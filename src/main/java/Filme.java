import java.util.ArrayList;

public class Filme {
    private String nome;
    private int idade;
    private String sinopse;
    private Diretor diretor;
    private ArrayList<Ator> arrayDeAtor;

    public Filme(){}

    public Filme(String nome, int idade, String sinopse) {
        this.nome = nome;
        this.idade = idade;
        this.sinopse = sinopse;
        this.arrayDeAtor = new ArrayList<>();
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public ArrayList<Ator> getArrayDeAtor() {
        return arrayDeAtor;
    }

    public void addAtor(Ator ator) {
        arrayDeAtor.add(ator);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
}
