package partido;

import java.time.LocalDateTime;

/**
 * Ejemplo del partido: equipos con sus jugadores y un partido entre ellos.
 */
public class Principal {

    public static void main(String[] args) {
        Equipo papitas = new Equipo("PapitasCrew", "MichiCorp");
        String[] nombres = {"Hugo", "Martín", "Lucas", "Mateo", "Leo", "Daniel", "Alejandro", "Pablo"};
        for (int i = 0; i < nombres.length; i++) {
            papitas.agregarJugador(new Jugador(nombres[i], i + 1));
        }

        Equipo rival = new Equipo("Los Cóndores", null);
        rival.agregarJugador(new Jugador("Andrés", 10));
        rival.agregarJugador(new Jugador("Felipe", 7));

        Partido partido = new Partido("Estadio de Cuenca, Ecuador",
                LocalDateTime.of(2022, 4, 23, 21, 0), papitas, rival);

        papitas.registrarFalta();
        papitas.registrarFalta();
        papitas.registrarFalta();
        rival.registrarFalta();
        papitas.getJugadores().get(4).lesionar();

        System.out.println(partido);
        System.out.println();
        for (Equipo equipo : new Equipo[] {partido.getLocal(), partido.getVisitante()}) {
            System.out.println(equipo);
            equipo.getJugadores().forEach(j -> System.out.println("  " + j));
            System.out.printf("  Faltas: %d · Disponibles: %d de %d%n%n",
                    equipo.getFaltas(), equipo.jugadoresDisponibles(), equipo.getJugadores().size());
        }
        System.out.println("Faltas en el partido: " + partido.totalFaltas());

        Jugador leo = papitas.getJugadores().get(4);
        System.out.println(leo.getNombre() + " juega en " + leo.getEquipo().getNombre() + ".");
    }
}
