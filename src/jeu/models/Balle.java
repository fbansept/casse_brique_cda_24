package jeu.models;

import jeu.CasseBrique;

import java.awt.*;

public class Balle extends Rond{

    private int vitesseHorizontal;
    private int vitesseVertical;

    public Balle(int x, int y, int diametre) {
        super(x, y, Color.RED, diametre);
        this.diametre = diametre;
        this.vitesseHorizontal = 5;
        this.vitesseVertical = 4;
    }

    public Balle(int diametre) {
        super(
                (int)(Math.random() * CasseBrique.LARGEUR),
                (int)(Math.random() * CasseBrique.HAUTEUR),
                new Color((float)Math.random(),(float)Math.random(),(float)Math.random()),
                diametre
        );

        this.vitesseHorizontal = (int)(Math.random() * 5) + 2;
        this.vitesseVertical = (int)(Math.random() * 5) + 2;
    }

    public int getCentreX() {
        return x + diametre / 2;
    }

    public int getCentreY() {
        return y + diametre / 2;
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
