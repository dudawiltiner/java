

## Aceleração Java - RESUMOS E DICAS:

##### Módulo 1: Básico da Linguagem Java

##### Módulo 2: Herança, Encapsulamento e Polimorfismo

##### Módulo 3: Interface, Abstract Class, Reflection. Annotaion

DIFERENÇA ENTRE CLASSE ABSTRATA, CLASSE "NORMAL", INTERFACE

CLASSE "NORMAL" -> A classe que eu chamo de normal é aquela classe que pode ser uma SUPERCLASSE que pode ser estendida por uma CLASSE DERIVADA com o uso do extends ou ser instanciada como um objeto.

- Ela pode ser instanciada normalmente para criar um objeto
- Possui métodos que podem ter um body, sem ser somente assinados na classe, e atributos
- Todos os métodos são herdados e podem ser sobrescritos (polimorfismo)

A CLASSE DERIVA só pode herdar de apenas uma SUPERCLASSE ou CLASSE "NORMAL".
CLASSE ABSTRATA -> É a classe que vai servir como modelo para CLASSE CONCRETA que vai ser também uma extensão da CLASSE ABSTRATA.

- Ela NÃO pode ser instanciada normalmente para criar um objeto
- Possui métodos que NÃO podem ter um body, somente assinados na classe, e atributos
- Todos os métodos são herdados e podem ser sobrescritos (polimorfismo). Se um método herdado for - abstrato, obrigatoriamente o método deverá ser sobrescrito na CLASSE CONCRETA, para ela mesma não se tornar uma classe abstrata.

A CLASSE CONCRETA só pode herdar de apenas uma CLASSE ABSTRATA
INTERFACE -> É  um recurso de dita padrões através de contratos já definidos para as CLASSES que implementam esse recurso co,m o uso de implements.

- Ela NÃO pode ser instanciada normalmente para criar um objeto
- Possui métodos que NÃO podem ter um body, somente assinados na classe
- Todos os métodos assinados na Interface devem ser implementados dentro da CLASSE obrigatoriamente.
- A CLASSE pode implementar várias Interfaces.

##### Módulo 4: Criar Entidades de Banco de Dados

##### Módulo 5: Introdução à consultas ao Banco de Dados

