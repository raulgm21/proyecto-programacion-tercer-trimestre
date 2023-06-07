package proyectojava;
import java.util.*;
public class Sociedad implements Cloneable {
    
    private String localizacion;
    private ArrayList ASociedad;                        //Sociedad de Individuos
    private ArrayList ANoble = new ArrayList();         //ArrayList copia para los Nobles
    private ArrayList ACriado = new ArrayList();        //ArrayList copia para los Criados
    private ArrayList AMuerto = new ArrayList();        //ArrayList copia para los Muertos
    private ArrayList AZombie = new ArrayList();        //ArrayList copia para los Zombie
    
    private int añoactual;
    //Constructor por Defecto
    public Sociedad(){
        localizacion = "Sociedad BlackCity";
        ASociedad = new ArrayList();
        añoactual = 2022;
    
    }
    //Constructor por Parámetros
    public Sociedad(String localizacion){
        this.localizacion = localizacion;
        ASociedad = new ArrayList();
        this.añoactual = añoactual;
    }
    //Constructor Copia
    public Sociedad(Sociedad S){
        this.localizacion = S.localizacion;
        ASociedad = new ArrayList();
        this.añoactual = S.añoactual;
    }   
    //Setter y Getter de LOCALIZACION 
    public void setlocalizacion(String localizacion){this.localizacion = localizacion;}
    public String getlocalizacion(){return localizacion;}  
    //Setter y Getter de AÑOACTUAL
    public void setañoactual(int añoactual){this.añoactual = añoactual;}
    public int getañoactual(){return añoactual;}
    //Suma un año más
    public void sumarañoactual(){this.añoactual++;}
    
    public void paqueteResidentes(){
        Individuo I = new Individuo("Raul","I00001",2003);
        Noble N1 = new Noble("Pepe","I00002",2003,"REY");
        Noble N2 = new Noble("Luis","I00003",2003,"DUQUE");
        Noble N3 = new Noble("Erick","I00004",2003,"DUQUE");
        Criado C1 = new Criado("Javier","I00005",2003,N1);
        Criado C2 = new Criado("Omar","I00006",2003,N1);
        Criado C3 = new Criado("Pol","I00007",2003,N2);
        Muerto M1 = new Muerto("Uxio","I00008",2003,2100);
        Muerto M2 = new Muerto("Borja","I00009",2003,2100);
        Muerto M3 = new Muerto("Joan","I00010",2003,2100);
        Zombie Z1 = new Zombie("Zombie1","I0000069",2000,2100,3,5);
        Zombie Z2 = new Zombie("Zombie2","I0000070",2000,2100,2,4);
        Zombie Z3 = new Zombie("Zombie3","I0000071",2000,2100,2,3);
        Zombie Z4 = new Zombie("Zombie4","I0000072",2000,2100,1,3);
        Zombie Z5 = new Zombie("Zombie5","I0000073",2000,2100,1,1);
        Zombie Z6 = new Zombie("Zombie6","I0000074",2000,2100,2,1);
        ASociedad.add(I);
        ASociedad.add(N1);ASociedad.add(N2);ASociedad.add(N3);
        ASociedad.add(C1);ASociedad.add(C2);ASociedad.add(C3);
        ASociedad.add(M1);ASociedad.add(M2);ASociedad.add(M3);
        ASociedad.add(Z1);ASociedad.add(Z2);ASociedad.add(Z3);
        ASociedad.add(Z4);ASociedad.add(Z5);ASociedad.add(Z6);
        
        ANoble.add(N1); ANoble.add(N2); ANoble.add(N3);
        
        ACriado.add(C1);ACriado.add(C2);ACriado.add(C3);
        
        AMuerto.add(M1);AMuerto.add(M2);AMuerto.add(M3);
        
        AZombie.add(Z1);AZombie.add(Z2);AZombie.add(Z3);
        AZombie.add(Z4);AZombie.add(Z5);AZombie.add(Z6);
    }
    //I. Admitir nuevos Reisdentes (COMPROBAR QUE NO HAYAN REPETIDOS)
    public boolean comprobarCodigo(String codigo){
        Individuo I = new Individuo();
        Muerto M = new Muerto();
        Zombie Z = new Zombie();
        for (int i = 0; i < ASociedad.size(); i++) {
            I = (Individuo)ASociedad.get(i);
            if (I.getcodigo().equals(codigo)) {return true;}
            
        }
        for (int i = 0; i < AMuerto.size(); i++) {
           M = (Muerto)AMuerto.get(i);
            if (M.codigoM().equals(codigo)) {return true;} 
        }
        
        for (int i = 0; i < AZombie.size(); i++) {
           Z = (Zombie)AZombie.get(i);
            if (Z.codigoM().equals(codigo)) {return true;} 
        }
      return false;  
    }
    
