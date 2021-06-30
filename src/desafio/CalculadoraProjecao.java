package desafio;

public class CalculadoraProjecao {

	public static int projecao(int valorInvestido, boolean inicio) {

		int visualizacoes = 30 * valorInvestido;
		if (inicio)
			return visualizacoes;
		else {
			visualizacoes += numCompartilhamentos(numCliques(visualizacoes)) * 40;
			return visualizacoes;
		}
	}

	public static int numCliques(int visualizacao) {
		return (int) Math.floor(visualizacao * 0.12);
	}

	public static int numCompartilhamentos(int clicks) {

		return (int) Math.floor(clicks * (20.0 / 3.0));
	}

}
