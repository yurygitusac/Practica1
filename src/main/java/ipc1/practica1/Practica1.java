/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ipc1.practica1;
import java.util.Scanner;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Yury Santos
 */


class Producto
{    String nombre;
    double precio;
}

class Descuento
{
    String codescuento;
    int descuento2;
}

class InfoCliente
{
    String nombreCliente;
    String nitCliente;
}

class Venta{
    double ventaProd;
    String continuar;
    
    double subTotal = 0.00;
    double totalFinal = 0.00;
    
}
        


public class Practica1 {
    
    public static Scanner scannerUsuario = new Scanner(System.in);
    public static Scanner scannerContra = new Scanner(System.in);
    
    public static Scanner scannerNumerico = new Scanner(System.in);
        
    public static Scanner scannerNombreProducto = new Scanner(System.in);
    public static Scanner scannerPrecioProducto = new Scanner(System.in);
    
    public static Scanner scannerNombreCodigo = new Scanner(System.in);
    public static Scanner scannerCantDescuento = new Scanner(System.in);
    
    public static Scanner scannerNombreCliente = new Scanner(System.in);
    public static Scanner scannerNitCliente = new Scanner(System.in);
    
    public static Scanner seleccionProductos = new Scanner(System.in);
    public static Scanner seleccionCantidad = new Scanner(System.in);
    public static Scanner seleccionCodigo = new Scanner(System.in);
    
    public static Scanner scannerContinuarSiNo = new Scanner(System.in);
    
    public static Producto [] productos = new Producto [1000];
    public static Descuento [] descuentos = new Descuento [1000];
    public static Venta [] ventas = new Venta[1000];
    
    
       
    
    public static void IngresoUsuario(){
        
        String user = "cajero_202113318";
        String pass = "ipc1_202113318";
        boolean acceso = false;
        
        while (!acceso){
            
            System.out.println("1. Ingresar Usuario");
            String usuario = scannerUsuario.nextLine();
            System.out.println("1. Ingresar Contraseña");
            String contra = scannerUsuario.nextLine();
            
            if(user.equals(usuario)){
                if(pass.equals(contra)){
                    menuPrincipal();
                    acceso = true;
                } else{
                    System.out.println("Contraseña incorrecto");
                }
            } else{
                System.out.println("Usuario incorrecto");
            }
            
        }
        
    }
    
    
    public static void menuPrincipal(){
        int opcion = 0;
        do{
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("MENU PRINCIPAL");
        System.out.println(" ");
        System.out.println("1. Agregar Nuevos Productos");
        System.out.println("2. Agregar Cupones de Descuento");
        System.out.println("3. Realizar Ventas");
        System.out.println("4. Realizar Reporte");
        System.out.println("Ingrese una opcion");
        opcion = scannerNumerico.nextInt();
        
        switch (opcion){
            case 1:
                IngresarProducto();
                break;
            case 2:
                IngresarCodDescuento();
                break;
            case 3:
                RealizarVenta();
                break;
            case 4:
                Reporte();
                break;
            default:
                System.out.println("No ingresaste una opcion valida");
            
        }
        
        } while (opcion != 5);
        
    }
    
    
    public static void IngresarProducto(){
       boolean ingresocorrecto = false;
        
        while (!ingresocorrecto){
            
            System.out.println("Ingresar Nombre del Producto");
            String nombre = scannerNombreProducto.nextLine();
            System.out.println("Ingresar Precio del producto");
            double precio = scannerPrecioProducto.nextDouble();
            
            if (precio <= 0)
            {
                System.out.println("Precio debe ser mayor a 0");
            } 
            
            
            else{
                Producto producto = new Producto();
                producto.nombre = nombre;
                producto.precio = precio;
        
                    for (int i = 0; i < productos.length; i++){
            
                        if(productos[i] == null){
                            productos[i] = producto;
                            System.out.println("Producto agregado correctamente");
                            ingresocorrecto = true;
                            break;
                        }
                
                    } 
            }
        }
    }
    
    
    public static void IngresarCodDescuento(){
       boolean ingresocorrecto = false;
        
        while (!ingresocorrecto){
            
            System.out.println("Ingresar Codigo de Descuento (codigo debe contener 4 caracteres)");
            String codescuento = scannerNombreCodigo.nextLine();
            System.out.println("Ingresar Descuento (Descuento debe de ser mayor a 0 y menor o igual a 100)");
            int cantdescuento = scannerCantDescuento.nextInt();
            
            int contador = codescuento.length();
            
            if (contador != 4 || cantdescuento <= 0 || cantdescuento > 100 ) 
            {
                    System.out.println("Error, Codigo descuento debe contener 4 caracteres y descuento debe de ser mayor a 0 y menor o igual que 100");
            }
            
            else{
                Descuento descuento = new Descuento();
                descuento.codescuento = codescuento;
                descuento.descuento2 = cantdescuento;
                
                for (int i = 0; i < descuentos.length; i++){
            
                        if(descuentos[i] == null){
                            descuentos[i] = descuento;
                            System.out.println("Codigo Descuento agregado correctamente");
                            ingresocorrecto = true;
                            break;
                        }
                
                    } 
            } 
        }
    }
    
