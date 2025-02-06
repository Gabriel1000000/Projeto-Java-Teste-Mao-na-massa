# Projeto-Java-Teste-Mao-na-massa
 Este repositório contém a implementação de um teste prático para um processo seletivo, desenvolvido em Java. O objetivo do projeto é manipular uma lista de funcionários, aplicando operações como inserção, remoção, ordenação, filtragem e cálculos salariais.

---

## 📌 Funcionalidades Implementadas

- ✅ **Cadastro de Funcionários**: Adição de funcionários com nome, data de nascimento, salário e função.
- ✅ **Remoção de Funcionários**: Exclui um funcionário específico da lista.
- ✅ **Impressão Formatada**: Exibição dos dados dos funcionários no formato `dd/MM/yyyy`, com valores financeiros formatados corretamente.
- ✅ **Aumento Salarial**: Aplicação de um aumento de 10% no salário de todos os funcionários.
- ✅ **Agrupamento por Função**: Funcionários agrupados por sua função, utilizando `Map<String, List<Funcionario>>`.
- ✅ **Listagem Agrupada por Função**: Impressão dos funcionários organizados por função.
- ✅ **Filtragem por Aniversário**: Funcionários com aniversários nos meses de outubro e dezembro.
- ✅ **Identificação do Funcionário Mais Velho**: Cálculo da idade do funcionário mais velho.
- ✅ **Ordenação Alfabética**: Listagem de funcionários em ordem alfabética.
- ✅ **Cálculo do Total Salarial**: Soma de todos os salários dos funcionários.
- ✅ **Cálculo de Salários Mínimos**: Exibição de quantos salários mínimos cada funcionário recebe.

---

## 🛠️ Tecnologias Utilizadas

- **Java 8+**
- **API de Coleções**: `List`, `Map`, `ArrayList`, `HashMap`, `Collections`, `Comparator`
- **BigDecimal**: Cálculos financeiros precisos
- **LocalDate**: Manipulação de datas

---

## 🛠️ Como Instalar os Requisitos para Execução no VS Code

1. **Instale o Java JDK 17 ou superior**:
   - Baixe o JDK em: [Adoptium](https://adoptium.net/)

2. **Instale a Extensão Java no VS Code**:
   - Abra o VS Code.
   - Vá até a aba **Extensões** `(Ctrl + Shift + X)`.
   - Busque por **"Extension Pack for Java"** e instale.

---

### ▶️ Como Executar o Projeto
    
1. Clonar este repositório:
```
git clone https://github.com/Gabriel1000000/Projeto-Java-Teste-Mao-na-massa.git

```

2. Abra o projeto no Visual Studio Code (ou outra IDE de sua preferência).

3. Compile o projeto: Execute o comando abaixo para compilar os arquivos `.java` e gerar os `.class` na pasta `bin`.
```
javac -d bin src/*.java
```

4. Execute o programa: Para rodar o programa e ver os resultados no terminal, execute:
```
java -cp bin Principal
```

O programa irá imprimir a lista de funcionários no terminal!

