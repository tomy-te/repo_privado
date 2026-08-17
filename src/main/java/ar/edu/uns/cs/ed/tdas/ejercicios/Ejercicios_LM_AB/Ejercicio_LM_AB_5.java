package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_AB;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BTNodo;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;

public class Ejercicio_LM_AB_5<E> {
    public int contarHijosUnicos(BinaryTree<E> t){
        if(t.isEmpty()){
            return 0;
        }
        BTNodo<E> nodo = checkPosition(t.root()); 
        int cont = preOrden(nodo);

        return cont;
    }

    private int preOrden(BTNodo<E> nodo) {
        int cont = 0;    
        if((nodo.getLeft() != null && nodo.getRight() == null) || (nodo.getLeft() == null && nodo.getRight() != null)){
            cont = 1;
        }
        return cont + preOrden(nodo.getLeft()) + preOrden(nodo.getRight());
    }

    private BTNodo<E> checkPosition(Position<E> pos){
        if(pos == null){
            throw new InvalidPositionException("la posicion es nula");
        }
        BTNodo<E> nodo = null;

        try{
            nodo = (BTNodo<E>) pos;
        }
        catch(ClassCastException e){
            throw new InvalidOperationException("El casteo no es valido");
        }
        return nodo;
    }
}
