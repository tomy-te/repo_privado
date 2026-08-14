package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_AB;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Ejercicio_LM_AB_3 {
    public PositionList<Character> infija(BinaryTree<Character> t){
        if(t.isEmpty() || t == null){
            throw new EmptyTreeException("el arbol esta vacio");
        }
        PositionList<Character> lista = new ListaDoblementeEnlazada<>();

        inorden(t, t.root(), lista);

        return lista;
    }

    private void inorden(BinaryTree<Character> t, Position<Character> r, PositionList<Character> lista){
        if(t.hasLeft(r)){
            inorden(t, t.left(r), lista);
        }

        lista.addLast(r.element());

        if(t.hasRight(r)){
            inorden(t, t.right(r), lista);
        }
    }
}
