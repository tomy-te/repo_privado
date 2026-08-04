package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TDAArbol;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TNodo;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Parcial23_10_25_2<E> extends TDAArbol<E> {
    public boolean eliminarUltimo(Position<E> p) throws InvalidPositionException {
        TNodo<E> nodo = checkPosition(p);
        if(nodo == root){
            return false;
        }
        TNodo<E> padre = nodo.padre();
        PositionList<TNodo<E>> hijos_padre = padre.Hijos();

        if(hijos_padre.isEmpty()){
            return false;
        }
        Position<TNodo<E>> ultimo = hijos_padre.last();
        if(nodo == ultimo.element()){
            PositionList<TNodo<E>> hijos_nodo = nodo.Hijos();

            while(!hijos_nodo.isEmpty()){

                Position<TNodo<E>> hijo = hijos_nodo.first();
                
                hijos_padre.addBefore(ultimo, hijo.element());
                
                hijo.element().setPadre(padre);
                
                hijos_nodo.remove(hijo);
            }
            hijos_padre.remove(ultimo);
            
            size--;
        }
        return true;
    }

    @Override
    protected  TNodo<E> checkPosition(Position<E> p) {
        TNodo<E> nodo = null;
        if(p == null){
            throw new InvalidPositionException("la Posicion es nula");
        }
        if(isEmpty()){
            throw new EmptyTreeException("el arbol esta vacio");
        }
        try{
            nodo = (TNodo<E>) p;
        }
        catch(ClassCastException e){
            throw new InvalidPositionException("La Posicion no es valida");
        }
        return nodo;
    }
}
