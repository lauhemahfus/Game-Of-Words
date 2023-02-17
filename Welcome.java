import javax.swing.*;
import java.awt.*;

public class Welcome  {
    JFrame welcome = new JFrame("Game Of Words");
    JLabel label = new JLabel();
    JTextField full = new JTextField();
    JButton load = new JButton();

    public Welcome() {

        welcome.setVisible(true);
        welcome.setSize(1000,600);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setResizable(false);
        welcome.add(label);
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/GOB.png"));
        welcome.setIconImage(icon.getImage());

        ImageIcon image = new ImageIcon(this.getClass().getResource("/img/homepage.png"));
        
        label.setIcon(image);
        label.setSize(1000,600);
        label.add(load);

        full.setEditable(false);
        full.setBackground(Color.GRAY);
        full.setBounds(97,478, 797, 19);
        label.add(full);
        load.setBackground(new Color(0x00FFFF));

        int w=0;

        for( int i=0 ; i<100;i++){
            load.setBounds(100,480,w,15);
            w+=8;
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
               System.out.println(e);
            }
        }
        new Menu();
        welcome.dispose();

    }
}
