package ar.edu.uns.cs.ed.tdas.ejercicios.Ejercicios_Parciales;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TDAArbol;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TNodo;

/**class TNodo<E> implements Position<E> {
        private E e;
        private TNodo<E> padre;
        private PositionList<TNodo<E>> hijos;

        public TNodo(E elemento, TNodo<E> p){
            e = elemento;
            padre = p;
            hijos = new ListaDoblementeEnlazada<>();
        }
        @Override
        public E element(){
            return e;
        }    
        public TNodo<E> getPadre(){
            return padre;
        }
        public PositionList<TNodo<E>> Hijos(){
            return hijos;
        }
        public void setElemento(E e){
            this.e = e;
        }
        public void setPadre(TNodo<E> p){
            padre = p;
        }
        
    }

   **/



public class Parcial26_6_25_2<E> extends TDAArbol<E> {
    public void agregarHijo(Position<E> p, E e){
        TNodo<E> nodo = checkPosition(p);
        int cantRecorrido = postOrden(nodo, e);
        size += cantRecorrido;
    }

    private int postOrden(TNodo<E> nodo, E e){
        int cant = 0;
        for(TNodo<E> hijo : nodo.Hijos()){
            cant += postOrden(hijo, e);
        }
        nodo.Hijos().addLast(new TNodo<>(e, nodo));
        return cant + 1;
    }

    
    @Override
     protected TNodo<E> checkPosition(Position<E> p){
        if(p == null){
            throw new InvalidPositionException("La posicion en nula");
        }
        if(this.isEmpty()){
            throw new EmptyTreeException("El arbol esta vacio");
        }
        TNodo<E> nodo = null;
        try{
            nodo = (TNodo<E>) p;
        }
        catch(ClassCastException e){
            throw new InvalidPositionException("La posicion no es valida");
        }
        return nodo;
    }
}
 