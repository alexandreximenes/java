package br.com.alexandre.app.Adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class SpringBootRestAdapter implements WebMvcConfigurer {

    private int page = 0;
    private int size = 5;

    public SpringBootRestAdapter() {
    }

    public SpringBootRestAdapter(int page, int size) {
        this.page = page;
        this.size = size;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        PageableHandlerMethodArgumentResolver phmar = new PageableHandlerMethodArgumentResolver();
        phmar.setFallbackPageable(new PageRequest(page, size));
        resolvers.add(phmar);
    }
}
