public class Inventario {
    private int platino;
    private int uranio;
    private int sodiof;
    private int hidrocristales;
    

   //obtiene el platino y lo retorna, no recibe parametros 
    public int getPlatino() {
        return platino;
    }

    ////recibe el platino y les da un valor
    public void setPlatino(int platino) {
        this.platino = platino;
    }

    //obtiene el uranio y lo retorna, no recibe parametros 
    public int getUranio() {
        return uranio;
    }

    ////recibe el uranio les da un valor
    public void setUranio(int uranio) {
        this.uranio = uranio;
    }

    //obtiene el sodio y lo retorna, no recibe parametros 
    public int getSodiof() {
        return sodiof;
    }

    //recibe los cristales de sodio y les da un valor
    public void setSodiof(int sodiof) {
        this.sodiof = sodiof;
    }

    //obtiene los cristales de hidrogeno y lo retorna, no recibe parametros 
    public int getHidrocristales() {
        return hidrocristales;
    }

    //recibe las flores de hidrogeno y les da un valor
    public void setHidrocristales(int hidrocristales) {
        this.hidrocristales = hidrocristales;
    }

    /*int platino el platino 
     int uranio el uranio 
     int sodiof las flores de sodio 
     int hidrocristales la cantidad de cristales de hidrogeno 
     constructor de inventario se le pasan los parametros al crearse 
     */
    public Inventario(int platino, int uranio, int sodiof, int hidrocristales) {
        this.platino = platino;
        this.uranio = uranio;
        this.sodiof = sodiof;
        this.hidrocristales = hidrocristales;
    }
}