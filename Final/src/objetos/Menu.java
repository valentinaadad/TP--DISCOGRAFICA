package objetos;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Discografica discografica;

    public Menu() {
        scanner = new Scanner(System.in);
        discografica = new Discografica();
        discografica.cargarProducciones();
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
            System.out.println("Ingrese la opcion deseada:");


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
                    discografica.guardarProducciones();
                    System.out.println("Ha salido del sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    public void registrarArtista() {
        System.out.println("Ingrese DNI:");
        int dni = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese apellido:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese nombre artístico:");
        String nombreArtistico = scanner.nextLine();

        Artista artista = new Artista(dni, nombre, apellido, nombreArtistico);
        discografica.registrarPersona(artista);

        System.out.println("Artista registrado correctamente.");
    }

    public void agregarProduccion() {
        System.out.println("Seleccione tipo de producción:");
        System.out.println("1. Álbum");
        System.out.println("2. Single");
        System.out.println("3. Podcast");

        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese título:");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese género:");
        String genero = scanner.nextLine();

        System.out.println("Ingrese año:");
        int anio = scanner.nextInt();
        scanner.nextLine();

        Produccion produccion = null;

        if (tipo == 1) {
            System.out.println("Ingrese cantidad de pistas:");
            int cantidadPistas = scanner.nextInt();

            System.out.println("Ingrese duración total:");
            double duracionTotal = scanner.nextDouble();
            scanner.nextLine();

            produccion = new Album(id, titulo, genero, anio, cantidadPistas, duracionTotal);

        } else if (tipo == 2) {
            System.out.println("Ingrese duración:");
            double duracion = scanner.nextDouble();

            System.out.println("¿Es colaboración? true/false:");
            boolean esColaboracion = scanner.nextBoolean();
            scanner.nextLine();

            produccion = new Single(id, titulo, genero, anio, duracion, esColaboracion);

        } else if (tipo == 3) {
            System.out.println("Ingrese cantidad de episodios:");
            int cantidadEpisodios = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese temática:");
            String tematica = scanner.nextLine();

            produccion = new Podcast(id, titulo, genero, anio, cantidadEpisodios, tematica);

        } else {
            System.out.println("Tipo de producción inválido.");
        }

        if (produccion != null) {
            discografica.agregarProduccion(produccion);
            System.out.println("Producción agregada correctamente.");
        }
    }

    public void publicarProduccion() {
        System.out.println("Ingrese el título de la producción a publicar:");
        String titulo = scanner.nextLine();

        Produccion produccion = discografica.buscarProduccion(titulo);

        if (produccion != null) {
            produccion.publicar();
            System.out.println("Producción publicada correctamente.");
        } else {
            System.out.println("No se encontró la producción.");
        }
    }

    public void reproducirProduccion() {
        try {
            System.out.println("Ingrese el título de la producción a reproducir:");
            String titulo = scanner.nextLine();

            Produccion produccion = discografica.buscarProduccion(titulo);

            if (produccion != null) {
                produccion.reproducir();
            } else {
                System.out.println("No se encontró la producción.");
            }

        } catch (ProduccionNoDisponibleException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Operación de reproducción finalizada.");
        }
    }

    public void mostrarPublicadas() {
        discografica.mostrarPublicadas();
    }

    public void mostrarCatalogo() {
        discografica.mostrarOrdenadas();
    }
}