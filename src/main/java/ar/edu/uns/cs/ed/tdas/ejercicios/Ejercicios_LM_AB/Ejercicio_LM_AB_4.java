package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_AB;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BTNodo;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;

public class Ejercicio_LM_AB_4<E> {
    public void eliminarSubarbol(BinaryTree<E> t, Position<E> pos){
        if(pos == t.root()){
            throw new InvalidOperationException("la posicion no puede ser la raiz");
        }
        BTNodo<E> nodo = checkPosition(pos);

        BTNodo<E> padre = nodo.getParent();

        if(padre.getLeft() == nodo){
            nodo.setParent(null);
            padre.setLeft(null);
        }
        else{
            nodo.setParent(null);
            padre.setRight(null);
        }
        //t.size() -= contarNodos(nodo);
    }
    @SuppressWarnings("unused")
    private int contarNodos(BTNodo<E> n){
        int cont = 1;
        if(n.getLeft() != null){
            cont += contarNodos(n.getLeft());
        }
        if(n.getRight() != null){
            cont += contarNodos(n.getRight());
        }
        return cont;
    }

    private BTNodo<E> checkPosition(Position<E> pos){
        if(pos == null){
            throw new InvalidPositionException("la Position es nula");
        }
        BTNodo<E> nodo = null;
        try{
            nodo = (BTNodo<E>) pos;
        }
        catch(ClassCastException e){
            throw new InvalidPositionException("error de casteo");
        }
        return nodo;
    }
}
