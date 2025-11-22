
# ⚙️ **Projeto: Simulador de Linha de Produção**
🧠 *Integra Engenharia de Produção e Computação usando Programação Orientada a Objetos (Java)*

---

## 🎯 **Objetivo do Projeto**
Desenvolver um simulador que representa uma **linha de produção automatizada**, composta por máquinas que processam produtos em sequência, registram resultados e geram relatórios de desempenho.

O projeto demonstra conceitos fundamentais de **Engenharia de Produção** (fluxo produtivo, gargalos, tempo de ciclo) e de **Computação** (POO, threads, exceções, arquivos, interfaces e pacotes).

---

## 🏭 **Conceito de Engenharia de Produção Aplicado**
- Fluxo produtivo e sequenciamento de operações
- Simulação de falhas mecânicas e manutenção
- Controle de qualidade e rejeição de peças
- Registro e análise de desempenho (Logs)

---

## 💻 **Conceitos de Programação Utilizados**
✅ Classes e Objetos  
✅ Herança e Polimorfismo  
✅ Interfaces (`Registravel`)  
✅ Pacotes  
✅ Modificadores de acesso e Encapsulamento  
✅ Construtores  
✅ Atributos e métodos `static`  
✅ Coleções e Arrays  
✅ Threads
✅ **Java NIO (Path, Files)** para I/O moderno  
✅ Exceções personalizadas (`RuntimeException`)

---

## 🧩 **Estrutura de Pacotes**
```text
br.producao.maquinas   -> Lógica das máquinas (Corte, Montagem, Inspeção)
br.producao.produtos   -> Definição do produto e gravação de arquivo
br.producao.simulacao  -> Controle do fluxo de produção (Simulador e Linha)
br.producao.arquivos   -> Leitura de configurações externas
br.producao.excecoes   -> Erros personalizados do sistema
````

-----

## 🧱 **Principais Classes e Interfaces**

### 🏗️ **Classe Abstrata `Maquina`**

Base para todas as máquinas da fábrica.

```java
public abstract class Maquina {
    protected String id;
    protected int tempoProcesso;

    public Maquina(String id, int tempoProcesso) {
        this.id = id;
        this.tempoProcesso = tempoProcesso;
    }

    public abstract void processar(Produto p) throws maquinaQuebradaException;
}
```

### ⚙️ **Subclasses de Máquina**

  - `MaquinaCorte`: Simula o corte e possui chance de falha mecânica.
  - `MaquinaMontagem`: Realiza a montagem das peças.
  - `MaquinaInspecao`: Verifica a qualidade e pode rejeitar o produto (10% de chance).

Cada uma implementa o método `processar()` de forma polimórfica.

-----

### 📦 **Classe `Produto`**

Implementa a lógica de status e gravação usando **Java NIO**.

```java
public class Produto implements Registravel {
    // ... atributos ...

    @Override
    public void registrarEmArquivo() {
        Path caminho = Paths.get("relatorio_producao.txt");
        // Usa Files.writeString com opção APPEND para criar log histórico
        Files.writeString(caminho, conteudo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
```

-----

### 🧠 **Classes de Simulação**

#### `LinhaProducao`

Gerencia a passagem do produto pelas etapas e trata falhas.

```java
public void iniciar(Produto p) {
    for (Maquina m : etapas) {
        try {
            m.processar(p);
        } catch (maquinaQuebradaException e) {
            System.out.println("Erro: " + e.getMessage());
            p.setAprovado(false); // Reprova automaticamente se a máquina quebrar
            break; 
        }
    }
}
```

#### `Simulador`

Classe auxiliar estática que encapsula a criação do produto e o início da linha, facilitando o uso em Threads.

-----

### ⚡ **Threads e Paralelismo**

Diferente da abordagem clássica de implementar `Runnable` nas máquinas, este projeto utiliza **Lambdas** no `Main` para disparar processos de fabricação independentes para cada produto.

```java
// Main.java
new Thread(() -> Simulador.iniciarProcesso("Carro Modelo A", etapas)).start();
new Thread(() -> Simulador.iniciarProcesso("Carro Modelo B", etapas)).start();
```

-----

### 📂 **Leitura de Configuração (Java NIO)**

O sistema lê os tempos de processo de um arquivo externo `configuracao.txt` localizado na raiz do projeto.

```java
public class LeitorConfiguracao {
    public static Map<String, Integer> ler(String caminho) {
        // Usa Files.readAllLines e Streams/Split para processar "CHAVE=VALOR"
    }
}
```

-----

### ❗ **Exceções Personalizadas**

  - `maquinaQuebradaException`: Lançada quando ocorre uma falha mecânica na `MaquinaCorte`.
  - `ConfiguracaoNaoEncontradaException`: Lançada se o arquivo `configuracao.txt` não for encontrado (Erro Crítico).

Ambas estendem `RuntimeException` para parar fluxos específicos quando necessário.

-----

## 📊 **Exemplo de Saída (Console)**

```text
=== SISTEMA DE PRODUÇÃO PARALELA ===

>> Thread iniciada para: Carro Modelo A
>> Thread iniciada para: Carro Modelo B
[Corte] A cortar: Carro Modelo A
[Corte] A cortar: Carro Modelo B
[Corte] Finalizado: Carro Modelo A
[Montagem] A montar: Carro Modelo A
...
[Inspeção] APROVADO: Carro Modelo A
[Arquivo] Relatório gravado para: Carro Modelo A
```

-----

## 📝 **Formato do Relatório (Arquivo)**

O arquivo `relatorio_producao.txt` é gerado automaticamente:

```text
Produto ID: 1 | Nome: Carro Modelo A | Status: APROVADO
Produto ID: 2 | Nome: Carro Modelo B | Status: REJEITADO
Produto ID: 3 | Nome: Carro Modelo C | Status: APROVADO
```
