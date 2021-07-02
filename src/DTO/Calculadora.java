package DTO;

/**
 * Classe responsável por realizar o cálculo dos anúncios
 *
 * @author Natasha Busnardo
 */
public class Calculadora {

	/**
	 * Método que realiza a projeção de visualizações.
	 * 
	 * @param valorInvestido, inicio
	 * @return A quantidade de visuazações do anúncio
	 */

	public static int projecao(int valorInvestido, boolean inicio) {

		int visualizacoes = 30 * valorInvestido;
		if (inicio)
			return visualizacoes;
		else {
			visualizacoes += numCompartilhamentos(numCliques(visualizacoes)) * 40;
			return visualizacoes;
		}
	}

	/**
	 * Método que realiza a projeção do número de cliques.
	 * 
	 * @param visualizacoes
	 * @return O alcance de cliques do anúncio
	 */

	public static int numCliques(int visualizacao) {
		return (int) Math.floor(visualizacao * 0.12);
	}

	/**
	 * Método que realiza a projeção do número de compartilhamentos.
	 * 
	 * @param cliques
	 * @return O alcance de compartilhamentos do anúncio
	 */
	public static int numCompartilhamentos(int cliques) {

		int nCompartilhamentos = (int) Math.floor(cliques / 20.0);
		return nCompartilhamentos * 3;
	}

}
