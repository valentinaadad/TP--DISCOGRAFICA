package objetos;

public class Album extends Produccion {

    private int cantidadPistas;
    private double duracionTotal;

    public Album(int id, String titulo, String genero, int anio, int cantidadPistas, double duracionTotal) {
        super(id, titulo, genero, anio);
        this.cantidadPistas = cantidadPistas;
        this.duracionTotal = duracionTotal;
    }

    @Override
    public void publicar() {
        setEstado(EstadoProduccion.PUBLICADO);
    }

    @Override
    public void reproducir() throws ProduccionNoDisponibleException {
        if (getEstado() != EstadoProduccion.PUBLICADO) {
            throw new ProduccionNoDisponibleException("El álbum no está publicado.");
        }

        System.out.println("Reproduciendo álbum: " + getTitulo());
    }

    @Override
    public double getDuracion() {
        return duracionTotal;
    }

    public int getCantidadPistas() {
        return cantidadPistas;
    }

    public double getDuracionTotal() {
        return duracionTotal;
    }

    public void setCantidadPistas(int cantidadPistas) {
        this.cantidadPistas = cantidadPistas;
    }

    public void setDuracionTotal(double duracionTotal) {
        this.duracionTotal = duracionTotal;
    }
}