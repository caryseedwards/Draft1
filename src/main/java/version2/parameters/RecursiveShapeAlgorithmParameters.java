package version2.parameters;

/**
 * Responsible for housing and configuring the specific Recursive Shape Algorithm values
 * @author carysedwards
 */
public class RecursiveShapeAlgorithmParameters extends Parameters {
    private int centerX;
    private int centerY;
    private int initialSize;
    private int depth;
    private int numShapes;

    /**
     * Creates new recursive shape parameters
     * @param centerX - starting x co-ordinate
     * @param centerY -  starting y co-ordinate
     * @param initialSize - the initial size of the shapes
     * @param depth - the recursive depth of the algorithm
     * @param numShapes - the number of secondary shapes to draw
     */
    public RecursiveShapeAlgorithmParameters(int centerX, int centerY, int initialSize, int depth, int numShapes) {
        this.parameterType = "recursive";
        this.centerX = centerX;
        this.centerY = centerY;
        this.initialSize = initialSize;
        this.depth = depth;
        this.numShapes = numShapes;
    }

    /**
     * Validates the circle packing parameters
     * Especially required for the GUI which provides free text
     * @return true if the parameters are valid
     */
    @Override
    public boolean validateParameters() {
        try {
            if (initialSize <= 0) {
                throw new IllegalArgumentException("Initial size must be greater than 0");
            }
            if (depth < 0) {
                throw new IllegalArgumentException("Depth cannot be negative");
            }
            if (numShapes <= 0) {
                throw new IllegalArgumentException("Number of shapes must be greater than 0");
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
    public int getCenterX() {
        return centerX;
    }

    /**
     * Sets the centre x co-ordinate
     * @param newX - the x co-ordinate
     */
    public void setCenterX(int newX) {
        centerX = newX;
    }

    /**
     * Gets the centre y co-ordinate
     * @return centreY
     */
    public int getCenterY() {
        return centerY;
    }

    /**
     * Sets the centre y co-ordinate
     * @param newY - the y co-ordinate
     */
    public void setCenterY(int newY) {
        centerY = newY;
    }

    /**
     * Gets the initial size of the shapes
     * @return initialSize
     */
    public int getInitialSize() {
        return initialSize;
    }

    /**
     * Sets the initial size of the shapes
     * @param newInitialSize - initial size of the shapes
     */
    public void setInitialSize(int newInitialSize) {
        initialSize = newInitialSize;
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
     * @param newDepth - depth of the algorithm
     */
    public void setDepth(int newDepth) {
        depth = newDepth;
    }

    /**
     * Gets the number of secondary shapes drawn
     * @return numShapes
     */
    public int getNumShapes() {
        return numShapes;
    }

    /**
     * Sets the number of the secondary shapes drawn
     * @param newNumShapes - number of secondary shapes to draw
     */
    public void setNumShapes(int newNumShapes) {
        numShapes = newNumShapes;
    }

}

