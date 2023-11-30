package version2.algorithms;

import java.awt.*;

/**
 * Interface as part of the strategy design pattern
 * @author carysedwards
 */
public interface AlgorithmStrategy {
    boolean validateParameters();
    void executeAlgorithm();
    void drawPattern(Graphics g);
    void saveImage(String filePath);
}
