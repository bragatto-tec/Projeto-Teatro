# PROJETO MACK THEATER

**Sistema de Gerenciamento de Teatro com Venda de Ingressos**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-Oriented-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)

*Construído com as ferramentas e tecnologias de Programação Orientada a Objetos*

---

## 📋 Tabela de Conteúdo

- [Visão Geral](#-visão-geral)
- [Funcionalidades](#-funcionalidades)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Diagrama de Classes](#-diagrama-de-classes)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação](#-instalação)
- [Utilização](#-utilização)
- [Exemplos de Uso](#-exemplos-de-uso)
- [Tecnologias](#-tecnologias)
- [Contribuindo](#-contribuindo)
- [Licença](#-licença)
- [Contato](#-contato)

---

## 🎯 Visão Geral

O **Mack Theater** é um sistema completo de gerenciamento de teatro que permite o cadastro de espetáculos, clientes e a venda de ingressos com diferentes tipos de entrada. Desenvolvido utilizando os princípios da Programação Orientada a Objetos, o sistema oferece uma solução robusta e extensível para a administração de eventos teatrais.

### Por que Mack Theater?

Este projeto demonstra a aplicação prática de conceitos fundamentais de POO, oferecendo:

- 🎭 **Gestão Completa de Espetáculos**: Cadastro e organização de eventos teatrais com controle de assentos em tempo real.

- 👥 **Gerenciamento de Clientes**: Sistema de cadastro com validação de CPF e histórico de compras.

- 🎫 **Sistema de Vendas Inteligente**: Suporte para múltiplos tipos de entrada (inteira, meia e professor) com cálculos automáticos de valores.

- 💺 **Controle de Assentos**: Visualização gráfica dos assentos disponíveis e ocupados com capacidade para 50 lugares.

- 🛒 **Carrinho de Compras**: Sistema de pedidos que permite adicionar múltiplas entradas antes da finalização.

- 🔧 **Arquitetura Extensível**: Estrutura orientada a objetos que facilita manutenção e adição de novas funcionalidades.

---

## ✨ Funcionalidades

### 🎭 Gestão de Espetáculos
- Cadastro completo de espetáculos (nome, data, hora e preço)
- Controle automático de 50 assentos por espetáculo
- Visualização gráfica dos assentos disponíveis e ocupados
- Listagem de todos os espetáculos cadastrados

### 👤 Gestão de Clientes
- Cadastro de clientes com nome e CPF
- Validação de CPF duplicado
- Histórico automático de pedidos por cliente
- Busca rápida de clientes por CPF

### 🎟️ Sistema de Vendas
- Seleção de espetáculo disponível
- Visualização em tempo real dos assentos
- Três tipos de entrada:
  - **Inteira**: Preço integral do espetáculo
  - **Meia**: 50% de desconto (0.5x)
  - **Professor**: 60% de desconto (0.4x)
- Carrinho de compras com múltiplas entradas
- Validação automática de assentos ocupados
- Cálculo automático do valor total

### 📊 Controle de Reservas
- Bloqueio automático de assentos ocupados
- Marcação visual (XX) para assentos indisponíveis
- Numeração sequencial de 01 a 50
- Impossibilidade de venda duplicada do mesmo assento

---

## 🏗️ Estrutura do Projeto

```
mack-theater/
│
├── Main.java                    # Ponto de entrada e interface do usuário
├── Teatro.java                  # Gerenciador central do sistema
├── Cliente.java                 # Entidade Cliente
├── Espetaculo.java             # Entidade Espetáculo
├── Pedido.java                 # Carrinho de compras
│
└── Tipos de Entrada (Herança):
    ├── Entrada.java            # Classe abstrata base
    ├── EntradaInteira.java     # Entrada com preço integral
    ├── EntradaMeia.java        # Entrada com 50% de desconto
    └── EntradaProfessor.java   # Entrada com 60% de desconto
```

---

## 📐 Diagrama de Classes

### Hierarquia de Entradas (Polimorfismo)

```
         Entrada (abstract)
              |
    +----------+----------+
    |          |          |
EntradaInteira  EntradaMeia  EntradaProfessor
  (100%)        (50%)         (40%)
```

### Relacionamentos Principais

- **Teatro** ⟶ gerencia múltiplos **Espetáculos**
- **Teatro** ⟶ gerencia múltiplos **Clientes**
- **Cliente** ⟶ possui múltiplos **Pedidos**
- **Pedido** ⟶ contém múltiplas **Entradas**
- **Entrada** ⟶ referencia um **Espetáculo**
- **Espetaculo** ⟶ controla 50 assentos (array boolean)

---

## 📦 Pré-requisitos

Antes de executar o projeto, certifique-se de ter:

- ☕ **Java JDK 8 ou superior** instalado
- 💻 Um ambiente de desenvolvimento Java (Eclipse, IntelliJ IDEA, VS Code, etc.)
- 🖥️ Terminal/Prompt de comando

### Verificando a instalação do Java:

```bash
java -version
javac -version
```

---

## 🚀 Instalação

### 1️⃣ Clone o repositório

```bash
git clone https://github.com/seu-usuario/mack-theater.git
cd mack-theater
```

### 2️⃣ Compile o projeto

```bash
javac *.java
```

### 3️⃣ Execute o programa

```bash
java Main
```

---

## 💡 Utilização

### Menu Principal

Ao executar o programa, você terá acesso às seguintes opções:

```
*** MACK THEATHER ***
1) Cadastrar Espetáculo
2) Cadastrar Cliente
3) Compra de Entradas
4) Sair
```

### Fluxo Recomendado

1. **Cadastre espetáculos** (opção 1) antes de realizar vendas
2. **Cadastre clientes** (opção 2) para associar as compras
3. **Realize vendas** (opção 3) selecionando espetáculo, assento e tipo de entrada

---

## 📖 Exemplos de Uso

### Exemplo 1: Cadastrando um Espetáculo

```
Opção: 1

*** CADASTRO DE ESPETÁCULO ***
Nome do Espetáculo: Romeu e Julieta
Data: 15/12/2025
Hora: 20:00
Preço da Entrada Inteira: 80.00

Espetáculo cadastrado com sucesso!
```

### Exemplo 2: Cadastrando um Cliente

```
Opção: 2

*** CADASTRO DE CLIENTE ***
Nome do Cliente: João Silva
CPF: 123.456.789-00

Cliente cadastrado!
```

### Exemplo 3: Comprando Ingressos

```
Opção: 3

*** VENDA DE ENTRADAS ESPETÁCULOS ***
1) Romeu e Julieta 15/12/2025 20:00 R$ 80.00

Selecione um espetáculo: 1

||| Assentos Disponíveis |||
50 49 48 47 46 45 44 43 42 41
40 39 38 37 36 35 34 33 32 31
30 29 28 27 26 25 24 23 22 21
20 19 18 17 16 15 14 13 12 11
10 09 08 07 06 05 04 03 02 01

Selecione um assento: 25

||| Tipos de Entrada |||
1) Inteira
2) Meia
3) Professor

Selecione um tipo de entrada: 2
Entrada adicionada ao carrinho.

Deseja comprar outra entrada (S/N)? N

Informe o CPF do Cliente Cadastrado: 123.456.789-00
Valor Total: R$ 40.00
```

### Exemplo 4: Visualização de Assentos Ocupados

```
||| Assentos Disponíveis |||
50 49 48 47 46 45 44 43 42 41
40 39 38 37 36 35 34 33 32 31
30 29 28 27 26 XX 24 23 22 21  ← Assento 25 ocupado
20 19 18 17 16 15 14 13 12 11
10 09 08 07 06 05 04 03 02 01
```

---

## 🛠️ Tecnologias

Este projeto foi desenvolvido utilizando:

- **Linguagem**: Java
- **Paradigma**: Programação Orientada a Objetos
- **Estruturas de Dados**: ArrayList, Arrays
- **Entrada/Saída**: Scanner (java.util)

### Conceitos de POO Aplicados:

- ✅ **Encapsulamento**: Atributos privados com getters
- ✅ **Herança**: Classe abstrata Entrada com subclasses especializadas
- ✅ **Polimorfismo**: Método abstrato `calculaValor()` com implementações específicas
- ✅ **Abstração**: Separação clara de responsabilidades entre classes
- ✅ **Composição**: Teatro contém Espetáculos e Clientes
- ✅ **Agregação**: Cliente possui Pedidos, Pedido contém Entradas

### Recursos Java Utilizados:

- ✅ Classes e Objetos
- ✅ ArrayList para coleções dinâmicas
- ✅ Arrays nativos para controle de assentos
- ✅ Override de métodos (@Override)
- ✅ Modificadores de acesso (private, public)
- ✅ Métodos construtores
- ✅ Estruturas de controle (if/else, for, while, switch)
- ✅ Formatação de saída (printf, String.format)

---


---

**⭐ Se este projeto foi útil para você, considere dar uma estrela no repositório!**
