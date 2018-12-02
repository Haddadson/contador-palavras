# contador-palavras
Trabalho prático II da disciplina de Laboratório de Computação II do curso de Engenharia de Software - PUC Minas

## Proposta
Desenvolva um programa que leia um texto qualquer (arquivo no formato .txt) e imprima, em ordem alfabética, as palavras e a sua frequência no texto.

A leitura do arquivo deverá desprezar **espaços em branco** e **sinais de pontuação**, que serão considerados separadores de palavras. Além disso, a leitura deverá converter todas as letras maiúsculas em minúsculas. 

Você pode considerar que existem no máximo **1024** palavras diferentes no texto (de fato, considere as primeiras 1024 diferentes palavras que aparecerem no texto e despreze as seguintes novas palavras), e que cada palavra contém no máximo **20** letras.

A pesquisa e inserção das palavras do texto deverão ser implementadas com as seguintes estruturas:

 1.  **pseq** - Pesquisa Seqüencial
 2.  **pbinaria** - Pesquisa Binária
 3.  **arvore** - Árvore Binária de Pesquisa sem balanceamento
 4.  **haberto** - Hash - endereçamento aberto
 5.  **hlista** - Hash - lista encadeada

Coloque contadores no seu programa para determinar o número de **comparações** de chaves e atribuições de registros necessárias para montar a tabela de frequências em cada uma das estruturas acima (Apenas o número de comparações para montar a estrutura. Não é necessário considerar as comparações e atribuições para a impressão ordenada). 

Calcule também o **tempo** que cada estrutura leva apara montar a tabela. Análise através dos dados coletados o **desempenho / eficiência** de cada estrutura.

Use parâmetros de linha de comando para fazer sua chamada. Esse tipo de execução é bastante comum em sistemas *Unix / Linux* e no antigo *DOS*. 

Descubra como ler os parâmetros da **linha de comando** e defina (e documente) a sintaxe a ser utilizada.

Também faz parte do trabalho descobrir como fazer a **leitura** de um arquivo texto e a **manipulação** adequada de strings.

### Exemplos
No texto *“dois mais dois são quatro”* o seu programa deverá imprimir:

> dois 2

> mais 1

> quatro 1

> são 1

Se o seu programa chama-se Freq e você quiser contar a frequência do arquivo *texto.txt* utilizando um hash com endereçamento aberto, sua chamada deve ser:
>java -jar "dist\contador-palavras.jar" pbinaria src/Util/texto.txt

>Freq haberto texto.txt 

_É recomendável o uso da primeira opção devido à divisão das classes em pacotes._
