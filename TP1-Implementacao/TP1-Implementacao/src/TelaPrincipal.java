import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class                    TelaPrincipal extends JFrame{
    //private JFrame frame = new JFrame();

    public TelaPrincipal() {
        super("Locadora de Veículos v1.0");
        this.setLayout(null);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);


        JLabel lTitulo = new JLabel("Relâmpago - Locadora de Veículos");
        lTitulo.setBounds(15, 10, 450, 30);
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Dialog",Font.PLAIN,20));
        this.add(lTitulo);

        JLabel lDesc = new JLabel("Sistema de Aluguel e Controle");
        lDesc.setBounds(15, 40, 450, 20);
        lDesc.setHorizontalAlignment(SwingConstants.CENTER);
        lDesc.setFont(new Font("Dialog", Font.PLAIN, 13));
        this.add(lDesc);

        JButton bAluguel = new JButton("Aluguel de veículos");
        bAluguel.setBounds(115, 80, 260, 30);
        bAluguel.setBackground(Color.lightGray);
        this.add(bAluguel);
        bAluguel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroCliente cdrcli = new CadastroCliente();
                cdrcli.setVisible(true);
            }
        });

        JButton bContcarro = new JButton("Controle de veículos");
        bContcarro.setBounds(115, 120, 260, 30);
        bContcarro.setBackground(Color.lightGray);
        this.add(bContcarro);
        bContcarro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removerVeiculo cot = null;
                try {
                    cot = new removerVeiculo();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                cot.frame.setVisible(true);
            }
        });

        JButton bContcliente = new JButton("Controle de clientes");
        bContcliente.setBounds(115, 160, 260, 30);
        bContcliente.setBackground(Color.LIGHT_GRAY);
        this.add(bContcliente);
        bContcliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ControleClientes ctCli = null;
                try {
                    ctCli = new ControleClientes();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                ctCli.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        TelaPrincipal tPrinc = new TelaPrincipal();
        tPrinc.setVisible(true);
    }
}

