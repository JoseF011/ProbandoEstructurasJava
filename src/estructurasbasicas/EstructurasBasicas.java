package estructurasbasicas;

import java.util.Scanner;

public class EstructurasBasicas {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int dineroSolicitado = 0;
        final int BILLETES[] = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int billetesEntregados[] = new int[BILLETES.length];//array con el tamaño de la cantidad de billetes
        int billetesRecargados[] = new int[BILLETES.length];//para el recargo de billetes
        int contRecarga = 0, contRetiro = 0;
        int dineroEntregado = 0, dineroRestante = 0;
        int limiteRetirar = 20000; 
        int op = 0;
        int dineroRecargado;  

        do {
            System.out.println("Menú de Opciones");
            System.out.println("1. Recargo");
            System.out.println("2. Retiro");
            System.out.println("3. Historial de transacciones");
            System.out.println("4. Salir");

            System.out.println("Qué desea hacer?");
            op = entrada.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Ingrese la cantidad de dinero que va a recargar: ");
                    dineroRecargado = entrada.nextInt();

                    dineroRestante = dineroRecargado;

                    for (int x = 0; x < BILLETES.length; x++) {
                        if (dineroRestante >= BILLETES[x]) {
                            billetesRecargados[x] = dineroRestante / BILLETES[x];  //Conocer cuantos billetes entrego de esta denominacion
                            dineroEntregado = billetesRecargados[x] * BILLETES[x];  //Dinero entregando con estos billetes
                            dineroRestante -= dineroEntregado;                    //Restar esa cifra para saber cuanto me falta pagar
                            contRecarga++;
                        } else {
                            billetesRecargados[x] = 0;
                        }
                       

                        System.out.println("Billetes de " + BILLETES[x] + " entregados: " + billetesRecargados[x] + " DINERO Recargado: " + dineroRecargado + " DINERO Restante: " + dineroRestante);
                        dineroEntregado = 0;
                    }
                    break;

                case 2:
                    System.out.println("La cantidad limite de retiro diario no debe exceder a 20,000");
                    System.out.println("Ingrese la cantidad que desea retirar: ");
                    dineroSolicitado = entrada.nextInt();
                    if (dineroSolicitado < limiteRetirar) {

                        dineroRestante = dineroSolicitado;
                        contRetiro++;

                        for (int x = 0; x < BILLETES.length; x++) {
                            if (dineroRestante >= BILLETES[x]) {
                                billetesEntregados[x] = dineroRestante / BILLETES[x];  //¨para saber los billetes que se entregan
                                dineroEntregado = billetesEntregados[x] * BILLETES[x];  //Dinero que se entregó con los billetes
                                dineroRestante -= dineroEntregado;                    //restar para saber cuanto me falta regresar
                            } else {
                                billetesEntregados[x] = 0;
                            }
                            System.out.println("Billetes de " + BILLETES[x] + " entregados: " + billetesEntregados[x] + " Dinero Entregado: " + dineroEntregado + " DINERO Restante: " + dineroRestante);
                            dineroEntregado = 0;
                        }
                    } else {
                        System.out.println("Monto diario de retiro excedido. Ingresar una cantidad menor a 20,000");

                    }
                    break;

                case 3:

                    System.out.println("Se ha recargado: " + contRecarga + " veces");
                    System.out.println("Se ha retirado: " + contRetiro + " veces");

                case 4:
                    System.out.println("Gracias por utilizar el ATM!! Hasta pronto ");
            }

        } while (op != 4);//eso se cumplirá mientras sea distinto a 4 ya que si me da otra opción esto será erróneo

    }

}
