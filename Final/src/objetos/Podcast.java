package objetos;

public class Podcast extends Produccion {

    private int cantidadEpisodios;
    private String tematica;

    public Podcast(int id, String titulo, String genero, int anio, int cantidadEpisodios, String tematica) {

        super(id, titulo, genero, anio);

        this.cantidadEpisodios = cantidadEpisodios;
        this.tematica = tematica;
    }

    @Override
    public void publicar() {
        setEstado(EstadoProduccion.PUBLICADO);
    }

    @Override
    public void reproducir() throws ProduccionNoDisponibleException {

        if (getEstado() != EstadoProduccion.PUBLICADO) {
            throw new ProduccionNoDisponibleException("El podcast no está publicado.");
        }

        System.out.println("Reproduciendo podcast: " + getTitulo());
    }

    @Override
    public double getDuracion() {
        return cantidadEpisodios * 30;
    }

    public int getCantidadEpisodios() {
        return cantidadEpisodios;
    }

    public String getTematica() {
        return tematica;
    }

    public void setCantidadEpisodios(int cantidadEpisodios) {
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
}