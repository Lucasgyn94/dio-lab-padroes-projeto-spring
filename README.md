# Lab Padrões de Projeto com Spring
Este projeto demonstra a aplicação de diversos padrões de projeto GoF (Gang of Four) e outros, utilizando o framework Spring e a linguagem Java. O objetivo é apresentar exemplos práticos de como esses padrões podem ser implementados em um contexto real, tornando o código mais flexível, manutenível e escalável.

## Funcionalidades Principais
__Integração com API Externa (ViaCEP)__: O sistema consome a API do ViaCEP para buscar informações de endereço com base no CEP fornecido, demonstrando o uso do padrão Facade para simplificar a interação com a API externa.<br>
__Padrão Strategy__: A interface ClienteService e sua implementação ClienteServiceImplementacao ilustram o padrão Strategy, permitindo que diferentes estratégias de serviço ao cliente sejam facilmente intercambiáveis.<br>
__Padrão Singleton__: A classe ClienteServiceImplementacao é um Singleton, garantindo que haja apenas uma instância do serviço em toda a aplicação.<br>
__Persistência de Dados (Spring Data JPA)__: O projeto utiliza o Spring Data JPA para interagir com o banco de dados H2, facilitando o mapeamento objeto-relacional e a persistência de dados.<br>
__API REST (Spring Web)__: O ClienteRestController expõe endpoints REST para realizar operações CRUD (criar, ler, atualizar e deletar) em clientes, permitindo a interação com o sistema através de requisições HTTP.<br>
__OpenFeign__: A integração com a API do ViaCEP é feita usando o OpenFeign, um cliente HTTP declarativo que simplifica o consumo de APIs REST.<br>
__Lombok__: A biblioteca Lombok é utilizada para reduzir a quantidade de código boilerplate, gerando automaticamente getters, setters, construtores e outros métodos comuns.<br>

## Tecnologias Utilizadas
__Java 17__: A linguagem de programação principal do projeto.<br>
__Spring Boot__: Framework para desenvolvimento rápido de aplicações Spring, facilitando a configuração e o deployment.<br>
__Spring Data JPA__: Simplifica o acesso a dados em bancos de dados relacionais.<br>
__Spring Web__: Framework para construção de aplicações web e APIs REST.<br>
__Spring Cloud OpenFeign__: Cliente HTTP declarativo para consumo de APIs REST.<br>
__H2 Database__: Banco de dados em memória para desenvolvimento e testes.<br>
__Lombok__: Biblioteca para reduzir o código boilerplate.<br>
__Maven__: Ferramenta de gerenciamento de dependências e build do projeto.<br>

## Como Executar o Projeto

__Clone o Repositório:__
Bash
git clone https://github.com/Lucasgyn94/dio-lab-padroes-projeto-spring

__Navegue até o Diretório do Projeto:__
Bash
cd lab-padroes-projeto-spring

__Execute a Aplicação:__
Bash
./mvnw spring-boot:run 

__Acesse a API:__
* A API estará disponível em http://localhost:8080/clientes.
* Utilize uma ferramenta como o Postman ou o Insomnia para interagir com os endpoints da API.

## Contribuindo
Sinta-se à vontade para contribuir com o projeto, abrindo issues, enviando pull requests ou sugerindo melhorias. Toda contribuição é bem-vinda! 😊

## Autor
Lucasgyn94

## Licença
Este projeto está licenciado sob a licença MIT - consulte o arquivo LICENSE para mais detalhes.

## Observações
Este projeto foi desenvolvido como parte do bootcamp da Digital Innovation One.<br>
A API do ViaCEP possui limites de uso.<br>
Consulte a documentação da API para mais informações.
