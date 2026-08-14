
package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_Parciales;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TDAArbol;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TNodo;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Parcial30_5_24_2<E> extends TDAArbol<E>{
    public Iterable<E> convertirAHoja(Position<E> p) throws InvalidPositionException {
        PositionList<E> rta = new ListaDoblementeEnlazada<>();
        if(p == null){
            throw new InvalidPositionException("Posicion nula");
        }
        else{
            TNodo<E> nodo = checkPosition(p);
            size -= cantEliminados(nodo);
            postOrden(nodo, rta, p);
            for(TNodo<E> hijo : nodo.Hijos()){
                hijo.setPadre(null);
                nodo.vaciarHijos();
            }
        }
        return rta;
    }
    private int cantEliminados(TNodo<E> nodo){
        int cont = 1;
        for(TNodo<E> hijos : nodo.Hijos()){
            cont += cantEliminados(hijos);
        }
        return cont;
    }

    private void postOrden(TNodo<E> nodo, PositionList<E> lista, Position<E> p){
        for(TNodo<E> hijo : nodo.Hijos()){
            postOrden(hijo, lista, p);
        }
        TNodo<E> otro = checkPosition(p);
        if(nodo != otro){
            lista.addLast(nodo.element());

        }
    }
}
