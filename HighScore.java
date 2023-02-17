import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;

public class HighScore implements ActionListener {
    int score;
    String username, level;
    JFrame frame = new JFrame("Game Of Words");
    JLabel label = new JLabel();
    JTextField textfield = new JTextField();
    JButton playagain = new JButton("Play Again");

    ImageIcon image_back = new ImageIcon(this.getClass().getResource("/img/btn_home.png"));
    JButton btn_home = new JButton(image_back);
    String path_highscore4 = "E:/Project/data/highscore4.txt";
    String path_highscore5 = "E:/Project/data/highscore5.txt";
    String path_highscore7 = "E:/Project/data/highscore7.txt";
    HighScore(int score, String username, String level){
        this.username = username;
        this.level = level;
        this.score = score;
        write();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/GOB.png"));
        frame.setIconImage(icon.getImage());


        frame.add(label);

        ImageIcon image = new ImageIcon(this.getClass().getResource("/img/highscore.png"));

        label.setIcon(image);
        label.setSize(1000,600);

        textfield.setEditable(false);
        textfield.setBounds(320,370,200,140);
        label.add(textfield);
        textfield.setHorizontalAlignment(SwingConstants.CENTER);
        textfield.setHorizontalAlignment(SwingConstants.CENTER);
        textfield.setFont(new Font("Serif", Font.BOLD, 80));
        textfield.setForeground(Color.black);
        textfield.setText(Integer.toString(score));
        textfield.setOpaque(false); 


        playagain.setBounds(720,450, 170, 45);
        playagain.setBackground(new Color(0xfb9c99));
        playagain.addActionListener(this);
        label.add(playagain);
        playagain.setForeground(Color.black);

        playagain.setFont(new Font("SERIF", Font.BOLD, 25));
        playagain.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.add(btn_home);
        btn_home.setBounds(50,50,50,50);
        btn_home.addActionListener(this);
        btn_home.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    void write(){
        File file = null;
        try {
            if(level.equals("easy"))
                file = new File(path_highscore4);
            else if(level.equals("medium"))
                file = new File(path_highscore5);
            else if(level.equals("hard"))
                file = new File(path_highscore7);
            PrintWriter out = new PrintWriter(file);
            out.println(score);
            out.println(username);
            out.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == playagain){
            frame.dispose();
            if(level.equals("easy"))
                new Easy(username);
            else if(level.equals("medium"))
                new Medium(username);
            else if(level.equals("hard"))
                new Hard(username);

        }
        if(e.getSource() == btn_home){
            frame.dispose();
            new Menu();

        }

    }
}
