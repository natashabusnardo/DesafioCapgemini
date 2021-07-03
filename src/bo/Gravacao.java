package bo;

import java.text.ParseException;
import java.util.List;

import model.Anuncio;

/**
 * Interface respons�vel pelos m�todos de persist�ncia.
 *
 * @author Natasha Busnardo
 */
public interface Gravacao {
	
	
	public boolean gravar(List<Anuncio> list);

	public List<Anuncio> ler() throws ParseException;


}