package unit_test.withgof.mvc.model;

import org.junit.Before;
import org.junit.Test;
import withgof.gui.model.ParametersModel;
import withgof.parameters.*;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParametersModelTest {

    private ParametersModel model;

    @Before
    public void setUp() {
        model = new ParametersModel();
    }

    @Test
    public void testCanvasParams_initialState() {
        CanvasParameters canvas = model.getCanvasParams();
        assertNotNull(canvas);
        assertEquals(500, canvas.getWidth());
        assertEquals(500, canvas.getHeight());
        assertEquals(Color.WHITE, canvas.getBackgroundColour());
    }

    @Test
    public void testCanvasParams_setAndGet() {
        CanvasParameters newCanvas = new CanvasParameters(600, 600, Color.BLACK);
        model.setCanvasParams(newCanvas);
        assertEquals(newCanvas, model.getCanvasParams());
    }

    @Test(expected = NullPointerException.class)
    public void testCanvasParams_setNull() {
        model.setCanvasParams(null);
    }

    @Test
    public void testShapesParams_initialState() {
        ArrayList<ShapeParameters> shapes = model.getShapesParams();
        assertNotNull(shapes);
        assertEquals(2, shapes.size());
    }

    @Test
    public void testShapesParams_setAndGet() {
        ArrayList<ShapeParameters> newShapes = new ArrayList<>();
        newShapes.add(new ShapeParameters("rectangle", 2, Color.BLUE, Color.GREEN));
        model.setShapesParams(newShapes);
        assertEquals(newShapes, model.getShapesParams());
    }

    @Test(expected = NullPointerException.class)
    public void testShapesParams_setNull() {
        model.setShapesParams(null);
    }

    @Test
    public void testRecursiveParams_initialState() {
        RecursiveShapeAlgorithmParameters rap = model.getRecursiveParams();
        assertNotNull(rap);
        assertEquals(250, rap.getCenterX());
        assertEquals(250, rap.getCenterY());
        assertEquals(100, rap.getInitialSize());
        assertEquals(4, rap.getDepth());
        assertEquals(6, rap.getNumShapes());
    }

    @Test
    public void testRecursiveParams_setAndGet() {
        RecursiveShapeAlgorithmParameters newRap = new RecursiveShapeAlgorithmParameters(300, 300, 150, 5, 7);
        model.setRecursiveParams(newRap);
        assertEquals(newRap, model.getRecursiveParams());
    }

    @Test(expected = NullPointerException.class)
    public void testRecursiveParams_setNull() {
        model.setRecursiveParams(null);
    }

    @Test
    public void testPackingParams_initialState() {
        CirclePackingAlgorithmParameters cap = model.getPackingParams();
        assertNotNull(cap);
        assertEquals(250, cap.getCentreX());
        assertEquals(250, cap.getCentreY());
    }

    @Test
    public void testPackingParams_setAndGet() {
        CirclePackingAlgorithmParameters newCap = new CirclePackingAlgorithmParameters(300, 300, 150, 6, 60, 1, 3);
        model.setPackingParams(newCap);
        assertEquals(newCap, model.getPackingParams());
    }

    @Test(expected = NullPointerException.class)
    public void testPackingParams_setNull() {
        model.setPackingParams(null);
    }

    @Test
    public void testSierpinskiParams_initialState() {
        SierpinskiShapeAlgorithmParameters sap = model.getSierpinskiParams();
        assertNotNull(sap);
        assertEquals(250, sap.getCentreX());
        assertEquals(250, sap.getCentreY());
        assertEquals(100, sap.getPolygonSize());
        assertEquals(4, sap.getDepth());
    }

    @Test
    public void testSierpinskiParams_setAndGet() {
        SierpinskiShapeAlgorithmParameters newSap = new SierpinskiShapeAlgorithmParameters(300, 300, 150, 5);
        model.setSierpinskiParams(newSap);
        assertEquals(newSap, model.getSierpinskiParams());
    }

    @Test(expected = NullPointerException.class)
    public void testSierpinskiParams_setNull() {
        model.setSierpinskiParams(null);
    }

}

