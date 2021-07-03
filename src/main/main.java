package main;

import java.io.IOException;
import java.text.ParseException;

import DTO.Menu;

public class main1 {
	public static void main(String[] args) throws IOException, ParseException {

		Menu menu = new Menu();

		int opcao = 0;

		do {
			opcao = menu.buildMainMenu();
			menu.selecionarOpcao(opcao);
		} while (opcao != 4);

	}
}
