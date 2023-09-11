/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author Yair
 */
public class IndicadorError {

    //Solo D10S y NOS sabemos lo que hace éste código.
    //Esta clase es un switch de distintos casos de error.
    public void mostrarError(int codigo, String cadena) {
        switch (codigo) {
            case 0:
                System.out.println("Tamo Cheto mal");
                break;
            case 1:
                System.out.println("El simbolo " + cadena + " esta de mas.");
                break;
            case 2:
                System.out.println("Se esperaba un punto y se encontró " + cadena);
                break;
            case 3:
                System.out.println("Se esperaba un identificador y se encontró " + cadena);
                break;
            case 4:
                System.out.println("Se esperaba un IGUAL y se encontró " + cadena);
                break;
            case 5:
                System.out.println("Se esperaba un NUMERO y se encontró " + cadena);
                break;
            case 6:
                System.out.println("Se esperaba un PUNTO_Y_COMA y se encontró " + cadena);
                break;
            case 7:
                System.out.println("");
                break;
            case 8:
                System.out.println("");
                break;
            // errores creados por santiago
            case 20:
                System.out.println(" se esperaba un Expresion pero se encontro" + cadena);
            
        }
        System.exit(0);
    }

}
