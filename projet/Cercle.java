package projet;

import java.io.Serializable;

public class Cercle extends Figure implements Cloneable, Serializable{
	private static final long serialVersionUID = 1L;
    private Point centre; // centre du cercle
    private double rayon; // rayon du cercle

    // a. Constructeur avec un centre et un rayon
    public Cercle(Point centre, double rayon) {
        this.centre = new Point(centre); // créer une copie pour éviter les modifications accidentelles
        this.rayon = rayon;
    }

    // b. Constructeur avec deux points
    public Cercle(Point p1, Point p2) {
        this.centre = new Point(p1); // créer une copie pour éviter les modifications accidentelles
        this.rayon = p1.distance(p2);
    }

    public Point getCentre() {
        return centre;
    }

    public double getRayon() {
        return rayon;
    }
    
    public void afficher() {
        System.out.print("Cercle(centre = ");
        centre.afficher();
        System.out.print(", rayon = " + rayon + ")");
    }
    
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cercle)) {
            return false;
        }
        Cercle other = (Cercle) obj;
        return this.centre.equals(other.centre) && this.rayon == other.rayon;
    }
    
    public Cercle clone() {
        try {
            Cercle cloned = (Cercle) super.clone();
            cloned.centre = this.centre.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clonage non supporté", e);
        }
    }
    public void translater(double dx, double dy) {
        centre.translater(dx, dy);
    }
    
    public double calculerAire() {
        return Math.PI * rayon * rayon;
    }
    
    public double calculerPerimetre() {
        return 2 * Math.PI * rayon;
    }
}
