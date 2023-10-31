import Dictionary.DictFunc;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
       DictFunc dictFunc = new DictFunc();
       String option;
        while (true){
           option = JOptionPane.showInputDialog("1.Agregar una empresa \n 2.Empresa con mayor capital \n 3.Empresa con Menor capital \n 4.Actualizar Datos \n 5. Imprimir Lista \n 6.Salir");
           if (option.equalsIgnoreCase("6")){
               break;
           }
           dictFunc.KeyMenuMap(Integer.parseInt(option));
       }
    }
}