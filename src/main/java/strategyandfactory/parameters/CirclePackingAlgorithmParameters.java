package strategyandfactory.parameters;

/**
 * Responsible for housing and configuring the specific Circle Packing Algorithm values
 * @author carysedwards
 */
public class CirclePackingAlgorithmParameters extends Parameters {
    public int centreX;
    public int centreY;
    public int polygonSize;
    public int minRadius, maxRadius, maxAttempts;
    public int animationSpeed;

    /**
     * Creates new Circle Packing algorithm parameters
     * @param centreX - starting x co-ordinate
     * @param centreY - starting y co-ordinate
     * @param polygonSize - the size of the boundary shape
     * @param minRadius - the minimum radius of the fill circles
     * @param maxRadius - the maximum radius of the fill circles
     * @param maxAttempts - the number of attempts to place a circle until the algorithm completes
     * @param animationSpeed - the speed of the animation in ms
     */
    public CirclePackingAlgorithmParameters(int centreX, int centreY, int polygonSize, int minRadius, int maxRadius, int maxAttempts, int animationSpeed) {
        this.parameterType = "packing";
        this.centreX = centreX;
        this.centreY = centreY;
        this.polygonSize = polygonSize;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.maxAttempts = maxAttempts;
        this.animationSpeed = animationSpeed;
    }

    /**
     * Validates the circle packing parameters
     * Especially required for the GUI which provides free text
     * @return true if the parameters are valid
     */
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
     * Gets the boundary polygon size
     * @return polygonSize
     */
    public int getPolygonSize() {
        return polygonSize;
    }

    /**
     * Sets the boundary polygon size
     * @param polygonSize - boundary polygon size
     */
    public void setPolygonSize(int polygonSize) {
        this.polygonSize = polygonSize;
    }

    /**
     * Gets the minimum radius of the fill circles
     * @return minRadius
     */
    public int getMinRadius() {
        return minRadius;
    }

    /**
     * Sets the minimum radius of the fill circles
     * @param minRadius - minimum radius of the fill circles
     */
    public void setMinRadius(int minRadius) {
        this.minRadius = minRadius;
    }

    /**
     * Gets the maximum radius of the fill circles
     * @return maxRadius
     */
    public int getMaxRadius() {
        return maxRadius;
    }

    /**
     * Sets the maximum of the fill circles
     * @param maxRadius - minimum radius of the fill circles
     */
    public void setMaxRadius(int maxRadius) {
        this.maxRadius = maxRadius;
    }

    /**
     * Gets the maximum attempts to place a circle until the algorithm completes
     * @return maxAttempts
     */
    public int getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * Sets the maximum attempts to place a circle until the algorithm completes
     * @param maxAttempts - maximum attempts to place a circle
     */
    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    /**
     * Gets the animation speed
     * @return animationSpeed
     */
    public int getAnimationSpeed() {
        return animationSpeed;
    }

    /**
     * Sets the animation speed
     * @param animationSpeed - the animation speed in ms
     */
    public void setAnimationSpeed(int animationSpeed) {
        this.animationSpeed = animationSpeed;
    }

}