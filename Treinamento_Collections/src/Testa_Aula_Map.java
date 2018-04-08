
public class Testa_Aula_Map {
	public static void main(String[] args) {
		Aula_Map map = new Aula_Map("java", "instrutor 1");
		
		Aluno a1 = new Aluno("alexandre", 5, 123456);
		Aluno a2 = new Aluno("day", 9, 5465465);
		Aluno a3 = new Aluno("arthur", 10, 6666);
		Aluno a4 = new Aluno("alexandre Ximenes", 5, 122223456);
		
		map.matricula(a1);
		map.matricula(a2);
		map.matricula(a3);
		map.matricula(a4);
		map.matricula(a4);
		
		Aluno alunoExistente = map.buscaMatriculado(a4);
		System.out.println("tem aluno ?" + alunoExistente);
		
		Aluno alunoInexistente = map.buscaMatriculado(new Aluno("tiago", 1, 1));
		System.out.println("tem aluno ?" + alunoInexistente);
	}

}
