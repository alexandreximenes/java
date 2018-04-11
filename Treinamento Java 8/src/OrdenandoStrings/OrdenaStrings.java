package OrdenandoStrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	
	public static void main(String[] args) {
		
		List<String> asList = Arrays.asList("string seis", "string um", "string dois", "string tres", "string quatro", "string cinco");
		
		/**
		 * Ordena lexicograficamente
		 * esperado [string cinco, string dois, string quatro, string seis, string tres, string um]
		 */ 
		Comparator<String> comparador = new ComparadorPorTamanho();
		Collections.sort(asList, comparador);
		
		System.out.println(asList);
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
