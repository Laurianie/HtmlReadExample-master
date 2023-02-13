import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class HtmlRead implements ActionListener {
    private JFrame mainFrame;
    private JTextArea inputURL;
    private JTextArea search;
    private JTextArea ta;
    private JLabel URL;
    private JLabel SEARCH;
    private JButton start;
    private JPanel panel;

    private int WIDTH = 1400;
    private int HEIGHT = 1200;



    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }


    private void prepareGUI() {
        mainFrame = new JFrame("HTML Reader Project");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());
        panel = new JPanel();
        panel.setLayout(new GridLayout(2,3));
        mainFrame.add(panel,BorderLayout.SOUTH);


        inputURL = new JTextArea();
        search = new JTextArea();
        ta = new JTextArea("RESULTS: " + "\n");
        URL = new JLabel ("INPUT URL: ");
        URL.setSize(2,2);
        SEARCH = new JLabel ("SEARCH: ");
        SEARCH.setSize(2,2);
        start = new JButton ("START ");
        start.setActionCommand("START");
        start.addActionListener(new ButtonClickListener());


        panel.add(SEARCH);
        panel.add(search);
        panel.add(start);
        panel.add(URL);
        panel.add(inputURL);
        mainFrame.add(ta,BorderLayout.CENTER);





        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
    }

    public HtmlRead() {
        prepareGUI();
        mainFrame.setVisible(true);
    }

    private void HTMLRead(){
        try {
            System.out.println();
            URL url = new URL (inputURL.getText());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            while ( (line = reader.readLine()) != null ){
                if (line.contains("href=\"") && line.contains("https") && line.contains(search.getText()) ) {
                    int start = line.indexOf("href=\"") + 6;
                    int end = line.indexOf("\"",start);
                String Line = line.substring(start,end);
                System.out.println(Line);
                ta.setText(ta.getText() + "\"" + Line + "\n");
            }}
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
        if (command.equals("START")){
            start.setText("START clicked ");
            HTMLRead();
        }
        }
    }
}
