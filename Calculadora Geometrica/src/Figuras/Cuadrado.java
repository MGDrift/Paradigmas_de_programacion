package Figuras;

public class Cuadrado implements Operaciones {

    protected int lado1;
    public Cuadrado(int lado1) {
        this.lado1 = lado1;
    }

    @Override
    public void calcularArea() {
        var resultado = lado1 * lado1;
        System.out.println("el area es: " + resultado);
    }

    @Override
    public void calcularPerimetro() {
        var resultado = lado1 * 4;
        System.out.println("el perimetro es: " + resultado);
    }
}
