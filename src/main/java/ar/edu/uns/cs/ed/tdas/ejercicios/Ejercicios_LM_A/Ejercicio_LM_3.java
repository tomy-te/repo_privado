package ar.edu.uns.cs.ed.tdas.ejercicios.Ejercicios_LM_A;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TDAArbol;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TNodo;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Ejercicio_LM_3<E> extends TDAArbol<E>{
    public void eliminarUltimo(Position<E> pos) throws InvalidOperationException {
        if(pos.equals(root())){
            throw new InvalidOperationException("La posicion invalida");
        }
        else{
            TNodo<E> nodo = checkPosition(pos);
            TNodo<E> padre = nodo.padre();
            PositionList<TNodo<E>> hijos = padre.Hijos();

            if(hijos.last().equals(nodo)){
                Position<TNodo<E>> ultimo = hijos.last();
                for(TNodo<E> h : nodo.Hijos()){
                    h.setPadre(padre);
                    hijos.addBefore(ultimo, h);
                }
                hijos.remove(ultimo);
            }

        }
    }
}
