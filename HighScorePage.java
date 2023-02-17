import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HighScorePage implements ActionListener {
    JFrame frame = new JFrame("Game Of Words");
    JLabel label = new JLabel();
    JTextField table = new JTextField();
    JTextField easy = new JTextField();
    JTextField medium = new JTextField();
    JTextField hard = new JTextField();
    JTextField name1 = new JTextField();
    JTextField name2 = new JTextField();
    JTextField name3 = new JTextField();
    JTextField point1 = new JTextField();
    JTextField point2 = new JTextField();
    JTextField point3 = new JTextField();

    String path_highscore4 = "E:/Project/data/highscore4.txt";
    String path_highscore5 = "E:/Project/data/highscore5.txt";
    String path_highscore7 = "E:/Project/data/highscore7.txt";

    ImageIcon image_back = new ImageIcon(this.getClass().getResource("/img/btn_home.png"));
    JButton button = new JButton(image_back);


    HighScorePage(){


        frame.setVisible(true);
        frame.setSize(1000,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(label);
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/GOB.png"));
        frame.setIconImage(icon.getImage());

        ImageIcon image1 = new ImageIcon(this.getClass().getResource("/img/scoreboard.png"));

        label.setIcon(image1);
        label.setSize(1000,600);
        label.add(button);

        button.setBounds(50,50,50,50);
        button.addActionListener(this);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        table.setEditable(false);
        table.setBackground(new Color(0x6FC7E1));
        table.setBounds(150,230,510, 50);
        //table.setHorizontalAlignment(SwingConstants.CENTER);
        table.setFont(new Font("SERIF", Font.BOLD, 25));
        table.setForeground(Color.black);
     
        label.add(table);



        easy.setEditable(false);
        easy.setBackground(new Color(0xCEE6F2));
        easy.setBounds(165,300,100, 50);
        easy.setHorizontalAlignment(SwingConstants.CENTER);
        easy.setFont(new Font("SERIF", Font.BOLD, 23));
        easy.setForeground(Color.black);
        label.add(easy);

        medium.setEditable(false);
        medium.setBackground(new Color(0xCEE6F2));
        medium.setBounds(165,375,100, 50);
        medium.setHorizontalAlignment(SwingConstants.CENTER);
        medium.setFont(new Font("SERIF", Font.BOLD, 23));
        medium.setForeground(Color.black);
        label.add(medium);

        hard.setEditable(false);
        hard.setBackground(new Color(0xCEE6F2));
        hard.setBounds(165,450,100, 50);
        hard.setHorizontalAlignment(SwingConstants.CENTER);
        hard.setFont(new Font("SERIF", Font.BOLD, 23));
        hard.setForeground(Color.black);
        label.add(hard);

        
        name1.setEditable(false);
        name1.setBackground(new Color(0xEECCD3));
        name1.setBounds(300,300,205, 50);
        name1.setHorizontalAlignment(SwingConstants.CENTER);
        name1.setFont(new Font("SERIF", Font.BOLD, 23));
        name1.setForeground(Color.black);
        label.add(name1);

        name2.setEditable(false);
        name2.setBackground(new Color(0xEECCD3));
        name2.setBounds(300,375,205, 50);
        name2.setHorizontalAlignment(SwingConstants.CENTER);
        name2.setFont(new Font("SERIF", Font.BOLD, 23));
        name2.setForeground(Color.black);
        label.add(name2);

        name3.setEditable(false);
        name3.setBackground(new Color(0xEECCD3));
        name3.setBounds(300,450,205, 50);
        name3.setHorizontalAlignment(SwingConstants.CENTER);
        name3.setFont(new Font("SERIF", Font.BOLD, 23));
        name3.setForeground(Color.black);
        label.add(name3);


        point1.setEditable(false);
        point1.setBackground(new Color(0xE9B796));
        point1.setBounds(540,300,100, 50);
        point1.setHorizontalAlignment(SwingConstants.CENTER);
        point1.setFont(new Font("SERIF", Font.BOLD, 23));
        point1.setForeground(Color.black);
        label.add(point1);

        point2.setEditable(false);
        point2.setBackground(new Color(0xE9B796));
        point2.setBounds(540,375,100, 50);
        point2.setHorizontalAlignment(SwingConstants.CENTER);
        point2.setFont(new Font("SERIF", Font.BOLD, 23));
        point2.setForeground(Color.black);
        label.add(point2);

        point3.setEditable(false);
        point3.setBackground(new Color(0xE9B796));
        point3.setBounds(540,450,100, 50);
        point3.setHorizontalAlignment(SwingConstants.CENTER);
        point3.setFont(new Font("SERIF", Font.BOLD, 23));
        point3.setForeground(Color.black);
        label.add(point3);



        setHighscore();

    }
    void setHighscore(){
        table.setText("      Type                     Name                   Penalty");
        try{
            File f1 = new File(path_highscore4);
            Scanner s1 = new Scanner(f1);
            String sc1 = s1.next();
            String name_1 = s1.next();  
            easy.setText("Easy");
            name1.setText(name_1);
            point1.setText(sc1);
            s1.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try{
            File f2 = new File(path_highscore5);
            Scanner s2 = new Scanner(f2);
            String sc2 = s2.next();
            String name_2 = s2.next();
            medium.setText("Medium");
            name2.setText(name_2);
            point2.setText(sc2);
            s2.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try{
            File f3 = new File(path_highscore7);
            Scanner s3 = new Scanner(f3);
            String sc3 = s3.next();
            String name_3 = s3.next();
            hard.setText( "Hard");
            name3.setText(name_3);
            point3.setText(sc3);
            s3.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            frame.dispose();
            new Menu();
        }

    }
}
