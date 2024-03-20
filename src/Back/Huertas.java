package Back;

public class Huertas {
    String nombre;

    int ancho;

    int largo;

    int area;

    

    public Huertas(String nombre, int ancho, int largo) {
        this.nombre = nombre;
        this.ancho = ancho;
        this.largo = largo;
        this.area = ancho*largo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }

    public int getArea() {
        return area;
    }

    public String toCVS(){
        return nombre + "," + ancho + "," + largo + "," + area;
    }


}
