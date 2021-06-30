package desafio;

import java.text.ParseException;
import java.util.List;


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