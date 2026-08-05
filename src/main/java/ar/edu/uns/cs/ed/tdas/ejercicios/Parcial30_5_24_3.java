package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Parcial30_5_24_3 {
    public Map<Character, Integer> metodo(Tree<Character> a){
        Map<Character, Integer> mapa = new MapeoConLista<>();
        
        postOrden(a, a.root(), mapa);
        return mapa;
    }

    private void postOrden(Tree<Character> a, Position<Character> raiz, Map<Character, Integer> mapa){
        for(Position<Character> hijo: a.children(raiz)){
            postOrden(a, hijo, mapa);
        }
        if(raiz.element().equals('a')  || raiz.element().equals('e') || raiz.element().equals('i') || raiz.element().equals('o') || raiz.element().equals('u') ){
            mapa.put(raiz.element(), mapa.get(raiz.element()) + 1);
        }
    }
}
