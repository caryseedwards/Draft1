package strategyandfactory.parameters;

import java.awt.*;

public class CanvasParameters extends Parameters {
    private int height;
    private int width;
    private Color backgroundColour;

    public CanvasParameters(int height, int width, Color backgroundColour) {
        this.parameterType = "canvas";
        this.height = height;
        this.width = width;
        this.backgroundColour = backgroundColour;
    }

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getBackgroundColour() {
        return backgroundColour;
    }

    public void setBackgroundColour(Color backgroundColour) {
        this.backgroundColour = backgroundColour;
    }

}
