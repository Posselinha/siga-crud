## Estrutura do projeto

```
siga-crud/
└── src/
    └── siga/
        ├── Aluno.java             (entidade de domínio; pronta)
        ├── AlunoDAO.java          (interface do DAO, da Aula 7; pronta)
        ├── AlunoDAOMemoria.java   (CRUD incompleto + deslizes 1 e 2)
        ├── ServicoAluno.java      (camada de serviço incompleta + deslize 3)
        └── Main.java              (apresentação; demonstra os deslizes)
```

## Como compilar e executar

Pré-requisito: JDK 17 ou superior (`java -version` para verificar).

```bash
# 1. Compilar (a saída vai para a pasta "bin")
javac -d bin src/siga/*.java

# 2. Executar
java -cp bin siga.Main
```

## Consolidação da ETAPA 1

Para impedir a matricula duplicada no inserir, é primeiro realizado uma verificação se a matricula já existe, e caso exista, impedir a inserção dela dentro do banco. Atualizar é implementado com uma verificação se a matricula existe dentro do banco, que dá erro caso não existir, e logo após isso reescrever o devido valor.
