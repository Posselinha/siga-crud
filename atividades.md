## Sua tarefa

Siga as etapas da ficha de atividade prática:

1. **Completar o CRUD** no `AlunoDAOMemoria`: impedir matrícula duplicada em `inserir` e implementar `atualizar`, verificando a existência do registro.
2. **Implementar a camada de serviço**: `consultar`, `alterar` e `excluir` no `ServicoAluno`, extraindo a validação para um método privado `validar(Aluno)` reutilizado pelas operações.
3. **Corrigir os três deslizes**: cópia defensiva em `listarTodos`, verificação de existência em `remover` e eliminação da validação duplicada na apresentação (a regra do domínio fica **apenas** no serviço).
4. **Tratar as exceções** na camada de apresentação, com mensagens claras e específicas — e sem blocos `catch` vazios.
5. **Consolidar a Etapa 1** no repositório, com README e commits descritivos.
