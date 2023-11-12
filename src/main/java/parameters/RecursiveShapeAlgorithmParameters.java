package parameters;

public class RecursiveShapeAlgorithmParameters extends AlgorithmParameters {
    private static int centerX;
    private static int centerY;
    private static int initialSize;
    private static int depth;
    private static int numShapes;

    // Constructor
    public RecursiveShapeAlgorithmParameters(int centerX, int centerY, int initialSize, int depth, int numShapes) {
        this.parameterType = "algorithm";
        this.algorithmName = "RecursiveShape";
        RecursiveShapeAlgorithmParameters.centerX = centerX;
        RecursiveShapeAlgorithmParameters.centerY = centerY;
        RecursiveShapeAlgorithmParameters.initialSize = initialSize;
        RecursiveShapeAlgorithmParameters.depth = depth;
        RecursiveShapeAlgorithmParameters.numShapes = numShapes;
    }

    @Override
    public void initialiseDefaultParameters() {
        // Set default values
        centerX = 250;
        centerY = 250;
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
    public void setCenterX(int newX) { newX = centerX; }
    public void setCenterY(int newY) { newY = centerY; }
    public void setInitialSize(int newInitialSize) { newInitialSize = initialSize; }
    public void setDepth(int newDepth) { newDepth = depth; }
    public void setNumShapes(int newNumShapes) { newNumShapes = numShapes; }

}

