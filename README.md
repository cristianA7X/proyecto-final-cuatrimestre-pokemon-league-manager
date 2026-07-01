# Pokemon League Manager

Proyecto integrador desarrollado para la materia **Desarrollo de Sistemas Orientados a Objetos** de la Tecnicatura Superior en Desarrollo de Software.

## 📋 Descripción
Este proyecto es un simulador de gestión de una Liga Pokémon. Permite registrar Pokémon de distintos tipos, gestionar equipos de combate, aplicar objetos de apoyo y simular batallas interactivas (1 vs 1) contra otro jugador o contra la CPU.

## 🚀 Funcionalidades Principales
- **Gestión de la Liga:** Registro de Pokémon y administración de objetos de apoyo.
- **Sistema de Combate:** Simulación de combates 1 vs 1 con mecánicas de turnos.
- **Acciones Especiales:** Implementación de interfaces para acciones como entrenar, curar y recuperar energía, respetando principios de POO.
- **Ventajas Elementales:** Cálculo de daño basado en tipos (Fuego, Agua, Planta, Eléctrico).
- **Interfaz Consola:** Menú interactivo con manejo de excepciones para una experiencia de usuario robusta.

## Tecnologías Utilizadas
- **Lenguaje:** Java 25.
- **Patrones de Diseño:** Singleton (para la clase `LigaPokemon`).
- **Arquitectura:** Orientada a Objetos (Interfaces, Clases Abstractas, Herencia).

## Instrucciones de Uso
1. **Compilación:** Asegúrate de tener instalado un JDK compatible (JDK 25 recomendado).
2. **Ejecución:** Ejecuta la clase `Main` desde tu IDE favorito (IntelliJ IDEA, Eclipse, etc.).
3. **Interacción:** - El programa te presentará un menú numerado.
   - Debes **Crear la liga** (Opción 1) antes de empezar a registrar Pokémon.
   - Sigue las instrucciones en consola para registrar tus Pokémon y armar tu equipo de combate.

## Estructura del Proyecto
- `clases/`: Contiene el modelo de dominio (Pokémon, Interfaces, Liga, Equipos).
- `presentacion/`: Contiene la clase `Main` que gestiona la lógica de la interfaz.

## Reglas de Negocio
- Los Pokémon tienen vida, energía y nivel.
- Un Pokémon debilitado (≤ 30 de vida) no puede participar en combate ni acciones especiales.
- Las ventajas elementales suman 10 puntos de daño extra al cálculo base.

---
*Desarrollado como proyecto final de cuatrimestre.*
