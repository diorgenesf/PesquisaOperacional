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
public class Vizinho {
    private int[] caminho; //array do melhor caminho
    
    public Vizinho(int[][] MatrizDistancia, final int CidadeInicial) {
        int[][] MatrizMesclavel = MatrizDistancia;
        caminho = new int[MatrizDistancia[0].length]; //inicia o caminho
        
        for (int i = 0; i < caminho.length; i++) {
            caminho[i] = -1;
        }
        
        //a cidade inicial é a escolhida pelo usuário.
        caminho[0] = CidadeInicial;
        int cidadeAtual = CidadeInicial;
        
        int i = 1;
        while (i < caminho.length) {
            // encontro a próxima cidade            
            int proximaCidade = getProximaCidade(MatrizMesclavel[cidadeAtual]);
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

    private int getProximaCidade(int[] linha) { 
        int proximaCidade = -1;
        int i = 1;
        int min = Integer.MAX_VALUE;
        
        
        while (i < linha.length) {
            //se a cidade não está no caminho e o custo dela for menor que min
            //min passa a ser o custo de linha[i] e a proxima cidade passa a ser i
            if (linha[i] < min && linha[i]!=-1) {
                min = linha[i];
                proximaCidade = i;
            }
            i++;
        }
        
        return proximaCidade;
    }

    public int[] getCaminho() {
        return caminho;
    }
    
}
