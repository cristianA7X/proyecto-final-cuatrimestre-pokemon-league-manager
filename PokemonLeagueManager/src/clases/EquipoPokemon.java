package clases;

import java.util.ArrayList;

public class EquipoPokemon
{
    private String nombre;
    public static final int CANT_MAXIMA_POR_EQUIPOS = 3;
    public ArrayList<Pokemon> equipo;

    public EquipoPokemon(String nombre)
    {
        this.nombre = nombre;
        equipo = new ArrayList<>();
    }

    public void agregarAEquipo(Pokemon p)
    {
        if(equipo.size() >= CANT_MAXIMA_POR_EQUIPOS)
            IO.println("Se excede la cantidad maxima por equipos");
        else
        {
            equipo.add(p);
        }
    }

    public void eliminarDelEquipo(Pokemon p)
    {
        if (equipo.size() < 0)
            IO.println("No se puede tener una cantidad negativa en un equipo");
        else
        {
            equipo.remove(p);
        }
    }

    public void motrarEquipo()
    {
        if(equipo.isEmpty())
            IO.println("No hay ningún Pokemón en el equipo");
        else
        {
            IO.println("***EQUIPO POKEMON***");
            for (Pokemon pokemon : equipo)
            {
                IO.println("•" + pokemon);
            }
        }
    }
}
