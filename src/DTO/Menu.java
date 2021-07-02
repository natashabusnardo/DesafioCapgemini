package DTO;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BO.Gravacao;
import BO.Persistencia;
import DAO.GravarBD;
import DAO.GravarCSV;

public class Menu {
	Scanner entrada = new Scanner(System.in);
	private ListaAnuncios listaAnuncios;

	public Menu() throws IOException {
		
		listaAnuncios = new ListaAnuncios();

		Anuncio a1 = new Anuncio("Anuncio1", "natasha", "23/05/2014", "25/05/2014", 37);
		Anuncio a2 = new Anuncio("Anuncio2", "rafa", "23/05/2015", "25/05/2015", 45);
		Anuncio a3 = new Anuncio("Anuncio2", "dani", "23/05/2014", "25/05/2014", 45);

		listaAnuncios.inserir(a1);
		listaAnuncios.inserir(a2);
		listaAnuncios.inserir(a3);

	}

	public int buildMainMenu() {

		int opcao;

		StringBuilder builder = new StringBuilder();

		builder.append("\n ----------Calculadora de An�ncios------------");
		builder.append("\n1 - Cadastrar An�ncio");
		builder.append("\n2 - Filtrar an�ncios por intervalo de tempo");
		builder.append("\n3 - Filtrar an�ncios por cliente");
		builder.append("\n4 - Sair");

		System.out.println(builder.toString());

		opcao = entrada.nextInt();
		entrada.nextLine();

		return opcao;
	}

	public void cadastrarAnuncio() throws ParseException, IOException {

		GravarCSV csv = new GravarCSV();
		Gravacao gravar = new GravarBD();

		Persistencia pers = new Persistencia(csv);
		Persistencia persBD = new Persistencia(gravar);

		Anuncio anuncio = new Anuncio();
		List<Anuncio> anuncios = new ArrayList<Anuncio>();

		System.out.println("Insira o nome do an�ncio: ");
		anuncio.setNome(entrada.next());

		System.out.println("Insira o cliente: ");
		anuncio.setCliente(entrada.next());

		System.out.println("Insira a data de �nicio do an�ncio: ");
		anuncio.setDataInicio(Anuncio.retornaData(entrada.next()));

		System.out.println("Insira a data de t�rmino do an�ncio: ");
		anuncio.setDataTermino(Anuncio.retornaData(entrada.next()));

		System.out.println("Insira o investimento por dia: ");
		anuncio.setInvestimentoDia(entrada.nextInt());

		listaAnuncios.inserir(anuncio);

		anuncios.add(anuncio);

		int valorInvestido = (int) anuncio.valorInvestido(anuncio.getDataInicio(), anuncio.getDataTermino(),
				anuncio.getInvestimentoDia());
		int numVisualizacoes = CalculadoraProjecao.projecao(valorInvestido, false);
		int numVisualizacoesC = CalculadoraProjecao.projecao(valorInvestido, true);
		int numCliques = CalculadoraProjecao.numCliques(numVisualizacoesC);
		int numCompartilhamentos = CalculadoraProjecao.numCompartilhamentos(numCliques);

		System.out.println("Valor total investido: " + valorInvestido);
		System.out.println("Quantidade m�xima de visualiza��es: " + numVisualizacoes);
		System.out.println("Quantidade m�xima de cliques: " + numCliques);
		System.out.println("Quantidade m�xima de compartilhamentos: " + numCompartilhamentos);

		pers.gravar(anuncios);
		persBD.gravar(anuncios);
	}

	public void pesquisaIntervaloTempo() throws ParseException {

		System.out.println("Insira a data de �nicio do an�ncio: ");
		String dataInicio = entrada.next();

		System.out.println("Insira a data de t�rmino do an�ncio: ");
		String dataTermino = entrada.next();

		System.out.println(listaAnuncios.pesquisaIntervalo(Anuncio.retornaData(dataInicio), Anuncio.retornaData(dataTermino)));
	}

	public void pesquisaCliente() {
		System.out.println("Insira o cliente: ");
		String cliente = entrada.next();

		System.out.println(listaAnuncios.pesquisaCliente(cliente));
	}

	public void selecionarOpcao(int opcao) throws ParseException, IOException {
		
		switch (opcao) {
		case 1:
			cadastrarAnuncio();
			break;

		case 2:
			pesquisaIntervaloTempo();
			break;

		case 3:
			pesquisaCliente();
			break;

		case 4:
			System.out.println("Obrigada. Volte Sempre!");
			break;

		default:
			System.out.println("Op��o inv�lida. Tente novamente.");
			break;
		}

	}
}
