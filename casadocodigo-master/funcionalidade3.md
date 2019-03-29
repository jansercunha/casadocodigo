##Cadastro de usuários
O nosso sistema já está fazendo um login através de um usuário cadastrado diretamente no banco de dados. No entanto não temos um formulário para cadastrar novos usuários. Nessa tarefa você deve criar um formulário com os dados principais do usuário e listar todos eles.

Obs: Nessa tarefa ainda não vamos trabalhar com as permissões (Role). A "URL Mágica" já cadastra um usuário admin com permissões.

##Dados do formulário
O cadastro do usuário deve ter os campos nome, email, senha, além de um segundo campo de senha para repetir a senha.

Segue uma possível visualização do formulário para cadastrar o usuário:

http://localhost:8080/casadocodigo/usuarios/form

<<imagem>>

E a listagem dos usuários fica:

http://localhost:8080/casadocodigo/usuarios

<<imagem>>

O design do formulário e listagem não é importante na avaliação, o que importa é a funcionalidade.

##Validação dos dados
Todos os campos do formulário são obrigatórios. Além disso, a senha deve ter no mínimo 5 caracteres e deve ser idêntica à senha repetida. Também deve ser validado se já existe um usuário com mesmo e-mail cadastrado.

##Fluxo
Após cadastrar com sucesso, o fluxo deve ser redirecionado para a listagem dos usuários. Em caso de erros de validação devemos ficar na página com o formulário. Na listagem dos usuários deve ter um link "Novo usuário" para ir para o formulário. A URL para chamar a listagem dos usuários deve se chamar /usuários.

##Detalhes das Views
Você deve implementar as views para o formulário e a listagem dos usuários, sempre usando o template já existente no projeto.

Os erros de validação devem ser apresentados no formulário. Ao cadastrar o novo usuário deve aparecer uma mensagem de sucesso também.

No menu deve aparecer um link para acessar a listagem de usuários e ela possui um link para chegar no formulário como apresentado nas imagens acima. O texto do link deve ser colocado no menu.properties (EN,PT).

##Segurança
Há restrições referente a essa funcionalidade. Apenas usuários com a permissão ADMIN podem ver o link no menu e acessar qualquer URL relacionada aos usuários.

##Implementação e dicas
O controller que implementa essa funcionalidade deve se chamar UsuarioController. Além disso, organize e crie as outras classes dentro dos pacotes já existentes.

O cadastro de usuários é parecido com o cadastro de produtos apresentados nas aulas do primeiro curso Spring MVC.