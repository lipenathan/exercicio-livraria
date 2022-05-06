import com.github.lipenathan.exerciciolivraria.dao.LivroDao;
import com.github.lipenathan.exerciciolivraria.model.Livro;
import org.junit.jupiter.api.Test;

public class LivroDaoTeste {

    LivroDao livroDao = new LivroDao();

    @Test
    public void testeBuscaPorTitulo() {
        Livro livro = livroDao.buscarLivro("Senhor");
        System.out.println(livro);
    }
}