package e3;

import java.util.Objects;

// Represents a rectangle
public class Rectangle {
    // Initializes a new rectangle with the values passed by parameter .
    // Throws IllegalArgumentException if a negative value is passed to any of the dimensions .

    private int base;
    private int height;

    static void main() {
        Rectangle r1 = new Rectangle(2,3);
        Rectangle r2 = new Rectangle(-9,-8);
    }

    public Rectangle ( int base , int height ) {
        try {
            setBase(base);
            setHeight(height);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error al crear el rectángulo: " + e.getMessage());
        }
    }
    // Copy constructor
    public Rectangle ( Rectangle r ) {
        try {
            if (r == null) {
                throw new IllegalArgumentException("El rectángulo no puede ser nulo");
            }
            this.base = r.base;
            this.height = r.height;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error en constructor de copia: " + e.getMessage());
        }
    }
    // Getters
    public int getBase () {
        return base;
    }
    public int getHeight () {
        return height;
    }
    // Setters . Throw IllegalArgumentException if the parameters are negative .
    public void setBase ( int base ) {
        try {
            if (base < 0) {
                throw new IllegalArgumentException("La base no puede ser negativa: " + base);
            }
            this.base = base;
        } catch (IllegalArgumentException e) {
            System.err.println("Error en setBase: " + e.getMessage());
            throw e;
        }
    }
    public void setHeight ( int height ) {
        try {
            if (height < 0) {
                throw new IllegalArgumentException("La altura no puede ser negativa: " + height);
            }
            this.height = height;
        } catch (IllegalArgumentException e) {
            System.err.println("Error en setHeight: " + e.getMessage());
            throw e;
        }
    }
    // Return true if the rectangle is a square
    public boolean isSquare () {
        return base == height;
    }
    // Calculate the area of the rectangle .
    public int area () {
        return base * height;
    }
    // Calculate the perimeter of the rectangle .
    public int perimeter () {
        return 2 * (base + height);
    }
    // Calculate the length of the diagonal
    public double diagonal () {
        return Math.sqrt(base * base + height * height);
    }
    // Turn this rectangle 90 degrees ( changing base by height ).
    public void turn () {
        int aux = base;
        base = height;
        height = aux;
    }
    // Ensure that this rectangle is oriented horizontally ( the base is greater
    // or equal than the height ).
    public void putHorizontal () {
        if (height > base) {
            turn();
        }
    }
    // Ensure that this rectangle is oriented vertically ( the height is greater
    // or equal than the base ).
    public void putVertical () {
        if (base > height) {
            turn();
        }
    }
    // Two rectangles are equal if the base and the height are the same .
    // It does not take into account if the rectangle is rotated .
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return base == rectangle.base && height == rectangle.height;
    }

    // It complies with the hashCode contract and is consistent with the equals .
    public int hashCode() {
        return Objects.hash(base, height);
    }


}