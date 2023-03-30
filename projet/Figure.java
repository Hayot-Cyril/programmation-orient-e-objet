package projet;

abstract public class Figure {
    /** Centre de la figure geometrique
     * @see Point
     */
    protected Point centre;

    public Point getCentre() {return centre;};
    
    /** Fonction de translation de la figure geometrique
     * @param dx valeur de la translation en X
     * @param dy valeur de la translation en Y
     */
    abstract public void translater(double dx, double dy);
    
    /** Fonction d'affichage de la figure geometrique.
     * A l'avenir, devrait etre une fonction graphique
     * ici juste un System.out.println()
     */
    abstract public void afficher();

    abstract public double calculerAire();

    abstract public double calculerPerimetre();
}
