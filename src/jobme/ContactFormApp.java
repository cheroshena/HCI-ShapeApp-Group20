package jobme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactFormApp extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JTextArea messageArea;

    public ContactFormApp() {
        initComponents();
    }

    public void initComponents() {
        setTitle("Contact Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout manager
        setLayout(new BorderLayout());

        // Create the form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.white);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Add the form fields and labels
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(nameLabel, constraints);

        constraints.gridx = 1;
        nameField = new JTextField(20);
        formPanel.add(nameField, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(emailLabel, constraints);

        constraints.gridx = 1;
        emailField = new JTextField(20);
        formPanel.add(emailField, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        JLabel messageLabel = new JLabel("Message:");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(messageLabel, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        messageArea = new JTextArea(5, 20);
        messageArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        formPanel.add(scrollPane, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(59, 89, 182));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Process the form submission
                String name = nameField.getText();
                String email = emailField.getText();
                String message = messageArea.getText();

                // TODO: Implement form submission logic

                // Reset the form
                nameField.setText("");
                emailField.setText("");
                messageArea.setText("");

                JOptionPane.showMessageDialog(ContactFormApp.this, "Form submitted successfully!");
            }
        });
        formPanel.add(submitButton, constraints);

        // Create the title panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(59, 89, 182));
        JLabel titleLabel = new JLabel("Contact Us");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);

        // Add the panels to the frame
        add(titlePanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public static void main(String[] args) {

                new ContactFormApp();

    }
}
