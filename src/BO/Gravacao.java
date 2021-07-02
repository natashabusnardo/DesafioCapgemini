package BO;

import DTO.Anuncio;

import java.text.ParseException;
import java.util.List;


public interface Gravacao {
	
	
	public boolean gravar(List<Anuncio> list);

	public List<Anuncio> ler() throws ParseException;


}