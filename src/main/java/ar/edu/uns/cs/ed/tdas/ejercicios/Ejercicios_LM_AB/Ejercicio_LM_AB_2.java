package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_AB;


import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbolbinario.BinaryTree;
import ar.edu.uns.cs.ed.tdas.tdadiccionario.DiccionarioConLista;
import ar.edu.uns.cs.ed.tdas.tdadiccionario.Dictionary;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Ejercicio_LM_AB_2<E> {
    public Dictionary<E, PositionList<E>> padre_Hijos(BinaryTree<E> t){
        Dictionary<E, PositionList<E>> dic = new DiccionarioConLista<>();
        if(!t.isEmpty()){
            preOrden(t, dic, t.root());
        }
        return dic;
    }

    private void preOrden(BinaryTree<E> t, Dictionary<E, PositionList<E>> dic,  Position<E> r){
        if(t.isInternal(r)){
            PositionList<E> lista = new ListaDoblementeEnlazada<>();

            if(t.hasLeft(r)){
                lista.addLast(t.left(r).element());
            }
            if(t.hasRight(r)){
                lista.addLast(t.right(r).element());
            }
            dic.insert(r.element(), lista);
        }
        if(t.hasLeft(r)){
            preOrden(t, dic, t.left(r));
        }
        if(t.hasRight(r)){
            preOrden(t, dic, t.right(r));
        }
    }
}
