package jeu;

import jeu.models.Balle;
import jeu.models.Barre;
import jeu.models.Brique;
import jeu.models.CanvasBouton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CasseBrique extends Canvas implements KeyListener, MouseListener {

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 600;

    protected ArrayList<Balle> listeBalle = new ArrayList<>();
    protected ArrayList<Brique> listeBrique = new ArrayList<>();
    protected ArrayList<CanvasBouton> listeBouton = new ArrayList<>();

    protected Barre barre = new Barre();

    protected boolean pause = false;

    public CasseBrique() {

        JFrame fenetre = new JFrame();

        this.setSize(LARGEUR, HAUTEUR);
        this.setBounds(0, 0, LARGEUR, HAUTEUR);
        this.setIgnoreRepaint(true);
        this.setFocusable(false);

        fenetre.pack();
        fenetre.setSize(LARGEUR + 20, HAUTEUR + 40);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);
        addMouseListener(this);

        Container panneau = fenetre.getContentPane();
        panneau.add(this);

        fenetre.setVisible(true);
        this.createBufferStrategy(2);


        CanvasBouton boutonPause = new CanvasBouton(
                20, 20, Color.BLUE, 50, 40, "PAUSE");

        boutonPause.addEvenementBouton(() -> {
            pause = !pause;
        });

        CanvasBouton boutonRecommencer = new CanvasBouton(
                150, 20, Color.BLUE, 100, 40, "RECOMMENCER");

        boutonRecommencer.addEvenementBouton(() -> {
            recommencer();
        });

        listeBouton.add(boutonPause);
        listeBouton.add(boutonRecommencer);

        recommencer();
        demarrer();
    }

    public void recommencer() {

        pause = false;
        listeBalle.clear();
        listeBrique.clear();

        for (int i = 0; i < 3; i++) {
            listeBalle.add(new Balle(20));
        }

        for (int indexColonne = 0; indexColonne < 10; indexColonne++) {
            for (int indexLigne = 0; indexLigne < 5; indexLigne++) {
                listeBrique.add(new Brique(indexColonne * 50, indexLigne * 30));
            }
        }

    }

    public void demarrer() {

        while (true) {
            try {
                Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();
                if (!pause) {
                    dessin.setColor(Color.WHITE);
                    dessin.fillRect(0, 0, LARGEUR, HAUTEUR);

                    barre.dessiner(dessin);

                    for (Brique brique : listeBrique) {
                        brique.dessiner(dessin);
                    }

                    for (Balle balle : listeBalle) {
                        balle.dessiner(dessin);
                        balle.deplacement();

                        ArrayList<Brique> briqueAsupprimer = new ArrayList<>();

                        //pour chaque brique, tester la collision
                        for (Brique brique : listeBrique) {
                            if(brique.collision(balle)){
                                briqueAsupprimer.add(brique);
                                balle.setVitesseVertical(-balle.getVitesseVertical());
                            }
                        }

                        for (Brique brique : briqueAsupprimer) {
                            listeBrique.remove(brique);
                        }

                        if (barre.collision(balle)) {
                            balle.setVitesseVertical(-balle.getVitesseVertical());
                        }
                    }

                    for (CanvasBouton bouton : listeBouton) {
                        bouton.dessiner(dessin);
                    }

                    dessin.dispose();
                    this.getBufferStrategy().show();

                    Thread.sleep(1000 / 60);

                }
            } catch (InterruptedException e) {
                System.out.println("processus arreté");
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        //quand la touche gauche est enfoncée
        if (e.getKeyCode() == 37) {
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

    @Override
    public void mouseClicked(MouseEvent e) {
        for (CanvasBouton bouton : listeBouton) {
            if (bouton.collision(e.getX(), e.getY())) {
                bouton.clic();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
