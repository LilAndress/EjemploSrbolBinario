/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolbinario2;

class NodoArbol {
    Producto producto;
    NodoArbol izquierda, derecha;

    public NodoArbol(Producto producto) {
        this.producto = producto;
        this.izquierda = this.derecha = null;
    }
}