package version2.algorithms;

import javax.swing.*;
import java.awt.*;


/** The context of the algorithm to execute.
 * Implemented as part of the Strategy pattern
 *
 * @author carysedwards
 */
public class AlgorithmContext extends JPanel {
    private static AlgorithmContext context;
    private AlgorithmStrategy strategy;

    /**
     * Private constructor to implement the singleton pattern
     */
    private AlgorithmContext() {
    }

    /**
     * Gets the algorithm context currently selected
     * @return the algorithm context or null if one hasn't been selected
     */
    public static AlgorithmContext getAlgorithmContext() {
        if (context == null) {
            context = new AlgorithmContext();
        }
        return context;
    }

    /**
     * Executes the algorithm via the strategy
     */
    public void executeAlgorithm() {
        strategy.executeAlgorithm();
    }

    /**
     * Draws the algorithm via the strategy
     * @param g - the graphics to draw
     */
    public void drawPattern(Graphics g) {
        strategy.drawPattern(g);
    }

    /**
     * Paints the algorithm to the component
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPattern(g);
    }

    /**
     * Gets the strategy selected
     * @return strategy
     */
    public AlgorithmStrategy getStrategy() {
        return this.strategy;
    }

    /**
     * Sets the strategy to be used
     * @param strategy - the strategy to use
     */
    public void setStrategy(AlgorithmStrategy strategy) {
        this.strategy = strategy;
    }
}
