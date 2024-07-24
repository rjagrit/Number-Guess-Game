import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.border.LineBorder;


public class Frame2 extends JFrame implements ActionListener
{

    private int score;
    JLabel gameframe,l1,wcome,nm,l2,l3,qmark;
    JTextField usernum;
    JButton check,playagain,exit;
    JButton r1,r2,r3,r4,r5;
    Frame2(String name){
        setLayout(null);//so that it will not use its predefined layouts
        setTitle("Number Guessing Game");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NGGFrame.png"));
        Image i2 = i1.getImage().getScaledInstance(626, 471, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        gameframe = new JLabel(i3);
        gameframe.setBounds(0, 0, 626, 471);
        add(gameframe);

        wcome= new JLabel("Welcome");
        wcome.setBounds(80,70,100,30);
        wcome.setFont(new Font("Times New Roman",Font.PLAIN,25));
        gameframe.add(wcome);
        nm= new JLabel();
        nm.setBounds(177,70,100,30);
        nm.setFont(new Font("Arial",Font.BOLD,25));
        nm.setText(name);
        gameframe.add(nm);

        l1 = new JLabel("Let's Start the Game");
        l1.setBounds( 80, 110, 700, 38);
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Abadi", Font.BOLD, 20));
        gameframe.add(l1);


        l3 = new JLabel("(Enter number between 1 to 100)");
        l3.setBounds(80, 160, 190, 40);
        l3.setForeground(Color.RED);
        l3.setFont(new Font("Arial", Font.BOLD, 12));
        gameframe.add(l3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Qmark.png"));
        Image i5 = i4.getImage().getScaledInstance(235, 280, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);

        qmark = new JLabel(i6);
        qmark.setBounds(305, 113, 230, 250);
        gameframe.add(qmark);

        check = new JButton("Click to Start");
        check.setBackground(Color.GREEN);
        check.setForeground(Color.BLACK);
        check.setBounds(80, 190, 200, 40);
        check.setFont(new Font("Arial", Font.BOLD, 20));
        check.addActionListener(this);
        gameframe.add(check);

        playagain = new JButton("Play Again");
        playagain.setBackground(Color.CYAN);
        playagain.setForeground(Color.BLACK);
        playagain.setBounds(80, 240, 200, 40);
        playagain.setFont(new Font("Arial", Font.BOLD, 20));
        playagain.addActionListener(this);
        gameframe.add(playagain);

        exit = new JButton("EXIT");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.BLACK);
        exit.setBounds(80, 290, 200, 40);
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        exit.addActionListener(this);
        gameframe.add(exit);

        setSize(635, 500); //frame size
        setVisible(true); //make frame visible
        setLocation(350, 200); //frame location
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Frame2("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            Random random = new Random();
            boolean hasWon = false;
            int numberToGuess = random.nextInt(100) + 1;
            int num;
            int numtries =0;
            try {
                int rounds = Integer.parseInt(JOptionPane.showInputDialog(null,"How many rounds You want to Play?"));
                while(numtries<rounds){
                    String input = JOptionPane.showInputDialog(null, "Guess a number between 1 and 100");
                    if (input == null) { // Check if user pressed Cancel
                        JOptionPane.showMessageDialog(null, "Game cancelled.");
                        return;
                    }
                    int guess;
                    try {
                        guess = Integer.parseInt(input);
                    } catch (NumberFormatException ue) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                        continue;
                    }

                    numtries++;
                    if (guess == numberToGuess) {
                        score +=10;
                        JOptionPane.showMessageDialog(null, "User wins! Your score is: " + score);
                        continue;
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong guess. Try again.");
                    }
                }
                if(numtries == rounds){
                    JOptionPane.showMessageDialog(null,"Your attempts are finished.\nThe Number is "+numberToGuess+"\nYour Score is: "+score);
                }
            }
            catch (NumberFormatException ex) {
                // Handle the case where the input is not a valid integer
                JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource()==playagain){
            setVisible(false);
            new Frame1().setVisible(true);
        }
        else if(e.getSource()==exit){
            System.exit(0);
        }

    }
}
