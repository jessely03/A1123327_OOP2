import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class A1123327_Exercise2 extends JFrame {

    private JComboBox<String> typeCombo;
    private JComboBox<String> sourceUnitCombo;
    private JComboBox<String> targetUnitCombo;

    private JTextField sourceField;
    private JTextField resultField;

    private JButton convertButton;

    // Unit lists
    private String[] lengthUnits = {
        "Meter", "Centimeter", "Inch", "Foot"
    };

    private String[] weightUnits = {
        "Kilogram", "Gram", "Pound", "Ounce"
    };

    private String[] temperatureUnits = {
        "Celsius", "Fahrenheit", "Kelvin"
    };

    // Constructor
    public A1123327_Exercise2() {

        // Window settings
        setTitle("Unit Converter");
        setSize(480, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // =========================
        // NORTH
        // =========================

        typeCombo = new JComboBox<>(
            new String[]{"Length", "Weight", "Temperature"}
        );

        JPanel northPanel = new JPanel();
        northPanel.add(typeCombo);

        add(northPanel, BorderLayout.NORTH);

        // =========================
        // CENTER
        // =========================

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2, 10, 10));

        sourceField = new JTextField();
        resultField = new JTextField();

        resultField.setEditable(false);

        sourceUnitCombo = new JComboBox<>(lengthUnits);
        targetUnitCombo = new JComboBox<>(lengthUnits);

        centerPanel.add(sourceField);
        centerPanel.add(sourceUnitCombo);

        centerPanel.add(resultField);
        centerPanel.add(targetUnitCombo);

        add(centerPanel, BorderLayout.CENTER);

        // =========================
        // SOUTH
        // =========================

        convertButton = new JButton("Convert");

        JPanel southPanel = new JPanel();
        southPanel.add(convertButton);

        add(southPanel, BorderLayout.SOUTH);

        // =========================
        // Events
        // =========================

        typeCombo.addActionListener(e -> updateUnits());

        convertButton.addActionListener(e -> convert());

        // Center the window
        setLocationRelativeTo(null);

        setVisible(true);
    }

    // Change unit options
    private void updateUnits() {

        String type = (String) typeCombo.getSelectedItem();

        String[] units;

        if (type.equals("Length")) {
            units = lengthUnits;

        } else if (type.equals("Weight")) {
            units = weightUnits;

        } else {
            units = temperatureUnits;
        }

        sourceUnitCombo.setModel(
            new DefaultComboBoxModel<>(units)
        );

        targetUnitCombo.setModel(
            new DefaultComboBoxModel<>(units)
        );
    }

    // Perform conversion
    private void convert() {

        try {

            double value =
                Double.parseDouble(sourceField.getText());

            String type =
                (String) typeCombo.getSelectedItem();

            String sourceUnit =
                (String) sourceUnitCombo.getSelectedItem();

            String targetUnit =
                (String) targetUnitCombo.getSelectedItem();

            double result = 0;

            if (type.equals("Length")) {

                result = convertLength(
                    value,
                    sourceUnit,
                    targetUnit
                );

            } else if (type.equals("Weight")) {

                result = convertWeight(
                    value,
                    sourceUnit,
                    targetUnit
                );

            } else if (type.equals("Temperature")) {

                result = convertTemperature(
                    value,
                    sourceUnit,
                    targetUnit
                );
            }

            resultField.setText(
                String.format("%.2f", result)
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid number.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================
    // Length Conversion
    // =========================

    private double convertLength(
        double value,
        String source,
        String target
    ) {

        double meter;

        // Convert to Meter first
        switch (source) {

            case "Meter":
                meter = value;
                break;

            case "Centimeter":
                meter = value / 100;
                break;

            case "Inch":
                meter = value * 0.0254;
                break;

            case "Foot":
                meter = value * 0.3048;
                break;

            default:
                meter = value;
        }

        // Convert Meter to target unit
        switch (target) {

            case "Meter":
                return meter;

            case "Centimeter":
                return meter * 100;

            case "Inch":
                return meter / 0.0254;

            case "Foot":
                return meter / 0.3048;

            default:
                return meter;
        }
    }

    // =========================
    // Weight Conversion
    // =========================

    private double convertWeight(
        double value,
        String source,
        String target
    ) {

        double kilogram;

        // Convert to Kilogram first
        switch (source) {

            case "Kilogram":
                kilogram = value;
                break;

            case "Gram":
                kilogram = value / 1000;
                break;

            case "Pound":
                kilogram = value * 0.45359237;
                break;

            case "Ounce":
                kilogram = value * 0.0283495231;
                break;

            default:
                kilogram = value;
        }

        // Convert Kilogram to target unit
        switch (target) {

            case "Kilogram":
                return kilogram;

            case "Gram":
                return kilogram * 1000;

            case "Pound":
                return kilogram / 0.45359237;

            case "Ounce":
                return kilogram / 0.0283495231;

            default:
                return kilogram;
        }
    }

    // =========================
    // Temperature Conversion
    // =========================

    private double convertTemperature(
        double value,
        String source,
        String target
    ) {

        double celsius;

        // Convert to Celsius first
        switch (source) {

            case "Celsius":
                celsius = value;
                break;

            case "Fahrenheit":
                celsius = (value - 32) * 5 / 9;
                break;

            case "Kelvin":
                celsius = value - 273.15;
                break;

            default:
                celsius = value;
        }

        // Convert Celsius to target unit
        switch (target) {

            case "Celsius":
                return celsius;

            case "Fahrenheit":
                return celsius * 9 / 5 + 32;

            case "Kelvin":
                return celsius + 273.15;

            default:
                return celsius;
        }
    }

    // =========================
    // Main
    // =========================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new A1123327_Exercise2();
        });
    }
}

