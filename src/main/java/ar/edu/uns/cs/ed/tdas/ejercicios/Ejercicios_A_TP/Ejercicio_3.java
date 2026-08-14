package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_A_TP;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TDAArbol;
import ar.edu.uns.cs.ed.tdas.tdaarbol.TNodo;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Ejercicio_3 extends TDAArbol<String>{
        public PositionList<Position<String>> listaDePosiciones(Tree<String> t, String s){    
            PositionList<Position<String>> lista = new ListaDoblementeEnlazada<>();
                TNodo<String> raiz = checkPosition(t.root());
                postOrden(t, s, raiz, lista);
            return lista;
        }

        private void postOrden(Tree<String> t, String s, TNodo<String> raiz, PositionList<Position<String>> lista){
            for(TNodo<String> hijo : raiz.Hijos()){
                postOrden(t, s, hijo, lista);
            }
            if(raiz.element().equals(s)){
                lista.addLast(raiz);
            }
        }
}
