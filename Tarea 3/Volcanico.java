import java.util.Random;
public class Volcanico extends Planeta {
    private int temperatura;
    private int platino;


    //obtiene la temperatura y la retorna, no recibe parametros 
    public int getTemperatura() {
        return temperatura;
    }

    //obtiene el platino y lo retorna, no recibe parametros 
    public int getPlatino() {
        return platino;
    }
     

    //metodo personalizado para esta subclase el cual retornara la temperatura 
    @Override
    public int laDiferencia() {
        Random rand = new Random();
        this.temperatura = rand.nextInt(136) + 120;  
        return this.temperatura;    
    }    
    
    
    //funcion para calcular la cantidad de platino que creara el planeta, recibe el radio del planeta y la temperatura porque es necesario para saber cuanto platino generara 
    private int platino(int radio, int temperatura){
        this.platino = (int)(0.25 * 4 * Math.PI * radio * radio)- (int)(20.5*temperatura);
        return this.platino;
    }
    
    /*int radio radio del planeta
     int cristalesHidrogeno los cristales de hidrogeno del planeta
     int floresDeSodio las flores de sodio del planeta
     Inventaro inventario eñ inventario del planeta
     constructor de planetas de tipo volcanico se le pasan los parametros al crearse 
     */
    public Volcanico(int radio, int cristalesHidrogeno, int floresDeSodio, Inventario inventario){
        super(radio, cristalesHidrogeno, floresDeSodio, inventario);
        this.temperatura = laDiferencia(); 
        this.platino = platino(radio, temperatura);
    }
    
   
}