package proyectojava;

public class Zombie extends Muerto implements Cloneable {
    
    //Clientela de Rasgo
    private Rasgo ras;
    
    //Constructor por Defecto
    public Zombie(){
        super();
        ras = new Rasgo();
    }
    //Constructor por parámetros
    public Zombie(String nombre, String codigo, int año, int añofallecimiento, int agresividad, int estado){
        super(nombre,codigo,año,añofallecimiento);
        super.setcodigo('Z' + codigo + (añofallecimiento-año));
        this.ras = new Rasgo(agresividad,estado);
    }
    
    //Constructor Copia
    public Zombie(Zombie Z){
        super(Z);
        this.ras = new Rasgo(Z.ras);
    }
    
    //Setter y Getter de AGRESIVIDAD         (Clientela de Rasgo)
    public void setagresividad(int agresividad){ras.setagresividad(agresividad);}
    public int getagresividad(){return ras.getagresividad();}
    
    //Setter y Getter de ESTADO         (Clientela de Rasgo)
    public void setestado(int estado){ras.setestado(estado);}
    public int getestado(){return ras.getestado();}
    
    //Métodos de subir y bajar ESTADO   (Clientela de Rasgo)
    public void subeEstado(){ras.subeEstado();}
    public void bajaEstado(){ras.bajaEstado();}
    public String decirestado(){return ras.decirestado();}
       
    
    //Método que pasa de cualquier ESTADO a CATÁTONICO
    public boolean cambiarCatatonico(){
        if (ras.getestado() != 1) {
            ras.setestado(1);
            return true;
        } else {return false;}      //Devuelve FALSE si ya está en Catatonico
    }
    
    //Método que pasa de CATÁTONICO a cualquier ESTADO
    public boolean cambiarEstado(){
       double cambiar;
       cambiar = (int)(Math.random()*4)+2;  //Devuelve valores entre 2 y 5
        if (ras.getestado() == 1) {
            ras.setestado((int)cambiar);
            return true;
        } else {return false;}     //Devuelve FALSE si no está en Catatonico
    }
    
    @Override
    public String getcodigo(){
        return "Z - " +super.getcodigo();
    }
    
    public String codigoM(){return super.codigoM();}
    //          toString
    public String toString(){
        return super.toString() + " .La agresividad es: " + ras.getagresividad() + " ." + ras.decirestado();
    }
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
         }catch(Exception ex){}
        return obj;
    }
}
