package Testes;

interface HasTail { int getTailLength(); }
abstract class Puma implements HasTail {
protected int getTailLength() { return 4; }
}
public class Cougar implements HasTail {
public static void main(String[] args) {
        var puma = new Puma();
        System.out.println(puma.getTailLength());
        }
public int getTailLength(int length) { return 2; }
}