package OrdenandoStrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	
	public static void main(String[] args) {
		
		/**
		 * [
				 A ciência de hoje é a tecnologia de amanhã [Edward Teller], 
				 Trocava toda minha tecnologia por uma tarde com Sócrates.[Steve Jobs], 
				 A tecnologia só é tecnologia para quem nasceu antes dela ter sido inventada. [Alan Kay], 
				 Tornou-se chocantemente óbvio que a nossa tecnologia excedeu a nossa humanidade. [Albert Einstein], 
				 A maior invenção do mundo não é a minha tecnologia! É a morte! pois através dela, o velho sempre dará lugar para o novo! [Steve Jobs], 
				 A primeira regra de qualquer tecnologia utilizada nos negócios é que a automação aplicada a uma operação eficiente aumentará a eficiência. 
				 A segunda é que a automação aplicada a uma operação ineficiente aumentará a ineficiência. [Bill Gates]
		   ]
		 */
		
		List<String> palavras = Arrays.asList(
				"\n Tornou-se chocantemente óbvio que a nossa tecnologia excedeu a nossa humanidade. [Albert Einstein]", 
				
				 "\n Trocava toda minha tecnologia por uma tarde com Sócrates.[Steve Jobs]",
				 
				 "\n A tecnologia só é tecnologia para quem nasceu antes dela ter sido inventada. [Alan Kay]",
				 
				 "\n A primeira regra de qualquer tecnologia utilizada nos negócios é que a automação aplicada a uma operação eficiente aumentará a eficiência. \n A segunda é que a automação aplicada a uma operação ineficiente aumentará a ineficiência. [Bill Gates]",
				 
				 "\n A maior invenção do mundo não é a minha tecnologia! É a morte! pois através dela, o velho sempre dará lugar para o novo! [Steve Jobs]",
				 
				 "\n A ciência de hoje é a tecnologia de amanhã [Edward Teller]");
		
		
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
