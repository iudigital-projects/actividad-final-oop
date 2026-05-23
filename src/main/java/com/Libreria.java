package com;

class Libreria {
  private String nombre;
  private int cantidad;
  private int max = 10;
  private Libro[] libros = new Libro[max];
  private double ingresos = 0;
  private double porcentajeDescuento = 0.01;

  private String SIN_LIBROS_MENSAJE = "No hay libros para mostrar";

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

 public void agregarLibro(Libro libro) {
   if (this.cantidad < this.max) {
     this.libros[cantidad] = libro; 
     this.cantidad = this.cantidad + 1;
   }
 } 

  public void listarLibros() {
    if (cantidad > 0) {
      for(int i = 0; i < cantidad; i++) {
        libros[i].mostrarInformacion();
      }
    } else {
      System.out.println(SIN_LIBROS_MENSAJE);
    }
  }


  public void listarLibros(String categoria) {
    if (cantidad > 0) {
      for(int i = 0; i < cantidad; i++) {
        if(categoria == libros[i].getCategoria()) {
          libros[i].mostrarInformacion();
        }
      }
    } else {
      System.out.println(SIN_LIBROS_MENSAJE);
    }
  }
}
