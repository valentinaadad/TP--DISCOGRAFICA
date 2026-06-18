package objetos;

import java.io.File;
import java.util.List;

public class Repositorio implements IRepositorio {

    private File archivo;

    public Repositorio() {
        archivo = new File("producciones.dat");
    }

    @Override
    public Object guardar(Object objeto) {
        return objeto;
    }

    @Override
    public List<?> consultar() {
        return null;
    }


    
}
