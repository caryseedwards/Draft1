package unit_test.version3.validate;

import static org.junit.Assert.*;

import version3.gui.CirclePackingPanel;
import version3.gui.RecursivePanel;
import version3.gui.SierpinskiPanel;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import version3.validation.Validate;

import java.awt.*;

public class ValidateTest {

    private RecursivePanel createMockRecursivePanel(String startX, String startY, String depth, String initialRadius, String numShapes, String largeLineWidth, String smallLineWidth) {
        RecursivePanel mockPanel = Mockito.mock(RecursivePanel.class);
        TextField mockStartXTextField = Mockito.mock(TextField.class);
        TextField mockStartYTextField = Mockito.mock(TextField.class);
        TextField mockRecursiveDepthTextField = Mockito.mock(TextField.class);
        TextField mockInitialRadiusTextField = Mockito.mock(TextField.class);
        TextField mockNumShapeTextField = Mockito.mock(TextField.class);
        TextField mockLargeLineWidthTextField = Mockito.mock(TextField.class);
        TextField mockSmallLineWidthTextField = Mockito.mock(TextField.class);
        when(mockPanel.getStartXTextField()).thenReturn(mockStartXTextField);
        when(mockPanel.getStartYTextField()).thenReturn(mockStartYTextField);
        when(mockPanel.getRecursiveDepthTextField()).thenReturn(mockRecursiveDepthTextField);
        when(mockPanel.getInitialRadiusTextField()).thenReturn(mockInitialRadiusTextField);
        when(mockPanel.getNumShapeTextField()).thenReturn(mockNumShapeTextField);
        when(mockPanel.getLargeLineWidthTextField()).thenReturn(mockLargeLineWidthTextField);
        when(mockPanel.getSmallLineWidthTextField()).thenReturn(mockSmallLineWidthTextField);
        when(mockStartXTextField.getText()).thenReturn(startX);
        when(mockStartYTextField.getText()).thenReturn(startY);
        when(mockRecursiveDepthTextField.getText()).thenReturn(depth);
        when(mockInitialRadiusTextField.getText()).thenReturn(initialRadius);
        when(mockNumShapeTextField.getText()).thenReturn(numShapes);
        when(mockLargeLineWidthTextField.getText()).thenReturn(largeLineWidth);
        when(mockSmallLineWidthTextField.getText()).thenReturn(smallLineWidth);
        return mockPanel;
    }

    private CirclePackingPanel createMockCirclePackingPanel(String startX, String startY, String maxAttempts, String boundaryRadius, String boundaryLineWidth, String packingLineWidth, String maxRadius, String minRadius) {
        CirclePackingPanel mockPanel = Mockito.mock(CirclePackingPanel.class);
        TextField mockStartXTextField = Mockito.mock(TextField.class);
        TextField mockStartYTextField = Mockito.mock(TextField.class);
        TextField mockMaxAttemptsTextField = Mockito.mock(TextField.class);
        TextField mockBoundaryRadiusTextField = Mockito.mock(TextField.class);
        TextField mockBoundaryLineWidthTextField = Mockito.mock(TextField.class);
        TextField mockPackingLineWidthTextField = Mockito.mock(TextField.class);
        TextField mockMaxRadiusCircleTextField = Mockito.mock(TextField.class);
        TextField mockMinRadiusCircleTextField = Mockito.mock(TextField.class);
        when(mockPanel.getStartXTextField()).thenReturn(mockStartXTextField);
        when(mockPanel.getStartYTextField()).thenReturn(mockStartYTextField);
        when(mockPanel.getMaxAttemptsTextField()).thenReturn(mockMaxAttemptsTextField);
        when(mockPanel.getBoundaryRadiusTextField()).thenReturn(mockBoundaryRadiusTextField);
        when(mockPanel.getBoundaryLineWidthTextField()).thenReturn(mockBoundaryLineWidthTextField);
        when(mockPanel.getPackingLineWidthTextField()).thenReturn(mockPackingLineWidthTextField);
        when(mockPanel.getMaxRadiusCircleTextField()).thenReturn(mockMaxRadiusCircleTextField);
        when(mockPanel.getMinRadiusCircleTextField()).thenReturn(mockMinRadiusCircleTextField);
        when(mockStartXTextField.getText()).thenReturn(startX);
        when(mockStartYTextField.getText()).thenReturn(startY);
        when(mockMaxAttemptsTextField.getText()).thenReturn(maxAttempts);
        when(mockBoundaryRadiusTextField.getText()).thenReturn(boundaryRadius);
        when(mockBoundaryLineWidthTextField.getText()).thenReturn(boundaryLineWidth);
        when(mockPackingLineWidthTextField.getText()).thenReturn(packingLineWidth);
        when(mockMaxRadiusCircleTextField.getText()).thenReturn(maxRadius);
        when(mockMinRadiusCircleTextField.getText()).thenReturn(minRadius);
        return mockPanel;
    }

