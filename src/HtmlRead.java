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
    private JButton start;

    private int WIDTH = 800;
    private int HEIGHT = 800;





    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }


    private void prepareGUI() {
        mainFrame = new JFrame("HTML Reader Project");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(4,1));

        inputURL = new JTextArea("INPUT URL: ");
        search = new JTextArea("SEARCH: ");
        ta = new JTextArea("RESULTS:");
        start = new JButton ("START !");


        mainFrame.add(inputURL);
        mainFrame.add(search);
        mainFrame.add(ta);
        mainFrame.add(start);


        start.setActionCommand("START");
        start.addActionListener(new ButtonClickListener());


        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
    }

    public HtmlRead() {
        prepareGUI();
        try {
            System.out.println();
            System.out.print("hello");
            URL url = new URL("https://www.milton.edu/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            while ( (line = reader.readLine()) != null ) {
                if (line.contains("href"))
                System.out.println(line);
            }
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
        }
    }
}
