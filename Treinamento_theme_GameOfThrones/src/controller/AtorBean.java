package controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.faces.bean.ManagedBean;

import org.apache.catalina.core.ApplicationPart;

import model.Ator;
import model.AtorDAO;

@ManagedBean
public class AtorBean {

	private Ator			ator		= new Ator();
	private AtorDAO		atorDAO	= new AtorDAO();
	private ApplicationPart	imagem;

	public ApplicationPart getImagem() {
		return imagem;
	}

	public void setImagem(ApplicationPart imagem) {
		this.imagem = imagem;
	}

	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}

	public void salvar() {
		System.out.println("salvando dados... ");

		try {
			File file = new File("G:\\DESENVOLVIMENTO\\eclipse Java EE 32bits\\eclipse\\workspace\\GameOfThrones\\WebContent\\atores\\" + imagem.getSubmittedFileName());

			byte[] bytes = new byte[(int) imagem.getSize()];
			imagem.getInputStream().read(bytes);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes);

			ator.setFoto(file.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Nome do ator " + ator.getNome());
		System.out.println("Nascimento " + ator.getNascimento());
		System.out.println("Valor Cache " + ator.getValorCache());
		System.out.println("Valor Cache " + ator.getFoto());

		atorDAO.inserir(this.ator);

		this.ator = new Ator();

	}

	// @PostConstruct
	// public ArrayList<Ator> getAtores() {
	//
	// ArrayList<Ator> atores = atorDAO.getAtores();
	// return atores;
	// }

}
