package clases;

public abstract class Pokemon {

    private String nombre;
    private String tipo;
    private int vida;
    private int energia;
    private int nivel;

    public Pokemon(String nombre, String tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        vida = 100;
        energia = 100;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }

    public int getEnergia() {
        return energia;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean estaDebilitado() {
        return vida <= 30;
    }

    public boolean tieneEnergiaSuficiente(int costo) {
        return energia >= costo;
    }

    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida < 30) {
            vida = 30;
        }
    }

    public void recuperarVida(int cantidad) {
        vida += cantidad;
        if (vida > 100) {
            vida = 100;
        }
    }

    public void gastarEnergia(int cantidad) {
        energia -= cantidad;
        if (energia < 0) {
            energia = 0;
        }
    }

    public void recuperarEnergia(int cantidad) {
        energia += cantidad;
        if (energia > 100) {
            energia = 100;
        }
    }

    public void subirNivel() {
        nivel++;
    }

    public void mostrarDatos() {
        System.out.println("------------------");
        System.out.println("clases.Pokemon: " + nombre);
        System.out.println("Tipo: " + tipo);
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + vida);
        System.out.println("Energia: " + energia);
    }

}
