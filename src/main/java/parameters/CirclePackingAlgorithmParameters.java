package parameters;

public class CirclePackingAlgorithmParameters extends AlgorithmParameters {
    public int centreX;
    public int centreY;
    public int polygonSize;
    public int minRadius, maxRadius, maxAttempts;
    public int animationSpeed;

    // Constructor
    public CirclePackingAlgorithmParameters(int centreX, int centreY, int polygonSize, int minRadius, int maxRadius, int maxAttempts, int animationSpeed) {
        this.parameterType = "algorithm";
        this.algorithmName = "CirclePacking";
        this.centreX = centreX;
        this.centreY = centreY;
        this.polygonSize = polygonSize;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.maxAttempts = maxAttempts;
        this.animationSpeed = animationSpeed;
    }

    @Override
    public void initialiseDefaultParameters() {
        centreX = 250;
        centreY = 250;
        polygonSize = 111;
        minRadius = 5;
        maxRadius = 22;
        maxAttempts = 100;
        animationSpeed = 1;
    }

    @Override
    public boolean validateParameters() {
        try {
            if (minRadius <= 0) {
                throw new IllegalArgumentException("Minimum radius must be greater than 0");
            }
            if (maxRadius < minRadius) {
                throw new IllegalArgumentException("Maximum radius must be greater than or equal to minimum radius");
            }
            if (maxAttempts <= 0) {
                throw new IllegalArgumentException("Maximum attempts must be greater than 0");
            }
            if (animationSpeed <= 0) {
                throw new IllegalArgumentException("Animation speed must be greater than 0");
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public CirclePackingAlgorithmParameters copy() {
        return new CirclePackingAlgorithmParameters(centreX, centreY, polygonSize, minRadius, maxRadius, maxAttempts, animationSpeed);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        CirclePackingAlgorithmParameters that = (CirclePackingAlgorithmParameters) other;
        return centreX == that.centreX &&
                centreY == that.centreY &&
                polygonSize == that.polygonSize &&
                minRadius == that.minRadius &&
                maxRadius == that.maxRadius &&
                maxAttempts == that.maxAttempts &&
                animationSpeed == that.animationSpeed;
    }

    public int getCentreX() { return centreX; }
    public int getCentreY() { return centreY; }
    public int getPolygonSize() { return polygonSize; }
    public int getMinRadius() { return minRadius; }
    public int getMaxRadius() { return maxRadius; }
    public int getMaxAttempts() { return maxAttempts; }
    public int getAnimationSpeed() { return animationSpeed; }

    public void setCentreX(int centreX) { this.centreX = centreX; }
    public void setCentreY(int centreY) { this.centreY = centreY; }
    public void setPolygonSize(int polygonSize) { this.polygonSize = polygonSize; }
    public void setMinRadius(int minRadius) { this.minRadius = minRadius; }
    public void setMaxRadius(int maxRadius) { this.maxRadius = maxRadius; }
    public void setMaxAttempts(int maxAttempts) { this.maxAttempts = maxAttempts; }
    public void setAnimationSpeed(int animationSpeed) { this.animationSpeed = animationSpeed; }

}