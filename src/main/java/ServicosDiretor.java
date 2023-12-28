import java.util.ArrayList;
import java.util.List;

public class ServicosDiretor {

    private static final List<Diretor> arrayDiretor = new ArrayList<>();

    public static void addDiretor(Diretor diretor){
        arrayDiretor.add(diretor);
    }

    public static boolean deletarFilme(String nomeFilme){
        for (Diretor diretor: arrayDiretor) {
            if (diretor.getNome().equalsIgnoreCase(nomeFilme)){
                arrayDiretor.remove(diretor);
                return true;
            }
        }
        return false;
    }

    public static void listarDiretor(){
        for (Diretor diretor: arrayDiretor) {
            System.out.println("Nome: "+diretor.getNome()+" CPF: "+diretor.getCpf());
        }
    }

    public static Diretor cadastrarDiretor(String nome, String cpf){

        Diretor diretor = new Diretor(nome,cpf);
        arrayDiretor.add(diretor);
        return diretor;
    }

}
