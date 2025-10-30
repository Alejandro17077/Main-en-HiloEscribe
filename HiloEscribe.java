public class HiloEscribe extends Thread {
   private String info[];
   private int ini;
   private int tmp;
   private Posicion p;
  
   private volatile boolean pausado = false;
   public HiloEscribe(Posicion x) {
       this.p = x;
   }
  
   public void pausarHilo() {
       pausado = true;
   }
 
   public void reanudarHilo() {
       pausado = false;
      
       synchronized (p) {
           p.notify();
       }
   }
   public void setTmp(int tmp) {
       this.tmp = tmp;
   }
   @Override
   public void run() {
       for (int i = ini; i < ini + 5; i++) {
           try {
              
               synchronized (p) {
                   while (pausado) {
                       try {
                           System.out.println(getName() + " está pausado...");
                           p.wait(); 
                       } catch (InterruptedException e) {
                           System.out.println("Hilo interrumpido mientras esperaba.");
                       }
                   }
               }
               synchronized (p) {
                   info[p.getP()] = getName() + " (i=" + i + ", p=" + p.getP() + ")";
                   p.incrementa();
               }
               sleep(tmp);
           } catch (ArrayIndexOutOfBoundsException e) {
               System.out.println("NO HAY ESPACIO EN EL ARREGLO");
               i = ini + 5;
           } catch (InterruptedException e) {
               System.out.println("INTERRUPCIÓN");
           }
       }
       System.out.println("Hilo " + getName() + " ha terminado su ejecución normal.");
   }
   public void setIni(int x) {
       ini = x;
   }
   public void setInfo(String x[]) {
       info = x;
   }
}
