package clases;

public class PokemonELectrico extends Pokemon implements Atacable, Entrenable {

    public PokemonELectrico(String nombre, int nivel) {

        super(nombre, "Electrico", nivel);

    }

    @Override
    public void atacar(Pokemon objetivo) {

        int costoEnergia = 8;
        int danio = 14;

    if (!tieneEnergiaSuficiente(costoEnergia)) {

        System.out.println("No tiene energia suficiente.");

    } else {

        objetivo.recibirDanio(danio);

        gastarEnergia(costoEnergia);

        System.out.println(getNombre() + " atacó a " + objetivo.getNombre() + " le hizo " + danio + "de daño.");
    }

        if (objetivo.getTipo().equalsIgnoreCase("Agua")) {
            danio += 10;
        }

        objetivo.recibirDanio(danio);

        gastarEnergia(costoEnergia);

        System.out.println(getNombre() + " ataco correctamente.");




    }

    @Override
    public void entrenar() {

        if (estaDebilitado()) {
            System.out.println(getNombre() + " no puede entrenar porque está debilitado.");
            return;
        }

        subirNivel();
        recuperarEnergia(10);

        System.out.println(getNombre() + " entrenó: subió 1 nivel y recuperó 10 de energía.");
    }
}




