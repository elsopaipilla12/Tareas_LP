public class Nave {
    private float unidadesCombustible;
    private float eficienciaPropulsor;
    private Inventario inventario;

    
    //obtiene los UnidadesCombustible y lo retorna, no recibe parametros 
    public float getUnidadesCombustible() {
        return unidadesCombustible;
    }

    //recibe las UnidadesCombustible y le da un valor
    public void setUnidadesCombustible(float unidadesCombustible) {
        this.unidadesCombustible = unidadesCombustible;
    }

    //obtiene la eficienciaPropulsor y lo retorna, no recibe parametros 
    public float getEficienciaPropulsor() {
        return eficienciaPropulsor;
    }
    
    //recibe la EficienciaPropulsory le da un valor
    public void setEficienciaPropulsor(float eficienciaPropulsor) {
        this.eficienciaPropulsor = eficienciaPropulsor;
    }

    /* unidadesCombustible la unidades de combustuble
    eficienciaPropulsor la eficiencia del propulsor
    Inventario inventario el inventario
    constructor de nave
    */
    public Nave(float unidadesCombustible, float eficienciaPropulsor, Inventario inventario) {
        this.unidadesCombustible = unidadesCombustible;
        this.eficienciaPropulsor = eficienciaPropulsor;
        this.inventario = inventario;
    }
    
    
    /* MapaGalactico MG el mapa galactico
    direccion direccion hacia adelante o atras segun el usuario
    int tamanoSalto la cantidad de cuadrados a saltar
    el usuario ingresa cuanto quiere saltar y la direccion del salto, la funcion ve si tiene el combustible 
    retorna true si puede viajar y false si no
    */
    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto) {
        int posicion = MG.getPosicion();
        int nposicion;
        float consumo = (float) 0.75 * tamanoSalto * tamanoSalto * (1 - eficienciaPropulsor);

        if (unidadesCombustible < consumo) {
            System.out.println("No alcanza el combustible.");
            return false;
        }

        if (direccion == 0) { 
            nposicion = posicion - tamanoSalto;
            if (nposicion < 0) {
                System.out.println("No puedes retroceder más allá del cuadrante 0.");
                return false;
            } else {
                unidadesCombustible -= consumo;
                MG.setPosicion(nposicion);
                System.out.println("Has viajado al cuadrante " + nposicion + ", queda: " + unidadesCombustible + " combustible");
                return true;
            }
        } else if (direccion == 1) {  
            nposicion = posicion + tamanoSalto;

        
            while (MG.getPlanetas().size() <= nposicion) {
                MG.generadorPlaneta(); 
            }

            unidadesCombustible -= consumo;
            MG.setPosicion(nposicion);
            System.out.println("Has viajado al cuadrante " + nposicion + ", queda: " + unidadesCombustible + " combustible");
            return true;
        } else {
            System.out.println("Dirección inválida.");
            return false;
        }
    }
    
    // recibe mapa galactico, si la pos es >0 y el consumo lo permite avanza 1 cuadrante
    public void avanzarCuadrante(MapaGalactico MG) {
        int posicion = MG.getPosicion();
        int nuevaPosicion = posicion + 1;
        float consumo = (float) 0.75 * (1 - eficienciaPropulsor); 
        if (unidadesCombustible < consumo) {
            System.out.println("No tienes suficiente combustible para avanzar.");
        } else {
            unidadesCombustible -= consumo;
            MG.setPosicion(nuevaPosicion);
        
       
            if (nuevaPosicion >= MG.getPlanetas().size()) {
                MG.generadorPlaneta();
            }
        }

        System.out.println("Avanzaste al cuadrante " + nuevaPosicion + ". Combustible restante: " + unidadesCombustible);
        
    }
    
    // recibe una cantidad de hidrogeno dada por el usuario, si el usuario tiene dicha cantidad en el inventario lo recarga 
    //a los propulsores sino imprime que no tienes lo suficiente 
    public void recargarPropulsores(int hidrogeno) {
        if (hidrogeno <= inventario.getHidrocristales()) {
            float recarga = 0.6f * hidrogeno * (1 + eficienciaPropulsor);
            unidadesCombustible = unidadesCombustible + recarga; 
            inventario.setHidrocristales(inventario.getHidrocristales() - hidrogeno);
            System.out.println("Propulsores recargados. Combustible actual: " + unidadesCombustible);
        } else {
            System.out.println("No hay suficientes cristales de hidrogeno.");
        }
    }
    
}