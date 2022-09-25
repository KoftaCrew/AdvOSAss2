// Kareem Mohamed Morsy Ismail       , ID: 20190386, Group: CS-S3, Program: CS
// David Emad Philip Ata-Allah       , ID: 20190191, Group: CS-S3, Program: CS
// Mostafa Mahmoud Anwar Morsy Sadek , ID: 20190544, Group: CS-S3, Program: CS
// Mohamed Ashraf Mohamed Ali        , ID: 20190424, Group: CS-S3, Program: CS

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
    private JTextField cylindersTxt;
    private JLabel headMovementLbl;
    private Visualizer visualizer;

    public GUIMain() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int initial;
                int cylindres;
                int q[];
                try {
                    initial = Integer.parseInt(initialTxt.getText().trim());
                    cylindres = Integer.parseInt(cylindersTxt.getText().trim());
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

                visualizer.setInitialPointer(initial);
                visualizer.setCylinders(cylindres);
                switch (algorithmCb.getSelectedIndex()) {
                    case 0:
                        visualizer.setQueue(Algorithms.FCFS(q, initial, cylindres));
                        break;
                    case 1:
                        visualizer.setQueue(Algorithms.SSTF(q, initial, cylindres));
                        break;
                    case 2:
                        visualizer.setQueue(Algorithms.SCAN(q, initial, cylindres));
                        break;
                    case 3:
                        visualizer.setQueue(Algorithms.CSCAN(q, initial, cylindres));
                        break;
                    case 4:
                        visualizer.setQueue(Algorithms.LOOK(q, initial, cylindres));
                        break;
                    case 5:
                        visualizer.setQueue(Algorithms.CLOOK(q, initial, cylindres));
                        break;
                    case 6:
                        visualizer.setQueue(Algorithms.newOptimizedAlgorithm(q, initial, cylindres));
                        break;
                }

                int[] visualizerQueue = visualizer.getQueue();
                int totalHeadMovement = Math.abs(initial - visualizerQueue[0]);
                for (int i = 0; i < visualizerQueue.length - 1; i++) {
                    totalHeadMovement += Math.abs(visualizerQueue[i] - visualizerQueue[i+1]);
                }

                headMovementLbl.setText(String.valueOf(totalHeadMovement));
            }
        });
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("Disk Scheduler");
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
