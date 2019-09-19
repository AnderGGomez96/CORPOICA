
package corpoicaAPP;
import Modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ghost
 */
public class CRUD {
    //Atributos

    //Metodos
    public static void menuIngresoProductos(ArrayList<ProductoControl> Productos,Scanner entradaInt, Scanner entradaStr)
    {
        int opcion;
        do
        {
            opcionesIngreso();
            opcion=entradaInt.nextInt();
            switch (opcion)
            {
                case 1:
                    ingresarProducto(Productos,entradaInt, entradaStr, opcion);
                    break;
                case 2:
                    ingresarProducto(Productos,entradaInt, entradaStr, opcion);
                    break;
            }
        }while(opcion != 3);
    }
    public static void opcionesIngreso()
    {
        System.out.println("1<-Ingresar producto de control de plagas");
        System.out.println("2<-Ingresar producto de control de fertilizantes");
        System.out.println("3<-Salir");
    }
    private static void ingresarProducto (ArrayList<ProductoControl> Productos,Scanner entradaInt, Scanner entradaStr, int opcion)
    {
        System.out.println("\nDIGITE:\n");
        System.out.println("El registro ICA");
        int registroICA=entradaInt.nextInt();
        System.out.println("El nombre del producto");
        String nombreProducto=entradaStr.nextLine();
        System.out.println("La Frecuencia de aplicacion (En numero de dias)");
        int FrecuenciaAplicacion =entradaInt.nextInt();
        if(opcion == 1)
        {
            System.out.println("El Periodo de carencia del producto (en numero de dias)");
            int periodoCarencia=entradaInt.nextInt();
            ControlPlaga nuevoControlPlaga = new ControlPlaga(registroICA, nombreProducto, FrecuenciaAplicacion, periodoCarencia);
            Productos.add(nuevoControlPlaga);
        }else
        {
           
            System.out.println("El numero de dias desde cuando se aplico el producto (en numero de dias)");
            int ultimaAplicacion=entradaInt.nextInt();
            ControlFertilizante nuevoControlFertilizante = new ControlFertilizante(registroICA, nombreProducto, FrecuenciaAplicacion, ultimaAplicacion);
            Productos.add(nuevoControlFertilizante);
        }
    }
    public static void menuListarProductos(ArrayList<ProductoControl> Productos)
    {
        for (ProductoControl Producto : Productos) {
            if (Producto instanceof ControlPlaga)
            {
                ControlPlaga almacenaControlPlaga = (ControlPlaga) Producto;
                almacenaControlPlaga.imprimir();
            }else
            {
                ControlFertilizante almacenaControlFertilizante = (ControlFertilizante) Producto;
                almacenaControlFertilizante.imprimir();
            }
        }
    }
    public static void BuscarProducto(ArrayList<ProductoControl> Productos,Scanner entradaInt, Scanner entradaStr)
    {
        if(Productos.isEmpty())
        {
            System.out.println("No hay productos para buscar");
        }else
        {
            ProductoControl productoEncontrado = EncontrarProducto(Productos,entradaInt,entradaStr);
            if (productoEncontrado==null)
            {
                System.out.println("No se encuentra un producto con ese registro");
            }else
            {
                if (productoEncontrado instanceof ControlPlaga)
                {
                    ControlPlaga almacenaControlPlaga = (ControlPlaga) productoEncontrado;
                    almacenaControlPlaga.imprimir();
                }else
                {
                    ControlFertilizante almacenaControlFertilizante = (ControlFertilizante) productoEncontrado;
                    almacenaControlFertilizante.imprimir();
                }
            }
        }
    }
    private static ProductoControl EncontrarProducto(ArrayList<ProductoControl> Productos, Scanner entradaInt, Scanner entradaStr)
    {
        int registroICA;
        ProductoControl productoEncontrado=null;
        System.out.println("Digite el registro ICA");
        registroICA = entradaInt.nextInt();
        for (ProductoControl Producto : Productos) {
            if(Producto.getRegistroICA()==registroICA)
            {
                productoEncontrado=Producto;
            }
        }
        return productoEncontrado;
    }
    public static void ActualizarProductos(ArrayList<ProductoControl> Productos,Scanner entradaInt, Scanner entradaStr)
    {
        int opcion;
        ProductoControl productoEncontrado = EncontrarProducto(Productos, entradaInt, entradaStr);
            if (productoEncontrado==null)
            {
                System.out.println("No se encuentra un producto con ese registro");
            }else
            {
                do
                {
                   menuAtributos();
                   opcion=entradaInt.nextInt();
                   switch(opcion)
                   {
                       case 1:
                            actualizarRegistroICA(productoEncontrado,entradaInt);
                            break;
                        case 2:
                            actualizarNombre(productoEncontrado,entradaStr);
                            break;
                        case 3:
                            actualizarFrecuencia(productoEncontrado,entradaInt);
                            break;
                        case 4:
                            actualizarAtributoIndividual(productoEncontrado,entradaInt);
                            break;
                   }
                }while(opcion != 5); 
            }   
    }
    private static void actualizarRegistroICA(ProductoControl productoEncontrado, Scanner entradaInt)
    {
        System.out.println("El registro ICA");
        productoEncontrado.setRegistroICA(entradaInt.nextInt());
    }
    private static void actualizarNombre(ProductoControl productoEncontrado, Scanner entradaStr) 
    {
        System.out.println("El nombre del producto");
        productoEncontrado.setNombreProducto(entradaStr.nextLine());
    }
    private static void actualizarFrecuencia(ProductoControl productoEncontrado, Scanner entradaInt) 
    {
        System.out.println("La Frecuencia de aplicacion (En numero de dias)");
        productoEncontrado.setFrecuenciaAPlicacion(entradaInt.nextInt());
    }
    private static void actualizarAtributoIndividual(ProductoControl productoEncontrado, Scanner entradaInt)
    {
        if (productoEncontrado instanceof ControlPlaga)
                {
                    ControlPlaga almacenaControlPlaga = (ControlPlaga) productoEncontrado;
                    System.out.println("El Periodo de carencia del producto (en numero de dias)");
                    almacenaControlPlaga.setPeriodoCarencia(entradaInt.nextInt());
                }else
                {
                    ControlFertilizante almacenaControlFertilizante = (ControlFertilizante) productoEncontrado;
                    System.out.println("El Periodo de aplicacion del producto (en numero de dias)");
                    almacenaControlFertilizante.setUltimaAplicacion(entradaInt.nextInt());
                }
    }
    private static void menuAtributos(){
        System.out.println("1<- Actualizar el registroICA");
        System.out.println("2<- Actualizar el nombre");
        System.out.println("3<- Actualizar la frecuencia de aplicacion");
        System.out.println("4<- Actualizar el periodo carencia/periodo aplicacion");
        System.out.println("5<- Salir\n");
    }
    public static void EliminarProductos(ArrayList<ProductoControl> Productos,Scanner entradaInt, Scanner entradaStr)
    {
        ProductoControl productoEncontrado = EncontrarProducto(Productos, entradaInt, entradaStr);
        if (productoEncontrado==null)
        {
            System.out.println("No se encuentra un producto con ese registro");
        }else
        {
            if (Productos.remove(productoEncontrado))
            {
                System.out.println("producto eliminado");
            }else
            {
                System.out.println("No se pudo eliminar este producto");
            }
        }
    }
}
    
    
    


/*

*/