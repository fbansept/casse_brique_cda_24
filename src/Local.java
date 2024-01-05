public class Local implements Mensualisable {
    int surface;
    int loyerParMetreCarre;

    @Override
    public int coutMensuel() {
        return surface * loyerParMetreCarre;
    }
}
