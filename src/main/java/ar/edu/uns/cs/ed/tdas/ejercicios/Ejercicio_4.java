package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TDAArbol;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;

//DENTRO DE LA ESTRUCTURA DE TDAArbol
public class Ejercicio_4<E> extends TDAArbol<E>{
    public int cantidadDeEliminaciones(Tree<E> t, E e){
        int cant = 0;
        if(!t.isEmpty()){
            Position<E> r = t.root();
            cant = postOrden(t, e, r, cant);
        }
        return cant;
    }

    private int postOrden(Tree<E> t, E e, Position<E> p, int cant){
        for(Position<E> hijo : t.children(p)){
            cant = postOrden(t, e, hijo, cant);
        }
        if(p.element().equals(e)){
            cant++;
            t.removeNode(p);
        }
        return cant;
    }
}