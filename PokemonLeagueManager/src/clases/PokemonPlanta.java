package clases;

public class PokemonPlanta extends Pokemon implements Atacable, Curable{

    public PokemonPlanta(String nombre, int nivel) {

        super(nombre, "Planta", nivel);
    }

    @Override
    public void atacar(Pokemon objetivo) {

        int costoEnergia = 10;
        int danio = 15;

        if (estaDebilitado()) {

            System.out.println("Pokemon debilitado.");

        } else if (objetivo.estaDebilitado()) {

            System.out.println("El objetivo ya esta debilitado.");

        } else if (!tieneEnergiaSuficiente(costoEnergia)) {

            System.out.println("No tiene energia suficiente.");

        } else {

            gastarEnergia(costoEnergia);

            if (objetivo.getTipo().equalsIgnoreCase("Agua")) {
                danio += 10;
            }

            objetivo.recibirDanio(danio);

            System.out.println(getNombre() + " ataco correctamente.");

        }

    }

    @Override
    public void curar (Pokemon objetivo)
    {
        int costoEnergia = 15;
        int curacion = 20;

        if (estaDebilitado()) {
            System.out.println("Pokemon debilitado.");
        }
        else if (!tieneEnergiaSuficiente(costoEnergia)) {
            System.out.println("No tiene energia suficiente.");
        }

        else {
            objetivo.recuperarVida(curacion);
            gastarEnergia(costoEnergia);
            System.out.println(getNombre() + " curo correctamente a " + objetivo.getNombre());


        }
    }

}