package controlador;

import modelo.Cliente;
import modelo.Tarjeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteController {

    private  static ArrayList<Cliente> clientes = new ArrayList<Cliente>();;
    private static int id = 1;


    public static int agregarCliente
            (String nombre, String direccion, String email, String celular, Double saldo ,Tarjeta tarjeta_credito){
        int codigo = id++;
        Cliente nuevo = new Cliente(codigo, nombre, direccion, email, celular, saldo, tarjeta_credito);

        clientes.add(nuevo);
        return codigo;
    }


    public static Cliente buscarCliente(int idCliente) {
       for (Cliente cliente: clientes) {
            if(cliente.getCodigo() == idCliente)
               return cliente;                        ;
        }
        return null;

    }

    public static List<Cliente> buscarCliente(String nombreCliente){
        List<Cliente> clientesEncontrados =
                clientes.stream()
                        .filter(c-> c.getNombre().contains((nombreCliente)))
                        .collect(Collectors.toList());

        return  clientesEncontrados;
    }

    public static Cliente editarCliente
            (int codigo, String nombre, String direccion, String email, String celular, Tarjeta tarjeta_credito) {

        Cliente buscado = buscarCliente(codigo);
        if(buscado != null){
        buscado.setNombre(nombre);
        buscado.setCelular(celular);
        buscado.setDireccion(direccion);
        buscado.setCelular(celular);
        buscado.setEmail(email);
        buscado.setTarjeta_credito(tarjeta_credito);


        return buscado;
        }

        else

        return null;


    }

    public static String eliminarCliente(int codigo) {
       clientes.remove(buscarCliente(codigo));
        return "Cliente Eliminado";
    }

    public static List listar (){
        return clientes;
    }
}
