package com.kodilla.testing.forum.shape;

import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.Shape;
import com.kodilla.testing.shape.ShapeCollection;
import org.junit.jupiter.api.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeAfterTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for shapes")
    class Tests {

        @Test
        public void testAddShape() {

            //Given
            ShapeCollection shapeCollection = new ShapeCollection();
            Circle circle = new Circle(1);

            //When
            shapeCollection.addFigure(circle);

            //Then
            Assertions.assertEquals(circle, shapeCollection.getFigure(0));
        }

        @Test
        public void testRemoveExistingShape() {

            //Given
            ShapeCollection shapeCollection = new ShapeCollection();
            Circle circle = new Circle(1);
            shapeCollection.addFigure(circle);

            //When
            boolean result = shapeCollection.removeFigure(circle);


            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollection.getSize());
        }

        @Test
        public void testGetFigure() {

            //Given
            ShapeCollection shapeCollection = new ShapeCollection();
            Circle circle = new Circle(1);
            shapeCollection.addFigure(circle);

            //When
            Shape shape = shapeCollection.getFigure(0);

            //Then
            Assertions.assertNotNull(shape);
            Assertions.assertEquals("Circle", shape.getShapeName());
        }
    }
}


