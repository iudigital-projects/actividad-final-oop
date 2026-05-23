package com;

public class App {
  public static void main(String[] args) {
    Libro libro1 = new Libro(
        "LIB123", "El Quijote", "Miguel de Cervantes", 16000, 1605, "Novela", 1000,
        "Libro del quijote", true);
    //
    Libro libro2 = new Libro(
        "LIB456", "Cien años de soledad", "Gabriel García Márquez", 20000, 1967, "Novela", 500,
        "Libro de cien años de soledad", true);
    Libro libro3 = new Libro(
        "LIB789", "El principito", "Antoine de Saint-Exupéry", 15000, 1943, "Cuento", 200,
        "Libro del principito", true);
    Libro libro4 = new Libro(
        "LIB101", "El Señor de los Anillos", "J.R.R. Tolkien", 25000, 1954, "Novela", 300,
        "Libro del Señor de los Anillos", true);


    Libreria villaNueva = new Libreria("Villa Nueva");

    villaNueva.agregarLibro(libro1);
    villaNueva.agregarLibro(libro2);
    villaNueva.agregarLibro(libro3);
    villaNueva.agregarLibro(libro4);

    // villaNueva.listarLibros();
    // villaNueva.buscarLibros("El Señor de los Anillos", "Novela", 1954, "");
    // villaNueva.buscarLibros("LIB789");

    String[] librosAVender = new String[2];
    librosAVender[0] = "LIB101";
    librosAVender[1] = "LIB456";

    int[] cantidades = new int[2];
    cantidades[0] = 2;
    cantidades[1] = 1;
    villaNueva.venderLibros(librosAVender, cantidades, true);
    villaNueva.buscarLibros();
  }
}
