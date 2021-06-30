package desafio;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class ListaAnuncios {
	List<Anuncio> listaAnuncio = new ArrayList<Anuncio>();
	
	public List<Anuncio> getLista(){
		return listaAnuncio;
	}
	
	public void setLista(List<Anuncio> listaAnuncio) {
		this.listaAnuncio = listaAnuncio;
	}
	
	public void inserir(Anuncio a) throws IOException {
		listaAnuncio.add(a);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaAnuncios [listaAnuncio=");
		builder.append(listaAnuncio);
		builder.append("]");
		return builder.toString();
	}
	
	
}
