import br.producao.arquivos.LeitorConfiguracao;
import br.producao.maquinas.*;
import br.producao.simulacao.Simulador;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PRODUÇÃO PARALELA ===\n");

        // 1. Ler Configuração (pode falhar e lançar erro crítico)
        Map<String, Integer> config = LeitorConfiguracao.ler("configuracao.txt");

        // 2. Preparar Máquinas
        MaquinaCorte mCorte = new MaquinaCorte("Laser-01", config.getOrDefault("CORTE", 2));
        MaquinaMontagem mMontagem = new MaquinaMontagem("Montadora-X", config.getOrDefault("MONTAGEM", 3));
        MaquinaInspecao mInspecao = new MaquinaInspecao("Scanner-Q", config.getOrDefault("INSPECAO", 1));

        Maquina[] etapas = { mCorte, mMontagem, mInspecao };

        // 3. Disparar Threads usando Lambda
        new Thread(() -> Simulador.iniciarProcesso("Carro Modelo A", etapas)).start();
        new Thread(() -> Simulador.iniciarProcesso("Carro Modelo B", etapas)).start();
        new Thread(() -> Simulador.iniciarProcesso("Carro Modelo C", etapas)).start();
    }
}