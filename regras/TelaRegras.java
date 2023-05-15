package regras;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaRegras extends JFrame {
    public TelaRegras(){
    UIManager.put("Button.background", Color.white);
    JLabel labelTituloRegrasJogo = new JLabel("Regras", SwingConstants.CENTER);
    labelTituloRegrasJogo.setFont(new Font("Verdana", Font.ITALIC, 20));
    labelTituloRegrasJogo.setForeground(new Color(139, 69, 19)); // marrom

    JLabel labelTituloRegrasJogo1 = new JLabel("Regras", SwingConstants.CENTER);
    labelTituloRegrasJogo1.setFont(new Font("Verdana", Font.ITALIC, 20));
    labelTituloRegrasJogo1.setForeground(new Color(139, 69, 19)); // marrom

    JLabel labelTituloRegrasJogo2 = new JLabel("Regras", SwingConstants.CENTER);
    labelTituloRegrasJogo2.setFont(new Font("Verdana", Font.ITALIC, 20));
    labelTituloRegrasJogo2.setForeground(new Color(139, 69, 19)); // marrom

    JLabel labelTituloRegrasJogo3 = new JLabel("Regras", SwingConstants.CENTER);
    labelTituloRegrasJogo3.setFont(new Font("Verdana", Font.ITALIC, 20));
    labelTituloRegrasJogo3.setForeground(new Color(139, 69, 19)); // marrom

    JLabel labelTituloRegrasJogo4 = new JLabel("Regras", SwingConstants.CENTER);
    labelTituloRegrasJogo4.setFont(new Font("Verdana", Font.ITALIC, 20));
    labelTituloRegrasJogo4.setForeground(new Color(139, 69, 19)); // marrom

    setSize(600, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Define a cor de fundo da janela para rosa claro
    getContentPane().setBackground(new Color(255, 153, 153));

    // Crie um painel para a JLabel e os botões
    JPanel painelRegrasJogo = new JPanel(new BorderLayout());

    // Adicione a JLabel
    JLabel labelTituloRegrasJogo1 = new JLabel("Regras", SwingConstants.CENTER);
    labelTituloRegrasJogo1.setFont(new Font("Verdana", Font.ITALIC, 16));
    labelTituloRegrasJogo1.setForeground(new Color(139, 69, 19)); // marrom
    painelRegrasJogo.add(labelTituloRegrasJogo1, BorderLayout.NORTH);

    JLabel labelTituloRegrasJogo2 = new JLabel("Regras",Swing.SwingConstants.CENTER);
    labelTituloRegrasJogo2.setFont(new Font("Verdana", Font.ITALIC, 16));
    labelTituloRegrasJogo2.setForeground(new Color(139, 69, 19)); // marrom
    painelRegrasJogo.add(labelTituloRegrasJogo1, BorderLayout.NORTH);

    }
}