    public static void RealizarVenta(){
        
        
        
        int seleccion;
        int cantidad;
        int seleccionCo;
        String continuarSiNo;
        
        double subTotal = 0.0;
        
        double operacion1;
        double operacion2;
        double totalFinal;
        
        
               
        boolean continuarVenta = false;
        
        
        
        System.out.println("Ingrese Nombre del Cliente");
        String nombreCliente = scannerNombreCliente.nextLine();
        System.out.println("Ingrese NIT (Si no posee nit dejar en blanco");
        String nitCliente = scannerNitCliente.nextLine();
        
        System.out.println("Nombre Cliente: " + nombreCliente);
        
        if (nitCliente == ""){
            System.out.println("Numero de NIT: " + "C/F");
        }else{
            System.out.println("Numero de NIT: " + nitCliente);
        }
        
        
        
        System.out.println("Listado Productos Disponibles");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        for(int i = 0; i < productos.length; i++){
            if(productos[i] == null){
                break;
            }
            System.out.println((i + 1) + " - " + productos[i].nombre + " - " + productos[i].precio);
        }
        
        while (!continuarVenta){
        System.out.println("Ingrese numero de producto a elegir: ");
        seleccion = seleccionProductos.nextInt();
        System.out.println("Producto seleccionado es: " + productos[seleccion - 1].nombre + " - " + productos[seleccion - 1].precio);
        System.out.println("Ingrese la cantidad que desea comprar: ");
        cantidad = seleccionCantidad.nextInt();
            
        double ventaProd = (cantidad * (productos[seleccion - 1].precio));
            
        System.out.println("Producto seleccionado es: " + productos[seleccion - 1].nombre);
        System.out.println("Cantidad a pagar es: " + ventaProd);
        
        Venta venta = new Venta() ;
        venta.ventaProd = ventaProd;
        
        for(int i = 0; i < ventas.length; i++){
            if(ventas[i] == null){
                ventas[i] = venta;
                System.out.println("Venta completada");
                break;
            }
        }
        
        System.out.println("Deseas hacer una nueva venta (S/N): ");
        continuarSiNo = scannerContinuarSiNo.nextLine();
        
        if(continuarSiNo.equals("S") || continuarSiNo.equals("s")){
            continuarVenta = false;
        }
        if(continuarSiNo.equals("N") || continuarSiNo.equals("n")){
            for(int i = 0; i < ventas.length; i++){
                if(ventas[i] == null){
                    break;
                }
                subTotal += ventas[i].ventaProd;
                
            }
            
            System.out.println("SubTotal es: " + subTotal);
            System.out.println("Deseas ingresar codigo de descuento(S/N): ");
            continuarSiNo = scannerContinuarSiNo.nextLine();
            
            if(continuarSiNo.equals("S") || continuarSiNo.equals("s")){
                System.out.println("Listado Productos Codigos de Descuento Disponibles");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                for(int i = 0; i < descuentos.length; i++){
                    if(descuentos[i] == null){
                        break;
            }
            System.out.println((i + 1) + " - " + descuentos[i].codescuento + " - " + descuentos[i].descuento2 + "%");
                }
                
                System.out.println("Ingrese numero de Codigo de Descuento a elegir: ");
                seleccionCo = seleccionCodigo.nextInt();
                System.out.println("Codigo seleccionado es: " + descuentos[seleccionCo - 1].codescuento + " - " + descuentos[seleccionCo - 1].descuento2 + "%");
            
                operacion1 = ((descuentos[seleccionCo - 1].descuento2) / 100.00);
                operacion2 = (operacion1 * subTotal);
                totalFinal = (subTotal - operacion2);
                System.out.println("Total: " + totalFinal);
                
                System.out.println("*******************************************************************");
                System.out.println("Nombre de la Empresa: SUPER 25");
                System.out.println("Cajero de turno: Yury Santos");
                System.out.println("Nombre Cliente: " + nombreCliente);
                if (nitCliente == ""){
                System.out.println("Numero de NIT: " + "C/F");
                }else{
                System.out.println("Numero de NIT: " + nitCliente);
                }
                Date date = Date.from(Instant.now());
                System.out.println("Emision de Factura " + date);
                System.out.println("Lista de Prodcutos Adquiridos");
                System.out.println("Sub Total: " + subTotal);
                System.out.println("Descuento Aplicado: " + descuentos[seleccionCo - 1].codescuento + " - " + descuentos[seleccionCo - 1].descuento2 + "%");
                System.out.println("Total: " + totalFinal);
                
        }
                
                
                
                continuarVenta = true;    
            }
            
                        
            if(continuarSiNo.equals("N") || continuarSiNo.equals("n")){
                System.out.println("*******************************************************************");
                System.out.println("Nombre de la Empresa: SUPER 25");
                System.out.println("Cajero de turno: Yury Santos");
                System.out.println("Nombre Cliente: " + nombreCliente);
                if (nitCliente == ""){
                System.out.println("Numero de NIT: " + "C/F");
                }else{
                System.out.println("Numero de NIT: " + nitCliente);
                }
                Date date = Date.from(Instant.now());
                System.out.println("Emision de Factura " + date);
                System.out.println("Lista de Prodcutos Adquiridos");
                System.out.println("Sub Total: " + subTotal);
                System.out.println("Total: " + subTotal);
                continuarVenta = true;
            }
            
        }
            
            
        }

        

    
public static void Reporte(){
    
    for(int i = 0; i < productos.length; i++){
        for (int j = 0; j <productos.length - 1; j++){
            if(productos[j] == null || productos[j+1] == null){
                break;
            }
            Producto productoActual = productos[j];
            Producto productoSiguiente = productos[j+1];
            
            if(productoActual.precio < productoSiguiente.precio){
                productos[j] = productoSiguiente;
                productos[j+1] = productoActual;
            }
        }
    }
    
    
    System.out.println("Listado Productos Disponibles");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        for(int i = 0; i < productos.length; i++){
            if(productos[i] == null){
                break;
            }
            
            System.out.println((i + 1) + " - " + productos[i].nombre + " - " + productos[i].precio);
        }

}



        
        
        
               
    
    
    public static void main(String[] args) {
        IngresoUsuario();
    }
}
        
       


