package Partido;
 //@michi
public class Principal {
    public static void main(String[] args) {
        var jugador = new Jugador();
        jugador.setNombreEquipo("PapitasCrew");
        jugador.setNumerosJugadores(12);
        jugador.setPatrocinador("MichiCorp");
        System.out.println("El nombre del equipo es: " + jugador.getNombreEquipo());
        System.out.println("El número de jugadores que representa al equipo es: " + jugador.getNumerosJugadores());
        System.out.println("El patrocinador de este partido es: "  + jugador.getPatrocinador());        
        var persona = new Partido();
        persona.setLugarPartido("Ecuador");
        persona.setFechaPartido("sábado a las 21:00");
        persona.setIntegrantes("\n"+
                               "Hugo.\n" +
                               "Martín.\n" +
                               "Lucas.\n" +
                               "Mateo.\n" +
                               "Leo.\n" +
                               "Daniel.\n" +
                               "Alejandro.\n" +
                               "Pablo.");
        
        System.out.println("El lugar del partido será en: " + persona.getLugarPartido());
        System.out.println("La fecha del partido será: " + persona.getFechaPartido());
        System.out.println("Los integrantes del partido son: " + persona.getIntegrantes());
        var equipo = new Equipo();
        equipo.setFaltasJugador(3);
        equipo.setJugadorLesionado(0);
        equipo.setJugadoresString("Hugo, Martín, Lucas, Mateo, Leo, Daniel, Alejandro, Pablo");
        System.out.println("Las faltas que comete el equipo de papitas son: " + equipo.getFaltasJugador());
        System.out.println("El número de jugadores lesionados en este partido es: " + equipo.getJugadorLesionado());

        // Asociación: el partido conoce a su equipo y a su jugador, y ellos al partido
        persona.setEquipo(equipo);
        persona.setJugador(jugador);
        equipo.setPartido(persona);
        jugador.setPartido(persona);
        System.out.println();
        System.out.println("Desde el partido en " + persona.getLugarPartido() + ":");
        System.out.println("  Equipo: " + persona.getJugador().getNombreEquipo()
                + ", patrocinado por " + persona.getJugador().getPatrocinador());
        System.out.println("  Faltas del equipo: " + persona.getEquipo().getFaltasJugador());
        System.out.println("Desde el equipo, el partido es el " + equipo.getPartido().getFechaPartido());
        System.out.println(equipo);
        

        
        
    }
}