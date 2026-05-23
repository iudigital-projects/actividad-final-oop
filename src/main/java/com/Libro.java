package com;

public class Libro {
  
  // Atributos
  private String uid;
  private String nombre;
  private String autor;
  private double precio;
  private int anio;
  private String categoria;
  private int stock;
  private String descripcion;
  private boolean disponible;

  // Constructor
  Libro(
      String uid, 
      String nombre, 
      String autor, 
      double precio, 
      int anio, 
      String categoria, 
      int stock,
      String descripcion, 
      boolean disponible) {
    this.uid = uid;
    this.nombre = nombre;
    this.autor = autor;
    this.precio = precio;
    this.anio = anio;
    this.categoria = categoria;
    this.stock = stock;
    this.descripcion = descripcion;
    this.disponible = disponible;
  }


  public void mostrarInformacion() {
    System.out.printf("---------------------%s-------------------------------\n", uid);
    System.out.printf("Nombre: %s, Autor: %s, Año: %s \n", nombre, autor, anio);
    System.out.printf("Categoria: %s, Descripción: %s \n", categoria, descripcion);
    System.out.printf("Stock: %s, Disponible: %s \n", stock, disponible ? "Si" : "No");
    System.out.printf("Precio: %s \n", precio);
    System.out.println("------------------------------------------------------");
  }

  public String getUid() {
      return uid;
  }

  public String getNombre() {
      return nombre;
  }

  public String getCategoria() {
      return categoria;
  }

  public int getAnio() {
      return anio;
  }

  public double getPrecio() {
      return precio;
  }

  public String getAutor() {
      return autor;
  }

  public int getStock() {
      return stock;
  }

  public void setStock(int stock) {
      this.stock = stock;
  }
}

