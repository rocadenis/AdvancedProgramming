package org.example;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.File;

public class MainFrame extends JFrame {
    public static final String SAVE_FILE_NAME = "game_state.dat";
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My game");
        init();
    }

    public void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize components
        canvas = new DrawingPanel();
        configPanel = new ConfigPanel(canvas, this);
        controlPanel = new ControlPanel(this);

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the frame
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setWindowSize(5); // Initial window size

        // Pack components and set visible
        pack();
        setVisible(true);

        // Adăugare ascultător pentru butonul "Load"
        controlPanel.getLoadButton().addActionListener(e -> {
            // Afisati un dialog de incarcare a fisierului
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);

            // Verificati daca utilizatorul a selectat un fisier
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                // Aici puteti adauga logica pentru incarcarea efectiva a jocului din fisierul selectat
                JOptionPane.showMessageDialog(null, "Game loaded from: " + selectedFile.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null, "No file selected.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }


    public void setWindowSize(int size) {
        size++;
        size *= 50;
        if (size + 100 > getHeight()) {
            setSize(size - 15, getHeight());
        }
        setSize(size - 15, size + 100);
    }

    public void saveGame() {
        Component frame = null;
        String saveFileName = MainFrame.SAVE_FILE_NAME;
        GameStateManager.saveGameState(canvas, saveFileName); // Utilizăm GameStateManager pentru a salva starea jocului
        JOptionPane.showMessageDialog(frame, "Game state saved successfully.");
    }

    public void saveGame(String filePath) throws IOException {
        GameStateManager.saveGameState(canvas, filePath);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
