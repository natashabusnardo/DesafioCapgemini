/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import DTO.CalculadoraProjecao;

public class CalculadoraProjecaoTest {

    @Test
    public void test() {
        CalculadoraProjecao calc = new CalculadoraProjecao();

        int output_f = calc.projecao(2, true);

        //teste de sa�da
        assertEquals(60, output_f);
    }

}

