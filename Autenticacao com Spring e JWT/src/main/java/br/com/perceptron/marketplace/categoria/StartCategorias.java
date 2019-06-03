package br.com.perceptron.marketplace.categoria;

import br.com.perceptron.marketplace.response.ResponseDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static br.com.perceptron.marketplace.response.ResponseUtils.*;

public class StartCategorias {

    private ResponseDTO<Categoria> responseDTO = new ResponseDTO<>();

    public StartCategorias(CategoriaRepository categoriaRepository) {
        insertData(categoriaRepository);
    }

    @Transactional
    public void insertData(CategoriaRepository categoriaRepository) {
        try {
            Categoria autoPecas = new Categoria("Auto peças");
            Categoria imoveis = new Categoria("Imoveis");
            Categoria paraCasa = new Categoria("Para sua casa");
            Categoria eletronicosCelulares = new Categoria("Eletronicos e celulares");
            Categoria musicaHobies = new Categoria("Musica e hobies");
            Categoria esporteLazer = new Categoria("Esporte e lazer");
            Categoria artigosInfantis = new Categoria("Artigos infantis");
            Categoria animaisEstimacao = new Categoria("Animais de estimação");
            Categoria modaBeleza = new Categoria("Moda e beleza");
            Categoria agroIndustria = new Categoria("Agro e industria");
            Categoria comercio = new Categoria("Comério");
            Categoria servicos = new Categoria("Serviços");

            List<Categoria> categorias = categoriaRepository.findAll();
            if (!categorias.contains(autoPecas)) categoriaRepository.save(autoPecas);
            if (!categorias.contains(imoveis)) categoriaRepository.save(imoveis);
            if (!categorias.contains(paraCasa)) categoriaRepository.save(paraCasa);
            if (!categorias.contains(eletronicosCelulares)) categoriaRepository.save(eletronicosCelulares);
            if (!categorias.contains(musicaHobies)) categoriaRepository.save(musicaHobies);
            if (!categorias.contains(esporteLazer)) categoriaRepository.save(esporteLazer);
            if (!categorias.contains(artigosInfantis)) categoriaRepository.save(artigosInfantis);
            if (!categorias.contains(animaisEstimacao)) categoriaRepository.save(animaisEstimacao);
            if (!categorias.contains(modaBeleza)) categoriaRepository.save(modaBeleza);
            if (!categorias.contains(agroIndustria)) categoriaRepository.save(agroIndustria);
            if (!categorias.contains(comercio)) categoriaRepository.save(comercio);
            if (!categorias.contains(servicos)) categoriaRepository.save(servicos);
            responseDTO.success($200, CATEGORIA + SALVO, this.getClass());
        } catch (Exception e) {
            responseDTO.error($404, NAO_SALVO + CATEGORIA, this.getClass(), "insertData", e);
        }
    }
}
