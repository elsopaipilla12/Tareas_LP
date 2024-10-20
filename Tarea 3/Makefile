JAVAC = javac
JAVA_FLAGS = --release 23


SOURCES = CentroGalactico.java Helado.java Inventario.java Jugador.java \
          MapaGalactico.java Nave.java NoJavaSky.java Oceanico.java \
          Planeta.java Radiactivo.java tieneAsentamientos.java Volcanico.java


OUT_DIR = bin


CLASSES = $(SOURCES:.java=.class)


MAIN_CLASS = NoJavaSky


all: $(OUT_DIR) $(CLASSES)


%.class: %.java
	$(JAVAC) $(JAVA_FLAGS) -d $(OUT_DIR) $<


$(OUT_DIR):
	mkdir -p $(OUT_DIR)


run: all
	java -cp $(OUT_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(OUT_DIR)

.PHONY: all run clean

