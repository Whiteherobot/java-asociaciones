package pelicula;

/**
 * Ejemplo de la película: reparto de una película y filmografía de un actor.
 */
public class Principal {

    public static void main(String[] args) {
        Actor daniel = new Actor("Daniel Radcliffe", 1989, "Reino Unido");
        Actor emma = new Actor("Emma Watson", 1990, "Reino Unido");
        Actor rupert = new Actor("Rupert Grint", 1988, "Reino Unido");

        Pelicula piedra = new Pelicula("Harry Potter y la piedra filosofal", "Fantasía", 2001);
        piedra.agregarPapel("Harry Potter", "Mago", "Perseverante", daniel);
        piedra.agregarPapel("Hermione Granger", "Bruja", "Inteligente", emma);
        piedra.agregarPapel("Ron Weasley", "Mago", "Leal", rupert);

        Pelicula camara = new Pelicula("Harry Potter y la cámara secreta", "Fantasía", 2002);
        camara.agregarPapel("Harry Potter", "Mago", "Valiente", daniel);

        System.out.println(piedra);
        piedra.getPersonajes().forEach(p -> System.out.println("  " + p));
        System.out.println();

        System.out.println("Películas de " + daniel.getNombre() + ":");
        for (Pelicula p : daniel.getPeliculas()) {
            System.out.printf("  %s · tenía %d años%n", p, daniel.edadEnEstreno(p));
        }
    }
}
