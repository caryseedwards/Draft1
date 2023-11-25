package template.parameters;

import java.awt.*;

/**
 * Houses the shapes parameters used to customise the shapes used in the algorithms
 * @author carysedwards
 */
public class ShapeParameters extends Parameters {
    private String shapeType;
    private float lineWidth;
    private Color lineColour;
    private Color fillColour;

    /**
     * Creates new shape parameters
     *
     * @param shapeType  - the type of the shape Circle, Hexagon, Square or Triangle
     * @param lineWidth  - the width of the lines
     * @param lineColour - the colour of the lines
     * @param fillColour - the fill colour of the shape
     */
    public ShapeParameters(String shapeType, float lineWidth, Color lineColour, Color fillColour) {
        this.parameterType = "shape";
        this.shapeType = shapeType;
        this.lineWidth = lineWidth;
        this.lineColour = lineColour;
        this.fillColour = fillColour;
    }

    /**
     * Initialises the default parameters for the algorithm
     */
    @Override
    public void initialiseDefaultParameters() {
        this.parameterType = "shape";
        this.shapeType = "circle";
        this.lineWidth = 0.1f;
        this.lineColour = Color.BLACK;
        this.fillColour = Color.WHITE;
    }

    /**
     * Used to validate the parameters and check for invalid inputs
     * Especially important when creating from GUI free text fields
     *
     * @return true if the parameters are valid
     */
    @Override
    public boolean validateParameters() {
        try {
            if (shapeType == null || shapeType.isEmpty()) {
                throw new IllegalArgumentException("Shape type is null or empty");
            }
            if (lineWidth <= 0.0f) {
                throw new IllegalArgumentException("Line width must be positive");
            }
            if (lineColour == null || fillColour == null) {
                throw new IllegalArgumentException("Line or Fill colour is null");
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Gets the shape type
     *
     * @return shapeType
     */
    public String getShapeType() {
        return shapeType;
    }

    /**
     * Sets the shape type
     *
     * @param shapeType - the type of the shape (Circle, Triangle, Hexagon, Square)
     */
    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    /**
     * Gets the line width
     *
     * @return lineWidth
     */
    public float getLineWidth() {
        return lineWidth;
    }

    /**
     * Sets the line width
     *
     * @param lineWidth - the width of the shape lines
     */
    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    /**
     * Gets the line colour
     *
     * @return lineColour
     */
    public Color getLineColour() {
        return lineColour;
    }

    /**
     * Sets the line colour
     *
     * @param lineColour - colour of the line
     */
    public void setLineColour(Color lineColour) {
        this.lineColour = lineColour;
    }

    /**
     * Gets the shape fill colour
     *
     * @return fillColour
     */
    public Color getFillColour() {
        return fillColour;
    }

    /**
     * Sets the fill colour of the shape
     *
     * @param fillColour - the colour to fill the shape
     */
    public void setFillColour(Color fillColour) {
        this.fillColour = fillColour;
    }
}
