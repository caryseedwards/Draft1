package version2.parameters;

import java.awt.*;

/**
 * Houses the canvas parameters used to customise the background for each artwork generated
 * @author carysedwards
 */
public class CanvasParameters extends Parameters {
    private int height;
    private int width;
    private Color backgroundColour;

    /**
     * Creates new canvas parameters
     * @param height - The height of the canvas
     * @param width - the width of the canvas
     * @param backgroundColour - the background colour of the canvas
     */
    public CanvasParameters(int height, int width, Color backgroundColour) {
        this.parameterType = "canvas";
        this.height = height;
        this.width = width;
        this.backgroundColour = backgroundColour;
    }

    /**
     * Used to validate the parameters and check for invalid inputs
     * Especially important when creating from GUI free text fields
     * @return true if the parameters are valid
     */
    @Override
    public boolean validateParameters() {
        try {
            if (height <= 0 || width <= 0) {
                throw new IllegalArgumentException("Canvas height and width needs to be higher than 0");
            }
            if (backgroundColour == null) {
                throw new IllegalArgumentException("Canvas background colour is not initialised");
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Gets the canvas height
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the canvas height
     * @param height - the height of the canvas
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets the canvas width
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the canvas width
     * @param width - the height of the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets the background colour of the canvas
     * @return backgroundColour
     */
    public Color getBackgroundColour() {
        return backgroundColour;
    }

    /**
     * Sets the background colour of the canvas
     * @param backgroundColour - Colour to set the canvas
     */
    public void setBackgroundColour(Color backgroundColour) {
        this.backgroundColour = backgroundColour;
    }

}
