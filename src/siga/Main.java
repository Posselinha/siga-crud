package siga;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade CRUD e Etapa 1 (código inicial) ===\n");

        AlunoDAO dao = new AlunoDAOMemoria();
        ServicoAluno servico = new ServicoAluno(dao);

        cadastrar(servico, new Aluno("Maria Silva", "2026001", 8.5));
        cadastrar(servico, new Aluno("João Souza", "2026002", 6.0));
        System.out.println();

        cadastrar(servico, new Aluno("Maria Silva", "2026001", 8.5));

        System.out.println("Alunos cadastrados:");
        for (Aluno aluno : servico.listar()) {
            System.out.println("  " + aluno);
        }

        System.out.println("\nTentando consultar aluno que não existe");
        consultar(servico, "2026001");
        consultar(servico, "0000000");

        List<Aluno> lista = servico.listar();
        lista.add(new Aluno("Intruso Silva", "9999999", 10));
        System.out.println("\nImpedido inserir diretamente na lista, utilização de cópia defensiva");
        for (Aluno aluno : servico.listar()) {
            System.out.println("  " + aluno);
        }

        System.out.println("\nTentando realizar exclusão de matrícula inexistente:");
        excluir(servico, "0000000");

        System.out.println("\nTentando inserir média fora do limite:");
        Aluno suspeito = new Aluno("Média Absurda", "2026003", 50);
        cadastrar(servico, suspeito);

        System.out.println();
        alterar(servico, new Aluno("Maria Silva", "2026001", 9.0));

        System.out.println("\nListando após alteração:");
        for (Aluno aluno : servico.listar()) {
            System.out.println("  " + aluno);
        }
    }

    /**
     * Apresentação: traduz as exceções do serviço em mensagens ao usuário.
     */
    private static void cadastrar(ServicoAluno servico, Aluno aluno) {
        try {
            servico.cadastrar(aluno);
            System.out.println("Cadastrado: " + aluno);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Não foi possível cadastrar: " + e.getMessage());
        }
    }

    private static void consultar(ServicoAluno servico, String matricula) {
        try {
            Aluno aluno = servico.consultar(matricula);
            System.out.println("Encontrado: " + aluno);
        } catch (IllegalArgumentException e) {
            System.out.println("Não foi possível consultar: " + e.getMessage());
        }
    }

    private static void alterar(ServicoAluno servico, Aluno aluno) {
        try {
            servico.alterar(aluno);
            System.out.println("Alterado: " + aluno);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Não foi possível alterar: " + e.getMessage());
        }
    }

    private static void excluir(ServicoAluno servico, String matricula) {
        try {
            servico.excluir(matricula);
            System.out.println(matricula + " foi excluído.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Não foi possível excluir: " + e.getMessage());
        }
    }
}
