public class FiguraComposta implements Figura, Countable {

    private Figura[] figuras;

    FiguraComposta(Figura[] figuras){
        this.figuras = figuras;
    }

    @Override
    public double getArea() {
        double area = 0;
        for(int i = 0; i < figuras.length; i++){
            area += figuras[i].getArea();
        }

        return area;
    }

    @Override
    public double getPerimetro() {
        double perimetro = 0;
        for(int i = 0; i < figuras.length; i++){
            perimetro += figuras[i].getPerimetro();
        }

        return perimetro;
    }

    @Override
    public int count() {
        return figuras.length;
    }
}
