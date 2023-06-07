package proyectojava;


public class Muerto extends Individuo implements Cloneable{

    private int añofallecimiento;
    
    //Constructor por Defecto
    public Muerto(){
        super();
        this.añofallecimiento = 5000;
    }
    //Constructor por parámetros
    public Muerto(String nombre, String codigo, int año, int añofallecimiento){
        super(nombre,codigo,año);
        if (año < añofallecimiento) {
            this.añofallecimiento = añofallecimiento;
        }else {System.out.println("Año fallecimiento no puede ser menor");}
    }
    //Constructor Copia
    public Muerto(Muerto M){
        super(M);
        this.añofallecimiento=M.getañofallecimiento();
    }
    
    //Setter y Getter de AÑO DE FALLECIMIENTO
    public boolean setañofallecimiento(int añofallecimiento){
        try{
        int correcion;
        if (super.getaño() < añofallecimiento) {
            this.añofallecimiento = añofallecimiento;
            return true;
        }else {
            do {
                
                return false;
            } while (false);}
        }catch(Exception X){};
        return false;
    }
    public int getañofallecimiento(){return this.añofallecimiento;}

    @Override
    public String getcodigo(){
        int diferencia = añofallecimiento-super.getaño();
        return super.getcodigo()+" - "+diferencia;
    }
    
    public String codigoM(){return super.getcodigo();}

    //          toString
    public String toString(){
        return super.getnombre() + " con codigo: " + getcodigo() + " nació en: " + super.getaño() + 
                                " y murió en: " + añofallecimiento;
    }
    
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
         }catch(Exception ex){}
        return obj;
    }
}
