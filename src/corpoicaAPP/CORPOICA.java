/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corpoicaAPP;
//import Modelo;

import Modelo.CRUD;
import java.util.ArrayList;
import java.util.Scanner;
import Modelo.*;
/**
 *
 * @author ghost
 */
public class CORPOICA {

    /**
     * @param args the command line arguments
     */
    
    public static void menu ()
    {
        System.out.println("1<- Ingresar productos de control");
        System.out.println("2<- Listar productos de control");
        System.out.println("3<- Buscar productos de control");
        System.out.println("4<- Actualizar productos de control");
        System.out.println("5<- Eliminar productos de control");
        System.out.println("6<- SALIR");
    }
    
    public static void main(String[] args) {
        Scanner entradaInt=  new Scanner(System.in);
        Scanner entradaStr=  new Scanner(System.in);
        ArrayList<ControlPlaga> ControlPlagas = new ArrayList<>();
        ArrayList<ControlFertilizante> ControlFertilizantes = new ArrayList<>();
        
        int opcion;
        
        do
        {
            menu();
            opcion = entradaInt.nextInt();
            switch(opcion)
            {
                case 1:
                    CRUD.menuIngresoProductos(ControlPlagas,ControlFertilizantes,entradaInt, entradaStr);
                    break;
                case 2:
                    CRUD.menuListarProductos(ControlPlagas, ControlFertilizantes, entradaInt, entradaStr);
                    break;
                case 3:
                    CRUD.MenuBuscarProductos(ControlPlagas, ControlFertilizantes, entradaInt, entradaStr);
                    break;
                case 4:
                    CRUD.ActualizarProductos(ControlPlagas, ControlFertilizantes, entradaInt, entradaStr);
                    break;
                case 5:
                    CRUD.EliminarProductos(ControlPlagas, ControlFertilizantes, entradaInt, entradaStr);
                    break;
            }
        }while(opcion != 6);
    }
    
}
