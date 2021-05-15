/*
 * Autores: Daniel Gonzalez Carrillo 20293, Marco Orozco 20857
 * Modificacion: 14/05/2021
 * Clase: Driver
 * Descripcion:
 *      Clase que crea el programa principal, la interaccion con el usuario
 *      y la creacion del diccionario.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException{

        // Definir el sistema de guarado de datos
        Scanner scan = new Scanner(System.in);

        // Crear Factory y mapa
        FactoryTrees<String, String> factory = new FactoryTrees<String, String>();
        Map<String, String> mapTree;

        // Mostrar el menu y crear las estructuras de datos
        int opcion = introMenu();
        mapTree = factory.createTree(opcion);

        // Leer el documento de texto
        try {
            FileReader f = new FileReader("Spanish.txt");
            BufferedReader r = new BufferedReader(f);
            
            String textLine;
            
            while ((textLine = r.readLine()) != null) {

                String[] worTra = textLine.split("	");

                // Crear los valores que seran añadidos al Tree
                String key = worTra[0];
                String[] traduction = worTra[1].split("[ .,;?!¡¿\'\"\\[\\]]+");
                mapTree.put(key.trim().toLowerCase(), traduction[0].toLowerCase());

            }
            
            f = new FileReader("Text.txt");
            r = new BufferedReader(f);
            
            textLine = "";
            String acu = "";
            //Traduccion
            while ((textLine = r.readLine()) != null) {
                String[] worTra = textLine.split(" ");
                for(int i = 0; i<worTra.length; i++){
                   // System.out.println(worTra[i]);
                    String temp = mapTree.get(worTra[i].trim().toLowerCase());
                    if(temp != null){
                        acu += "*" + temp + "* ";
                    }
                    else{
                        acu += worTra[i] + " ";
                    }
                }
                System.out.println("La frase traducida es:");
                System.out.println(acu);

            }


        } catch(Exception e){
            System.out.println("Error");
        }
    }

    // Menu para elegir estructura de datos
    public static int introMenu(){
        Scanner scan = new Scanner(System.in);
        String opcion;
        //Muestra de opciones.
        System.out.println("Bienvenido al diccionario computarizado!");
        System.out.println("Selecciona el tipo de estructura de datos que deseas usar");
        System.out.println("1. SplayTreeMap");
        System.out.println("2. HashTree");

        int option = 0;
        boolean verifier = false;
        while(verifier==false){
            opcion = scan.nextLine();
            try{
                //Almacenamiento de opcion
                option = Integer.parseInt(opcion);
                System.out.println(option);
                if(option != 1 && option != 2){

                    System.out.println("Uy! has elegido una opcion no valida");
                } else{
                    verifier = true;
                }
            } catch(Exception e){

                System.out.println("Uy! Has elegido un valor no numerico");
            }
        }

        return option;
    }
}
