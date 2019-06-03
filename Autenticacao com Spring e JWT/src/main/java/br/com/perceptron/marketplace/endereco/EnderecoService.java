package br.com.perceptron.marketplace.endereco;

import br.com.perceptron.marketplace.domains.IService;
import br.com.perceptron.marketplace.exceptions.MException;
import br.com.perceptron.marketplace.response.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Optional;

import static br.com.perceptron.marketplace.response.ResponseUtils.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoService implements IService<EnderecoDTO> {

    private Endereco endereco = null;
    private final EnderecoRepository addressRepository;
    private final MessageSource messageSource;
    @Value("${via.cep}")
    private String viaCep;// = "http://viacep.com.br/ws/\"{cep}/json/";

    private ResponseDTO<Object> responseDTO = new ResponseDTO<>();

    @Transactional
    @Override
    public ResponseEntity<Object> saveOrUpdate(EnderecoDTO addressDTO) {
        try {
            endereco = EnderecoServiceFilter.get(addressDTO);
        } catch (Exception e) {
            return responseDTO.error($404, objectNotSave(messageSource), this.getClass(), "saveOrUpdate", e);
        }
        endereco = addressRepository.save(endereco);
        return responseDTO.success($200, objectSaved(messageSource), new EnderecoDTO(endereco), this.getClass());
    }

    public Endereco saveOrUpdateDirect(EnderecoDTO enderecoDTO) {
        return Optional.ofNullable(addressRepository
                .save(new Endereco(enderecoDTO)))
                .orElseThrow(() -> new MException(objectNotSave(messageSource)));
    }

    @Override
    public ResponseEntity<Object> deleteById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findAll(Integer pagina, Integer quantidade, String ordenarPor, String direcaoOrdenacao, String parametro) {
        return null;
    }

    public ResponseEntity<Object> findViaCep(String cep) {

        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> params = new HashMap<>();
        params.put("cep", cep);

        EnderecoDTO enderecoDTO = restTemplate.getForObject(viaCep, EnderecoDTO.class, params);

        if (nonNull(enderecoDTO) && isNull(enderecoDTO.getLogradouro())) {
            return responseDTO.error($404, objectNotFound(messageSource), this.getClass(), "findViaCep", null);
        }
        return responseDTO.success($200, searchOk(messageSource), enderecoDTO, this.getClass());
    }
}
