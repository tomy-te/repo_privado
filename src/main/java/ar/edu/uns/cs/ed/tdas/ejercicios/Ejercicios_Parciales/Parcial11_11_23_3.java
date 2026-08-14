package ar.edu.uns.cs.ed.tdas.ejercicios.Ejercicios_Parciales;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Parcial11_11_23_3 {
    public Map<Character, Integer> cantOperadores(BinaryTree<Character> a){
        Map<Character, Integer> mapa = new MapeoConLista<>();

        preOrden(a.root(), a, mapa);

        return mapa;
    }

    private void preOrden(Position<Character> p, BinaryTree<Character> a, Map<Character, Integer> mapa){
        if(a.hasLeft(p) || a.hasRight(p)){
            Character c = p.element();
            mapa.put(c, mapa.get(c) + 1);
        }

        if(a.hasLeft(p)){
            preOrden(a.left(p), a, mapa);
        }
        if(a.hasRight(p)){
            preOrden(a.right(p), a, mapa);
        }
    }
}
