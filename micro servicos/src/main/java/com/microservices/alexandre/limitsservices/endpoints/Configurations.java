package com.microservices.alexandre.limitsservices.endpoints;

import com.microservices.alexandre.limitsservices.Configuration;
import com.microservices.alexandre.limitsservices.bean.LimitConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Configurations {

    private final Configuration configuration;

    @GetMapping(path = "/limits")
    public LimitConfiguration getLimitConfiguration() {
        return new LimitConfiguration(configuration.getMin(), configuration.getMax());
    }
}
