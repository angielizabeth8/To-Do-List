
package testtask;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * @author angie_000
 */
public class Task {
    //Atributos
    private String descripcion ;
    private boolean completo;
    private Date fechaLimite;
    private Task Siguiente;
    
    SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/YYYY");
    
   //Constructores
    public Task(String descripcion, Date fechaLimite){
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completo = false;
    }
    
    public Task(){
        
    }
    
    
    //Métodos
    void cambiarEstado(){
        this.completo = !(this.completo);
    }
    
    void mostrarTarea(){ //creo que lo correco sería que vaya en main
        System.out.println("•Tarea: "+descripcion+
                "\n  Estado completo: "+(completo)+
                "\n  Fecha límite: "+dateForm.format(fechaLimite)+"\n");
    }
    
    String getDescripcion(){
        return this.descripcion;
    }
    
    void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
}
