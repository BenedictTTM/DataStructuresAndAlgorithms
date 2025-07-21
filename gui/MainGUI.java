package DataStructuresAndAlgorithms.gui;

import javax.swing.*;
import java.awt.*;

/**
 * MainGUI is the main window of the application.
 * It extends JFrame, which means it is a top-level window that can contain other components.
 * This class serves as the entry point for the GUI version of the Data Structures and Algorithms program.
 */
public class MainGUI extends JFrame { // jframe is the main window class in java swing and so extending it makes MainGUI a window

    /**
     * Constructor sets up the main window properties and components.
     * This is called when a new MainGUI object is created.
     */
    public MainGUI(){
        // Set the title that appears in the window's title bar
        setTitle("Data Structures and Algorithms - GUI Version");

        // Set the window size (width: 800px, height: 700px)
        setSize(700, 600);
        
        // Specify what happens when the user closes the window
        // EXIT_ON_CLOSE means the entire application will terminate
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Center the window on the screen (null means center relative to screen)
        setLocationRelativeTo(null);

        // Set the background color of the window
        getContentPane().setBackground(new Color(240, 248, 255));

        // Initialize the main menu components
        initializeMainMenu();
        
        // Make the window visible to the user
        setVisible(true);
    }

    /**
     * Creates and sets up the main menu panel with buttons for different categories.
     * This method organizes the layout and adds action listeners to buttons.
     */
    private void initializeMainMenu() {
        // Create the main panel that will hold all components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // BorderLayout divides panel into 5 regions
        mainPanel.setBackground(new Color(240, 248, 255));

        // Create a title label at the top
        JLabel titleLabel = new JLabel("Data Structures and Algorithms", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(25, 25, 112));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Create a panel for the main buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 0, 15)); // 3 rows, 1 column, 15px vertical gap
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        // Create buttons for the main menu options
        JButton sortButton = createStyledButton("🔢 Sorting Algorithms", new Color(70, 130, 180));
        JButton searchButton = createStyledButton("🔍 Searching Algorithms", new Color(60, 179, 113));
        JButton exitButton = createStyledButton("❌ Exit Application", new Color(220, 20, 60));

        // Add buttons to the button panel
        buttonPanel.add(sortButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(exitButton);

        // Add components to the main panel
        mainPanel.add(titleLabel, BorderLayout.NORTH);   // Title at the top
        mainPanel.add(buttonPanel, BorderLayout.CENTER); // Buttons in the center

        // Set the main panel as the content pane of the window
        setContentPane(mainPanel);

        //Show the sorting Panel when the sort button is clicked
        sortButton.addActionListener(e -> showSortingPanel());

         //Show the searching Panel when the search button is clicked
        searchButton.addActionListener(e -> showSearchingPanel());

         //when Exit button is clicked, exit the application with confirmation
        exitButton.addActionListener(e -> {
            // Show a confirmation dialog before exiting
            int option = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0); // Terminate the application
            }
        });
        // System.exit(0) closes the current java application and the status code 0 means closing the application normally
    }

    /**
     * Creates a styled button with consistent appearance.
     * @param text The text to display on the button
     * @param backgroundColor The background color of the button
     * @return A styled JButton
     */
    private JButton createStyledButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false); // Remove focus border
        button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        button.setPreferredSize(new Dimension(300, 60));
        
        // Add hover effect - button gets brighter when mouse hovers over it
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

     // we now create the SortingPanel
    private void showSortingPanel(){
        SortingPanel sortingPanel = new SortingPanel(this);
        setContentPane(sortingPanel);
        revalidate(); // refresh the content pane to show the new panel
        repaint();    // redraw the window
    }

    // we now create the SearchingPanel
    private void showSearchingPanel(){
        SearchingPanel searchingPanel = new SearchingPanel(this);
        setContentPane(searchingPanel);
        revalidate(); // refresh the content pane to show the new panel
        repaint();    // redraw the window
    }

    /**
     * Returns to the main menu by reinitializing the main menu components.
     * This method is called from other panels when the user clicks "Back".
     */
    public void returnToMainMenu() {
        initializeMainMenu();
        revalidate(); // Refresh the content pane
        repaint();    // Redraw the window
    }

    // Main method to run the GUI application
    public static void main(String[] args){
        // Ensure the GUI code runs on the Event Dispatch thread(EDT) to avoid conflicts with another thread modifying the GUI and to ensure thread safety
        SwingUtilities.invokeLater(() -> {
            new MainGUI(); // Create an instance of MainGUI - visibility is set in constructor
        });
    }
}
