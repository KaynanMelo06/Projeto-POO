# ⚙️ **Projeto: Simulador de Linha de Produção**
🧠 *Integra Engenharia de Produção e Computação usando Programação Orientada a Objetos (Java)*

---

## 🎯 **Objetivo do Projeto**
Desenvolver um simulador que representa uma **linha de produção automatizada**, composta por máquinas que processam produtos em sequência, registram resultados e geram relatórios de desempenho.

O projeto demonstra conceitos fundamentais de **Engenharia de Produção** (fluxo produtivo, gargalos, tempo de ciclo) e de **Computação** (POO, threads, exceções, arquivos, interfaces e pacotes).

---

## 🏭 **Conceito de Engenharia de Produção Aplicado**
- Fluxo produtivo e sequenciamento de operações
- Gargalos e eficiência da linha
- Controle de qualidade e rejeição de peças
- Registro e análise de desempenho

---

## 💻 **Conceitos de Programação Utilizados**
✅ Classes e Objetos  
✅ Herança e Polimorfismo  
✅ Interfaces  
✅ Pacotes  
✅ Modificadores de acesso  
✅ Construtores  
✅ Atributos e métodos `static`  
✅ Arrays  
✅ Threads  
✅ Exceções personalizadas  
✅ Leitura e escrita de arquivos

---

## 🧩 **Estrutura de Pacotes**
```
br.producao.maquinas
br.producao.produtos
br.producao.simulacao
br.producao.arquivos
br.producao.excecoes
```

---

## 🧱 **Principais Classes e Interfaces**

### 🏗️ **Classe Abstrata `Maquina`**
```java
public abstract class Maquina {
    protected String id;
    protected int tempoProcesso;

    public Maquina(String id, int tempoProcesso) {
        this.id = id;
        this.tempoProcesso = tempoProcesso;
    }

    public abstract void processar(Produto p) throws MaquinaQuebradaException;
}
```

### ⚙️ **Subclasses**
- `MaquinaCorte`
- `MaquinaMontagem`
- `MaquinaInspecao`

Cada uma implementa `processar()` de forma diferente (polimorfismo).

---

### 📦 **Classe `Produto`**
```java
public class Produto implements Registravel {
    private static int contador = 0;
    private int id;
    private String nome;
    private boolean aprovado;

    public Produto(String nome) {
        this.id = ++contador;
        this.nome = nome;
        this.aprovado = true;
    }

    @Override
    public void registrarEmArquivo() {
        // escreve dados do produto em arquivo
    }
}
```

---

### 🧾 **Interface `Registravel`**
```java
public interface Registravel {
    void registrarEmArquivo();
}
```

---

### 🧠 **Classe `LinhaProducao`**
```java
public class LinhaProducao {
    private Maquina[] etapas;
    
    public LinhaProducao(Maquina[] etapas) {
        this.etapas = etapas;
    }

    public void iniciar(Produto p) {
        for (Maquina m : etapas) {
            try {
                m.processar(p);
            } catch (MaquinaQuebradaException e) {
                System.out.println("Erro: " + e.getMessage());
                break;
            }
        }
    }
}
```

---

### ⚡ **Threads**
Cada máquina pode rodar em paralelo:
```java
public class MaquinaCorte extends Maquina implements Runnable {
    public void run() {
        // simula tempo de operação
    }
}
```

---

### ❗ **Exceções Personalizadas**
```java
public class MaquinaQuebradaException extends Exception {
    public MaquinaQuebradaException(String msg) {
        super(msg);
    }
}
```

---

## 📊 **Exemplo de Saída**
```
=== RELATÓRIO DE PRODUÇÃO ===
Produto: 001 - "Caixa de Engrenagem"
Processado com sucesso!
Tempo total: 12 segundos
Status: Aprovado
```

---

## 🧭 **Resumo do Projeto**
| Conceito | Aplicação |
|-----------|------------|
| Herança | Maquina → subclasses específicas |
| Polimorfismo | `processar()` adaptado em cada máquina |
| Interface | `Registravel` |
| Arrays | Lista de máquinas na linha |
| Threads | Simulação paralela |
| Arquivos | Registro de produção |
| Exceções | Erros de processo e falhas |
| Static | Contador de produtos |
| Pacotes | Organização modular |

---

## 🧩 **Próximos Passos**
1. Criar o **diagrama UML**.
2. Implementar o **código base**.
3. Adicionar simulação e relatórios.
4. Apresentar destacando conceitos de POO + Engenharia de Produção.
