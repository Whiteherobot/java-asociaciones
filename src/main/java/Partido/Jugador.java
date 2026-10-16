package Partido;
 //@michi
public class Jugador {
    private String nombreEquipo;
    private int numerosJugadores;
    private String patrocinador;
    private Partido partido;
    
    public Jugador()
    {        
    }

    public Jugador(String nombreEquipo, int numerosJugadores, String patrocinador, Partido partido) {
        this.nombreEquipo = nombreEquipo;
        this.numerosJugadores = numerosJugadores;
        this.patrocinador = patrocinador;
        this.partido = partido;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getNumerosJugadores() {
        return numerosJugadores;
    }

    public void setNumerosJugadores(int numerosJugadores) {
        this.numerosJugadores = numerosJugadores;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jugador{");
        sb.append("nombreEquipo=").append(nombreEquipo);
        sb.append(", numerosJugadores=").append(numerosJugadores);
        sb.append(", patrocinador=").append(patrocinador);
        sb.append(", partido=").append(partido == null ? null : partido.getLugarPartido());
        sb.append('}');
        return sb.toString();
    }


        
}
