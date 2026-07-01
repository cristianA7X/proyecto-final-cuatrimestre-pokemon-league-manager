import clases.*;
import java.util.Random;

void main()
{
    LigaPokemon liga = null;
    EquipoPokemon equipoJugador = null;
    EquipoPokemon equipoRival = null;
    int opcion = 0;

    IO.println("=== BIENVENIDO A LA LIGA POKÉMON ===");

    while (opcion != 12)
    {
        try
        {
            IO.println("\n--- MENÚ PRINCIPAL ---");
            IO.println("1. Crear la liga.");
            IO.println("2. Registrar Pokemon.");
            IO.println("3. Agregar Pokemon al equipo de combate.");
            IO.println("4. Mostrar Pokemon registrados.");
            IO.println("5. Mostrar equipo de combate.");
            IO.println("6. Buscar Pokemon por nombre.");
            IO.println("7. Realizar combate entre Pokemon del equipo.");
            IO.println("8. Aplicar acción especial.");
            IO.println("9. Aplicar una Pocion.");
            IO.println("10. Mostrar Pokemon debilitados.");
            IO.println("11. Agregar pocion.");
            IO.println("12. Salir.");
            opcion = Integer.parseInt(IO.readln("Elija una opción (1-11): "));
            IO.println("*******************");
            IO.println();
            IO.println();


            switch (opcion) {
                case 1:
                    if (liga == null){
                        liga = LigaPokemon.getLigaPokemon();
                        equipoJugador = new EquipoPokemon("Equipo Jugador 1");
                        equipoRival = new EquipoPokemon("Equipo Rival / CPU");
                        IO.println("¡Liga Pokémon y equipos creados con éxito!");
                    }
                    else {
                        IO.println("La liga pokemon ya fue creada");
                    }
                    break;

                case 2:
                    try
                    {
                        if (liga == null)
                        {
                            IO.println("Primero debes crear la liga (Opción 1).");
                            break;
                        }
                        IO.println("¿Qué tipo de Pokémon deseas registrar?");
                        IO.println("1. Fuego \n2. Agua  \n3. Eléctrico \n4. Planta");
                        int tipo = Integer.parseInt(IO.readln("Elige el tipo: "));
                        String nombre = IO.readln("Nombre del Pokémon: ");
                        int nivel = Integer.parseInt(IO.readln("Nivel del Pokémon: "));

                        Pokemon nuevoPokemon = null;
                        if (tipo == 1) {
                            nuevoPokemon = new PokemonFuego(nombre, nivel);
                        } else if (tipo == 2) {
                            nuevoPokemon = new PokemonAgua(nombre, nivel);
                        } else if (tipo == 3) {
                            nuevoPokemon = new PokemonELectrico(nombre, nivel);
                        } else if(tipo == 4) {
                            nuevoPokemon = new PokemonPlanta(nombre, nivel);
                        }
                        else {
                            IO.println("Tipo inválido. Cancelando registro.");
                        }

                        if (nuevoPokemon != null) {
                            agregarPokemon(liga, nuevoPokemon);
                            IO.println(nombre + " registrado exitosamente en la Liga.");
                        }
                        break;
                    }
                    catch (NumberFormatException e)
                    {
                        System.err.println("Debes elegir un numero");
                        IO.println();
                    }
                case 3:
                    if (liga == null) {
                        IO.println("Primero debes crear la liga (Opción 1).");
                        break;
                    }
                    String nombreAg = IO.readln("Nombre del Pokémon a agregar al equipo: ");
                    Pokemon pAgregar = liga.buscarPokemon(nombreAg);
                    if (pAgregar != null) {
                        IO.println("¿A qué equipo deseas agregarlo?");
                        IO.println("1. Equipo Jugador 1");
                        IO.println("2. Equipo Rival / CPU");
                        int numEq = Integer.parseInt(IO.readln("Opción: "));

                        if (numEq == 1) {
                            liga.agregarPokemonEquipo(pAgregar, equipoJugador);
                            IO.println("Agregado al Equipo 1.");
                        } else if (numEq == 2) {
                            liga.agregarPokemonEquipo(pAgregar, equipoRival);
                            IO.println("Agregado al Equipo 2.");
                        }
                    }
                    break;

                case 4:
                    if (liga != null) mostrarPokemonesRegistrados(liga);
                    else IO.println("Crea la liga primero.");
                    break;

                case 5:
                    if (equipoJugador != null) {
                        IO.println("\n--- EQUIPO 1 ---");
                        mostrarEquipoDeCombate(equipoJugador);
                        IO.println("\n--- EQUIPO RIVAL ---");
                        mostrarEquipoDeCombate(equipoRival);
                    } else {
                        IO.println("Crea la liga primero.");
                    }
                    break;

                case 6:
                    if (liga != null) buscarPokemonPorNombre(liga);
                    else IO.println("Crea la liga primero.");
                    break;

                case 7:
                    if (liga != null && equipoJugador != null && equipoRival != null) {
                        if (equipoJugador.equipo.isEmpty() || equipoRival.equipo.isEmpty()) {
                            IO.println("Ambos equipos deben tener al menos un Pokémon para combatir.");
                        } else {
                            String modo = IO.readln("¿Deseas jugar contra la CPU? (1 para SÍ, 2 para jugar contra un amigo): ");
                            boolean vsCpu = modo.equals("1");
                            simularCombate(equipoJugador, equipoRival, vsCpu, liga); // El método grande que hicimos
                        }
                    } else {
                        IO.println("Asegúrate de crear la liga y los equipos primero.");
                    }
                    break;

                case 8:
                    if (liga != null) aplicarAccionEspecial(liga);
                    else IO.println("Crea la liga primero.");
                    break;

                case 9:
                    if (liga != null) aplicarUnaPocion(liga);
                    else IO.println("Crea la liga primero.");
                    break;

                case 10:
                    if (liga != null) mostrarPokemonDebilitados(liga);
                    else IO.println("Crea la liga primero.");
                    break;

                case 11:
                    if(liga != null)
                        agregarPocionALiga(liga);
                    else
                        IO.println("Crea la liga primero.");
                    break;
                case 12:
                    IO.println("Saliendo del Pokemon League Manager... ¡Hasta la próxima!");
                    break;

                default:
                    IO.println("Opción incorrecta. Por favor elige un número del 1 al 11.");
                    break;
            }
        }
        catch(NumberFormatException ex)
        {
            System.err.println("Debes elegir un numero");
            IO.println("");
        }
    }
}


