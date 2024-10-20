import java.util.Scanner;
public abstract class Planeta {
    private int radio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int diferencia;
    private Inventario inventario;

    //obtiene el radio y lo retorna, no recibe parametros 
    public int getRadio() {
        return radio;
    }

    //recibe el radio y les da un valor
    public void setRadio(int radio) {
        this.radio = radio;
    }

    //obtiene los cristaleshidrogeno y la retorna, no recibe parametros 
    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    //recibe los cristales de hidrogeno y les da un valor
    public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

    //obtiene las floredsdesodio y la retorna, no recibe parametros 
    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    //recibe flores de sodio y les da un valor
    public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
    }
    
    //obtiene la diferencia y la retorna, no recibe parametros 
    public int getDiferencia() {
        return diferencia;
    }
   
    public abstract int laDiferencia();
    
    
    
    /*int radio radio del planeta
     int cristalesHidrogeno los cristales de hidrogeno del planeta
     int floresDeSodio las flores de sodio del planeta
     Inventaro inventario el inventario del planeta
     constructor de planetas 
     */
    public Planeta(int radio, int cristalesHidrogeno, int floresDeSodio, Inventario inventario) {
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.diferencia = laDiferencia();  
        this.inventario = inventario;
    }
    
    //no recibe nada e imprime un mensaje avisando que avandonas la atmosfera del planeta indicando que saliste de el
    public boolean salir(){
        System.out.println("Abandonando atmosfera del planeta actual.....");
        return true;
    }
    
    //recibe el tipo de recurso que quiere extraer el jugador y llama a la funcion extraccion luego retorna lo que entregue dicha funcion
    public int extraerRecursos(int tipo) {
        Scanner scan = new Scanner(System.in);
        int cantidad;
        System.out.print("Ingrese cantidad a extraer: ");
        cantidad = scan.nextInt();
        int extraido = extraccion(tipo, cantidad, inventario, this);
        return extraido;
    }
    
    /*int tipo el tipo de recurso a extraer
     int cantidad La cantidad a extraer
     int inventario el inventario
     Inventaro inventario eñ inventario del planeta
     Planeta planeta planeta actual
     ve si puedes extraer recursos, de ser asi retorna la cantidad extraida, sino retorna -1 e imprime valor invalido
     */
    public int extraccion(int tipo, int cantidad, Inventario inventario, Planeta planeta){
        switch (tipo) {
            case 1:
                if(planeta.getFloresDeSodio()>=cantidad){
                    System.out.println("Tenias " + inventario.getSodiof() + " flores de sodio");
                    inventario.setSodiof(inventario.getSodiof() + cantidad);
                    System.out.println("Ahora tienes " + inventario.getSodiof() + " flores de sodio");
                }else{
                    System.out.println("El planeta no cuenta con lo necesario para la extraccion");
                }
                break;

            case 2:
                if(planeta.getCristalesHidrogeno()>=cantidad){
                    System.out.println("Tenias  " + inventario.getHidrocristales() + " cristales de hidrógeno");
                    inventario.setHidrocristales(inventario.getHidrocristales() + cantidad);
                    System.out.println("Ahora tienes " + inventario.getHidrocristales() + " cristales de hidrógeno");
                }else{
                    System.out.println("El planeta no cuenta con lo necesario para la extraccion");
                }
                break;

            case 3:
                if(planeta instanceof Radiactivo && ((Radiactivo) planeta).getUranio() >= cantidad){
                    System.out.println("Tenias  " + inventario.getUranio() + " de uranio");
                    inventario.setUranio(inventario.getUranio() + cantidad);
                    System.out.println("Ahora tienes " + inventario.getUranio() + " de uranio");
                }else{
                    System.out.println("El planeta no cuenta con lo necesario para la extraccion");
                }
                break;

            case 4:
                if (planeta instanceof Volcanico && ((Volcanico) planeta).getPlatino() >= cantidad){
                    System.out.println("Tenias  " + inventario.getPlatino() + " de platino");
                    inventario.setPlatino(inventario.getPlatino() + cantidad);
                    System.out.println("Ahora tienes " + inventario.getPlatino() + " de platino");
                }else{
                    System.out.println("El planeta no cuenta con lo necesario para la extraccion");
                }
                break;

            default:
                System.out.println("Saliendo, número inválido");
                return -1; 
        }
        return cantidad;  
    }

}