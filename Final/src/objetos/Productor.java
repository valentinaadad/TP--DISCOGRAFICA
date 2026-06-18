package objetos;

public class Productor extends Persona {
    private String estudio;

    public Productor(int dni, String nombre, String apellido, String estudio) {
        super(dni, nombre, apellido);
        this.estudio = estudio;
    }
    
    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public void mostrarInfo(){
        System.out.println("Nombre:" + getNombre());
        System.out.println("Apellido:" + getApellido());
        System.out.println("Dni:"+ getDni());
        System.out.println("Estudio: " + getEstudio());
    }

    public void registrarProduccion(Discografica discografica, Produccion produccion) {
        discografica.agregarProduccion(produccion);
   }

    
}
