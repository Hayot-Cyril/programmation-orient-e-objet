package projet;

import java.io.*;
import java.util.ArrayList;
public class test {

    public static void afficher(String nom, Point p) {
        System.out.print(nom + " = ");
        p.afficher();
        System.out.println();
    }

    public static void main(String[] args) {
        testPoint();
        testSegment();
        testCercle();
        testPointNomme();
        testSegmentNomme();
        testPolymorphisme();
        testSerialization();
        testStructures();
    }

    public static void testPoint() {
        // Créer et afficher un point p1
        Point p1 = new Point(3, 4);
        afficher("p1", p1);

        // Créer et afficher un point p2
        Point p2 = new Point(0, 0);
        afficher("p2", p2);

        // Créer et afficher un point p3 en utilisant le constructeur de copie
        Point p3 = new Point(p1);
        afficher("p3", p3);

        // Calculer et afficher la distance entre p1 et p2
        double d = p1.distance(p2);
        System.out.println("Distance de p1 à p2 : " + d);

        // Translater p1
        System.out.println("> p1.translater(6, -2);");
        p1.translater(6, -2);
        afficher("p1", p1);

        // Calculer et afficher la distance entre p1 et p2 après translation
        System.out.println("Distance de p1 à p2 : " + p1.distance(p2));

        // Modifier les coordonnées de p1 et afficher p1
        System.out.println("> p1.setX(0);");
        p1.setX(0);
        afficher("p1", p1);

        System.out.println("> p1.setY(10);");
        p1.setY(10);
        afficher("p1", p1);
        
        // Test d'égalité
        Point p4 = new Point(3, 4);
        System.out.println("p1 et p4 sont égaux ? " + p1.equals(p4));
        System.out.println("p1 et p2 sont égaux ? " + p1.equals(p2));
        
        // Test de clonage
        Point p5 = p1.clone();
        System.out.println("p5 est un clone de p1 : " + p5.equals(p1));
    }
    
    public static void testSegment() {
        // Créer deux points p1 et p2
        Point p1 = new Point(3, 4);
        Point p2 = new Point(9, 6);

        // Créer un segment s1 avec les points p1 et p2
        Segment s1 = new Segment(p1, p2);

        // Afficher les points extrêmes du segment
        afficher("Point extrême 1 du segment s1", s1.getP1());
        afficher("Point extrême 2 du segment s1", s1.getP2());

        // Calculer et afficher la longueur du segment s1
        double longueur = s1.getLongueur();
        System.out.println("Longueur du segment s1 : " + longueur);

        // Calculer et afficher le milieu du segment s1
        Point milieu = s1.getMilieu();
        afficher("Milieu du segment s1", milieu);
        
        // Test d'égalité
        Segment s2 = new Segment(new Point(9,6), new Point(3, 4));
        Segment s3 = new Segment(new Point(1, 1), new Point(4, 5));

        System.out.println("s1 et s2 sont égaux ? " + s1.equals(s2));
        System.out.println("s1 et s3 sont égaux ? " + s1.equals(s3));
        
        // Test de clonage
        Segment s4 = s1.clone();
        System.out.println("s4 est un clone de s1 : " + s4.equals(s1));
    }
    
    public static void testCercle() {
        // Créer un point p1 pour le centre et un point p2 pour déterminer le rayon
        Point p1 = new Point(3, 4);
        Point p2 = new Point(5, 8);

        // Créer un cercle c1 à partir d'un centre et d'un rayon
        Cercle c1 = new Cercle(p1, 5.0);
        afficher("Centre du cercle c1", c1.getCentre());
        System.out.println("Rayon du cercle c1 : " + c1.getRayon());

        // Créer un cercle c2 à partir de deux points
        Cercle c2 = new Cercle(p1, p2);
        afficher("Centre du cercle c2", c2.getCentre());
        System.out.println("Rayon du cercle c2 : " + c2.getRayon());
        
        // Test d'égalité
        Cercle c3 = new Cercle(new Point(3, 4), 5);

        System.out.println("c1 et c2 sont égaux ? " + c1.equals(c2));
        System.out.println("c1 et c3 sont égaux ? " + c1.equals(c3));
        
        // Test de clonage
        Cercle c4 = c1.clone();
        System.out.println("c4 est un clone de c1 : " + c4.equals(c1));
        
        
    }
    
    public static void testPointNomme() {
        // Créer un point nommé pn1
        PointNomme pn1 = new PointNomme(3, 4, "A");
        afficher("Point nommé pn1", pn1);
        System.out.println("Nom du point pn1 : " + pn1.getNom());

        // Créer un point nommé pn2 à partir d'un objet Point
        Point p = new Point(5, 8);
        PointNomme pn2 = new PointNomme(p, "B");
        afficher("Point nommé pn2", pn2);
        System.out.println("Nom du point pn2 : " + pn2.getNom());
    }
    
    public static void testSegmentNomme() {
        // Créer deux points p1 et p2
        Point p1 = new Point(3, 4);
        Point p2 = new Point(5, 8);

        // Créer un segment nommé sn1
        SegmentNomme sn1 = new SegmentNomme(p1, p2, "S1");
        System.out.print("Segment nommé sn1 : ");
        sn1.afficher();
        System.out.println();
        System.out.println("Nom du segment sn1 : " + sn1.getNom());
    }
    
    public static void testPolymorphisme() {
        // Créer deux points nommés pn1 et pn2
        PointNomme pn1 = new PointNomme(3, 4, "A");
        PointNomme pn2 = new PointNomme(5, 8, "B");

        // Créer un segment en utilisant des points nommés au lieu de points
        Segment s = new Segment(pn1, pn2);
        System.out.print("Segment créé avec des points nommés : ");
        s.afficher();
        System.out.println();
    }
    
    public static void testSerialization() {
        Point p1 = new Point(3, 4);

        // Sérialiser l'objet p1 dans un fichier
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("point.ser"))) {
            oos.writeObject(p1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Désérialiser l'objet p1 à partir du fichier
        Point p2 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("point.ser"))) {
            p2 = (Point) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Comparer les deux objets
        if (p2 != null) {
            System.out.println("L'objet sérialisé et désérialisé est égal à l'objet original : " + p1.equals(p2));
        } else {
            System.out.println("Erreur lors de la désérialisation");
        }
    }
    
    public static void testStructures() {
        // Créer une liste de figures
        ArrayList<Figure> liste1 = new ArrayList<>();

        // Ajouter des figures à la liste
        liste1.add(new Point(3, 4));
        liste1.add(new PointNomme(5, 8, "A"));
        liste1.add(new Segment(new Point(1, 2), new Point(3, 4)));
        liste1.add(new SegmentNomme(new PointNomme(1, 2, "B"), new PointNomme(3, 4, "C"), "S1"));
        liste1.add(new Cercle(new Point(3, 4), 5));
        liste1.add(new Cercle(new PointNomme(5, 8, "D"), new Point(3, 4)));

        // Afficher la liste de figures
        System.out.println("Liste de figures :");
        for (Figure f : liste1) {
            f.afficher();
            System.out.println();
        }

    }
}
