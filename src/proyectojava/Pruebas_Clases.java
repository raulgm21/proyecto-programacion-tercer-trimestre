package proyectojava;
import java.util.*;
public class Pruebas_Clases {

    public static void main(String[] args) {
       ///////////////////////////////////////////////////
       //   CLASE DE PRUEBAS PARA COMPROBAR LAS CLASES  //
       ///////////////////////////////////////////////////
       
       //       PRUEBA DE LA CLASE RASGO        //
        System.out.println("        ~Clase Rasgo~");
        
       System.out.println("CONSTRUCTORES:");
       Rasgo R1 = new Rasgo();              //Constructor por defecto
       Rasgo R2 = new Rasgo(true,3,2);      //Constructor por parámetros
       Rasgo R3 = new Rasgo(true,4,3);      //Error en agresividad
       Rasgo R4 = new Rasgo(true,2,6);      //Error en estado
       Rasgo R5 = new Rasgo(true,7,8);      //Error en agresividad y estado
       Rasgo R6 = new Rasgo(2,2);           //Constructor Agresividad y Estado
       Rasgo R7 = new Rasgo(R1);            //Constructor Copia
       Rasgo R8 = (Rasgo)R1.clone();
       
       System.out.println("SETTER & GETTER:");
       R1.setdescomposicion(false);                 //Set de Descomposición
       System.out.println(R1.getdescomposicion());  //Get de Descomposición
       
       R1.setagresividad(1);                        //Set de Agresividad
       System.out.println(R1.getagresividad());     //Get de Agresividad
       
       R1.setagresividad(7);                        //ERROR
       System.out.println(R1.getagresividad());     //Get de Agresividad
       
       R1.setestado(2);                             //Set de Estado
       System.out.println(R1.getestado());          //Get de Estado
       
       R1.setestado(7);                             //ERROR
       System.out.println(R1.getestado());          //Get de Estado
       
       System.out.println("DECIR ESTADO:");
       R2.setestado(1);
       System.out.println(R2.decirestado());        //CATATONICO
       
       R2.setestado(2);
       System.out.println(R2.decirestado());        //DORMIDO
       
       R2.setestado(3);
       System.out.println(R2.decirestado());        //DESPIERTO
       
       R2.setestado(4);
       System.out.println(R2.decirestado());        //ACTIVO
       
       R2.setestado(5);
       System.out.println(R2.decirestado());        //ATAQUE
       
       System.out.println("SUBIR Y BAJAR ESTADO:");
       R1.setestado(3);
       R1.subeEstado();                             //Sube ESTADO
       System.out.println(R1.getestado());
       
       R1.bajaEstado();                             //Baja ESTADO
       System.out.println(R1.getestado());
       
       R1.setestado(5);
       R1.subeEstado();                             //ERROR SUBE ESTADO
       System.out.println(R1.getestado());
       
       R1.setestado(2);
       R1.bajaEstado();                             //ERROR BAJA ESTADO
       System.out.println(R1.getestado());
       
       
       
       System.out.println("");System.out.println("");System.out.println("");
        
       
       
       
       //       PRUEBA DE LA CLASE INDIVIDUO        //
       System.out.println("     ~Clase Individuo~");
        
       System.out.println("CONSTRUCTORES:");
       Individuo I1 = new Individuo();                      //Constructor por defecto
       Individuo I2 = new Individuo("Pepe","I00001",2000);  //Constructor por parámetros
       Individuo I3 = new Individuo("Luis","U00002",2000);  //ERROR en inicio código
       Individuo I4 = new Individuo("Ana","I03",2000);      //ERROR en longitud
       Individuo I5 = new Individuo(I1);                    //Constructor Copia
       
       System.out.println("SETTER & GETTER:");
       I2.setnombre("Juan");                                //Set de Nombre
       System.out.println(I2.getnombre());                  //Get de Nombre
       
       I2.setcodigo("I99999");                              //Set de Codigo
       System.out.println(I2.getcodigo());                  //Get de Codigo
       
       I2.setaño(2100);                                     //Set de Año
       System.out.println(I2.getaño());                     //Get de Año
       
       System.out.println("toString:");
       System.out.println(I1);     System.out.println(I2);
       System.out.println(I3);     System.out.println(I4);
       System.out.println(I5);         
       
       System.out.println("");System.out.println("");System.out.println("");
       
       
       
       
       //       PRUEBA DE LA CLASE NOBLE        //
       System.out.println("     ~Clase Noble~");
       
       System.out.println("CONSTRUCTORES:");       
       Noble N1 = new Noble();                                  //Constructor por defecto
       Noble N2 = new Noble("Erick","I000008",2000,"rEy");      //Constructor por parametro
       Noble N3 = new Noble("Paul","I0000010",2000,"dUquE");    //Constructor por parametro
       Noble N4 = new Noble("Raúl","I000009",2000,"h");         //ERROR
       Noble N5 = new Noble(N1);                                //Constructor Copia
       
       System.out.println("toString:");
       System.out.println(N1);     System.out.println(N2);
       System.out.println(N3);     System.out.println(N4);
       System.out.println(N5);
       
       System.out.println("");System.out.println("");System.out.println("");
       
       
       
       
       //       PRUEBA DE LA CLASE CRIADO        //
       System.out.println("     ~Clase Criado~");
       
       Criado C1 = new Criado();                                //Constructor por defecto
       Criado C2 = new Criado("Carlos","I00000015",2000,N2);    //Constructor por parametro con N2
       Criado C3 = new Criado(C1);                              //Constructor Copia
       
       System.out.println("PONER NOBLE:");
       C2.setnoble(N3);                                         //Asignamos el Noble quien sirve
       System.out.println(C2.getnoble());                       //Muestra el código del Noble que sirve
       
       System.out.println("toString:");
       System.out.println(C1);     
       System.out.println(C2);
       System.out.println(C3); 
       
       System.out.println("");System.out.println("");System.out.println("");
       
       
       
       
       //       PRUEBA DE LA CLASE MUERTO        //
       System.out.println("     ~Clase Muerto~");
       System.out.println("CONSTRUCTORES:");
       
       Muerto M1 = new Muerto();                                //Constructor por defecto
       Muerto M2 = new Muerto("Julio","I00000019",2000,2100);   //Constructor por parametros
       Muerto M3 = new Muerto("Julían","I00000020",2000,1900);  //ERROR Constructor por parametros
       Muerto M4 = new Muerto(M1);                              //Constructor Copia
       Muerto MTest = new Muerto();
       
       System.out.println("SETTER & GETTER:");
       M1.setañofallecimiento(2200);                            //Set de Año de Fallecimiento
       System.out.println(M1.getañofallecimiento());            //Get de Año de Fallecimiento
                    
       System.out.println("toString:");
       System.out.println(M1);     System.out.println(M2);
       System.out.println(M3);     System.out.println(M4);
       
        System.out.println("TEST:");
        MTest.setnombre("Teo");         MTest.setcodigo("I000002");
        MTest.setaño(1000);             MTest.setañofallecimiento(1200);
        
        System.out.println(MTest);
        System.out.println("El codigo MUERTO es " + MTest.codigoM());
       System.out.println("");System.out.println("");System.out.println("");
       
       
       
       
       //       PRUEBA DE LA CLASE ZOMBIE        //
       System.out.println("     ~Clase Zombie~");
       System.out.println("CONSTRUCTORES:");
       
       Zombie Z1 = new Zombie();                                    //Constructor por defecto
       Zombie Z2 = new Zombie("Pepito","I0000069",2000,2100,3,3);   //Constructor por parametros
       Zombie Z3 = new Zombie(Z1);                                  //Constructor COPIA
       Zombie ZTest = new Zombie();
       
       System.out.println("MÉTODOS CAMBIAR ESTADO");
       Z2.cambiarCatatonico();                                      //Pasa a CATATÓNICO     
       System.out.println(Z2.decirestado());
       
       Z1.setestado(1); 
       Z1.cambiarEstado();                                          //Pasa a CUALQUIER ESTADO
       System.out.println(Z1.decirestado());
       
       
       System.out.println("toString:");
       System.out.println(Z1);     System.out.println(Z2);
       System.out.println(Z3);     
       
        System.out.println("TEST:");
        ZTest.setnombre("Teo");         ZTest.setcodigo("I000002");
        ZTest.setaño(1000);             ZTest.setañofallecimiento(1200);
        System.out.println("El codigo ZOMBIE es " + ZTest.codigoM());
        System.out.println(ZTest);
      
        //PRUEBA CLONEABLE
        
        System.out.println("CLASE CLONEABLE");
        Rasgo RC = new Rasgo();
        Rasgo RC2 = (Rasgo)RC.clone();
        
        System.out.println(RC);
        System.out.println(RC2);
        
        Individuo IC = new Individuo();
        Individuo IC2 = (Individuo)IC.clone();
        
        System.out.println(IC);
        System.out.println(IC2);
        
        Noble NC = new Noble();
        Noble NC2 = (Noble)NC.clone();
           
        System.out.println(NC);
        System.out.println(NC2);
        
        Criado CC = new Criado();
        Criado CC2 = (Criado)CC.clone();
        
        System.out.println(CC);
        System.out.println(CC2);
        
        Muerto MC = new Muerto();
        Muerto MC2 = (Muerto)MC.clone();
        
        System.out.println(MC);
        System.out.println(MC2);
        
        Zombie ZC = new Zombie();
        Zombie ZC2 = (Zombie)ZC.clone();
        
        System.out.println(ZC);
        System.out.println(ZC2);
    }   
    
}