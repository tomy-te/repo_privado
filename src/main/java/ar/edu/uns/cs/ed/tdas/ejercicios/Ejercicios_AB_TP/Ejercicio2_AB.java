package ar.edu.uns.cs.ed.tdas.ejercicios.Ejercicios_AB_TP;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BTNodo;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Ejercicio2_AB {
    public PositionList<Character> expresionAritmetica(BinaryTree<Character> a){
        BTNodo<Character> raiz = checkPosition(a.root());
        PositionList<Character> lista = new ListaDoblementeEnlazada<>();
        inorden(raiz, lista);
        return lista;
    }

    private void inorden (BTNodo<Character> nodo, PositionList<Character> lista){
        if (nodo.getLeft() != null){
            inorden(nodo.getLeft(), lista);
        }
        lista.addLast(nodo.getElement());

        if(nodo.getRight() != null){
            inorden(nodo.getRight(), lista);
        }
    }



    private BTNodo<Character> checkPosition (Position<Character> p){
        BTNodo<Character> nodo = null;
        if(p == null){
            throw new InvalidPositionException("Posicion nula");
        }
        try{
            nodo = (BTNodo<Character>) p;
        }
        catch (ClassCastException e){
            throw new InvalidPositionException("Posicion no valida");
        }
        return nodo;
    }
}
