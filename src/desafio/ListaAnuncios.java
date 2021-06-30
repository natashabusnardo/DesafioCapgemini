package desafio;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ListaAnuncios {
	protected List<Anuncio> listaAnuncio = new ArrayList<Anuncio>();

	public void inserir(Anuncio a) throws IOException {
		listaAnuncio.add(a);
	}

	public Anuncio pesquisaCliente(String cliente) {
		for (Anuncio anuncio : listaAnuncio) {
			System.out.println(anuncio.getCliente());
			if (cliente.equals(anuncio.getCliente())) {
				return anuncio;
			}
		}
		return null;
	}

	public Anuncio pesquisaIntervalo(Date dataInicio, Date dataFinal) {
		for (Anuncio anuncio : listaAnuncio) {
			if (dataInicio.after(anuncio.getDataInicio()) && dataFinal.before(anuncio.getDataTermino())) {
				return anuncio;
			}
		}
		return null;
	}
	

	public ListaAnuncios() {
		listaAnuncio = new ArrayList<>();
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
