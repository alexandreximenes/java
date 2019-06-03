package br.com.perceptron.marketplace.paginacao;


import br.com.perceptron.marketplace.exceptions.MException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.perceptron.marketplace.paginacao.OrderBySQL.ASC;
import static br.com.perceptron.marketplace.paginacao.OrderBySQL.DESC;
import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageRequestService {

    public static PageRequest of(Integer pagina, Integer quantidade, String ordenarPor, String direcaoOrdenacao, Object object) {

        if (nonNull(object) && nonNull(ordenarPor))
            verifyFildsEqualFildsEntity(object, ordenarPor);

        String name = nonNull(direcaoOrdenacao) && direcaoOrdenacao.equalsIgnoreCase(ASC) ? ASC : (direcaoOrdenacao.equalsIgnoreCase(DESC) ? DESC : ASC);
        return PageRequest.of(pagina, quantidade, Direction.valueOf(name), ordenarPor);
    }

    private static void verifyFildsEqualFildsEntity(Object object, String campoOrderByDaPaginacao) {

        List<String> objects = new ArrayList<>();
        Class<?> mClass = object.getClass();
        Field[] fields = mClass.getDeclaredFields();
        for (Field f : fields) {
            objects.add(f.getName());
        }
        if (!objects.contains(campoOrderByDaPaginacao.trim()))
            throw new MException(("[ " + campoOrderByDaPaginacao + " ] não faz parte do objeto " + mClass.getSimpleName().toUpperCase() + ", para usar o \'ordenarPor\' da paginação, utilize o(s) campo(s) [ " + objects.stream().collect(Collectors.joining(", ")) + " ], por favor verifique e tente novamente"));

    }
}
