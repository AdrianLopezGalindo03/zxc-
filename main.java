import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class main {
    
    public static void main(String[] args) {
        
        // int + 2*cada caracter + float
        // 4 + 2*20 + 4 = 48 bytes
        final int tamanioRegistro = 48;

        ArrayList<Prueba> Estudiantes = new ArrayList<>();
        
        // Añado mis datos a un ArrayList
        Estudiantes.add(new Prueba(1, "Adrián", 7.8f));
        Estudiantes.add(new Prueba(2, "María", 4.3f));
        Estudiantes.add(new Prueba(3, "Alfredo", 6.9f));

        try (RandomAccessFile archivo = new RandomAccessFile("estudiantes.db", "rw")) {

            // Escritura de daos
            for (Prueba estudiante : Estudiantes) {

                archivo.writeInt(estudiante.getID());

                StringBuffer sb = new StringBuffer(estudiante.getNombre());
                sb.setLength(20);

                archivo.writeChars(sb.toString());

                archivo.writeFloat(estudiante.getNota());
                
            }

            // Lectura de datos
            archivo.seek(0);
            for (int i = 0; i < 3; i++) { 
                System.out.println("ID: " + archivo.readInt());

                String nombre = "";
                for (int j = 0; j < 20; j++) nombre += archivo.readChar();
                System.out.println("Nombre: " + nombre);
                    
                System.out.println("Nota: " + archivo.readFloat());
             
                System.out.println("--------");
            }
        
            // Modificar nota
            archivo.seek(tamanioRegistro*2-Float.BYTES);
            archivo.writeFloat(9.3f);
            System.out.println("\nArchivo modificado.\n");

            archivo.seek(tamanioRegistro);           
            System.out.println("ID: " + archivo.readInt());

            String nombre = "";
            for (int j = 0; j < 20; j++) nombre += archivo.readChar();
            System.out.println("Nombre: " + nombre);
                
            System.out.println("Nota: " + archivo.readFloat());
            
            System.out.println("--------");
    
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}