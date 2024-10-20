import java.util.Scanner;



//La clase main,tiene todo lo necesario para que el programa funcione como deberia 
public class NoJavaSky {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Inventario inventario = new Inventario(0, 0, 0, 0);
        MapaGalactico mapaGalactico = new MapaGalactico(inventario);
        Nave nave = new Nave(100, 0.0f, inventario);
        Jugador jugador= new Jugador(100,0, inventario, nave);
        System.out.println("Bien espero estes listo, aqui van unas ultimas instrucciones y consejos para tu mision de exploracion");
        System.out.println("Tu trabajo es sobrevivir y recolectar recursos e informacion");
        System.out.println("Cuentar con una nave preparada para informarte acerca de las condiciones climatologicas y los recursos del planeta que visites");
        System.out.println("Si encuentra un planeta extraño lo relacionara con algo terrestre para hacerlo familiar y entendible para ti");
        System.out.println("Segun sabemos existen 2 tipos de planetas ");
        System.out.println("Los oceanicos, planetas con rica vida acuatica y con importantes recursos en sus profundidades");
        System.out.println("Los Helados, planetas con climas frios cubiertos de nieve y hielo.");
        System.out.println("Debido a su clima creemos que estos tipos de planetas podrian alvergar vida, tu nave y traje se crearon con el proposito de poder soportarlos asi que exploralos bajo tu propio riesgo");
        System.out.println("Bueno esa es toda la informacion que tenemos, espero te sea de utilidad, recuerda tu nave tiene un sistema de navegacion que se activara una vez este en orbita.");
        System.out.println("Tendras siertas opciones predefinidas para hacer tu viaje un poco mas llevadero, lo demas depende de ti\n");
        System.out.println("Preparando despegue......... \n 3..... \n 2..... \n 1..... \n DESPEGUE \n ");
        System.out.println("                    /\\");
        System.out.println("                   //\\\\");
        System.out.println("                  ||##||");
        System.out.println("                 //####\\\\");
        System.out.println("                //######\\\\");
        System.out.println("               //########\\\\");
        System.out.println("              //##########\\\\");
        System.out.println("             //############\\\\");
        System.out.println("             ||############||");
        System.out.println("             ||############||");
        System.out.println("             |______________|");
        System.out.println("             |   Tocomple   |");
        System.out.println("              \\____________/");
        System.out.println("               |          |");
        System.out.println("              /|    /\\    |\\");
        System.out.println("             /_|    || /\\ |_\\");
        System.out.println("               |     NASHE|");
        System.out.println("               |          |");
        System.out.println("              /|    /\\    |\\");
        System.out.println("             / |    ||    | \\");
        System.out.println("            /  |    ||    |  \\");
        System.out.println("           /  /\\    ||    /\\  \\");
        System.out.println("          |__/  \\   ||   /  \\__|");
        System.out.println("            /____\\      /____\\");
        System.out.println("            |    |      |    |");
        System.out.println("            |    |______|    |");
        System.out.println("            |    | /--\\ |    |");
        System.out.println("            |____|/----\\|____|");
        System.out.println("             \\||/ //##\\\\ \\||/");
        System.out.println("             /##\\//####\\\\/##\\");
        System.out.println("            //##\\\\/####\\//##\\\\");
        System.out.println("           ||/::\\||/##\\||/::\\||");
        System.out.println("           \\\\\\''///:**:\\\\\\''///");
        System.out.println("            \\\\\\///\\::::/\\\\\\///");
        System.out.println("             \\\\//\\\\\\::///\\\\//");
        System.out.println("              \\/\\\\\\\\..////\\/");
        System.out.println("                 \\\\\\\\////");
        System.out.println("                  \\\\\\///");
        System.out.println("                   \\\\//");
        System.out.println("                    \\/");
        
        
        
        System.out.println("\n--- Iniciando sistema de navegacion ---");
        Planeta planetaInicial = mapaGalactico.generadorPlaneta();
        imprimirPlaneta(planetaInicial, mapaGalactico.getPosicion(), nave);
        

