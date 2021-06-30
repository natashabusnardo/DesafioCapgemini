package desafio;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) throws ParseException, IOException {
		// TODO Auto-generated method stub

		ListaAnuncios listaAnuncios = new ListaAnuncios();
		
		Anuncio anuncio = new Anuncio();
		anuncio.setCliente("natasha");
		anuncio.setNome("nome2");
		anuncio.setDataInicio(Anuncio.retornaData("23/05/2014"));
		anuncio.setDataTermino(Anuncio.retornaData("25/05/2014"));
		anuncio.setInvestimentoDia(37);

		listaAnuncios.inserir(anuncio);

		System.out.println(listaAnuncios.toString());

		int valorInvestido = (int) anuncio.valorInvestido(anuncio.getDataInicio(), anuncio.getDataTermino(),
		anuncio.getInvestimentoDia());
		int numVisualizacoes = CalculadoraProjecao.projecao(valorInvestido, false);
		int numVisualizacoesC = CalculadoraProjecao.projecao(valorInvestido, true);
		int numCliques = CalculadoraProjecao.numCliques(numVisualizacoesC);
		int numCompartilhamentos = CalculadoraProjecao.numCompartilhamentos(numCliques);

		System.out.println("Valor total investido: " + valorInvestido);
		System.out.println("Quantidade máxima de visualizações: " + numVisualizacoes);
		System.out.println("Quantidade máxima de cliques: " + numCliques);
		System.out.println("Quantidade máxima de compartilhamentos: " + numCompartilhamentos);

		System.out.println(listaAnuncios.pesquisaCliente("natasha"));
		System.out.println(listaAnuncios.pesquisaIntervalo(Anuncio.retornaData("24/05/2014"), Anuncio.retornaData("24/05/2014")));

	}

}
