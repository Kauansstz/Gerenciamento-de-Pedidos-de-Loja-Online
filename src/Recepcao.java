import java.util.Scanner;

public class Recepcao {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Boa Noite\nPossuem reserva?");
        String clienteReserva = entrada.nextLine();

        if (clienteReserva.equalsIgnoreCase("Sim")) {
            boolean cadastrado = perguntaSimNao(entrada, "Possui cadastro?");
            Customer cliente = lerDadosCliente(entrada);
            System.out.println("");
            System.out.println("Essas informações estão corretas?");
            System.out.println("Nome: " + cliente.get_nomeCliente());
            System.out.println("E-mail: " + cliente.get_emailCliente());

            String conf = entrada.nextLine();
            System.out.println(gerarMensagem(conf));
            System.out.println("");

        } else {
            System.out.println("Sentimos muito, mas trabalhamos somente com hora marcada.");
        }

        entrada.close();
    }

    private static boolean perguntaSimNao(Scanner sc, String pergunta) {
        System.out.println(pergunta);
        String resp = sc.nextLine();
        return resp.equalsIgnoreCase("Sim");
    }

    private static Customer lerDadosCliente(Scanner sc) {
        System.out.println("Qual o seu nome?");
        String nome = sc.nextLine();

        System.out.println("Qual o seu E-mail?");
        String email = sc.nextLine();

        return new Customer(nome, email);
    }

    private static String gerarMensagem(String resposta) {
        String msg;
        if (!resposta.equalsIgnoreCase("Sim")){
            msg = "\u001B[33mMe entregue a identidade\u001B[0m";
            System.out.println(msg);
        }else{
            msg = "\u001B[32mIrei acompanhar o senhor e a senhora até a mesa\u001B[0m" ;
            System.out.println(msg);
            try {
                Thread.sleep(3000);
                Waiter.Cardapio();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return msg;
    }
}
