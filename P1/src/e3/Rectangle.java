package e3;

// Represents a rectangle
public class Rectangle {
    // Initializes a new rectangle with the values passed by parameter .
// Throws IllegalArgumentException if a a negative value is passed to any of
// the dimensions .
    public Rectangle ( int base , int height ) { }
    // Copy constructor
    public Rectangle ( Rectangle r ) { }
    // Getters
    public int getBase () { }
    public int getHeight () { }
    // Setters . Throw IllegalArgumentException if the parameters are negative .
    public void setBase ( int base ) { }
    public void setHeight ( int height ) { }
    // Return true if the rectangle is a square
    public boolean isSquare () { }
    // Calculate the area of the rectangle .
    public int area () { }
    // Calculate the perimeter of the rectangle .
    public int perimeter () { }
    // Calculate the length of the diagonal
    public double diagonal () { }
    // Turn this rectangle 90 degrees ( changing base by height ).
    public void turn () { }
    // Ensure that this rectangle is oriented horizontally ( the base is greater
// or equal than the height ).
    public void putHorizontal () { }
    // Ensure that this rectangle is oriented vertically ( the height is greater
// or equal than the base ).
    public void putVertical () { }
    // Two rectangles are equal if the base and the height are the same .
// It does not take into account if the rectangle is rotated .
    public boolean equals ( Object obj ) { }
    // It complies with the hashCode contract and is consistent with the equals .
    public int hashCode () { }
}