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

    // REGISTRAR
    public void agregarProduccion(Produccion p) {
        producciones.add(p);
    }

    public void registrarPersona(Persona p) {
        personas.put(p.getDni(), p);
    }

    public void registrarArtista(Artista artista) {
        personas.put(artista.getDni(), artista);
    }

    // BUSQUEDAS
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

    // *****REQUERIMIENTOS DEL MENU
    // mostrar canciones publicadas, apafece en el UML DE MENU

    public void mostrarPublicadas() {

        List<Produccion> publicadas = producciones.stream()
                .filter(p -> p.getEstado() == EstadoProduccion.PUBLICADO)
                .collect(Collectors.toList());

        publicadas.forEach(Produccion::mostrarInfo);
    }

    // Agregar produccion
    public void agregarProduccionArtista(int dni, Produccion produccion) {

        Artista artista = buscarArtista(dni);

        if (artista == null) {
            System.out.println("Artista no encontrado.");
            return;
        }

        agregarProduccion(produccion);
        artista.agregarProduccion(produccion);

        System.out.println("Producción agregada correctamente.");
    }

    // Publicar produccion
    public void publicarProduccion(String titulo) {

        Produccion produccion = buscarProduccion(titulo);

        if (produccion == null) {
            System.out.println("Producción no encontrada.");
            return;
        }

        produccion.publicar();
        System.out.println("Producción publicada correctamente.");
    }

    // Reproducir produccion
    public void reproducirProduccion(String titulo) {

        Produccion produccion = buscarProduccion(titulo);

        if (produccion == null) {
            System.out.println("Producción no encontrada.");
            return;
        }

        try {
            produccion.reproducir();
        } catch (ProduccionNoDisponibleException e) {
            System.out.println(e.getMessage());
        }
    }

    // Mostrar catalogo ordenado por titulo
    public void mostrarOrdenadas() {

        ArrayList<Produccion> copia = new ArrayList<>(producciones);

        Collections.sort(copia, new Comparator<Produccion>() {

            @Override
            public int compare(Produccion p1, Produccion p2) {
                return p1.getTitulo().compareToIgnoreCase(p2.getTitulo());
            }

        });

        if (copia.isEmpty()) {
            System.out.println("No hay producciones registradas.");
            return;
        }

        for (Produccion p : copia) {
            p.mostrarInfo();
        }
    }

    public void guardarProducciones() {
        repositorio.guardar(producciones);
    }

    @SuppressWarnings("unchecked")
    public void cargarProducciones() {
        Object obj = repositorio.consultar();

        if (obj instanceof ArrayList) {
            producciones = (ArrayList<Produccion>) obj;
        } else {
            producciones = new ArrayList<>();
        }
    }
    //GET Y SET
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