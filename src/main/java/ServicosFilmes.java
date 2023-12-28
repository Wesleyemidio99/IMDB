import java.util.ArrayList;
import java.util.List;


public class ServicosFilmes {
    private static final List<Filme> filmes = new ArrayList<>();;

    public static void addFilme(Filme filme) {
        filmes.add(filme);
    }

    public static void listarFilme() {
        for (Filme filme : filmes) {
            System.out.println("Nome: " + filme.getNome() + " Classificação de idade: +" + filme.getIdade() + " Sinopse do filme: " + filme.getSinopse());
        }
    }

    public static void deletarFilme(Filme filme) {
        filmes.remove(filme);
    }

    public static boolean deletarFilme(String nomeFilme) {
        for (Filme f : filmes) {
            if (f.getNome().equals(nomeFilme)) {
                filmes.remove(f);
                return true;
            }
        }
        return false;
    }

    public static Filme getFilme(String nomeFilme){
        for (Filme f: filmes) {
            if(f.getNome().equals(nomeFilme)){
                return f;
            }
        }
        return null;
    }

    public static void cadastrarFilme(String nome,int idade,String sinopse){

        Filme filme = new Filme(nome,idade,sinopse);
        filmes.add(filme);

    }
}
