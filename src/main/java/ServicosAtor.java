import java.util.ArrayList;
import java.util.List;

public class ServicosAtor {

    private static final List<Ator> arrayAtor = new ArrayList<>();

    public static void addAtor(Ator ator){
        arrayAtor.add(ator);
    }

    public static Ator cadastrarAtor(String nome, String cpf){
        Ator ator = new Ator(nome,cpf);
        addAtor(ator);
        return ator;
    }

    public static void listarAtor(){
        for (Ator ator: arrayAtor) {
            System.out.println("Nome do Ator: "+ator.getNome()+" CPF do ator: "+ator.getCpf());
        }
    }

    public static boolean deletarAtor(String nome){
        for (Ator ator: arrayAtor) {
            if (ator.getNome().equals(nome)){
                System.out.println("Ator: "+ator.getNome()+" foi removido com sucesso.");
                arrayAtor.remove(ator);
                return true;
            }
        }
        return false;
    }
}
