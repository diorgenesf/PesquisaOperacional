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
        int cidadeInicial = 0;
        Vizinho v = new Vizinho(Matriz,cidadeInicial);
        System.out.println("------------------------------------");
        String t="";
        for(int i=0;i<v.getCaminho().length;i++)
        {
            t+="["+v.getCaminho()[i]+"]";
        }
        System.out.println(t);
        
    }
    
}
