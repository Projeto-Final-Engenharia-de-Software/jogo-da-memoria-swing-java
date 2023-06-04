package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

import regras.ControleBotoesSelecionados;
import regras.EstadosBotoes;

public class TelaPrincipal extends JFrame {
    
    private static final int QUANTIDADE_JOGADAS = 2;
    private int jogadas = 0;

    private ImageIcon[] icon;
    
    private JPanel painel;
    
    private List<ControleBotoesSelecionados> listaControle;
    
    private List<ControleBotoesSelecionados> listaSelecionados;
    
    private ActionListener acaoBotoes;
    
    public TelaPrincipal(int qtdPares) {
        super("Jogo da Memoria");
        
        listaControle = new ArrayList<>();
        listaSelecionados = new ArrayList<>();
        
        // Evento dos botões
        acaoBotoes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton botao = (JButton) e.getSource();
                for (ControleBotoesSelecionados cont : listaControle) {
                    if (cont.getReferenciaBotoes().get(botao) != null) {
                        jogadas++;
                        cont.executarAcaoBotoes((JButton) e.getSource(), EstadosBotoes.SELECIONADO);
                        // Controle de inclusão
                        if (!listaSelecionados.contains(cont)) {
                            listaSelecionados.add(cont);
                        }
                        System.out.println(listaSelecionados.size());
                        if (jogadas == QUANTIDADE_JOGADAS) {
                            // Acabaram as jogadas
                            if (listaSelecionados.size() > 1) {
                                // Deixar os botões com estado inicial
                                for (ControleBotoesSelecionados cbs : listaSelecionados) {
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
        painel.setLayout(null);  
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        criarJogo(qtdPares);
        this.setBounds(250, 250, 500, 500);
        this.setVisible(true);
    }

    private void criarJogo(int qtPares) {
        // Quantidade de botões
        ControleBotoesSelecionados controle = null;

            List<Rectangle> posicionamentos = new ArrayList<>();
        int posX = 10;
        int posY = 10;
        
        Random rand = new Random();
        int j = 0;
        int i = 0;

        for (i = 0; i < (qtPares * 2); i++) {
            // Randomizar o posicionamento dos botões
            Rectangle rec = new Rectangle(posX, posY, 75, 75);
            posicionamentos.add(rec);
            if (i % 5 == 0 && i > 0) {
                posY += 80;
                posX = 10;
            } else {
                posX += 80;
            }
        }

        //adicionando quantidade de pares
        for (i = 0; i < (qtPares * 2); i++) {
            if (i % 2 == 0) {
                // Quantidade de controladores
                j++;
                controle = new ControleBotoesSelecionados();
                controle.setNmBotao("teste"+j); // substituir por comando que adiciona imagem
                this.listaControle.add(controle);

            }
            JButton botao = new JButton("Carta");
            // Colocar os botões na tela
            this.painel.add(botao);
            botao.addActionListener(this.acaoBotoes);
            // Adicionar posição
            int pos = rand.nextInt(((posicionamentos.size() - 1) > 0) ? posicionamentos.size() - 1 : 1);
            System.out.println(pos);
            botao.setBounds(posicionamentos.get(pos));
            posicionamentos.remove(pos);
            
            
            controle.adicionarBotao(botao);
            
        }
        // Adaptar o tamanho da tela
        
        
    }
    
}

