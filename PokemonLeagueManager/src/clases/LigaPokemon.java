package clases;

import java.util.ArrayList;

public class LigaPokemon {

    private ArrayList<Pokemon> pokemonsRegistrados;
    private ArrayList<EquipoPokemon> equiposDeCombate;
    private ArrayList<Pocion> pocionesDisponibles;
    private static LigaPokemon ligaPokemon;

    private LigaPokemon() {

        pokemonsRegistrados = new ArrayList<>();
        equiposDeCombate = new ArrayList<>();
        pocionesDisponibles = new ArrayList<>();

    }

    public static LigaPokemon getLigaPokemon()
    {
        if(ligaPokemon == null)
            ligaPokemon = new LigaPokemon();

        return ligaPokemon;
    }

    public void agregarPokemon(Pokemon pokemon) {

        pokemonsRegistrados.add(pokemon);

    }

    public void agregarEquipo(EquipoPokemon equipoPokemon)
    {
        equiposDeCombate.add(equipoPokemon);
    }

    public void agregarPokemonEquipo(Pokemon pokemon, EquipoPokemon e)
    {
        if (pokemonsRegistrados.contains(pokemon))
        {
            e.agregarAEquipo(pokemon);
        } else {
            System.out.println("Ese Pokémon no está registrado.");
        }
    }

    public void agregarPocion(Pocion pocion) {

        pocionesDisponibles.add(pocion);

    }

    public Pokemon buscarPokemon(String nombre) {

        for (Pokemon pokemon : pokemonsRegistrados) {
            if (nombre.equalsIgnoreCase(pokemon.getNombre()))
            {
                return pokemon;
            }

        }

        System.out.println("No hay registro de un pokemon con ese nombre.");
        return null;

    }

    public void mostrarPokemonsRegistrados() {

        for (Pokemon pokemon : pokemonsRegistrados) {
            pokemon.mostrarDatos();
        }

    }

    public void mostrarEquipoCombate(EquipoPokemon equipoPokemon)
    {
        equipoPokemon.motrarEquipo();
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

        return equiposDeCombate.contains(pokemon);

    }

    public void aplicarPocion(Pocion pocion, Pokemon pokemon)
    {
        pocion.curar(pokemon);
    }

    public ArrayList<Pokemon> getPokemonsRegistrados() {
        return pokemonsRegistrados;
    }

    public ArrayList<Pocion> getPocionesDisponibles() {
        return pocionesDisponibles;
    }
}
