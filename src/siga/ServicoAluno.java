package siga;

import java.util.List;

public class ServicoAluno {

    private final AlunoDAO dao;

    public ServicoAluno(AlunoDAO dao) {   // injeção de dependência (DIP)
        this.dao = dao;
    }

    public void cadastrar(Aluno aluno) {
        validar(aluno);
        if (dao.buscarPorMatricula(aluno.getMatricula()) != null) {
            throw new IllegalStateException("Matrícula já cadastrada.");
        }
        dao.inserir(aluno);
    }

    public Aluno consultar(String matricula) {
        Aluno aluno = dao.buscarPorMatricula(matricula);
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado: " + matricula);
        }
        return aluno;
    }

    public List<Aluno> listar() {
        return dao.listarTodos();
    }

    public void alterar(Aluno aluno) {
        validar(aluno);
        consultar(aluno.getMatricula());   // garante que existe
        dao.atualizar(aluno);
    }

    public void excluir(String matricula) {
        consultar(matricula);              // garante que existe
        dao.remover(matricula);
    }

    private void validar(Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (aluno.getMedia() < 0 || aluno.getMedia() > 10) {
            throw new IllegalArgumentException("Média deve estar entre 0 e 10.");
        }
    }
}
