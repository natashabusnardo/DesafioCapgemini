package bo;

import java.text.ParseException;
import java.util.List;

import model.Anuncio;

/**
 * Interface responsável pelos métodos de persistência.
 *
 * @author Natasha Busnardo
 */
public interface Gravacao {
	
	
	public boolean gravar(List<Anuncio> list);

	public List<Anuncio> ler() throws ParseException;


}