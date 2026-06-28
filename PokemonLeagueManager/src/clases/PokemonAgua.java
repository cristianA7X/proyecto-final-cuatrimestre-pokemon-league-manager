package clases;

public class PokemonAgua extends Pokemon implements Atacable, RecuperadorEnergia {

    public PokemonAgua(String nombre, int nivel) {
        super(nombre, "Agua", nivel);
    }

    @Override
    public void atacar(Pokemon objetivo) {
        if (this.estaDebilitado()) {
            System.out.println(this.getNombre() + " está debilitado y no puede atacar.");
            return;
        }

        if (!this.tieneEnergiaSuficiente(12)) {
            System.out.println(this.getNombre() + " no tiene suficiente energía para atacar.");
            return;
        }

        this.gastarEnergia(12);

        int danioFinal = 18;

        if (objetivo.getTipo().equals("Fuego") || objetivo instanceof PokemonFuego) {
            danioFinal += 10;
            System.out.println("¡Es un ataque súper efectivo contra el tipo Fuego!");
        }

        System.out.println(this.getNombre() + " ataca con un chorro de agua causando " + danioFinal + " de daño.");

        objetivo.recibirDanio(danioFinal);

        if (objetivo.estaDebilitado()) {
            System.out.println(objetivo.getNombre() + " se ha debilitado.");
        }
    }

    @Override
    public void recuperarEnergia() {
        if (this.estaDebilitado()) {
            System.out.println(this.getNombre() + " está debilitado y no puede recuperar energía.");
            return;
        }

        super.recuperarEnergia(20);

        System.out.println(this.getNombre() + " descansó y recuperó energía. Energía actual: " + this.getEnergia());
    }
}