package regras;

import javax.swing.JButton;

public class referenciasBotoes {

    private JButton botao;
    private boolean selecionado;
  
    public JButton getBotao(){
      return botao;
    }
  
    public void setBotao(JButton botao){
      this.botao = botao;
    }
  
    public boolean getSelecionado(){
      return selecionado;
    }
  
    public void setSelecionado(boolean selecionado){
      this.selecionado = selecionado;
    }
  }