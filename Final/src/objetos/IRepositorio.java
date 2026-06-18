package objetos;
import java.util.List;

public interface IRepositorio {

    Object guardar(Object objeto);
    
    List <?> consultar();
}
