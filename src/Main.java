import br.producao.excecoes.maquinaQuebradaException;
import br.producao.maquinas.Maquina;
import br.producao.maquinas.MaquinaCorte;
import br.producao.maquinas.MaquinaInspecao;
import br.producao.maquinas.MaquinaMontagem;
import br.producao.produtos.Produto;
import br.producao.produtos.Registravel;
import br.producao.simulacao.LinhaProducao;


public class Main {
    public static void main(String[] args) {
        MaquinaCorte m1 = new MaquinaCorte("serralheria", 5);
    }
}