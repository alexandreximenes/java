import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Principal {

    public static void main(String[] args) {

        Map<Integer,	String> weekDays	=	new HashMap<>();
        weekDays.put(1,	"Domingo");
        weekDays.put(2,	"Segunda");
        weekDays.put(3,	"Terça");
        weekDays.put(4,	"Quarta");
        weekDays.put(5,	"Quinta");
        weekDays.put(6,	"Sexta");
        weekDays.put(7,	"Sábado");

        List<Object> list = weekDays.entrySet()
                .stream()
                .flatMap(s -> Stream.of(s.getValue()))
                .collect(Collectors.toList());

        List<Integer> list2 = weekDays.entrySet()
                .stream()
                .flatMap(k -> Stream.of(k.getKey()))
                .collect(Collectors.toList());

        IntStream.range(1, 10)
                .skip(5)
                .forEach(System.out::println);

    }
}
