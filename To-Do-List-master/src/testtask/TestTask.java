package testtask;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author angie_000
 */
public class TestTask {

    public static void main(String[] args) {

        String menu = ("\n1- Añadir nueva tarea\n"
                + "2- Mostrar tareas\n"
                + "3- Modificar una tarea\n"
                + "4- Sair\n");

        String menuOpciones = ("\nElija una opción:\n"
                + "1- Cambiar estado de la tarea (completa/incompleta)\n"
                + "2- Eliminar tarea\n"
                + "3- Volver al menú principal\n");

        int opcionMenu, opcionMenuOpciones, numTask;
        
        Scanner sc = new Scanner(System.in);
        Task task1 = new Task();
        
        ArrayList<Task> task; //declaración de array tipo task
        task = new ArrayList<>(); //inicializo
        
        Iterator<Task> It = task.iterator();
        

        String descripcion;
        
        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/YYYY");
        

        System.out.print("      *BIENVENIDO/A*\n");

        do {
            
            System.out.print(menu);                    
            opcionMenu = sc.nextInt();
            sc.nextLine();

            switch (opcionMenu) {

                case 1: //nueva tarea

                    Date date = new Date();
                    
                    System.out.print("Descripción: ");
                    descripcion = sc.nextLine();
                    System.out.print("Día de la fecha límite: ");
                    date.setDate(sc.nextInt());
                    System.out.print("Mes de la fecha límite (número): ");
                    date.setMonth(sc.nextInt()-1);
                    System.out.print("Año de la fecha límite: ");
                    date.setYear(sc.nextInt()-1900);
                    sc.nextLine();
                    
                    
                    task.add(new Task(descripcion, date));
                    
                    break;

                case 2:     //mostrar lista de tareas
                    if (task.isEmpty()) {
                        System.out.print("No hay tareas para ver\n");
                    } else {
                        
                        for(Task tarea: task){
                            tarea.mostrarTarea(task.indexOf(tarea)+1);
                        }
                    }

                    break;
                    
                case 3:        //realizar operaciones sobre tareas
                    
                    if(task.isEmpty()){
                        
                        System.out.print("No existen tareas\n");
                        
                    } else {
                        
                        System.out.print("Inserte el número de la tarea que desea modificar: ");
                        numTask = sc.nextInt()-1;
                        sc.nextLine();
                        
                        
                        if (task.size()<numTask+1) {
                            System.out.println("No existe la tarea nº "+(numTask+1)+"\n");
                        } else { 
                            task.get(numTask).mostrarTarea(numTask+1);
                            
                            
                            System.out.print("\n"+menuOpciones);
                            opcionMenuOpciones = sc.nextInt();
                            sc.nextLine();
                            
                            switch(opcionMenuOpciones){
                                case 1:
                                    task.get(numTask).cambiarEstado();
                                    break;
                                case 2:
                                    task.remove(numTask);
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.print("Opción incorrecta.\n");
                            }
                            
                        }
                        
                    }
                    break;
                case 4:
                    System.out.print("¡Hasta luego!\n");
                    break;
                default:
                    System.out.print("Opción incorrecta. Intente nuevamente.\n");
            }

            System.out.print("\nPresione 'enter' para continuar...");
            sc.nextLine();

        } while (opcionMenu != 4);

    }

}
