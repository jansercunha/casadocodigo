##Novo Web Service Relatório de Produtos
O nosso sistema já sabe trabalhar com produtos (livros), mas agora também queremos oferecer os dados dos produtos para outros sistemas. Essa integração deve funcionar através de um web service que mostra os produtos cadastrados junto com uma data da geração do relatório e a quantidade de produtos. Além disso, deve ser possível filtrar os produtos pela data de lançamento. Ao enviar a data pelo serviço apenas devem aparecer produtos lançados após essa data.

##URI e Parâmetro do serviço
O web service deve atender à URI abaixo:

http://localhost:8080/casadocodigo/relatorio-produtos

Como falamos, existe um parâmetro data que é opcional. Ou seja, o web service deve funcionar sem ou com parâmetro. Ele serve para filtrar o retorno pela data de lançamento dos livros:

http://localhost:8080/casadocodigo/relatorio-produtos?data=2017-03-21
Nesse exemplo queremos receber todos os livros lançados após o dia 21/03/2017.

##Método HTTP
O nosso web service deve atender apenas o método GET do protocolo HTTP. Outros métodos HTTP não são suportados.

##Retorno do web service
O web service deve devolver um JSON como retorno que precisa ter uma estrutura bem definida para garantir a maior facilidade na integração com outros sistemas. Segue um exemplo de um retorno com apenas dois produtos:

{
  "dataGeracao": 1527187651215,
  "quantidade": 2,
  "produtos": [
    {
      "id": 1,
      "titulo": "Java SE 8 Programmer I",
      "descricao": "O guia para sua certificação Oracle Certified Associate",
      "paginas": 502,
      "sumarioPath": "/arquivos-sumario/java_se8.png",
      "precos": [
        {
          "valor": 29.90,
          "tipo": "EBOOK"
        },
        {
          "valor": 49.90,
          "tipo": "IMPRESSO"
        },
        {
          "valor": 79.90,
          "tipo": "COMBO"
        }
      ],
      "dataLancamento": 1468551600000
    },
    {
      "id": 2,
      "titulo": "Orientação a Objetos",
      "descricao": "Aprenda seus conceitos e suas aplicabilidades de forma efetiva",
      "paginas": 172,
      "sumarioPath": "/arquivos-sumario/oo_conceitos.png",
      "precos": [
        {
          "valor": 19.90,
          "tipo": "EBOOK"
        },
        {
          "valor": 29.90,
          "tipo": "IMPRESSO"
        },
        {
          "valor": 49.90,
          "tipo": "COMBO"
        }
      ],
      "dataLancamento": 1513821600000
    }
  ]
}


##Segurança
Não há restrições de segurança para acessar esse serviço.

##Implementação
A implementação do serviço deve ser feita dentro de uma nova classe com o nome RelatorioProdutosController. O acesso ao banco de dados deve ser feito dentro do ProdutoDAO. Você pode ver uma implementação de um web service nessa aula.(https://cursos.alura.com.br/course/springmvc-2-integracao-cache-seguranca-e-templates/task/12233)