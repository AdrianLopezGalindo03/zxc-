public class Prueba {

    private int ID;
    private String nombre;
    private float nota;

    public Prueba(int iD, String nombre, float nota) {
        ID = iD;
        this.nombre = nombre;
        this.nota = nota;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
}