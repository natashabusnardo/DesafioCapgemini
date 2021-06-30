package desafio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		Anuncio anuncio = new Anuncio();
		
		anuncio.setCliente("rafa");
		anuncio.setNome("nome");
		anuncio.setDataInicio(Anuncio.retornaData("23/05/2014"));
		anuncio.setDataTermino(Anuncio.retornaData("24/05/2014"));
		anuncio.setInvestimentoDia(37);
		
		anuncios.add(anuncio);
		
		anuncio.setCliente("natasha");
		anuncio.setNome("nome2");
		anuncio.setDataInicio(Anuncio.retornaData("23/05/2014"));
		anuncio.setDataTermino(Anuncio.retornaData("24/05/2014"));
		anuncio.setInvestimentoDia(37);
		
		anuncios.add(anuncio);
		
		System.out.println(anuncios.toString());
		
		
		int valorInvestido = (int) anuncio.valorInvestido(anuncio.getDataInicio(), anuncio.getDataTermino(), anuncio.getInvestimentoDia());
		int numVisualizacoes = CalculadoraProjecao.projecao(valorInvestido, false);
		int numVisualizacoesC = CalculadoraProjecao.projecao(valorInvestido, true);
		int numCliques = CalculadoraProjecao.numCliques(numVisualizacoesC);
		int numCompartilhamentos = CalculadoraProjecao.numCompartilhamentos(numCliques);
		
		System.out.println("Valor total investido: "+valorInvestido);
		System.out.println("Quantidade máxima de visualizações: "+numVisualizacoes);
		System.out.println("Quantidade máxima de cliques: "+numCliques);
		System.out.println("Quantidade máxima de compartilhamentos: "+numCompartilhamentos);
				
		
	}

}
