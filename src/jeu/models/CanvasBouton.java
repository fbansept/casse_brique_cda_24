package jeu.models;

import java.awt.*;

public class CanvasBouton extends Rectangle {

    protected String texte = "";
    protected EvenementBouton evenement;

    public CanvasBouton(int x, int y, Color couleur, int largeur, int hauteur, String texte) {
        super(x, y, couleur, largeur, hauteur);
        this.texte = texte;
    }

    public void addEvenementBouton(EvenementBouton evenement) {
        this.evenement = evenement;
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        super.dessiner(dessin);

        dessin.setColor(Color.black);
        dessin.drawString(texte, x, y + 20);
    }

    public void clic() {
        if(evenement != null) {
            evenement.declenche();
        }
    }

    public boolean collision(int xSourie, int ySourie) {
        return xSourie > this.x
                && xSourie < this.x + this.largeur
                && ySourie > this.y
                && ySourie < this.y + this.hauteur;
    }
}
