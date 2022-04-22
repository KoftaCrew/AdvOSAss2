// Kareem Mohamed Morsy Ismail       , ID: 20190386, Group: CS-S3, Program: CS
// David Emad Philip Ata-Allah       , ID: 20190191, Group: CS-S3, Program: CS
// Mostafa Mahmoud Anwar Morsy Sadek , ID: 20190544, Group: CS-S3, Program: CS
// Mohamed Ashraf Mohamed Ali        , ID: 20190424, Group: CS-S3, Program: CS

import javax.swing.*;
import java.awt.*;

public class Visualizer extends JPanel {
    private static final int circleSize = 10;
    private int initialPointer;
    private int[] queue;
    private int cylinders;

    public Visualizer(int initialPointer, int[] queue, int cylinders) {
        this.initialPointer = initialPointer;
        this.queue = queue;
        this.cylinders = cylinders;
    }

    public Visualizer() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (queue == null)
            return;

        int h = getHeight();
        int w = getWidth();

        float verticalStep = (float) h / (float) (queue.length + 2);
        float horizontalStep = (float)(w - circleSize) / (float) cylinders;

        g.setColor(Color.black);

        g.drawLine(0, 25, w, 25);

        g.drawString(String.valueOf(initialPointer), (int) (initialPointer * horizontalStep) + circleSize, 20);
        g.drawLine((int) (initialPointer * horizontalStep) + (circleSize / 2), 0, (int) (initialPointer * horizontalStep) + (circleSize / 2), 25);

        for (int i = 0; i < queue.length - 1; i++) {
            g.drawString(String.valueOf(queue[i]), (int) (queue[i] * horizontalStep) + circleSize, 20);
            g.drawLine((int) (queue[i] * horizontalStep) + (circleSize / 2), 0, (int) (queue[i] * horizontalStep) + (circleSize / 2), 25);
        }

        g.setColor(Color.blue);

        g.fillOval((int) (initialPointer * horizontalStep), (int) verticalStep - (circleSize / 2), circleSize, circleSize);
        g.drawLine((int) (initialPointer * horizontalStep) + (circleSize / 2), (int) verticalStep, (int) (queue[0] * horizontalStep)  + (circleSize / 2), (int) (2 * verticalStep));

        for (int i = 0; i < queue.length - 1; i++) {
            g.fillOval((int) (queue[i] * horizontalStep), (int) ((i + 2) * verticalStep) - (circleSize / 2), circleSize, circleSize);
            g.drawLine((int) (queue[i] * horizontalStep) + (circleSize / 2), (int) ((i + 2) * verticalStep), (int) (queue[i + 1] * horizontalStep)  + (circleSize / 2), (int) ((i + 3) * verticalStep));
        }

        g.fillOval((int) (queue[queue.length - 1] * horizontalStep), (int) ((queue.length + 1) * verticalStep) - (circleSize / 2), circleSize, circleSize);
    }

    public int getInitialPointer() {
        return initialPointer;
    }

    public void setInitialPointer(int initialPointer) {
        this.initialPointer = initialPointer;
        repaint();
    }

    public int[] getQueue() {
        return queue;
    }

    public void setQueue(int[] queue) {
        this.queue = queue;
        repaint();
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(200, 100);
    }
}
