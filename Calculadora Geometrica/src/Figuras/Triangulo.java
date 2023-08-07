package Figuras;

public class Triangulo extends Rectangulo {
    private int lado3, altura;
    public Triangulo(int lado1, int lado2, int lado3, int altura) {
        super(lado1, lado2);
        this.lado3 = lado3;
        this.altura = altura;
    }
    @Override
    public void calcularArea() {
        var resultado = (lado1 * altura) / 2;
        System.out.println("el area es: " + resultado);
    }

    @Override
    public void calcularPerimetro() {
        var resultado = lado1 + lado2 + lado3;
        System.out.println("el perimetro es: " + resultado);
    }
}