        while (opcion != 7) {
            System.out.println("Inventario actual\n");
            imprimirinventario(inventario);
            System.out.println("\n--- Mapa Galactico ---");
            System.out.println("1. Viajar al siguiente cuadrante");
            System.out.println("2. Regresar al cuadrante anterior");
            System.out.println("3. Viajar a un cuadrante especifico");
            System.out.println("4. Extraer recursos");
            System.out.println("5. Visitar planeta");
            System.out.println("6. Recargar");
            System.out.println("7. Ya no quieros vivir");
            System.out.println("Elija una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    nave.avanzarCuadrante(mapaGalactico);
                    System.out.println("El nuevo cuadrante es " + mapaGalactico.getPosicion());
                    imprimirPlaneta(mapaGalactico.getPlanetas().get(mapaGalactico.getPosicion()), mapaGalactico.getPosicion(),nave);
                    break;

                case 2:
                    if (mapaGalactico.getPosicion() > 0) {
                        mapaGalactico.regresarCuadrante();
                        System.out.println("Regresando al cuadrante anterior");
                        System.out.println("Posicion actual: " + mapaGalactico.getPosicion());
                        imprimirPlaneta(mapaGalactico.getPlanetas().get(mapaGalactico.getPosicion()), mapaGalactico.getPosicion(),nave);

                    } else {
                        System.out.println("Lo lamento pero no podemos viajar a ese lugar, todo se pone raro alguna vez viste la peli de bob esponja? pues es algo similar");
                    }
                    break;

                case 3:
                    System.out.println("Elija la direccion del viaje: \n Para retroceder 0 \n Para avanzar 1 ");
                    int direccion = scanner.nextInt();

                    
                    System.out.println("Elija tamaño del salto: ");
                    int tamano = scanner.nextInt();

                    
                    boolean exito = nave.viajarPlaneta(mapaGalactico, direccion, tamano);
                    

                    if (exito) {
                        System.out.println("Viaje exitoso, el nuevo cuadrante es:");
                        imprimirPlaneta(mapaGalactico.getPlanetas().get(mapaGalactico.getPosicion()), mapaGalactico.getPosicion(),nave);

                    } else {
                        System.out.println("Viaje fallido.");
                    }
                    break;
                   
                case 4:
                    int opc;
                    System.out.println("Ingrese que recurso quiere extraer");
                    System.out.println("1. Flores de sodio");
                    System.out.println("2. Cristales de hidrogeno");
                    System.out.println("3. Uranio");
                    System.out.println("4. Platino");
                    opc=scanner.nextInt();
                    Planeta planetaActual = mapaGalactico.getPlanetas().get(mapaGalactico.getPosicion());
                    planetaActual.extraerRecursos(opc);
                    planetaActual.salir();
                    break;
                    
                    
                    
                    
                case 5:
                    planetaActual = mapaGalactico.getPlanetas().get(mapaGalactico.getPosicion());
                    if (planetaActual instanceof tieneAsentamientos) {
                        ((tieneAsentamientos) planetaActual).visitarAsentamientos(jugador);
                    } else {
                        System.out.println("La nave no esta preparada para visitar este planeta. \n Saliendo ...............");
                    }
                    break;
                    
                case 6:
                    int rec;
                    int recurso;
                    System.out.println("Elija que recargar");
                    System.out.println("1. Recargar propulsores");
                    System.out.println("2. Recargar exotraje");
                    rec=scanner.nextInt();
                    if (rec==1){
                        System.out.println("Ingrese cantidad de cristales de hidrogeno a cargar");
                        recurso=scanner.nextInt();
                        nave.recargarPropulsores(recurso);
                    }else if(rec==2){
                        System.out.println("Ingrese cantidad de flores de sodio a cargar");
                        recurso=scanner.nextInt();
                        jugador.recargarEnergiaProteccional(recurso);
                        
                    } else {
                        System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
                    }
                    break;
                        
                
                case 7:
                    System.out.println("Adiosito");
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

                    
                    
                    System.out.println("Posicion final: " + mapaGalactico.getPosicion());
                    System.exit(0);
                    break;
                    
                    
            }
        }

