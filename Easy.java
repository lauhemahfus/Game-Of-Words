import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Easy implements ActionListener {
    JFrame frame = new JFrame("Game Of Words");
    JButton b1,b2,b3,b4, reset,skip;
    boolean f1,f2,f3,f4 = false;
    int penalty =0;

    JLabel label = new JLabel();
    JTextField textfield = new JTextField();
    JTextField penaltytext = new JTextField();
    JTextField highscoretext = new JTextField();
    JTextField usernametext = new JTextField();

    char currWord;
    String x;
    String username;
    int highscore;

    String path_word4 = "E:/Project/data/word4.txt";
    String path_highscore4 = "E:/Project/data/highscore4.txt";
    ImageIcon image_quit= new ImageIcon(this.getClass().getResource("/img/btn_quit.png"));
    JButton btn_quit = new JButton(image_quit);
    Easy(String username){

        this.username =username;
        getHighScore();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/GOB.png"));
        frame.setIconImage(icon.getImage());


        frame.add(label);

        ImageIcon image = new ImageIcon(this.getClass().getResource("/img/game.png"));

        label.setIcon(image);
        label.setSize(1000,600);


        textfield.setEditable(false);
        textfield.setBackground(new Color(0xFBC42D));
        textfield.setBounds(445,200, 80, 80);
        label.add(textfield);
        textfield.setHorizontalAlignment(SwingConstants.CENTER);
        textfield.setHorizontalAlignment(SwingConstants.CENTER);
        textfield.setFont(new Font("Serif", Font.BOLD, 60));
        textfield.setForeground(Color.black);

        penaltytext.setEditable(false);
        penaltytext.setBackground(new Color(0xFBF8BE));
        penaltytext.setBounds(650,220, 150, 50);
        penaltytext.setHorizontalAlignment(SwingConstants.CENTER);
        penaltytext.setFont(new Font("SERIF", Font.BOLD, 25));
        penaltytext.setForeground(Color.black);
        label.add(penaltytext);

        usernametext.setEditable(false);
        usernametext.setBackground(new Color(0x0063B2FF));
        usernametext.setBounds(400,30, 170, 50);
        usernametext.setHorizontalAlignment(SwingConstants.CENTER);
        usernametext.setFont(new Font("SERIF", Font.BOLD, 25));
        usernametext.setForeground(Color.black);
        usernametext.setText(username);
        label.add(usernametext);

        highscoretext.setEditable(false);
        highscoretext.setBackground(new Color(0x234E70));
        highscoretext.setBounds(150,220, 180, 50);
        highscoretext.setHorizontalAlignment(SwingConstants.CENTER);
        highscoretext.setFont(new Font("SERIF", Font.BOLD, 25));
        highscoretext.setForeground(Color.white);
        highscoretext.setText("Highscore : " + highscore);
        label.add(highscoretext);



        b1 = new JButton("");
        b1.setBounds(300,320,70,70);
        b1.setBackground(new Color(0xFFFFFF));
        b1.addActionListener(this);
        label.add(b1);

        b2 = new JButton("");
        b2.setBounds(400,320,70,70);
        b2.setBackground(new Color(0xFFFFFF));
        b2.addActionListener(this);
        label.add(b2);

        b3 = new JButton("");
        b3.setBounds(500,320,70,70);
        b3.setBackground(new Color(0xFFFFFF));
        b3.addActionListener(this);
        label.add(b3);

        b4 = new JButton("");
        b4.setBounds(600,320,70,70);
        b4.setBackground(new Color(0xFFFFFF));
        b4.addActionListener(this);
        label.add(b4);

        b1.setFont(new Font("SERIF", Font.BOLD, 35));
        b2.setFont(new Font("SERIF", Font.BOLD, 35));
        b3.setFont(new Font("SERIF", Font.BOLD, 35));
        b4.setFont(new Font("SERIF", Font.BOLD, 35));

        reset = new JButton("Reset");
        reset.setBounds(350,420, 100, 45);
        reset.setBackground(new Color(0xfb9c99));
        reset.addActionListener(this);
        label.add(reset);
        reset.setForeground(Color.white);

        skip = new JButton("Skip");
        skip.setBounds(520,420, 100, 45);
        skip.setBackground(new Color(0x32AE2B));
        skip.addActionListener(this);
        label.add(skip);
        skip.setForeground(Color.WHITE);

        reset.setFont(new Font("SERIF", Font.BOLD, 25));
        skip.setFont(new Font("SERIF", Font.BOLD, 25));


        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        skip.setCursor(new Cursor(Cursor.HAND_CURSOR));

        label.add(btn_quit);
        btn_quit.setBounds(50,50,100,50);
        btn_quit.addActionListener(this);
        btn_quit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        generateWord();
        textfield.setText(x);

    }

    void getHighScore(){
        try{
            File highscore_file = new File(path_highscore4);
            Scanner high_sc = new Scanner(highscore_file);
            highscore  = high_sc.nextInt();
            high_sc.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    void generateWord(){
        currWord = 65;
        int rand =(int)Math.floor(Math.random()*(26));
        for(int i =0; i<rand;i++)currWord++;
        x = Character.toString(currWord);
        penalty++;
        penaltytext.setText("Penalty : " + penalty);

    }

    boolean check(){
        if(f1&& f2 && f3  && f4)
            return true;
        else {
            return false;
        }
    }

    void match() {
        String playerWord = "";
        playerWord+=b1.getText();
        playerWord+=b2.getText();
        playerWord+=b3.getText();
        playerWord+=b4.getText();
        playerWord = playerWord.toLowerCase();
        File file = new File(path_word4);
        try {
            Scanner s = new Scanner(file);
            while(s.hasNextLine()){
                String line = s.nextLine();
                if(line.equals(playerWord)){
                    if(penalty<highscore){
                        new HighScore(penalty, username, "easy");
                    }else{
                        new Score(penalty, username, "easy");
                    }
                    frame.dispose();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        f1 = false;
        f2 = false;
        f3 = false;
        f4 = false;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1){
            if(b1.getText() == ""){
                f1 = true;
                b1.setText(x);
                generateWord();
                if(check())
                    match();
            }else{
                JOptionPane.showMessageDialog(null, "This box is already filled","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == b2){
            if(b2.getText() == ""){
                f2 = true;
                b2.setText(x);
                generateWord();
                if(check())
                    match();
            }else{
                JOptionPane.showMessageDialog(null, "This box is already fill","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == b3){
            if(b3.getText() == ""){
                f3 = true;
                b3.setText(x);
                generateWord();
                if(check())
                    match();
            }else{
                JOptionPane.showMessageDialog(null, "This box is already filled","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == b4){
            if(b4.getText() == ""){
                f4 = true;
                b4.setText(x);
                generateWord();
                if(check())
                    match();
            }else{
                JOptionPane.showMessageDialog(null, "This box is already filled","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == reset){
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            f1 = false;
            f2 = false;
            f3 = false;
            f4 = false;
        }
        if(e.getSource() == skip){
            generateWord();
        }

        if(e.getSource()==btn_quit){
            frame.dispose();
            new Loser();
        }
        textfield.setText(x);
    }
}
