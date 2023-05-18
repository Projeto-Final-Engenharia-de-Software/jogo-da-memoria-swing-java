package regras;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;

public class TelaRegras extends JFrame {

    /**
     * 
     */
    public TelaRegras() {
        setTitle("Regras do Jogo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 400);
        setResizable(false);

        // Mudar a cor do botão

        UIManager.put("Button.background", Color.white);

        // Define a cor de fundo da janela para rosa claro
        getContentPane().setBackground(new Color(255, 153, 153));

        JPanel painelRegrasJogo = new JPanel();

        painelRegrasJogo.setLayout(new BoxLayout(painelRegrasJogo, BoxLayout.Y_AXIS));

        painelRegrasJogo.setBackground(new Color(255, 153, 153));
        painelRegrasJogo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelTituloRegrasJogo = new JLabel("Regras do Jogo", SwingConstants.CENTER);
        labelTituloRegrasJogo.setFont(new Font("Verdana", Font.BOLD, 20));
        labelTituloRegrasJogo.setForeground(new Color(139, 69, 19));
        painelRegrasJogo.add(labelTituloRegrasJogo);

        painelRegrasJogo.add(Box.createVerticalStrut(20));

        JLabel labelTituloRegrasJogo1 = new JLabel("Revezem-se lançando 2 cartas de cada vez clicando nelas.", SwingConstants.CENTER);
        labelTituloRegrasJogo1.setFont(new Font("Verdana", Font.ITALIC, 20));
        labelTituloRegrasJogo1.setForeground(new Color(139, 69, 19));
        painelRegrasJogo.add(labelTituloRegrasJogo1);

        painelRegrasJogo.add(Box.createVerticalStrut(20));

        JLabel labelTituloRegrasJogo2 = new JLabel("Se eles forem iguais, dê outra volta, se não, vire-os de volta e perde uma vida.", SwingConstants.CENTER);
        labelTituloRegrasJogo2.setFont(new Font("Verdana", Font.ITALIC, 20));
        labelTituloRegrasJogo2.setForeground(new Color(139, 69, 19));
        painelRegrasJogo.add(labelTituloRegrasJogo2);

        painelRegrasJogo.add(Box.createVerticalStrut(20));

        JLabel labelTituloRegrasJogo3 = new JLabel("Quanto mais cartas você acerta, mais o medidor aumenta o número até 100.", SwingConstants.CENTER);
        labelTituloRegrasJogo3.setFont(new Font("Verdana", Font.ITALIC, 20));
        labelTituloRegrasJogo3.setForeground(new Color(139, 69, 19));
        painelRegrasJogo.add(labelTituloRegrasJogo3);

        painelRegrasJogo.add(Box.createVerticalStrut(20));

        JLabel labelTituloRegrasJogo4 = new JLabel("Quanto maior a dificuldade, maior a quantidade e variedade de cartas.", SwingConstants.CENTER);
        labelTituloRegrasJogo4.setFont(new Font("Verdana", Font.ITALIC, 20));
        labelTituloRegrasJogo4.setForeground(new Color(139, 69, 19));
        painelRegrasJogo.add(labelTituloRegrasJogo4);

        painelRegrasJogo.add(Box.createVerticalStrut(20));

        // Crie um painel para os botões
        JPanel painelBotoes = new JPanel(new GridBagLayout());

        // Crie uma restrição para o GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 1.0;
        
        JButton btnContinuar = new JButton("Continuar");
        
        btnContinuar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });


        getContentPane().add(painelRegrasJogo);
    }

    public static void main(String[] args) {
        TelaRegras tela = new TelaRegras();
        tela.setVisible(true);
    }
}
