import java.util.Scanner;

public class Recepcao {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Boa Noite\nPossuem reserva?");
        String clienteReserva = entrada.nextLine();

        if (clienteReserva.equalsIgnoreCase("Sim")) {
            boolean cadastrado = perguntaSimNao(entrada, "Possui cadastro?");
            OrderRequest cliente = lerDadosCliente(entrada);

            System.out.println("Essas informações estão corretas?");
            System.out.println("Nome: " + cliente.get_nomeCliente());
            System.out.println("E-mail: " + cliente.get_emailCliente());

            String conf = entrada.nextLine();
            System.out.println(gerarMensagem(conf));

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

    private static OrderRequest lerDadosCliente(Scanner sc) {
        System.out.println("Qual o seu nome?");
        String nome = sc.nextLine();

        System.out.println("Qual o seu E-mail?");
        String email = sc.nextLine();

        return new OrderRequest(nome, email);
    }

    private static String gerarMensagem(String resposta) {
        return resposta.equalsIgnoreCase("Sim")
            ? "\u001B[32mIrei acompanhar o senhor e a senhora até a mesa\u001B[0m"
            : "\u001B[33mMe entregue a identidade\u001B[0m";
    }
}
