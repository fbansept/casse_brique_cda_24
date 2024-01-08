import java.awt.*;

public class Barre extends Rectangle {

    public Barre() {
        super(
                0,
                CasseBrique.HAUTEUR - 100,
                Color.BLUE,
                200,
                20
        );

        this.x = CasseBrique.LARGEUR / 2 - this.largeur / 2;
    }
}
