package Partido;
// @author Gabriela
public class Principal_1 {
    public static void main(String[] args) {
        Actor actor = new Actor();
        actor.setNombre("Daniel Radcliffe");
        actor.setPaisOrigen("Reino Unido");
        actor.setYearNacimiento(1989);
        
        System.out.println("El nombre del actor es: " + actor.getNombre());
        System.out.println("El país de origen del actor es: " + actor.getPaisOrigen());
        System.out.println("El año de nacimiento del actor es: " + actor.getYearNacimiento());
        
        Personaje personaje = new Personaje();
        personaje.setNombrePersonaje("Harry Potter");
        personaje.setTipoPersonaje("Mago");
        personaje.setCualidadPersonaje("Perseverante");
        
        
        System.out.println("El nombre del personaje es: " + personaje.getNombrePersonaje());
        System.out.println("El personaje es : " + personaje.getTipoPersonaje());
        System.out.println("La cualidad que destaca del personaje es: " + personaje.getCualidadPersonaje());
        
        Pelicula pelicula = new Pelicula();
        pelicula.setCategoria("Fantasía");
        pelicula.setNombrePelicula("Harry Potter y la piedra filosofal");
        pelicula.setYearPelicula(2001);
        
        System.out.println("La categoría de la película es: " + pelicula.getCategoria());
        System.out.println("El nombre de la película es: " + pelicula.getNombrePelicula());
        System.out.println("El año de la película es: " + pelicula.getYearPelicula());

        // Asociación: el actor conoce la película y el personaje que interpreta
        actor.setDatosPelicula(pelicula);
        actor.setDatosPersonaje(personaje);
        pelicula.actor = actor;
        personaje.actor = actor;
        System.out.println();
        System.out.println(actor.getNombre() + " interpreta a " + actor.getDatosPersonaje().getNombrePersonaje()
                + " en \"" + actor.getDatosPelicula().getNombrePelicula() + "\" ("
                + actor.getDatosPelicula().getYearPelicula() + ").");
        System.out.println("Desde la película, el protagonista es " + pelicula.actor.getNombre() + ".");
        
    }
}
