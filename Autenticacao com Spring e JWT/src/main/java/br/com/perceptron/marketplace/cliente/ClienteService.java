package br.com.perceptron.marketplace.cliente;

import br.com.perceptron.marketplace.exceptions.MConstraintViolationException;
import br.com.perceptron.marketplace.exceptions.ObjectNotFoundException;
import br.com.perceptron.marketplace.response.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.perceptron.marketplace.domains.AbstractEntity.codeIDisValid;
import static br.com.perceptron.marketplace.response.ResponseUtils.*;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {

    private final ClienteRepository clientRepository;
    private final MessageSource messageSource;
    private Cliente cliente = new Cliente();
    private ResponseDTO<ClienteDTO> responseDTO = new ResponseDTO<>();
    private ClienteServiceFilter clientServiceFilter;

    public ResponseEntity<Object> findById(Long id) {
        try {
            cliente = find(id);
            if (isNull(cliente)) throw new ObjectNotFoundException(objectNotFound(messageSource));

            return responseDTO.success($200, searchOk(messageSource), new ClienteDTO(cliente), this.getClass());
        } catch (Exception e) {
            return responseDTO.error($404, objectNotFound(messageSource), this.getClass(), "findById", e);
        }
    }

    private Cliente find(Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(objectNotFound(messageSource)));
    }

    public ResponseEntity<Object> findAll() {
        List<Cliente> clientes = clientRepository.findAll();
        if (!clientes.isEmpty()) {
            return responseDTO.success($200, searchOk(messageSource), ClienteDTO.get(clientes), this.getClass());
        }
        throw new ObjectNotFoundException(objectNotFound(messageSource));
    }

    public ResponseEntity<Object> findAllAtivos() {
        List<Cliente> clientes = clientRepository.findAllAtivos();
        if (!clientes.isEmpty()) {
            return responseDTO.success($200, searchOk(messageSource), ClienteDTO.get(clientes), this.getClass());
        }
        throw new ObjectNotFoundException(objectNotFound(messageSource));

    }

    public ResponseEntity<Object> deleteById(Long id) {
        if (codeIDisValid(id)) {
            cliente = find(id);
            try {
                clientRepository.deleteById(cliente.getId());
            } catch (MConstraintViolationException e) {
                throw new MConstraintViolationException(e.getMessage());
            }
        }
        return responseDTO.success($200, objectRemoved(messageSource), this.getClass());
    }

    public ResponseEntity<Object> saveOrUpdate(ClienteDTO clientDTO) {
        try {
            cliente = ClienteServiceFilter.get(clientDTO, cliente);
            cliente = clientRepository.save(cliente);
            return responseDTO.success($200, objectSaved(messageSource), new ClienteDTO(cliente), this.getClass());
        } catch (DataIntegrityViolationException e) {
            return responseDTO.error($400, objectAlreadyExists(messageSource), this.getClass(), SAVE_OR_UPDATE, e);
        } catch (Exception e) {
            return responseDTO.error($400, objectNotSave(messageSource), this.getClass(), SAVE_OR_UPDATE, e);
        }
    }
}
