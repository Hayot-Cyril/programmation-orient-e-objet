package projet;

public class SegmentNomme extends Segment implements Nomme {
    private String nom;

    public SegmentNomme(Point p1, Point p2, String nom) {
        super(p1, p2);
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    public void afficher() {
        System.out.print(getNom() + " [");
        getP1().afficher();
        System.out.print(", ");
        getP2().afficher();
        System.out.print("]");
    }
}