    //I. Admitir nuevos Residentes (INDIVIDUOS)
    public boolean admitirIndividuo(String nombre, String codigo, int año){
        Individuo I = new Individuo(); 
        I.setnombre(nombre);
        I.setcodigo(codigo);
        I.setaño(año);
        if (comprobarCodigo(codigo) == true) {
            return false;
        }
        if (I.setcodigo(codigo) == false) {
            return false;
        }else{if (añoactual < I.getaño()) {
            return false;
        }else{ASociedad.add(I);return true;}
            
        }
     
    }
    
    //I. Admitir nuevos Residentes (NOBLE)
    public boolean admitirNoble(String nombre, String codigo, int año, String titulo){
        Noble N = new Noble();
        N.setnombre(nombre);
        N.setcodigo(codigo);
        N.setaño(año);
        N.settitulo(titulo);
        
        if (comprobarCodigo(codigo) == true) {
            return false;
        }
        if (N.setcodigo(codigo) == false) {
            return false;
        }else{if (N.settitulo(titulo) == false) {
            return false; 
        }else{if (añoactual < N.getaño()) {
            return false;
        }else{ASociedad.add(N);ANoble.add(N);return true;}
        }
        }
    }                                                  
    //I. Admitir nuevos Residentes (CRIADOS)  
    public boolean admitirCriado(String nombre, String codigo, int año, String codigonoble){
        Criado C = new Criado();
        Noble N = new Noble();
        C.setnombre(nombre);
        C.setcodigo(codigo);
        C.setaño(año);
        //SI HAY NOBLES
        if (ANoble.size() != 0) {
           for (int i = 0; i < ANoble.size(); i++) {
            N = (Noble)ANoble.get(i);
            if (N.getcodigo().equals(codigonoble)) {C.setnoble(N);} 
        }
        if (comprobarCodigo(codigo) == true) {
        return false;       //Manda FALSE si hay uno repetido
        }
        if (C.setcodigo(codigo) == false) {
            return false;   //Manda FALSE si esta mal es código
        }else{if (!C.getnoble().equals(codigonoble)) {
            return false;   //Manda FALSE si esta mal el NOBLE    
        }else{if (añoactual < C.getaño()) {
             return false;
        }else{ASociedad.add(C); ACriado.add(C); return true;}
        }
        }
    //SI NO HAY NOBLES 
    }else{System.out.println("Debe existir un noble"); return false;}
 
   }

    //I. Admitir nuevos Residentes (MUERTO)
    public boolean admitirMuerto(String nombre, String codigo, int año){
        Muerto M = new Muerto(); 
        
        M.setnombre(nombre);
        M.setcodigo(codigo);
        M.setaño(año);
        M.setañofallecimiento(getañoactual());      //Pone el AÑO ACTUAL para el AÑO FALLECIMIENTO
        
        if (comprobarCodigo(codigo) == true) {
            return false;
        }
        if (M.setcodigo(codigo) == false) {
            return false;
        }else{if (getañoactual() < M.getaño()) {       //Si el año nacimiento es mayor que el de fallecimiento
             return false;
        }else{ASociedad.add(M);AMuerto.add(M); return true;}
        }
     
    }
    
