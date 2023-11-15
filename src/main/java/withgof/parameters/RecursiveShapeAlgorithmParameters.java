package withgof.parameters;

public class RecursiveShapeAlgorithmParameters extends Parameters {
    private int centerX;
    private int centerY;
    private int initialSize;
    private int depth;
    private int numShapes;

    public RecursiveShapeAlgorithmParameters(int centerX, int centerY, int initialSize, int depth, int numShapes) {
        this.parameterType = "recursive";
        this.centerX = centerX;
        this.centerY = centerY;
        this.initialSize = initialSize;
        this.depth = depth;
        this.numShapes = numShapes;
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

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int newX) {
        centerX = newX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int newY) {
        centerY = newY;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int newInitialSize) {
        initialSize = newInitialSize;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int newDepth) {
        depth = newDepth;
    }

    public int getNumShapes() {
        return numShapes;
    }

    public void setNumShapes(int newNumShapes) {
        numShapes = newNumShapes;
    }

}

