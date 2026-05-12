import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleShippingApp extends JFrame {
	private JTextField weightField, distanceField;
	private JComboBox<String> policyCombo;
	private JTextArea resultArea;

	public SimpleShippingApp() {
		setTitle("Shipping Calculator (No Patterns)");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Standardized GUI layout
		JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
		inputPanel.add(new JLabel("Weight (kg):"));
		weightField = new JTextField();
		inputPanel.add(weightField);

		inputPanel.add(new JLabel("Distance (km):"));
		distanceField = new JTextField();
		inputPanel.add(distanceField);

		inputPanel.add(new JLabel("Policy:"));
		policyCombo = new JComboBox<>(
				new String[] {"Flat Rate", "Weight-Based", "Distance-Based", "Carrier-Specific"});
		inputPanel.add(policyCombo);

		JButton calcButton = new JButton("Calculate Cost");
		inputPanel.add(calcButton);

		resultArea = new JTextArea();
		resultArea.setEditable(false);

		add(inputPanel, BorderLayout.NORTH);
		add(new JScrollPane(resultArea), BorderLayout.CENTER);

		// Logic handled entirely within the listener
		calcButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(weightField.getText());
					double distance = Double.parseDouble(distanceField.getText());
					String policy = (String) policyCombo.getSelectedItem();
					double cost = 0;
					String surchargeNote = "";

					// 1. Calculate Base Cost (The "Policy" logic)
					if (policy.equals("Flat Rate")) {
						cost = 20.0;
					} else if (policy.equals("Weight-Based")) {
						cost = weight * 5.5;
					} else if (policy.equals("Distance-Based")) {
						cost = distance * 0.75;
					} else if (policy.equals("Carrier-Specific")) {
						cost = (weight * 2) + (distance * 0.5) + 15;
					}

					// 2. Add Handling Fee (The "Heavy Load" logic)
					// Instead of a Decorator, we just use a hardcoded if-statement
					if (weight > 20) {
						cost += 15.0;
						surchargeNote = " (Includes $15 Heavy Surcharge)";
					}

					resultArea.append(policy + ": $" + cost + surchargeNote + "\n");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
				}
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new SimpleShippingApp().setVisible(true));
	}
}
