import javax.swing.*;
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
    private JButton buttonSTART;

    private int WIDTH = 200;
    private int HEIGHT = 200;





    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }


    private void prepareGUI() {
        mainFrame = new JFrame("Layout Practice");
        mainFrame.setSize(WIDTH, HEIGHT);

        inputURL = new JTextArea();
        inputURL.setBounds(50, 5, WIDTH-100, HEIGHT-50);

        search = new JTextArea();
        search.setBounds(80, 15, WIDTH-100, HEIGHT-50);

        ta = new JTextArea();
        ta.setBounds(500, 50, WIDTH-100, HEIGHT-50);

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

}
