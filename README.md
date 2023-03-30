# API de Consulta de Endereço e Cálculo de Frete
Este é um projeto de API que permite consultar informações de endereço e calcular o valor do frete para um determinado CEP. A API consome a [API ViaCep](https://viacep.com.br/) e a especificação OpenAPI para documentação.

## Tecnologias Utilizadas

* Java ``versão 11``
* Spring boot ``versão 3.0.5``
* Spring Web ``versão 3.0.5``
* API REST Template ``versão 5.0``
* Lombok ``versão 1.18.26``
* Springdoc OpenAPI ``versão 2.0.0``
* Swagger ``versão 4.18.1``
* Maven ``versão 3.9.1``

Obs.: durante o desenvolvimento usei a versão 17 do Java, mas também testei na versão 11 e funcinou normal.

## Como executar o projeto
Para executar o projeto, siga as instruções abaixo:

  1. Clone o repositório para sua máquina local.

  2. Abra o projeto em uma IDE Java de sua escolha.

  3. Certifique-se de que todas as dependências do projeto estejam instaladas.

  4. Compile e execute o projeto.

## Como usar a API
Uma vez que a API está em execução, você pode usar o Swagger UI para explorar e testar as diferentes rotas. Para acessar o Swagger UI, abra o seguinte URL no seu navegador:

``
http://localhost:8080/swagger-ui.html
``

A partir daqui, você pode explorar as diferentes rotas, inserir os parâmetros necessários e testar a API.

## Endpoints
### Consulta de endereço

``GET /endereco/{cep}``

Retorna as informações de endereço para um determinado CEP. Com essas informações consegue calcular o valor o frete.

Parâmetros de entrada:

cep: O ``CEP`` a ser consultado.

Exemplo de resposta usando o ``CEP:01001000``

url: ``http://localhost:8080/endereco/01001000`` 

````
{
    "cep": "01001-000",
    
    "logradouro": "Praça da Sé",
    
    "complemento": "lado ímpar",
    
    "bairro": "Sé",
    
    "localidade": "São Paulo",
    
    "uf": "SP",
    
    "frete": 7.85
}
````

## Contribuindo
Este projeto é aberto para contribuições. Se você quiser contribuir com código, documentação ou correções de bugs, abra um pull request.

## Evidencias

* Chamada API via Postman

![chamada API via postman](https://github.com/Gilmar-moraes/API-Consulta-CEP/blob/master/evidencias/chamada%20API%20via%20postman.png?raw=true)

* Chamada API via Swagger

![chamada API via Swagger](https://github.com/Gilmar-moraes/API-Consulta-CEP/blob/master/evidencias/chamada%20API%20via%20Swagger.png?raw=true)
