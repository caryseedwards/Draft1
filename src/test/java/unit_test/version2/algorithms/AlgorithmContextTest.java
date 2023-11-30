package unit_test.version2.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;
import version2.algorithms.AlgorithmContext;

public class AlgorithmContextTest {

    @Test
    public void testSingletonPattern() {
        AlgorithmContext firstInstance = AlgorithmContext.getAlgorithmContext();
        AlgorithmContext secondInstance = AlgorithmContext.getAlgorithmContext();
        assertSame("Singleton instances should be the same", firstInstance, secondInstance);
    }

    @Test
    public void testSetAndGetStrategy() {
        MockAlgorithmStrategy mockStrategy = new MockAlgorithmStrategy();
        AlgorithmContext context = AlgorithmContext.getAlgorithmContext();
        context.setStrategy(mockStrategy);
        assertSame("Set and get strategy should return the same object", mockStrategy, context.getStrategy());
    }

    @Test
    public void testExecuteStrategy() {
        MockAlgorithmStrategy mockStrategy = new MockAlgorithmStrategy();
        AlgorithmContext context = AlgorithmContext.getAlgorithmContext();
        context.setStrategy(mockStrategy);
        context.executeAlgorithm();
        assertTrue("executeAlgorithm should call the strategy's executeAlgorithm method", mockStrategy.isExecuteCalled());
    }

    @Test
    public void testDrawPattern() {
        MockAlgorithmStrategy mockStrategy = new MockAlgorithmStrategy();
        AlgorithmContext context = AlgorithmContext.getAlgorithmContext();
        context.setStrategy(mockStrategy);
        context.drawPattern(null);
        assertTrue("drawPattern should call the strategy's drawPattern method", mockStrategy.isDrawCalled());
    }

    @Test
    public void testStrategyChange() {
        MockAlgorithmStrategy firstStrategy = new MockAlgorithmStrategy();
        MockAlgorithmStrategy secondStrategy = new MockAlgorithmStrategy();
        AlgorithmContext context = AlgorithmContext.getAlgorithmContext();

        context.setStrategy(firstStrategy);
        assertSame("First strategy should be set correctly", firstStrategy, context.getStrategy());

        context.setStrategy(secondStrategy);
        assertSame("Strategy should be changeable", secondStrategy, context.getStrategy());
    }

    @Test
    public void testValidateParameters() {
        MockAlgorithmStrategy mockStrategy = new MockAlgorithmStrategy();
        mockStrategy.setValidationOutcome(true);
        AlgorithmContext context = AlgorithmContext.getAlgorithmContext();
        context.setStrategy(mockStrategy);
        assertTrue("validateParameters should return true", mockStrategy.validateParameters());

        mockStrategy.setValidationOutcome(false);
        assertFalse("validateParameters should return false", mockStrategy.validateParameters());
    }


}

