import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CadastroCliente extends JFrame {
    public CadastroCliente(){
        super("Locadora de Veículos v1.0");
        this.setLayout(null);
        this.setSize(500, 350);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lTitulo = new JLabel("Cadastro de novo cliente");
        lTitulo.setBounds(15, 10, 450, 30);
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Dialog",Font.PLAIN,20));
        this.add(lTitulo);

        JLabel lDesc = new JLabel("Insira suas informações abaixo:");
        lDesc.setBounds(15, 40, 450, 20);
        lDesc.setHorizontalAlignment(SwingConstants.CENTER);
        lDesc.setFont(new Font("Dialog", Font.PLAIN, 13));
        this.add(lDesc);

        JLabel lCPF = new JLabel("CPF:");
        lCPF.setBounds(5, 80, 50, 30);
        lCPF.setForeground(Color.BLACK);
        lCPF.setHorizontalAlignment(SwingConstants.LEFT);
        lCPF.setForeground(Color.BLACK);
        this.add(lCPF);

        JTextField getCPF = new JTextField();
        getCPF.setBackground(Color.white);
        getCPF.setBounds(160, 80, 280, 30);
        getCPF.setText("Insira seu cpf");
        getCPF.setFont(new Font("Dialog", Font.PLAIN, 15));
        getCPF.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(getCPF);

        JLabel lNomeCompleto = new JLabel("Nome Completo:");
        lNomeCompleto.setBounds(5, 120, 120, 30);
        lNomeCompleto.setHorizontalAlignment(SwingConstants.LEFT);
        lNomeCompleto.setForeground(Color.BLACK);
        lNomeCompleto.setBackground(new Color(255, 255, 230));
        this.add(lNomeCompleto);

        JTextField getNomeCompleto = new JTextField();
        getNomeCompleto.setBackground(Color.white);
        getNomeCompleto.setBounds(160, 120, 280, 30);
        getNomeCompleto.setText("Insira seu nome completo");
        getNomeCompleto.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getNomeCompleto);

        JLabel lIdade = new JLabel("Idade:");
        lIdade.setBounds(5, 160, 150, 30);
        lIdade.setHorizontalAlignment(SwingConstants.LEFT);
        lIdade.setForeground(Color.BLACK);
        lIdade.setBackground(new Color(255, 255, 230));
        this.add(lIdade);

        JTextField getIdade = new JTextField();
        getIdade.setBackground(Color.white);
        getIdade.setBounds(160, 160, 280, 30);
        getIdade.setText("Insira sua idade");
        getIdade.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getIdade);

        JButton bConf = new JButton("Confirmar Cadastro");
        bConf.setBounds(160, 220, 280, 30);
        bConf.setBackground(Color.LIGHT_GRAY);
        this.add(bConf);
        bConf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String CPF = getCPF.getText();
                    String Nome = getNomeCompleto.getText();
                    String num = getIdade.getText();
                    int idade = Integer.parseInt(num);
                    Cliente c = new Cliente(CPF,Nome,idade);
                    ClienteDAO cli = new ClienteDAO();
                    cli.addCliente(c);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso, Bem vindo!","Aviso",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    AluguelCadastro alug = new AluguelCadastro();
                    alug.setVisible(true);
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cadastrar o veículo, tente novamente","Aviso",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton bJaCadastrado = new JButton("Já tenho um cadastro");
        bJaCadastrado.setBounds(160, 260, 280, 30);
        bJaCadastrado.setBackground(Color.LIGHT_GRAY);
        this.add(bJaCadastrado);
        bJaCadastrado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AluguelCadastro alug = null;
                try {
                    alug = new AluguelCadastro();
                    dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                alug.setVisible(true);
            }
        });

    }
    /*public static void main(String args[])throws ClassNotFoundException, SQLException {
        CadastroCliente cad = new CadastroCliente();
        cad.setVisible(true);
    }*/
}
