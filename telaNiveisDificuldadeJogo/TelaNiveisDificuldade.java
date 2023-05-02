package telaNiveisDificuldadeJogo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaNiveisDificuldade extends JFrame {

    public TelaNiveisDificuldade() {
        super("Escolha o nível de dificuldade do jogo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define a cor de fundo da janela para rosa claro
        getContentPane().setBackground(new Color(255, 153, 153));

        // Crie um painel para a JLabel e os botões
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Adicione a JLabel
        JLabel label = new JLabel("Escolha o nível de dificuldade do jogo", SwingConstants.CENTER);
        label.setFont(new Font("Segoe print", Font.BOLD, 16));
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
        
            }
        });
        
        btnNivelMedio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
        
            }
        });
        
        btnNivelDificil.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
        
            }
        });
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10); // Adiciona espaçamento de 10 pixels em todas as direções
        
        // Adicione os botões ao painel com a restrição de preenchimento
        painelBotoes.add(btnNivelFacil, gbc);
        painelBotoes.add(btnNivelMedio, gbc);
        painelBotoes.add(btnNivelDificil, gbc);
        painelBotoes.setBackground(new Color(255, 153, 153));

        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);
        getContentPane().add(painelPrincipal);

        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args){
        new TelaNiveisDificuldade();
    }
}