        scanner.close();
    }

   
    //recibe el inventario, no retorna nada y lo imprime
    private static void imprimirinventario(Inventario inventario) {
        System.out.println("Platino: " + inventario.getPlatino());
        System.out.println("Uranio: " + inventario.getUranio());
        System.out.println("Flores de Sodio: " + inventario.getSodiof());
        System.out.println("Cristales de Hidrogeno: " + inventario.getHidrocristales());
    }


    //recibe el planeta la posicion y la nave, e imprime las caracteristicas del planeta
    private static void imprimirPlaneta(Planeta planeta, int posicion, Nave nave) {
        System.out.println("Cuadrante actual: " + posicion+"\n");
        System.out.println("Radio: " + planeta.getRadio());
        System.out.println("Cristales de Hidrogeno: " + planeta.getCristalesHidrogeno());
        System.out.println("Flores de Sodio: " + planeta.getFloresDeSodio());
        
        if (planeta instanceof Oceanico) {
            System.out.println("\n--- Planeta Oceanico ---");
            System.out.println("           _.====.._                             _.====.._");
            System.out.println("         ,:._       ~-_                        ,:._       ~-_");
            System.out.println("             `\\        ~-_                        `\\        ~-_");
            System.out.println("               | _  _  |  `.                       | _  _  |  `.");
            System.out.println("             ,/ /_)/ | |    ~-_                  ,/ /_)/ | |    ~-_");
            System.out.println("    -..__..-''  \\_ \\_\\ `_      ~~--    -..__..-''  \\_ \\_\\ `_      ~~--");
            
            Oceanico oceanico = (Oceanico) planeta;
            System.out.println("Profundidad: " + oceanico.getProfundidad());
            
        } else if (planeta instanceof Helado) {
            System.out.println("\n--- Planeta Helado ---");
            System.out.println("      /\\");
            System.out.println(" __   \\/   __");
            System.out.println(" \\_\\_\\/\\/_/_/");
            System.out.println("   _\\_\\/_/_");
            System.out.println("  __/_/\\_\\__");
            System.out.println(" /_/ /\\/\\ \\_\\");
            System.out.println("      /\\");
            System.out.println("      \\/");
            Helado helado = (Helado) planeta;
            System.out.println("Temperatura: " + helado.getTemperatura());
            
        } else if (planeta instanceof Volcanico) {
            System.out.println("\n--- Planeta Volcanico ---");
            System.out.println("                      ooO");
            System.out.println("                     ooOOOo");
            System.out.println("                   oOOOOOOoooo");
            System.out.println("                 ooOOOooo  oooo");
            System.out.println("                /vvv\\");
            System.out.println("               /V V V\\ ");
            System.out.println("              /V  V  V\\  ");
            System.out.println("             /         \\  ");
            System.out.println("            /           \\      ");
            System.out.println("          /               \\ ");
            System.out.println("         /                 \\  ");
            Volcanico volcanico = (Volcanico) planeta;
            System.out.println("Temperatura: " + volcanico.getTemperatura());
            System.out.println("Platino " + volcanico.getPlatino());
            
        } else if (planeta instanceof Radiactivo) {
            System.out.println("\n--- Planeta Radiactivo ---");
            System.out.println("         _________________________");
            System.out.println("        /    .................     \\");
            System.out.println("       /      ...............       \\");
            System.out.println("      /        .............         \\");
            System.out.println("     /          ...........           \\");
            System.out.println("    /            .........             \\");
            System.out.println("   /              .......               \\");
            System.out.println("  |             Radioactive             |");
            System.out.println("   \\...............     .............../");
            System.out.println("    \\.............       ............./");
            System.out.println("     \\...........         .........../");
            System.out.println("      \\.........           ........./");
            System.out.println("       \\......               ....../");
            System.out.println("        \\....                 ..../");
            System.out.println("         \\_______________________/");
            System.out.println("\n");
            
            Radiactivo radiactivo = (Radiactivo) planeta;
            System.out.println("Radiacion: " + radiactivo.getRadiacion());
            System.out.println("Uranio: " + radiactivo.getUranio());
            
        } else if (planeta instanceof CentroGalactico) {
            if (nave.getEficienciaPropulsor()<50){
                System.out.println("Aparecio un cumulo de estrellas.... trataste de maniobrar......  no fue suficiente......");
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
                System.exit(0);
            }else if(nave.getEficienciaPropulsor()>=50){
                System.out.println("Aparecio un cumulo de estrellas.... despues de maniobrar...... finalmente ves algo");
                System.out.println("Quedas anonadado debido a la magnificencia que estas presenciando");
                System.out.println("\n--- CentroGalactico ---");
                System.out.println("           _...----.._");
                System.out.println("        ,:':::::.     `>.");
                System.out.println("      ,' |:::::;'     |:::.");
                System.out.println("     /    `'::'       :::::\\");
                System.out.println("    /         _____     `::;\\");
                System.out.println("   :         /:::::\\      `  :");
                System.out.println("   | ,.     /::SSt::\\        |");
                System.out.println("   |;:::.   `::::::;'        |");
                System.out.println("   ::::::     `::;'      ,.  ;");
                System.out.println("    \\:::'              ,::::/");
                System.out.println("     \\                 \\:::/");
                System.out.println("      `.     ,:.        :;'");
                System.out.println("        `-.::::::..  _.''");
                System.out.println("           ```----'''");
                System.out.println("No puedes evitar pensar, FUA DE AQUI DEBE DE HABER SALIDO CHUPETE SUAZO DE VERDAD ERA EL HOMBRE VENIDO DEL PLANETA GOL");
                System.out.println("Wineaste, supreme victory");
                System.exit(0);
                
                CentroGalactico centroGalactico = (CentroGalactico) planeta;
                System.out.println("Estrellas: " + centroGalactico.getEstrellas());
            
            
            
            }
         
        }
    }
}
