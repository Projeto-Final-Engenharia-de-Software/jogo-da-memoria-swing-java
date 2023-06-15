/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogomemoriatelas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import principal.JogoMemoriaMain;

public class TelasJm extends JFrame {
    // Panels
    private JPanel mainPanel;
    private JPanel jpnTelaLogin;
    private JPanel jpnTelaCadastro;
    private JPanel jpnTelaMenu;
  
    // Card layout
    private CardLayout cardLayout;
    
    // Elementos panel tela de login
    private JButton botaoLogin;
    private JButton botaoCadastrese;
    private JTextField campoLogin;
    //private JTextField campoSenha;
    private JPasswordField campoSenha;
    private JLabel loginLabel;
    private JLabel senhaLabel;
    
    // Elementos panel tela de cadastro   
    private JButton botaoCadastrar;
    private JLabel nomeLabelCadastro;
    private JLabel senhaLabelCadastro;
    private JPasswordField campoSenhaCadastro;
    private JTextField campoNomeCadastro;
    //private JTextField campoSenhaCadastro;
    
    // Elementos panel menu
    private JLabel menuLabel;
    private JButton botaoIniciar;
    private JButton botaoRegras;
    private JButton botaoSair;
    
    // Alternativa Banco de dados
    private HashMap<String, String> bd;

    public TelasJm() {
        conf();
        mainPanel();
        jpnLogin();
        jpnLoginElementos();
        jpnCadastro();
        jpnCadastroElemetos();
        jpnMenu();
        jpnMenuElementos();
    }

