import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class About implements ActionListener {

    JFrame about = new JFrame("Game Of Words");
    JLabel label = new JLabel();
    ImageIcon image_back = new ImageIcon(this.getClass().getResource("/img/btn_home.png"));
    JButton btn_home = new JButton(image_back);

    About(){
        about.setVisible(true);
        about.setSize(1000,600);
        about.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        about.setResizable(false);
        about.add(label);

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/GOB.png"));
        about.setIconImage(icon.getImage());

        ImageIcon image1 = new ImageIcon(this.getClass().getResource("/img/about.png"));
       
        label.setIcon(image1);
        label.setSize(1000,600);
        label.add(btn_home);

        btn_home.setBounds(50,50,50,50);
        btn_home.addActionListener(this);
        btn_home.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_home){
            about.dispose();
            new Menu();
        }
    }
}
