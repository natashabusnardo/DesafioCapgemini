package DTO;

import java.util.List;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListaAnuncios {
	protected List<Anuncio> listaAnuncio = new ArrayList<Anuncio>();

	public void inserir(Anuncio a) throws IOException {
		listaAnuncio.add(a);
	}

	public String pesquisaCliente(String cliente) {
		String verAnuncios = " ";

		for (Anuncio anuncio : listaAnuncio) {
			if (cliente.equals(anuncio.getCliente())) {
				verAnuncios += anuncio.toString();
			}
		}
		return verAnuncios;
	}

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
