package ar.edu.uns.cs.ed.tdas.tdamapeo;

import ar.edu.uns.cs.ed.tdas.Entrada;
import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidKeyException;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import java.util.Iterator;

public class MapeoConLista<K, V> implements Map<K, V> {
    protected ListaDoblementeEnlazada<Entrada<K,V>> lista;
	
	public MapeoConLista() {
		this.lista = new ListaDoblementeEnlazada<>();
	}

	@Override
	public int size() {
		return this.lista.size();
	}

	@Override
	public boolean isEmpty() {
		return this.lista.isEmpty();
	}

	@Override
	public V get(K key) {
		if(key == null) {throw new InvalidKeyException("La clave del get es nula");}
		else {
			V resultado = null;
			Iterator<Entrada<K,V>> ite = this.lista.iterator();
			boolean encontre = false;
			while(ite.hasNext()&&!encontre) {
				Entrada<K,V> e = ite.next();
				if(e.getKey() == key) {
					encontre = true;
					resultado = e.getValue();
				}
			}
			return resultado;
		}
	}

	@Override
	public V put(K key, V value) {
		if(key == null) {throw new InvalidKeyException("La clave del put es nula");}
		else {
			V resultado = null;
			Iterator<Entrada<K,V>> ite = this.lista.iterator();
			boolean encontre = false;
			while(ite.hasNext()&&!encontre) {
				Entrada<K,V> e = ite.next();
				if(e.getKey() == key) {
					encontre = true;
					resultado = e.getValue();
					e.setValue(value);
				}
			}
			if(!encontre) {
				Entrada<K,V> nueva = new Entrada<>(key, value);
				this.lista.addLast(nueva);
			}
			return resultado;
		}
	}

	@Override
	public V remove(K key) {
		if(key == null) {throw new InvalidKeyException("La clave del remove es nula");}
		else {
			V resultado = null;
			Iterator<Position<Entrada<K,V>>> ite = this.lista.positions().iterator();
			boolean encontre = false;
			while(ite.hasNext()&&!encontre) {
				Position<Entrada<K,V>> elemento = ite.next();
				Entrada<K,V> e = elemento.element();
				if(e.getKey() == key) {
					encontre = true;
					resultado = e.getValue();
					this.lista.remove(elemento);
				}
			}
			return resultado;
		}
	}

	@Override
	public Iterable<K> keys() {
		PositionList<K> resultado = new ListaDoblementeEnlazada<>();
		for(Entry<K,V> entrada : this.lista ) {
			resultado.addLast(entrada.getKey());
		}
		return resultado;
	}

	@Override
	public Iterable<V> values() {
		PositionList<V> resultado = new ListaDoblementeEnlazada<>();
		for(Entry<K,V> entrada : this.lista ) {
			resultado.addLast(entrada.getValue());
		}
		return resultado;
	}

	@Override
	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K, V>> resultado = new ListaDoblementeEnlazada<>();
		for(Entry<K,V> entrada : this.lista ) {
			resultado.addLast(entrada);
		}
		return resultado;
	}

}

    

