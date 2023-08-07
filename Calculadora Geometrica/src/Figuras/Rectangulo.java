package Figuras;

public class Rectangulo extends Cuadrado {
    protected int lado2;
    public Rectangulo(int lado1, int lado2) {
        super(lado1);
        this.lado2 = lado2;
    }
    @Override
    public void calcularArea() {
        var resultado = lado1 * lado2;
        System.out.println("el area es: " + resultado);
    }

    @Override
    public void calcularPerimetro() {
        var resultado = (lado1 * 2) + (lado2 * 2);
        System.out.println("el perimetro es: " + resultado);
    }
}
