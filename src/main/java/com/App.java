package com;

import java.util.Scanner;

public class App {
  private static void agregarLibro(Scanner leer, Libreria libreria) {
    System.out.println("------------------------------------------------------------");
    System.out.println("Por favor a continuación ingrese la información del libro: ");
    System.out.println();
    System.out.print("Uid: ");
    String uid = leer.nextLine();

    System.out.print("Nombre: ");
    String nombre = leer.nextLine();

    System.out.print("Autor: ");
    String autor = leer.nextLine();

    System.out.print("Precio: ");
    int precio = Integer.parseInt(leer.nextLine());

    System.out.print("Año de publicación: ");
    int anio = Integer.parseInt(leer.nextLine());

    System.out.print("Categoria: ");
    String categoria = leer.nextLine();

    System.out.print("Stock disponible: ");
    int stock = Integer.parseInt(leer.nextLine());

    System.out.print("Descripcion: ");
    String descripcion = leer.nextLine();

    System.out.print("¿Está disponible? (Si/No): ");
    String respuestaDisponible = leer.nextLine();
    boolean disponible;
    switch (respuestaDisponible) {
      case "Si":
        disponible = true;
      case "No":
        disponible = false;
      default:
        disponible = true;
    }

    libreria.agregarLibro(uid, nombre, autor, precio, anio, categoria, stock, descripcion, disponible);
    System.out.println("------------------------------------------------------------");
    System.out.println();
  }

  private static void agregarStock(Scanner leer, Libreria libreria) {
    System.out.println("--------------------------------------------");
    System.out.println("A continuación ingrese el uid del libro al cual le quiere agregar stock");
    System.out.print("Uid: ");
    String uid = leer.nextLine();
    System.out.println("Buscando libro... ");
    libreria.buscarLibros(uid);
    System.out.print("Agregar stock: ");
    int stock = Integer.parseInt(leer.nextLine());
    libreria.agregarStock(uid, stock);
  }

  public static void main(String[] args) {

    // INICIALIZAMOS UNA LIBRERIA CON UNOS CUANTOS LIBROS
    // 1. Creamos los libros
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
    
    // Creamos una libreria nueva
    Libreria villaNueva = new Libreria("Villa Nueva");
    
    // Agregamos los libros
    villaNueva.agregarLibro(libro1);
    villaNueva.agregarLibro(libro2);
    villaNueva.agregarLibro(libro3);
    villaNueva.agregarLibro(libro4);
    villaNueva.buscarLibros("LIB789");

    // Menú
    int opcion;
    Scanner leer = new Scanner(System.in);
    do {
      System.out.println("MENÚ\n");
      System.out.println("1. Agregar libro");
      System.out.println("2. Agregar stock");
      System.out.println("3. Listar libros");
      System.out.println("4. Buscar libro");
      System.out.println("5. Vender libro");
      System.out.println("6. Salir\n");

      System.out.print("Elija una opción: ");
      opcion = Integer.parseInt(leer.nextLine());

      switch (opcion) {
        case 1:
          agregarLibro(leer, villaNueva);
          break;
        case 2:
          agregarStock(leer, villaNueva);
          break;
        case 3:
          villaNueva.buscarLibros();
          break;
        default:
          break;
      }

    } while (opcion != 6);
    leer.close();

  }

}
