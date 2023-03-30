package projet;

import java.io.Serializable;

public class Segment extends Figure implements Cloneable, Serializable  {
	private static final long serialVersionUID = 1L;
    private Point p1; // premier point du segment
    private Point p2; // deuxième point du segment

    // a. Constructeur avec deux points
    public Segment(Point p1, Point p2) {
        this.p1 = new Point(p1); // créer une copie pour éviter les modifications accidentelles
        this.p2 = new Point(p2); // créer une copie pour éviter les modifications accidentelles
    }

    // b. Calcul de longueur
    public double getLongueur() {
        return p1.distance(p2);
    }

    // c. Calcul du milieu du segment
    public Point getMilieu() {
        double milieuX = (p1.getX() + p2.getX()) / 2;
        double milieuY = (p1.getY() + p2.getY()) / 2;
        return new Point(milieuX, milieuY);
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
    
    public void afficher() {
        System.out.print("[");
        p1.afficher();
        System.out.print(", ");
        p2.afficher();
        System.out.print("]");
    }
    
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Segment)) {
            return false;
        }
        Segment other = (Segment) obj;
        return (this.p1.equals(other.p1) && this.p2.equals(other.p2))
                || (this.p1.equals(other.p2) && this.p2.equals(other.p1));
    }
    
    public Segment clone() {
        try {
            Segment cloned = (Segment) super.clone();
            cloned.p1 = this.p1.clone();
            cloned.p2 = this.p2.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clonage non supporté", e);
        }
    }
    
    @Override
    public void translater(double dx, double dy) {
        p1.translater(dx, dy);
        p2.translater(dx, dy);
    }
    
    @Override
    public double calculerAire() {
        return 0; // un segment n'a pas d'aire
    }

    @Override
    public double calculerPerimetre() {
        return getLongueur();
    }
}
