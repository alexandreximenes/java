package br.com.perceptron.marketplace.cliente;

import org.springframework.util.StringUtils;

import static java.util.Objects.nonNull;

public class ClienteServiceFilter {

    public static Cliente get(ClienteDTO clientDTO, Cliente cliente) {

        Cliente client = null;
        if (nonNull(cliente)) {
            client = cliente;
        } else {
            client = new Cliente();
        }

        if (!StringUtils.isEmpty(clientDTO.getNome())) {
            client.setNome(clientDTO.getNome());
        }
        if (!StringUtils.isEmpty(clientDTO.getCodigo())) {
            client.setCodigo(clientDTO.getCodigo());
        }
        if (!StringUtils.isEmpty(clientDTO.getTelefones())) {
            client.setTelefones(clientDTO.getTelefones());
        }
        if (!StringUtils.isEmpty(clientDTO.getTipo())) {
            client.setTipo(clientDTO.getTipo());
        }


        return client;

    }

}
