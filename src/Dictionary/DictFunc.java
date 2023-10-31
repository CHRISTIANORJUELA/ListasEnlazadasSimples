package Dictionary;

import Interfaces.FuntionalVoid;
import Interfaces.Menu;
import service.ListaEnlazadaSimple;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DictFunc {

    private ListaEnlazadaSimple listaEnlazadaSimple = new ListaEnlazadaSimple();
    private final Map<Integer, FuntionalVoid> menuMap = new HashMap<>();

    public void KeyMenuMap(Integer key){
        if (menuMap.size()==0){
            menuMap.put(1,()-> listaEnlazadaSimple.agregarEmpresa());
            menuMap.put(2,()-> listaEnlazadaSimple.empresaConMasDinero());
            menuMap.put(3,()-> listaEnlazadaSimple.empresaConMenosDinero());
            menuMap.put(4,()-> listaEnlazadaSimple.actualizarCamposDeEmpresa());
            menuMap.put(5,()-> listaEnlazadaSimple.imprimirLista());
        }
        Optional.ofNullable(menuMap.get(key))
                .ifPresentOrElse(FuntionalVoid::implementation,
                 ()-> System.out.println("Element not exists"));
    }
}
