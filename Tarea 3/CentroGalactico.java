import java.util.Random;
public class CentroGalactico extends Planeta {
    private int estrellas;
    
    //obtiene la cantidad de estrellas, no recibe parametros 
    public int getEstrellas() {
        return estrellas;
    }


    /*int radio radio del planeta
     int cristalesHidrogeno los cristales de hidrogeno del planeta
     int floresDeSodio las flores de sodio del planeta
     Inventaro inventario eñ inventario del planeta
     constructor de planeta centroGalactico se le pasan los parametros al crearse 
     */
    public CentroGalactico(int radio, int cristalesHidrogeno, int floresDeSodio, Inventario inventario){
        super(radio, cristalesHidrogeno, floresDeSodio, inventario);
        this.estrellas = laDiferencia();  
    }

    
    //metodo personalizado para esta subclase el cual retornara la cantidad de estrellas del planeta
    @Override
    public int laDiferencia() {
        Random rand = new Random();
        this.estrellas = rand.nextInt(971) + 300;
        return this.estrellas;
    }
}