package clases;

import java.util.ArrayList;

public class LigaPokemon {

    private ArrayList<Pokemon> pokemonsRegistrados;
    private ArrayList<Pokemon> equipoDeCombate;
    private ArrayList<Pocion> pocionesDisponibles;

    public LigaPokemon() {

        pokemonsRegistrados = new ArrayList<>();
        equipoDeCombate = new ArrayList<>();
        pocionesDisponibles = new ArrayList<>();

    }

    public void agregarPokemon(Pokemon pokemon) {

        pokemonsRegistrados.add(pokemon);

    }

    public void agregarPokemonEquipo(Pokemon pokemon) {

        if (pokemonsRegistrados.contains(pokemon)) {
            equipoDeCombate.add(pokemon);
        } else {
            System.out.println("Ese Pokémon no está registrado.");
        }
    }

    public void agregarPocion(Pocion pocion) {

        pocionesDisponibles.add(pocion);

    }

    public Pokemon buscarPokemon(String nombre) {

        for (Pokemon pokemon : pokemonsRegistrados) {
            if (pokemon.getNombre().equalsIgnoreCase(nombre)) {
                return pokemon;
            }else {
                System.out.println("No hay registro de un pokemon con ese nombre.");
            }
        }

        return null;

    }

    public void mostrarPokemonsRegistrados() {

        for (Pokemon pokemon : pokemonsRegistrados) {
            pokemon.mostrarDatos();
        }

    }

    public void mostrarEquipoCombate() {

        for (Pokemon pokemon : equipoDeCombate){
            pokemon.mostrarDatos();
        }

    }

    public void mostrarPociones() {

        for (Pocion pocion : pocionesDisponibles){
            System.out.println(pocion);
        }

    }

    public void mostrarPokemonsActivos() {

        for (Pokemon pokemon : pokemonsRegistrados){
            if(!pokemon.estaDebilitado()){
                pokemon.mostrarDatos();
            }
        }
    }

    public void mostrarPokemonsDebilitados() {

        for (Pokemon pokemon : pokemonsRegistrados){
            if(pokemon.estaDebilitado()){
                pokemon.mostrarDatos();
            }
        }
    }

    public int contarPokemonsRegistrados() {

        return pokemonsRegistrados.size();

    }

    public boolean perteneceEquipo(Pokemon pokemon) {

        return equipoDeCombate.contains(pokemon);

    }

    public void aplicarPocion() {

        //completar

    }

}
