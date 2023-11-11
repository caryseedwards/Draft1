package parameters;

public class SierpinskiShapeAlgorithmParameters extends AlgorithmParameters {
    private int centreX, centreY, polygonSize, depth;

    // Constructor
    public SierpinskiShapeAlgorithmParameters(int centreX, int centreY, int polygonSize, int depth) {
        this.parameterType = "algorithm";
        this.algorithmName = "SierpinskiShape";
        this.centreX = centreX;
        this.centreY = centreY;
        this.polygonSize = polygonSize;
        this.depth = depth;
    }

    @Override
    public void initialiseDefaultParameters() {
        // Set default values
        centreX = 0;
        centreY = 0;
        polygonSize = 100;
        depth = 3;
    }

    @Override
    public boolean validateParameters() {
        return centreX > 0 && centreY > 0 && polygonSize > 0 && depth >= 0;
    }

    @Override
    public SierpinskiShapeAlgorithmParameters copy() {
        return new SierpinskiShapeAlgorithmParameters(centreX, centreY, polygonSize, depth);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        SierpinskiShapeAlgorithmParameters that = (SierpinskiShapeAlgorithmParameters) other;
        return centreX == that.centreX &&
                centreY == that.centreY &&
                polygonSize == that.polygonSize &&
                depth == that.depth;
    }

    // Getters
    public int getCentreX() { return centreX; }
    public int getCentreY() { return centreY; }
    public int getPolygonSize() { return polygonSize; }
    public int getDepth() { return depth; }

    // Setters
    public void setCentreX(int centreX) { this.centreX = centreX; }
    public void setCentreY(int centreY) { this.centreY = centreY; }
    public void setPolygonSize(int polygonSize) { this.polygonSize = polygonSize; }
    public void setDepth(int depth) { this.depth = depth; }
}

