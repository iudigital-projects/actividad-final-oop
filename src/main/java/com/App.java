package com;

import java.util.Scanner;

public class App {
  private static void agregarLibro(Scanner leer, Libreria libreria) {
    System.out.println("------------------------------------------------------------");
    System.out.println("Por favor a continuación ingrese la información del libro: ");
    System.out.println();

    try {
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
    } catch (NumberFormatException e) {
      System.out.println("Error: ingrese solo números en el precio, año y stock");
      System.out.println("Vuelva a intentar nuevamente...");
    }

    System.out.println("------------------------------------------------------------");
    System.out.println();
  }

  private static void agregarStock(Scanner leer, Libreria libreria) {
    System.out.println("--------------------------------------------");
    System.out.println("A continuación ingrese el uid del libro al cual le quiere agregar stock");
    System.out.print("Uid: ");
    String uid = leer.nextLine();

    System.out.print("Agregar stock: ");
    try {
      int stock = Integer.parseInt(leer.nextLine());
      libreria.agregarStock(uid, stock);
    } catch (NumberFormatException e) {
      System.out.println("Error: ingrese solo números para stock");
      System.out.println("Vuelva a intentar nuevamente...");
    }
  }

  public static void buscarLibros(Scanner leer, Libreria libreria) {
    System.out.println("Buscar libro por nombre, categoria, año o autor");
    System.out.print("Ingrese el nombre o enter para dejar vacío: ");
    String nombre = leer.nextLine();
    System.out.print("Ingrese la categoria o enter para dejar vacío: ");
    String categoria = leer.nextLine();
    System.out.print("Ingrese año o el número 0: ");
    
    int anio;
    try {
      anio = Integer.parseInt(leer.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Error: ingrese solo números para el año");
      return;
    }

    System.out.print("Ingrese autor o enter para dejar vacío: ");
    String autor = leer.nextLine();
    System.out.println();

    libreria.buscarLibros(nombre, categoria, anio, autor);
    System.out.println();
  }

  public static void venderLibros(Scanner leer, Libreria libreria) {
    System.out.print("Ingrese solo el número de títulos a vender: ");
    int numeroTitulos = Integer.parseInt(leer.nextLine());

    int[] unidades = new int[numeroTitulos];
    String[] uids = new String[numeroTitulos];

    int cantidad = 0;
    for(int i = 0; i < numeroTitulos; i++) {
      if (cantidad < numeroTitulos) {
        System.out.printf("Ingrese el uid del libro %s: ", i + 1);
        uids[i] = leer.nextLine();
        System.out.println();
        System.out.printf("Ingresar unidades a vender para libro %s: ", i + 1);
        unidades[i] = Integer.parseInt(leer.nextLine());
        System.out.println();
        cantidad++;
      }
    }

    String respuestaEstudiante = "No";
    boolean esEstudiante = false;
    System.out.print("¿Es usted un estudiante? (Si / No): ");
    respuestaEstudiante = leer.nextLine();
    if (respuestaEstudiante.equals("Si")) {
      esEstudiante = true;
    } else {
      esEstudiante = false;
    }

    libreria.venderLibros(uids, unidades, esEstudiante);
  }

  public static void ejecutarMenu(Libreria libreria) {
    int opcion;
    Scanner leer = new Scanner(System.in);
    do {
      System.out.println("MENÚ\n");
      System.out.println("1. Agregar libro");
      System.out.println("2. Agregar stock");
      System.out.println("3. Listar libros");
      System.out.println("4. Buscar libro");
      System.out.println("5. Vender libro");
      System.out.println("6. Mostrar información de libreria");
      System.out.println("7. Salir\n");

      System.out.print("Elija una opción: ");
      try {
        opcion = Integer.parseInt(leer.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Error: Solo se admiten números para la opción de menú, vuelva a intentarlo...");
        System.out.println();
        // Se ejecuta de nuevo el menú, para no sacar al usuario de la aplicación
        ejecutarMenu(libreria);
        return;
      }

      switch (opcion) {
        case 1:
          agregarLibro(leer, libreria);
          break;
        case 2:
          agregarStock(leer, libreria);
          break;
        case 3:
          libreria.buscarLibros();
          break;
        case 4:
          buscarLibros(leer, libreria);
          break;
        case 5:
          venderLibros(leer, libreria);
          break; 
        case 6:
          libreria.mostrarInformacion();
          break;
        default:
          break;
      }

    } while (opcion != 7);
    leer.close();
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

    // Ejecutar el menú para la libreria villaNueva
    ejecutarMenu(villaNueva);

  }

}
