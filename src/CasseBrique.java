import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CasseBrique extends Canvas implements KeyListener {

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 600;

    public CasseBrique() {

        JFrame fenetre = new JFrame();

        this.setSize(LARGEUR, HAUTEUR);
        this.setBounds(0,0, LARGEUR, HAUTEUR);
        this.setIgnoreRepaint(true);
        this.setFocusable(false);

        fenetre.pack();
        fenetre.setSize(LARGEUR, HAUTEUR);
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

        ArrayList<Balle> listeBalle = new ArrayList<>();

        Barre barre = new Barre();

        for(int i = 0 ; i < 3 ; i++) {
            listeBalle.add(new Balle(20));
        }



        while(true) {

            try {

                Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();

                dessin.setColor(Color.WHITE);
                dessin.fillRect(0,0, LARGEUR, HAUTEUR);

                barre.dessiner(dessin);

                for(Balle balle : listeBalle) {
                    balle.dessiner(dessin);
                    balle.deplacement();
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
