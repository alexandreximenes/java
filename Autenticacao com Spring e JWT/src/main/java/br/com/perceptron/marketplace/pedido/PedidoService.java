package br.com.perceptron.marketplace.pedido;

import br.com.perceptron.marketplace.exceptions.MConstraintViolationException;
import br.com.perceptron.marketplace.exceptions.MDataIntegrityViolationException;
import br.com.perceptron.marketplace.exceptions.ObjectNotFoundException;
import br.com.perceptron.marketplace.response.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.perceptron.marketplace.domains.AbstractEntity.codeIDisValid;
import static br.com.perceptron.marketplace.response.ResponseUtils.*;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private MessageSource messageSource;
    private Pedido pedido;
    private ResponseDTO<PedidoDTO> responseDTO = new ResponseDTO<>();

    public ResponseEntity<Object> findById(Long id) {
        pedido = find(id);
        return responseDTO.success($200, objectNotFound(messageSource), new PedidoDTO(pedido), this.getClass());

    }

    private Pedido find(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(objectNotFound(messageSource)));
    }

    public ResponseEntity<Object> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return responseObjects(pedidos);
    }

    private ResponseEntity<Object> responseObjects(List<Pedido> pedidos) {
        if (!pedidos.isEmpty()) {
            List<PedidoDTO> pedidosDTO = PedidoDTO.get(pedidos);
            return responseDTO.success($200, searchOk(messageSource), pedidosDTO, this.getClass());
        }
        throw new ObjectNotFoundException(objectNotFound(messageSource));
    }

    public ResponseEntity<Object> deleteById(Long id) {
        if (codeIDisValid(id)) {
            pedido = find(id);
            pedidoRepository.deleteById(pedido.getId());
        }
        return responseDTO.success($200, objectRemoved(messageSource), this.getClass());
    }

    public ResponseEntity<Object> saveOrUpdate(PedidoDTO pedidoDTO) {
        try {
            if (nonNull(pedidoDTO.getId())) {
                pedido = find(pedidoDTO.getId());
            }

            pedido = PedidoServiceFilter.get(pedido, pedidoDTO);
            pedido = pedidoRepository.save(pedido);
            return responseDTO.success($200, objectSaved(messageSource), new PedidoDTO(pedido), this.getClass());

        } catch (MDataIntegrityViolationException e) {
            throw new MDataIntegrityViolationException(e.getMessage());
        } catch (MConstraintViolationException e) {
            throw new MConstraintViolationException(objectWithRelationship(messageSource));
        }
    }

}