    public void conf() {
        this.setTitle("Jogo da Memória");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0, 0, 500, 500);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }
    
    //JPanel principal
    public void mainPanel() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBounds(0, 0, 500, 500);
        //mainPanel.setBackground(new Color(253,216,168));
        add(mainPanel);
        cardLayout.show(mainPanel,  "login");
    }
    
    //==================================== LOGIN =========================================
    
    // Jpanel Login
    public void jpnLogin() {
        jpnTelaLogin = new JPanel(null);
        jpnTelaLogin.setBounds(0, 0, 500, 500);
        jpnTelaLogin.setBackground(new Color(253,216,168));
        // Adicionando o JPanel ao JPanel principal e dando uma tag no mesmo.
        mainPanel.add(jpnTelaLogin, "login");
    }
    // Jpanel Componentes login
    public void jpnLoginElementos() {
        // JLabel Login
        loginLabel = new JLabel("Jogo da Memória");
        loginLabel.setBounds(120, 30, 260, 50);
        loginLabel.setFont(new Font("Verdana", Font.BOLD, 27));
        loginLabel.setForeground(new Color(100,31,22));
        jpnTelaLogin.add(loginLabel);
        
        // Label login
        loginLabel = new JLabel("Login:");
        loginLabel.setBounds(200, 110, 250, 50);
        loginLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        loginLabel.setForeground(new Color(100,31,22));
        jpnTelaLogin.add(loginLabel);
        
        // Campo Login
        campoLogin = new JTextField();
        campoLogin.setBounds(95, 170, 300, 30);
        campoLogin.setBackground(new Color(232,232,232));
        jpnTelaLogin.add(campoLogin);
        
        // Label senha
        senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(200, 210, 200, 50);
        senhaLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        senhaLabel.setForeground(new Color(100,31,22));
        jpnTelaLogin.add(senhaLabel);
        
        // Campo Senha
        campoSenha = new JPasswordField();
        campoSenha.setBounds(95, 270, 300, 30);
        campoSenha.setBackground(new Color(232,232,232));
        jpnTelaLogin.add(campoSenha);
        
        // Botão cadastrar
        botaoCadastrese = new JButton("Cadastrar");
        botaoCadastrese.setBounds(95, 370, 120, 30);
        botaoCadastrese.setFont(new Font("Verdana", Font.BOLD, 13));
        botaoCadastrese.setForeground(new Color(100, 31, 22));
        botaoCadastrese.setBackground((new Color(232,232,232)));
        jpnTelaLogin.add(botaoCadastrese);
        
        // Botão login
        botaoLogin = new JButton("Login");
        botaoLogin.setBounds(275, 370, 120, 30);
        botaoLogin.setSize(120, 30);
        botaoLogin.setFont(new Font("Verdana", Font.BOLD, 13));
        botaoLogin.setForeground(new Color(100, 31, 22));
        botaoLogin.setBackground((new Color(232,232,232)));
        jpnTelaLogin.add(botaoLogin);
        
        botaoLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Usando o card layout para trocar de telas. JPanel principal e a tag dos panels secundários
                if (bd.containsKey(campoLogin.getText()) == false){
                    JOptionPane.showMessageDialog(null, "Erro! Usuário não cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else{
                    //System.out.println(bd.get(campoLogin.getText()));
                    String novaSenha = new String(campoSenha.getPassword());
                    if(bd.get(campoLogin.getText()).equals(novaSenha)){
                         cardLayout.show(mainPanel, "menu");
                    }else{
                        JOptionPane.showMessageDialog(null, "Senha incorreta! Tente novamente.", "ERRO", JOptionPane.ERROR_MESSAGE);
                        
                        }}
               
          }
        });
        // Passando para página de cadastro 
        botaoCadastrese.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Usando o card layout para trocar de telas. JPanel principal e a tag dos panels secundários
                cardLayout.show(mainPanel, "cadastro");
            }
        });
    }
    
    //==================================== CADASTRO =========================================

    public void jpnCadastro() {
        jpnTelaCadastro = new JPanel(null);
        jpnTelaCadastro.setBounds(0, 0, 500, 500);
        jpnTelaCadastro.setBackground(new Color(253,216,168));
        // Adicionando o JPanel ao Panel principal e dando uma tag no mesmo.
        mainPanel.add(jpnTelaCadastro, "cadastro");
    }

    public void jpnCadastroElemetos() {
        // Label Cadastro
        JLabel cadastroLabel = new JLabel("Tela de Cadastro");
        cadastroLabel.setBounds(120, 30, 260, 50);
        cadastroLabel.setFont(new Font("Verdana", Font.BOLD, 27));
        cadastroLabel.setForeground(new Color(100, 31, 22));
        jpnTelaCadastro.add(cadastroLabel);
        // Label nome do usuário
        nomeLabelCadastro = new JLabel("Seu nome: ");
        nomeLabelCadastro.setBounds(190, 110, 250, 50);
        nomeLabelCadastro.setFont(new Font("Verdana", Font.BOLD, 25));
        nomeLabelCadastro.setForeground(new Color(100, 31, 22));
        jpnTelaCadastro.add(nomeLabelCadastro);
        
        // Campo nome de usuário
        campoNomeCadastro = new JTextField();
        campoNomeCadastro.setBounds(95, 170, 300, 30);
        campoNomeCadastro.setBackground(new Color(232,232,232));
        jpnTelaCadastro.add(campoNomeCadastro);
        
        // Label Senha
        senhaLabelCadastro = new JLabel("Senha:");
        senhaLabelCadastro.setBounds(200, 210, 200, 50);
        senhaLabelCadastro.setFont(new Font("Verdana", Font.BOLD, 25));
        senhaLabelCadastro.setForeground(new Color(100, 31, 22));
        jpnTelaCadastro.add(senhaLabelCadastro);
        
        // Senhasenha
        campoSenhaCadastro = new JPasswordField();
        campoSenhaCadastro.setBounds(95, 270, 300, 30);
        campoSenhaCadastro.setBackground(new Color(232,232,232));
        jpnTelaCadastro.add(campoSenhaCadastro);
        
        // Botão cadastrar
        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(180, 370, 120, 30);
        botaoCadastrar.setFont(new Font("Verdana", Font.BOLD, 13));
        botaoCadastrar.setForeground(new Color(100, 31, 22));
        botaoCadastrar.setBackground((new Color(232,232,232)));
        jpnTelaCadastro.add(botaoCadastrar);
        
        //Iniciado o HashMap 
        bd = new HashMap <String, String>();
        
        // Finalizando cadastro ao apertar no botao
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Usando o card layout para trocar de telas. JPanel principal e a tag dos panels secundários
                if(campoNomeCadastro.getText().isEmpty() || campoSenhaCadastro.getPassword().length == 0){
                    JOptionPane.showMessageDialog(null, "Erro! Verifique se os campos NOME e SENHA foram preenchidos corretamenete.", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
                } else{
                    String nome = campoNomeCadastro.getText();
                    String senha = new String(campoSenhaCadastro.getPassword());
                    bd.put(nome, senha);
                    //System.out.println(bd);
                    
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Tela de cadastro", JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(mainPanel, "login");}
            }
        });
        
    }
    
    //==================================== MENU =========================================
    
    public void jpnMenu(){
        jpnTelaMenu = new JPanel(null);
        jpnTelaMenu.setBounds(0, 0, 500, 500);
        jpnTelaMenu.setBackground(new Color(253,216,168));
        // Adicionando o JPanel ao Panel principal e dando uma tag no mesmo.
        mainPanel.add(jpnTelaMenu, "menu");
    }
    
    public void jpnMenuElementos(){
        menuLabel = new JLabel("Jogo da Memória");
        menuLabel.setBounds(140, 60, 250, 50);
        menuLabel.setFont(new Font("Verdana", Font.BOLD, 25));
        menuLabel.setForeground(new Color(100,31,22));
        jpnTelaMenu.add(menuLabel);
        
        botaoIniciar = new JButton("Iniciar Jogo");
        botaoIniciar.setBounds(170, 150, 150, 40);
        botaoIniciar.setFont(new Font("Verdana", Font.BOLD, 16));
        botaoIniciar.setForeground(new Color(100, 31, 22));
        botaoIniciar.setBackground((new Color(232,232,232)));
        jpnTelaMenu.add(botaoIniciar);
                  
        botaoRegras = new JButton("Regras");
        botaoRegras.setBounds(170, 230, 150, 40);
        botaoRegras.setFont(new Font("Verdana", Font.BOLD, 16));
        botaoRegras.setForeground(new Color(100, 31, 22));
        botaoRegras.setBackground((new Color(232,232,232)));
        jpnTelaMenu.add(botaoRegras);
        
        botaoSair = new JButton("Sair");
        botaoSair.setBounds(170, 310, 150, 40);
        botaoSair.setFont(new Font("Verdana", Font.BOLD, 16));
        botaoSair.setForeground(new Color(100, 31, 22));
        botaoSair.setBackground((new Color(232,232,232)));
        jpnTelaMenu.add(botaoSair);
        
        // Botão iniciar
        botaoIniciar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              // Usando o card layout para trocar de telas. JPanel principal e a tag dos panels secundários
              //dispose();
              JogoMemoriaMain.telaEscolhaNiveis();
        }
      });
        
        // Botão Regras
        botaoRegras.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              // Usando o card layout para trocar de telas. JPanel principal e a tag dos panels secundários
              JOptionPane.showMessageDialog(null, "Revezem-se lançando 2 cartas de cada vez\n" 
                      +"clicando nelas.\n" + "\n"
                      + "Se eles forem iguais, dê outra volta, se não,\n" 
                      +"vire-os de volta e perde uma vida.\n" 
                      +"\n" +"Quanto mais cartas você acerta, mais o\n" 
                      +"medidor aumenta o numero até 100.\n" +"\n" 
                      +"Quanto maior a dificuldade, maior a\n" 
                      +"quantidade e variedade de cartas.\n" + "\n" 
                      +"Pressione Esc caso queira abrir o menu.", "Regras Jogo Memória", JOptionPane.INFORMATION_MESSAGE);
        }
      });
        
        // Botão Sair
        botaoSair.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Usando o card layout para trocar de telas. JPanel principal e a tag dos panels secundários
             int respostaSaida = (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Aviso", JOptionPane.YES_NO_OPTION));
             if (respostaSaida == 0){
                dispose();
             }
        }
      });
    }
}



