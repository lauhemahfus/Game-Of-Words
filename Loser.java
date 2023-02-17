import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loser implements ActionListener {
    JFrame frame = new JFrame("Game Of Word");
    JLabel label = new JLabel();
    ImageIcon image_back = new ImageIcon(this.getClass().getResource("/img/btn_home.png"));
    JButton btn_home = new JButton(image_back);
    ImageIcon img = new ImageIcon(this.getClass().getResource("/img/btn_exit.png"));
    JButton btn_exit = new JButton(img);
    Loser(){


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/GOB.png"));
        frame.setIconImage(icon.getImage());


        frame.add(label);

        ImageIcon image = new ImageIcon(this.getClass().getResource("/img/loser.png"));

        label.setIcon(image);
        label.setSize(1000,600);

        label.add(btn_home);
        btn_home.setBounds(50,50,50,50);
        btn_home.addActionListener(this);
        btn_home.setCursor(new Cursor(Cursor.HAND_CURSOR));

        label.add(btn_exit);
        btn_exit.setBounds(420,420,100,50);
        btn_exit.addActionListener(this);
        btn_exit.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_home){
            frame.dispose();
            new Menu();
        }
        if(e.getSource() == btn_exit){
            System.exit(0);
        }
    }
}
