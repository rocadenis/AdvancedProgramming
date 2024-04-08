package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn;
    JButton saveBtn;
    JButton exitBtn;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        loadBtn = new JButton("Load");
        saveBtn = new JButton("Save");
        exitBtn = new JButton("Exit");

        setLayout(new FlowLayout());
        add(loadBtn);
        add(saveBtn);
        add(exitBtn);

        // Add action listeners
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        exitBtn.addActionListener(this::exitGame);
    }

    public JButton getLoadButton() {
        return loadBtn;
    }

    private void loadGame(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);

        // Verifica daca utilizatorul a selectat un fisier
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            JOptionPane.showMessageDialog(null, "Game loaded from: " + selectedFile.getAbsolutePath());
        } else {
            JOptionPane.showMessageDialog(null, "No file selected.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveGame(ActionEvent e) {
        // Crearea unui selector de fișiere
        JFileChooser fileChooser = new JFileChooser();
        // Afisarea dialogului de salvare
        int returnValue = fileChooser.showSaveDialog(this);

        // Verificarea dacă utilizatorul a selectat un fișier pentru salvare
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Obținerea fișierului selectat
            File selectedFile = fileChooser.getSelectedFile();
            // Salvarea jocului în fișierul selectat
            try {
                frame.saveGame(selectedFile.getAbsolutePath()); // Salvarea jocului în fișierul selectat
                JOptionPane.showMessageDialog(null, "Game saved successfully to: " + selectedFile.getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving game.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
