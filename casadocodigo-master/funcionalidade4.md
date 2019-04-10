##Listar e alterar as permissões
Ao listar os usuários, ainda faltam os dados sobre as permissões (roles). Além disso, não há ainda nenhuma forma de alterar as permissões. Nessa tarefa vamos implementar esta funcionalidade. 
Você deve criar um novo formulário para alterar os roles e, ao atualizar a aplicação, deve redirecionar para a listagem dos usuários apresentando uma mensagem de sucesso.

Obs: Ao executar a "URL Mágica" já são cadastrados 3 roles: ROLE_ADMIN, ROLE_USER e ROLE_COMERCIAL*.

Views
A tabela de usuários deve ganhar mais duas colunas para mostrar as roles do usuário e outra para mostrar um botão de edição:

[Imagem] compressed_listar_usuarios_com_roles1.png

O formulário para alterar os roles mostra todos os roles cadastrados no banco. Para cada role deve existir uma checkbox:

[Imagem] compressed_form_roles.png

Repare também que o título mostra o nome do usuário.

Após a alteração, é preciso voltar para a listagem com uma mensagem de sucesso:

[Imagem] compressed_listar_usuarios_com_roles.png

##Segurança
Aqui também tem restrições. Apenas usuários com a permissão ADMIN podem alterar as permissões.

##Implementação
Para a implementação, use as classes já existentes como UsuarioController, UsuarioDao e RoleDao, além do modelo Usuario e Role.

O relacionamento entre Usuários e Roles é @ManyToMany (um usuários tem vários roles e um role pode ter vários usuários). a aula sobre relacionamentos JPA do tipo muitos para muitos se encontra aqui (https://cursos.alura.com.br/course/jpa-avancado/task/7234).

O Spring MVC possui uma tag form:checkboxes que pode ser utilizada.