/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import control.Calculadora;

public class CalculadoraTest {
	Calculadora calc = Mockito.spy(Calculadora.class);

	@Test
	public void validateProjecaoInicioTrue() {
		int expected = 60;

		int result = calc.projecao(2, true);

		Assert.assertEquals(expected, result);
		Mockito.verify(calc, Mockito.never()).numCliques(Mockito.anyInt());
		Mockito.verify(calc, Mockito.never()).numCompartilhamentos(Mockito.anyInt());
	}

	@Test
	public void validateProjecaoInicioFalse() {	
		int expected = 100;
		Mockito.doReturn(0).when(calc).numCliques(Mockito.anyInt());
		Mockito.doReturn(1).when(calc).numCompartilhamentos(Mockito.anyInt());

		int result = calc.projecao(2, false);

		Assert.assertEquals(expected, result);
		Mockito.verify(calc).numCliques(Mockito.anyInt());
		Mockito.verify(calc).numCompartilhamentos(Mockito.anyInt());
	}

	@Test
	public void validateNumCliques() {		
		int expected = (int) Math.floor(100 * 0.12);
		
		int result = calc.numCliques(100);
		
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void validateNumCompartilhamentos() {
		int expected = (int) Math.floor(100 * 0.15);
		
		int result = calc.numCompartilhamentos(100);
		
		Assert.assertEquals(expected, result);
	}

}
