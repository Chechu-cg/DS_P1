package e3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void getBase() {
        Rectangle rect = new Rectangle(5, 3);
        assertEquals(5, rect.getBase());

        Rectangle rect2 = new Rectangle(10, 7);
        assertEquals(10, rect2.getBase());
    }

    @Test
    void getHeight() {
        Rectangle rect = new Rectangle(5, 3);
        assertEquals(3, rect.getHeight());

        Rectangle rect2 = new Rectangle(10, 7);
        assertEquals(7, rect2.getHeight());
    }

    @Test
    void setBase() {
        Rectangle rect = new Rectangle(2, 2);
        rect.setBase(8);
        assertEquals(8, rect.getBase());

        // Test con valor negativo
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> rect.setBase(-5));
        assertTrue(exception.getMessage().contains("La base no puede ser negativa"));
    }

    @Test
    void setHeight() {
        Rectangle rect = new Rectangle(2, 2);
        rect.setHeight(6);
        assertEquals(6, rect.getHeight());

        // Test con valor negativo
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> rect.setHeight(-3));
        assertTrue(exception.getMessage().contains("La altura no puede ser negativa"));
    }

    @Test
    void isSquare() {
        // Caso cuadrado
        Rectangle square = new Rectangle(4, 4);
        assertTrue(square.isSquare());

        // Caso no cuadrado
        Rectangle rectangle = new Rectangle(4, 3);
        assertFalse(rectangle.isSquare());

        // Caso con dimensiones diferentes
        Rectangle rect2 = new Rectangle(5, 7);
        assertFalse(rect2.isSquare());
    }

    @Test
    void area() {
        Rectangle rect = new Rectangle(4, 3);
        assertEquals(12, rect.area());

        Rectangle rect2 = new Rectangle(5, 5);
        assertEquals(25, rect2.area());

        Rectangle rect3 = new Rectangle(10, 2);
        assertEquals(20, rect3.area());
    }

    @Test
    void perimeter() {
        Rectangle rect = new Rectangle(4, 3);
        assertEquals(14, rect.perimeter());

        Rectangle rect2 = new Rectangle(5, 5);
        assertEquals(20, rect2.perimeter());

        Rectangle rect3 = new Rectangle(10, 2);
        assertEquals(24, rect3.perimeter());
    }

    @Test
    void diagonal() {
        Rectangle rect = new Rectangle(3, 4);
        assertEquals(5.0, rect.diagonal(), 0.001);

        Rectangle rect2 = new Rectangle(6, 8);
        assertEquals(10.0, rect2.diagonal(), 0.001);

        Rectangle rect3 = new Rectangle(1, 1);
        assertEquals(Math.sqrt(2), rect3.diagonal(), 0.001);
    }

    @Test
    void turn() {
        Rectangle rect = new Rectangle(4, 3);
        rect.turn();
        assertEquals(3, rect.getBase());
        assertEquals(4, rect.getHeight());

        // Volver a girar
        rect.turn();
        assertEquals(4, rect.getBase());
        assertEquals(3, rect.getHeight());

        // Test con cuadrado
        Rectangle square = new Rectangle(5, 5);
        square.turn();
        assertEquals(5, square.getBase());
        assertEquals(5, square.getHeight());
    }

    @Test
    void putHorizontal() {
        // Ya está horizontal
        Rectangle rect1 = new Rectangle(5, 3);
        rect1.putHorizontal();
        assertEquals(5, rect1.getBase());
        assertEquals(3, rect1.getHeight());

        // Está vertical, debe girar
        Rectangle rect2 = new Rectangle(3, 5);
        rect2.putHorizontal();
        assertEquals(5, rect2.getBase());
        assertEquals(3, rect2.getHeight());

        // Caso cuadrado
        Rectangle square = new Rectangle(4, 4);
        square.putHorizontal();
        assertEquals(4, square.getBase());
        assertEquals(4, square.getHeight());
    }

    @Test
    void putVertical() {
        // Ya está vertical
        Rectangle rect1 = new Rectangle(3, 5);
        rect1.putVertical();
        assertEquals(3, rect1.getBase());
        assertEquals(5, rect1.getHeight());

        // Está horizontal, debe girar
        Rectangle rect2 = new Rectangle(5, 3);
        rect2.putVertical();
        assertEquals(3, rect2.getBase());
        assertEquals(5, rect2.getHeight());

        // Caso cuadrado
        Rectangle square = new Rectangle(4, 4);
        square.putVertical();
        assertEquals(4, square.getBase());
        assertEquals(4, square.getHeight());
    }

    @Test
    void testEquals() {
        Rectangle rect1 = new Rectangle(4, 3);
        Rectangle rect2 = new Rectangle(4, 3);
        Rectangle rect3 = new Rectangle(5, 3);
        Rectangle rect4 = new Rectangle(4, 4);

        // Igualdad con mismos valores
        assertEquals(rect1, rect2);
        assertEquals(rect2, rect1);

        // Desigualdad con diferentes valores
        assertNotEquals(rect1, rect3);
        assertNotEquals(rect1, rect4);

        // Igualdad consigo mismo
        assertEquals(rect1, rect1);

        // Desigualdad con null
        assertNotEquals(null, rect1);

        // Desigualdad con objeto de diferente clase
        assertNotEquals("No soy un rectángulo", rect1);

        // Igualdad después de rotación (debe seguir siendo igual)
        rect1.turn();
        Rectangle rect5 = new Rectangle(3, 4);
        assertEquals(rect1, rect5);
    }

    @Test
    void testHashCode() {
        Rectangle rect1 = new Rectangle(4, 3);
        Rectangle rect2 = new Rectangle(4, 3);
        Rectangle rect3 = new Rectangle(5, 3);

        // HashCode debe ser igual para objetos iguales
        assertEquals(rect1.hashCode(), rect2.hashCode());

        // HashCode debe ser diferente para objetos diferentes
        assertNotEquals(rect1.hashCode(), rect3.hashCode());

        // Consistencia: múltiples llamadas deben devolver el mismo valor
        int hashCode1 = rect1.hashCode();
        int hashCode2 = rect1.hashCode();
        assertEquals(hashCode1, hashCode2);

        // Test con diferentes objetos pero mismo hashCode
        Rectangle rect4 = new Rectangle(3, 4);
        rect1.turn(); // Ahora rect1 es (3, 4)
        assertEquals(rect1.hashCode(), rect4.hashCode());
    }

    // Tests adicionales para casos especiales
    @Test
    void testConstructorWithNegativeValues() {
        // Base negativa
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(-5, 3));
        assertTrue(exception1.getMessage().contains("Error al crear el rectángulo"));

        // Altura negativa
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(5, -3));
        assertTrue(exception2.getMessage().contains("Error al crear el rectángulo"));

        // Ambos negativos
        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(-5, -3));
        assertTrue(exception3.getMessage().contains("Error al crear el rectángulo"));
    }

    @Test
    void testCopyConstructor() {
        Rectangle original = new Rectangle(7, 2);
        Rectangle copy = new Rectangle(original);

        assertEquals(original.getBase(), copy.getBase());
        assertEquals(original.getHeight(), copy.getHeight());
        assertEquals(original, copy);
        assertEquals(original.hashCode(), copy.hashCode());
    }

    @Test
    void testCopyConstructorWithNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(null));
        assertTrue(exception.getMessage().contains("Error en constructor de copia"));
    }

    @Test
    void testZeroDimensions() {
        Rectangle rect = new Rectangle(0, 0);
        assertEquals(0, rect.getBase());
        assertEquals(0, rect.getHeight());
        assertTrue(rect.isSquare());
        assertEquals(0, rect.area());
        assertEquals(0, rect.perimeter());
        assertEquals(0.0, rect.diagonal(), 0.001);
    }
}