package parameters;

public class RecursiveShapeAlgorithmParameters extends AlgorithmParameters {
    private  int centerX;
    private  int centerY;
    private  int initialSize;
    private  int depth;
    private  int numShapes;

    // Constructor
    public RecursiveShapeAlgorithmParameters(int centerX, int centerY, int initialSize, int depth, int numShapes) {
        this.parameterType = "algorithm";
        this.algorithmName = "RecursiveShape";
        this.centerX = centerX;
        this.centerY = centerY;
        this.initialSize = initialSize;
        this.depth = depth;
        this.numShapes = numShapes;
    }

    @Override
    public void initialiseDefaultParameters() {
        centerX = 250;
        centerY = 250;
        initialSize = 100;
        depth = 3;
        numShapes = 5;
    }

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

    @Override
    public RecursiveShapeAlgorithmParameters copy() {
        return new RecursiveShapeAlgorithmParameters(centerX, centerY, initialSize, depth, numShapes);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        RecursiveShapeAlgorithmParameters that = (RecursiveShapeAlgorithmParameters) other;
        return getCenterX() == that.getCenterX() &&
                getCenterY() == that.getCenterY() &&
                getInitialSize() == that.getInitialSize() &&
                getDepth() == that.getDepth() &&
                getNumShapes() == that.getNumShapes();
    }
    // Getters
    public int getCenterX() { return centerX; }
    public int getCenterY() { return centerY; }
    public int getInitialSize() { return initialSize; }
    public int getDepth() { return depth; }
    public int getNumShapes() { return numShapes; }

    // Setters
    public void setCenterX(int newX) {centerX = newX; }
    public void setCenterY(int newY) { centerY = newY; }
    public void setInitialSize(int newInitialSize) { initialSize = newInitialSize; }
    public void setDepth(int newDepth) { depth = newDepth; }
    public void setNumShapes(int newNumShapes) { numShapes = newNumShapes; }

}

