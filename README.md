# POO_Trabalho_Final
Implementação do backend de uma rede social, voltado a explorar os conceitos de POO.

## Relatório

Este projeto engloba a elaboração do backend de uma rede social genérica, contendo os testes unitários para a implementação das classes utilizadas.
O trabalho apresentado se baseia no enunciado definido e na imagem em diagrama, em que, a seguir, serão explicitados os principais pontos que divergem dessas referências.

* **Setts/Getts:** Foram criados praticamente todos os setts e getts, pois nunca se sabe em que momento deve ser utilizado. Pode ser que eu apague e logo em seguida precise, então sempre que criava o atributo já fazio o set/get caso esse atributo fosse acessível externamente;

* **Construtores:** Basicamente em quase todos os casos foi adicionado o contrutor vazio (caso precise) e o completo (particularmente prefiro esse, pois agiliza nos testes unitários). No caso de foto e vídeo que tem mais de um, mas nao foi tão necessário no final das contas;

* **Acesso a listas:** No caso das listas de comentários e de fotos, criei uns métodos para agilizarem o desenvolvimento e seus testes;

* **PostavelFactory:** Particularmente não gostei do único parâmetro que a mesma possui, se fosse fazer a minha, colocaria bem mais elementos de entrada naa função estática para receber a postagem pronta.

## Provocação Teórica

* **Singleton de conversão:** Fiquei tentado a implementar, mas pelo tempo apertado decidi não seguir adiante. Foi perceptível na questão da formatação do dia/horário que estava repetindo código na PostFoto e PostVideo, mas para não mudar muito o esquema, decidi seguir adiante. Mas seria a primeira modificação que faria para evoluir esse código. A implementação ocorreria deixando um método para receber um objeto do tipo *DateTimeLocal* e o mesmo retornaria a string formatada.

* **Singleton de feed:** Em termos de implementação, é o que falta para uma rede social. Faria um singleton que teria uma lista de postagens, com suas informações de publicação e seus atributos internos.

* **Postagens temporárias:** Criaria um **Observer** para ficar monitorando as datas iniciadas pelas postagens e o tempo atual do sistema e, dado o tempo definido em um **Singleton de Configuração**, ele avisaria para o *feed*, que iria remover a postagem da lista. Também precisaria de um atributo *boolean* em cada postagem dizendo se ela é ou não temporária.