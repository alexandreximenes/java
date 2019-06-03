package br.com.perceptron.marketplace.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseErrorDetails {
    private String field;
    private String message;

}