    //I. Admitir nuevos Residentes (ZOMBIE)
    public boolean admitirZombie(String nombre, String codigo, int año){
        Zombie Z = new Zombie(); 
        
        Z.setnombre(nombre);
        Z.setcodigo(codigo);
        Z.setaño(año);
        Z.setañofallecimiento(getañoactual());      //Pone el AÑO ACTUAL para el AÑO FALLECIMIENTO
        double agresividad;
        agresividad = (int)(Math.random()*4);        //Asigna un valor random para AGRESIVIDAD entre 0 y 3
        double estado;
        estado = (int)(Math.random()*5+1);            //Asigna un valor random para ESTADO entre 0 y 5
        Z.setagresividad((int)agresividad);
        Z.setestado((int)estado);
        
        if (comprobarCodigo(codigo) == true) {
            return false;
        }
        if (Z.setcodigo(codigo) == false) {
            return false;
        }else{if (getañoactual() < Z.getaño()) {       //Si el año nacimiento es mayor que el de fallecimiento
             return false;
        }else{ASociedad.add(Z);AZombie.add(Z); return true;}
        }
     
    }
    
    //II. Dar de baja por traslado. En cualquier momento un habitante puede irse de 
    //la Sociedad. Si se va un noble también hay que eliminar de la Sociedad a sus sirvientes.
    public void baja(String codigo){
        Individuo I = new Individuo();
        Noble N = new Noble();
        Criado C = new Criado();
        Muerto M = new Muerto();
        Zombie Z = new Zombie();
        //Baja para NOBLES, CRIADOS E INDIVIDUOS
        for (int i = 0; i < ASociedad.size(); i++) {    
        I = (Individuo)ASociedad.get(i);
               if (I instanceof Noble) {        //Si se da de baja un NOBLE, para que se vayan sus CRIADOS
                   N = (Noble)ASociedad.get(i);
                 if (N.getcodigo().equals(codigo)){  
                   for (int j = 0; j < ACriado.size(); j++) {
                       C = (Criado)ACriado.get(j);
                       if (C.getnoble().equals(codigo)) {
                           ASociedad.remove(C);     //Elimina a los CRIADOS
                       }
                   }
                   ASociedad.remove(N);     //Elimina al NOBLE de la SOCIEDAD
                   ANoble.remove(N);        //Elimina al NOBLE de la COPIA
               }
           }    
           else             //Para que se vayan los CRIADOS o INDIVIDUOS
           {
               if (I.getcodigo().equals(codigo)){
                   if (I instanceof Criado) {
                       ASociedad.remove(I); //Elimina al CRIADO de la SOCIEDAD
                       ACriado.remove(I);   //Elimina al CRIADO de la COPIA
                   }else{
                       ASociedad.remove(I); //Elimina el INDIVIDUO
                   }

               }
           }
            
        }
        //Baja para MUERTOS
        for (int i = 0; i < AMuerto.size(); i++) {
            M = (Muerto)AMuerto.get(i);
            if (M.codigoM().equals(codigo)) {
                AMuerto.remove(M);      //Elimina de la COPIA
                ASociedad.remove(M);    //Elimina de la SOCIEDAD
            }
        }
        //Baja para ZOMBIES
        for (int i = 0; i < AZombie.size(); i++) {
            Z = (Zombie)AZombie.get(i);
            if (Z.codigoM().equals(codigo)) {
                AZombie.remove(Z);      //Elimina de la COPIA
                ASociedad.remove(Z);    //Elimina de la SOCIEDAD
            }
        }
    }
    
