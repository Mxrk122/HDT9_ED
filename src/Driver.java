import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws IOException{
            Scanner scan = new Scanner(System.in);
            // Leer el documento de texto
            try {
                FileReader f = new FileReader("Text.txt");
                BufferedReader r = new BufferedReader(f);

                String textLine;

                while ((textLine = r.readLine()) != null) {
                    System.out.println(textLine);
                }

            } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
