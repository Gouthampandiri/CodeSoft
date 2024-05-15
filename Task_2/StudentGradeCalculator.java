package Task_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentGradeCalculator {
    private static ArrayList<JTextField> markFields = new ArrayList<>();
    private static JPanel panel;
    private static JTextField NumberField;
    private static JLabel resultLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Grade Calculator");
        panel = new JPanel();
        JLabel NumberLabel = new JLabel("Enter Number of Subjects:");
        NumberField = new JTextField();
        JLabel inputTextLabel = new JLabel("Enter marks of Subjects:");
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        NumberField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterSubjects();
            }
        });

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        resultLabel = new JLabel("");

        panel.add(NumberLabel);
        panel.add(NumberField);
        panel.add(calculateButton);
        panel.add(resultLabel);
        panel.add(inputTextLabel);
        

        frame.getContentPane().add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    

    public static void enterSubjects() {
        int numSubjects = Integer.parseInt(NumberField.getText());

        markFields.clear();
        for (int i = 0; i < numSubjects; i++) {
            JTextField markField = new JTextField();
            markField.setMaximumSize(new Dimension(Integer.MAX_VALUE, markField.getPreferredSize().height));
            markField.setColumns(10);
            markFields.add(markField);
            panel.add(markField);
            
        }
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        panel.revalidate();
        panel.repaint();
    }

    public static void calculateGrade() {
        int totalMarks = 0;
        for (JTextField markField : markFields) {
            totalMarks += Integer.parseInt(markField.getText());
        }

        double averageMarks = (double) totalMarks / markFields.size();
        String grade;

        if (averageMarks >= 90) {
            grade = "A+";
            resultLabel.setForeground(Color.GREEN);
        } else if (averageMarks >= 80) {
            grade = "A";
            resultLabel.setForeground(Color.BLACK);
        } else if (averageMarks >= 70) {
            grade = "B";
            resultLabel.setForeground(Color.BLACK);
        } else if (averageMarks >= 60) {
            grade = "C";
            resultLabel.setForeground(Color.BLACK);
        } else if (averageMarks >= 50) {
            grade = "D";
            resultLabel.setForeground(Color.BLACK);
        } else {
            grade = "F";
            resultLabel.setForeground(Color.RED);
        }

        resultLabel.setText("<html>Total Marks: " + totalMarks + "<br/>" +
                            "Average Percentage: " + averageMarks + "%" + "<br/>" +
                            "Grade: " + grade + "</html>");
    }
}
