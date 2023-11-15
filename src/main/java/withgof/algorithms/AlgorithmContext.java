package withgof.algorithms;

import withgof.parameters.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AlgorithmContext extends JPanel {
    private static AlgorithmContext context;
    private AlgorithmStrategy strategy;

    private AlgorithmContext() {
    }

    public static AlgorithmContext getAlgorithmContext() {
        if (context == null) {
            context = new AlgorithmContext();
        }
        return context;
    }

    public void executeAlgorithm() {
        strategy.executeAlgorithm();
    }

    public void drawPattern(Graphics g) {
        strategy.drawPattern(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPattern(g);
    }

    public AlgorithmStrategy getStrategy() {
        return this.strategy;
    }

    public void setStrategy(AlgorithmStrategy strategy) {
        this.strategy = strategy;
    }
}
