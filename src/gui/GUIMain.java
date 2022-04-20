package gui;

import algorithms.Algorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain {
    private JTextField requestsTxt;
    private JTextField initialTxt;
    private JComboBox algorithmCb;
    private JPanel panel;
    private JButton startButton;
    private JPanel visualizerPanel;
    private Visualizer visualizer;

    public GUIMain() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int initial;
                int q[];
                try {
                    initial = Integer.parseInt(initialTxt.getText().trim());
                    String[] qString = requestsTxt.getText().split(",");
                    q = new int[qString.length];
                    for (int i = 0; i < q.length; i++) {
                        q[i] = Integer.parseInt(qString[i].trim());
                    }
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Input error");
                    return;
                }

                switch (algorithmCb.getSelectedIndex()) {
                    case 0:
                        visualizer.setInitialPointer(initial);
                        visualizer.setQueue(Algorithms.FCFS(q, initial));
                        break;
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("CPU Scheduler");
        frame.setContentPane(new GUIMain().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(680, 680));
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        String[] algorithms ={
                "FCFS",
                "SSTF",
                "SCAN",
                "C-SCAN",
                "LOOK",
                "C-LOOK",
                "Real-Time Disk Scheduling Algorithm"
        };
        algorithmCb = new JComboBox<>(algorithms);

        visualizer = new Visualizer();
        visualizerPanel = visualizer;
    }
}
