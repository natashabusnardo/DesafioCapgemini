package BO;

import java.text.ParseException;
import java.util.List;

import DTO.Anuncio;

/**
 * Classe respons�vel por definir os m�todos nas classes de persit�ncia.
 *
 * @author Natasha Busnardo
 */
public class Persistencia {
	
	private Gravacao g;
	
	public Persistencia(Gravacao g) {
		this.g = g;
	}
	
	public boolean gravar(List<Anuncio> list) {
		return g.gravar(list);
		
	}
	public List<Anuncio> ler() throws ParseException{
		return g.ler();
	}

	
}