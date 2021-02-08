package org.example;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PrimeiroTest
{


    @Test
    public void deveSomar()
    {
        int resultado = Calculadora.somar(10, 10);

//        Assert.assertEquals(30, soma);
        Assertions.assertThat(resultado).isEqualTo(20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveSomarELancarException()
    {
        int resultado = Calculadora.somar(10, -10);

//        Assert.assertEquals(30, soma);
        Assertions.assertThat(resultado).isEqualTo(20);
    }

    @Test
    public void deveSubtrair()
    {
        int resultado = Calculadora.subtrai(10, 10);

        Assertions.assertThat(resultado).isEqualTo(0);
    }

    @Test
    public void deveMultiplicar()
    {
        int resultado = Calculadora.multi(10, 10);

        Assertions.assertThat(resultado).isEqualTo(100);
    }

    @Test
    public void deveDividir()
    {
        int resultado = Calculadora.div(10, 1);

        Assertions.assertThat(resultado).isEqualTo(10);
    }

}


