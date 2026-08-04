package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Parcial23_10_25_1 {
    public Map<Character, Integer> eliminarHojas(BinaryTree<Character> a, Position<Character> p) throws InvalidPositionException {
        if(p == null){
            throw new InvalidPositionException("La posicion es nula");
        }
        Map<Character, Integer> mapa = new MapeoConLista<>();
        postOrden(a, p, mapa);

        return mapa;
    }

    private void postOrden(BinaryTree<Character> a, Position<Character> p, Map<Character, Integer> mapa){
        if(a.hasLeft(p)){
            postOrden(a, a.left(p), mapa);
        }
        if(a.hasRight(p)){
            postOrden(a, a.right(p), mapa);
        }
        
        if(!a.hasLeft(p) && !a.hasRight(p)){
            Character car = p.element();
            Integer cont = mapa.get(car);
            if(cont != null){
                mapa.put(car, cont + 1);
            }
            else{
                mapa.put(car, 1);
            }
            a.remove(p);
        }
    }
}
