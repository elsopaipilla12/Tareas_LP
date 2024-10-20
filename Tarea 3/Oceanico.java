import java.util.Random;
import java.util.Scanner;

public class Oceanico extends Planeta implements tieneAsentamientos {
    private int profundidad;
    
    //obtiene la profundidad y la retorna, no recibe parametros 
    public int getProfundidad() {
        return profundidad;
    }


    /*int radio radio del planeta
     int cristalesHidrogeno los cristales de hidrogeno del planeta
     int floresDeSodio las flores de sodio del planeta
     Inventaro inventario eñ inventario del planeta
     constructor de planetas de tipo ocenico se le pasan los parametros al crearse 
     */
    public Oceanico(int radio, int cristalesHidrogeno, int floresDeSodio, Inventario inventario){
        super(radio, cristalesHidrogeno, floresDeSodio, inventario);
        this.profundidad = laDiferencia();  // Se llama al método que calcula la profundidad
    }
    


    //metodo personalizado para esta subclase el cual retornara la profundidad
    @Override
    public int laDiferencia() {
        Random rand = new Random();
        this.profundidad = rand.nextInt((1000 - 30) + 1) + 30;  
        return this.profundidad;
        
    }
    
    //no retorna nada y solo imprime por pantalla el arte ascii de muerte cuando es llamada
    public void muerto(){
        System.out.println("                                 _____  _____");
        System.out.println("                                |     \\/     |"); 
        System.out.println("                                |            |");       
        System.out.println("                                |   _     _  |");       
        System.out.println("                                |  |_) | |_) |");       
        System.out.println("                                |  | \\ | |   |");       
        System.out.println("                                |            |");       
        System.out.println("                 _______________|            |_________________");       
        System.out.println("               _/                                       \\|     |");       
        System.out.println("              |                P  L  A  Y  E  R                <");       
        System.out.println("              |_____.-._________              ____/|___________|");       
        System.out.println("                                |            |");       
        System.out.println("                                |  16/10/24  |");       
        System.out.println("                                |            |");
        System.out.println("                                |            |");
        System.out.println("                                |   _        <");
        System.out.println("                                |__/         |");
        System.out.println("                                 / `--.      |");
        System.out.println("                                |            |");
        System.out.println("                                |           -< ");
        System.out.println("            ^^^^^^^^^^^^^^^^^^^^|            |^^^^^^^^^^^^^^^^^^^^");
    }
    
    

    /*metodo imprementado desde la interfaz tieneAsentamientos, sirve para visitar e interactuar con el planeta
    dependiendo de lo que ingrese el jugador podra mejorar la nave, negociar con el mecanico espacial o irse,
    negociar depende de la probavilidad con un numero random*/
    @Override 
    public void visitarAsentamientos(Jugador jugador){ 
        Scanner scanner = new Scanner(System.in);
        Random prob = new Random();
        int numero = prob.nextInt(15);
        System.out.println("Despues de mucho viajar finalmente encontraste a los locatarios del planeta");
        System.out.println("Te ofrecen mejorar tu nave por 50000 de uranio");
        System.out.println("Elija una opcion");
        System.out.println("1. Mejorar la nave");
        System.out.println("2. Negociar ");
        System.out.println("3. Salir ");
        int opcion= scanner.nextInt();    
       
        switch(opcion){
            case 1:
                if (jugador.getInventario().getPlatino() >= 50000) {
                    jugador.getInventario().setPlatino(jugador.getInventario().getPlatino() - 50000);
                    System.out.println("Has mejorado tu nave. Platino restante: " + jugador.getInventario().getPlatino());
                    jugador.mejoranave(5.0f); 
                } else {
                    System.out.println("No tienes suficiente platino.");
                    System.out.println("El de la tienda penso que querias estafarlo...... te disparo");
                    muerto();
                    System.exit(0);
                }
                break;
            
            case 2:
                if (numero<5){
                    System.out.println("Y si me lo dejas en 10000?");
                    System.out.println("Y tu que te crees pedazo de imbecil");
                    muerto();
                    System.exit(0);
                }else if(numero<10){
                    System.out.println("Que sean 10000");
                    System.out.println("Mecanico espacial: 30000 ");
                    System.out.println("50000 tomalo o dejalo");
                    if (jugador.getInventario().getPlatino() >= 50000) {
                        jugador.getInventario().setPlatino(jugador.getInventario().getPlatino() - 50000);
                        System.out.println("Has mejorado tu nave. Platino restante: " + jugador.getInventario().getPlatino());
                        jugador.mejoranave(5);
                    } else {
                        System.out.println("No tienes suficiente platino.");
                        System.out.println("El de la tienda penso que querias estafarlo...... te disparo");
                        muerto();
                        System.exit(0);
                }
                    break;
                
                }else if(numero<15){
                    System.out.println("Me lo dejas en 10000?");
                    System.out.println("Esta bien. ");
                    if (jugador.getInventario().getPlatino() >= 10000) {
                        jugador.getInventario().setPlatino(jugador.getInventario().getPlatino() - 10000);
                        System.out.println("Has mejorado tu nave. Platino restante: " + jugador.getInventario().getPlatino());
                        jugador.mejoranave(5);
                    } else {
                        System.out.println("No tienes suficiente platino.");
                        System.out.println("El de la tienda penso que querias estafarlo...... te disparo");
                        muerto();
                        System.exit(0);
                    }

                
                }
                break;
            
            case 3:
              System.out.println("Decides salir sin hacer nada.");

        }
    }
}