    private SierpinskiPanel createMockSierpinskiPanel(String startX, String startY, String depth, String size, String lineWidth) {
        SierpinskiPanel mockPanel = Mockito.mock(SierpinskiPanel.class);
        TextField mockStartXTextField = Mockito.mock(TextField.class);
        TextField mockStartYTextField = Mockito.mock(TextField.class);
        TextField mockDepthTextField = Mockito.mock(TextField.class);
        TextField mockSizeTextField = Mockito.mock(TextField.class);
        TextField mockLineWidthTextField = Mockito.mock(TextField.class);
        when(mockPanel.getStartXTextField()).thenReturn(mockStartXTextField);
        when(mockPanel.getStartYTextField()).thenReturn(mockStartYTextField);
        when(mockPanel.getDepthTextField()).thenReturn(mockDepthTextField);
        when(mockPanel.getSizeTextField()).thenReturn(mockSizeTextField);
        when(mockPanel.getLineWidthTextField()).thenReturn(mockLineWidthTextField);
        when(mockStartXTextField.getText()).thenReturn(startX);
        when(mockStartYTextField.getText()).thenReturn(startY);
        when(mockDepthTextField.getText()).thenReturn(depth);
        when(mockSizeTextField.getText()).thenReturn(size);
        when(mockLineWidthTextField.getText()).thenReturn(lineWidth);
        return mockPanel;
    }

    @Test
    public void testPositiveInteger() {
        assertEquals("", Validate.validateInteger("5", "TestParam"));
    }

    @Test
    public void testNegativeInteger() {
        assertEquals("TestParam must be a positive integer.", Validate.validateInteger("-5", "TestParam"));
    }

    @Test
    public void testZero() {
        assertEquals("TestParam must be a positive integer.", Validate.validateInteger("0", "TestParam"));
    }

    @Test
    public void testNonInteger() {
        assertEquals("TestParam must be an integer.", Validate.validateInteger("abc", "TestParam"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("TestParam must be an integer.", Validate.validateInteger("", "TestParam"));
    }

    @Test
    public void testLargeInteger() {
        assertEquals("", Validate.validateInteger("9999999", "TestParam"));
    }

    @Test
    public void testvalidateRecursiveParamsWithValidInputs() {
        RecursivePanel mockPanel = createMockRecursivePanel("100", "100", "5", "50", "3", "2", "1");
        assertEquals("", Validate.validateRecursiveParams(mockPanel));
    }

    @Test
    public void testvalidateRecursiveParamsWithNegativeDepth() {
        RecursivePanel mockPanel = createMockRecursivePanel("100", "100", "-1", "50", "3", "2", "1");
        assertEquals("Recursive depth must be a positive integer.", Validate.validateRecursiveParams(mockPanel));
    }

    @Test
    public void testvalidateRecursiveParamsWithEmptyStartX() {
        RecursivePanel mockPanel = createMockRecursivePanel("", "100", "5", "50", "3", "2", "1");
        assertEquals("CenterX must be an integer.", Validate.validateRecursiveParams(mockPanel));
    }

    @Test
    public void testvalidateRecursiveParamsWithNonIntegerRadius() {
        RecursivePanel mockPanel = createMockRecursivePanel("100", "100", "5", "abc", "3", "2", "1");
        assertEquals("Initial radius must be an integer.", Validate.validateRecursiveParams(mockPanel));
    }



    @Test
    public void testvalidateCirclePackingParamsWithValidInputs() {
        CirclePackingPanel mockPanel = createMockCirclePackingPanel("200", "200", "100", "300", "5", "3", "60", "5");
        assertEquals("", Validate.validateCirclePackingParams(mockPanel));
    }

    @Test
    public void testvalidateCirclePackingParamsWithZeroMaxAttempts() {
        CirclePackingPanel mockPanel = createMockCirclePackingPanel("200", "200", "0", "300", "5", "3", "60", "5");
        assertEquals("MaxAttempts must be a positive integer.", Validate.validateCirclePackingParams(mockPanel));
    }

    @Test
    public void testvalidateCirclePackingParamsWithLargeValues() {
        CirclePackingPanel mockPanel = createMockCirclePackingPanel("10000", "10000", "1000", "5000", "10", "8", "300", "10");
        assertEquals("", Validate.validateCirclePackingParams(mockPanel));
    }

    @Test
    public void testvalidateCirclePackingParamsWithZeroBoundaryLineWidth() {
        CirclePackingPanel mockPanel = createMockCirclePackingPanel("200", "200", "100", "300", "0", "3", "60", "5");
        assertEquals("Boundary Line Width must be a positive integer.", Validate.validateCirclePackingParams(mockPanel));
    }


    @Test
    public void testvalidateSierpinskiParamsWithValidInputs() {
        SierpinskiPanel mockPanel = createMockSierpinskiPanel("150", "150", "4", "200", "2");
        assertEquals("", Validate.validateSierpinskiParams(mockPanel));
    }

    @Test
    public void testvalidateSierpinskiParamsWithInvalidSize() {
        SierpinskiPanel mockPanel = createMockSierpinskiPanel("150", "150", "4", "-200", "2");
        assertEquals("Polygon Size must be a positive integer.", Validate.validateSierpinskiParams(mockPanel));
    }

    @Test
    public void testvalidateSierpinskiParamsWithZeroDepth() {
        SierpinskiPanel mockPanel = createMockSierpinskiPanel("150", "150", "0", "200", "2");
        assertEquals("Depth must be a positive integer.", Validate.validateSierpinskiParams(mockPanel));
    }

    @Test
    public void testvalidateSierpinskiParamsWithNegativeLineWidth() {
        SierpinskiPanel mockPanel = createMockSierpinskiPanel("150", "150", "4", "200", "-1");
        assertEquals("Shape Line Width must be a positive integer.", Validate.validateSierpinskiParams(mockPanel));
    }
}