void agregarPokemon(LigaPokemon ligaPokemon, Pokemon pokemon)
{
    ligaPokemon.agregarPokemon(pokemon);
}

void mostrarPokemonesRegistrados(LigaPokemon ligaPokemon)
{
    ligaPokemon.mostrarPokemonsRegistrados();
}

void mostrarEquipoDeCombate(EquipoPokemon equipoPokemon)
{
    equipoPokemon.motrarEquipo();
}

void buscarPokemonPorNombre(LigaPokemon ligaPokemon) {
    String nombre = IO.readln("Ingrese el nombre del Pokémon que quiere buscar: ");
    Pokemon p = ligaPokemon.buscarPokemon(nombre);

    if (p != null) {
        IO.println("¡Pokémon encontrado!");
        p.mostrarDatos();
    }
}

boolean hayPokemonsVivos(EquipoPokemon equipo) {
    for (Pokemon p : equipo.equipo) {
        if (!p.estaDebilitado()) {
            return true;
        }
    }
    return false;
}

Pokemon obtenerPrimerPokemonVivo(EquipoPokemon equipo) {
    for (Pokemon p : equipo.equipo) {
        if (!p.estaDebilitado()) {
            return p;
        }
    }
    return null;
}

Pokemon forzarCambioPokemon(EquipoPokemon equipo, boolean esCpu, String nombreJugador) {
    IO.println("\nEl equipo de " + nombreJugador + " debe elegir un nuevo Pokémon.");

    if (esCpu) {
        Pokemon nuevo = obtenerPrimerPokemonVivo(equipo);
        IO.println("La CPU envía a " + nuevo.getNombre());
        return nuevo;
    }

    while (true) {
        IO.println("Selecciona el índice del Pokémon a enviar (0 a " + (equipo.equipo.size() - 1) + "):");
        equipo.motrarEquipo();

        try {
            int indice = Integer.parseInt(IO.readln("Índice: "));

            if (indice >= 0 && indice < equipo.equipo.size()) {
                Pokemon seleccionado = equipo.equipo.get(indice);
                if (!seleccionado.estaDebilitado()) {
                    IO.println("¡Ve, " + seleccionado.getNombre() + "!");
                    return seleccionado;
                } else {
                    IO.println("Ese Pokémon está debilitado. Elige otro.");
                }
            } else {
                IO.println("Índice inválido. Por favor, elige un número de la lista.");
            }
        } catch (NumberFormatException e) {
            IO.println("Error: Debes ingresar un número válido.");
        }
    }
}

