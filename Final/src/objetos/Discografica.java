package objetos;

import java.util.ArrayList;
import java.util.HashMap;

public class Discografica {

    private ArrayList<Produccion> producciones;
    private HashMap<Integer, Persona> personas;

    public Discografica() {
        this.producciones = new ArrayList<>();
        this.personas = new HashMap<>();
    }

    public void agregarProduccion(Produccion p) {
        producciones.add(p);
    }

    public void registrarPersona(Persona p) {
        personas.put(p.getDni(), p);
    }

    public Artista buscarArtista(int dni) {

        Persona persona = personas.get(dni);

        if (persona instanceof Artista) {
            return (Artista) persona;
        }

        return null;
    }

    public Produccion buscarProduccion(String titulo) {

        return producciones.stream()
                .filter(p -> p.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Produccion> getProducciones() {
        return producciones;
    }

    public void setProducciones(ArrayList<Produccion> producciones) {
        this.producciones = producciones;
    }

    public HashMap<Integer, Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(HashMap<Integer, Persona> personas) {
        this.personas = personas;
    }
}