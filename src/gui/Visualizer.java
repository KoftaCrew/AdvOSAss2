package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

public class Visualizer extends JPanel {
    private static final int circleSize = 10;
    private int initialPointer;
    private int[] queue;

    public Visualizer(int initialPointer, int[] queue) {
        this.initialPointer = initialPointer;
        this.queue = queue;
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

        int max = 0;
        for (int x : queue) {
            max = Math.max(max, x);
        }

        float verticalStep = (float) h / (float) (queue.length + 2);
        float horizontalStep = (float) w / (float) max;

        g.setColor(Color.blue);

        g.fillOval((int) (initialPointer * horizontalStep) - (circleSize / 2), (int) verticalStep - (circleSize / 2), circleSize, circleSize);
        g.drawLine((int) (initialPointer * horizontalStep), (int) verticalStep, (int) (queue[0] * horizontalStep), (int) (2 * verticalStep));

        for (int i = 0; i < queue.length - 1; i++) {
            g.fillOval((int) (queue[i] * horizontalStep) - (circleSize / 2), (int) ((i + 2) * verticalStep) - (circleSize / 2), circleSize, circleSize);
        }

        g.fillOval((int) (queue[queue.length - 1] * horizontalStep) - (circleSize / 2), (int) ((queue.length + 1) * verticalStep) - (circleSize / 2), circleSize, circleSize);
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

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(200, 100);
    }
}
