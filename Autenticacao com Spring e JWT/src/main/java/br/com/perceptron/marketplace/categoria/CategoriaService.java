package br.com.perceptron.marketplace.categoria;

import br.com.perceptron.marketplace.domains.IService;
import br.com.perceptron.marketplace.exceptions.ObjectNotFoundException;
import br.com.perceptron.marketplace.paginacao.PageRequestService;
import br.com.perceptron.marketplace.response.ResponseDTO;
import br.com.perceptron.marketplace.response.ResponsePageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.perceptron.marketplace.response.ResponseUtils.*;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaService implements IService<CategoriaDTO> {

    private final MessageSource messageSource;
    private final CategoriaRepository categoriaRepository;
    private ResponseDTO<Object> responseDTO = new ResponseDTO<>();
    private ResponsePageDTO<CategoriaDTO> responsePageDTO = new ResponsePageDTO<>();
    private Categoria categoria = null;

    @Override
    @Transactional
    public ResponseEntity<Object> saveOrUpdate(CategoriaDTO categoriaDTO) {

        try {
            if (nonNull(categoriaDTO.getId())) {
                categoriaRepository
                        .findById(categoriaDTO.getId())
                        .ifPresent(c -> categoria = CategoriaServiceFilter.get(categoria, categoriaDTO));

                categoria = categoriaRepository.save(categoria);
            }
        } catch (Exception e) {
            return responseDTO.error($400, objectNotSave(messageSource), this.getClass(), SAVE_OR_UPDATE, e);
        }
        return responseDTO.success($200, objectSaved(messageSource), new CategoriaDTO(categoria), this.getClass());
    }

    @Override
    @Transactional
    public ResponseEntity<Object> deleteById(Long id) {
        categoria = find(id).orElseThrow(() -> new ObjectNotFoundException(objectNotFound(messageSource)));

        categoriaRepository.deleteById(categoria.getId());

        return responseDTO.success($200, objectRemoved(messageSource), this.getClass());
    }

    @Override
    public ResponseEntity<Object> findById(Long id) {
        categoria = find(id).orElseThrow(() -> new ObjectNotFoundException(objectNotFound(messageSource)));
        CategoriaDTO categoriaDTO = new CategoriaDTO(categoria);
        return responseDTO.success($200, searchOk(messageSource), categoriaDTO, this.getClass());
    }

    private Optional<Categoria> find(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public ResponseEntity<Object> findAll(Integer pagina, Integer quantidade, String ordenarPor, String direcaoOrdenacao, String parametro) {
        Page<Categoria> categorias = categoriaRepository.findAll(parametro, PageRequestService.of(pagina, quantidade, ordenarPor, direcaoOrdenacao, new Categoria()));
        if (nonNull(categorias)) {
            return responsePageDTO.success($200, searchOk(messageSource), CategoriaDTO.get(categorias), this.getClass());
        }
        throw new ObjectNotFoundException(objectNotFound(messageSource));
    }
}
