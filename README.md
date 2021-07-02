# DesafioCapgemini
A agência Divulga Tudo precisa de um programa para gerenciar os seus anúncios online. O objetivo dos anúncios faz parte de uma campanha nas redes sociais. O sistema de gerenciamento permitirá a gestão do anúncio e o rastreio dos resultados da campanha.

# Instalação
Para executar o programa é necessário seguir os seguintes passos: 
1. Xampp - para iniciar o MySQL no localhost porta 3306(porta padrão).
2. MySQL Workbench - Para executar o arquivo `bd/bd.sql` e instanciar a tabela do sistema.
3. IDE Java* - Para adicionar as bibliotecas o arquivo de conexão com o MYSQL `lib/mysql-connector-java-8.0.25.jar` na BuildPath do projeto.
4. IDE Java - Para executar o arquivo `src/main/Main.java` e testar as funcionalidades do sistema.

*Recomendo utilizar a IDE Eclipse 2020-12, ambiente onde o presente projeto foi desenvolvido.

# Visão Geral
O sistema foi desenvolvido na linguagem de programação Java, utilizando a IDE Eclipse versão 2021-12 e Java 11. Antes de executar o programa é necessário seguir os passos de instalação acima.
O projeto possui persistência em CSV e MySQL, que são iniciadas assim que é realizado o primeiro cadastro.  
Para realizar a persistência foi utilizado injeção de dependência para se manter um baixo nível de acoplamento entre as classes `src/BO/Gravacao.java`, `src/BO/Persistencia.java`, `src/BO/GravarCSV.java` e `src/BO/GravarBD.java`.

# Documentação
A documentação do projeto está disponível em `src/doc`, onde sua organização é espelhada de acordo com o diretório do arquivo que deseja verificar. Por exemplo: A documentação do arquivo `src/DTO/CalculadoraAnuncios.java` estará em `src/doc/DTO/CalculadoraAnuncios.java`.

# Classe da Calculadora
A classe responsável pela parte 1 do desafio está no diretório: `src/DTO/Calculadora.java`.

# Testes Unitários
Os testes se encontram no diretório `src/test`.
