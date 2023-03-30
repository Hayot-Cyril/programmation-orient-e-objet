package projet;

import java.io.Serializable;

public class Point extends Figure implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
    private double x; // abscisse
    private double y; // ordonnée

    // a. Constructeur avec coordonnées x et y
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // b. Constructeur avec un autre point
    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void afficher() {
        System.out.print("(" + getX() + "," + getY() + ")");
    }

    // c. Calcul de distance
    public double distance(Point p) {
        double deltaX = p.x - this.x;
        double deltaY = p.y - this.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public void translater(double dx, double dy) {
        x += dx;
        y += dy;
    }
    
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }
    
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clonage non supporté", e);
        }
    }
    
    
    @Override
    public double calculerAire() {
        return 0.0; // un point n'a pas d'aire
    }
    
    @Override
    public double calculerPerimetre() {
        return 0.0; // un point n'a pas de périmètre
    }
}