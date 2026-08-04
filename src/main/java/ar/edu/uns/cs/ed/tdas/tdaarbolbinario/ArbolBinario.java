package ar.edu.uns.cs.ed.tdas.tdaarbolbinario;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyTreeException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import java.util.Iterator;

public class ArbolBinario<E> implements BinaryTree<E> {
    protected BTNodo<E> raiz;
    protected int size;
    
    public ArbolBinario() {
        this.raiz = null;
        this.size = 0;
    }


    protected  BTNodo<E> checkPosition (Position<E> p) {
		BTNodo<E> resultado = null;
		if (p == null) {
			throw new InvalidPositionException("Posición nula.");
		}

		if (this.isEmpty()) {
			throw new InvalidPositionException("Posición inválida");
		}

		try {
			resultado = (BTNodo<E>) p;
		} catch (ClassCastException e) {
			throw new InvalidPositionException("Posición inválida");
		}

		return resultado;
	}

    @Override
    public Position<E> addLeft(Position<E> v, E r) {
        BTNodo<E> n = checkPosition(v);

        if (n.getLeft()!=null) {
            throw new InvalidOperationException("Error: La posición ya tiene un hijo izquierdo.");
        }

        BTNodo<E> hi = new BTNodo<>(r, null, null, n);
        n.setLeft(hi);
        return hi;
    }

    @Override
    public Position<E> addRight(Position<E> v, E r) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void attach(Position<E> r, BinaryTree<E> T1, BinaryTree<E> T2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasRight(Position<E> v) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Position<E> left(Position<E> v) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<E> right(Position<E> v) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<E> addAfter(Position<E> p, Position<E> lb, E e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<E> addBefore(Position<E> p, Position<E> rb, E e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<E> addFirstChild(Position<E> p, E e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<E> addLastChild(Position<E> p, E e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> v) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createRoot(E e) {
        if (this.raiz!=null) {
            throw new InvalidOperationException("Error: El árbol ya tiene raíz.");
        }
        raiz = new BTNodo<>(e, null, null, null);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isExternal(Position<E> v) {
        BTNodo<E> n = checkPosition(v);

        return n.getLeft()==null && n.getRight()==null;
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !isExternal(v);
    }

    @Override
    public boolean isRoot(Position<E> v) {
        BTNodo<E> n = checkPosition(v);
        return n==this.raiz;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        BTNodo<E> n = checkPosition(v);
        if (n.getParent()==null) {
            throw new BoundaryViolationException("Error: La raíz no tiene padre.");
        }
        return n.getParent();
    }

    @Override
    public Iterable<Position<E>> positions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeExternalNode(Position<E> p) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeInternalNode(Position<E> p) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeNode(Position<E> p) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E replace(Position<E> v, E e) {
        BTNodo<E> n = checkPosition(v);
        E resultado = n.getElement();
        n.setElement(e);
        return resultado;
    }

    @Override
    public Position<E> root() {
        if (size==0)
            throw new EmptyTreeException("Error: el árbol está vacío y no tiene raíz.");
        return this.raiz;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void remove(Position<E> v) {
        BTNodo<E> n = checkPosition(v);
        if (n.getLeft()!=null && n.getRight()!=null) {
            throw new InvalidOperationException("Error: La posición tiene dos hijos.");
        }
        BTNodo<E> hijo = (n.getLeft()!=null) ? n.getLeft() : n.getRight();
        if (hijo!=null) {
            hijo.setParent(n.getParent());
        }
        if (n==this.raiz) {
            this.raiz = hijo;
        } else {
            BTNodo<E> padre = n.getParent();
            if (padre.getLeft()==n) {
                padre.setLeft(hijo);
            } else {
                padre.setRight(hijo);
            }
        }
        size--;
    }
    
}
    

