import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import regras.TelaRegras;
import telaNiveisDificuldadeJogo.TelaNiveisDificuldade;

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

public class MenuPrincipal extends JFrame {

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
        JButton btnReiniciarJogo = new JButton("Reiniciar");
        JButton btnSairJogo = new JButton("Sair do Jogo");
        
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TelaRegras telaRegras = new TelaRegras();
                telaRegras.setVisible(true);
            }
        });
        
        btnReiniciarJogo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TelaNiveisDificuldade telaReiniciarJogo = new TelaNiveisDificuldade();
                telaReiniciarJogo.setVisible(true);
            }
        });
        
        btnSairJogo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja sair do jogo?", "Aviso", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    // Fecha a janela
                    Window window = SwingUtilities.getWindowAncestor((JButton)e.getSource());
                    window.dispose();
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
        painelBotoes.add(btnReiniciarJogo, gbc);
        painelBotoes.add(btnSairJogo, gbc);
        
        painelBotoes.setBackground(new Color(255, 153, 153)); // Define a cor de fundo do painel de botões

        painelMenuPrincipal.add(painelBotoes, BorderLayout.CENTER);
        getContentPane().add(painelMenuPrincipal);
    }

    public static void main(String[] args) {

        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        menu.setResizable(false);
        
    }
}