    //III. En cualquier momento un INDIVIDUO puede fallecer. Un rey o un criado que mueren
    //pierden todas sus condiciones especiales, son muertos sin privilegios ni servidumbres
    public void fallecer(String codigo){
        Individuo I = new Individuo();
        Individuo I2 = new Individuo();
        Muerto M = new Muerto();
        Criado C = new Criado();
        Noble N = new Noble();
        
        
        for (int i = 0; i < ASociedad.size(); i++) {
            I = (Individuo)ASociedad.get(i);
            if (I.getcodigo().equals(codigo)) {
                
                if (I instanceof Noble) { //Si es NOBLE
                    //Matar al NOBLE
                        M.setnombre(I.getnombre());
                        M.setcodigo(I.getcodigo());
                        M.setaño(I.getaño());
                        M.setañofallecimiento(this.añoactual);
                       
                        ASociedad.remove(i);    //Elimina el NOBLE de la SOCIEDAD
                        ANoble.remove(I);       //Elimina el NOBLE de la copia
                        ASociedad.add(M);       //Añade el MUERTO en la SOCIEDAD
                        AMuerto.add(M);         //Añade el MUERTO en la copia
                        
                    for (int j = 0; j < ACriado.size(); j++) {   //Transformar CRIADOS a INDIVIDUOS
                        C = (Criado)ACriado.get(j);
                       
                       if (C.getnoble().equals(M.codigoM())) { 
                            I2.setnombre(C.getnombre());
                            I2.setcodigo(C.getcodigo());
                            I2.setaño(C.getaño()); 
                            ASociedad.remove(C);         //Elimina el CRIADO de la SOCIEDAD
                            ASociedad.add(I2);           //Añade el CRIADO como INDIVIDUO en la SOCIEDAD
                            I2 = new Individuo();
                        } 
                    }

                }else{
                    if (I instanceof Criado){       //Si es Criado
                
                        M.setnombre(I.getnombre());
                        M.setcodigo(I.getcodigo());
                        M.setaño(I.getaño());
                        M.setañofallecimiento(this.añoactual);
                        ASociedad.remove(i);    //Elimina el INDIVIDUO de la SOCIEDAD
                        ACriado.remove(I);      //Elimina el CRIADO de la copia
                        ASociedad.add(M);       //Añade el MUERTO en la SOCIEDAD
                        AMuerto.add(M);         //Añade el MUERTO en la copia
                     }else{
                        
                        M.setnombre(I.getnombre());
                        M.setcodigo(I.getcodigo());
                        M.setaño(I.getaño());
                        M.setañofallecimiento(this.añoactual);
                        ASociedad.remove(i);    //Elimina el INDIVIDUO de la SOCIEDAD
                        ASociedad.add(M);       //Añade el MUERTO en la SOCIEDAD
                        AMuerto.add(M);         //Añade el MUERTO en la copia
                    }
                }
            }
            
        }
    }
            
    
    //IV. En cualquier momento un muerto puede evolucionar a un Zombie
    public void evolucionar(String codigo){
        Muerto M = new Muerto();
        Zombie Z = new Zombie();
        double agresividad;
        agresividad = (int)(Math.random()*4);        //Asigna un valor random para AGRESIVIDAD entre 0 y 3
        double estado;
        estado = (int)(Math.random()*5+1);            //Asigna un valor random para ESTADO entre 0 y 5
        
        for (int i = 0; i < AMuerto.size(); i++) {
            M = (Muerto)AMuerto.get(i);
            if (M.codigoM().equals(codigo)) {
                System.out.println("OH NO! " + M.getnombre() + " con codigo " + M.getcodigo() + " .Ha evolucionado a un Zombie");
                Z.setnombre(M.getnombre());
                Z.setcodigo(M.codigoM());
                Z.setaño(M.getaño());
                Z.setañofallecimiento(M.getañofallecimiento());
                Z.setagresividad((int)agresividad);
                Z.setestado((int)estado);
                AMuerto.remove(i);  //Elimina el Muerto de la copia
                ASociedad.remove(M); //Borra el Muerto de la SOCIEDAD 
                
                AZombie.add(Z);  //Añade al Zombie a la copia
                ASociedad.add(Z); //Añade el Zombie de la SOCIEDAD  
            }
        }
        
        
        
    }
    
