package br.com.perceptron.marketplace;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketplaceApplicationTests {

    @Test
    public void contextLoads() {
        Double reduce = Stream.of(10.0, 20.0, 30.0)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println(reduce);

    }

}

