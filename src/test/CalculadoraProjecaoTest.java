/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import DTO.Calculadora;

public class CalculadoraProjecaoTest {

    @Test
    public void test() {
        Calculadora calc = new Calculadora();

        int output_f = calc.projecao(2, true);

        //teste de saída
        assertEquals(60, output_f);
    }

}

