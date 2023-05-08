import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
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

import telaNiveisDificuldadeJogo.TelaNiveisDificuldade;

public class MainFrame extends JFrame {
    private static final KeyListener tabListener = null;
    private static final Component btnLogin = null;
    private static final Component btnCancelar = null;
    protected static final String WARNING_MESSAGE = null;
    protected static final String JOptionPane = null;
    /**
     *
     */
    final private Font mainFont = new Font("Arial", Font.BOLD, 10);
    JTextField tfEmailUsuario, tfSenhaUsuario;
    /**
     * @param panel TODO
    **/
    
    public void initialize() {

        // Mudar cor dos botões
        UIManager.put("Button.background", Color.white);

        /************Form Panel**************/

        JLabel labelTitulo = new JLabel("Jogo da Memória", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));


        JLabel lbEmailUsuario = new JLabel("Login: ", SwingConstants.CENTER);
        lbEmailUsuario.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel lbSenhaUsuario = new JLabel("Senha: ", SwingConstants.CENTER);
        lbSenhaUsuario.setFont(new Font("Arial", Font.BOLD, 20));
        

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Obtém a dimensão da tela
        int screenWidth = (int) screenSize.getWidth(); // Obtém a largura da tela em pixels

        int numCols = (int) (screenWidth * 0.05); // Define o número de colunas como 5% da largura da tela

        tfEmailUsuario = new JTextField(10);
        tfEmailUsuario.setColumns(numCols); // Define o tamanho do campo de email
        tfSenhaUsuario = new JTextField(10);
        tfSenhaUsuario.setColumns(numCols); // Define o tamanho do campo de senha

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbEmailUsuario);
        formPanel.add(tfEmailUsuario);
        formPanel.add(lbSenhaUsuario);
        formPanel.add(tfSenhaUsuario);
        /************Buttons Panel**************/
        final JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailUsuario = tfEmailUsuario.getText();
                String senhaUsuario = tfSenhaUsuario.getText();
                
                // Instancia a próxima classe e a torna visível
                TelaNiveisDificuldade telaNiveisDificuldade = new TelaNiveisDificuldade();
                telaNiveisDificuldade.setVisible(true);
                
                // Fecha a janela de login
                dispose();
            }
        });
        
        final JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(mainFont);
        btnCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        Window window = SwingUtilities.getWindowAncestor((JButton)e.getSource());
        window.dispose();
    }
});

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfEmailUsuario.getText();
                String password = tfSenhaUsuario.getText();

                if (username == null || username.trim().isEmpty() ||
                        password == null || password.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Por favor, digite o usuário e a senha.",
                            "Erro de Login",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                   
                }
            }

            private String extracted() {
                return JOptionPane;
            }
        });
        

        btnLogin.setFont(new Font("Arial", Font.PLAIN, 12));
        btnLogin.setPreferredSize(new Dimension(80, 30));

        btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
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

