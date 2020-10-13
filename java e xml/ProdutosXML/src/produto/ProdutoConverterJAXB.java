package produto;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ProdutoConverterJAXB {
	
	public static void main(String[] args) throws Exception {


		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
	
		xmlParaObjecto(jaxbContext);
		
		objectoParaXml(jaxbContext);
	}

	private static void objectoParaXml(JAXBContext jaxbContext) throws Exception {
		
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		Venda venda = new Venda();
		
		Produto produto = new Produto("Livro JAXB", 100.00);
		Produto produto2 = new Produto("Livro SOAP", 200.00);
		Produto produto3 = new Produto("Livro Spring boot com SOAP e JAXB", 400.00);
		
		venda.setProdutos(Arrays.asList(produto, produto2, produto3));
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(venda, writer);
		marshaller.marshal(venda, new File("src/arquivo.xml"));
		
		System.out.println(writer.toString());
	}

	private static void xmlParaObjecto(JAXBContext jaxbContext) throws Exception {
		
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/produto.xml"));
	
		System.out.println(venda);
	
		
	}
		
}