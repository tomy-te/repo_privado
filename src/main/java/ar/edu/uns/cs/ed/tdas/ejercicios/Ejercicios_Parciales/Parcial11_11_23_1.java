package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_Parciales;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TDAArbol;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TNodo;

public class Parcial11_11_23_1<E> extends TDAArbol<E>{
    public int sizeSubArbol(Position<E> p) throws InvalidPositionException{
        int cont = 0;
        if(p == null){
            throw new InvalidPositionException("la posicion en nula");
        }
        else{
            TNodo<E> nodo = checkPosition(p);
            cont = preOrden(nodo);
        }
        return cont;
    }

    private int preOrden(TNodo<E> nodo){
        int cont = 1;
        for(TNodo<E> hijo : nodo.Hijos()){
            cont += preOrden(hijo);
        }
        return cont;
    }
}
