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
public class PesquisaOperacional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] Matriz = {
                          {-1,10,17,15},
                          {20,-1,19,18},
                          {50,40,-1,25},
                          {45,40,20,-1},
                         };
        int[] pesos = new int[Matriz[0].length];
        
        for(int i=0;i<Matriz[0].length;i++)
        {
            int cidadeInicial = i;
            Vizinho v = new Vizinho(Matriz,cidadeInicial);
            System.out.println("---------------- Cidade: "+i+" -------------------");
            String t="";
            for(int x=0;x<v.getCaminho().length;x++)
            {
                t+="["+v.getCaminho()[x]+"]";
            }
            System.out.println(t);
            pesos[i] = v.getPesoCaminho(v.getCaminho());
            System.out.println(">Peso: "+pesos[i]);
        }
        
        System.out.println("---------------- Melhor Cidade -------------------");
        System.out.println("> "+Vizinho.getMelhorCidade(pesos));
        
        Vizinho vi = new Vizinho(Matriz,Vizinho.getMelhorCidade(pesos));
        System.out.println("---------------- Inversão -------------------");
        String t="";
        for(int x=0;x<vi.Inversao().length;x++)
        {
            t+="["+vi.Inversao()[x]+"]";
        }
        System.out.println(t);
        System.out.println("Peso: "+vi.getPesoCaminho(vi.Inversao()));
        
    }
    
}
