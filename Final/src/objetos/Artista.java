package objetos;

import java.util.ArrayList;

public class Artista extends Persona {

    private String nombreArtistico;
    private ArrayList<Produccion> producciones;// aca se cmabia por produccion cuando cree la clase

    // se inicializa dentro del constructor el array, ya que cuando se inicializa un
    // artista empieza vacio en producciones
    // despues se van agregando; cuando creas un artista todavia no tiene
    // producciones registradas. Evita el produccion=null
    public Artista(int dni, String nombre, String apellido, String nombreArtistico) {
        super(dni, nombre, apellido);
        this.nombreArtistico = nombreArtistico;
        this.producciones = new ArrayList<>();
    }

    // getters y setters
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public ArrayList<Produccion> getProducciones() {
        return producciones;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public void setProducciones(ArrayList<Produccion> producciones) {
        this.producciones = producciones;
    }

    @Override
    public void mostrarInfo() {

        System.out.println("Nombre:" + getNombre());
        System.out.println("Apellido:" + getApellido());
        System.out.println("Dni:" + getDni());
        System.out.println("Nombre Artistico: " + nombreArtistico);
        System.out.println("Producciones: " + producciones);
    }

    public void agregarProduccion(Produccion p) {
        producciones.add(p);
    }

    public void mostrarProducciones() {

        if (producciones.isEmpty() == true) {
            System.out.println("No posee producciones.");
        }
        producciones.forEach(Produccion::mostrarInfo);
        // recorre todas las producciones del artista. Significa que cada objeto
        // Produccion
        // de la lista ejecuta su metodo mostrarInfo()
        // aunque cada objeto sea de un tipo distinto, todos responden al método
        // mostrarInfo
    }

    public void publicarProduccion(Produccion p) throws ProduccionNoDisponibleException {
        p.publicar();
    }
}
