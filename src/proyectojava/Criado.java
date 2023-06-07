package proyectojava;

public class Criado extends Individuo implements Cloneable {
    
    //Clientela de la clase NOBLE
    private Noble nob;
    
    //Constructor por defecto
    public Criado(){
        super();
        nob = null;
    }
    //Constructor por parámetros
    public Criado(String nombre,String codigo, int año, Noble nob){
        super(nombre,codigo,año);   
        this.nob = nob;
    }
    //Constructor Copia
    public Criado(Criado C){
        super(C);
        this.nob = C.nob;
    }
    //Setter y Getter de NOBLE (Asignar y Mostrar NOBLES)
    public void setnoble(Noble N){try{nob = N;}catch(Exception X){};}
    public String getnoble(){return nob.getcodigo();}

    //          toString
    @Override
    public String toString(){
        if (nob == null) {      
            return super.toString() + " no sirve a nadie";
        }else{return super.toString() + " quien sirve a: " +  nob.toString();}
        
    }
    
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
         }catch(Exception ex){}
        return obj;
    }
}
