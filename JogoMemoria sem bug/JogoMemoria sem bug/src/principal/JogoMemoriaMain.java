package principal;

import telas.TelaPrincipal;

import javax.swing.*;


public class JogoMemoriaMain {

    public static void main(String[] args) {

        try{
            String resposta = JOptionPane.showInputDialog(null,"Digite o nivel do jogo, 1 = facil. 10 = Dificil","Dificuldade do Jogo",3);
            int op = Integer.parseInt(resposta);

            if(op > 10){
                op = 10;
            }

            TelaPrincipal tela = new TelaPrincipal(op);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Você fez algo que não deveria!");
            e.printStackTrace();
        }
    }

}
