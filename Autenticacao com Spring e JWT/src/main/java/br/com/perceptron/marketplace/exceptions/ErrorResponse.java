package br.com.perceptron.marketplace.exceptions;

import br.com.perceptron.marketplace.response.ResponseErrorDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private int code;
    private String status;
    private String object;
    private List<ResponseErrorDetails> errors;
}
