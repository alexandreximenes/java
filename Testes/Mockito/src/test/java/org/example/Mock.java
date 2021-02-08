package org.example;

import static org.junit.Assert.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class Mock
{

    @Test
    public void primeiroMock()
    {

        List<String> lista = Mockito.mock(ArrayList.class);

        Mockito.when(lista.size()).thenReturn(10);

        Assertions.assertThat(lista.size()).isEqualTo(10);

    }
}
