import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class estudiantesAvanzado {

static final int RECORD_SIZE = 48; // Calculado como en el ejercicio anterior

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
int option;
ArrayList<Prueba> estudiantes = new ArrayList<>();

do {
System.out.println("Menú:");
System.out.println("1. Añadir estudiante");
System.out.println("2. Buscar estudiante por ID");
System.out.println("3. Modificar nota de estudiante");
System.out.println("4. Eliminar estudiante");
System.out.println("5. Listar todos los estudiantes");
System.out.println("6. Salir");
System.out.print("Elija una opción: ");

option = sc.nextInt();
switch (option) {
case 1:
añadir(sc, estudiantes);
System.out.println(estudiantes);
break;
case 2:
// TODO: Implementar buscar estudiante
break;
case 3:
// TODO: Implementar modificar estudiante
break;
case 4:
// TODO: Implementar eliminar estudiante
break;
case 5:
// TODO: Implementar listar estudiantes
break;
case 6:
System.out.println("Saliendo...");
break;
default:
System.out.println("Opción inválida.");
break;
}

} while (option != 6);

}

public static void añadir(Scanner sc, ArrayList estudiantes) {

try (RandomAccessFile archivo = new RandomAccessFile("estudiantesAvanzado.db", "rw")) {

System.out.println("Introduzca el ID del estudiante");
int ID = sc.nextInt();
archivo.writeInt(ID);

System.out.println("Introduzca el nombre del estudiante");
String nombre = sc.nextLine();
StringBuffer sb = new StringBuffer(nombre);
sb.setLength(20);
archivo.writeChars(sb.toString());

System.out.println("Introduzca la nota del estudiante");
float nota = (float)sc.nextFloat();
archivo.writeFloat(nota);
 
estudiantes.add(new Prueba(ID, nombre, nota));

} catch (IOException e) {
e.printStackTrace();
}

}

}