void simularCombate(EquipoPokemon equipo1, EquipoPokemon equipo2, boolean vsCpu, LigaPokemon liga) {
    IO.println("\n=== ¡COMIENZA EL COMBATE EN LA LIGA POKÉMON! ===");

    Pokemon activoP1 = obtenerPrimerPokemonVivo(equipo1);
    Pokemon activoP2 = obtenerPrimerPokemonVivo(equipo2);

    if (activoP1 == null || activoP2 == null) {
        IO.println("Ambos equipos deben tener al menos un Pokémon apto para combatir.");
        return;
    }

    boolean turnoJugador1 = true;
    var random = new Random();

    while (hayPokemonsVivos(equipo1) && hayPokemonsVivos(equipo2))
    {
        Pokemon atacante = turnoJugador1 ? activoP1 : activoP2;
        Pokemon defensor = turnoJugador1 ? activoP2 : activoP1;
        String nombreJugador = turnoJugador1 ? "Jugador 1" : (vsCpu ? "CPU" : "Jugador 2");

        IO.println("\n------------------------------------------------");
        IO.println("Turno de " + nombreJugador);
        IO.println("Activo: " + atacante.getNombre() + " (Vida: " + atacante.getVida() + " | Energía: " + atacante.getEnergia() + ")");
        IO.println("Rival : " + defensor.getNombre() + " (Vida: " + defensor.getVida() + ")");
        IO.println("------------------------------------------------");

        int accion = 0;

        // Decidimos si juega la CPU o pide input al usuario
        if (!turnoJugador1 && vsCpu) {
            IO.println("La CPU está decidiendo al azar...");
            accion = random.nextInt(4) + 1; // Genera un número del 1 al 4
        } else {
            IO.println("1. Atacar");
            IO.println("2. Usar Habilidad de Apoyo (Entrenar/Curar/Recuperar)");
            IO.println("3. Usar Poción");
            IO.println("4. Cambiar Pokémon");

            try {
                accion = Integer.parseInt(IO.readln("Elige una acción (1-4): "));
            } catch (NumberFormatException e) {
                IO.println("Entrada no reconocida.");
                accion = 0;
            }
        }

        // Ejecutamos la acción elegida
        switch (accion) {
            case 1:
                if (atacante instanceof Atacable) {
                    ((Atacable) atacante).atacar(defensor);
                } else {
                    IO.println(atacante.getNombre() + " no tiene la habilidad de atacar.");
                }
                break;
            case 2:
                if (atacante instanceof Entrenable) {
                    ((Entrenable) atacante).entrenar();
                } else if (atacante instanceof RecuperadorEnergia) {
                    ((RecuperadorEnergia) atacante).recuperarEnergia();
                } else if (atacante instanceof Curable) {
                    // Por simplicidad en este combate, el Pokémon se cura a sí mismo
                    ((Curable) atacante).curar(atacante);
                    IO.println(atacante.getNombre() + " se curó a sí mismo.");
                } else {
                    IO.println("Este Pokémon no tiene habilidades especiales de apoyo.");
                }
                break;
            case 3:
                // Instanciamos una poción en el momento para simplificar la prueba
                Pocion pocion = new Pocion("Poción Básica", 20);
                liga.aplicarPocion(pocion, atacante);
                IO.println("Se aplicó una " + pocion.getNombre() + " a " + atacante.getNombre());
                break;
            case 4:
                IO.println(nombreJugador + " decide cambiar de Pokémon.");
                if (turnoJugador1) {
                    activoP1 = forzarCambioPokemon(equipo1, false, "Jugador 1");
                } else {
                    activoP2 = forzarCambioPokemon(equipo2, vsCpu, nombreJugador);
                }
                break;
            default:
                IO.println("Acción inválida. " + atacante.getNombre() + " pierde su turno por confusión.");
                break;
        }

        // Verificamos si el defensor fue derrotado en este turno
        if (defensor.estaDebilitado()) {
            IO.println("\n¡" + defensor.getNombre() + " se ha debilitado y ya no puede pelear!");

            EquipoPokemon equipoDefensor = turnoJugador1 ? equipo2 : equipo1;

            // Si al equipo defensor le quedan Pokémon vivos, forzamos el cambio
            if (hayPokemonsVivos(equipoDefensor)) {
                if (turnoJugador1) {
                    activoP2 = forzarCambioPokemon(equipo2, vsCpu, "Jugador 2/CPU");
                } else {
                    activoP1 = forzarCambioPokemon(equipo1, false, "Jugador 1");
                }
            }
        }

        // Cambiamos el turno al otro jugador
        turnoJugador1 = !turnoJugador1;
    }
    // Resultados finales
    IO.println("\n=== FIN DEL COMBATE ===");
    if (hayPokemonsVivos(equipo1)) {
        IO.println("¡El Jugador 1 es el ganador absoluto de la práctica!");
    } else {
        IO.println("¡Ganó " + (vsCpu ? "la CPU" : "el Jugador 2") + "!");
    }
}

