package DataStructuresAndAlgorithms.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import algorithms.BinarySearch;
import algorithms.LinearSearch;

public class SearchingPanel extends JPanel {
    private JTextField inputField;
    private JTextField targetField;
    private JTextArea outputArea;
    private JComboBox<String> algoBox;
    private JFrame parent;

    public SearchingPanel(JFrame parent) {
        this.parent = parent;
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255));

        initializeInputPanel();
        initializeOutputArea();
        initializeButtonPanel();
    }

    private void initializeInputPanel() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(240, 248, 255));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input & Search Selection"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Enter numbers (comma separated):"), gbc);

        inputField = new JTextField(30);
        gbc.gridx = 1; gbc.gridy = 0;
        inputPanel.add(inputField, gbc);

        // File input button
        JButton fileBtn = new JButton("📁 Load from File");
        fileBtn.setFont(new Font("Arial", Font.BOLD, 12));
        fileBtn.setBackground(new Color(100, 149, 237));
        fileBtn.setForeground(Color.WHITE);
        fileBtn.setFocusPainted(false);
        fileBtn.addActionListener(e -> loadNumbersFromFile());
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(fileBtn, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(new JLabel("Enter target value:"), gbc);

        targetField = new JTextField(10);
        gbc.gridx = 1; gbc.gridy = 2;
        inputPanel.add(targetField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Select Searching Algorithm:"), gbc);

        String[] algorithms = {"Linear Search", "Binary Search"};
        algoBox = new JComboBox<>(algorithms);
        gbc.gridx = 1; gbc.gridy = 3;
        inputPanel.add(algoBox, gbc);

        add(inputPanel, BorderLayout.NORTH);
    }

    private void initializeOutputArea() {
        outputArea = new JTextArea(15, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospace", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Search Results"));
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initializeButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));

        JButton searchBtn = createStyledButton("Search", new Color(34, 139, 34));
        searchBtn.addActionListener(e -> performSearch());

        JButton clearBtn = createStyledButton("Clear", new Color(255, 140, 0));
        clearBtn.addActionListener(e -> clearFields());

        JButton backBtn = createStyledButton("Back to Main Menu", new Color(220, 20, 60));
        backBtn.addActionListener(e -> returnToMainMenu());

        buttonPanel.add(searchBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(backBtn);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JButton createStyledButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(180, 40));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor);
            }
        });
        return button;
    }

    private void performSearch() {
        String inputText = inputField.getText().trim();
        String targetText = targetField.getText().trim();

        if (inputText.isEmpty() || targetText.isEmpty()) {
            outputArea.setText("ERROR: Please enter both the array and the target value.");
            return;
        }

        try {
            String[] parts = inputText.split(",");
            int[] array = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                array[i] = Integer.parseInt(parts[i].trim());
            }

            int target = Integer.parseInt(targetText);
            String selectedAlgorithm = (String) algoBox.getSelectedItem();
            Arrays.sort(array);

            StringBuilder result = new StringBuilder();
            result.append("SEARCHING OPERATION\n");
            result.append("==========================================\n");
            result.append("Algorithm: ").append(selectedAlgorithm).append("\n");
            result.append("Array: ").append(Arrays.toString(array)).append("\n");
            result.append("Target: ").append(target).append("\n\n");

            long startTime = System.nanoTime();
            int index = -1;

            if ("Linear Search".equals(selectedAlgorithm)) {
                index = LinearSearch.linearSearch(array, target);
                result.append("Time Complexity: O(n)\n");
            } else if ("Binary Search".equals(selectedAlgorithm)) {
                index = BinarySearch.binarySearch(array, target);
                result.append("Time Complexity: O(log n)\n");
            }

            long endTime = System.nanoTime();
            double executionTime = (endTime - startTime) / 1_000_000.0;

            if (index != -1) {
                result.append("\nResult: Target found at index " + index + ".\n");
            } else {
                result.append("\nResult: Target not found in the array.\n");
            }

            result.append(String.format("Execution Time: %.3f milliseconds\n", executionTime));

            outputArea.setText(result.toString());
            outputArea.setCaretPosition(0);
        } catch (NumberFormatException e) {
            outputArea.setText("ERROR: Invalid input detected. Ensure all inputs are valid integers.");
        } catch (Exception e) {
            outputArea.setText("ERROR: " + e.getMessage());
        }
    }

    private void clearFields() {
        inputField.setText("");
        targetField.setText("");
        outputArea.setText("");
        inputField.requestFocus();
    }

    private void returnToMainMenu() {
        if (parent instanceof MainGUI) {
            ((MainGUI) parent).returnToMainMenu();
        }
    }

    private void loadNumbersFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a file with comma-separated numbers");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Text files (*.txt)", "txt"));
        
        int result = fileChooser.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                StringBuilder content = new StringBuilder();
                String line;
                
                while ((line = reader.readLine()) != null) {
                    content.append(line).append(",");
                }
                
                // Remove trailing comma and set to input field
                String numbers = content.toString().replaceAll(",$", "");
                inputField.setText(numbers);
                
                // Show success message
                outputArea.setText("✅ Successfully loaded numbers from file: " + selectedFile.getName() + 
                                 "\n\nNumbers loaded: " + numbers + 
                                 "\n\nEnter a target value and select a searching algorithm to proceed.");
                
            } catch (IOException ex) {
                outputArea.setText("❌ ERROR: Failed to read the file!\n\n" +
                                 "Error details: " + ex.getMessage() + "\n\n" +
                                 "Please ensure:\n" +
                                 "• The file exists and is accessible\n" +
                                 "• The file contains comma-separated numbers\n" +
                                 "• You have read permissions for the file");
            } catch (Exception ex) {
                outputArea.setText("❌ ERROR: An unexpected error occurred!\n\n" +
                                 "Error details: " + ex.getMessage());
            }
        }
    }
}
