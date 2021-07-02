package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import BO.Gravacao;
import DTO.Anuncio;

public class GravarCSV implements Gravacao {

	public List<Anuncio> ler() throws ParseException {
		List<Anuncio> lista = new ArrayList<Anuncio>();
		try {
			Anuncio a = new Anuncio();
			FileReader arq1 = new FileReader("Anuncios.csv");
			BufferedReader lerArq = new BufferedReader(arq1);
			String linha = lerArq.readLine();

			while (linha != null) {
				String[] leitura = linha.split(",");
				a = new Anuncio();
				a.setNome(leitura[0]);
				a.setCliente(leitura[1]);
				a.setDataInicio(Anuncio.retornaData(leitura[2]));
				a.setDataTermino(Anuncio.retornaData(leitura[3]));
				a.setInvestimentoDia(Integer.parseInt(leitura[4]));
				;
				lista.add(a);
				linha = lerArq.readLine();
			}

			arq1.close();
			return lista;
		} catch (IOException e) {
			System.err.printf("Erro na Abertura do Arquivo: %s. \n", e.getMessage());
			return null;
		}
	}

	public boolean gravar(List<Anuncio> lista) {
		try {
			FileWriter arq = new FileWriter("Anuncios.csv", true);
			PrintWriter gravarArq = new PrintWriter(arq);
			for (Anuncio Anuncio : lista) {
				gravarArq.printf("%s,%s,%s,%s,%d\n", Anuncio.getNome(), Anuncio.getCliente(), DTO.Anuncio.retornaData(Anuncio.getDataInicio()), DTO.Anuncio.retornaData(Anuncio.getDataTermino()),
														   Anuncio.getInvestimentoDia());
			}
			
			arq.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
}