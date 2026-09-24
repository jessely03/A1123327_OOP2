import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class A1123327_Exercise1 {

    static int count = 0;
    static int total = 0;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Dice Simulator");
        frame.setSize(400, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel info = new JLabel("Rolled 0 times, Total 0, Average 0.00");
        info.setHorizontalAlignment(JLabel.CENTER);

        JLabel dice = new JLabel("0");
        dice.setFont(new Font("Arial", Font.PLAIN, 60));
        dice.setHorizontalAlignment(JLabel.CENTER);

        JButton button = new JButton("Roll Dice");

        button.addActionListener(e -> {

            Random random = new Random();
            int number = random.nextInt(6) + 1;

            count++;
            total += number;

            double average = (double) total / count;

            dice.setText("" + number);

            if (number == 6) {
                dice.setForeground(Color.GREEN);
            } else if (number == 1) {
                dice.setForeground(Color.RED);
            } else {
                dice.setForeground(Color.BLACK);
            }

            info.setText("Rolled " + count + " times, Total "
                    + total + ", Average " + String.format("%.2f", average));
        });

        frame.setLayout(new BorderLayout());

        frame.add(info, BorderLayout.NORTH);
        frame.add(dice, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}