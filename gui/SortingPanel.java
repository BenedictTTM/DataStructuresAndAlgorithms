package DataStructuresAndAlgorithms.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import algorithms.SelectionSort;
import algorithms.BubbleSort;
import algorithms.InsertionSort;
import algorithms.ShellSort;
import algorithms.HeapSort;
import algorithms.MergeSort;

/**
 * SortingPanel provides the user interface for sorting algorithms.
 * Users can enter numbers, select an algorithm, and see the sorted result.
 */
public class SortingPanel extends JPanel {
    private JTextField inputField;
    private JTextArea outputArea;
    private JComboBox<String> algoBox;
    private JFrame parent;

    public SortingPanel(JFrame parent) {
        this.parent = parent;
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255));

        initializeComponents();
    }

    private void initializeComponents() {
        // Input panel at the top
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(240, 248, 255));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input & Algorithm Selection"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Input label and field
        JLabel inputLabel = new JLabel("Enter numbers (comma separated):");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        inputPanel.add(inputLabel, gbc);

        inputField = new JTextField(30);
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(inputField, gbc);

        // File input button
        JButton fileBtn = new JButton("📁 Load from File");
        fileBtn.setFont(new Font("Arial", Font.BOLD, 12));
        fileBtn.setBackground(new Color(100, 149, 237));
        fileBtn.setForeground(Color.WHITE);
        fileBtn.setFocusPainted(false);
        fileBtn.addActionListener(e -> loadNumbersFromFile());
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(fileBtn, gbc);

        // Algorithm selection
        JLabel algoLabel = new JLabel("Select Sorting Algorithm:");
        algoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(algoLabel, gbc);

        String[] algorithms = {
            "Selection Sort", "Bubble Sort", "Insertion Sort", 
            "Shell Sort", "Heap Sort", "Merge Sort", "Quick Sort"
        };
        algoBox = new JComboBox<>(algorithms);
        algoBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(algoBox, gbc);

        add(inputPanel, BorderLayout.NORTH);

        // Output area in the center
        outputArea = new JTextArea(15, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospace", Font.PLAIN, 14));
        outputArea.setBackground(new Color(250, 250, 250));
        
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Results"));
        add(scrollPane, BorderLayout.CENTER);

        // Button panel at the bottom
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));

        JButton sortBtn = createButton("Sort Array", new Color(34, 139, 34));
        sortBtn.addActionListener(e -> performSorting());

        JButton clearBtn = createButton("Clear", new Color(255, 140, 0));
        clearBtn.addActionListener(e -> clearFields());

        JButton backBtn = createButton("Back to Main Menu", new Color(220, 20, 60));
        backBtn.addActionListener(e -> returnToMainMenu());

        buttonPanel.add(sortBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(backBtn);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        button.setPreferredSize(new Dimension(150, 40));
        
        // Hover effect
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

    private void performSorting() {
        String inputText = inputField.getText().trim();
        
        if (inputText.isEmpty()) {
            outputArea.setText("ERROR: Please enter some numbers to sort.\n\nExample: 64, 34, 25, 12, 22, 11, 90");
            return;
        }

        try {
            String[] parts = inputText.split(",");
            int[] originalArray = new int[parts.length];
            
            for (int i = 0; i < parts.length; i++) {
                originalArray[i] = Integer.parseInt(parts[i].trim());
            }

            int[] arrayToSort = originalArray.clone();
            String selectedAlgorithm = (String) algoBox.getSelectedItem();
            
            StringBuilder result = new StringBuilder();
            result.append("SORTING OPERATION\n");
            result.append("==========================================\n");
            result.append("Algorithm: ").append(selectedAlgorithm).append("\n");
            result.append("Original Array: ").append(Arrays.toString(originalArray)).append("\n");
            result.append("Array Length: ").append(originalArray.length).append(" elements\n\n");
            
            long startTime = System.nanoTime();
            
            // Execute sorting algorithm
            switch (selectedAlgorithm) {
                case "Selection Sort":
                    new SelectionSort().sort(arrayToSort);
                    result.append("Selection Sort completed!\n");
                    result.append("Time Complexity: O(n²)\n");
                    break;
                case "Bubble Sort":
                    new BubbleSort().sort(arrayToSort);
                    result.append("Bubble Sort completed!\n");
                    result.append("Time Complexity: O(n²)\n");
                    break;
                case "Insertion Sort":
                    new InsertionSort().sort(arrayToSort);
                    result.append("Insertion Sort completed!\n");
                    result.append("Time Complexity: O(n²)\n");
                    break;
                case "Shell Sort":
                    ShellSort.shellSort(arrayToSort);
                    result.append("Shell Sort completed!\n");
                    result.append("Time Complexity: O(n^1.5)\n");
                    break;
                case "Heap Sort":
                    HeapSort.heapSort(arrayToSort);
                    result.append("Heap Sort completed!\n");
                    result.append("Time Complexity: O(n log n)\n");
                    break;
                case "Merge Sort":
                    MergeSort.sort(arrayToSort);
                    result.append("Merge Sort completed!\n");
                    result.append("Time Complexity: O(n log n)\n");
                    break;
                case "Quick Sort":
                    // Use simple quicksort implementation since QuickSort class has complex structure
                    quickSortSimple(arrayToSort, 0, arrayToSort.length - 1);
                    result.append("Quick Sort completed!\n");
                    result.append("Time Complexity: O(n log n) average\n");
                    break;
                default:
                    result.append("Algorithm not implemented yet: ").append(selectedAlgorithm);
            }
            
            long endTime = System.nanoTime();
            double executionTime = (endTime - startTime) / 1_000_000.0;
            
            result.append("\nSorted Array: ").append(Arrays.toString(arrayToSort)).append("\n");
            result.append("\nPERFORMANCE METRICS\n");
            result.append("==========================================\n");
            result.append(String.format("Execution Time: %.3f milliseconds\n", executionTime));
            result.append("Elements Sorted: ").append(arrayToSort.length).append("\n");
            
            outputArea.setText(result.toString());
            outputArea.setCaretPosition(0);
            
        } catch (NumberFormatException ex) {
            outputArea.setText("ERROR: Invalid input format!\n\n" +
                    "Please enter numbers separated by commas.\n" +
                    "Example: 64, 34, 25, 12, 22, 11, 90\n\n" +
                    "Make sure all inputs are valid integers.");
        } catch (Exception ex) {
            outputArea.setText("ERROR: An unexpected error occurred!\n\n" +
                    "Error message: " + ex.getMessage() + "\n\n" +
                    "Please check your input and try again.");
        }
    }

    // Simple QuickSort implementation for GUI use
    private void quickSortSimple(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionSimple(arr, low, high);
            quickSortSimple(arr, low, pi - 1);
            quickSortSimple(arr, pi + 1, high);
        }
    }

    private int partitionSimple(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private void clearFields() {
        inputField.setText("");
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
                                 "\n\nSelect a sorting algorithm and click 'Sort Array' to proceed.");
                
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
