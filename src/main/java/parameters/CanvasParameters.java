package parameters;

import java.awt.*;
import java.util.Objects;

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
    public void initialiseDefaultParameters() {
        this.height = 500;
        this.width = 500;
        this.backgroundColour = Color.WHITE;
    }

    @Override
    public boolean validateParameters() {
        try {
        // Check if height and width are positive
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Canvas height and width needs to be higher than 0");
        }
        if (backgroundColour == null){
            throw new IllegalArgumentException("Canvas background colour is not initialised");
        }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public CanvasParameters copy() {
        return new CanvasParameters(this.height, this.width, this.backgroundColour);
    }

    @Override
    public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            CanvasParameters that = (CanvasParameters) other;
            return height == that.height &&
                    width == that.width &&
                    Objects.equals(backgroundColour, that.backgroundColour);
    }

    // Getters
    public int getHeight() {return height;}
    public int getWidth() {return width;}
    public Color getBackgroundColour() {return backgroundColour;}

    // Setters
    public void setHeight(int height) {this.height = height;}
    public void setWidth(int width) {this.width = width;}
    public void setBackgroundColour(Color backgroundColour) {this.backgroundColour = backgroundColour;}

}
