package projet;

public class PointNomme extends Point implements Nomme {
	
	private String nom;

    public PointNomme(double x, double y, String nom) {
        super(x, y);
        this.nom = nom;
    }

    public PointNomme(Point point, String nom) {
        super(point.getX(), point.getY());
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void afficher() {
        System.out.print(getNom() + " (" + getX() + "," + getY() + ")");
    }
}