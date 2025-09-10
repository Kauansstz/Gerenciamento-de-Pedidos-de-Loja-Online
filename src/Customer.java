import java.util.List;

public class Customer {
    static String nomeCliente;
    String email;
    static List<String> clienteReserva = List.of("Pedro", "João");

    public Customer(String nomeCliente, String email){
        Customer.nomeCliente = nomeCliente;
        this.email = email;
    }

    public String get_nomeCliente(){
        return nomeCliente;
    }
    public String setter_nomeCliente(String nome){
        String msg;
        if (clienteReserva.contains(nome)){
            msg = "\u001B[32m" + "Cliente encontrado" + "\u001B[0m";
            Waiter.main(null);
            

        }else{
            msg= "\u001B[31m"+"Cliente não encontrado" + "\u001B[0m";
        }
        nomeCliente = nome;
        return msg;
    }
    public String get_emailCliente(){
        return email;
    }
}
