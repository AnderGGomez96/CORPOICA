/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ghost
 */
public class CRUD {
    //Atributos
    
    //Metodos
    public static void menuIngresoProductos(ArrayList<ControlPlaga> ControlPlagas,ArrayList<ControlFertilizante> ControlFertilizantes,Scanner entradaInt, Scanner entradaStr)
    {
        int opcion;
        do
        {
            opcionesIngreso();
            opcion=entradaInt.nextInt();
            switch (opcion)
            {
                case 1:
                    ingresarControlPlagas(ControlPlagas,entradaInt, entradaStr);
                    break;
                case 2:
                    ingresarControlFertilizantes(ControlFertilizantes,entradaInt, entradaStr);
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

    private static void ingresarControlPlagas(ArrayList<ControlPlaga> ControlPlagas,Scanner entradaInt, Scanner entradaStr) {
        ControlPlaga nuevoControlPlaga = new ControlPlaga();
        System.out.println("\nDIGITE:\n");
        System.out.println("El registro ICA");
        nuevoControlPlaga.setRegistroICA(entradaInt.nextInt());
        System.out.println("El nombre del producto");
        nuevoControlPlaga.setNombreProducto(entradaStr.nextLine());
        System.out.println("La Frecuencia de aplicacion (En numero de dias)");
        nuevoControlPlaga.setFrecuenciaAPlicacion(entradaInt.nextInt());
        System.out.println("El Periodo de carencia del producto (en numero de dias)");
        nuevoControlPlaga.setPeriodoCarencia(entradaInt.nextInt());
        ControlPlagas.add(nuevoControlPlaga);
        
    }

    private static void ingresarControlFertilizantes(ArrayList<ControlFertilizante> ControlFertilizantes,Scanner entradaInt, Scanner entradaStr) {
        ControlFertilizante nuevoControlFertilizante = new ControlFertilizante();
        System.out.println("\nDIGITE:\n");
        System.out.println("El registro ICA");
        nuevoControlFertilizante.setRegistroICA(entradaInt.nextInt());
        System.out.println("El nombre del producto");
        nuevoControlFertilizante.setNombreProducto(entradaStr.nextLine());
        System.out.println("La Frecuencia de aplicacion (En numero de dias)");
        nuevoControlFertilizante.setFrecuenciaAPlicacion(entradaInt.nextInt());
        System.out.println("El numero de dias desde cuando se aplico el producto (en numero de dias)");
        nuevoControlFertilizante.setUltimaAplicacion(entradaInt.nextInt());
        ControlFertilizantes.add(nuevoControlFertilizante);
    }
    
    public static void menuListarProductos(ArrayList<ControlPlaga> ControlPlagas,ArrayList<ControlFertilizante> ControlFertilizantes,Scanner entradaInt, Scanner entradaStr)
    {
        int opcion;
        do
        {
            opcionesListado();
            opcion=entradaInt.nextInt();
            switch(opcion)
            {
                case 1:
                    listarControlPlagas(ControlPlagas,entradaInt, entradaStr);
                    break;
                case 2:
                    listarControlFertilizante(ControlFertilizantes,entradaInt, entradaStr);
                    break;
            }
        }while(opcion != 3);
        
    }
    
    private static void opcionesListado()
    {
        System.out.println("1<- Liste los productos de control de plagas");
        System.out.println("2<- Liste los productos de control fertilizantes");
        System.out.println("3<- Salir");
    }

    private static void listarControlPlagas(ArrayList<ControlPlaga> ControlPlagas, Scanner entradaInt, Scanner entradaStr) {
        for (ControlPlaga ControlPlaga1 : ControlPlagas) {
            ControlPlaga1.imprimir();
        }
    }

    private static void listarControlFertilizante(ArrayList<ControlFertilizante> ControlFertilizantes, Scanner entradaInt, Scanner entradaStr) {
        for (ControlFertilizante ControlFertilizante1 : ControlFertilizantes) {
            ControlFertilizante1.imprimir();
        }
    }
    
    public static void MenuBuscarProductos(ArrayList<ControlPlaga> ControlPlagas,ArrayList<ControlFertilizante> ControlFertilizantes,Scanner entradaInt, Scanner entradaStr)
    {
        int opcion;
        do
        {
           opcionesBusqueda();
           opcion=entradaInt.nextInt();
           switch(opcion)
           {
               case 1:
                    BuscarControlPlagas(ControlPlagas,entradaInt, entradaStr);
                    break;
                case 2:
                    BuscarControlFertilizante(ControlFertilizantes,entradaInt, entradaStr);
                    break;
           }
        }while(opcion != 3);
    }
    
    private static void opcionesBusqueda()
    {
        System.out.println("1<-Buscar producto de control de plagas");
        System.out.println("2<-Buscar producto de control fertilizantes");
        System.out.println("3<- Salir");
    }

    private static void BuscarControlPlagas(ArrayList<ControlPlaga> ControlPlagas, Scanner entradaInt, Scanner entradaStr) {
        if(ControlPlagas.isEmpty())
        {
            System.out.println("No hay productos para buscar");
        }else
        {
            ControlPlaga productoEncontrado = buscarPlaga(ControlPlagas,entradaInt,entradaStr);
            if (productoEncontrado==null)
            {
                System.out.println("Este producto no se encuentra en control de plagas");
            }else
            {
                productoEncontrado.imprimir();
            }
        }
    }

    private static void BuscarControlFertilizante(ArrayList<ControlFertilizante> ControlFertilizantes, Scanner entradaInt, Scanner entradaStr) {
        if(ControlFertilizantes.isEmpty())
        {
            System.out.println("No hay productos para buscar");
        }else
        {
            ControlFertilizante productoEncontrado = buscarFertilizante(ControlFertilizantes,entradaInt,entradaStr);
            if (productoEncontrado==null)
            {
                System.out.println("Este producto no se encuentra en control de fertilizante");
            }else
            {
                productoEncontrado.imprimir();
            }
        }
    }

    private static ControlPlaga buscarPlaga(ArrayList<ControlPlaga> ControlPlagas, Scanner entradaInt, Scanner entradaStr) {
        int indice =0;
        int registroICA;
        System.out.println("Digite el registro ICA");
        registroICA = entradaInt.nextInt();
        while ((ControlPlagas.get(indice).getRegistroICA() != registroICA)&&(indice < ControlPlagas.size()))
        {
            indice ++;
        }
        if (indice == ControlPlagas.size())
        {
            return null;
        }else
        {
            return ControlPlagas.get(indice);
        }
        
    }

    private static ControlFertilizante buscarFertilizante(ArrayList<ControlFertilizante> ControlFertilizantes, Scanner entradaInt, Scanner entradaStr) {
        int indice =0;
        int registroICA;
        System.out.println("Digite el registro ICA");
        registroICA = entradaInt.nextInt();
        while ((ControlFertilizantes.get(indice).getRegistroICA() != registroICA)&&(indice < ControlFertilizantes.size()))
        {
            indice ++;
        }
        if (indice == ControlFertilizantes.size())
        {
            return null;
        }else
        {
            return ControlFertilizantes.get(indice);
        }
    }
    
    public static void ActualizarProductos(ArrayList<ControlPlaga> ControlPlagas,ArrayList<ControlFertilizante> ControlFertilizantes,Scanner entradaInt, Scanner entradaStr)
    {
        int opcion;
        do
        {
           opcionesActualizacion();
           opcion=entradaInt.nextInt();
           switch(opcion)
           {
               case 1:
                    ActualizarControlPlagas(ControlPlagas,entradaInt, entradaStr);
                    break;
                case 2:
                    ActualizarControlFertilizante(ControlFertilizantes,entradaInt, entradaStr);
                    break;
           }
        }while(opcion != 3);       
    }

    private static void opcionesActualizacion() {
        System.out.println("1<-Actualizar producto de control de plagas");
        System.out.println("2<-Actualizar producto de control fertilizantes");
        System.out.println("3<- Salir");       
    }

    private static void ActualizarControlPlagas(ArrayList<ControlPlaga> ControlPlagas, Scanner entradaInt, Scanner entradaStr) {
        if(ControlPlagas.isEmpty())
        {
            System.out.println("No hay productos para buscar");
        }else
        {
            ControlPlaga productoEncontrado = buscarPlaga(ControlPlagas,entradaInt,entradaStr);
            if (productoEncontrado==null)
            {
                System.out.println("Este producto no se encuentra en control de plaga");
            }else
            {
                int opcion;
                do
                {
                    menuAtributos();
                    opcion=entradaInt.nextInt();
                    switch(opcion)
                    {
                        case 1:
                            actualizarRegistroICA1(productoEncontrado, entradaInt, entradaStr);
                            break;
                        case 2:
                            actualizarNombre1(productoEncontrado, entradaInt,  entradaStr);
                            break;
                        case 3:
                            actualizarFrecuencia1(productoEncontrado, entradaInt,  entradaStr);
                            break;
                        case 4:
                            actualizarCarencia1(productoEncontrado, entradaInt,  entradaStr);
                            break;
                    }
                }while(opcion != 5);
            }
        }
    }

    private static void menuAtributos() {
        System.out.println("1<- Actualizar el registroICA");
        System.out.println("2<- Actualizar el nombre");
        System.out.println("3<- Actualizar la frecuencia de aplicacion");
        System.out.println("4<- Actualizar el periodo carencia");
        System.out.println("5<- Salir\n");
    }

    private static void actualizarRegistroICA1(ControlPlaga productoEncontrado, Scanner entradaInt, Scanner entradaStr) {
        System.out.println("El registro ICA");
        productoEncontrado.setRegistroICA(entradaInt.nextInt());
    }

    private static void actualizarNombre1(ControlPlaga productoEncontrado, Scanner entradaInt, Scanner entradaStr) {
        System.out.println("El nombre del producto");
        productoEncontrado.setNombreProducto(entradaStr.nextLine());
    }

    private static void actualizarFrecuencia1(ControlPlaga productoEncontrado, Scanner entradaInt, Scanner entradaStr) {
        System.out.println("La Frecuencia de aplicacion (En numero de dias)");
        productoEncontrado.setFrecuenciaAPlicacion(entradaInt.nextInt());
    }

    private static void actualizarCarencia1(ControlPlaga productoEncontrado, Scanner entradaInt, Scanner entradaStr) {
        System.out.println("El Periodo de carencia del producto (en numero de dias)");
        productoEncontrado.setPeriodoCarencia(entradaInt.nextInt());
    }
    
    private static void ActualizarControlFertilizante(ArrayList<ControlFertilizante> ControlFertilizantes, Scanner entradaInt, Scanner entradaStr) 
    {
        if(ControlFertilizantes.isEmpty())
        {
            System.out.println("No hay productos para buscar");
        }else
        {
            ControlFertilizante productoEncontrado = buscarFertilizante(ControlFertilizantes,entradaInt,entradaStr);
            if (productoEncontrado==null)
            {
                System.out.println("Este producto no se encuentra en control de plaga");
            }else
            {
                int opcion;
                do
                {
                    menuAtributos();
                    opcion=entradaInt.nextInt();
                    switch(opcion)
                    {
                        case 1:
                            actualizarRegistroICA(productoEncontrado, entradaInt, entradaStr);
                            break;
                        case 2:
                            actualizarNombre(productoEncontrado, entradaInt,  entradaStr);
                            break;
                        case 3:
                            actualizarFrecuencia(productoEncontrado, entradaInt,  entradaStr);
                            break;
                        case 4:
                            actualizarAplicacion(productoEncontrado, entradaInt,  entradaStr);
                            break;
                    }
                }while(opcion != 5);
            }
        }
    }
    
    private static void actualizarRegistroICA(ControlFertilizante productoEncontrado, Scanner entradaInt, Scanner entradaStr) {
        System.out.println("El registro ICA");
        productoEncontrado.setRegistroICA(entradaInt.nextInt());
    }

    private static void actualizarNombre(ControlFertilizante productoEncontrado, Scanner entradaInt, Scanner entradaStr) {
        System.out.println("El nombre del producto");
        productoEncontrado.setNombreProducto(entradaStr.nextLine());
    }

    private static void actualizarFrecuencia(ControlFertilizante productoEncontrado, Scanner entradaInt, Scanner entradaStr) {
        System.out.println("La Frecuencia de aplicacion (En numero de dias)");
        productoEncontrado.setFrecuenciaAPlicacion(entradaInt.nextInt());
    }

    private static void actualizarAplicacion(ControlFertilizante productoEncontrado, Scanner entradaInt, Scanner entradaStr) {
        System.out.println("El Periodo de carencia del producto (en numero de dias)");
        productoEncontrado.setUltimaAplicacion(entradaInt.nextInt());
    }
    
    
    public static void EliminarProductos(ArrayList<ControlPlaga> ControlPlagas,ArrayList<ControlFertilizante> ControlFertilizantes,Scanner entradaInt, Scanner entradaStr)
    {
        int opcion;
        do
        {
           opcionesEliminacion();
           opcion=entradaInt.nextInt();
           switch(opcion)
           {
               case 1:
                    EliminarControlPlagas(ControlPlagas,entradaInt, entradaStr);
                    break;
                case 2:
                    EliminarControlFertilizante(ControlFertilizantes,entradaInt, entradaStr);
                    break;
           }
        }while(opcion != 3);       
    }
    
    private static void opcionesEliminacion() {
        System.out.println("1<-Actualizar producto de control de plagas");
        System.out.println("2<-Actualizar producto de control fertilizantes");
        System.out.println("3<- Salir");       
    }
    
    public static void EliminarControlPlagas(ArrayList<ControlPlaga> ControlPlagas,Scanner entradaInt, Scanner entradaStr)
    {
        if(ControlPlagas.isEmpty())
        {
            System.out.println("No hay productos para eliminar");
        }else
        {
            ControlPlaga productoEncontrado = buscarPlaga(ControlPlagas,entradaInt,entradaStr);
            if (productoEncontrado==null)
            {
                System.out.println("Este producto no se encuentra en control de plaga");
            }else
            {
                if (ControlPlagas.remove(productoEncontrado))
                {
                    System.out.println("producto eliminado");
                }else
                {
                    System.out.println("No se pudo eliminar este producto");
                }
            }
        }
    }
    
    public static void EliminarControlFertilizante(ArrayList<ControlFertilizante> ControlFertilizantes,Scanner entradaInt, Scanner entradaStr)
    {
        if(ControlFertilizantes.isEmpty())
        {
            System.out.println("No hay productos para eliminar");
        }else
        {
            ControlFertilizante productoEncontrado = buscarFertilizante(ControlFertilizantes,entradaInt,entradaStr);
            if (productoEncontrado==null)
            {
                System.out.println("Este producto no se encuentra en control de fertilizante");
            }else
            {
                if (ControlFertilizantes.remove(productoEncontrado))
                {
                    System.out.println("producto eliminado");
                }else
                {
                    System.out.println("No se pudo eliminar este producto");
                }
            }
        }
    }
}


/*

*/