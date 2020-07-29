package produto;

import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ProdutoConverterSax {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {


		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse("src/produto.xml");
		
		Element e = document.getDocumentElement();
		String moeda = e.getAttribute("moeda");
		System.out.println(moeda);
		
		NodeList produtos = document.getElementsByTagName("produto");
		
		for (int i = 0; i < produtos.getLength(); i++) {
			
			Element element = (Element) produtos.item(i);
			
			String nome = element.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(element.getElementsByTagName("preco").item(0).getTextContent());
			
			Produto produto = new Produto(nome, preco);
			Produto produto2 = new Produto(nome, preco);
			
			
			Venda venda = new Venda();
			venda.setProdutos(Arrays.asList(produto, produto2));
			System.out.println(venda);
			
		}
	}
		

}
