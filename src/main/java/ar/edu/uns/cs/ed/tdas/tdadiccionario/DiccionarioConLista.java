package ar.edu.uns.cs.ed.tdas.tdadiccionario;

import ar.edu.uns.cs.ed.tdas.Entrada;
import ar.edu.uns.cs.ed.tdas.Entry;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidEntryException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidKeyException;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import java.util.Iterator;

public class DiccionarioConLista<K, V> implements Dictionary<K, V> {
    	protected ListaDoblementeEnlazada<Entrada<K,V>> lista;
	
	public  DiccionarioConLista() {
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
	public Entry<K, V> find(K key) {
		if( key == null ) { throw new InvalidKeyException("Clave nula en find");}
		else {
			Entry<K,V> resultado = null;
			Iterator<Entrada<K,V>> ite = this.lista.iterator();
			boolean encontre = false;
			while(ite.hasNext()&&!encontre) {
				Entrada<K,V> entrada = ite.next();
				if(entrada.getKey()==key) {
					encontre = true;
					resultado = entrada;
				}
			}
			return resultado;	
		}
	}

	@Override
	public Iterable<Entry<K, V>> findAll(K key) {
		if( key == null ) { throw new InvalidKeyException("Clave nula en find");}
		else {
			PositionList<Entry<K,V>> resultado = new ListaDoblementeEnlazada<>();
			for(Entry<K,V> entrada : this.lista ) {
				if(entrada.getKey() == key) {
					resultado.addLast(entrada);
				}
			}
			return resultado;
 		}
	}

	@Override
	public Entry<K, V> insert(K key, V value) {
		if( key == null ) { throw new InvalidKeyException("Clave nula en find");}
		else {
			boolean encontre = false;
			Iterator<Entrada<K,V>> ite = this.lista.iterator();
			Entrada<K,V> resultado = null;
			while(ite.hasNext()&&!encontre) {
				resultado = ite.next();
				if( (resultado.getKey() == key)&&(resultado.getValue()==value)) {
					encontre = true;
				}
			}
			if(!encontre) {
				resultado = new Entrada<>(key, value);
				this.lista.addLast(resultado);
			}
			return resultado;
		}
	}

	@Override
	public Entry<K, V> remove(Entry<K, V> e) {
		if( e == null ) { throw new InvalidEntryException("Entrada invalidad en remove");}
		else {
			boolean encontre = false;
			Entry<K,V> resultado = null;
			Iterator<Position<Entrada<K,V>>> ite = this.lista.positions().iterator();
			while(ite.hasNext()&&!encontre) {
				Position<Entrada<K,V>> pos = ite.next();
				if(pos.element().getKey()==e.getKey()&&pos.element().getValue()==e.getValue()) {
					resultado = pos.element();
					this.lista.remove(pos);
					encontre = true;
				}
			}
			if(!encontre) {throw new InvalidEntryException("No está la entry");}
			else {return resultado;}
		}
	}

	@Override
	public Iterable<Entry<K, V>> entries() {
		// TODO Auto-generated method stub
		return null;
	}

}


