import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class MapaGalactico {
    private List<Planeta> planetas;
    private int posicion;
    private Inventario inventario;

    // Constructor de mapaglactico recive inventario
    public MapaGalactico(Inventario inventario) {
        this.planetas = new ArrayList<>();
        this.posicion = 0;
        this.inventario = inventario;
    }

    //obtiene la lista de planetas y lo retorna, no recibe parametros 
    public List<Planeta> getPlanetas() {
        return planetas;
    }

    //obtiene la posicion y lo retorna, no recibe parametros 
    public int getPosicion() {
        return posicion;
    }

    //recibe la posicion y le da un valor
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    //retrocede una posicion si la pos actual es mayor a 0
    public void regresarCuadrante() {
        if (posicion > 0) {
            posicion--;  
        } else {
            System.out.println("Ya estás en el cuadrante 0, no puedes regresar más.");
        }
    }
    
    //Crea los planetas segun la probabilidad especificada
    public Planeta generadorPlaneta(){
        Random prob = new Random();
        Random rand = new Random();
        Planeta nuevo = null;
        int numero = prob.nextInt(100);

        if (numero < 30) { // Helado
            int rad = rand.nextInt((1000000 - 1000) + 1) + 1000;
            int ctr = (int) (0.65 * 4 * Math.PI * rad * rad);
            int flor = (int) (0.35 * 4 * Math.PI * rad * rad);
            nuevo = new Helado(rad, ctr, flor,inventario);
         
        } else if (numero < 60) { // Oceánico
            int rad = rand.nextInt((1000000 - 10000) + 1) + 10000;
            int ctr = (int) (0.2 * 4 * Math.PI * rad * rad);
            int flor = (int) (0.65 * 4 * Math.PI * rad * rad);
            nuevo = new Oceanico(rad, ctr, flor,inventario);
         
        } else if (numero < 80) { // Radiactivo
            int rad = rand.nextInt((100000 - 10000) + 1) + 10000;
            int ctr = (int) (0.2 * 4 * Math.PI * rad * rad);
            int flor = (int) (0.2 * 4 * Math.PI * rad * rad);
            nuevo = new Radiactivo(rad, ctr, flor,inventario);
            
        } else if (numero < 99) { // Volcánico
            int rad = rand.nextInt((100000 - 1000) + 1) + 1000;
            int ctr = (int) (0.3 * 4 * Math.PI * rad * rad);
            int flor = 0;
            nuevo = new Volcanico(rad, ctr, flor,inventario);
            
        } else { // Centro galactico 
            int rad = (int) (Math.random() * (1000000 - 10000)) + 10000;
            int ctr = (int) (0.65 * 4 * Math.PI * rad * rad);
            int flor = (int) (0.35 * 4 * Math.PI * rad * rad);
            nuevo = new Oceanico(rad, ctr, flor,inventario);
           
        }

        planetas.add(nuevo); 
        return nuevo;
    }
     
}