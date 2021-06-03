# Descrição das Classes

* Reservatório: é a classe que representa um reservatório de água. A classe tem atributos de informações sobre os niveis de água, e é nela que é feita a simulação do fluxo hidráulico, com metodos para captar água do reservatório definido como sua fonte.

* Valvula: é ligada ao reservatório para controlar o fluxo de água. O reservatório utiliza a abertura da valvula para calcular a quantidade de liquido que vai fluir entre os reservatorios.

* Registro: o registro de um reservatorio representa informações que vão ser utilizadas nos relatórios. Armazena a data do registro, o identificador do reservatorio e quanto foi consumido até a captura do registro.

* BancoDeDadosRegistro: esta classe conta com um CRUD para controlar um banco de dados onde vai ser armazenados os registros e tem métodos para retornar registros em listas com diferentes configurações

* Pessoa: representa os usuários do sistema. Seu tipo define as funcionalidades do sistema que ele vai poder acessar: o visitante apenas pode visualizar o sistema e ver os níveis de agua, o usuário é capas que gerar relatórios e o administrador pode controlar as válvulas da rede.

* BancoDeDadosPessoa: mantém um CRUD para controle do banco de dados que armazena os usuários e suas credenciais de acesso.

* GeradorDeArquivos: contém métodos para gerar arquivosem diferentes formatos com relatórios detalhados dos dados fornecidos
