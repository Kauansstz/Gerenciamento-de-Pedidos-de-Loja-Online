import java.util.List;
import java.util.Map;

public class OrderService {
    Integer idPedido;
    String nomePedido;
    Integer quantidadePedido;
    Double preco;
    public OrderService(Integer idPedido, String nomePedido, Integer quantidadePedido, Double preco){
        this.idPedido = idPedido;
        this.nomePedido = nomePedido;
        this.quantidadePedido = quantidadePedido;
        this.preco = preco;
    }

    public Integer  getIdPedido(){
        return this.idPedido;
    }
    public String getnomePedido(){
        return this.nomePedido;
    }

    public boolean setPedido(){
        boolean flag = true;
        if (idPedido == null && nomePedido == null){
            flag = false;
            System.out.println("Por favor, mencionar o nome ou o número do mesmo.");
            
        }
        
        return flag;
    }

    public static void precoDesconto(List<String> pedidos, Map<String, Double> cardapio){
        List<String> clienteCadastrada = Customer.clienteReserva;
        String cliente = Customer.nomeCliente;
        Double total = 0.0;
        
        for(String pedido: pedidos){
            Double preco = cardapio.get(pedido); 
            if(preco != null){
                total += preco;
                System.out.println(pedido + " - R$ " + String.format("%.2f", preco));
            } else {
                System.out.println("Pedido não encontrado no cardápio: " + pedido);
            }
        }
        if (clienteCadastrada.contains(cliente)) {
            Double desconto = total * 0.10;
            Double precoFinal = total - desconto;
            String formatada = String.format("O valor ficou: R$ %.2f", precoFinal);
            System.out.println(formatada);
        }
        else{
            System.out.println("Cliente comum, preço normal: " + total);
        }
        
    }

    
}
