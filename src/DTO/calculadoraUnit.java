package DTO;
import static org.junit.Assert.*;

import org.junit.Test;

public class calculadoraUnit {

	@Test
	public void test() {
		CalculadoraProjecao calc = new CalculadoraProjecao();
		
		int output_f = calc.projecao(2, true);
		
		//teste de saída
		assertEquals(60, output_f);
	}

}
