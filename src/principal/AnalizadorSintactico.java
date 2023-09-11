/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.io.IOException;
import static principal.Terminal.IF;

/**
 *
 * @author Yair
 */
public class AnalizadorSintactico {

    private AnalizadorLexico alex;
    private IndicadorError indError;

    public AnalizadorSintactico(AnalizadorLexico alex, IndicadorError indError) {
        this.alex = alex;
        this.indError = indError;
    }

    public void analizar() throws IOException {
        alex.escanear();
        programa();
        if (alex.getSimbolo() == Terminal.EOF) {
            indError.mostrarError(0, alex.getCadena());
        } else {
            indError.mostrarError(1, alex.getCadena());
        }
    }

    private void programa() throws IOException {
        bloque();
        if (alex.getSimbolo() == Terminal.PUNTO) {
            alex.escanear();
        } else {
            indError.mostrarError(2, alex.getCadena());
        }
    }

    private void bloque() throws IOException {
        if (alex.getSimbolo() == Terminal.CONST) {
            alex.escanear();
            if(alex.getSimbolo()==Terminal.IDENTIFICADOR){
                alex.escanear();                
            }else{
                indError.mostrarError(3, alex.getCadena());
            }            
            if(alex.getSimbolo()==Terminal.IGUAL){
                alex.escanear();
            }else{
                indError.mostrarError(4, alex.getCadena());
            }            
            if(alex.getSimbolo()==Terminal.NUMERO){
                alex.escanear();
            }else{
                indError.mostrarError(5, alex.getCadena());
            }            
            while(alex.getSimbolo()==Terminal.COMA){
                alex.escanear();
                if(alex.getSimbolo()==Terminal.IDENTIFICADOR){
                    alex.escanear();                
                }else{
                    indError.mostrarError(3, alex.getCadena());
                }            
                if(alex.getSimbolo()==Terminal.IGUAL){
                    alex.escanear();
                }else{
                    indError.mostrarError(4, alex.getCadena());
                }            
                if(alex.getSimbolo()==Terminal.NUMERO){
                    alex.escanear();
                }else{
                    indError.mostrarError(5, alex.getCadena());
                }                               
            }
            if(alex.getSimbolo()==Terminal.PUNTO_Y_COMA){
                alex.escanear();
            }else{
                indError.mostrarError(6, alex.getCadena());
            }
        }
        if (alex.getSimbolo() == Terminal.VAR) {
            alex.escanear();
            if(alex.getSimbolo() == Terminal.IDENTIFICADOR){
                alex.escanear();
            }else{
                indError.mostrarError(3, alex.getCadena());
            }
            while(alex.getSimbolo()==Terminal.COMA){
                alex.escanear();
                if(alex.getSimbolo()==Terminal.IDENTIFICADOR){
                    alex.escanear();
                }else{
                    indError.mostrarError(3, alex.getCadena());
                }                
            }
            if(alex.getSimbolo()==Terminal.PUNTO_Y_COMA){
                alex.escanear();
            }else{
                indError.mostrarError(6, alex.getCadena());
            }            
        }
        while (alex.getSimbolo() == Terminal.PROCEDURE) {
            alex.escanear();
            if(alex.getSimbolo() == Terminal.IDENTIFICADOR){
                alex.escanear();
            }else{
                indError.mostrarError(3, alex.getCadena());
            }
            if(alex.getSimbolo()==Terminal.PUNTO_Y_COMA){
                alex.escanear();
            }else{
                indError.mostrarError(6, alex.getCadena());
            }
            bloque();
            if(alex.getSimbolo()==Terminal.PUNTO_Y_COMA){
                alex.escanear();
            }else{
                indError.mostrarError(6, alex.getCadena());
            }            
        }
        proposicion();
    }

    private void proposicion() throws IOException {
        switch(alex.getSimbolo()){
            case IDENTIFICADOR:
                alex.escanear();
                if(alex.getSimbolo()==Terminal.ASIGNACION_DE_VARIABLE){
                    expresion();
                }
                break;
            case CALL:
                break;
            case BEGIN:
                break;
            case IF:
                break;    
            case WHILE:
                break;
            case READLN:
                break;
            case WRITELN:
                break;
            case WRITE:
                break;
            }
    }

    private void expresion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
