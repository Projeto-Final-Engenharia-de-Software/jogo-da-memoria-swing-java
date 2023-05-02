package regras;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

public class ControleBotoesSelecionados {
    private String botao;
    private Map<JButton, EstadosBotoes> referenciasBotoes;

    public ControleBotoesSelecionados(){
        this.referenciasBotoes = new HashMap<>();
    }

    public void executarAcaoBotoes(JButton botao, EstadosBotoes estado){
        alterarSelecao(botao, estado);
        alterarEstadoTodosBotoes(EstadosBotoes.PARES_ENCONTRADOS);
    }

    private void alterarEstadoTodosBotoes(EstadosBotoes estado){
        for(JButton botao : this.referenciasBotoes.keySet()){
            alterarSelecao(botao, estado);
            alterarVisualizacaoBotao(botao);
        }
    }

    public String getBotao(){
        return botao;
    }

    public void setBotao(String botao){
        this.botao = botao;
    }

    public Map<JButton, EstadosBotoes> getReferenciasBotoes(){
        return referenciasBotoes;
    }

    public void setReferenciasBotoes(Map<JButton, EstadosBotoes> referenciasBotoes){
        this.referenciasBotoes = referenciasBotoes;
    }

    public void adicionarBotao(JButton botao){
        this.referenciasBotoes.put(botao, EstadosBotoes.NORMAL);
    }

    public void alterarSelecao(JButton botao, EstadosBotoes estado) {
        this.referenciasBotoes.put(botao, estado);
        alterarVisualizacaoBotao(botao);
        if(this.isTodasSelecionadas()){
            alterarEstadoTodosBotoes(EstadosBotoes.PARES_ENCONTRADOS);
        } else {
            alterarVisualizacaoBotao(botao);
        }
    }

    private void alterarVisualizacaoBotao(JButton botao){
        EstadosBotoes selecionado = this.referenciasBotoes.get(botao);
        switch (selecionado){
            case NORMAL: // Cinza, não exibe texto
                botao.setBackground(null);
                botao.setText("Jogo");
                break;
            case SELECIONADO: // Exibir texto, mudar a cor
                botao.setBackground(Color.pink);
                botao.setText(this.botao);
                botao.setEnabled(false);
                break;
            case PARES_ENCONTRADOS: // Mudar a cor, exibir o texto
                botao.setBackground(Color.GREEN);
                botao.setText(this.botao);
                botao.setEnabled(false);
                break;
        }
    }
    public void zerarSelecoes(){
        alterarEstadoTodosBotoes(EstadosBotoes.NORMAL);
    }

    public Boolean isTodasSelecionadas(){
        alterarEstadoTodosBotoes(EstadosBotoes.PARES_ENCONTRADOS);
        return true;
    }
}

