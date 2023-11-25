package unit_test.strategyandfactory.algorithms;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import strategyandfactory.algorithms.SierpinskiShapeAlgorithm;
import strategyandfactory.parameters.CanvasParameters;
import strategyandfactory.parameters.ShapeParameters;
import strategyandfactory.parameters.SierpinskiShapeAlgorithmParameters;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SierpinskiShapeAlgorithmTestStrategy {
    CanvasParameters canvas;
    ArrayList<ShapeParameters> shapes;
    SierpinskiShapeAlgorithmParameters algorithm;
    SierpinskiShapeAlgorithm test;

    @Before
    public void createTestInstance() {
        canvas = new CanvasParameters(800, 800, Color.WHITE);
        shapes = new ArrayList<>();
        shapes.add(new ShapeParameters("triangle", 0.1f, Color.BLACK, Color.WHITE));
        algorithm = new SierpinskiShapeAlgorithmParameters(400, 1200, 400, 5);
        test = new SierpinskiShapeAlgorithm(canvas, shapes, algorithm);
    }
    private void refreshTestInstanceWithUpdatedParameters() {
        test = new SierpinskiShapeAlgorithm(canvas, shapes, algorithm);
    }
    private SierpinskiShapeAlgorithm createTestInstanceWithShapeType(String shapeType) {
        CanvasParameters canvas = new CanvasParameters(800, 800, Color.WHITE);
        ArrayList<ShapeParameters> shapes = new ArrayList<>();
        shapes.add(new ShapeParameters(shapeType, 0.1f, Color.BLACK, Color.WHITE));
        SierpinskiShapeAlgorithmParameters algorithm = new SierpinskiShapeAlgorithmParameters(400, 1200, 400, 5);

        return new SierpinskiShapeAlgorithm(canvas, shapes, algorithm);
    }

    @Test
    public void testInitialisationWithDifferentShapes() {
        String[] shapeTypes = {"triangle", "circle", "square", "hexagon"};
        for (String shapeType : shapeTypes) {
            SierpinskiShapeAlgorithm sierpinski = createTestInstanceWithShapeType(shapeType);
            assertNotNull("Algorithm should be initialized for shape type: " + shapeType, sierpinski);
        }
    }
 @Test
    public void testInitialisationWithInvalidShape() {
        assertThrows(IllegalArgumentException.class, () -> createTestInstanceWithShapeType("invalidShape").executeAlgorithm());
    }
    @Test
    public void testParameterValidation() {
        algorithm  = new SierpinskiShapeAlgorithmParameters(20,20,20,3);
        refreshTestInstanceWithUpdatedParameters();
        assertTrue("Valid parameters should pass validation", test.validateParameters());
        algorithm.setDepth(-1);
        assertFalse(test.validateParameters());
    }

    @Test
    public void testSaveImage() {
        test.executeAlgorithm();
        String testFilePath = "test_sierpinski_shape_algorithm.png";
        test.saveImage(testFilePath);
        File savedImage = new File(testFilePath);
        assertTrue("Image file should be created", savedImage.exists() && !savedImage.isDirectory());
    }

    @After
    public void cleanUp() {
        String testFilePath = "test_sierpinski_shape_algorithm.png";
        File savedImage = new File(testFilePath);
        if (savedImage.exists()) {
            savedImage.delete();
        }
    }
}
