package principal;

import java.io.FileReader;
import java.io.IOException;
import static java.lang.Character.isLetter;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) throws IOException {
        IndicadorError indError = new IndicadorError();
        AnalizadorLexico alex = new AnalizadorLexico("prueba.txt");
        AnalizadorSintactico aSint = new AnalizadorSintactico(alex, indError);
        aSint.analizar();

//                do {
//                    alex.escanear();
//                    alex.mostrar();
//                } while (alex.getSimbolo() != Terminal.EOF);
    }

}
