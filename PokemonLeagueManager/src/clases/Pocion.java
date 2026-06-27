package clases;

public class Pocion implements Curable
{
    //ATRIBUTOS
    private String nombre;
    private int cantRecuperacion;

    //CONSTRUCTOR/ES
    public Pocion(String nombre, int cantRecuperacion)
    {
        this.nombre = nombre;
        this.cantRecuperacion = cantRecuperacion;
    }

    //MÉTODOS
    @Override
    public void curar(Pokemon objetivo)
    {
        objetivo.recuperarVida(cantRecuperacion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantRecuperacion() {
        return cantRecuperacion;
    }

    public void setCantRecuperacion(int cantRecuperacion) {
        this.cantRecuperacion = cantRecuperacion;
    }
}
