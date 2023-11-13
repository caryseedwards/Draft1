package withgof.algorithms;
import java.awt.*;

public interface AlgorithmStrategy {
    boolean validateParameters();
    void executeAlgorithm();
    void drawPattern(Graphics g);
}
