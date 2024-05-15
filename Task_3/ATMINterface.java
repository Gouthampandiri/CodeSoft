package Task_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMINterface {
    private static JTextField inputField;
    private static JLabel infoLabel;
    private static int balance = 1000; // Initial balance

    public static void main(String[] args) {
        JFrame frame = new JFrame("ATM Interface");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,25,30));

        JLabel balanceLabel = new JLabel("Balance: " + balance);
        JLabel amountLabel = new JLabel("Enter amount:");
        inputField = new JTextField();
        inputField.setColumns(15);
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");
        infoLabel = new JLabel("Welcome to ATM!",10);

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(inputField.getText());
                if (balance >= amount) {
                    balance -= amount;
                    balanceLabel.setText("Balance: " + balance);
                    infoLabel.setText("Withdrawal ₹"+amount+" successful!");
                    infoLabel.setForeground(Color.BLACK);
                } else {
                    infoLabel.setText("Insufficient balance!  ₹"+ balance);
                    infoLabel.setForeground(Color.RED);
                }
                inputField.setText(""); // Clear the text field
            }
        });
        
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(inputField.getText());
                balance += amount;
                balanceLabel.setText("Balance: " + balance);
                infoLabel.setText("Deposit 0f ₹"+amount+" successful!");
                infoLabel.setForeground(Color.GREEN);
                inputField.setText(""); // Clear the text field
            }
        });
        
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoLabel.setText("Current balance: ₹ " + balance);
                infoLabel.setForeground(Color.BLACK);
            }
        });

        
        panel.add(amountLabel);
        panel.add(inputField);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(checkBalanceButton);
        panel.add(infoLabel);
        

        frame.getContentPane().add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.setVisible(true);
    }
}
