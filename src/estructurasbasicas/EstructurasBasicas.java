package estructurasbasicas;
import java.util.Scanner;
public class EstructurasBasicas {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // variable que contendra el valor a devolver
        int importe = 0;
        do {
            try {
                System.out.print("Ingresa la cantidad de dinero que necesita:");
                importe = entrada.nextInt();
            } catch (Exception e) {
                System.out.println("Introduciste un dato erroneo.");
               System.out.println("");
                entrada.nextLine();
            }
        } while (importe <= 0);

        calcular(importe);
    }

    public static void calcular(double importe) {
        // Indicamos todas las monedas posibles
        int[] monedas = {500, 200, 100, 50, 20, 10, 5, 2, 1};

        // Creamos un array con 0 de longitud igual a la cantidad de monedas
        // Este array contendra las monedas a devolver
        int[] devolver = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        // Recorremos todas las monedas
        for (int i = 0; i < monedas.length; i++) {
            // Si el importe actual, es superior a la moneda
            if (importe >= monedas[i]) {
                // obtenemos cantidad de monedas
                devolver[i] = (int) Math.floor(importe / monedas[i]);

                // actualizamos el valor del importe que nos queda por didivir
                importe = importe - (devolver[i] * monedas[i]);
            }
        }

        // Bucle para mostrar el resultado
        for (int i = 0; i < monedas.length; i++) {
            if (devolver[i] > 0) {
                if (monedas[i] > 2) {
                    // Indicamos que es un billete
                    System.out.println("Hay " + devolver[i] + " billetes de: " + monedas[i] + " Lempiras");
                } 
            }

        }

    }

}
/*  int numero=0;
       double decimales=10.5;
       char caracter='A';
       boolean binario=false;
       
       float nota=85;
       float MAXPR=60;
      
       //Estructuras Decision
       if(nota>=MAXPR){
           System.out.println("Aprobó la clase con éxito!");
       }
       else{
           System.out.println("Ha reprobado la clase");
       }
       //Operador Ternario
        System.out.println(nota>MAXPR ? "Aprobó la clase con éxito" : "Reprobó la clase");
       
        System.out.println(!binario);
        
       if (nota>=0 && nota<60){
           System.out.println("Reprobado");
       }else if(nota>=60 && nota<80){
           System.out.println("Bueno");
       }else if(nota>=80 && nota<90){
           System.out.println("Muy bueno");
       }else{
           System.out.println("Excelente");
       }
        switch (numero){
            case 0:
                
            case 1:
        }
       //Estructuras Repetitivas
       //Operadores logicos
       //And &
       //Or |
 */
