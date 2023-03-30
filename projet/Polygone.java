package projet;

import java.util.ArrayList;
import java.util.List;

public class Polygone extends Figure {
    private List<Point> points;

    public Polygone(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public double getPerimetre() {
        double perimetre = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size()); // permet de revenir au premier point après le dernier
            perimetre += p1.distance(p2);
        }
        return perimetre;
    }

    public double getAire() {
        double aire = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size()); // permet de revenir au premier point après le dernier
            aire += p1.getX() * p2.getY() - p2.getX() * p1.getY();
        }
        return Math.abs(aire / 2);
    }

    public boolean add(Point p) {
        points.add(p);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polygone)) return false;
        Polygone polygone = (Polygone) o;
        if (points.size() != polygone.points.size()) return false;
        for (int i = 0; i < points.size(); i++) {
            if (!points.get(i).equals(polygone.points.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return points.hashCode();
    }

    @Override
    public void translater(double dx, double dy) {
        for(Point p : points) {
            p.translater(dx, dy);
        }
    }

    @Override
    public void afficher() {
        System.out.print("Polygone [");
        for(int i=0; i<points.size(); i++) {
            System.out.print(points.get(i));
            if(i != points.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public double calculerAire() {
        // Méthode non implémentée pour un polygone général
        // Il faudrait coder une méthode spécifique pour chaque type de polygone (triangle, rectangle, etc.)
        return 0;
    }

    @Override
    public double calculerPerimetre() {

        return 0;
    }
}