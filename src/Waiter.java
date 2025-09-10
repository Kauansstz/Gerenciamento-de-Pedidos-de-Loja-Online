import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Waiter {
    public static String Promt(){
        Scanner entrada = new Scanner(System.in);
        String response = entrada.nextLine();
        return response;
    }
    
    public static void Cardapio(){
        System.out.println("O que o casal deseja ?");

        Map<String, Double> cardapio = new HashMap<>();
        cardapio.put("Costela ao molho", 65.99);
        cardapio.put("Pizza Familia", 105.99);
        cardapio.put("Frango", 30.00);

        int i = 0;
        System.out.println("Cardápio: ");
        for(Map.Entry<String, Double> nomePedidos: cardapio.entrySet()){
            i++;
            System.out.println(i + " - " + nomePedidos.getKey() + " - " + "R$" + nomePedidos.getValue());
        }
        System.out.println("");
        List<String> pedidos = new ArrayList<>();
        List<String> conta = new ArrayList<>();
        i = 0;
        while (true) {
            System.out.println("Faça o seu pedido (ou digite 'Conta'): ");
            String getPedidos = Promt();
            
            boolean encontrou = false;
            
            i++;
            for(String chave: cardapio.keySet()){
                if(chave.equalsIgnoreCase(getPedidos)){
                    Double preco = cardapio.get(chave);
                    pedidos.add(getPedidos);
                    conta.add("O pedido: "+ i + " - " + getPedidos + " R$" + preco);
                    System.out.println("✔ Adicionado na conta");
                    encontrou = true;
                    break;
                }
            }
            if(getPedidos.equalsIgnoreCase("conta")){
                System.out.println("Quero a conta!");
                OrderService.precoDesconto(pedidos,cardapio);
                break;
            }
            if (!encontrou) {
                System.out.println("❌ Nenhum item do cardápio encontrado nessa frase.");}

            System.out.println("\nLista de pedidos: ");
            for(String c : conta){
                System.out.println(c);
            }
        }
    }

    
    public static void main(String[] args) {
        System.out.println("O casal vai querer pedir agora?");
        String casal = Promt();
        switch (casal) {
            case "Sim":
                    Cardapio();
                break;
        
            default:
                System.out.println("ok, volto mais tarde.");
                break;
        }
        

    }
    
}
