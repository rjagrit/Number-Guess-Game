import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame implements ActionListener {
    JLabel gameframe, l1, hrline, name, qmark;
    JTextField nametf;
    JButton ok, exit;

    Frame1() {
        setLayout(null);//so that it will not use its predefined layouts
        setTitle("Number Guessing Game");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NGGFrame.png"));
        Image i2 = i1.getImage().getScaledInstance(626, 471, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        gameframe = new JLabel(i3);
        gameframe.setBounds(0, 0, 626, 471);
        add(gameframe);

        l1 = new JLabel("NUMBER GUESSING GAME");
        l1.setBounds(105, 70, 700, 38);
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Raleway", Font.BOLD, 32));
        gameframe.add(l1);

        hrline = new JLabel("-----------------------------------------");
        hrline.setBounds(104, 85, 700, 38);
        hrline.setForeground(Color.DARK_GRAY);
        hrline.setFont(new Font("Raleway", Font.PLAIN, 32));
        gameframe.add(hrline);

        name = new JLabel("Enter Your Name");
        name.setBounds(85, 160, 700, 38);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Raleway", Font.PLAIN, 19));
        gameframe.add(name);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Qmark.png"));
        Image i5 = i4.getImage().getScaledInstance(235, 260, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);

        qmark = new JLabel(i6);
        qmark.setBounds(305, 130, 235, 260);
        gameframe.add(qmark);

        nametf = new JTextField();
        nametf.setBounds(85, 220, 190, 25);
        nametf.setFont(new Font("Arial", Font.BOLD, 14));
        add(nametf);

        ok = new JButton("PLAY");
        ok.setBounds(85, 280, 90, 30);
        ok.setForeground(Color.YELLOW);
        ok.setBackground(Color.BLACK);
        ok.setFont(new Font("Arial", Font.BOLD, 18));
        ok.setFocusPainted(false);
        ok.addActionListener(this);
        gameframe.add(ok);

        exit = new JButton("EXIT");
        exit.setBounds(180, 280, 90, 30);
        exit.setForeground(Color.RED);
        exit.setBackground(Color.BLACK);
        exit.setFont(new Font("Arial", Font.BOLD, 18));
        exit.setFocusPainted(false);
        exit.addActionListener(this);
        gameframe.add(exit);

        setSize(635, 500); //frame size
        setVisible(true); //make frame visible
        setLocation(350, 200); //frame location
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Frame1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == ok) {
                setVisible(false);
                String name = nametf.getText();
                new Frame2(name).setVisible(true);
            } else if (e.getSource() == exit) {
                System.exit(0);
            }
        } catch (Exception ae) {
            System.out.println(ae);
        }
    }
}
