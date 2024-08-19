package one.digitalInnovation.gof.service.implementacao;

import one.digitalInnovation.gof.model.Cliente;
import one.digitalInnovation.gof.model.Endereco;
import one.digitalInnovation.gof.repository.ClienteRepository;
import one.digitalInnovation.gof.repository.EnderecoRepository;
import one.digitalInnovation.gof.service.ClienteService;
import one.digitalInnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> ClienteService, a qual pode ser
 * injetada pelo Spring via Autowired. Com isso, como essa classe é um
 * Service, ela será tratada como um <b>Singleton</b>.
 *
 */

@Service
public class ClienteServiceImplementacao implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        if (id == null) {
            return null;
        } else {
            Optional<Cliente> cliente = clienteRepository.findById(id);
            return cliente.get();
        }
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // buscar cliente por id, caso exista
        Optional<Cliente> clienteBd = clienteRepository.findById(id);

        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        // verificando se o Endereco do Cliente ja existe com base no cep
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // caso nao exista, integrar com ViaCEP e persistir o retorno;
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // inserindo Cliente vinculando o Endereco (novo ou existente)
        clienteRepository.save(cliente);
    }
}
