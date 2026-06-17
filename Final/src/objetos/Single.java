package objetos;

public class Single extends Produccion {

    private double duracion;
    private boolean esColaboracion;

    public Single(int id, String titulo, String genero, int anio, double duracion, boolean esColaboracion) {

        super(id, titulo, genero, anio);

        this.duracion = duracion;
        this.esColaboracion = esColaboracion;
    }

    @Override
    public void publicar() {
        setEstado(EstadoProduccion.PUBLICADO);
    }

    @Override
    public void reproducir() throws ProduccionNoDisponibleException {

        if (getEstado() != EstadoProduccion.PUBLICADO) {
            throw new ProduccionNoDisponibleException("El single no está publicado.");
        }

        System.out.println("Reproduciendo single: " + getTitulo());
    }

    @Override
    public double getDuracion() {
        return duracion;
    }

    public boolean isEsColaboracion() {
        return esColaboracion;
    }

    public void setEsColaboracion(boolean esColaboracion) {
        this.esColaboracion = esColaboracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
}