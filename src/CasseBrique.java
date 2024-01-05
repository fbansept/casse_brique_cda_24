import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CasseBrique extends JFrame {

    public CasseBrique() {

        Salarie toto = new Salarie();
        toto.salaireAnnuel = 40000;

        Salarie tata = new Salarie();
        tata.salaireAnnuel = 50000;

        Local openspace = new Local();
        openspace.loyerParMetreCarre = 100;
        openspace.surface = 1000;

        Local garage = new Local();
        garage.loyerParMetreCarre = 50;
        garage.surface = 20;

        ArrayList<Mensualisable> listeMensualisable = new ArrayList<>();
        listeMensualisable.add(openspace);
        listeMensualisable.add(garage);
        listeMensualisable.add(toto);
        listeMensualisable.add(tata);

        int cumulCout = 0;
        for (Mensualisable mensualisable : listeMensualisable) {
            cumulCout += mensualisable.coutMensuel();
        }




        this.setSize(500,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton monBouton = new JButton("Clic moi");
        JPanel monPanneau = new JPanel();
        this.setContentPane(monPanneau);
        monPanneau.add(monBouton);
        this.setVisible(true);

        monBouton.addActionListener(new EvenementClic());
    }

    public static void main(String[] args) {

        new CasseBrique();

    }
}
