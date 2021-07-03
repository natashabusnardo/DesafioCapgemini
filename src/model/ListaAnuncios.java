package model;

import java.util.List;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe responsável por criar lista de Anuncios
 *
 * @author Natasha Busnardo
 */
public class ListaAnuncios {
	protected List<Anuncio> listaAnuncio = new ArrayList<Anuncio>();

	public void inserir(Anuncio a) throws IOException {
		listaAnuncio.add(a);
	}

	/**
	 * Método que realiza a pesquisa por nome do cliente.
	 * 
	 * @param cliente
	 * @return Retona uma String com todos os resultados da busca.
	 */

	public String pesquisaCliente(String cliente) {
		String verAnuncios = " ";

		for (Anuncio anuncio : listaAnuncio) {
			if (cliente.equals(anuncio.getCliente())) {
				verAnuncios += anuncio.toString();
			}
		}
		return verAnuncios;
	}

	/**
	 * Método que realiza a pesquisa por intervalo de tempo.
	 * 
	 * @param dataInicio, dataFinal
	 * @return Retona uma String concatenando todos os resultados da busca.
	 */
	public String pesquisaIntervalo(Date dataInicio, Date dataFinal) {
		String verAnuncios = " ";

		for (Anuncio anuncio : listaAnuncio) {
			if (dataInicio.after(anuncio.getDataInicio()) && dataFinal.before(anuncio.getDataTermino())) {
				verAnuncios += anuncio.toString();
			}
		}
		return verAnuncios;
	}

	public ListaAnuncios() {
		listaAnuncio = new ArrayList<>();
	}

	/**
	 * Método que converte Date para StringDate no formato do MySQL.
	 * 
	 * @param pDate
	 * @return Retona uma String concatenando todos os resultados da busca.
	 */
	public static String DataForStringMySQL(Date pDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String s = "";
		try {
			s = df.format(pDate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}

	/**
	 * Método que converte StringDate no formato do MySQL para Date.
	 * 
	 * @param pDate
	 * @return Retona um objeto no formato yyyy-MM-dd H:mm:ss.
	 */
	public static Date DataMySQLHoraDia(String pDate) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");

		Date dia = null;
		try {

			dia = df.parse(pDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dia;
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
