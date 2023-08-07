package Figuras;

public class Circulo implements Operaciones{
    private int radio;

    public Circulo(int radio){
        this.radio = radio;
    }
    @Override
    public void calcularArea() {
        var resultado = Math.PI * Math.pow(radio, 2);
        System.out.println("el area es: " + resultado);
    }
    @Override
    public void calcularPerimetro() {
        var resultado = Math.PI * (radio * 2);
        System.out.println("el perimetro es: " + resultado);
    }
}
