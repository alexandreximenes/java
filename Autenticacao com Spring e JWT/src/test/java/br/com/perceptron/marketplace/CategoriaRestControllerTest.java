package br.com.perceptron.marketplace;

import br.com.perceptron.marketplace.categoria.Categoria;
import br.com.perceptron.marketplace.categoria.CategoriaRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CategoriaRestControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;
    @MockBean
    private CategoriaRepository categoriaRepository;
    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class Config {
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder().basicAuthentication("xyymenes@gmail.com", "admin");
        }
    }

    @Test
    public void listCategorias() {
        testRestTemplate = this.testRestTemplate.withBasicAuth("1", "1");
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/v1/categorias", String.class);
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(404);
    }

    @Test
    public void listCategoriasById() {
        List<Categoria> categoriaList = asList(new Categoria("bugiganga"), new Categoria("mais bugigangas"));
        BDDMockito.when(categoriaRepository.findAll()).thenReturn(categoriaList);
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/v1/categorias", String.class);
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(404);
    }

}
