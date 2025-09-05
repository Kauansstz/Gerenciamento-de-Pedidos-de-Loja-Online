import java.util.List;

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

    public void precoDesconto(Double preco){
        List<String> clienteCadastrada = OrderRequest.clienteReserva;
        String cliente = OrderRequest.nomeCliente;
        if (clienteCadastrada.contains(cliente)) {
            Double desconto = preco * 0.10;
            Double precoFinal = preco - desconto;
            System.out.println("O valor ficou: " + precoFinal);
        }
        else{
            System.out.println("Cliente comum, preço normal: " + preco);
        }
        
    }
}
