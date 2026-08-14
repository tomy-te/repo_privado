package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_AB_TP;

import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.ArbolBinario;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BTNodo;
import ar.edu.uns.cs.ed.tdas.tdadiccionario.DiccionarioConLista;
import ar.edu.uns.cs.ed.tdas.tdadiccionario.Dictionary;

public class Ejercicio1_AB<E> extends ArbolBinario<E> {
    public Dictionary<E, E> metodo() {
        Dictionary<E, E> diccionario = new DiccionarioConLista<>();
        BTNodo<E> r = checkPosition(this.root());
        preOrden(r, diccionario);
        return diccionario;
    }

    private void preOrden(BTNodo<E> raiz, Dictionary<E, E> dic){
        if(raiz.getLeft() != null){
            dic.insert(raiz.getElement(), raiz.getLeft().getElement());
            preOrden(raiz.getLeft(), dic);
        }
        if(raiz.getRight() != null){
            dic.insert(raiz.getElement(), raiz.getRight().getElement());
            preOrden(raiz.getRight(), dic);
        }
    }
}
