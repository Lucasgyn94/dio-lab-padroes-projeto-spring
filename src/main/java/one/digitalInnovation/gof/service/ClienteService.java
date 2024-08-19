package one.digitalInnovation.gof.service;

/*Interface que define o padrao Strategy no dominio de cliente
* Com isso, se necessario podemos ter multiplas implementacoes
* dessa interface
* */

import one.digitalInnovation.gof.model.Cliente;

public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
