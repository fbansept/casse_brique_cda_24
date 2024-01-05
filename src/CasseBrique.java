import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class CasseBrique extends Canvas {

    public CasseBrique() {

        JFrame fenetre = new JFrame();

        this.setSize(500,600);
        this.setBounds(0,0,500,600);
        this.setIgnoreRepaint(true);
        this.setFocusable(false);

        fenetre.pack();
        fenetre.setSize(500,600);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.requestFocus();

        Container panneau = fenetre.getContentPane();
        panneau.add(this);


        fenetre.setVisible(true);
        this.createBufferStrategy(2);
        demarrer();
    }

    public void demarrer() {

        Balle balle = new Balle(200,300,20);

        while(true) {

            try {

                Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();

                dessin.setColor(Color.WHITE);
                dessin.fillRect(0,0,500,600);

                dessin.setColor(Color.RED);
                dessin.fillOval(balle.getX(), balle.getY(),  balle.getDiametre(), balle.getDiametre());
                xBalle += vitesseHorizontal;
                yBalle += vitesseVertical;

                if(xBalle >= 500 -20 || xBalle <= 0) {
                    vitesseHorizontal = -vitesseHorizontal;
                }
                if(yBalle >= 600 -20 || yBalle <= 0) {
                    vitesseVertical = -vitesseVertical;
                }

                dessin.dispose();
                this.getBufferStrategy().show();

                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                System.out.println("processus arreté");
            }
        }
    }

    public static void main(String[] args) {

        new CasseBrique();

    }
}
