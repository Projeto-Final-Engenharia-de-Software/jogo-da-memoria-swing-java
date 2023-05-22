package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TelaNiveisDificuldade extends JFrame {
    /**
     * 
     */
    public TelaNiveisDificuldade() {

        // Mudar cor dos botões
        UIManager.put("Button.background", Color.white);
        setTitle("Escolher nível de dificuldade");
        JLabel labelTitulo = new JLabel("Escolha o nível de dificuldade do jogo", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Verdana", Font.ITALIC, 20));
        labelTitulo.setForeground(new Color(139, 69, 19)); // marrom
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define a cor de fundo da janela para rosa claro
        getContentPane().setBackground(new Color(255, 153, 153));

        // Crie um painel para a JLabel e os botões
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Adicione a JLabel
        JLabel label = new JLabel("Escolha o nível de dificuldade do jogo", SwingConstants.CENTER);
        label.setFont(new Font("Verdana", Font.ITALIC, 16));
        label.setForeground(new Color(139, 69, 19)); // marrom
        painelPrincipal.add(label, BorderLayout.NORTH);

        // Crie um painel para os botões
        JPanel painelBotoes = new JPanel(new GridBagLayout());

        // Crie uma restrição para o GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 1.0;
        
        JButton btnNivelFacil = new JButton("Nível Fácil");
        JButton btnNivelMedio = new JButton("Nível Médio");
        JButton btnNivelDificil = new JButton("Nível Difícil");
        

        btnNivelFacil.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.setVisible(true);   
            }
        });
        
        btnNivelMedio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.setVisible(true);
            }
        });
        
        btnNivelDificil.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.setVisible(true);
            }
        });
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10); // Adiciona espaçamento de 10 pixels em todas as direções
        
        // Adicione os botões ao painel com a restrição de preenchimento
        painelBotoes.add(btnNivelFacil, gbc);
        painelBotoes.add(btnNivelMedio, gbc);
        painelBotoes.add(btnNivelDificil, gbc);
        
        painelBotoes.setBackground(new Color(255, 153, 153)); // Define a cor de fundo do painel de botões

        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);
        getContentPane().add(painelPrincipal);

        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args){
        new TelaNiveisDificuldade();
    }
}

class MenuPrincipal extends JFrame {

    /**
     * 
     */
    public MenuPrincipal() {
        // Título da janela
        setTitle("Menu Principal");

        // Cor de fundo da janela
        getContentPane().setBackground(new Color(255, 153, 153));

        // Cor de fundo dos botões
        UIManager.put("Button.background", Color.white);

        // Tamanho/resolução da janela
        setSize(400, 200);

        // Crie um painel para a JLabel e os botões
        JPanel painelMenuPrincipal = new JPanel(new BorderLayout());

        // Adicione a JLabel
        JLabel labelTituloMenu = new JLabel("Menu", SwingConstants.CENTER);
        labelTituloMenu.setFont(new Font("Verdana", Font.BOLD, 16));
        labelTituloMenu.setForeground(new Color(139, 69, 19)); // cor da fonte marrom
        painelMenuPrincipal.add(labelTituloMenu, BorderLayout.NORTH);

        // Adicione o painel à janela
        add(painelMenuPrincipal);

        // Crie um painel para os botões
        JPanel painelBotoes = new JPanel(new GridBagLayout());

        // Crie uma restrição para o GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 1.0;
        
        JButton btnVoltar = new JButton("Voltar");
        JButton btnIniciarJogo = new JButton("Iniciar Jogo");
        JButton btnSairJogo = new JButton("Sair");
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TelaNiveisDificuldade tela = new TelaNiveisDificuldade();
                tela.setVisible(true);
            }
        });
        
        btnIniciarJogo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               
            }
        });
        
        btnSairJogo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UIManager.put("OptionPane.yesButtonText", "Sim");
                UIManager.put("OptionPane.noButtonText", "Não");
        
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja sair do jogo?", "Aviso", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    // Fecha a janela
                    Window window = SwingUtilities.getWindowAncestor((JButton)e.getSource());
                    window.dispose();
                    System.exit(0); // Encerra o processo do jogo
                }
            }
        });
        

        // Adicionar um ouvinte de eventos para detectar a tecla Tab
        
        KeyAdapter tabListener = new KeyAdapter() {
            public void KeyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_TAB){
                    e.consume();
                }
            }
        };
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10); // Adiciona espaçamento de 10 pixels em todas as direções
        
        // Adicione os botões ao painel com a restrição de preenchimento
        painelBotoes.add(btnVoltar, gbc);
        painelBotoes.add(btnIniciarJogo, gbc);
        painelBotoes.add(btnSairJogo, gbc);
        
        painelBotoes.setBackground(new Color(255, 153, 153)); // Define a cor de fundo do painel de botões

        painelMenuPrincipal.add(painelBotoes, BorderLayout.CENTER);
        getContentPane().add(painelMenuPrincipal);
    }
}