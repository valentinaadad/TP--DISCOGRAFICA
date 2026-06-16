package objetos;
import java.util.ArrayList;

public class Artista extends Persona {
    
    private String nombreArtistico;
    private ArrayList <String> producciones;//aca se cmabia por produccion cuando cree la clase
    
   
    public Artista(int dni, String nombre, String apellido, String nombreArtistico, ArrayList<String> producciones) {
        super(dni, nombre, apellido);
        this.nombreArtistico = nombreArtistico;
        this.producciones = producciones;
    }
    
    //getters y setters
    public String getNombreArtistico() {
        return nombreArtistico;
    }
    public ArrayList<String> getProducciones() {
        return producciones;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }
    public void setProducciones(ArrayList<String> producciones) {
        this.producciones = producciones;
    }
    
    public void mostrarInfo(){
       
        System.out.println("Nombre:" + getNombre());
        System.out.println("Apellido:" + getApellido());
        System.out.println("Dni:"+ getDni());
        System.out.println("Nombre Artistico: " + nombreArtistico);
        System.out.println("Producciones: "+ producciones);
    }    
}
