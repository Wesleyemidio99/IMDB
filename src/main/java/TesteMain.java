import java.util.ArrayList;
import java.util.Scanner;

public class TesteMain {

    static int opcao;
    static ArrayList<Ator> arrayAtor = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {


        do {

            mostrarMenu();
            switch (opcao){
                case 0:
                    return;

                case 1:
                    menuFilme();
                    break;

                case 2:
                    menuDiretor();
                    break;

                case 3:
                    menuAtor();
                    break;

                default:
                    System.out.println("Valor incorreto digite novamente.");
                    break;

            }

        }while (true);

    }
    public static void mostrarMenu(){
        System.out.println("Digite a opção que deseja:");
        System.out.println("1 - Cadastrar filme.");
        System.out.println("2 - Cadastrar diretor");
        System.out.println("3 - Cadastrar Ator");
        System.out.println("0 - Voltar");
        opcao = Integer.parseInt(sc.nextLine());
    }

    public static void menuFilme(){

        do {
            System.out.println("1 - Cadastrar filme na lista:");
            System.out.println("2 - Listar os filmes");
            System.out.println("3 - Excluir filme da lista");
            System.out.println("0 - Voltar");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao){
                case 0 :
                    break;

                case 1:
                    cadastrarFilme();
                    break;

                case 2:
                    listaFilme();
                    break;

                case 3:
                    deletarFilme();
                    break;

                default:
                    System.out.println("Opção digitada incorreta, digite novamente.");
                    break;
            }

        }while(opcao != 0);
    }
    public static void cadastrarFilme(){
        String nome;
        int idade;
        String sinopse;

        System.out.println("Digite o nome do filme:");
        nome = sc.nextLine();
        System.out.println("Digite a faixa etaria do filme:");
        idade = Integer.parseInt(sc.nextLine());
        System.out.println("Digite a sinopse do filme:");
        sinopse = sc.nextLine();

        ServicosFilmes.cadastrarFilme(nome, idade,sinopse);
    }
    public static void listaFilme(){
        ServicosFilmes.listarFilme();
    }

    public static void deletarFilme(){
        String excluir;

        System.out.println("Digite o nome do filme que deseja excluir:");
        excluir = sc.nextLine();

        if(!ServicosFilmes.deletarFilme(excluir)){
            System.out.println("Filme não encontrado.");
        }

    }

    public static void menuDiretor(){
        do {
            System.out.println("1 - Cadastrar diretor");
            System.out.println("2 - Listar diretores");
            System.out.println("3 - Excluir diretores");
            System.out.println("4 - Listar filmes do diretor");
            System.out.println("0 - Voltar");
            System.out.println("Digite a opção que deseja:");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao){
                case 1:
                    cadastrarDiretor();
                    break;

                case 2:
                    listarDiretor();
                    break;

                case 3:
                    deletarDiretor();
                    break;

                case 4:


                default:
                    System.out.println("Opção incorreta, digite novamente.");
                    break;

            }

        }while (opcao != 0);
    }

    public static void cadastrarDiretor(){
        String nome;
        String cpf;

        System.out.println("Digite o nome do Diretor:");
        nome = sc.nextLine();
        System.out.println("Digite o CPF do Diretor:");
        cpf = sc.nextLine();

        System.out.println("Deseja associar a algum filme?");
        System.out.println("1 - Sim / 0 - Não");
        opcao = Integer.parseInt(sc.nextLine());
        if(opcao == 1){
            associarDiretor(ServicosDiretor.cadastrarDiretor(nome,cpf));
        }
        else {
            ServicosDiretor.cadastrarDiretor(nome,cpf);
            System.out.println("Diretor cadastro, sem associação de filme.");
        }
    }

    public static void listarDiretor(){
        ServicosDiretor.listarDiretor();
    }

    public static void deletarDiretor(){
        String nomeDiretor;

        System.out.println("Digite o nome do Diretor para excluir da lista: ");
        nomeDiretor = sc.nextLine();

        if (!ServicosDiretor.deletarFilme(nomeDiretor)){
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void menuAtor(){
        do {

            System.out.println("Digite a opção que deseja:");
            System.out.println("1 - Cadastrar Ator.");
            System.out.println("2 - Listar atores.");
            System.out.println("3 - Excluir ator.");
            System.out.println("0 - Voltar");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao){
                case 1:
                    cadastrarAtor();
                    break;

                case 2:
                    listarAtor();
                    break;

                case 3:
                    deletarAtor();
                    break;

                default:
                    System.out.println("Valor incorreto digite novamente.");
                    break;

            }


        }while(opcao != 0);
    }

    public static void cadastrarAtor(){
        String nome;
        String cpf;

        System.out.println("Digite o nome do Ator: ");
        nome = sc.nextLine();
        System.out.println("Digite o CPF do ator: ");
        cpf = sc.nextLine();
        System.out.println("Deseja associar a algum filme?");
        System.out.println("1 - Sim / 0 - Não");
        opcao = Integer.parseInt(sc.nextLine());
        if(opcao == 1){
            associarAtor(ServicosAtor.cadastrarAtor(nome,cpf));
        }
        else {
            ServicosAtor.cadastrarAtor(nome,cpf);
            System.out.println("Diretor cadastro, sem associação de filme.");
        }


    }

    public static void listarAtor(){
        ServicosAtor.listarAtor();
    }

    public static void deletarAtor(){
        String nomeAtor;

        System.out.println("Digite o nome do ator que deseja excluir: ");
        nomeAtor = sc.nextLine();

        if (!ServicosAtor.deletarAtor(nomeAtor)){
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void associarDiretor(Diretor diretor){
        listaFilme();
        String nomeDoFilme;

        do {
            System.out.println("Digite o nome do filme.");
            nomeDoFilme = sc.nextLine();

            Filme filme = ServicosFilmes.getFilme(nomeDoFilme);
            if (filme == null){
                System.out.println("Filme nao encontrado, digite novamente.");
            }
            else {
                filme.setDiretor(diretor);
                return;
            }

        }while(true);

    }

    public static void associarAtor(Ator ator){

        listaFilme();
        String nomeDoFilme;

        do {
            System.out.println("Digite o nome do filme:");
            nomeDoFilme = sc.nextLine();

            Filme filme = ServicosFilmes.getFilme(nomeDoFilme);
            if (filme == null){
                System.out.println("Filme nao encontrado, digite novamente.");
            }else {
                filme.addAtor(ator);
            }

        }while(true);

    }

}