    //V. Cazar (se liquidan todos los zombies que están en CATATÓNICO)
    public void cazar(){
        Zombie Z = new Zombie();
        for (int i = AZombie.size()-1; 0 <= i; i--) {
            Z = (Zombie)AZombie.get(i);
            
            if (Z.getestado() == 1) {
                System.out.println(Z.getnombre() + " con código " + Z.getcodigo() + " HA SIDO CAZADO");
                AZombie.remove(i);  //Elimina el Zombie de la copia
                ASociedad.remove(Z); //Borra el Zombie de la SOCIEDAD  
            }
        }
    }
    
    
    //VI. Aniquilar (eliminar uno a uno todos los habitantes de la sociedad)
    public void aniquilar(){
        
        for (int i = ASociedad.size()-1; 0 <= i; i--) {
            System.out.println(ASociedad.get(i) + " ha sido ANIQUILADO");
            ASociedad.remove(i);
        }
        //Ya que se tratan de copias de la ArrayList, hago directamente un CLEAR 
        //para simplificar el código.
                    ANoble.clear();
                    ACriado.clear();
                    AZombie.clear();
                    AMuerto.clear();
    }
    
    //VII. Consultar los datos de un residente por código. Si es un criado hay que
    //mostrar también el nombre y título de su señor.
    public void consultar(String codigo){
        Individuo I = new Individuo();
        Zombie Z = new Zombie();
        Muerto M = new Muerto();
        
        for (int i = 0; i < ASociedad.size(); i++) {
            I = (Individuo)ASociedad.get(i);
            if (I.getcodigo().equals(codigo)) {System.out.println(ASociedad.get(i));}
        }
        
        for (int i = 0; i < AMuerto.size(); i++) {
            M = (Muerto)AMuerto.get(i);
            if (M.codigoM().equals(codigo)) {System.out.println(AMuerto.get(i));}
        }
        for (int i = 0; i < AZombie.size(); i++) {
            Z = (Zombie)AZombie.get(i);
            if (Z.codigoM().equals(codigo)) {System.out.println(AZombie.get(i));}
        }
    }
    
    
    //VIII. Ver los datos de todos los RESIDENTES indicando de que tipo son. Y si
    //son ZOMBIES mostrar su estado.
    public void mostrarInfo(){
        Individuo I = new Individuo();
        for (int i = 0; i < ASociedad.size(); i++) {
            I = (Individuo)ASociedad.get(i);
               if (I instanceof Noble){System.out.println("NOBLE: " + ASociedad.get(i));}else{
               if (I instanceof Criado){System.out.println("CRIADO: " + ASociedad.get(i));}else{
               if (I instanceof Muerto){if (I instanceof Zombie){
                  System.out.println("ZOMBIE: " + ASociedad.get(i));
               }else{System.out.println("MUERTO: " + ASociedad.get(i));}
               }else{if (I instanceof Individuo) {System.out.println("INDIVIDUO: " + ASociedad.get(i));}}   
               }
               }   
        }
    }
    //IX. Ver los nombres de los NOBLES por título y mostrar los datos de sus CRIADOS (REY)
    public void verReyes(){
    Noble N = new Noble();
    Criado C = new Criado();
        for (int i = 0; i < ANoble.size() ; i++) {
            N = (Noble)ANoble.get(i);
            if (N.gettitulo().equals("REY")) {
                System.out.println(N.getnombre() + " con codigo: " + N.getcodigo());
                for (int j = 0; j < ACriado.size(); j++) {
                C = (Criado)ACriado.get(j);
                if (C.getnoble().equals(N.getcodigo())) {System.out.println(" --- " + C.getnombre() + " con codigo: " + C.getcodigo());}    
                }      
            }
        }  
    }
    //IX. Ver los nombres de los NOBLES por título y mostrar los datos de sus CRIADOS (DUQUE)
    public void verDuques(){
    Noble N = new Noble();
    Criado C = new Criado();
        for (int i = 0; i < ANoble.size() ; i++) {
            N = (Noble)ANoble.get(i);
            if (N.gettitulo().equals("DUQUE")) {
                System.out.println(N.getnombre() + " con codigo: " + N.getcodigo());
                for (int j = 0; j < ACriado.size(); j++) {
                C = (Criado)ACriado.get(j);
                if (C.getnoble().equals(N.getcodigo())) {System.out.println(" --- " + C.getnombre() + " con codigo: " + C.getcodigo());}    
                }      
            }
        }  
    }
    
