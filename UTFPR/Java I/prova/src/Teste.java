import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Alexandre Tiago Ximenes
 */

public class Teste {

    private static BDVeiculos bdVeiculos = new BDVeiculos();
    static String escolha;
    static Leitura leitura = new Leitura();
    static String resposta = null;

    public static void main(String[] args) {

        Passeio p = new Passeio("CCC-333", "VW", "GOL", "BRANCO", 4, 220, new Motor(2, 220), 5);
        Carga c = new Carga("AAA-111", "VW", "Caminhao VW", "PRETO", 6, 180, new Motor(4, 400), 100, 1_000);
        try {
            bdVeiculos.save(p);
            bdVeiculos.save(c);
        } catch (VeicExistException e) {
            e.printStackTrace();
        }

        System.out.println("Sistema de gestão de veiculos - Menu inicial");

        do {

            menuSistema();
            escolha = leitura.entraDados();

            switch (escolha) {
                case "1":
                    cadastrarVeiculoDePasseio();
                    break;
                case "2":
                    cadastrarVeiculoDeCarga();
                    break;
                case "3":
                    DataEHoraAgora();
                    imprimirTodosVeiculosDePasseio();
                    break;
                case "4":
                    DataEHoraAgora();
                    imprimirTodosVeiculosDeCarga();
                    break;
                case "5":
                    DataEHoraAgora();
                    imprimirVeiculosDePasseioPelaPlaca();
                    break;
                case "6":
                    DataEHoraAgora();
                    imprimirVeiculosDeCargaPelaPlaca();
                    break;
                case "7":
                    DataEHoraAgora();
                    System.out.println("# Voce escolheu alterar veiculo de passeio pela placa");
                    System.out.println("Informe a placa: ");
                    String placa = leitura.entraDados();
                    Passeio passeio = new Passeio();
                    passeio.setPlaca(placa);
                    alterarDadosDoveiculoDePasseioPelaPlaca(passeio);
                    break;
                case "8":
                    DataEHoraAgora();
                    System.out.println("# Voce escolheu alterar veiculo de carga pela placa");
                    System.out.println("Informe a placa: ");
                    placa = leitura.entraDados();
                    Carga carga = new Carga();
                    carga.setPlaca(placa);
                    alterarDadosDoveiculoDeCargaPelaPlaca(carga);
                    break;
            }

        } while (!escolha.equals("9"));
        System.out.println("Finalizou o programa");
    }

    private static void DataEHoraAgora() {
        System.out.println("# Agora são: "+DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
    }

    private static void menuSistema() {
        System.out.println();
        System.out.println("1)_ Cadastrar Veículo de Passeio");
        System.out.println("2)_ Cadastrar Veículo de Carga");
        System.out.println("3)_ Imprimir Todos os Veículos de Passeio");
        System.out.println("4)_ Imprimir Todos os Veículos de Carga");
        System.out.println("5)_ Imprimir Veículo de Passeio pela Placa");
        System.out.println("6)_ Imprimir Veículo de Carga pela Placa");
        System.out.println("7)_ Alterar dados do Veículo de Passeio pela Placa");
        System.out.println("8)_ Alterar dados do Veículo de Carga pela Placa");
        System.out.println("9)_ Sair do Sistema");
    }

    private static void alterarDadosDoveiculoDeCargaPelaPlaca(Carga carga) {
        Carga cargaRecuperado = bdVeiculos.buscaVeiculoCargaPelaPlaca(carga);
        int indexVeiculoCarga = bdVeiculos.buscaIndexVeiculoCargaPelaPlaca(cargaRecuperado);
        if (nonNull(cargaRecuperado)) {
            System.out.println(cargaRecuperado);
            System.out.println("\n# Deseja alterar os dados do veiculo ?");
            String resposta = leitura.entraDados();
            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                carga = alterarDadosDoveiculoDeCarga(cargaRecuperado);
                bdVeiculos.save(indexVeiculoCarga, carga);
            }

        } else {
            System.out.println("Veiculo com a placa (" + carga.getPlaca() + ") não foi encontrado");
        }
    }

