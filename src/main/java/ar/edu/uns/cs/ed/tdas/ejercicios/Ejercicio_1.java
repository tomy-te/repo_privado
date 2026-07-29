package ar.edu.uns.cs.ed.tdas.ejercicios;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
//fuera de la estructura
public class Ejercicio_1<E> {
    public void eliminarUltimoHijo(Position<E> p, Tree<E> t){
        if (p == t.root()){
            throw new InvalidOperationException("No se puede eliminar la raiz del arbol");
        }
        Position<E> padre = t.parent(p);
        PositionList<Position<E>> hijos = (PositionList<Position<E>>) t.children(padre);
        if(hijos.last() == p){
            hijos.remove(hijos.last());
        }
        else{
            throw new InvalidOperationException("La posicion pasada por parametro no es el ultimo hijo del nodo padre");
        }
    }
}
