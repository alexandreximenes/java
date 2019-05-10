package br.com.springaopexample;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

    private String accountNumber;
    private String amount;
    private String description;


}