    private static void sobrescreverDadosDoveiculoDeCargaPelaPlaca(Carga carga) {
        Carga cargaRecuperado = bdVeiculos.buscaVeiculoCargaPelaPlaca(carga);
        int indexVeiculoCarga = bdVeiculos.buscaIndexVeiculoCargaPelaPlaca(cargaRecuperado);
        if (nonNull(cargaRecuperado)) {
            carga = alterarDadosDoveiculoDeCarga(cargaRecuperado);
            bdVeiculos.save(indexVeiculoCarga, carga);
        } else {
            System.out.println("Veiculo com a placa (" + carga.getPlaca() + ") não foi encontrado");
        }
    }

    private static Carga alterarDadosDoveiculoDeCarga(Carga carga) {

        System.out.println("Informe a marca: ");
        resposta = leitura.entraDados();
        carga.setMarca(resposta);

        System.out.println("Informe a modelo: ");
        resposta = leitura.entraDados();
        carga.setModelo(resposta);


        System.out.println("Informe a cor: ");
        resposta = leitura.entraDados();
        carga.setCor(resposta);

        System.out.println("Informe a tara: ");
        resposta = leitura.entraDados();
        int tara = parseStringToInteger(resposta);
        carga.setTara(tara);

        System.out.println("Informe a carga maxima: ");
        resposta = leitura.entraDados();
        int cargaMax = parseStringToInteger(resposta);
        carga.setCargaMax(cargaMax);

        System.out.println("Informe a quantidade de rodas: ");
        resposta = leitura.entraDados();
        int qtdePneus = parseStringToInteger(resposta);
        carga.setQtdeDeRodas(qtdePneus);

        System.out.println("Informe a velocidade maxima em Km/h: ");
        resposta = leitura.entraDados();
        int velMax = parseStringToInteger(resposta);
        carga.addVelocMax(velMax);

        System.out.println("Informe a quantidade de pistões do motor: ");
        resposta = leitura.entraDados();
        int qtdPistoes = parseStringToInteger(resposta);
        System.out.println("Informe a potência do motor: ");
        resposta = leitura.entraDados();
        int potencia = parseStringToInteger(resposta);
        carga.setMotor(new Motor(qtdPistoes, potencia));

        return carga;
    }

