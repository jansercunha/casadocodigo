#Consumidor do Serviço Pedidos

Nessa funcionalidade também trabalharemos com a integração de aplicações, mas desta vez você precisa acessar um web service externo e apresentar os dados desse serviço dentro da nossa aplicação. Em outras palavras, você deve criar um consumidor de um serviço e preparar os dados no formato HTML.

##URI do Serviço externo
Você já pode acessar o serviço externo através da URI:

https://book-payment.herokuapp.com/orders

O retorno é um JSON com vários pedidos que contém produtos. No exemplo abaixo tem listado uma parte do retorno desse serviço:

[
  {
    "id": 2316,
    "valor": 235.92,
    "data": 1542765600000,
    "produtos": [
      {
        "titulo": "Cangaceiro JavaScript",
        "descricao": "Uma aventura no sertão da programação",
        "paginas": 502,
        "precos": [
          {
            "valor": 29.9,
            "tipo": "EBOOK"
          },
          {
            "valor": 39.9,
            "tipo": "IMPRESSO"
          },
          {
            "valor": 59.9,
            "tipo": "COMBO"
          }
        ],
        "dataLancamento": 1468551600000
      },
      {
        "titulo": "Bootstrap 4",
        "descricao": "Conheça a biblioteca front-end mais utilizada no mundo",
        "paginas": 172,
        "precos": [
          {
            "valor": 19.9,
            "tipo": "EBOOK"
          },
          {
            "valor": 39.9,
            "tipo": "IMPRESSO"
          },
          {
            "valor": 49.9,
            "tipo": "COMBO"
          }
        ],
        "dataLancamento": 1513821600000
      }
    ]
  },
  {
    "id": 4125,
    "valor": 68.76,
    "data": 1539226800000,
    "produtos": [
      {
        "titulo": "Spring MVC",
        "descricao": "Domine o principal framework web Javao",
        "paginas": 260,
        "precos": [
          {
            "valor": 19.9,
            "tipo": "EBOOK"
          },
          {
            "valor": 29.9,
            "tipo": "IMPRESSO"
          },
          {
            "valor": 39.9,
            "tipo": "COMBO"
          }
        ],
        "dataLancamento": 1519959600000
      }
    ]
  },
  [...]
]
Repare que temos dois pedidos (ID: 2316 e ID: 4125). O primeiro tem dois produtos associados, o segundo apenas um.

##View e URI da aplicação
Você deve criar uma página pedidos.jsp que apresenta os pedidos do serviço dentro de uma tabela:



A página deve aproveitar o template já criado. Nela, basta mostrar uma tabela com os pedidos onde cada coluna apresenta:

ID
Valor
Data Pedido
Titulos dos produtos

##URI na aplicação
Para acessar a funcionalidade use a URL /pedidos:

http://localhost:8080/casadocodigo/pedidos

##Menu
Adicione um link no menu para a URL /pedidos como apresentado na imagem acima. Coloque o texto do link dentro dos arquivos messages.properties (PT, EN).

##Segurança
Há uma restrição referente a essa funcionalidade. Apenas usuários com a permissão ADMIN podem ver o link no menu e acessar a URI /pedidos.

##Implementação
O controller que implementa essa funcionalidade deve se chamar PedidosServicoController. Você deve usar o RestTemplate para receber os dados usado nessa aula.
https://cursos.alura.com.br/course/spring-mvc-1-criando-aplicacoes-web/task/11488