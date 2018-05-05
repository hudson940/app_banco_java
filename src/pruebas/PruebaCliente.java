package pruebas;
import controlador.ClienteController;
import modelo.Tarjeta;
import modelo.Cliente;

import java.util.List;

public class PruebaCliente {
    private static String nombre = "nuevo cliente";
    private static String direccion = "calle de prueba 45";
    private static String email = "info@test.com";
    private static String celular = "3326554587";
    private static Double saldo = .0;
    private static Tarjeta tarjeta_credito = new Tarjeta(1000, 500.0,"15", 0.2f);


    public PruebaCliente(){
        // agregar cliente
       int idNuevoCliente =  agregar();
        System.out.println("cliente creado con el id: "+idNuevoCliente);
        // buscar cliente.
        Cliente buscado = ClienteController.buscarCliente(idNuevoCliente);

        System.out.println("cliente encontrado: "+ buscado.to_string());

        int nuevoCliente2 = ClienteController.agregarCliente("nuevo cliente 2", direccion, email, celular,
                saldo, null);


        // agregar saldo
        Double nuevoSaldo = buscado.addSaldo(500.0);
        if (buscado.getSaldo() == nuevoSaldo) {
            System.out.println("Saldo agregado correctamente, nuevo saldo: " + nuevoSaldo);
        } else {
            System.out.println("Error, nuevo saldo no es correcto ");
        }

        // retirar saldo
        Double saldo = buscado.retirarSaldo(250.0);
        if (buscado.getSaldo() == saldo) {
            System.out.println("Saldo retirado correctamente, nuevo saldo: " + saldo);
        } else {
            System.out.println("Error, nuevo saldo no es correcto ");
        }

        Double saldoInsuficiente = buscado.retirarSaldo(1000.0);
        if (saldoInsuficiente == null) {
            System.out.println("Prueba OK. Sado insuficiente: " + saldo);
        } else {
            System.out.println("Error, retiro aprobado con saldo insuficiente ");
        }

        // editar cliente
        nombre = "cliente editado";
        direccion = "dirección editada";
        email = "editado@email.com";
        celular = "3000000000";
        saldo = 100.0;
        tarjeta_credito = null;

        Cliente editado = ClienteController.editarCliente(buscado.getCodigo(), nombre, direccion, email,
                celular, tarjeta_credito);

        System.out.println("Editado: \n"+ editado.to_string());

        List<Cliente> buscadoNombre = ClienteController.buscarCliente(buscado.getNombre());
        System.out.println("Encontrados");
        buscadoNombre.forEach((cliente -> {
            System.out.println(cliente.to_string());
        }));

        // listar

        ClienteController.listar().forEach((c ->{
            System.out.println(c.toString());
        }));



        //eliminar
        String eliminado = ClienteController.eliminarCliente(buscado.getCodigo());
        System.out.println(eliminado);






    }

    public static int agregar(){
        int idNuevoCliente = ClienteController.agregarCliente(nombre,direccion,email,celular,saldo,tarjeta_credito);
        return idNuevoCliente;

    }
}
