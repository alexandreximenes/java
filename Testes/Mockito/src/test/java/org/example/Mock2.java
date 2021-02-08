package org.example;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class Mock2
{

    @Mock
    private List<String> lista;
    @Test
    public void segundoMock()
    {
        Mockito.when(lista.size()).thenReturn(10);

        Assertions.assertThat(lista.size()).isEqualTo(10);

    }
}
