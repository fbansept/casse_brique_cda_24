import java.awt.*;

public class Balle {

    private int x;
    private int y;
    private int diametre;
    private int vitesseHorizontal;
    private int vitesseVertical;
    private Color couleur;

    public Balle(int x, int y, int diametre) {
        this.x = x;
        this.y = y;
        this.diametre = diametre;
        this.vitesseHorizontal = 5;
        this.vitesseVertical = 4;
        this.couleur = Color.RED;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    public int getVitesseHorizontal() {
        return vitesseHorizontal;
    }

    public void setVitesseHorizontal(int vitesseHorizontal) {
        this.vitesseHorizontal = vitesseHorizontal;
    }

    public int getVitesseVertical() {
        return vitesseVertical;
    }

    public void setVitesseVertical(int vitesseVertical) {
        this.vitesseVertical = vitesseVertical;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
