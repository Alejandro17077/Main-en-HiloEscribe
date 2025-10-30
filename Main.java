import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main (String[] args){

Scanner scanner=new
Scanner (System.in);

Posicion p=new Posicion();
String[] arreglo=new String[20];

HiloEscribe hilo=new
HiloEscribe(p);
hilo.setName("Hilo principal");
hilo.setInfo(arreglo);
hilo.setIni(0);
hilo.setTmp(1000);

System.out.println("Empezando el hilo");
hilo.start();

boolean salir=false;
while (!salir){
    System.out.println("-----Menu-----");
    
    System.out.println("1.Pausar Hilo");
    System.out.println("2.Continuar Hilo");
    System.out.println("3.Terminar Hilo");
    System.out.println("4.Mostrar Hilo");
    System.out.println("5.Estado del Hilo");
    System.out.println("6.Salir");
    
    System.out.println("-----Sleccione una opcion-----");
    
    try{
        int opcion=scanner.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Pausando el hilo");
                hilo.pausarHilo();
                System.out.println("Estado actual: "+ hilo.getState());
                break;
            
            case 2:
                System.out.println("Continuando el hilo");
                hilo.reanudarHilo();
                System.out.println("Estado actual: "+ hilo.getState());
                break;
                
                case 3:
                System.out.println("Terminando el hilo");
                hilo.stop();
                System.out.println("Hilo deteniendose");
                System.out.println("Estado actual: "+ hilo.getState());
                break;
                
                case 4:
                    System.out.println("-----Contenido del arreglo-----");
                    for (int i=0;
                    i<arreglo.length;
                    i++){
                        if (arreglo[i] !=null){
                            System.out.println("Pos["+i+"]:"+arreglo[i]);
                            
                        }
                    }
                break;
                    
                    case 5:
                        System.out.println("Estado del hilo:" + hilo.getState());
                        break;
                        
                        case 6:
                            System.out.println("Saliendo del programa");
                            salir=true;
                            if(hilo.isAlive()){
                                hilo.stop();}
                                break;
                                
default:
System.out.println("Opcion no valida");
}

}
catch
(InputMismatchException e){
    System.out.println("Se debe escribir un numero");
    scanner.next();
}
catch (Exception e){
    System.out.println("Ha ocurrido un error: "+ e.getMessage());
    }
}

scanner.close();
System.out.println("Programa principal finalizado");
}
}
