package proyectojava;

public class Rasgo implements Cloneable{
    
    
    private boolean descomposicion;
    private int agresividad;
    private int estado;
    
    //        Agresividad
    //---------------------------
    //0 No agresivo. 3 Máx nivel
    
    //          Estado
    //---------------------------
    //1 Catatonico
    //2 Dormido
    //3 Despierto
    //4 Activo
    //5 Ataque
    
    //Constructor por Defecto
    public Rasgo(){
        try{
        descomposicion = true;
        agresividad = 0;
        estado = 2;
        }
        catch(Exception X){};
    }
    //Constructor por Parametros
    public Rasgo(boolean descomposicion, int agresividad, int estado){
        try{
        this.descomposicion = descomposicion;
        if (agresividad >= 0 && agresividad <= 3) {
            this.agresividad = agresividad;
        } else{System.out.println("Agresividad introducida Incorrecta");}
        if (estado >= 1 && estado<= 5) {
            this.estado = estado;
        } else{System.out.println("Estado introducido Incorrecto");}
        }
        catch(Exception X){};
    }
    
    //Constructor de Agresividad & Estado
    public Rasgo(int agresividad, int estado){
        try{
        if (agresividad >= 0 && agresividad <= 3) {
            this.agresividad = agresividad;
        } else{System.out.println("Agresividad introducida Incorrecta");}
        if (estado >= 1 && estado<= 5) {
            this.estado = estado;
        } else{System.out.println("Estado introducido Incorrecto");}
        }
        catch(Exception X){};
    }
    //Constructor Copia
    public Rasgo(Rasgo R){
        this.descomposicion = R.descomposicion;
        this.agresividad = R.agresividad;
        this.estado = R.estado;
    }
    //Setter y Getter de DESCOMPOSICIÓN
    public void setdescomposicion(boolean descomposicion){
        try{this.descomposicion = descomposicion;}
        catch(Exception X){};
        }
    public boolean getdescomposicion(){return descomposicion;}
        
    //Setter y Getter de AGRESIVIDAD
    public boolean setagresividad(int agresividad){
       
        if (agresividad >= 0 && agresividad <= 3) {
            this.agresividad = agresividad;
            return true;
        } else{
            do {
                
                return false;          //Devuelve FALSE si sobrepasa los límite
            } while (false);}    
    }
    public int getagresividad(){return agresividad;}
    
    //Setter y Getter de ESTADO
    public boolean setestado(int estado){
        int correcion;
        if (estado >= 1 && estado<= 5) {
            this.estado = estado;
            return true;
        } else{
            do {
                
                return false;          //Devuelve FALSE si sobrepasa los límite
            } while (false);}
    }
    public int getestado(){return estado;}
        
    //Mostrar el estado en forma de texto
    public String decirestado(){
        if (estado == 1) {return "El estado es: Catatonico";}
        if (estado == 2) {return "El estado es: Dormido";}
        if (estado == 3) {return "El estado es: Despierto";}
        if (estado == 4) {return "El estado es: Activo";}
        if (estado == 5) {return "El estado es: Ataque";}
        return ""; 
    }
    //Sube el ESTADO en 1
    public void subeEstado(){
        if (this.estado >= 2 && this.estado < 5  ) {this.estado++;}
    }
    //Baja el ESTADO en 1
    public void bajaEstado(){
         if (this.estado > 2 && this.estado <= 5 ) {this.estado--;}  
    }

    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
         }catch(CloneNotSupportedException ex){}
        return obj;
    }
 
}
    