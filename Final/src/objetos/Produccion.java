package objetos;

import java.io.Serializable;

public abstract class Produccion implements IPublicable, Serializable {

    private int id;
    private String titulo;
    private String genero;
    private int anio;
    private EstadoProduccion estado;

    public Produccion(int id, String titulo, String genero, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.estado = EstadoProduccion.EN_PRODUCCION;
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Año: " + anio);
        System.out.println("Estado: " + estado);
    }

    public abstract double getDuracion();

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getAnio() { return anio; }
    public EstadoProduccion getEstado() { return estado; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setEstado(EstadoProduccion estado) { this.estado = estado; }
}