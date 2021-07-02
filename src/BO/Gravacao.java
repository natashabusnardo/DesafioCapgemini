package BO;

import DTO.Anuncio;

import java.text.ParseException;
import java.util.List;

/**
 * Interface respons�vel pelos m�todos de persist�ncia.
 *
 * @author Natasha Busnardo
 */
public interface Gravacao {
	
	
	public boolean gravar(List<Anuncio> list);

	public List<Anuncio> ler() throws ParseException;


}