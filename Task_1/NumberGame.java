package Task_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGame {
    private static JTextField guessField;
    private static JLabel messageLabel;
    private static int targetNumber;
    private static int attempts;
    private static int score;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Guessing Game");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JLabel guessLabel = new JLabel("Enter your guess:");
        guessField = new JTextField();
        JButton guessButton = new JButton("Guess");
        messageLabel = new JLabel("");
        JButton playAgainButton = new JButton("Play Again");

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeGuess();
            }
        });

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        panel.add(messageLabel);
        panel.add(guessLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(playAgainButton);

        frame.getContentPane().add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        startGame();
    }

    public static void startGame() {
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
        attempts = 0;
        messageLabel.setText("I'm thinking of a number between 1 and 100.");
        messageLabel.setForeground(Color.BLACK);
    }

    public static void makeGuess() {
        if (attempts >= MAX_ATTEMPTS) {
            messageLabel.setText("You've reached the maximum number of attempts. Please start a new game.");
            messageLabel.setForeground(Color.RED);
            return;
        }

        int userGuess = Integer.parseInt(guessField.getText());
        attempts++;

        if (userGuess == targetNumber) {
            score++;
            messageLabel.setText("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts. Your total score is: " + score);
            messageLabel.setForeground(Color.GREEN);
        } else if (userGuess < targetNumber) {
            messageLabel.setText("Too low! Try again.");
            messageLabel.setForeground(Color.BLACK);
        } else {
            messageLabel.setText("Too high! Try again.");
            messageLabel.setForeground(Color.BLACK);
        }

        if (attempts == MAX_ATTEMPTS && userGuess != targetNumber) {
            messageLabel.setText("Game over! The correct number was " + targetNumber + ". Please start a new game.");
            messageLabel.setForeground(Color.RED);
        }
    }
}
