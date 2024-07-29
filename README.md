#### 1. Introdução

Este projeto é um sistema de gerenciamento de clientes, produtos e vendas. Ele permite cadastrar, consultar, alterar e excluir clientes e produtos, além de gerenciar vendas, incluindo a adição e remoção de produtos em uma venda.

#### 2. Estrutura do Projeto

- `anotacao`: Contém anotações personalizadas.
- `dao`: Contém as classes DAO (Data Access Object) para acesso ao banco de dados.
- `domain`: Contém as classes de domínio do projeto.
- `exception`: Contém classes de exceção personalizadas.
- `services`: Contém as classes de serviço que implementam a lógica de negócios.
- `test.br.com.gpaiva`: Contém os testes unitários.

#### 3. Configuração do Ambiente

- **Java**: Versão 11 ou superior.
- **Maven**: Para gerenciamento de dependências.
- **IDE**: IntelliJ IDEA recomendada.

#### 4. Guia de Instalação

```bash
# Clone o repositório
git clone https://github.com/usuario/projeto.git

# Navegue até o diretório do projeto
cd projeto

# Compile o projeto
mvn clean install

# Execute os testes
mvn test
```

#### 5. Descrição das Classes Principais

##### Cliente

Classe que representa um cliente no sistema.

```java
public class Cliente implements Persistente {
    private String nome;
    private Long cpf;
    private Long tel;
    private String end;
    private Integer numero;
    private String cidade;
    private String estado;
    // Getters e Setters
}
```

##### Produto

Classe que representa um produto no sistema.

```java
public class Produto implements Persistente {
    private String codigo;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    // Getters e Setters
}
```

##### Venda

Classe que representa uma venda no sistema.

```java
public class Venda implements Persistente {
    private String codigo;
    private Cliente cliente;
    private Set<ProdutoQuantidade> produtos;
    private BigDecimal valorTotal;
    private Instant dataVenda;
    private Status status;
    // Métodos para adicionar e remover produtos
}
```

#### 6. Testes

Os testes estão localizados no pacote `test.br.com.gpaiva`. Para executar os testes, utilize o comando:

```bash
mvn test
```

#### 7. Exceções e Tratamento de Erros

##### TipoChaveNaoEncontradaException

Exceção lançada quando uma chave de tipo não é encontrada.

```java
public class TipoChaveNaoEncontradaException extends Exception {
    public TipoChaveNaoEncontradaException(String msg) {
        super(msg);
    }
}
```

#### 8. Anotações Personalizadas

##### TipoChave

Anotação usada para marcar o campo que será usado como chave.

```java
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {
    String value();
}
```

#### 9. Serviços e DAOs

##### ClienteService

Serviço para operações relacionadas a clientes.

```java
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }
    public Cliente buscarPorCPF(Long cpf) {
        return this.dao.consultar(cpf);
    }
}
```

##### ClienteDAO

DAO para operações de persistência de clientes.

```java
public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {
    public ClienteDAO() {
        super();
    }
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
        // Atualiza os dados do cliente
    }
}
```

