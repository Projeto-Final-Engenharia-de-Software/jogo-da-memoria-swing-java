package telaLogin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import telas.TelaNiveisDificuldade;

public class MainFrame extends JFrame {
    /**
     *
     */
    final private Font mainFont = new Font("Verdana", Font.BOLD, 10);
    JTextField tfLoginUsuario, tfSenhaUsuario;
    /**
     * @param panel TODO
    **/
    
    public void initialize() {

        // Mudar cor dos botões
        UIManager.put("Button.background", Color.white);

        /************Form Panel**************/

        JLabel labelTitulo = new JLabel("Jogo da Memória", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Verdana", Font.ITALIC, 20));
        labelTitulo.setForeground(new Color(139, 69, 19)); // marrom

        JLabel lbLoginUsuario = new JLabel("Login: ", SwingConstants.CENTER);
        lbLoginUsuario.setFont(new Font("Verdana", Font.ITALIC, 20));
        lbLoginUsuario.setForeground(new Color(139, 69, 19)); // marrom

        JLabel lbSenhaUsuario = new JLabel("Senha: ", SwingConstants.CENTER);
        lbSenhaUsuario.setFont(new Font("Verdana", Font.ITALIC, 20));
        lbSenhaUsuario.setForeground(new Color(139, 69, 19)); // marrom

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Obtém a dimensão da tela
        int screenWidth = (int) screenSize.getWidth(); // Obtém a largura da tela em pixels

        int numCols = (int) (screenWidth * 0.05); // Define o número de colunas como 5% da largura da tela

        tfLoginUsuario = new JTextField(10);
        tfLoginUsuario.setColumns(numCols); // Define o tamanho do campo de login
        tfSenhaUsuario = new JTextField(10);
        tfSenhaUsuario.setColumns(numCols); // Define o tamanho do campo de senha

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbLoginUsuario);
        formPanel.add(tfLoginUsuario);
        formPanel.add(lbSenhaUsuario);
        formPanel.add(tfSenhaUsuario);
        /************Buttons Panel**************/
        final JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginUsuario = tfLoginUsuario.getText();
                String senhaUsuario = tfSenhaUsuario.getText();
                
                dispose();
            }
        });
        
        final JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(mainFont);

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UIManager.put("OptionPane.yesButtonText", "Sim");
                UIManager.put("OptionPane.noButtonText", "Não");
        
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja sair do jogo?", "Aviso", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    // Fecha a janela
                    Window window = SwingUtilities.getWindowAncestor((JButton)e.getSource());
                    window.dispose();
                }
            }
        });


btnLogin.addActionListener(new ActionListener() {
    /**
     * @param e
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        String nickname = tfLoginUsuario.getText();
        String senhaUsuario = tfSenhaUsuario.getText();

        // Verifica se os campos estão vazios

        if (nickname.isEmpty() || senhaUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválida!", "Aviso", JOptionPane.ERROR_MESSAGE);
            return; // Parada no código
        } else {
        // Avança para a próxima tela
        TelaNiveisDificuldade tela = new TelaNiveisDificuldade();
        tela.setVisible(true);

        return; // Parada no código
        }
    }
}); 

        // Cria uma borda com espaçamento de 10 pixels

        btnLogin.setFont(new Font("Verdana", Font.PLAIN, 12));
        btnLogin.setPreferredSize(new Dimension(80, 30));

        btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 12));
        btnCancelar.setPreferredSize(new Dimension(80, 30));
    

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 20, 10));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnCancelar);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(255, 153, 153));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(labelTitulo, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        
        add(mainPanel);

        // Adicionar um ouvinte de eventos para detectar a tecla Tab

        KeyAdapter tabListener = new KeyAdapter() {
            public void KeyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_TAB){
                    e.consume();
                }
            }
        };

        setTitle("Área de Login");
        setSize(400, 300);
        setMaximumSize(new Dimension(600, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    protected void JOptionPane() {
    }

    protected Object ERROR_MESSAGE() {
        return null;
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}