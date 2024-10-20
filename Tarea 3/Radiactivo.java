import java.util.Random;
public class Radiactivo extends Planeta  {
    private int radiacion;
    private int uranio;

    //obtiene la radiacion y la retorna, no recibe parametros 
    public int getRadiacion() {
        return radiacion;
    }
    
    //obtiene el uranio y lo retorna, no recibe parametros 
    public int getUranio() {
        return uranio;
    }
    
    //funcion para calcular la cantidad de uranio que creara el planeta, recibe el radio del planeta porque es necesario para saber 
    private int eluranio(int radio){
        this.uranio = (int)(0.65 * 4 * Math.PI * radio * radio);
        return this.uranio;
    }

    /*int radio radio del planeta
     int cristalesHidrogeno los cristales de hidrogeno del planeta
     int floresDeSodio las flores de sodio del planeta
     Inventaro inventario eñ inventario del planeta
     constructor de planetas de tipo radioactivo se le pasan los parametros al crearse 
     */
    public Radiactivo(int radio, int cristalesHidrogeno, int floresDeSodio, Inventario inventario){
        super(radio, cristalesHidrogeno, floresDeSodio, inventario);
        this.radiacion = laDiferencia();  
        this.uranio = eluranio(radio);
    }
    

    //metodo personalizado para esta subclase el cual retornara la radiacion
    @Override
    public int laDiferencia() {
        Random rand = new Random();
        this.radiacion = rand.nextInt(41) + 10;  
        return this.radiacion;    
    }    
}
    