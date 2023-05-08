package telaNiveisDificuldadeJogo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import regras.ControleBotoesSelecionados;
import regras.EstadosBotoes;

public class TelaNivelDificil extends JFrame {
    private static final int QUANTIDADE_JOGADAS = 2;
    private int jogadas = 0;
    private JPanel painel;

    private List<ControleBotoesSelecionados> listaControle;

    private List<ControleBotoesSelecionados> listaSelecionados;

    private ActionListener acaoBotoes;
    private LayoutManager layoutMgr;
    private boolean verificando = false;
    
    public List<ControleBotoesSelecionados> getListaSelecionados() {
        return listaSelecionados;
    }

    /**
     */
    public TelaNivelDificil(){
        super("Jogo da Memória - Nível Difícil");

        listaControle = new ArrayList<>();
        listaSelecionados = new ArrayList<>();


        //Evento dos botões
        acaoBotoes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JButton botao = (JButton) e.getSource();

                for(ControleBotoesSelecionados cont : listaControle){
                    if(cont.getReferenciasBotoes().get(botao) != null){
                        jogadas++;
                        cont.executarAcaoBotoes((JButton) e.getSource(), EstadosBotoes.SELECIONADO);
                        // Controle de inclusão
                        if(!listaSelecionados.contains(cont)){
                            listaSelecionados.add(cont);
                        }   
                        System.out.println(listaSelecionados.size());

                        if(jogadas == QUANTIDADE_JOGADAS){
                            // Acabaram as jogadas
                            if(listaSelecionados.size() > 1){
                            // Só selecionou os botões corretos
                            for(ControleBotoesSelecionados cbs : listaSelecionados){
                                cbs.zerarSelecoes();
                            }
                        }
                            
                            jogadas = 0;
                            listaSelecionados.clear();
                        }
                        break;
                    }
                }
            } 
        };

        painel = new JPanel();
        this.add(painel);
        painel.setLayout(new GridLayout(0, 5, 20, 20));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        criarJogo(4);
        this.setBounds(120, 100, 500, 500);
        this.setVisible(true);
    }
    /**
     * @param qtPares
     */
    private void criarJogo(int qtPares) {
        List<Integer> valoresPares = new ArrayList<>();
        for (int i = 1; i <= qtPares; i++) {
            valoresPares.add(i);
            valoresPares.add(i);
        }
        Collections.shuffle(valoresPares);
    
        ControleBotoesSelecionados controle = null;
        int posX = 10;
        int posY = 10;
    
        int j = 0;
        for (int i = 0; i < (qtPares * 2); i++) {
            if (i % 2 == 0) {
                j++;
                controle = new ControleBotoesSelecionados();
                controle.setBotao("Botão" + j);
                this.listaControle.add(controle);
            }
    
            JButton botao = new JButton(String.valueOf(valoresPares.get(i)));
            this.painel.add(botao);
            botao.addActionListener(this.acaoBotoes);
            botao.setBounds(posX, posY, 75, 75);
            posX += 80;
            if (i % 5 == 0 && i > 0) {
                posY += 80;
                posX = 10;
            } else {
                posX += 10;
            }
    
            controle.adicionarBotao(botao);
            }
        }

        /**
         * @param args
         */

        public static void main (String[] args) {
            TelaNivelDificil tela = new TelaNivelDificil();
        }
    }


