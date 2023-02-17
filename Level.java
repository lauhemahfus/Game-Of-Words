import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level implements ActionListener {

    JFrame level = new JFrame("Game Of Words");
    JLabel label = new JLabel();
    JButton easy = new JButton("Easy");
    JButton medium = new JButton("Medium");
    JButton hard = new JButton("Hard");
    ImageIcon image_back = new ImageIcon(this.getClass().getResource("/img/btn_home.png"));
    JButton btn_home = new JButton(image_back);


    Level(){

        level.setVisible(true);
        level.setSize(1000,600);
        level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level.setResizable(false);
        level.add(label);

        ImageIcon image1 = new ImageIcon(this.getClass().getResource("/img/level.jpeg"));

        label.setIcon(image1);
        label.setSize(1000,600);
        label.add(easy);
        label.add(medium);
        label.add(hard);

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/GOB.png"));
        level.setIconImage(icon.getImage());


        easy.setBounds(450,250,130,35);
        easy.addActionListener(this);

        medium.setBounds(450,300,130,35);
        medium.addActionListener(this);

        hard.setBounds(450,350,130,35);
        hard.addActionListener(this);

        easy.setFont(new Font("SERIF", Font.BOLD, 20));
        medium.setFont(new Font("SERIF", Font.BOLD, 20));
        hard.setFont(new Font("SERIF", Font.BOLD, 20));


        btn_home.setBounds(50,50,50,50);
        btn_home.addActionListener(this);
        btn_home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.add(btn_home);
        easy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        medium.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hard.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==easy){
            level.dispose();
            new UserName("easy");
        }
        if(e.getSource() == medium){
            level.dispose();
            new UserName("medium");
        }
        if(e.getSource()==hard){
            level.dispose();
            new UserName("hard");
        }
        if(e.getSource() == btn_home){
            level.dispose();
            new Menu();

        }

    }

}