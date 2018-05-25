/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Tarjeta;

/**
 *
 * @author Andrea
 * 
 * Clase controladora para el modelo cliente
 * contiene variables y metodos estaticos que se pueden llamar sin tener que 
 * instanciar objetos de esta clase.
 */
public class ControladorCliente {
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private static int codigoAuto = 1;
    
    /**
     * Metodo para buscar pod codigo
     * @param codigo
     * @return Retorna el cliente encontrado
     */
    public static Cliente buscar(int codigo){
        
        for(Cliente cliente: listaClientes){
           if(cliente.getIdCliente()== codigo)
               return cliente;
        }
        return null;
    }
    
    /** Sobrecarga de metodo buscar
     *  para buscar por nombre
     * @param nombre
     * @return
     */
    public static Cliente buscar(String nombre){
        
        for(Cliente cliente: listaClientes){
           if(cliente.getNombre().toLowerCase().contains(nombre))
               return cliente;
        }
        return null;
    }
    
    /** Sobrecarga de metodo buscar
     *  para buscar por objeto cliete completo
     * @param cliente
     * @return
     */
    public static int buscar(Cliente cliente){
        return listaClientes.indexOf(cliente);
    }
    
    /**
     * Metodo void (sin retorno) para agregar nuevos clientes
     * @param nombre
     * @param direccion
     * @param email
     * @param saldo
     * @param celular
     * @param tarjeta
     */
    public static void agregar(String nombre, String direccion,
                    String email, Double saldo, long celular, Tarjeta tarjeta){
     // llama el constructor de la clase cliente con el codigo autogenerado
     // y lo postincrementa (++)
        Cliente clienteNuevo = new Cliente(
                codigoAuto++, nombre, direccion, email, saldo, celular, tarjeta
        );
        listaClientes.add(clienteNuevo);
    }
    
    /**
     * Metodo para editar clientes
     * @param id
     * recibe como parameto el objeto Cliente que se queire editar
     * @param cliente
     */
    public static void editar(int id,Cliente cliente){
      // llama metodo set de la clase ArrayList, con la pocición en la lista
      // y con el nuevo contenido
        listaClientes.set(id, cliente);
    }
    
    /**
     * Metodo para listar todos los clientes
     * @return clientes, un arreglo de Strings
     */
    public static String[] listar(){
        String[] clientes = new String[listaClientes.size()];
        int id = 0;
        // for mejorado o foreach
        for(Cliente cliente: listaClientes){
          clientes[id] = cliente.getNombre();
          id++;
        }
        return clientes;
    }

    /**
     * Metodo para eliminar
     * utiliza el metodo remove de la clase ArrayList
     * @param cliente
     */
    public static void eliminar(Cliente cliente) {
        listaClientes.remove(cliente);
    }
    
    
}
