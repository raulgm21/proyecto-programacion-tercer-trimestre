package proyectojava;


public class Individuo implements Cloneable {

    
    private String nombre;
    private String codigo;
    private int año;
    
    //Constructor por Defecto
    public Individuo(){
        try{
        nombre = "Desconocido";
        codigo = "I00000";
        año = 1900;
        }catch(Exception X){};
    }
    
    //Contructor por Parámetros
    public Individuo(String nombre, String codigo, int año){
       try{
        this.nombre = nombre;
        
        if (codigo.startsWith("I") == true) {
            if (codigo.length() >= 6) {
                this.codigo = codigo;
            }else {System.out.println("Debe de tener mínimo 6 caracteres");}
        }else{System.out.println("Debe llevar al principio 'I'");}
        
        this.año = año;
       }catch(Exception X){};
    }
    
    //Constructor Copia
    public Individuo(Individuo I){
        try{
        this.nombre = I.nombre;
        this.codigo = I.codigo;
        this.año = I.año;
        }catch(Exception X){};
    }
    
    //Setter y Getter de NOMBRE
    public void setnombre(String nombre){try{this.nombre = nombre;}catch(Exception X){};}
    public String getnombre(){return this.nombre;}
    
    //Setter y Getter de CODIGO    
    public boolean setcodigo(String codigo){
        String correcion;
        if (codigo.startsWith("I") == true && codigo.length() >= 6) {
            this.codigo = codigo;
            return true;
        }else {do {return false;} 
                   while (false);}                                
    } 
    public String getcodigo(){return this.codigo;}
      
    //Setter y Getter de AÑO 
    public void setaño(int año){try{this.año = año;}catch(Exception X){};} 
    public int getaño(){return this.año;}
        
    //          toString
    public String toString(){return this.nombre + " con código: " + this.codigo + " nació en: " + this.año;}
       
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
         }catch(CloneNotSupportedException ex){}
        return obj;
    }
}
