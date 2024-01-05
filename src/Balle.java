import java.awt.*;

public class Balle extends Sprite{

    private int diametre;
    private int vitesseHorizontal;
    private int vitesseVertical;

    public Balle(int x, int y, int diametre) {
        this.x = x;
        this.y = y;
        this.diametre = diametre;
        this.vitesseHorizontal = 5;
        this.vitesseVertical = 4;
        this.couleur = Color.RED;
    }

    public Balle(int diametre) {
        this.diametre = diametre;
        this.x = (int)(Math.random() * CasseBrique.LARGEUR);
        this.y = (int)(Math.random() * CasseBrique.HAUTEUR);
        this.vitesseHorizontal = (int)(Math.random() * 5) + 2;
        this.vitesseVertical = (int)(Math.random() * 5) + 2;
        this.couleur = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
    }

    public void deplacement() {
        x += vitesseHorizontal;
        y += vitesseVertical;

        if(x >= CasseBrique.LARGEUR -diametre || x <= 0) {
            vitesseHorizontal = -vitesseHorizontal;
        }
        if(y >= CasseBrique.HAUTEUR -diametre || y <= 0) {
            vitesseVertical = -vitesseVertical;
        }
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x, y,  diametre, diametre);
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


}
