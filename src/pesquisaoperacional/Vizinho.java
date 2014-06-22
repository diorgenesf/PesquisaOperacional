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
    private int[][] Matriz;
    
    public Vizinho(int[][] MatrizDistancia, final int CidadeInicial) {
        this.Matriz = MatrizDistancia;
        caminho = new int[MatrizDistancia[0].length]; //inicia o caminho
        
        for (int i = 0; i < caminho.length; i++) {
            caminho[i] = -1;
        }
        
        //a cidade inicial é a escolhida pelo usuário.
        caminho[0] = CidadeInicial;
        System.out.println("Cidade Inicial: "+CidadeInicial);
        int cidadeAtual = CidadeInicial;
        
        int i = 1;
        while (i < caminho.length) {
                            
            // encontro a próxima cidade                  
            int proximaCidade = getProximaCidade(MatrizDistancia[cidadeAtual]);
            System.out.println("Proxima Cidade: "+proximaCidade);
            
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
    
    public int[] Inversao()
    {
        int[] min = this.caminho;
        
        int m = 1;
        int n = this.caminho.length;        
        
        while((n-m)>0)
        {
            int[] aux = this.caminho;
            for(int i=1;(m+i)<this.caminho.length;i++)
            {
                int w = aux[m];
                aux[m] = aux[m+i];
                aux[m+i] = w;
            }
            if(this.getPesoCaminho(min)>this.getPesoCaminho(aux))
            {
                min = aux;
            }
            m++;
        }
        return min;
    }
    
    public int getPesoCaminho(int[] Caminho)
    {
        int peso = 0;
        
        for(int i=0;i<Caminho.length-1;i++)
        {
            peso+=this.Matriz[Caminho[i]][Caminho[i+1]];
        }
        peso+=this.Matriz[Caminho[Caminho.length-1]][Caminho[0]];
        return peso;
    }
    
    public static int getMelhorCidade(int[] pesoCidades) { 
        int menor=-1;        
        int min = Integer.MAX_VALUE; 
        
        for(int i = 0; i<pesoCidades.length; i++)
        {
            if(pesoCidades[i]<min)
            {
                min = pesoCidades[i];
                menor = i;
            }
        }        
        return menor;
    }
    
    private boolean foiVisitada(int cidade)
    {
        int i=0;
        
        while(i<this.caminho.length)
        {
            if(caminho[i]==cidade)
            {
                return true;
            }
            i++;
        }
        return false;
    }

    private int getProximaCidade(int[] linha) { 
        int proximaCidade = -1;
        int i = 0;
        int min = Integer.MAX_VALUE;        
        
        while (i < linha.length) {
            //se a cidade não está no caminho e o custo dela for menor que min
            //min passa a ser o custo de linha[i] e a proxima cidade passa a ser i
            if (linha[i] < min && linha[i]!=-1 && !foiVisitada(i)) {
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
