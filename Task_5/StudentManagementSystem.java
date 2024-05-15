package Task_5;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Student {
    String name;
    int rollNumber;
    String grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    private static JTextField nameField, rollNumberField, gradeField, searchField;
    
    private static ArrayList<Student> students = new ArrayList<>();
    private static JTable table;
    private static DefaultTableModel model;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberField = new JTextField();
        JLabel gradeLabel = new JLabel("Grade:");
        gradeField = new JTextField();
        JButton addButton = new JButton("Add Student");
        JButton removeButton = new JButton("Remove Student");
        JButton searchButton = new JButton("Search Student");
        searchField = new JTextField();
        

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int rollNumber = Integer.parseInt(rollNumberField.getText());
                String grade = gradeField.getText();
                students.add(new Student(name, rollNumber, grade));
                displayStudents();
                // Clear the text fields
                nameField.setText("");
                rollNumberField.setText("");
                gradeField.setText("");
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rollNumber = Integer.parseInt(rollNumberField.getText());
                students.removeIf(student -> student.rollNumber == rollNumber);
                displayStudents();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rollNumber = Integer.parseInt(searchField.getText());
                for (Student student : students) {
                    if (student.rollNumber == rollNumber) {
                        // Show the student details in a pop-up dialog
                        JOptionPane.showMessageDialog(frame, student.toString(), "Student Details", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
            }
        });
        

        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Roll Number");
        model.addColumn("Grade");
        table = new JTable(model);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(rollNumberLabel);
        panel.add(rollNumberField);
        panel.add(gradeLabel);
        panel.add(gradeField);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(searchField);
        panel.add(searchButton);
        panel.add(new JScrollPane(table));

        frame.getContentPane().add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void displayStudents() {
        model.setRowCount(0);
        for (Student student : students) {
            model.addRow(new Object[]{student.name, student.rollNumber, student.grade});
        }
    }
}
