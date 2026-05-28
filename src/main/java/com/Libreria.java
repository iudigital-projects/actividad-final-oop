package com;

import java.util.Optional;

class Libreria {
  private String nombre;
  private int cantidad;
  private int max = 10;
  private Libro[] libros = new Libro[max];
  private double ingresos = 0;
  private double porcentajeDescuento = 0.1;

  private String SIN_LIBROS_MENSAJE = "No hay libros para mostrar";
  
  // Sobrecarga - Overload 
  // Constructo Libreria
  Libreria(String nombre, Libro[] libros, double ingresos, double porcentajeDescuento, int max) {
    this.nombre = nombre;
    this.libros = libros;
    this.ingresos = ingresos;
    this.porcentajeDescuento = porcentajeDescuento;
    this.max = max;
  }

  Libreria(String nombre) {
    this.nombre = nombre;
  }

  // METODOS
  public void mostrarInformacion() {
    System.out.println();
    System.out.println("------------------------------------------------");
    System.out.printf("Libreria: %s  |  Ingresos: $%s \n", nombre, ingresos);
    System.out.println("------------------------------------------------");
    System.out.println();
  } 

  boolean libroExiste(String uid) {
    boolean existe = false;
    if (cantidad > 0) {
      for (int i = 0; i < cantidad; i++) {
        if (uid.equals(libros[i].getUid())) {
          existe = true;
        }
      }
    }

    return existe;
  }

  // Sobrecarga sobre el método agregar libro
  public void agregarLibro(Libro libro) {
    if (this.cantidad < this.max) {
      this.libros[cantidad] = libro;
      this.cantidad = this.cantidad + 1;
    }
  }
 
  // Agregar libro a la tienda
  public void agregarLibro(
      String uid,
      String nombre,
      String autor,
      int precio,
      int anio,
      String categoria,
      int stock,
      String descripcion,
      boolean disponible) {
    if (this.cantidad < this.max) {

      if (libroExiste(uid)) {
        this.libros[cantidad] = new Libro(uid, nombre, autor, precio, anio, categoria, stock, descripcion, disponible);
        this.cantidad = this.cantidad + 1;
      } else {
        System.out.println("El libro ya existe");
      }

    }
  }

  public void agregarStock(String uid, int stock) {
    boolean existe = false;
    if (cantidad > 0) {
      for (int i = 0; i < cantidad; i++) {
        if (uid.equals(libros[i].getUid())) {
          existe = true;
          libros[i].setStock(libros[i].getStock() + stock);
          libros[i].mostrarInformacion();
          System.out.println("Stock agregado correctamente.\n");
        } else {
          existe = false;
        }
      }

      if (existe == false) {
        System.out.printf("No existe libro con uid: %s \n", uid);
      }
    } else {
      System.out.println(SIN_LIBROS_MENSAJE);
    }
  }

  // BUSCAR LIBROS
  // Usamos sobrecarga de métodos para permitir diferentes busquedas
  //
  // 1. Listar todos los libros disponibles en la libreria
  public void buscarLibros() {
    if (cantidad > 0) {
      for (int i = 0; i < cantidad; i++) {
        libros[i].mostrarInformacion();
      }
      System.out.println();
    } else {
      System.out.println(SIN_LIBROS_MENSAJE);
    }
  }

  // buscar 1 solo libro por su uid
  public void buscarLibros(String uid) {
    if (cantidad > 0) {
      for (int i = 0; i < cantidad; i++) {
        if (uid.equals(libros[i].getUid())) {
          libros[i].mostrarInformacion();
        }
      }
    } else {
      System.out.println(SIN_LIBROS_MENSAJE);
    }
  }

  // buscar por categoria, año o autor
  public void buscarLibros(String nombre, String categoria, int anio, String autor) {
    boolean existe = false;
    if (cantidad > 0) {
      for (int i = 0; i < cantidad; i++) {
        if (nombre.equals(libros[i].getNombre()) || categoria.equals(libros[i].getCategoria())
            || anio == libros[i].getAnio() || autor.equals(libros[i].getAutor())) {
          existe = true;
          libros[i].mostrarInformacion();
        }
      }

      if (existe == false) {
        System.out.println("No se encontro ningún libro");
      }
    } else {
      System.out.println(SIN_LIBROS_MENSAJE);
    }
  }

  private double calcularDescuento(double total) {
    return total - (total * porcentajeDescuento);
  }

  // el metodo getLibro usa Optional para
  // permitir retornar vacio cuando el libro no existe
  private Optional<Libro> getLibro(String uid) {
    if (cantidad > 0) {
      for (int i = 0; i < cantidad; i++) {
        if (uid.equals(libros[i].getUid())) {
          return Optional.of(libros[i]);
        } else {
          Optional.empty();
        }
      }
    }

    return Optional.empty();
  }

  private void imprimirFactura(String infoVenta, String infoDescuento, double precioFinal) {
    System.out.println();
    System.out.println("--------------------------------------------------------");
    System.out.println("FACTURA DE VENTA");
    System.out.println("--------------------------------------------------------");
    System.out.println(infoVenta);
    System.out.println(infoDescuento);
    System.out.println("--------------------------------------------------------");
    System.out.println("Precio final: $" + precioFinal);
    System.out.println("--------------------------------------------------------");
    System.out.println();
  }

  public void venderLibros(String[] uids, int[] cantidades, boolean esEstudiante) {
    if (cantidades.length == uids.length) {
      String infoVenta = "";
      String infoDescuento = "";
      double precioFinal = 0;

      for (int i = 0; i < uids.length; i++) {
        Libro libro = getLibro(uids[i]).get();
        String nombre = libro.getNombre();
        double precio = libro.getPrecio();
        libro.setStock(libro.getStock() - cantidades[i]);
        infoVenta += String.format("Libro %s: %s | precio: %s | unidades: %s\n", (i + 1), nombre, precio,
            cantidades[i]);
        precioFinal += precio * cantidades[i];
      }

      if (esEstudiante) {
        precioFinal = calcularDescuento(precioFinal);
        infoDescuento = String.format("Descuento de estudiante: %s%%", porcentajeDescuento * 100);
      } else {
        infoDescuento = "No es estudiante, no tiene descuento.";
      }

      ingresos += precioFinal;

      imprimirFactura(infoVenta, infoDescuento, precioFinal);

    }
  }
}
