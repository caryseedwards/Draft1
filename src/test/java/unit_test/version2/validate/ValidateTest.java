package unit_test.version2.validate;

import org.junit.Test;
import org.mockito.Mockito;
import version2.gui.view.panel.CirclePackingPanelView;
import version2.gui.view.panel.RecursivePanelView;
import version2.gui.view.panel.SierpinskiPanelView;
import version2.validate.Validate;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ValidateTest {

    private RecursivePanelView createMockRecursivePanel(String startX, String depth, String initialRadius) {
        RecursivePanelView mockPanel = Mockito.mock(RecursivePanelView.class);
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
        when(mockStartYTextField.getText()).thenReturn("100");
        when(mockRecursiveDepthTextField.getText()).thenReturn(depth);
        when(mockInitialRadiusTextField.getText()).thenReturn(initialRadius);
        when(mockNumShapeTextField.getText()).thenReturn("3");
        when(mockLargeLineWidthTextField.getText()).thenReturn("2");
        when(mockSmallLineWidthTextField.getText()).thenReturn("1");
        return mockPanel;
    }

    private CirclePackingPanelView createMockCirclePackingPanelView(String startX, String startY, String maxAttempts, String boundaryRadius, String boundaryLineWidth, String packingLineWidth, String maxRadius, String minRadius) {
        CirclePackingPanelView mockPanel = Mockito.mock(CirclePackingPanelView.class);
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

    private SierpinskiPanelView createMockSierpinskiPanel(String depth, String size, String lineWidth) {
        SierpinskiPanelView mockPanel = Mockito.mock(SierpinskiPanelView.class);
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
        when(mockStartXTextField.getText()).thenReturn("150");
        when(mockStartYTextField.getText()).thenReturn("150");
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
    public void testValidateRecursiveParamsPanelWithValidInputs() {
        RecursivePanelView mockPanel = createMockRecursivePanel("100", "5", "50");
        assertEquals("", Validate.validateRecursivePanelView(mockPanel));
    }

    @Test
    public void testValidateRecursiveParamsPanelWithNegativeDepth() {
        RecursivePanelView mockPanel = createMockRecursivePanel("100", "-1", "50");
        assertEquals("Recursive depth must be a positive integer.", Validate.validateRecursivePanelView(mockPanel));
    }

    @Test
    public void testValidateRecursiveParamsPanelWithEmptyStartX() {
        RecursivePanelView mockPanel = createMockRecursivePanel("", "5", "50");
        assertEquals("CenterX must be an integer.", Validate.validateRecursivePanelView(mockPanel));
    }

    @Test
    public void testValidateRecursiveParamsPanelWithNonIntegerRadius() {
        RecursivePanelView mockPanel = createMockRecursivePanel("100", "5", "abc");
        assertEquals("Initial radius must be an integer.", Validate.validateRecursivePanelView(mockPanel));
    }



    @Test
    public void testValidateCirclePackingParamsPanelWithValidInputs() {
        CirclePackingPanelView mockPanel = createMockCirclePackingPanelView("200", "200", "100", "300", "5", "3", "60", "5");
        assertEquals("", Validate.validateCirclePackingPanelView(mockPanel));
    }

    @Test
    public void testValidateCirclePackingParamsPanelWithZeroMaxAttempts() {
        CirclePackingPanelView mockPanel = createMockCirclePackingPanelView("200", "200", "0", "300", "5", "3", "60", "5");
        assertEquals("MaxAttempts must be a positive integer.", Validate.validateCirclePackingPanelView(mockPanel));
    }

    @Test
    public void testValidateCirclePackingParamsPanelWithLargeValues() {
        CirclePackingPanelView mockPanel = createMockCirclePackingPanelView("10000", "10000", "1000", "5000", "10", "8", "300", "10");
        assertEquals("", Validate.validateCirclePackingPanelView(mockPanel));
    }

    @Test
    public void testValidateCirclePackingParamsPanelWithZeroBoundaryLineWidth() {
        CirclePackingPanelView mockPanel = createMockCirclePackingPanelView("200", "200", "100", "300", "0", "3", "60", "5");
        assertEquals("Boundary Line Width must be a positive integer.", Validate.validateCirclePackingPanelView(mockPanel));
    }


    @Test
    public void testValidateSierpinskiParamsPanelWithValidInputs() {
        SierpinskiPanelView mockPanel = createMockSierpinskiPanel("4", "200", "2");
        assertEquals("", Validate.validateSierpinskiPanelView(mockPanel));
    }

    @Test
    public void testValidateSierpinskiParamsPanelWithInvalidSize() {
        SierpinskiPanelView mockPanel = createMockSierpinskiPanel("4", "-200", "2");
        assertEquals("Polygon Size must be a positive integer.", Validate.validateSierpinskiPanelView(mockPanel));
    }

    @Test
    public void testValidateSierpinskiParamsPanelWithZeroDepth() {
        SierpinskiPanelView mockPanel = createMockSierpinskiPanel("0", "200", "2");
        assertEquals("Depth must be a positive integer.", Validate.validateSierpinskiPanelView(mockPanel));
    }

    @Test
    public void testValidateSierpinskiParamsPanelWithNegativeLineWidth() {
        SierpinskiPanelView mockPanel = createMockSierpinskiPanel("4", "200", "-1");
        assertEquals("Shape Line Width must be a positive integer.", Validate.validateSierpinskiPanelView(mockPanel));
    }
}