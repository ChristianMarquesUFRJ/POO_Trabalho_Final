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

Desenvolvimento explicativo do úlitmo tópico do enunciado.