//Alexandre Tiago Ximenes
public class Teste {
    public static void main(String[] args) {

        Veiculo gol = new Veiculo();
        gol.setPlaca("AAA-111");
        gol.setMarca("VW");
        gol.setModelo("Gol");
        gol.setVelocMax(180);
        gol.setMotor(new Motor(4, 100));

        Veiculo corsa = new Veiculo();
        corsa.setPlaca("AAA-222");
        corsa.setMarca("Chevlolet");
        corsa.setModelo("Corsa");
        corsa.setVelocMax(180);
        corsa.setMotor(new Motor(4, 120));

        Veiculo palio = new Veiculo();
        palio.setPlaca("AAA-333");
        palio.setMarca("Fiat");
        palio.setModelo("Palio");
        palio.setVelocMax(180);
        palio.setMotor(new Motor(4, 180));


        Veiculo polo = new Veiculo();
        polo.setPlaca("AAA-444");
        polo.setMarca("VW");
        polo.setModelo("Polo");
        polo.setVelocMax(200);
        polo.setMotor(new Motor(4, 200));

        Veiculo prisma = new Veiculo();
        prisma.setPlaca("AAA-555");
        prisma.setMarca("Chevlolet");
        prisma.setModelo("Prisma");
        prisma.setVelocMax(220);
        prisma.setMotor(new Motor(4, 220));

        Veiculo celta = new Veiculo();
        celta.setPlaca("AAA-666");
        celta.setMarca("Chevlolet");
        celta.setModelo("Celta");
        celta.setVelocMax(19);
        celta.setMotor(new Motor(4, 190));

        Veiculo fiesta = new Veiculo();
        fiesta.setPlaca("AAA-777");
        fiesta.setMarca("Ford");
        fiesta.setModelo("Fiesta");
        fiesta.setVelocMax(180);
        fiesta.setMotor(new Motor(4, 180));

        Veiculo uno = new Veiculo();
        uno.setPlaca("AAA-888");
        uno.setMarca("Fiat");
        uno.setModelo("Uno");
        uno.setVelocMax(180);
        uno.setMotor(new Motor(4, 180));

        Veiculo ferrari = new Veiculo();
        ferrari.setPlaca("AAA-999");
        ferrari.setMarca("Ferrari");
        ferrari.setModelo("Ferrari I");
        ferrari.setVelocMax(360);
        ferrari.setMotor(new Motor(4, 360));

        Veiculo bmw = new Veiculo();
        corsa.setPlaca("AAA-101");
        corsa.setMarca("BMW");
        corsa.setModelo("BMW Serie I");
        corsa.setVelocMax(240);
        corsa.setMotor(new Motor(4, 240));

        System.out.println(gol);
        System.out.println(corsa);
        System.out.println(palio);
        System.out.println(polo);
        System.out.println(prisma);
        System.out.println(celta);
        System.out.println(fiesta);
        System.out.println(uno);
        System.out.println(ferrari);
        System.out.println(bmw);
    }
}


