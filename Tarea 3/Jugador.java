public class Jugador {
    private float unidadesEnergiaProteccional;
    private float eficienciaEnergiaProteccional;
    private Inventario inventario;
    private Nave nave;

    //obtiene el inventario y lo retorna, no recibe parametros 
    public Inventario getInventario() {
        return inventario;
    }
    
    //obtiene el inventario y lo retorna, no recibe parametros 
    public float getUnidadesEnergiaProteccional() {
        return unidadesEnergiaProteccional;
    }

    //recibe las unidades de energia proteccional y les da un valor
    public void setUnidadesEnergiaProteccional(float unidadesEnergiaProteccional) {
        this.unidadesEnergiaProteccional = unidadesEnergiaProteccional;
    }

    //obtiene el getEficienciaEnergiaProteccional y lo retorna, no recibe parametros 
    public float getEficienciaEnergiaProteccional() {
        return eficienciaEnergiaProteccional;
    }

    //recibe la eficienciaenergiaproteccional y le da un valor
    public void setEficienciaEnergiaProteccional(float eficienciaEnergiaProteccional) {
        this.eficienciaEnergiaProteccional = eficienciaEnergiaProteccional;
    }

    /*float unidadesEnergiaProteccional las unidadesEnergiaProteccional 
    fñloat eficienciaEnergiaProteccional la eficienciaEnergiaProteccional 
    Inventario inventario, el inventario
    Nave nave la nave 
    constructor de jugador se le pasan los parametros al crearse 
    */
    public Jugador(float unidadesEnergiaProteccional, float eficienciaEnergiaProteccional, Inventario inventario, Nave nave) {
        this.unidadesEnergiaProteccional = unidadesEnergiaProteccional;
        this.eficienciaEnergiaProteccional = eficienciaEnergiaProteccional;
        this.inventario = inventario;
        this.nave = nave; 
    }
    
    
    public void recargarEnergiaProteccional(int sodio){
        if (sodio <= inventario.getSodiof()) {
            float recarga= unidadesEnergiaProteccional + (float) (0.65*sodio*(1+eficienciaEnergiaProteccional));
            unidadesEnergiaProteccional=unidadesEnergiaProteccional+recarga;
            System.out.println("Hexotraje recargados. Energia protecional actual: " + unidadesEnergiaProteccional);
        } else {
            System.out.println("No hay suficientes cristales de hidrogeno.");
        }
    }
    
    // recibe un velor mejora y mejora la eficiencia del traje en 5
    public void mejoratraje(float mejora){
        eficienciaEnergiaProteccional+=5.0;
    }
    
    // recibe un velor mejora y mejora la eficiencia de la nave 
    public void mejoranave(float mejora) {
        nave.setEficienciaPropulsor(nave.getEficienciaPropulsor() + mejora); 
    }
}