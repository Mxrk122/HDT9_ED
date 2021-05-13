import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException{

        // Definir el sistema de guarado de datos
        Scanner scan = new Scanner(System.in);

        // Crear Factory y mapa
        FactoryTrees<String, Association<String,String>> factory = new FactoryTrees<String, Association<String,String>>();
        Map<String, Association<String,String>> mapTree;

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
                String traduction = worTra[1];
                Association value = new Association<String, String>(key, traduction);

                // Agregarlo a la estructura
                mapTree.put(key, value);

                // Este codigo lo pongo aca para mostrarte que funciona
                // le metes la key en el get, y eso te devuelve el association
                // Luego solo haces getValue y ya tenes la traduccion
                String traduccionPrueba = mapTree.get(key).getValue();
                System.out.println(traduccionPrueba);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Menu para elegir estructura de datos
    public static int introMenu(){
        Scanner scan = new Scanner(System.in);
        String opcion;
        System.out.println("Bienvenido al diccionario computarizado!");
        System.out.println("Selecciona el tipo de estructura de datos que deseas usar");
        System.out.println("1. SplayTreeMap");
        System.out.println("2. HashTree");

        int option = 0;
        boolean verifier = false;
        while(verifier==false){
            opcion = scan.nextLine();
            try{

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