void aplicarAccionEspecial(LigaPokemon ligaPokemon)
{
    IO.println("\n--- APLICAR ACCIÓN ESPECIAL ---");
    String nombre = IO.readln("Ingrese el nombre del Pokémon que realizará la acción: ");
    Pokemon p = ligaPokemon.buscarPokemon(nombre);

    if (p != null) {
        if (p.estaDebilitado())
        {
            IO.println(p.getNombre() + " está debilitado y no puede realizar acciones especiales.");
        } else if (p instanceof Entrenable)
        {
            ((Entrenable) p).entrenar();
        } else if (p instanceof RecuperadorEnergia)
        {
            ((RecuperadorEnergia) p).recuperarEnergia();
        } else if (p instanceof Curable)
        {
            String nombreObjetivo = IO.readln("Ingrese el nombre del Pokémon objetivo a curar: ");
            Pokemon objetivo = ligaPokemon.buscarPokemon(nombreObjetivo);

            if (objetivo != null) {
                ((Curable) p).curar(objetivo);
                IO.println(p.getNombre() + " aplicó curación sobre " + objetivo.getNombre() + ".");
            }
        } else {
            IO.println("Este Pokémon no tiene ninguna acción especial o habilidad de apoyo.");
        }
    }
}

void aplicarUnaPocion(LigaPokemon ligaPokemon)
{
    IO.println("\n--- APLICAR UNA POCIÓN ---");

    var pociones = ligaPokemon.getPocionesDisponibles();
    if (pociones.isEmpty()) {
        IO.println("No hay pociones disponibles en la Liga. Debes agregar una primero.");
        return;
    }

    String nombre = IO.readln("Ingrese el nombre del Pokémon al que desea curar: ");
    Pokemon p = ligaPokemon.buscarPokemon(nombre);

    if (p != null) {
        if (p.estaDebilitado()) {
            IO.println(p.getNombre() + " está debilitado y no puede recibir pociones.");
        } else {
            IO.println("\nPociones disponibles:");
            for (int i = 0; i < pociones.size(); i++) {
                Pocion pocion = pociones.get(i);
                IO.println(i + ". " + pocion.getNombre() + " (Recupera: " + pocion.getCantRecuperacion() + " pts)");
            }

            try {
                int indice = Integer.parseInt(IO.readln("Elige el número de la poción a usar: "));

                if (indice >= 0 && indice < pociones.size()) {
                    Pocion pocionElegida = pociones.get(indice);
                    ligaPokemon.aplicarPocion(pocionElegida, p);
                    IO.println("Se ha aplicado '" + pocionElegida.getNombre() + "' a " + p.getNombre() + ".");
                    IO.println("La vida de " + p.getNombre() + " ahora es de: " + p.getVida());
                    pociones.remove(indice);
                } else {
                    IO.println("Índice inválido. Operación cancelada.");
                }
            } catch (NumberFormatException e) {
                IO.println("Error: Debes ingresar un número entero. Operación cancelada.");
            }
        }
    }
}

void mostrarPokemonDebilitados(LigaPokemon ligaPokemon)
{
    IO.println("\n--- POKÉMON DEBILITADOS ---");
    ligaPokemon.mostrarPokemonsDebilitados();
}

void agregarPocionALiga(LigaPokemon ligaPokemon)
{
    IO.println("\n--- AGREGAR NUEVA POCIÓN ---");
    String nombre = IO.readln("Ingrese el nombre de la poción: ");

    try
    {
        int recuperacion = Integer.parseInt(IO.readln("Ingrese la cantidad de vida que recupera: "));
        Pocion nuevaPocion = new Pocion(nombre, recuperacion);
        ligaPokemon.agregarPocion(nuevaPocion);
        IO.println("¡Poción '" + nombre + "' agregada exitosamente al stock de la Liga!");
    } catch (NumberFormatException e) {
        IO.println("Error: La cantidad a recuperar debe ser un número entero. Operación cancelada.");
    }
}