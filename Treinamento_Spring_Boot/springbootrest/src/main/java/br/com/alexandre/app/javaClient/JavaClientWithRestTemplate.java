package br.com.alexandre.app.javaClient;

import br.com.alexandre.app.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JavaClientWithRestTemplate {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:9000/student")
                .basicAuthorization("alexandre", "alexandre")
                .build();

        /**
         * Busca estudante usando metodo getForObject retornando o objeto studante 1
         */
        //Student student = restTemplate.getForObject("/2", Student.class, 1);

        /**
         * Busca estudante usando metodo getForEntity com status, header e objeto
         */
//        ResponseEntity<Student> studentEntity = restTemplate.getForEntity("/2", Student.class, 1);
////        Object o = studentEntity != null ? studentEntity : "";
//        System.out.println(studentEntity.getStatusCode());
//        System.out.println(studentEntity.getBody());
//        System.out.println("Headers");
//        String [] headers = studentEntity.getHeaders().toString().split(";");
//        for (String header : headers) {
//            System.out.println(header);
//        }
//
////        /**
//         * Busca TODOS os estudante usando metodo getForEntity com status, header e objetos
//         */
//        Student[] students = restTemplate.getForObject("/", Student[].class);
//        System.out.println(Arrays.toString(students));

        /**
         * Busca TODOS os estudante usando metodo exchange com status, header e objetos
         * Parametros:
         * 1 -  url
         * 2 - Metodo pode ser GET ou POST
         * 3 - Se estiver usando GET, passar null, POST passar a entitdade
         * 4 - Tipo de parametro ParameterizedTypeReference, nesse caso List<Student>
         */
//        ResponseEntity<List<Student>> listResponseEntity =
//                restTemplate.exchange("/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {});
//        List<Student> studentList = listResponseEntity.getBody();
//        System.out.println("listResponseEntity \n"+listResponseEntity);
//        System.out.println("studentList \n");
//        studentList.stream()
//                .sorted(Comparator.comparing(Student::getEmail))
//                .forEach(System.out::println);

        ResponseEntity<PageableResponse<Student>> exchange =
                restTemplate.exchange("/?sort=id,desc&sort=name,desc", HttpMethod.GET, null, new ParameterizedTypeReference<PageableResponse<Student>>() {
        });
        System.out.println(exchange);

    }
}
