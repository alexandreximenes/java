package ThreadComLambda;

public class TrabalhandoComThread {

	public static void main(String[] args) {
		
		//modo antigo
		
		new Thread(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start();
		
		// thread com lambda
		
		new Thread( () -> System.out.println("Executando com lambda um Runnable")).start();

	}

}
