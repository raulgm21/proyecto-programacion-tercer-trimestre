
package proyectojava;

public class Noble extends Individuo implements Cloneable {
    
    private String titulo;      //Rey o Duque
    
    //Constructor por Defecto
    public Noble(){
        super();
        titulo = "";
    }
    
    //Constructor por Parámetros
    public Noble(String nombre, String codigo, int año, String titulo){
        super(nombre,codigo,año);
                //PASA EL TÍTULO EN MAYÚSCULAS
        String Sensitive = titulo.toUpperCase();      
        if (Sensitive.equals("REY") || Sensitive.equals("DUQUE")) {
                //DEVUELVE EL TÍTULO EN MAYÚSCULAS
            this.titulo = titulo.toUpperCase();
        } else {System.out.println("**Título Incorrecto");}
    }
    
    //Constructor Copia
    public Noble(Noble N){
        super(N);
        this.titulo=N.gettitulo();
    }
    
    //Setter y Getter de TITULO
    public boolean settitulo(String titulo){
        
                //PASA EL TÍTULO EN MAYÚSCULAS
        String Sensitive = titulo.toUpperCase();      
        if (Sensitive.equals("REY") || Sensitive.equals("DUQUE")) {
                //DEVUELVE EL TÍTULO EN MAYÚSCULAS
            this.titulo = titulo.toUpperCase();
            return true;
        } else {do {return false;}       
                   while (false);}         
    }     

    public String gettitulo(){return this.titulo;}
    
    //          toString
    public String toString(){
        return super.toString() + ", cuyo título es: " + this.titulo;
    }
    
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
         }catch(Exception ex){}
        return obj;
    }
}
