package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TDAArbol;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TNodo;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;


public class Parcial20_6_23_1<E> extends TDAArbol<E> {
    public void eliminarUltimoHijo(Position<E> p) throws InvalidPositionException { 
        
        TNodo<E> nodo = checkPosition(p);

        if(nodo.padre() == null){
            throw new InvalidPositionException("la posicion es la raiz del arbol");
        }

        if(nodo != nodo.padre().Hijos().last().element()){
            throw new InvalidOperationException("la posicion del nodo no es la ultima");
        }
        else{
            TNodo<E> padre = nodo.padre();
            PositionList<TNodo<E>> hijos_p = padre.Hijos();

            for(TNodo<E> hijo : nodo.Hijos()){
                hijo.setPadre(padre);
                hijos_p.addLast(hijo);
            }
            hijos_p.remove(hijos_p.last());
            size --;
        }
    }
}
