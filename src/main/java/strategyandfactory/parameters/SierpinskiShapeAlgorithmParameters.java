package strategyandfactory.parameters;

/**
 * Responsible for housing and configuring the specific Sierpinski Algorithm values
 * @author carysedwards
 */
public class SierpinskiShapeAlgorithmParameters extends Parameters {
    private int centreX;
    private int centreY;
    private int polygonSize;
    private int depth;

    /**
     * Creates new sierpinski shape parameters
     * @param centreX - starting x co-ordinate
     * @param centreY -  starting y co-ordinate
     * @param polygonSize - the size of the shapes drawn
     * @param depth - the recursive depth of the algorithm
     */
    public SierpinskiShapeAlgorithmParameters(int centreX, int centreY, int polygonSize, int depth) {
        this.parameterType = "algorithm";
        this.centreX = centreX;
        this.centreY = centreY;
        this.polygonSize = polygonSize;
        this.depth = depth;
    }

    /**
     * Validates the circle packing parameters
     * Especially required for the GUI which provides free text
     * @return true if the parameters are valid
     */
    @Override
    public boolean validateParameters() {
        try {
            if (centreX <= 0) {
                throw new IllegalArgumentException("Centre X coordinate must be greater than 0");
            }
            if (centreY <= 0) {
                throw new IllegalArgumentException("Centre Y coordinate must be greater than 0");
            }
            if (polygonSize <= 0) {
                throw new IllegalArgumentException("Polygon size must be greater than 0");
            }
            if (depth < 0) {
                throw new IllegalArgumentException("Depth cannot be negative");
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Gets the centre x co-ordinate
     * @return centreX
     */
    public int getCentreX() {
        return centreX;
    }

    /**
     * Sets the centre x co-ordinate
     * @param centreX - the x co-ordinate
     */
    public void setCentreX(int centreX) {
        this.centreX = centreX;
    }

    /**
     * Gets the centre y co-ordinate
     * @return centreY
     */
    public int getCentreY() {
        return centreY;
    }

    /**
     * Sets the centre y co-ordinate
     * @param centreY - the y co-ordinate
     */
    public void setCentreY(int centreY) {
        this.centreY = centreY;
    }

    /**
     * Gets the polygon size
     * @return polygonSize
     */
    public int getPolygonSize() {
        return polygonSize;
    }

    /**
     * Sets the polygon size
     * @param polygonSize - the size
     */
    public void setPolygonSize(int polygonSize) {
        this.polygonSize = polygonSize;
    }

    /**
     * Gets the recursive depth of the algorithm
     * @return depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Sets the recursive depth of the algorithm
     * @param depth - the recursive depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }
}

