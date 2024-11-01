
package com.mycompany.arbolbinario2;

import javax.swing.JOptionPane;



  public class Arbolbinario2 {
    NodoArbol raiz;

    public Arbolbinario2() {
        raiz = null;
    }

    public void insertarProducto() {
        // Solicitar datos del producto con JOptionPane
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        String color = JOptionPane.showInputDialog("Ingrese el color del producto:");
        String tamaño = JOptionPane.showInputDialog("Ingrese el tamaño del producto:");
        String marca = JOptionPane.showInputDialog("Ingrese la marca del producto:");

        // Crear y agregar el producto
        Producto producto = new Producto(nombre, color, tamaño, marca);
        raiz = insertarRecursivo(raiz, producto, 0);

        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente: \n" + producto);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, Producto producto, int nivel) {
        if (nivel >= 5) {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más productos. Se alcanzó el nivel máximo.");
            return nodo;
        }

        if (nodo == null) {
            return new NodoArbol(producto);
        }

        if (producto.nombre.compareTo(nodo.producto.nombre) < 0) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, producto, nivel + 1);
        } else {
            nodo.derecha = insertarRecursivo(nodo.derecha, producto, nivel + 1);
        }

        return nodo;
    }

    public void buscarProductosSimilares() {
        // Solicitar características del producto a buscar
        String color = JOptionPane.showInputDialog("Ingrese el color del producto a buscar:");
        String tamaño = JOptionPane.showInputDialog("Ingrese el tamaño del producto a buscar:");
        String marca = JOptionPane.showInputDialog("Ingrese la marca del producto a buscar:");

        StringBuilder resultados = new StringBuilder();
        buscarRecursivo(raiz, color, tamaño, marca, resultados);

        if (resultados.length() > 0) {
            JOptionPane.showMessageDialog(null, "Productos similares encontrados:\n" + resultados.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron productos similares.");
        }
    }

    private void buscarRecursivo(NodoArbol nodo, String color, String tamaño, String marca, StringBuilder resultados) {
        if (nodo == null) return;

        if (nodo.producto.color.equals(color) && nodo.producto.tamaño.equals(tamaño) && nodo.producto.marca.equals(marca)) {
            resultados.append(nodo.producto).append("\n");
        }

        buscarRecursivo(nodo.izquierda, color, tamaño, marca, resultados);
        buscarRecursivo(nodo.derecha, color, tamaño, marca, resultados);
    }

    public void obtenerRecomendaciones() {
        StringBuilder recomendaciones = new StringBuilder();
        recorrerInOrden(raiz, recomendaciones);

        if (recomendaciones.length() > 0) {
            JOptionPane.showMessageDialog(null, "Recomendaciones de productos:\n" + recomendaciones.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos en el sistema.");
        }
    }

    public void recorrerInOrden(NodoArbol nodo, StringBuilder recomendaciones) {
        if (nodo == null) return;

        recorrerInOrden(nodo.izquierda, recomendaciones);
        recomendaciones.append(nodo.producto).append("\n");
        recorrerInOrden(nodo.derecha, recomendaciones);
    }
}