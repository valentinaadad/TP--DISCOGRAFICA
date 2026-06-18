package objetos;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Discografica discografica;

    public Menu() {
        scanner = new Scanner(System.in);
        discografica = new Discografica();
    }

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n-------- MENÚ --------");
            System.out.println("1. Registrar artista");
            System.out.println("2. Agregar producción");
            System.out.println("3. Publicar producción");
            System.out.println("4. Reproducir producción");
            System.out.println("5. Mostrar producciones publicadas");
            System.out.println("6. Mostrar catálogo ordenado por título");
            System.out.println("0. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarArtista();
                    break;
                case 2:
                    agregarProduccion();
                    break;
                case 3:
                    publicarProduccion();
                    break;
                case 4:
                    reproducirProduccion();
                    break;
                case 5:
                    mostrarPublicadas();
                    break;
                case 6:
                    mostrarCatalogo();
                    break;
                case 0:
                    System.out.println("Ha salido del sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    public void registrarArtista() {
        // pedir datos y llamar a discografica.registrarArtista(...)
    }

    public void agregarProduccion() {
        // pedir datos y llamar a discografica.agregarProduccion(...)
    }

    public void publicarProduccion() {
        // pedir código y llamar a discografica.publicarProduccion(...)
    }

    public void reproducirProduccion() {
        // pedir código y llamar a discografica.reproducirProduccion(...)
    }

    public void mostrarPublicadas() {
        // recorrer las producciones publicadas e imprimirlas
    }

    public void mostrarCatalogo() {
        // mostrar el catálogo ordenado
    }
}