    private static void alterarDadosDoveiculoDePasseioPelaPlaca(Passeio passeio) {
        Passeio passeioRecuperado = bdVeiculos.buscaVeiculoPasseioPelaPlaca(passeio);
        int indexVeiculoPasseio = bdVeiculos.buscaIndexVeiculoPasseioPelaPlaca(passeioRecuperado);
        if (nonNull(passeioRecuperado)) {
            System.out.println(passeioRecuperado);
            System.out.println("\n# Deseja alterar os dados do veiculo ?");
            String resposta = leitura.entraDados();
            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                passeio = alterarDadosDoveiculoDePasseio(passeioRecuperado);
                bdVeiculos.save(indexVeiculoPasseio, passeio);
            }
        } else {
            System.out.println("Veiculo com a placa (" + passeio.getPlaca() + ") não foi encontrado");
        }
    }

    private static void sobrescreverDadosDoveiculoDePasseioPelaPlaca(Passeio passeio) {
        Passeio passeioRecuperado = bdVeiculos.buscaVeiculoPasseioPelaPlaca(passeio);
        int indexVeiculoPasseio = bdVeiculos.buscaIndexVeiculoPasseioPelaPlaca(passeioRecuperado);
        if (nonNull(passeioRecuperado)) {
            passeio = alterarDadosDoveiculoDePasseio(passeioRecuperado);
            bdVeiculos.save(indexVeiculoPasseio, passeio);

        } else {
            System.out.println("Veiculo com a placa (" + passeio.getPlaca() + ") não foi encontrado");
        }
    }

    private static Passeio alterarDadosDoveiculoDePasseio(Passeio passeio) {

        System.out.println("Informe a marca: ");
        resposta = leitura.entraDados();
        passeio.setMarca(resposta);

        System.out.println("Informe a modelo: ");
        resposta = leitura.entraDados();
        passeio.setModelo(resposta);

        System.out.println("Informe a cor: ");
        resposta = leitura.entraDados();
        passeio.setCor(resposta);

        System.out.println("Informe a quantidade de passageiros: ");
        resposta = leitura.entraDados();
        int qtdPassageiros = parseStringToInteger(resposta);
        passeio.setQtdeDePassageiros(qtdPassageiros);

        System.out.println("Informe a quantidade de rodas: ");
        resposta = leitura.entraDados();
        int qtdePneus = parseStringToInteger(resposta);
        passeio.setQtdeDeRodas(qtdePneus);

        System.out.println("Informe a velocidade maxima em Km/h: ");
        resposta = leitura.entraDados();
        int velMax = parseStringToInteger(resposta);
        passeio.addVelocMax(velMax);

        System.out.println("Informe a quantidade de pistões do motor: ");
        resposta = leitura.entraDados();
        int qtdPistoes = parseStringToInteger(resposta);
        System.out.println("Informe a potência do motor: ");
        resposta = leitura.entraDados();
        int potencia = parseStringToInteger(resposta);
        passeio.setMotor(new Motor(qtdPistoes, potencia));

        return passeio;
    }

    private static void imprimirVeiculosDeCargaPelaPlaca() {
        System.out.println("# Imprimindo veiculo de carga pela placa");
        System.out.println("Informe a placa: ");
        String placa = leitura.entraDados();
        Carga carga = new Carga();
        carga.setPlaca(placa);
        carga = bdVeiculos.buscaVeiculoCargaPelaPlaca(carga);
        if (nonNull(carga)) {
            System.out.println(carga);
        } else {
            System.out.println("# Veiculo não encontrado");
        }

    }

    private static void imprimirVeiculosDePasseioPelaPlaca() {
        System.out.println("# Imprimindo veiculo de passeio pela placa");
        System.out.println("Informe a placa: ");
        String placa = leitura.entraDados();
        Passeio passeio = new Passeio();
        passeio.setPlaca(placa);
        passeio = bdVeiculos.buscaVeiculoPasseioPelaPlaca(passeio);
        if (nonNull(passeio)) {
            System.out.println(passeio);
        } else {
            System.out.println("# Veiculo não encontrado");
        }
    }

    private static void imprimirTodosVeiculosDeCarga() {
        bdVeiculos.imprimeVeiculosDeCarga();
    }

    private static void imprimirTodosVeiculosDePasseio() {
        bdVeiculos.imprimeVeiculosDePasseio();
    }

    private static void cadastrarVeiculoDeCarga() {

        System.out.println("# Você escolheu cadastrar veiculo de carga");

        do {

            System.out.println("Informe a placa: ");
            String placa = leitura.entraDados();
            Carga carga = new Carga();
            carga.setPlaca(placa);

            try {

                //Caso não existe veiculo cadastrado com essa placa
                if (!bdVeiculos.existeVeiculoCargaComA(carga)) {
                    carga = cadastrarOuAtualizarDados(carga);
                    save(carga);

                    System.out.println("Você quer sobrescrever o veiculo? [s/n]");
                    resposta = leitura.entraDados();

                }

            } catch (VeicExistException e) {
                System.out.println(e.getMessage());

                System.out.println("Você quer sobrescrever o veiculo? [s/n]");
                resposta = leitura.entraDados();
                if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                    sobrescreverDadosDoveiculoDeCargaPelaPlaca(carga);
                } else {
                    carga = bdVeiculos.buscaVeiculoCargaPelaPlaca(carga);
                    cadastrarVeiculoCargaDoMesmoTipo(carga);
                }
            }

        } while (!resposta.equalsIgnoreCase("n") || resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("não"));
    }

    private static void cadastrarVeiculoDePasseio() {

        System.out.println("# Você escolheu cadastrar veiculo de passeio");

        do {

            System.out.println("Informe a placa: ");
            String placa = leitura.entraDados();
            Passeio passeio = new Passeio();
            passeio.setPlaca(placa);

            try {
                //Caso não existe veiculo cadastrado com essa placa
                if (!bdVeiculos.existeVeiculoPasseioComA(passeio)) {
                    passeio = cadastrarOuAtualizarDados(passeio);
                    save(passeio);

                    System.out.println("Deseja cadastrar outro veiculo do mesmo tipo? [s/n]");
                    resposta = leitura.entraDados();

                }
            } catch (VeicExistException e) {
                System.out.println(e.getMessage());

                System.out.println("Você quer sobrescrever o veiculo? [s/n]");
                resposta = leitura.entraDados();

                if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                    sobrescreverDadosDoveiculoDePasseioPelaPlaca(passeio);
                } else {
                    passeio = bdVeiculos.buscaVeiculoPasseioPelaPlaca(passeio);
                    cadastrarVeiculoPasseioDoMesmoTipo(passeio);
                }
            }

        } while (!resposta.equalsIgnoreCase("n") || resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("não"));
    }

    private static void cadastrarVeiculoPasseioDoMesmoTipo(Passeio passeio) {

        String resposta = "n";
        System.out.println("Deseja cadastrar o veiculo do mesmo tipo? [s/n]");
        resposta = leitura.entraDados();
        if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {

            do {

                Passeio passeioParaPesquisa = new Passeio();
                System.out.println("Informe a placa: ");
                String placaVeiculoMesmoTipo = leitura.entraDados();
                passeioParaPesquisa.setPlaca(placaVeiculoMesmoTipo);

                try {

                    if (!bdVeiculos.existeVeiculoPasseioComA(passeioParaPesquisa)) {

                        Passeio passeioDoMesmoTipo = new Passeio();
                        passeioDoMesmoTipo.setPlaca(passeioParaPesquisa.getPlaca());
                        passeioDoMesmoTipo.setMarca(passeio.getMarca());
                        passeioDoMesmoTipo.setQtdeDePassageiros(passeio.getQtdeDePassageiros());
                        passeioDoMesmoTipo.setMotor(new Motor(passeio.getMotor().getQtdPistoes(), passeio.getMotor().getPotencia()));
                        passeioDoMesmoTipo.addVelocMax(passeio.getVelocMax());

                        passeioDoMesmoTipo = cadastrarOuAtualizarDados(passeioDoMesmoTipo);
                        save(passeioDoMesmoTipo);

                        System.out.println("Deseja cadastrar outro veiculo do mesmo tipo? [s/n]");
                        resposta = leitura.entraDados();
                    }

                } catch (VeicExistException e) {
                    System.out.println("Veiculo com a placa (" + passeioParaPesquisa.getPlaca() + ") já foi cadastrado");
                    resposta = "n";
                }

            } while (!resposta.equalsIgnoreCase("n") || resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("não"));

        }
    }

    private static void cadastrarVeiculoCargaDoMesmoTipo(Carga carga) {

        String resposta = "n";
        System.out.println("Deseja cadastrar o veiculo do mesmo tipo? [s/n]");
        resposta = leitura.entraDados();
        if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {

            do {

                Carga cargaParaPesquisa = new Carga();
                System.out.println("Informe a placa: ");
                String placaVeiculoMesmoTipo = leitura.entraDados();
                cargaParaPesquisa.setPlaca(placaVeiculoMesmoTipo);

                try {

                    if (!bdVeiculos.existeVeiculoCargaComA(cargaParaPesquisa)) {

                        Carga cargaDoMesmoTipo = new Carga();
                        cargaDoMesmoTipo.setPlaca(cargaParaPesquisa.getPlaca());
                        cargaDoMesmoTipo.setMarca(carga.getMarca());
                        cargaDoMesmoTipo.setQtdeDeRodas(carga.getQtdeDeRodas());
                        cargaDoMesmoTipo.setMotor(new Motor(carga.getMotor().getQtdPistoes(), carga.getMotor().getPotencia()));
                        cargaDoMesmoTipo.addVelocMax(carga.getVelocMax());

                        cargaDoMesmoTipo = cadastrarOuAtualizarDados(cargaDoMesmoTipo);
                        save(cargaDoMesmoTipo);

                        System.out.println("Deseja cadastrar outro veiculo do mesmo tipo? [s/n]");
                        resposta = leitura.entraDados();
                    }

                } catch (VeicExistException e) {
                    System.out.println("Veiculo com a placa (" + cargaParaPesquisa.getPlaca() + ") já foi cadastrado");
                    resposta = "n";
                }

            } while (!resposta.equalsIgnoreCase("n") || resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("não"));
        }
    }

    private static void save(Passeio passeio) {
        try {
            bdVeiculos.save(passeio);
        } catch (VeicExistException e) {
            System.out.println("Veiculo placa: " + passeio.getPlaca() + " ja existe");
        }
    }

    private static void save(Carga carga) {
        try {
            bdVeiculos.save(carga);
        } catch (VeicExistException e) {
            System.out.println("Veiculo placa: " + carga.getPlaca() + " ja existe");
        }
    }

    private static Passeio cadastrarOuAtualizarDados(Passeio passeio) {

        if (isNull(passeio.getPlaca())) {
            System.out.println("Informe a placa: ");
            resposta = leitura.entraDados();
            passeio.setPlaca(resposta);
        }

        if (isNull(passeio.getMarca())) {
            System.out.println("Informe a marca: ");
            resposta = leitura.entraDados();
            passeio.setMarca(resposta);
        }

        if (isNull(passeio.getModelo())) {
            System.out.println("Informe a modelo: ");
            resposta = leitura.entraDados();
            passeio.setModelo(resposta);
        }

        if (isNull(passeio.getCor())) {
            System.out.println("Informe a cor: ");
            resposta = leitura.entraDados();
            passeio.setCor(resposta);
        }

        if (passeio.getQtdeDePassageiros() == 0) {
            System.out.println("Informe a quantidade de passageiros: ");
            resposta = leitura.entraDados();
            int qtdPassageiros = parseStringToInteger(resposta);
            passeio.setQtdeDePassageiros(qtdPassageiros);
        }

        if (passeio.getQtdeDeRodas() == 0) {
            System.out.println("Informe a quantidade de rodas: ");
            resposta = leitura.entraDados();
            int qtdePneus = parseStringToInteger(resposta);
            passeio.setQtdeDeRodas(qtdePneus);
        }
        if (passeio.getVelocMax() == 0) {
            System.out.println("Informe a velocidade maxima em Km/h: ");
            resposta = leitura.entraDados();
            int velMax = parseStringToInteger(resposta);
            passeio.addVelocMax(velMax);
        }

        if (isNull(passeio.getMotor())) {
            System.out.println("Informe a quantidade de pistões do motor: ");
            resposta = leitura.entraDados();
            int qtdPistoes = parseStringToInteger(resposta);
            System.out.println("Informe a potência do motor: ");
            resposta = leitura.entraDados();
            int potencia = parseStringToInteger(resposta);
            passeio.setMotor(new Motor(qtdPistoes, potencia));
        }
        return passeio;
    }

    private static Carga cadastrarOuAtualizarDados(Carga carga) {

        if (isNull(carga.getPlaca())) {
            System.out.println("Informe a placa: ");
            resposta = leitura.entraDados();
            carga.setPlaca(resposta);
        }

        if (isNull(carga.getMarca())) {
            System.out.println("Informe a marca: ");
            resposta = leitura.entraDados();
            carga.setMarca(resposta);
        }

        if (isNull(carga.getModelo())) {
            System.out.println("Informe a modelo: ");
            resposta = leitura.entraDados();
            carga.setModelo(resposta);
        }

        if (isNull(carga.getCor())) {
            System.out.println("Informe a cor: ");
            resposta = leitura.entraDados();
            carga.setCor(resposta);
        }

        if (carga.getTara() == 0) {
            System.out.println("Informe a tara: ");
            resposta = leitura.entraDados();
            int tara = parseStringToInteger(resposta);
            carga.setTara(tara);
        }

        if (carga.getCargaMax() == 0) {
            System.out.println("Informe a carga maxima: ");
            resposta = leitura.entraDados();
            int cargaMax = parseStringToInteger(resposta);
            carga.setCargaMax(cargaMax);
        }

        if (carga.getQtdeDeRodas() == 0) {
            System.out.println("Informe a quantidade de rodas: ");
            resposta = leitura.entraDados();
            int qtdePneus = parseStringToInteger(resposta);
            carga.setQtdeDeRodas(qtdePneus);
        }

        if (carga.getVelocMax() == 0) {
            System.out.println("Informe a velocidade maxima em Km/h: ");
            resposta = leitura.entraDados();
            int velMax = parseStringToInteger(resposta);
            carga.addVelocMax(velMax);
        }

        if (isNull(carga.getMotor())) {
            System.out.println("Informe a quantidade de pistões do motor: ");
            resposta = leitura.entraDados();
            int qtdPistoes = parseStringToInteger(resposta);
            System.out.println("Informe a potência do motor: ");
            resposta = leitura.entraDados();
            int potencia = parseStringToInteger(resposta);
            carga.setMotor(new Motor(qtdPistoes, potencia));
        }
        return carga;
    }


    private static int parseStringToInteger(String resposta) {
        int i = 0;
        try {
            i = Integer.parseInt(resposta);
        } catch (NumberFormatException e) {
            System.out.println("Não foi possivel converter (" + resposta + ") para um numero valido");
            System.out.println("Tente novamente: ");
        }
        return i;
    }
}
