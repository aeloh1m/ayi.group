package com.clase26;

import java.sql.Timestamp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.clase26.DAO.*;
import com.clase26.DAO.Impl.*;
import com.clase26.Funcion.ConsultaMultitabla;
import com.clase26.Modelos.*;

// Todavía falta agregarle la lógica de consulta multitabla según elección, desde Funcion.ConsultaMultitabla.java

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ProveedorDAO proveedorDAO = new ProveedorDAOImpl();
        VentaDAO ventaDAO = new VentaDAOImpl();
        DetalleDeVentaDAO detalleDeVentaDAO = new DetalleDeVentaDAOImpl();
        MetodoDePagoDAO metodoDePagoDAO = new MetodoDePagoDAOImpl();
        ClienteDAO clienteDAO = new ClienteDAOImpl(); // Asegúrate de que la clase esté implementada
        ConsultaMultitabla consultaMultitabla = new ConsultaMultitabla();

        while (true) {
            System.out.println("\n1. Agregar Proveedor");
            System.out.println("2. Consultar Proveedores");
            System.out.println("3. Agregar Cliente");
            System.out.println("4. Consultar Clientes");
            System.out.println("5. Agregar Venta");
            System.out.println("6. Consultar Ventas");
            System.out.println("7. Consultar Ventas con Detalles");
            System.out.println("8. Agregar Método de Pago");
            System.out.println("9. Consultar Métodos de Pago");
            System.out.println("10. Actualizar Proveedor");
            System.out.println("11. Actualizar Cliente");
            System.out.println("12. Actualizar Venta");
            System.out.println("13. Actualizar Método de Pago");
            System.out.println("14. Eliminar Proveedor");
            System.out.println("15. Eliminar Cliente");
            System.out.println("16. Eliminar Venta");
            System.out.println("17. Eliminar Método de Pago");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = reader.readLine();

            switch (opcion) {
                case "1":
                    // Cargar datos del proveedor
                    System.out.print("Nombre: ");
                    String nombre = reader.readLine();
                    System.out.print("Razón Social: ");
                    String razonSocial = reader.readLine();
                    System.out.print("Contacto: ");
                    String contacto = reader.readLine();
                    System.out.print("Dirección: ");
                    String direccion = reader.readLine();
                    System.out.print("Email: ");
                    String email = reader.readLine();
                    System.out.print("Teléfono: ");
                    String telefono = reader.readLine();

                    Proveedor proveedor = new Proveedor();
                    proveedor.setNombre(nombre);
                    proveedor.setRazonSocial(razonSocial);
                    proveedor.setContacto(contacto);
                    proveedor.setDireccion(direccion);
                    proveedor.setEmail(email);
                    proveedor.setTelefono(telefono);

                    proveedorDAO.agregarProveedor(proveedor);
                    System.out.println("Proveedor agregado con éxito.");
                    break;

                case "2":
                    List<Proveedor> proveedores = proveedorDAO.obtenerTodosProveedores();
                    proveedores.forEach(System.out::println);
                    break;

                case "3":
                    // Cargar datos del cliente
                    System.out.print("Nombre del Cliente: ");
                    String nombreCliente = reader.readLine();
                    System.out.print("Email del Cliente: ");
                    String emailCliente = reader.readLine();
                    System.out.print("Teléfono del Cliente: ");
                    String telefonoCliente = reader.readLine();

                    Cliente cliente = new Cliente();
                    cliente.setNombre(nombreCliente);
                    cliente.setEmail(emailCliente);
                    cliente.setTelefono(telefonoCliente);

                    clienteDAO.agregarCliente(cliente);
                    System.out.println("Cliente agregado con éxito.");
                    break;

                case "4":
                    List<Cliente> clientes = clienteDAO.obtenerTodosClientes();
                    clientes.forEach(System.out::println);
                    break;

                case "5":
                    // Cargar datos de la venta
                    System.out.print("ID del Cliente: ");
                    int clienteId = Integer.parseInt(reader.readLine());
                    System.out.print("Fecha de Venta (YYYY-MM-DD HH:MM:SS): ");
                    String fechaVenta = reader.readLine();
                    System.out.print("Total: ");
                    double total = Double.parseDouble(reader.readLine());
                    System.out.print("Método de Pago ID: ");
                    int metodoDePagoId = Integer.parseInt(reader.readLine());

                    Venta venta = new Venta();
                    venta.setClienteId(clienteId);
                    venta.setFechaDeVenta(Timestamp.valueOf(fechaVenta));
                    venta.setTotal(total);
                    venta.setMetodoDePagoId(metodoDePagoId);

                    ventaDAO.agregarVenta(venta);
                    System.out.println("Venta agregada con éxito.");
                    break;

                case "6":
                    List<Venta> ventas = ventaDAO.obtenerTodasVentas();
                    ventas.forEach(System.out::println);
                    break;

                case "7":
                    List<String> resultados = consultaMultitabla.obtenerVentasConDetalles();
                    resultados.forEach(System.out::println);
                    break;

                case "8":
                    // Cargar datos del método de pago
                    System.out.print("Nombre del Método de Pago: ");
                    String nombreMetodoPago = reader.readLine();

                    MetodoDePago metodoDePago = new MetodoDePago();
                    metodoDePago.setDescripcion(nombreMetodoPago);

                    metodoDePagoDAO.agregarMetodoDePago(metodoDePago);
                    System.out.println("Método de Pago agregado con éxito.");
                    break;

                case "9":
                    List<MetodoDePago> metodosDePago = metodoDePagoDAO.obtenerTodosMetodosDePago();
                    metodosDePago.forEach(System.out::println);
                    break;

                case "10":
                    // Actualizar Proveedor
                    System.out.print("ID del Proveedor a actualizar: ");
                    int proveedorId = Integer.parseInt(reader.readLine());
                    Proveedor proveedorActualizado = proveedorDAO.obtenerProveedor(proveedorId);
                    if (proveedorActualizado != null) {
                        System.out.print("Nuevo Nombre (actual: " + proveedorActualizado.getNombre() + "): ");
                        String nuevoNombre = reader.readLine();
                        System.out.print("Nueva Razón Social (actual: " + proveedorActualizado.getRazonSocial() + "): ");
                        String nuevaRazonSocial = reader.readLine();
                        System.out.print("Nuevo Contacto (actual: " + proveedorActualizado.getContacto() + "): ");
                        String nuevoContacto = reader.readLine();
                        System.out.print("Nueva Dirección (actual: " + proveedorActualizado.getDireccion() + "): ");
                        String nuevaDireccion = reader.readLine();
                        System.out.print("Nuevo Email (actual: " + proveedorActualizado.getEmail() + "): ");
                        String nuevoEmail = reader.readLine();
                        System.out.print("Nuevo Teléfono (actual: " + proveedorActualizado.getTelefono() + "): ");
                        String nuevoTelefono = reader.readLine();

                        proveedorActualizado.setNombre(nuevoNombre.isEmpty() ? proveedorActualizado.getNombre() : nuevoNombre);
                        proveedorActualizado.setRazonSocial(nuevaRazonSocial.isEmpty() ? proveedorActualizado.getRazonSocial() : nuevaRazonSocial);
                        proveedorActualizado.setContacto(nuevoContacto.isEmpty() ? proveedorActualizado.getContacto() : nuevoContacto);
                        proveedorActualizado.setDireccion(nuevaDireccion.isEmpty() ? proveedorActualizado.getDireccion() : nuevaDireccion);
                        proveedorActualizado.setEmail(nuevoEmail.isEmpty() ? proveedorActualizado.getEmail() : nuevoEmail);
                        proveedorActualizado.setTelefono(nuevoTelefono.isEmpty() ? proveedorActualizado.getTelefono() : nuevoTelefono);

                        proveedorDAO.actualizarProveedor(proveedorActualizado);
                        System.out.println("Proveedor actualizado con éxito.");
                    } else {
                        System.out.println("Proveedor no encontrado.");
                    }
                    break;

                case "11":
                    // Actualizar Cliente
                    System.out.print("ID del Cliente a actualizar: ");
                    int clienteIdActualizar = Integer.parseInt(reader.readLine());
                    Cliente clienteActualizado = clienteDAO.obtenerCliente(clienteIdActualizar);
                    if (clienteActualizado != null) {
                        System.out.print("Nuevo Nombre (actual: " + clienteActualizado.getNombre() + "): ");
                        String nuevoNombreCliente = reader.readLine();
                        System.out.print("Nuevo Email (actual: " + clienteActualizado.getEmail() + "): ");
                        String nuevoEmailCliente = reader.readLine();
                        System.out.print("Nuevo Teléfono (actual: " + clienteActualizado.getTelefono() + "): ");
                        String nuevoTelefonoCliente = reader.readLine();

                        clienteActualizado.setNombre(nuevoNombreCliente.isEmpty() ? clienteActualizado.getNombre() : nuevoNombreCliente);
                        clienteActualizado.setEmail(nuevoEmailCliente.isEmpty() ? clienteActualizado.getEmail() : nuevoEmailCliente);
                        clienteActualizado.setTelefono(nuevoTelefonoCliente.isEmpty() ? clienteActualizado.getTelefono() : nuevoTelefonoCliente);

                        clienteDAO.actualizarCliente(clienteActualizado);
                        System.out.println("Cliente actualizado con éxito.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case "12":
                    // Actualizar Venta
                    System.out.print("ID de la Venta a actualizar: ");
                    int ventaId = Integer.parseInt(reader.readLine());
                    Venta ventaActualizada = ventaDAO.obtenerVenta(ventaId);
                    if (ventaActualizada != null) {
                        System.out.print("Nuevo ID del Cliente (actual: " + ventaActualizada.getClienteId() + "): ");
                        int nuevoClienteId = Integer.parseInt(reader.readLine());
                        System.out.print("Nueva Fecha de Venta (YYYY-MM-DD HH:MM:SS, actual: " + ventaActualizada.getFechaDeVenta() + "): ");
                        String nuevaFechaVenta = reader.readLine();
                        System.out.print("Nuevo Total (actual: " + ventaActualizada.getTotal() + "): ");
                        double nuevoTotal = Double.parseDouble(reader.readLine());
                        System.out.print("Nuevo Método de Pago ID (actual: " + ventaActualizada.getMetodoDePagoId() + "): ");
                        int nuevoMetodoDePagoId = Integer.parseInt(reader.readLine());

                        ventaActualizada.setClienteId(nuevoClienteId);
                        ventaActualizada.setFechaDeVenta(Timestamp.valueOf(nuevaFechaVenta));
                        ventaActualizada.setTotal(nuevoTotal);
                        ventaActualizada.setMetodoDePagoId(nuevoMetodoDePagoId);

                        ventaDAO.actualizarVenta(ventaActualizada);
                        System.out.println("Venta actualizada con éxito.");
                    } else {
                        System.out.println("Venta no encontrada.");
                    }
                    break;

                case "13":
                    // Actualizar Método de Pago
                    System.out.print("ID del Método de Pago a actualizar: ");
                    int metodoPagoId = Integer.parseInt(reader.readLine());
                    MetodoDePago metodoDePagoActualizado = metodoDePagoDAO.obtenerMetodoDePago(metodoPagoId);
                    if (metodoDePagoActualizado != null) {
                        System.out.print("Nuevo Nombre (actual: " + metodoDePagoActualizado.getDescripcion() + "): ");
                        String nuevoNombreMetodoPago = reader.readLine();

                        metodoDePagoActualizado.setDescripcion(nuevoNombreMetodoPago.isEmpty() ? metodoDePagoActualizado.getDescripcion() : nuevoNombreMetodoPago);

                        metodoDePagoDAO.actualizarMetodoDePago(metodoDePagoActualizado);
                        System.out.println("Método de Pago actualizado con éxito.");
                    } else {
                        System.out.println("Método de Pago no encontrado.");
                    }
                    break;

                case "14":
                    // Eliminar Proveedor
                    System.out.print("ID del Proveedor a eliminar: ");
                    int idProveedorEliminar = Integer.parseInt(reader.readLine());
                    proveedorDAO.eliminarProveedor(idProveedorEliminar);
                    System.out.println("Proveedor eliminado con éxito.");
                    break;

                case "15":
                    // Eliminar Cliente
                    System.out.print("ID del Cliente a eliminar: ");
                    int idClienteEliminar = Integer.parseInt(reader.readLine());
                    clienteDAO.eliminarCliente(idClienteEliminar);
                    System.out.println("Cliente eliminado con éxito.");
                    break;

                case "16":
                    // Eliminar Venta
                    System.out.print("ID de la Venta a eliminar: ");
                    int idVentaEliminar = Integer.parseInt(reader.readLine());
                    ventaDAO.eliminarVenta(idVentaEliminar);
                    System.out.println("Venta eliminada con éxito.");
                    break;

                case "17":
                    // Eliminar Método de Pago
                    System.out.print("ID del Método de Pago a eliminar: ");
                    int idMetodoPagoEliminar = Integer.parseInt(reader.readLine());
                    metodoDePagoDAO.eliminarMetodoDePago(idMetodoPagoEliminar);
                    System.out.println("Método de Pago eliminado con éxito.");
                    break;

                case "0":
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}
