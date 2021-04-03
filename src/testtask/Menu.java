/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtask;

/**
 *
 * @author angie_000
 */
public class Menu {
    
    public Menu(){
        
    }
    
    void menuPrincipal(){
        System.out.print("1- Añadir nueva tarea\n"+
                "2- Mostrar una tarea y realizar operaciones\n"+
                "3- Sair\n");
    }
    
    void menuOpciones(){
        System.out.print("\nElija una opción:\n"+
                "1- Cambiar estado de la tarea (completa/incompleta)\n"+
                "2- Eliminar tarea\n"+
                "3- Volver al menú principal\n");
    }
    
}
