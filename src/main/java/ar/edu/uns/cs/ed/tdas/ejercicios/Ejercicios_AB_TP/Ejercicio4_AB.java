package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_AB_TP;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.ArbolBinario;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BTNodo;

public class Ejercicio4_AB<E> extends ArbolBinario<E> {
    public void eliminarSubarbol(Position<E> p){
        BTNodo<E> nodo = checkPosition(p);
        BTNodo<E> padre = nodo.getParent();
        if(padre == null){
            raiz = null;
        }
        else{
            if(padre.getLeft() == nodo){
                padre.setLeft(null);
            }
            else{
                padre.setRight(null);
            }
            nodo.setParent(null);
        }
        size -= contarNodos(nodo);
    }

    private int contarNodos(BTNodo<E> nodo){
        int cont = 1;
        if(nodo == null){
            return 0;
        }
        else{
            cont += contarNodos(nodo.getLeft());
            cont += contarNodos(nodo.getRight());
            return cont;
        }
    }
}
