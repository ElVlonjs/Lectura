/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7.streams;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Valentin 
 */
public class Practica7Streams {

    /**
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException { 
        /**
         * @return
         * <p>Aqui tenemos un menu creado con un switch que nos dejara acceder a diferentes opciones del programa</p>
         * @deprecated 
         * <p>Tanto el menu como el programa estan sin terminar y algunas cosas se podrian mejorar de cara al futuro</p>
         */
        
        Scanner input = new Scanner(System.in); //Input
        boolean verdadero = true;
        // TODO code application logic 
                while (verdadero) {

            System.out.println("1.  Escritura caracter");
            System.out.println("2. Lectura caracter copia bien");
            System.out.println("3. Lectura y escritura de fichero línea a línea "
                    + "con buffers (character Streams). ");
             System.out.println("4. SALIR");


            int elecion = input.nextInt();
            switch (elecion) {
                case 1:
                 
                    Lectura_escritura_caracter.escrituracharstreams();
                    break;
                case 2:
                                      Lectura_escritura_caracter.copiabien();
                    break;
                case 3:

                    Lectura_escritura_caracter.lecturaBufferedReader();
                           
                    break;
                case 4:
                    
                default:
                    verdadero = false;
                    break;
            }
        }
        
    }
    
}
