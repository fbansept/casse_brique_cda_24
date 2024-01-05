public class Salarie implements Mensualisable{
    int salaireAnnuel;

    @Override
    public int coutMensuel() {
        return salaireAnnuel / 12;
    }
}
