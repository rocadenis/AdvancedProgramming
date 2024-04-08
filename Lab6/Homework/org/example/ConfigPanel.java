package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ConfigPanel extends JPanel {

    private DrawingPanel drawingPanel;
    private MainFrame mainFrame;
    private JSpinner spinner;
    private JButton newGameButton;

    public ConfigPanel(DrawingPanel drawingPanel, MainFrame mainFrame) {
        this.drawingPanel = drawingPanel;
        this.mainFrame = mainFrame;

        JLabel label = new JLabel("Grid Size:");
        spinner = new JSpinner(new SpinnerNumberModel(5, 5, 20, 1));
        newGameButton = new JButton("New Game");

        setLayout(new FlowLayout());
        add(label);
        add(spinner);
        add(newGameButton);

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gridSize = (int) spinner.getValue();
                mainFrame.setWindowSize(gridSize);
                drawingPanel.setGridSize(gridSize);
                drawingPanel.initGame();
                drawingPanel.repaint();
            }
        });
    }

    public void updateSpinnerValue(int value) {
        spinner.setValue(value);
    }

}