    //X. Combatir entre dos residentes
    public void combate(String codigoI, String codigoZ){
        //(1)Un combate será de Individuo no muerto contra Zombie
        
        //(2)Un REY gana siempre
        
        //(3)Un Zombie Activo o en Ataque siempre gana a un Individuo. Un Zombie 
        //Despierto siempre gana a un Individuo si su nivel de agresividad está 
        //por encima en 1. En cualquier otro caso pierde
        
        //(4)Un INDIVIDUO que pierde un combate MUERE
        
        //(5)Un ZOMBIE que pierde un combate pasa a estado CATATÓNICO
        
        Individuo I = new Individuo();
        Noble N = new Noble();
        Criado C = new Criado();
        Muerto M = new Muerto();
        Zombie Z = new Zombie();
        Zombie Z2 = new Zombie();
        
        for (int i = 0; i < ASociedad.size(); i++) {    
            I = (Individuo)ASociedad.get(i);
            if (I.getcodigo().equals(codigoI)) {
            if (I instanceof Noble) {               //      (2)
                N = (Noble)ASociedad.get(i);
                if (N.gettitulo().equals("REY")) {
                    for (int j = 0; j < AZombie.size(); j++) {
                        Z = (Zombie)AZombie.get(j);
                        if (Z.codigoM().equals(codigoZ)){
                            Z2.setnombre(Z.getnombre());        //      (5)
                            Z2.setcodigo(Z.codigoM());
                            Z2.setaño(Z.getaño());
                            Z2.setañofallecimiento(Z.getañofallecimiento());
                            Z2.setestado(1);
                            Z2.setagresividad(Z.getagresividad());
                            AZombie.remove(j);  //Elimina el Zombie Antiguo de la copia
                            ASociedad.remove(Z); //Borra el Zombie Antiguo de la SOCIEDAD 
                            AZombie.add(Z2);  //Añade al Zombie a la copia
                            ASociedad.add(Z2); //Añade el Zombie de la SOCIEDAD
                            
                        }
                    }System.out.println("HA GANADO: " + codigoI);
                        break;
                }
            }
            }
            
            if (I.getcodigo().equals(codigoI)) {
                for (int j = 0; j < AZombie.size(); j++) {
                        Z = (Zombie)AZombie.get(j);
                        Z = (Zombie)AZombie.get(j);
                        if (Z.codigoM().equals(codigoZ)){
                            if (Z.getestado() == 4 || Z.getestado() == 5) {  //Si el ESTADO es Ataque o Activo
                                fallecer(codigoI);
                                System.out.println("HA GANADO: " + codigoZ);
                                
                                break;
                            }else{if (Z.getestado() == 3 && Z.getagresividad() > 1) {  //Si el ESTADO es Despierto y
                                 fallecer(codigoI);                                     // AGRESIVIDAD mayor a 1
                                System.out.println("HA GANADO: " + codigoZ);
                                break;
                            }else{
                                Z2.setnombre(Z.getnombre());        //      (5)
                                Z2.setcodigo(Z.codigoM());
                                Z2.setaño(Z.getaño());
                                Z2.setañofallecimiento(Z.getañofallecimiento());
                                Z2.setestado(1);
                                Z2.setagresividad(Z.getagresividad());
                                AZombie.remove(j);  //Elimina el Zombie Antiguo de la copia
                                ASociedad.remove(Z); //Borra el Zombie Antiguo de la SOCIEDAD 
                                AZombie.add(Z2);  //Añade al Zombie a la copia
                                ASociedad.add(Z2); //Añade el Zombie de la SOCIEDAD
                                System.out.println("HA GANADO: " + codigoI);break;
                                
                        }
                            }
                        }
                }
            }
        }
     
    }
        
 
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
         }catch(Exception ex){}
        return obj;
    }
    
    
}
