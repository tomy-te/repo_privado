package ar.edu.uns.cs.ed.tdas.tdaarbolbinario;

import ar.edu.uns.cs.ed.tdas.Position;

public class BTNodo<E> implements Position<E> {
    private E elemento;
    private BTNodo<E> padre;
    private BTNodo<E> izquierdo;
    private BTNodo<E> derecho;

    public BTNodo(E elemento, BTNodo<E> izquierdo, BTNodo<E> derecho, BTNodo<E> padre) {
        this.elemento = elemento;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.padre = padre;
    }

    public E getElement() {
        return elemento;
    }

    public void setElement(E elemento) {
        this.elemento = elemento;
    }

    public BTNodo<E> getLeft() {
        return izquierdo;
    }

    public void setLeft(BTNodo<E> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public BTNodo<E> getRight() {
        return derecho;
    }

    public void setRight(BTNodo<E> derecho) {
        this.derecho = derecho;
    }

    public BTNodo<E> getParent() {
        return padre;
    }

    public void setParent(BTNodo<E> padre) {
        this.padre = padre;
    }

    @Override
    public E element() {
        return elemento;
    }
    
}
