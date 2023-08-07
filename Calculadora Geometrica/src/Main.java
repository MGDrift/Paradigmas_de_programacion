// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
/*public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Mayús+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Mayús+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }
}*/

import Figuras.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> listaFiguras = new ArrayList<>();
        listaFiguras.add("circulo");
        listaFiguras.add("cuadrado");
        listaFiguras.add("rectangulo");
        listaFiguras.add("triangulo");
        listaFiguras.add("rombo");

        int v1, v2, v3, v4, alt, dM, dm;
        String elementoBuscado = "";
        String palabraCorregida = "";
        String seleccion = "";
        String seleccionCorregida = "";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la figura: ");
        elementoBuscado = scanner.nextLine();
        palabraCorregida = elementoBuscado.toLowerCase();

        if (listaFiguras.contains(palabraCorregida)) {
            System.out.println("¿Quiere saber el area o el perimetro?");
            seleccion = scanner.nextLine();
            seleccionCorregida = seleccion.toLowerCase();
            if(seleccionCorregida.equals("area")){
                switch (palabraCorregida) {
                    case "cuadrado":
                        System.out.println("ingresa el lado");
                        v1 = scanner.nextInt();
                        Cuadrado cuadrado = new Cuadrado(v1);
                        cuadrado.calcularArea();
                        break;
                    case "rectangulo":
                        System.out.println("ingresa el primer lado");
                        v1 = scanner.nextInt();
                        System.out.println("ingresa el sengundo lado");
                        v2 = scanner.nextInt();
                        Rectangulo rectangulo = new Rectangulo(v1, v2);
                        rectangulo.calcularArea();
                        break;
                    case "triangulo":
                        System.out.println("ingresa el base");
                        v1 = scanner.nextInt();
                        System.out.println("ingresa el altura");
                        alt = scanner.nextInt();
                        Triangulo triangulo = new Triangulo(v1, 0, 0, alt);
                        triangulo.calcularArea();
                        break;
                    case "rombo":
                        System.out.println("ingresa la Diagonal mayor");
                        dM = scanner.nextInt();
                        System.out.println("ingresa la diagonal menor");
                        dm = scanner.nextInt();
                        Rombo rombo = new Rombo(0, 0, 0, 0, dM, dm);
                        rombo.calcularArea();
                        break;
                    case "circulo":
                        System.out.println("ingresa el radio");
                        v1 = scanner.nextInt();
                        Circulo circulo = new Circulo(v1);
                        circulo.calcularArea();
                        break;
                    default:
                        System.out.println("Operacion no disponible");
                        break;
                }
            }
            if(seleccionCorregida.equals("perimetro")){
                switch (palabraCorregida) {
                    case "cuadrado":
                        System.out.println("ingresa el lado");
                        v1 = scanner.nextInt();
                        Cuadrado cuadrado = new Cuadrado(v1);
                        cuadrado.calcularPerimetro();
                        break;
                    case "rectangulo":
                        System.out.println("ingresa el primer lado");
                        v1 = scanner.nextInt();
                        System.out.println("ingresa el sengundo lado");
                        v2 = scanner.nextInt();
                        Rectangulo rectangulo = new Rectangulo(v1, v2);
                        rectangulo.calcularPerimetro();
                        break;
                    case "triangulo":
                        System.out.println("ingresa el primer lado");
                        v1 = scanner.nextInt();
                        System.out.println("ingresa el segundo lado");
                        v2 = scanner.nextInt();
                        System.out.println("ingresa el tercer lado");
                        v3 = scanner.nextInt();
                        Triangulo triangulo = new Triangulo(v1, v2, v3, 0);
                        triangulo.calcularPerimetro();
                        break;
                    case "rombo":
                        System.out.println("ingresa la primer diagonal");
                        v1 = scanner.nextInt();
                        System.out.println("ngresa la segunda diagonal");
                        v2 = scanner.nextInt();
                        System.out.println("ngresa la tercera diagonal");
                        v3 = scanner.nextInt();
                        System.out.println("ngresa la cuarta diagonal");
                        v4 = scanner.nextInt();
                        Rombo rombo = new Rombo(v1, v2, v3, v4, 0, 0);
                        rombo.calcularPerimetro();
                        break;
                    case "circulo":
                        System.out.println("ingresa el radio");
                        v1 = scanner.nextInt();
                        Circulo circulo = new Circulo(v1);
                        circulo.calcularPerimetro();
                        break;
                    default:
                        System.out.println("Operacion no disponible");
                        break;
                }
            }

        }
        if(!listaFiguras.contains(palabraCorregida)) {
            System.out.println("Operación no valida.");
        }
        scanner.close();
    }
}

