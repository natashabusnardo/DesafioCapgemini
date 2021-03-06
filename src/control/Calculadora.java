package control;

/**
 * Classe respons?vel por realizar o c?lculo dos an?ncios
 *
 * @author Natasha Busnardo
 */
public class Calculadora {

	/**
	 * M?todo que realiza a proje??o de visualiza??es.
	 * 
	 * @param valorInvestido, inicio
	 * @return A quantidade de visuaza??es do an?ncio
	 */

	public int projecao(int valorInvestido, boolean inicio) {
		int visualizacoes = 30 * valorInvestido;
		if (inicio)
			return visualizacoes;
		else {
			visualizacoes += numCompartilhamentos(numCliques(visualizacoes)) * 40;
			return visualizacoes;
		}
	}

	/**
	 * M?todo que realiza a proje??o do n?mero de cliques.
	 * 
	 * @param visualizacoes
	 * @return O alcance de cliques do an?ncio
	 */

	public int numCliques(int visualizacao) {
		return (int) Math.floor(visualizacao * 0.12);
	}

	/**
	 * M?todo que realiza a proje??o do n?mero de compartilhamentos.
	 * 
	 * @param cliques
	 * @return O alcance de compartilhamentos do an?ncio
	 */
	public int numCompartilhamentos(int cliques) {
		return (int) Math.floor(cliques * 0.15);
	}

}
