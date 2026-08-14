package ar.edu.uns.cs.ed.tdas.ejercicios.Ejercicios_LM_AB;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;

public class Ejercicio_LM_AB_1<E> {
    public void completarDerechos(BinaryTree<E> t, E r){

        if(t == null || t.isEmpty()){
            throw new EmptyTreeException("El arbol esta vacio");
        }
        Position<E> pos = t.root();
        
        preOrden(t, r, pos);
    }

    private void preOrden(BinaryTree<E> t, E r, Position<E> pos) {
        if(t.hasLeft(pos)){
            if(!t.hasRight(pos)){
                t.addRight(pos, r);
            }
        }
        if(t.hasLeft(pos)){
            preOrden(t, r, t.left(pos));
        }
        if(t.hasRight(pos)){
            preOrden(t, r, t.right(pos));
        }
    }
}

