package siga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlunoDAOMemoria implements AlunoDAO {

    // Mudando para HashMap no intuito de fazer chave e valor
    private final Map<String, Aluno> armazem = new HashMap<>();

    @Override
    public void inserir(Aluno aluno) {
        // Verificando se o id da matricula já existe dentro do "banco" antes de tentar inserir
        if (armazem.containsKey(aluno.getMatricula())) {
            throw new IllegalStateException("Já existe aluno com a matrícula " + aluno.getMatricula());
        }
        armazem.put(aluno.getMatricula(), aluno);
    }

    @Override
    public Aluno buscarPorMatricula(String matricula) {
        return armazem.get(matricula);   // null se não encontrar
    }

    @Override
    public List<Aluno> listarTodos() {
        return new ArrayList<>(armazem.values());   // cópia defensiva
    }

    @Override
    public void atualizar(Aluno aluno) {
        // Implementação do método atualizar e lançamento de excepção caso não existir o Aluno
        if (!armazem.containsKey(aluno.getMatricula())) {
            throw new IllegalStateException("Aluno não encontrado: " + aluno.getMatricula());
        }
        armazem.put(aluno.getMatricula(), aluno);
    }

    @Override
    public void remover(String matricula) {
        if (armazem.remove(matricula) == null) {
            throw new IllegalStateException("Aluno não encontrado: " + matricula);
        }
    }
}
