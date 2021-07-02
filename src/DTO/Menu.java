package DTO;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import BO.Gravacao;
import BO.Persistencia;
import DAO.GravarBD;
import DAO.GravarCSV;

/**
 * Classe responsável por implementar o manu ao usuário
 *
 * @author Natasha Busnardo
 */
public class Menu {
	Scanner entrada = new Scanner(System.in);
	private ListaAnuncios listaAnuncios;

	public Menu() throws IOException {

		listaAnuncios = new ListaAnuncios();

	}

	/**
	 * Método que imprime as opções do menu ao usuário.
	 * 
	 */
	public int buildMainMenu() {

		int opcao;

		StringBuilder builder = new StringBuilder();

		builder.append("\n ----------Calculadora de Anúncios------------");
		builder.append("\n1 - Cadastrar Anúncio");
		builder.append("\n2 - Filtrar anúncios por intervalo de tempo");
		builder.append("\n3 - Filtrar anúncios por cliente");
		builder.append("\n4 - Sair");

		System.out.println(builder.toString());

		opcao = entrada.nextInt();
		entrada.nextLine();

		return opcao;
	}

	/**
	 * Método que recebe os valores do usuário para cadastro de novo anúncio e
	 * retorna os parâmetros da classe CalculadoraAnuncio.
	 * 
	 */
	public void cadastrarAnuncio() throws ParseException, IOException {

		GravarCSV csv = new GravarCSV();
		Gravacao gravar = new GravarBD();

		Persistencia pers = new Persistencia(csv);
		Persistencia persBD = new Persistencia(gravar);

		Anuncio anuncio = new Anuncio();
		List<Anuncio> anuncios = new ArrayList<Anuncio>();

		System.out.println("Insira o nome do anúncio: ");
		anuncio.setNome(entrada.next());

		System.out.println("Insira o cliente: ");
		anuncio.setCliente(entrada.next());

		System.out.println("Insira a data de ínicio do anúncio: ");
		anuncio.setDataInicio(Anuncio.retornaData(entrada.next()));

		System.out.println("Insira a data de término do anúncio: ");
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
		System.out.println("Quantidade máxima de visualizações: " + numVisualizacoes);
		System.out.println("Quantidade máxima de cliques: " + numCliques);
		System.out.println("Quantidade máxima de compartilhamentos: " + numCompartilhamentos);

		pers.gravar(anuncios);
		persBD.gravar(anuncios);
	}

	/**
	 * Método que recebe os valores do usuário para realização da pesquisa por
	 * intervalo de tempo.
	 * 
	 * @throws IOException
	 * 
	 */
	public void pesquisaIntervaloTempo() throws ParseException, IOException {


		System.out.println("Insira a data de ínicio do anúncio: ");
		String dataInicio = entrada.next();

		System.out.println("Insira a data de término do anúncio: ");
		String dataTermino = entrada.next();

		
		Date dataI = Anuncio.retornaData(dataInicio);
		Date dataT = Anuncio.retornaData(dataTermino);
		
		Calendar dataIF = Calendar.getInstance();
		Calendar dataTF = Calendar.getInstance();
		
		dataIF.setTime(dataI);
		dataIF.add(Calendar.DATE, 1);
		
		dataTF.setTime(dataT);
		dataTF.add(Calendar.DATE, -1);
		
		System.out.println(listaAnuncios.pesquisaIntervalo(dataIF.getTime(), dataTF.getTime()));
	}

	/**
	 * Método que recebe os valores do usuário para realização da pesquisa por nome
	 * do cliente.
	 * 
	 */

	public void pesquisaCliente() {
		System.out.println("Insira o cliente: ");
		String cliente = entrada.next();

		System.out.println(listaAnuncios.pesquisaCliente(cliente));
	}

	/**
	 * Método que seleciona os métodos a serem chamados de acordo com a escolha do
	 * usuário.
	 * 
	 * @param opcao
	 */

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
			System.out.println("Opção inválida. Tente novamente.");
			break;
		}

	}
}
