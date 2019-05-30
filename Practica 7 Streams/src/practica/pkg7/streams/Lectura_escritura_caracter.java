/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Valentin
 */
public class Lectura_escritura_caracter {

    static Scanner input = new Scanner(System.in);

    /**
     * 
     * @throws IOException <p>En este metodo probaremos la lectura de streams caracter a caracter</p>
     */
    public static void lecturacharstreams() throws IOException {
// Define el archivo a usar
        File archivoEntrada = new File("fuente.txt");
// Instancia un FileReader que se encargara de leer del
//archivo
        FileReader lector = new FileReader(archivoEntrada);
// Declara una variable que contendrá el caracter a leer
        int unCaracter;
// Lee el archivo e informa
        while ((unCaracter = lector.read()) != -1) {

            System.out.print((char) unCaracter);
        }
// Cierra el archivo
        lector.close();
    }
 
    
    /**
     * 
     * @throws IOException <p>Aqui probaremos la escritura con streams</p>
     */
    public static void escrituracharstreams() throws IOException {
        Scanner input = new Scanner(System.in); //Input
        File archivoSalida = new File("destino.txt");
// Instancia un FileWriter que se encargara de escribir
        FileWriter escritor = new FileWriter(archivoSalida);
// Construye una cadena de caracteres a ser guardada en el
//archivo
        System.out.println("Escribe algo: ");

        String info = input.nextLine();
// Escribe el archivo con la informacion
        for (int i = 0; i < info.length(); i++) {
            escritor.write(info.charAt(i));
        }
// Cierra el stream
        escritor.close();
// Informa que el archivo ha sido escrito
        System.out.println("El archivo ha sido escrito...");

    }

    /**
     * 
     * @throws IOException 
     * <p>Primero de todo en este metodo tendremos una lista con la informacion que se aplicara automaticamente cuando sea necesario,
     * Como podemos observar tambien hay diferentes strings que nos daran formato pero con lineas, por lo demas el programa leera y reescribira 
     * construyendo Buffer Reader/Writer, Declara una variable que contendrá el caracter a leer y Lee el archivo e informa, finalemente reescribe 
     * en el formato deseado</p>
     */
    public static void lecturaBufferedReader() throws IOException {
        String info[] = {"Año: ", "Director: ", "Duracion: ", "Sinopsis: ", "Reparto: ", "Sesion: "};
        int cuenta = 0;
        String saltoLinea = System.getProperty("line.separator");
        String formatpelicula = "----------";
        String formatpelicula2 = "\n\n----------";
        // Instancia un objeto File de entrada
        File archivoEntrada = new File(input.next());
        File archivoSalida = new File(input.next());
        // Construye un BufferedReader
        BufferedReader reader = new BufferedReader(new FileReader(archivoEntrada));
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida));
        // Defino variables
        boolean eof = false;
        String lineaLeida = "";
        String[] broken_text = null;
        // Lee el archivoEntrada de forma eficiente e imprime los datos en pantalla
        while (!eof) {
            // Lee una linea entera
            lineaLeida = reader.readLine();//una vez leída la línea la podemos partir con el método split, suele ser muy útil
            // Imprime la linea en pantalla
            if (lineaLeida != null) {
                broken_text = lineaLeida.split(" ");
            } // Si llego al final del archivo, termina la ejecución
            else {
                eof = true;
            }
        }
        System.out.print(formatpelicula);
        try {
            writer.write(formatpelicula);
            for (int i = 0; i < broken_text.length; i++) {
                for (int j = 0; j < broken_text[i].length(); j++) {
                    // Declara una variable que contendrá el caracter a leer
                    // Lee el archivo e informa
                    char x = broken_text[i].charAt(j);
                    if (x == '#') {
                        if (cuenta == 0) {
                            System.out.println("----------");
                            writer.write(formatpelicula);
                        }
                        System.out.print("\n" + info[cuenta]);
                        writer.write(saltoLinea);
                        writer.write(info[cuenta]);
                        cuenta++;

                    } else if (x == '{') {
                        System.out.print("\n\n----------");
                        writer.write(formatpelicula2);
                        cuenta = 0;
                    } else {
                        if (j == 0 && i != 0) {
                            System.out.print(" " + x);
                            writer.write(" " + x);
                        } else {
                            System.out.print(x);
                            writer.write(x);
                        }
                    }
                }
            }
        } catch (Exception e) {

        }

        // Cierra el FileReader
        System.out.println();
        reader.close();
        writer.close();
    }
    
    
    /**
     * 
     * @throws IOException <p>Nos devuelve cualquier error de tipo IO en la lectura/escritura del objeto,
     * Tambien lo que conseguiremos es que con un archivo de entrada que tenga un formato lo convierta en el 
     * formato deseado iendo caracter a caracter, tambien  da formato de lineas gracias a los strings, cotrola donde deberia ir 
     * cada palabra de la lista gracias a un contador llamado "cuenta"</p>
     */
    

    public static void copiabien() throws IOException {

        File archivoEntrada = new File("fuente.txt");
        File archivoSalida = new File("destino.txt");

        FileReader lector = new FileReader(archivoEntrada);
        FileWriter escritor = new FileWriter(archivoSalida);
        int unCaracter;
        int cuenta = 0;

        String saltoLinea = System.getProperty("line.separator");
        String linea = "-----------------------------------------\n";
        String cartelera = "Cartelera Cinefbmoll";
        String linea2 = "--------";

        String info[] = {"Año: ", "Director: ", "Duracion: ", "Sinopsis: ", "Reparto: ", "Sesion: "};

        escritor.write(linea);
        escritor.write(saltoLinea);
        escritor.write(cartelera);
        escritor.write(saltoLinea);
        escritor.write(saltoLinea);
        escritor.write(linea);
        escritor.write(saltoLinea);
        escritor.write(linea2);

        while ((unCaracter = lector.read()) != -1) {
            char x = (char) unCaracter;
            if (x == '{') {
                escritor.write(saltoLinea);
                cuenta = 0;
                escritor.write(saltoLinea + linea2);

            } else if (x == '#') {
                if (cuenta == 0) {
                    escritor.write(linea2);

                }

                escritor.write(saltoLinea);
                escritor.write(info[cuenta]);
                cuenta++;

            } else {
                escritor.write(unCaracter);
            }

        }

        lector.close();
        escritor.close();

    }
    
    
    

}
