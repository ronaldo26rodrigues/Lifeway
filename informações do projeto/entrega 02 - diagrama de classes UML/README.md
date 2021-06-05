# Descrição das Classes

* Reservatório: é a classe que representa um reservatório de água. A classe tem atributos de informações sobre os niveis de água, e é nela que é feita a simulação do fluxo hidráulico, com metodos para captar água do reservatório definido como sua fonte.

* Manancial: representa a fonte natural de agua, um rio, lago, lençol freatico, etc.

* ETA: Estação de tratamento de água. A agua passa por aqui para o controle de qualidade e apresenta informações uteis sobre esta qualidade.

* Valvula: é ligada ao reservatório para controlar o fluxo de água. O reservatório utiliza a abertura da valvula para calcular a quantidade de liquido que vai fluir entre os reservatorios.

* Registro: o registro de um reservatorio representa informações que vão ser utilizadas nos relatórios. Armazena a data do registro, o identificador do reservatorio e quanto foi consumido até a captura do registro.

* Consumidor: é a entidade que vai consumir a agua da rede.
    * Casa: um Consumidor que tem um número de moradores e informa seu total consumido.
    * ConjuntoHabitacional: um conjunto de casas que informa o total consumido por estas.
    * Industrial: TODO: fatores que definem sua forma de consumir água 

* Pessoa: representa os usuários do sistema. Seu tipo define as funcionalidades do sistema que ele vai poder acessar: o visitante apenas pode visualizar o sistema e ver os níveis de agua, o usuário é capas que gerar relatórios e o administrador pode controlar as válvulas da rede.
