package OrdenandoStrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	
	public static void main(String[] args) {
		
		/**
		 * [
				 A ci�ncia de hoje � a tecnologia de amanh� [Edward Teller], 
				 Trocava toda minha tecnologia por uma tarde com S�crates.[Steve Jobs], 
				 A tecnologia s� � tecnologia para quem nasceu antes dela ter sido inventada. [Alan Kay], 
				 Tornou-se chocantemente �bvio que a nossa tecnologia excedeu a nossa humanidade. [Albert Einstein], 
				 A maior inven��o do mundo n�o � a minha tecnologia! � a morte! pois atrav�s dela, o velho sempre dar� lugar para o novo! [Steve Jobs], 
				 A primeira regra de qualquer tecnologia utilizada nos neg�cios � que a automa��o aplicada a uma opera��o eficiente aumentar� a efici�ncia. 
				 A segunda � que a automa��o aplicada a uma opera��o ineficiente aumentar� a inefici�ncia. [Bill Gates]
		   ]
		 */
		
		List<String> palavras = Arrays.asList(
				"\n Tornou-se chocantemente �bvio que a nossa tecnologia excedeu a nossa humanidade. [Albert Einstein]", 
				
				 "\n Trocava toda minha tecnologia por uma tarde com S�crates.[Steve Jobs]",
				 
				 "\n A tecnologia s� � tecnologia para quem nasceu antes dela ter sido inventada. [Alan Kay]",
				 
				 "\n A primeira regra de qualquer tecnologia utilizada nos neg�cios � que a automa��o aplicada a uma opera��o eficiente aumentar� a efici�ncia. \n A segunda � que a automa��o aplicada a uma opera��o ineficiente aumentar� a inefici�ncia. [Bill Gates]",
				 
				 "\n A maior inven��o do mundo n�o � a minha tecnologia! � a morte! pois atrav�s dela, o velho sempre dar� lugar para o novo! [Steve Jobs]",
				 
				 "\n A ci�ncia de hoje � a tecnologia de amanh� [Edward Teller]");
		
		
		/**
		 * Ordena por tamanho da string
		 */ 
		Comparator<String> comparador = new ComparadorPorTamanho();
		palavras.sort(comparador);
		
		//for antigo
		/*
		for(String s : palavras) {
			System.out.println(s);
		}*/
		
		//Usando lambda
		palavras.forEach( p -> System.out.println(p) );
		
		//System.out.println(palavras);
	}

}
class ComparadorPorTamanho implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() < o2.length()) 
			return -1;
		if(o1.length() > o2.length()) 
			return 1;
		return 0;
	}
	
}
