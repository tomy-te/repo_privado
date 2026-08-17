package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_A;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Ejercicio_LM_5<E> {
    public PositionList<E> elementosEnNivel(Tree<E> a, int k){
        if(k < 0){
            throw new InvalidOperationException("k es un numero negativo");
        }
        PositionList<E> lista = new ListaDoblementeEnlazada<>();
        int n = 0;
        if(!a.isEmpty()){
            preOrden(a, a.root(), k, lista, n);
        }
        
        return lista;
    }

    private void preOrden(Tree<E> a, Position<E> pos, int k, PositionList<E> lista, int n){

        if(n == k){
            lista.addLast(pos.element());
        }
        for(Position<E> p : a.children(pos)){
            preOrden(a, p, k, lista, n + 1);
        }
    }
}
