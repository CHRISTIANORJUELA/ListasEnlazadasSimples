package service;

import Interfaces.Menu;
import com.sun.jdi.VoidType;
import com.sun.jdi.VoidValue;
import model.Nodo;

import javax.swing.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListaEnlazadaSimple implements Menu {
    private Nodo cab = null;
    private Nodo movil = null;
    public ListaEnlazadaSimple(){}

    public void agregarEmpresa(){
        String name = JOptionPane.showInputDialog("Ingresa un Nombre de empresa");
        Integer money = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de capital de la empresa"));
        String country = JOptionPane.showInputDialog("Ingresa el pais donde tiene sede la empresa");
        Integer employees = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de empleados de la empresa"));
        Nodo nodo = new Nodo(name,money,country,employees);
        nodo.sig = cab;
        cab = nodo;
        /*
        String name = JOptionPane.showInputDialog("Ingresa un Nombre de empresa");
        Integer money = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de capital de la empresa"));
        String country = JOptionPane.showInputDialog("Ingresa el pais donde tiene sede la empresa");
        Integer employees = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de empleados de la empresa"));
        Nodo nodo = new Nodo(name,money,country,employees);
        if (cab==null){
            cab = nodo;
            System.out.println(cab);
        }else {
            movil = cab;
            while (movil.getSig()!=null){
                movil = movil.getSig();
            }
            movil.setSig(nodo);
        }

         */
    }


    public void empresaConMasDinero(){
       movil = cab;
       List<Nodo> listNodo = new LinkedList<>();
       while (movil!=null){
           listNodo.add(movil);
           movil = movil.sig;
       }
       Nodo nodo = listNodo.stream()
               .max(Comparator.comparing(Nodo::getMoney))
               .orElseThrow();
       System.out.println("El nodo mayores ganancias : "+nodo);
    }

    public void empresaConMenosDinero(){
      movil = cab;
      List<Nodo> nodoList = new LinkedList<>();
      while (movil!=null){
          nodoList.add(movil);
          movil = movil.sig;
      }
      Nodo nodo = nodoList
              .stream()
              .min(Comparator.comparing(Nodo::getMoney))
              .orElseThrow();
        System.out.println("*".repeat(10));
        System.out.println("El nodo con menores ganancias "+nodo);
        System.out.println("*".repeat(10));
    }

    public void actualizarCamposDeEmpresa(){
        movil = cab;
        String key = JOptionPane.showInputDialog("Ingrese el nombre de la empresa");
        while (movil!=null){
            if (movil.name.equalsIgnoreCase(key)){
                String name = JOptionPane.showInputDialog("Nombre de la empresa para cambiar");
                if (!name.isEmpty()){
                    movil.name = name;
                }
                String money = JOptionPane.showInputDialog("Capital financiero de la empresa a cambiar");
                if (!money.isEmpty()){
                    movil.money = Integer.parseInt(money);
                }
                String country = JOptionPane.showInputDialog("Pais de la empresa a cambiar");
                if (!country.isEmpty()){
                    movil.country = country;
                }
                String employees = JOptionPane.showInputDialog("Cantidad de empleados a cambiar");
                if(!employees.isEmpty()){
                    movil.employees = Integer.parseInt(employees);
                }
                System.out.println("Actualización realizada con exito");
                break;
            }
            movil = movil.sig;
        }
    }

    public void imprimirLista(){
      movil = cab;
      System.out.println("-".repeat(10));
      while ((movil)!=null){
          System.out.println("Información de la empresa");
          System.out.println("Nombre :"+movil.name);
          System.out.println("Capital financiero :"+movil.money);
          System.out.println("Pais :"+movil.country);
          System.out.println("Empleados :"+movil.employees);
          movil = movil.sig;
          System.out.println("*".repeat(10));
          System.out.println("*".repeat(10));
      }
    }
}
