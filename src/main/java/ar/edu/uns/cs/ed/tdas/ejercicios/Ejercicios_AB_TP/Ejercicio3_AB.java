package ar.edu.uns.cs.ed.tdas.ejercicios.Ejercicios_AB_TP;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;

public class Ejercicio3_AB<E> {
    public void completarDerechos(E r, BinaryTree<E> t){
        if(t.isEmpty()){
            throw new EmptyTreeException("El arbol esta vacio");
        }
        Position<E> raiz = t.root();
        preOrden(raiz, r, t);
    }

    private void preOrden(Position<E> p, E r, BinaryTree<E> t){
        if(t.hasLeft(p) && !t.hasRight(p)){
            t.addRight(p, r);
        }
        if(t.hasLeft(p)){
            preOrden(t.left(p), r, t);
        }
        if(t.hasRight(p)){
            preOrden(t.right(p), r, t);
        }
    }
}
