package objetos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Discografica {

    private ArrayList<Produccion> producciones;
    private HashMap<Integer, Persona> personas;
    private IRepositorio repositorio;

    public Discografica() {
        this.producciones = new ArrayList<>();
        this.personas = new HashMap<>();
        this.repositorio = new Repositorio();
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

    public void mostrarPublicadas() {

        List<Produccion> publicadas = producciones.stream()
                .filter(p -> p.getEstado() == EstadoProduccion.PUBLICADO)
                .collect(Collectors.toList());

        publicadas.forEach(Produccion::mostrarInfo);
    }

    public void mostrarOrdenadas() {

        Collections.sort(producciones, new Comparator<Produccion>() {

            @Override
            public int compare(Produccion p1, Produccion p2) {
                return p1.getTitulo().compareToIgnoreCase(p2.getTitulo());
            }
        });

        for (Produccion p : producciones) {
            p.mostrarInfo();
        }
    }

    public void guardarProducciones() {
        repositorio.guardar(producciones);
    }

    @SuppressWarnings("unchecked")
    public void cargarProducciones() {
        producciones = (ArrayList<Produccion>) repositorio.consultar();
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

    public IRepositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(IRepositorio repositorio) {
        this.repositorio = repositorio;
    }
}