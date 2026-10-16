# java-asociaciones

Ejercicio 01.03 de Programación Orientada a Objetos (abril de 2022), hecho en
grupo. El tema era la asociación entre clases: objetos que guardan una
referencia a otros y pueden navegar entre ellos. Cada integrante armó su propio
ejemplo:

- **Partido** (Michael): `Partido`, `Equipo` y `Jugador`. El partido conoce a su
  equipo y a su jugador, y cada uno conoce el partido. Se ejecuta con `Principal`.
  El patrocinador del equipo ya era "MichiCorp".
- **Película** (Gabriela): `Pelicula`, `Actor` y `Personaje`. El actor sabe en qué
  película sale y a qué personaje interpreta. Se ejecuta con `Principal_1`.

## Ejecutar

Con JDK 11 o superior y Maven:

```bash
mvn compile
java -cp target/classes Partido.Principal     # ejemplo del partido
java -cp target/classes Partido.Principal_1   # ejemplo de la película
```

```
Desde el partido en Ecuador:
  Equipo: PapitasCrew, patrocinado por MichiCorp
  Faltas del equipo: 3
Desde el equipo, el partido es el sábado a las 21:00
```

```
Daniel Radcliffe interpreta a Harry Potter en "Harry Potter y la piedra filosofal" (2001).
Desde la película, el protagonista es Daniel Radcliffe.
```

## Notas

En la entrega original las clases tenían los atributos de asociación, pero
ningún `main` los usaba: cada objeto se creaba por separado. En 2026 se agregó
el enlace entre objetos en los dos ejemplos y se corrigieron los `toString()`
de `Equipo` y `Jugador`, que al asociarse se llamaban en círculo con el de
`Partido` hasta producir un `StackOverflowError`. También se corrigieron
mensajes (el año de nacimiento salía como "país de origen") y el `pom.xml`, que
apuntaba a una clase de otro proyecto.

Los nombres de las clases del partido quedaron como se entregaron, aunque
`Jugador` guarda en realidad los datos del equipo (nombre, número de jugadores,
patrocinador) y `Equipo` las estadísticas del partido.

## Autores

- Michael Lata ([@Whiteherobot](https://github.com/Whiteherobot))
- Gabriela Rocano
