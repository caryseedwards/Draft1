package withoutgof.validation;

import withoutgof.gui.CirclePackingPanel;
import withoutgof.gui.RecursivePanel;
import withoutgof.gui.SierpinskiPanel;

public class Validate {

    public static String validateRecursiveParams(RecursivePanel rp) {
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

    public static String validateCirclePackingParams(CirclePackingPanel cpp) {
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

    public static String validateSierpinskiParams(SierpinskiPanel sp) {
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

    private static String validateInteger(String input, String parameterName) {
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
