package objetos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Repositorio implements IRepositorio {

    private File archivo;

    public Repositorio() {
        archivo = new File("producciones.dat");
    }

    @Override
    public Object guardar(Object obj) {

        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(obj);

            oos.close();
            fos.close();

        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }

        return obj;
    }

    @Override
    public List<?> consultar() {

        List<?> lista = new ArrayList<>();

        try {
            if (archivo.exists()) {
                FileInputStream fis = new FileInputStream(archivo);
                ObjectInputStream ois = new ObjectInputStream(fis);

                lista = (List<?>) ois.readObject();

                ois.close();
                fis.close();
            }

        } catch (Exception e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }

        return lista;
    }
}