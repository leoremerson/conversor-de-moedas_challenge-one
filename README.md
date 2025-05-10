# 💱 Conversor de Moedas

Um projeto simples em Java que realiza conversões entre diferentes moedas utilizando uma API de câmbio em tempo real. O sistema permite ao usuário converter valores, visualizar a taxa de câmbio aplicada e consultar o histórico das conversões realizadas.

O Conversor de Moedas é um projeto desenvolvido como challenge do curso de Java e Orientação a Objetos do programa Oracle Next Education (ONE), parceria de Alura + Oracle, com o objetivo de aplicar conceitos importantes de Java, como consumo de API, herança, polimorfismo, entre outros, experimentando diretamente o papel de um desenvolvedor back-end no cotidiano.

## 🚀 Funcionalidades

- Conversão entre as seguintes moedas:
  - Real (BRL)
  - Dólar (USD)
  - Euro (EUR)
  - Libra (GBP)
  - Peso Argentino (ARS)
- Consulta da taxa de câmbio em tempo real via API ([ExchangeRate-API](https://www.exchangerate-api.com/))
- Registro automático de cada conversão em um arquivo `.txt`
- Exibição do histórico de conversões com data, hora e numeração sequencial

## 📁 Estrutura do Projeto

```bash
.
├── Main.java                   # Interface principal e lógica do menu
├── ObterTaxa.java              # Consulta de taxas via API
├── HistoricoConversoes.java    # Registro e exibição do histórico
└── conversões.txt              # Arquivo gerado com o histórico das conversões
```

## 🧰 Tecnologias utilizadas

- Java 17+
- IntelliJ IDEA
- API HTTP (HttpClient)
- Biblioteca GSON (para leitura do JSON da API)
- Manipulação de arquivos (`java.nio.file`, `FileWriter`, `BufferedReader`)

## 📦 Como executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/conversor-moedas-java.git
   cd conversor-moedas-java
   ```

2. **Compile os arquivos:**
   ```bash
   javac Main.java ObterTaxa.java HistoricoConversoes.java
   ```

3. **Execute o programa:**
   ```bash
   java Main
   ```

> 💡 Certifique-se de estar conectado à internet para obter as taxas de câmbio atualizadas.

## 📝 Exemplo de histórico gerado

```
1 [10/05/2025 17:35] Convertido 100.00 BRL para 19.45 USD (taxa 0.1945)
2 [10/05/2025 17:37] Convertido 50.00 USD para 257.00 BRL (taxa 5.1400)
```

## 🔐 API Key

Este projeto utiliza a ExchangeRate-API. Para executar com sua própria chave:

1. Crie uma conta gratuita em [https://www.exchangerate-api.com](https://www.exchangerate-api.com).
2. Substitua a `apikey` na classe `ObterTaxa` pela sua chave pessoal.

```java
private static String apikey = "sua-chave-aqui";
```

## 🧠 Aprendizados

- Requisições HTTP com Java
- Parse de JSON com GSON
- Manipulação de arquivos
- Organização de código em classes
- Estrutura de menu interativo no terminal

## ✍️ Autor

[Leo Remerson](https://github.com/leoremerson)

Desenvolvido como parte da minha jornada de aprendizado em Java no programa Oracle Next Education (ONE) - Alura.

## 📄 Licença

Este projeto é de uso livre para fins de estudo e aprendizagem.
