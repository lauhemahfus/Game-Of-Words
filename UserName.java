import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserName implements ActionListener{
    String username;
    JFrame frame = new JFrame("Game Of Words");
    JTextField name = new JTextField( 100);
    JTextField user_name = new JTextField( 200);
    JButton enter = new JButton("Enter");
    JLabel label = new JLabel();
    String level;
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    ImageIcon image_back = new ImageIcon(this.getClass().getResource("/img/btn_home.png"));
    JButton btn_home = new JButton(image_back);
    ButtonGroup gender = new ButtonGroup();
    UserName(String level){
        this.level = level;

        frame.setVisible(true);
        frame.setSize(1000,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(label);

        ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/GOB.png"));
        frame.setIconImage(icon.getImage());
        ImageIcon image2 = new ImageIcon(this.getClass().getResource("/img/name.png"));

        label.setIcon(image2);
        label.setSize(1000,600);

        name.setBackground(new Color(0xfff8f9));
        name.setBounds(400,250, 200, 40);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("SERIF", Font.BOLD, 20));
        name.setForeground(Color.black);
        label.add(name);

        user_name.setBackground(new Color(0xF96167));
        user_name.setBounds(400,200, 200, 40);
        user_name.setHorizontalAlignment(SwingConstants.CENTER);
        user_name.setFont(new Font("SERIF", Font.BOLD, 25));
        user_name.setForeground(Color.white);
        user_name.setText("User Name");
        user_name.setEditable(false);
        label.add(user_name);

        enter.setBounds(450,340,100,35);
        enter.addActionListener((java.awt.event.ActionListener) this);
        enter.setFont(new Font("SERIF", Font.BOLD, 24));
        enter.setBackground(new Color(0xfffe00));
        enter.setForeground(Color.black);
        label.add(enter);
        label.add(btn_home);
        btn_home.setBounds(50,50,50,50);
        btn_home.addActionListener(this);
        btn_home.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gender.add(male);
        gender.add(female);
        male.setBounds(400, 350, 100, 60);
        female.setBounds(500, 350, 100, 60);

    }
    void getUsername(){
        username = name.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==enter){
            getUsername();
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
