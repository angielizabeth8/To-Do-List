
package testtask;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author angie_000
 */
public class TestTask {

    
    public static void main(String[] args) {
        
        //espacio pa cosas
        int opcionMenu, opcionMenuOpciones, totalTask=0, numTask;
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        Task task1=new Task(), task2=new Task(), task3=new Task();
        String descripcion;
        Date hoy=new Date(), date=new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/YYYY");
 
        
        System.out.print("*BIENVENIDO*\n");
        System.out.print("Hoy es "+dateForm.format(hoy)+"\n");
        
        do{
           menu.menuPrincipal();
           opcionMenu = sc.nextInt();
           sc.nextLine();
           
           switch(opcionMenu){
               
               case 1: //nueva tarea
                   if(totalTask<3){ //evalúa que haya menos de 3 tareas
                       
                       System.out.print("Descripción: ");
                       descripcion = sc.nextLine();
                       System.out.print("Día de la fecha límite: ");
                       date.setDate(sc.nextInt());
                       System.out.print("Mes de la fecha límite (número): ");
                       date.setMonth(sc.nextInt());
                       System.out.print("Día de la fecha límite: ");
                       date.setYear(sc.nextInt());
                       sc.nextLine();
                       
                       if(task1.getDescripcion()==null){ //evalua dónde almacenarla
                           task1 = new Task(descripcion,date);
                       } else if (task2.getDescripcion()==null){
                           task2 = new Task(descripcion,date);
                       } else {
                           task3 = new Task(descripcion,date);
                       }
                       totalTask++;
                       
                   } else{
                       System.out.print("No se pueden cargar más tareas.\n");
                   }
                   break;
                   
               case 2:
                  
                  if(totalTask==0){
                      System.out.print("No hay tareas para ver\n");
                  } else {
                      System.out.print("Inserte el número de la tarea que desea ver: ");
                   numTask = sc.nextInt();
                   sc.nextLine();
                   
                   switch(numTask){ //con un arreglo Task me ahorraría esto, hay muchas repeticiones de código
                       case 1:
                           
                           if(task1.getDescripcion().isEmpty()){ //evalua si existe
                               System.out.print("No existe la tarea nº "+numTask+"\n");
                           } else {
                               task1.mostrarTarea();
                               System.out.print("Presione 'enter' para continuar...");
                               sc.nextLine();
                               
                               menu.menuOpciones();
                               opcionMenuOpciones = sc.nextInt();
                               while(opcionMenuOpciones<1 || opcionMenuOpciones>3){
                                   System.out.print("Incorrecto. Inserte una opción nuevamente: ");
                                   opcionMenuOpciones = sc.nextInt();
                               }
                               sc.nextLine();
                               
                               if(opcionMenuOpciones==1){
                                   task1.cambiarEstado();
                                   task1.mostrarTarea();
                               } else if(opcionMenuOpciones==2){
                                   System.out.print("Se eliminó la tarea '"+task1.getDescripcion()+"'\n");
                                   task1 = new Task();
                                   totalTask--;
                               }
                           }
                           
                           break;
                       case 2:
                           
                           if(task2.getDescripcion().isEmpty()){
                               System.out.print("No existe la tarea nº "+numTask+"\n");
                           } else {
                               task2.mostrarTarea();
                               System.out.print("Presione 'enter' para continuar...");
                               sc.nextLine();
                               
                               menu.menuOpciones();
                               opcionMenuOpciones = sc.nextInt();
                               while(opcionMenuOpciones<1 || opcionMenuOpciones>3){
                                   System.out.print("Incorrecto. Inserte una opción nuevamente: ");
                                   opcionMenuOpciones = sc.nextInt();
                               }
                               sc.nextLine();
                               
                               if(opcionMenuOpciones==1){
                                   task2.cambiarEstado();
                                   task2.mostrarTarea();
                               } else if(opcionMenuOpciones==2){
                                   System.out.print("Se eliminó la tarea '"+task2.getDescripcion()+"'\n");
                                   task2 = new Task();
                                   totalTask--;
                               }
                           }
                           
                           break;
                       case 3:
                           
                           if(task3.getDescripcion().isEmpty()){
                               System.out.print("No existe la tarea nº "+numTask+"\n");
                           } else {
                               task3.mostrarTarea();
                               System.out.print("Presione 'enter' para continuar...");
                               sc.nextLine();
                               
                               menu.menuOpciones();
                               opcionMenuOpciones = sc.nextInt();
                               while(opcionMenuOpciones<1 || opcionMenuOpciones>3){
                                   System.out.print("Incorrecto. Inserte una opción nuevamente: ");
                                   opcionMenuOpciones = sc.nextInt();
                               }
                               sc.nextLine();
                               
                               if(opcionMenuOpciones==1){
                                   task3.cambiarEstado();
                                   task3.mostrarTarea();
                               } else if(opcionMenuOpciones==2){
                                   System.out.print("Se eliminó la tarea '"+task3.getDescripcion()+"'\n");
                                   task3 = new Task();
                                   totalTask--;
                               }
                           }
                           
                           break;
                       default:
                           System.out.print("No existe la tarea nº "+numTask+"\n");
                           
                   }
                  }
             
                   break;
               case 3:
                   System.out.print("Hasta luego!\n");
                   break;
               default:
                   System.out.print("Opción incorrecta. Intente nuevamente.\n");
           }
            
           System.out.print("Presione 'enter' para continuar...");
           sc.nextLine();
            
        }while(opcionMenu!=3);
        
    }
    
}
