package Partido;
 //@michi
public class Equipo{
    private int faltasJugador;
    private int jugadorLesionado;
    private String jugadoresString;
    private Partido partido;
    
    public Equipo()
    {
    }

    public Equipo(int faltasJugador, int jugadorLesionado, String jugadoresString, Partido partido) {
        this.faltasJugador = faltasJugador;
        this.jugadorLesionado = jugadorLesionado;
        this.jugadoresString = jugadoresString;
        this.partido = partido;
    }

    public int getFaltasJugador() {
        return faltasJugador;
    }

    public void setFaltasJugador(int faltasJugador) {
        this.faltasJugador = faltasJugador;
    }

    public int getJugadorLesionado() {
        return jugadorLesionado;
    }

    public void setJugadorLesionado(int jugadorLesionado) {
        this.jugadorLesionado = jugadorLesionado;
    }

    public String getJugadoresString() {
        return jugadoresString;
    }

    public void setJugadoresString(String jugadoresString) {
        this.jugadoresString = jugadoresString;
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
        sb.append("Equipo{");
        sb.append("faltasJugador=").append(faltasJugador);
        sb.append(", jugadorLesionado=").append(jugadorLesionado);
        sb.append(", jugadoresString=").append(jugadoresString);
        sb.append(", partido=").append(partido == null ? null : partido.getLugarPartido());
        sb.append('}');
        return sb.toString();
    }


   
}
