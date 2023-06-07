package proyectojava;
import java.util.*;
public class PruebaSociedad {

    public static void main(String[] args) {
      //&
        Scanner TECLADO = new Scanner(System.in);
         
        Sociedad Sociedad = new Sociedad();
        
                //VARIABLES
        //=================================
        
        int opcion, opcionAdmitir;
        Noble N = new Noble();
        String vNombre;
        String vCodigo;
        String vCodigo2;
        int vAño;
        String vTitulo;
        String vNoble;
        String elegirResidentes;
        boolean menu = true;
        
        //=================================
        
        System.out.println("==================================");
        System.out.println("¿Como deseas llamar a su SOCIEDAD?");
        System.out.println("==================================");
        vNombre = TECLADO.next();
        Sociedad.setlocalizacion(vNombre);
       
        System.out.println("==================================");
        System.out.println("Él año en el que se sitúa es: 2022");
        System.out.println("==================================");

        System.out.println("");
        System.out.println("");
        
        System.out.print("    ¿Desea añadir un Pack de Residentes antes de EMPEZAR?   (SI/NO) ");
        elegirResidentes = TECLADO.next();
        String Residentes = elegirResidentes.toUpperCase();      
        if (Residentes.equals("SI")) {
            System.out.println("Pack de Residentes añadido con Éxito");
            Sociedad.paqueteResidentes();  
        }else{System.out.println("Pack de Residentes INACTIVO");}
        
        
        do{
            try{
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("~Bienvenido a: " + Sociedad.getlocalizacion() + " . Año: " + Sociedad.getañoactual() + " ~");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("1.Admitir un nuevo Individuo");
            System.out.println("2.Dar de baja por Translado");
            System.out.println("3.Fallecimiento de un Individuo");
            System.out.println("4.Evolución de un Muerto a Zombie");
            System.out.println("5.Cazar Zombies");
            System.out.println("6.Aniquilar la Sociedad");
            System.out.println("7.Consultar Individuo mediante Código");
            System.out.println("8.Mostrar información de los Residentes de la Sociedad");
            System.out.println("9.Mostrar los Nobles de la Sociedad");
            System.out.println("10.¡Combate!");
            System.out.println("");
            System.out.println("11.Pasar de año");
            System.out.print("Elija la opción:");
            
            opcion = TECLADO.nextInt();
         
            if (opcion == 1) {             
            System.out.println("");
            System.out.println("¡Sea bienvenido al ayuntamiento de " + Sociedad.getlocalizacion() + "!");
            System.out.println("¿Que desea introducir a la Sociedad?");
            System.out.println("");
            System.out.println("     1-Introducir un Individuo");
            System.out.println("     2-Introducir un Noble");
            System.out.println("     3-Introducir un Criado");
            System.out.println("     4-Introducir un Muerto");
            System.out.println("     5-Introducir un Zombie");
            System.out.println("     Otro-Volver Atrás");
            System.out.println("");
            System.out.print("Elegir Opción: ");
            opcionAdmitir = TECLADO.nextInt();
            
            
                
                if (opcionAdmitir== 1)
                {
                    System.out.println("=========================");
                    System.out.println("        INDIVIDUO");
                    System.out.println("=========================");
                    
                    System.out.print("Escribe el nombre: "); vNombre = TECLADO.next();
                    System.out.print("Escribe el código: "); vCodigo = TECLADO.next();
                    System.out.print("Escribe el año de nacimiento: "); vAño = TECLADO.nextInt();
                    System.out.println("");
                    
                    //Manda un mensaje si el CÓDIGO ya existe
                    if (Sociedad.comprobarCodigo(vCodigo) == true) {
                    System.out.println("Existe ya ese código. Intentelo de nuevo"); 
                    }
                    //No admite el INDIVIDUO por algún fallo
                    if (Sociedad.admitirIndividuo(vNombre,vCodigo,vAño) == false) {
                      
                        System.out.println("Algo no ocurrio como debia. Intentelo de nuevo");
                            
                    }else{System.out.println("~Individuo Introducido~");}      
                }
                
                if (opcionAdmitir == 2 )
                {
                    System.out.println("=========================");
                    System.out.println("        NOBLE");
                    System.out.println("=========================");
                    
                    System.out.print("Escribe el nombre: "); vNombre = TECLADO.next();
                    System.out.print("Escribe el código: "); vCodigo = TECLADO.next();
                    System.out.print("Escribe el año de nacimiento: "); vAño = TECLADO.nextInt();
                    System.out.print("Escribe el título: "); vTitulo = TECLADO.next();
                    System.out.println("");
                    
                    //Manda un mensaje si el CÓDIGO ya existe
                    if (Sociedad.comprobarCodigo(vCodigo) == true) {
                    System.out.println("Existe ya ese código. Intentelo de nuevo"); 
                    }
                    //No admite el NOBLE por algún fallo
                    if (Sociedad.admitirNoble(vNombre,vCodigo,vAño,vTitulo) == false) {
                      
                        System.out.println("Algo no ocurrio como debia. Intentelo de nuevo");
                            
                    }else{System.out.println("~Noble Introducido~");}  
                            
                }
                    
                if (opcionAdmitir == 3)
                {
                    System.out.println("=========================");
                    System.out.println("        CRIADO");
                    System.out.println("=========================");
                    
                    System.out.print("Escribe el nombre: "); vNombre = TECLADO.next();
                    System.out.print("Escribe el código: "); vCodigo = TECLADO.next();
                    System.out.print("Escribe el año de nacimiento: "); vAño = TECLADO.nextInt();
                    System.out.print("Escribe el noble:"); vNoble = TECLADO.next();
                    System.out.println("");
                    
                    
                    //Manda un mensaje si el CÓDIGO ya existe
                    if (Sociedad.comprobarCodigo(vCodigo) == true) {
                    System.out.println("Existe ya ese código. Intentelo de nuevo"); 
                    }
                    //No admite el CRIADO por algún fallo
                    if (Sociedad.admitirCriado(vNombre,vCodigo,vAño,vNoble) == false) {
                      
                        System.out.println("Algo no ocurrio como debia. Intentelo de nuevo");
                  
                    }else{System.out.println("~Criado Introducido~");}  
                       
                }
                
                if (opcionAdmitir == 4) {
                    System.out.println("=========================");
                    System.out.println("        MUERTO");
                    System.out.println("=========================");
                    
                    System.out.print("Escribe el nombre: "); vNombre = TECLADO.next();
                    System.out.print("Escribe el código: "); vCodigo = TECLADO.next();
                    System.out.print("Escribe el año de nacimiento: "); vAño = TECLADO.nextInt();
                    System.out.println("");
                    
                    //Manda un mensaje si el CÓDIGO ya existe
                    if (Sociedad.comprobarCodigo(vCodigo) == true) {
                    System.out.println("Existe ya ese código. Intentelo de nuevo"); 
                    }
                    //No admite el MUERTO por algún fallo
                    if (Sociedad.admitirMuerto(vNombre,vCodigo,vAño) == false) {
                      
                        System.out.println("Algo no ocurrio como debia. Intentelo de nuevo");
                            
                    }else{System.out.println("~Muerto Introducido~");}
                }
                
                if (opcionAdmitir == 5) {
                    System.out.println("=========================");
                    System.out.println("        ZOMBIE");
                    System.out.println("=========================");
                    
                    System.out.print("Escribe el nombre: "); vNombre = TECLADO.next();
                    System.out.print("Escribe el código: "); vCodigo = TECLADO.next();
                    System.out.print("Escribe el año de nacimiento: "); vAño = TECLADO.nextInt();
                    System.out.println("");
                    
                    //Manda un mensaje si el CÓDIGO ya existe
                    if (Sociedad.comprobarCodigo(vCodigo) == true) {
                    System.out.println("Existe ya ese código. Intentelo de nuevo"); 
                    }
                    //No admite el ZOMBIE por algún fallo
                    if (Sociedad.admitirZombie(vNombre,vCodigo,vAño) == false) {
                      
                        System.out.println("Algo no ocurrio como debia. Intentelo de nuevo");
                            
                    }else{System.out.println("~Zombie Introducido~");}
                }
            
            
            
            }
            if (opcion == 2) {
                System.out.println("===========================");
                System.out.println("        DAR DE BAJA");
                System.out.println("===========================");
                System.out.println("");
                
                System.out.println("Un INDIVIDUO de la sociedad se quiere dar de BAJA");
                System.out.print("Introduce el código del INDIVIDUO: ");
                vCodigo = TECLADO.next();
                System.out.println("");
                Sociedad.baja(vCodigo);
            }
            
            if (opcion == 3) {
                System.out.println("========================");
                System.out.println("        FALLECER");
                System.out.println("========================");
                System.out.println("");
                
                System.out.println("Un INDIVIDUO de la sociedad ha fallecido");
                System.out.print("Introduce el código del INDIVIDUO: ");
                vCodigo = TECLADO.next();
                System.out.println("");
                
                Sociedad.fallecer(vCodigo);
                
                System.out.println("");
                
                System.out.println("=========================");
                System.out.println("Datos cambiados con Éxito");
                System.out.println("==========================");
            }
            if (opcion == 4) {
                System.out.println("===========================");
                System.out.println("        EVOLUCIONAR");
                System.out.println("===========================");
                System.out.println("");
                
                System.out.println("¡Estás intentando revivir a un ser fallecido!");
                System.out.println("¿Con quien quieres intentar este expertimento?");
                System.out.print("Introduce el código de un MUERTO: ");
                vCodigo = TECLADO.next();
                System.out.println("");
                
                Sociedad.evolucionar(vCodigo);
                
                System.out.println("");
                
                System.out.println("=================================");
                System.out.println("Experimento fallecido... o... no?");
                System.out.println("=================================");
            }
            if (opcion == 5) {
                System.out.println("=====================");
                System.out.println("        CAZAR");
                System.out.println("=====================");
                System.out.println("");
                
                Sociedad.cazar();
                
                System.out.println("");
                
                System.out.println("=========================");
                System.out.println("Zombies cazados con Éxito");
                System.out.println("=========================");
            }
            if (opcion == 6) {      //Metodo ANIQUILAR
                System.out.println("=============================");
                System.out.println("        ANIQUILACIÓN");
                System.out.println("=============================");
                System.out.println("");
                
                Sociedad.aniquilar();
                
                System.out.println("");
                
                System.out.println("=============================");
                System.out.println("Sociedad Aniquilada con Éxito");
                System.out.println("=============================");
            }
            if (opcion == 7) {      //Método CONSULTAR residente con CÓDIGO
                System.out.println("=========================");
                System.out.println("        CONSULTAR");
                System.out.println("=========================");
                System.out.println("");
                System.out.println("¡Bienvenido a la sección privada del Ayuntamiento!");
                System.out.println("¿Que residente quieres CONSULTAR?");
                System.out.print("Introduce el código del RESIDENTE: ");
                vCodigo = TECLADO.next();
                System.out.println("");
                System.out.println("===========Resultado===========");
                Sociedad.consultar(vCodigo);
                System.out.println("===============================");
                System.out.println("");
                System.out.println("========================");
                System.out.println("Consulta hecha con Éxito");
                System.out.println("========================");
            }
            if (opcion == 8) {      //Método MOSTRAR sociedad
                System.out.println("========================");
                System.out.println("        SOCIEDAD");
                System.out.println("========================");
                System.out.println(""); 
                Sociedad.mostrarInfo();
                System.out.println("");
                System.out.println("========================");
            }
            if (opcion == 9) {      //Método VER NOBLES por Título
                System.out.println("=====================");
                System.out.println("        REYES");
                System.out.println("=====================");
                
                Sociedad.verReyes();
                System.out.println("");
                
                System.out.println("======================");
                System.out.println("        DUQUES");
                System.out.println("======================");
                
                Sociedad.verDuques();
                System.out.println("");
            }
            if (opcion == 10) {     //Método COMBATE
                System.out.println("========================");
                System.out.println("        COMBATIR");
                System.out.println("========================");
                
                System.out.print("Escribe el código del INDIVIDUO: ");
                vCodigo = TECLADO.next();
                System.out.print("Escribe el código del ZOMBIE: ");
                vCodigo2 = TECLADO.next();
                System.out.println("");
                Sociedad.combate(vCodigo, vCodigo2);
               
                
            }
            if (opcion == 11) {     //Método pasar año
                Sociedad.sumarañoactual();
            }

         }catch(Exception X){
         TECLADO.nextLine();
                System.out.println("¡DEBES INTRODUCIR UN NÚMERO!");
         }
        }while(menu);
        
        
    }
    
}
