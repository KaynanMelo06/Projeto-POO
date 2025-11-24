import br.producao.arquivos.LeitorConfiguracao;
import br.producao.maquinas.*;
import br.producao.simulacao.TarefaProducao;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PRODUÇÃO PARALELA ===\n");

        // 1. Ler Configuração
        Map<String, Integer> config = LeitorConfiguracao.ler("configuracao.txt");

        // 2. Preparar Máquinas
        MaquinaCorte mCorte = new MaquinaCorte("Laser-01", config.getOrDefault("CORTE", 2));
        MaquinaMontagem mMontagem = new MaquinaMontagem("Montadora-X", config.getOrDefault("MONTAGEM", 3));
        MaquinaInspecao mInspecao = new MaquinaInspecao("Scanner-Q", config.getOrDefault("INSPECAO", 1));

        Maquina[] etapas = { mCorte, mMontagem, mInspecao };

        // 3. Criar as Tarefas
        TarefaProducao tarefa1 = new TarefaProducao("Carro Modelo A", etapas);
        TarefaProducao tarefa2 = new TarefaProducao("Carro Modelo B", etapas);
        TarefaProducao tarefa3 = new TarefaProducao("Carro Modelo C", etapas);

        // 4. Criar as Threads passando as tarefas
        Thread t1 = new Thread(tarefa1);
        Thread t2 = new Thread(tarefa2);
        Thread t3 = new Thread(tarefa3);

        // 5. Iniciar
        t1.start();
        t2.start();
        t3.start();
    }
}