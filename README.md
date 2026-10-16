# java-asociaciones

[![CI](https://github.com/Whiteherobot/java-asociaciones/actions/workflows/ci.yml/badge.svg)](https://github.com/Whiteherobot/java-asociaciones/actions/workflows/ci.yml)

Ejercicio 01.03 de Programación Orientada a Objetos (abril de 2022), hecho en
grupo. El tema era la asociación entre clases: objetos que guardan referencias
a otros y se pueden recorrer en uno o ambos sentidos. Cada integrante armó un
ejemplo en su propio paquete.

## partido (Michael)

Un `Equipo` tiene su plantilla de `Jugador` y cada jugador sabe en qué equipo
juega (uno a muchos, bidireccional). El equipo es el que crea el enlace, así que
los dos lados nunca quedan desincronizados: un jugador no puede estar en dos
equipos y dos jugadores no pueden tener el mismo número. Un `Partido` se juega
entre un equipo local y uno visitante, en un lugar y una fecha.

```
PapitasCrew vs Los Cóndores · Estadio de Cuenca, Ecuador · sábado 23 de abril, 21:00

PapitasCrew (patrocina MichiCorp)
  1. Hugo
  ...
  5. Leo (lesionado)
  Faltas: 3 · Disponibles: 7 de 8
```

## pelicula (Gabriela)

Un `Actor` interpreta a un `Personaje` en una `Pelicula`. El personaje es el que
une a los otros dos, así que una película tiene todo su reparto y un actor
puede tener papeles en varias películas.

```
Harry Potter y la piedra filosofal (2001, Fantasía)
  Harry Potter (Mago, Perseverante) · Daniel Radcliffe
  Hermione Granger (Bruja, Inteligente) · Emma Watson
  Ron Weasley (Mago, Leal) · Rupert Grint

Películas de Daniel Radcliffe:
  Harry Potter y la piedra filosofal (2001, Fantasía) · tenía 12 años
  Harry Potter y la cámara secreta (2002, Fantasía) · tenía 13 años
```

## Cómo correrlo

Necesitas JDK 17 o superior. El proyecto trae el wrapper de Maven.

```bash
./mvnw verify                                   # compila y corre las pruebas
java -cp target/classes partido.Principal
java -cp target/classes pelicula.Principal
```

Las pruebas verifican que las asociaciones queden consistentes en ambos sentidos
y corren en GitHub Actions con Java 17 y 21.

## Qué cambió desde la entrega

La versión de 2022 tenía los atributos de asociación, pero ningún objeto se
enlazaba con otro. Además el modelo del partido estaba cruzado: `Jugador`
guardaba el nombre del equipo y el patrocinador, y `Equipo` las faltas y los
lesionados. Los `toString()` se llamaban en círculo y habrían terminado en
`StackOverflowError` apenas se asociaran los objetos. En 2026 se reorganizaron
las clases para que cada una tenga la responsabilidad que dice su nombre, se
separaron los dos ejemplos en paquetes y se agregaron pruebas. Los nombres de los
jugadores, el equipo PapitasCrew con su patrocinador y el ejemplo de Harry
Potter vienen de la entrega original.

## Autores

- Michael Lata ([@Whiteherobot](https://github.com/Whiteherobot))
- Gabriela Rocano

Licencia MIT.
