package com.mycompany.arbolbinario2;
class Producto {
    String nombre;
    String color;
    String tamaño;
    String marca;

    public Producto(String nombre, String color, String tamaño, String marca) {
        this.nombre = nombre;
        this.color = color;
        this.tamaño = tamaño;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Producto [Nombre: " + nombre + ", Color: " + color + ", Tamaño: " + tamaño + ", Marca: " + marca + "]";
    }
}