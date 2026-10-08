import javax.swing.*;

public class BadLogin extends JFrame {

    public BadLogin() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Username:");
        JTextField t1 = new JTextField();

        JLabel l2 = new JLabel("Password:");
        JTextField t2 = new JTextField();

        JButton btn = new JButton("Login");

        l1.setBounds(30, 30, 80, 25);
        t1.setBounds(110, 30, 140, 25);

        l2.setBounds(30, 70, 80, 25);
        t2.setBounds(110, 70, 140, 25);

        btn.setBounds(100, 110, 100, 30);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(btn);

        btn.addActionListener(e -> {
            if (t1.getText().equals("admin")
                    && t2.getText().equals("admin")) {

                JOptionPane.showMessageDialog(
                    this,
                    "Login successful!"
                );

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Username or password is incorrect."
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new BadLogin();
    }
}