package withgof.parameters;

public class SierpinskiShapeAlgorithmParameters extends Parameters {
    private int centreX;
    private int centreY;
    private int polygonSize;
    private int depth;

    // Constructor
    public SierpinskiShapeAlgorithmParameters(int centreX, int centreY, int polygonSize, int depth) {
        this.parameterType = "algorithm";
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

    // Getters
    public int getCentreX() {
        return centreX;
    }

    // Setters
    public void setCentreX(int centreX) {
        this.centreX = centreX;
    }

    public int getCentreY() {
        return centreY;
    }

    public void setCentreY(int centreY) {
        this.centreY = centreY;
    }

    public int getPolygonSize() {
        return polygonSize;
    }

    public void setPolygonSize(int polygonSize) {
        this.polygonSize = polygonSize;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}

