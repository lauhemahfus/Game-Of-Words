import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    JFrame menu = new JFrame("Game Of Words");
    JLabel label = new JLabel();
    JButton playgame = new JButton("Play");
    JButton btn_highscore = new JButton("High Score");
    JButton btn_about = new JButton("About");
    JButton btn_exit = new JButton("Exit");

    Menu(){

        menu.setVisible(true);
        menu.setSize(1000,600);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.add(label);

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/GOB.png"));
        menu.setIconImage(icon.getImage());

        ImageIcon image1 = new ImageIcon(this.getClass().getResource("./img/menu.png"));
       
        label.setIcon(image1);
        label.setSize(1000,600);
        label.add(playgame);
        label.add(btn_highscore);
        label.add(btn_about);
        label.add(btn_exit);

        playgame.setBounds(450,250,130,35);
        playgame.addActionListener(this);

        btn_highscore.setBounds(450,300,130,35);
        btn_highscore.addActionListener(this);
        
        btn_about.setBounds(450,350,130,35);
        btn_about.addActionListener(this);

        btn_exit.setBounds(450,400,130,35);
        btn_exit.addActionListener(this);

    
        playgame.setFont(new Font("SERIF", Font.BOLD, 20));
        btn_highscore.setFont(new Font("SERIF", Font.BOLD, 20));
        btn_about.setFont(new Font("SERIF", Font.BOLD, 20));
        btn_exit.setFont(new Font("SERIF", Font.BOLD, 20));

        playgame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_highscore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_about.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==playgame){
            menu.dispose();
            new Level();
        }
        if(e.getSource() == btn_highscore){
            menu.dispose();
            new HighScorePage();
        }
        if(e.getSource()==btn_about){
            menu.dispose();
            new About();
        }
        if(e.getSource()==btn_exit){
            System.exit(0);
        }
    }

}