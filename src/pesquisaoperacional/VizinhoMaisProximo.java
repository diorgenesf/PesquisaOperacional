/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisaoperacional;

/**
 *
 * @author Diorgenes
 */
public class VizinhoMaisProximo {

    private int[] caminho; //array do melhor caminho

    public VizinhoMaisProximo(final int[][] MatrizDistancia, final int CidadeInicial) {

        caminho = new int[MatrizDistancia[0].length]; //inicia o caminho

        //preencho o caminho inicialmente com o infinito
        //pois dava problema com valor 0 ao iniciar com uma cidade diferente de A
        for (int i = 0; i < caminho.length; i++) {
            caminho[i] = Integer.MAX_VALUE;
        }

        //a cidade inicial é a escolhida pelo usuário.
        caminho[0] = CidadeInicial;
        int cidadeAtual = CidadeInicial;

        // enquanto não houver cidades a serem visitadas
        int i = 1;
        while (i < caminho.length) {
            // encontro a próxima cidade
            int proximaCidade = EncontraMinimo(MatrizDistancia[cidadeAtual]);
            // se a cidade for diferente de - 1 (significa que a mesma não foi visitada)
            if (proximaCidade != -1) {
                // adiciono a cidade ao caminho
                caminho[i] = proximaCidade;
                // atualizo a cidade atual e o contador
                cidadeAtual = proximaCidade;
                i++;
            }
        }
    }

    private int EncontraMinimo(int[] linha) {
        //encontro o menor custo
        //na linha passada por parametro (int[] linha)
        int proximaCidade = -1;
        int i = 0;
        int min = Integer.MAX_VALUE;

        while (i < linha.length) {
            //se a cidade não está no caminho e o custo dela for menor que min
            //min passa a ser o custo de linha[i] e a proxima cidade passa a ser i
            if (!ehCaminho(caminho, i) && linha[i] < min) {
                min = linha[i];
                proximaCidade = i;
            }
            i++;
        }
        return proximaCidade;
    }

    //retorna o array com o caminho
    public int[] getCaminho() {
        return caminho;
    }

    //verifica se a cidade está no caminho (int[] caminho)
    public boolean ehCaminho(int[] caminho, int cidade) {
        for (int i = 0; i < caminho.length; i++) {
            if (caminho[i] == cidade) {
                return true;
            }
        }
        return false;
    }
}
