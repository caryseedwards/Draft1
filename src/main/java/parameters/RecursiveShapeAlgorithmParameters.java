package parameters;

public class RecursiveShapeAlgorithmParameters extends AlgorithmParameters {
    private int centerX;
    private int centerY;
    private int initialSize;
    private int depth;
    private int numShapes;

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
        // Set default values
        centerX = 0;
        centerY = 0;
        initialSize = 100;
        depth = 3;
        numShapes = 5;
    }

    @Override
    public boolean validateParameters() {
        // Validation logic
        return initialSize > 0 && depth >= 0 && numShapes > 0;
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
        return centerX == that.centerX &&
                centerY == that.centerY &&
                initialSize == that.initialSize &&
                depth == that.depth &&
                numShapes == that.numShapes;
    }
    // Getters
    public int getCenterX() { return centerX; }
    public int getCenterY() { return centerY; }
    public int getInitialSize() { return initialSize; }
    public int getDepth() { return depth; }
    public int getNumShapes() { return numShapes; }

    // Setters
    public void setCenterX(int centerX) { this.centerX = centerX; }
    public void setCenterY(int centerY) { this.centerY = centerY; }
    public void setInitialSize(int initialSize) { this.initialSize = initialSize; }
    public void setDepth(int depth) { this.depth = depth; }
    public void setNumShapes(int numShapes) { this.numShapes = numShapes; }

}

