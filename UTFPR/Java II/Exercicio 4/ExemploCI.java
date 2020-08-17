/*
 * ExemploCI.java
 * @author fabricio@utfpr.edu.br
 */
package classesinternas;
public class ExemploCI {
    public Thread DefineThread(){
        return(new Thread(){public void run(){processa3();}});
    }
            
    protected void IniciaTransacao() {
        new Thread(){
            public void run() {
                processa();
            }
        }.start();
        
        new Thread(){
            public void run() {
                processa2();
            }
        }.start();
        
        new Thread(){
            public void run() {
                processa3();
            }
        }.start();
    }
    public static void processa() {
        for (int i = 0; i < 10; i++) {
            System.out.println("tarefa1");
            Thread.yield();
        }
    }
    public static void processa2() {
        for (int i = 0; i < 10; i++) {
            System.out.println("tarefa2");
            Thread.yield();
        }
    }
    public static void processa3() {
        for (int i = 0; i < 10; i++) {
            System.out.println("tarefa3");
            Thread.yield();
        }
    }    
    public static void main(String args[]) {
        ExemploCI eci = new ExemploCI();
        eci.IniciaTransacao();
        eci.DefineThread().start();
    }
}
