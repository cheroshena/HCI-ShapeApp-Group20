package jobme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import jobme.ContactFormApp;

public class MainApp extends JFrame {

    public MainApp() {
        initComponents();
    }

    public void initComponents() {
        setTitle("JobME tech Solutions");
        setSize(new Dimension(400, 720));
        setLayout(null);
        setIconImage(new ImageIcon("C:\\Users\\DVM\\IdeaProjects\\jobMEProject\\icons\\ppic.jpg").getImage());

        GridLayout gridLayout = new GridLayout(1, 1);
        setLayout(gridLayout);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adding Components to the JFrame
        add(mainPanel());
    }

    public JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(50, 100, 200));

        //Adding Components Into Main Panel
        panel.add(appBar());
        panel.add(sideBar(new String[]{"DASHBOARD", "SERVICES", "CONTACT"}));
        return panel;
    }

    public JPanel appBar() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(222, 222, 222));
        panel.setBounds(0, 0, 1200, 45);

        JLabel title = new JLabel("Web Manager");
        JLabel appLogo = new JLabel(
                Defaults.getResizeImage("C:\\Users\\DVM\\IdeaProjects\\jobMEProject\\icons\\ppic.jpg",
                        40,
                        25
                )
        );

        appLogo.setBounds(0, 0, 45, 45);
        title.setBounds(50, 0, 1200, 45);

        //Adding Elements Into App Bar
        panel.add(appLogo);
        panel.add(title);

        return panel;
    }

    public JPanel sideBar(String[] values) {
        JPanel panel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);

        panel.setLayout(flowLayout);
        panel.setBounds(0, 50, 300, 700);
        panel.setBackground(new Color(50, 100, 200));

        for (int i = 0; i < values.length; i++) {
            JPanel panel1 = new JPanel(new GridLayout(1, 1));
            panel1.setPreferredSize(new Dimension(290, 45));

            JLabel value = new JLabel(" " + values[i]);
            panel1.add(value);

            panel1.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ContactFormApp contactFormApp =  new ContactFormApp();
                    contactFormApp.setVisible(true);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    panel1.setBackground(new Color(255, 135, 0));
                    value.setForeground(new Color(255, 255, 255));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    panel1.setBackground(new Color(222, 222, 222));
                    value.setForeground(new Color(0, 0, 0));
                }
            });

            panel.add(panel1);
        }

        return panel;
    }

    public static void main(String[] args) {
        new MainApp().setVisible(true);
    }
}