package Figuras;

public class Rombo extends Rectangulo {
    private int lado3, lado4, diagonalMayor, diagonalMenor;
    public Rombo(int lado1, int lado2, int lado3, int lado4, int diagonalMayor, int diagonalMenor) {
        super(lado1, lado2);
        this.lado3 = lado3;
        this.lado4 = lado4;
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }
    @Override
    public void calcularArea() {
        var resultado = (diagonalMayor * diagonalMenor) / 2;
        System.out.println("el area es: " + resultado);
    }
    @Override
    public void calcularPerimetro() {
        var resultado = lado1 + lado2 + lado3 + lado4;
        System.out.println("el perimetro es: " + resultado);
    }
}
