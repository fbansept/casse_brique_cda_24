package jeu;

import jeu.models.Balle;
import jeu.models.Barre;
import jeu.models.Brique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CasseBrique extends Canvas implements KeyListener {

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 600;

    protected ArrayList<Balle> listeBalle = new ArrayList<>();
    protected ArrayList<Brique> listeBrique = new ArrayList<>();


    protected Barre barre = new Barre();

    public CasseBrique() {

        JFrame fenetre = new JFrame();

        this.setSize(LARGEUR, HAUTEUR);
        this.setBounds(0,0, LARGEUR, HAUTEUR);
        this.setIgnoreRepaint(true);
        this.setFocusable(false);

        fenetre.pack();
        fenetre.setSize(LARGEUR + 20, HAUTEUR + 40);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);

        Container panneau = fenetre.getContentPane();
        panneau.add(this);


        fenetre.setVisible(true);
        this.createBufferStrategy(2);
        demarrer();
    }

    public void demarrer() {

        for(int i = 0 ; i < 3 ; i++) {
            listeBalle.add(new Balle(20));
        }

        for(int indexColonne = 0 ; indexColonne < 10 ; indexColonne++) {
            for(int indexLigne = 0 ; indexLigne < 5 ; indexLigne++) {
                listeBrique.add(new Brique(indexColonne * 50, indexLigne * 30));
            }
        }

        while(true) {

            try {

                Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();

                dessin.setColor(Color.WHITE);
                dessin.fillRect(0,0, LARGEUR, HAUTEUR);

                barre.dessiner(dessin);

                for(Brique brique : listeBrique) {
                    brique.dessiner(dessin);
                }


                for(Balle balle : listeBalle) {
                    balle.dessiner(dessin);
                    balle.deplacement();

                    //pour chaque brique, tester la collision
                    //stocker dans une liste les brique impactées
                    //apres le foreach des briques, supprimer les brique impactées

                    //Note : parce qu'on ne peut pas supprimer un element d'une liste
                    // alors qu'on parcours cette liste

                    if(barre.collision(balle)){
                        balle.setVitesseVertical(-balle.getVitesseVertical());
                    }
                }

                dessin.dispose();
                this.getBufferStrategy().show();

                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                System.out.println("processus arreté");
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        //quand la touche gauche est enfoncée
        if(e.getKeyCode() == 37) {
            barre.deplacerGauche();
        } else if (e.getKeyCode() == 39) {
            //quand la touche droite est enfoncée
            barre.deplacerDroite();
        }
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }



    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {

        new CasseBrique();

    }
}
