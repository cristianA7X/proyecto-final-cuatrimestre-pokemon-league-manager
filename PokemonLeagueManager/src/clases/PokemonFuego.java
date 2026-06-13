package clases;

public class PokemonFuego extends Pokemon implements Atacable {

    public PokemonFuego(String nombre, int nivel) {

        super(nombre, "Fuego", nivel);

    }

    @Override
    public void atacar(Pokemon objetivo) {

        int costoEnergia = 15;
        int danio = 20;

        if (estaDebilitado()) {

            System.out.println("clases.Pokemon debilitado.");

        } else if (objetivo.estaDebilitado()) {

            System.out.println("El objetivo ya esta debilitado.");

        } else if (!tieneEnergiaSuficiente(costoEnergia)) {

            System.out.println("No tiene energia suficiente.");

        } else {

            gastarEnergia(costoEnergia);

            if (objetivo.getTipo().equalsIgnoreCase("Planta")) {
                danio += 10;
            }

            objetivo.recibirDanio(danio);

            System.out.println(getNombre() + " ataco correctamente.");

        }

    }

}
