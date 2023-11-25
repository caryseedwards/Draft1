package strategyandfactory.validate;

import strategyandfactory.gui.view.panel.CirclePackingPanelView;
import strategyandfactory.gui.view.panel.RecursivePanelView;
import strategyandfactory.gui.view.panel.SierpinskiPanelView;

/**
 * Validates the parameters used as input to the algorithms
 * For both the GUI and the API
 * @author carysedwards
 */
public class Validate {

    /**
     * Validates inputs for a recursive panel view
     * @param rp the recursive panel view to validate
     * @return error - empty if the panel passed validation
     */
    public static String validateRecursivePanelView(RecursivePanelView rp) {
        String error;

        error = validateInteger(rp.getStartXTextField().getText(), "CenterX");
        if (!error.isEmpty()) return error;

        error = validateInteger(rp.getStartYTextField().getText(), "CenterY");
        if (!error.isEmpty()) return error;

        error = validateInteger(rp.getRecursiveDepthTextField().getText(), "Recursive depth");
        if (!error.isEmpty()) return error;

        error = validateInteger(rp.getInitialRadiusTextField().getText(), "Initial radius");
        if (!error.isEmpty()) return error;

        error = validateInteger(rp.getNumShapeTextField().getText(), "Number of shapes");
        if (!error.isEmpty()) return error;

        error = validateInteger(rp.getLargeLineWidthTextField().getText(), "Large shape line width");
        if (!error.isEmpty()) return error;

        error = validateInteger(rp.getSmallLineWidthTextField().getText(), "Small shape line width");
        if (!error.isEmpty()) return error;

        return "";
    }

    /**
     * Validates inputs for a circle packing panel view
     * @param cpp the circle packing view to validate
     * @return error - empty if the panel passed validation
     */
    public static String validateCirclePackingPanelView(CirclePackingPanelView cpp) {
        String error;

        error = validateInteger(cpp.getStartXTextField().getText(), "CentreX");
        if (!error.isEmpty()) return error;

        error = validateInteger(cpp.getStartYTextField().getText(), "CentreY");
        if (!error.isEmpty()) return error;

        error = validateInteger(cpp.getMaxAttemptsTextField().getText(), "MaxAttempts");
        if (!error.isEmpty()) return error;

        error = validateInteger(cpp.getBoundaryRadiusTextField().getText(), "PolygonSize");
        if (!error.isEmpty()) return error;

        error = validateInteger(cpp.getBoundaryLineWidthTextField().getText(), "Boundary Line Width");
        if (!error.isEmpty()) return error;

        error = validateInteger(cpp.getPackingLineWidthTextField().getText(), "Packing Line Width");
        if (!error.isEmpty()) return error;

        error = validateInteger(cpp.getMaxRadiusCircleTextField().getText(), "MaxRadius");
        if (!error.isEmpty()) return error;

        error = validateInteger(cpp.getMinRadiusCircleTextField().getText(), "MinRadius");
        if (!error.isEmpty()) return error;

        return "";
    }

    /**
     * Validates inputs for a sierpinski panel view
     * @param sp the circle packing view to validate
     * @return error - empty if the panel passed validation
     */
    public static String validateSierpinskiPanelView(SierpinskiPanelView sp) {
        String error;

        error = validateInteger(sp.getStartXTextField().getText(), "CentreX");
        if (!error.isEmpty()) return error;

        error = validateInteger(sp.getStartYTextField().getText(), "CentreY");
        if (!error.isEmpty()) return error;

        error = validateInteger(sp.getDepthTextField().getText(), "Depth");
        if (!error.isEmpty()) return error;

        error = validateInteger(sp.getSizeTextField().getText(), "Polygon Size");
        if (!error.isEmpty()) return error;

        error = validateInteger(sp.getLineWidthTextField().getText(), "Shape Line Width");
        if (!error.isEmpty()) return error;

        return "";
    }

    /**
     * Helper method to safely parse strings entered by users into the text boxes
     * @param text - Text to valid if it is an integer
     * @return the text as an Integer or null if not an int
     */
    public static Integer safelyParseInteger(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Helper method to cast a String to an Integer
     * @param input the input string
     * @param parameterName the parameter name
     * @return The string converted to an Integer or an empty string if not possible
     */
    public static String validateInteger(String input, String parameterName) {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) {
                return parameterName + " must be a positive integer.";
            }
        } catch (NumberFormatException e) {
            return parameterName + " must be an integer.";
        }
        return "";
    }
}