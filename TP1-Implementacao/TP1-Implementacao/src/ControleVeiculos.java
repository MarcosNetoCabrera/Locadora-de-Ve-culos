import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ControleVeiculos extends JFrame {

    public ControleVeiculos() {
        super("Locadora de Veículos v1.0");
        this.setLayout(null);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lTitulo = new JLabel("Controle de veículos");
        lTitulo.setBounds(15, 10, 450, 30);
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Dialog",Font.PLAIN,20));
        this.add(lTitulo);

        JLabel lDesc = new JLabel("Escolha uma opção a baixo:");
        lDesc.setBounds(15, 40, 450, 20);
        lDesc.setHorizontalAlignment(SwingConstants.CENTER);
        lDesc.setFont(new Font("Dialog", Font.PLAIN, 13));
        this.add(lDesc);

        JButton bcadastro = new JButton("Cadastrar novo veículo");
        bcadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastroVeiculo cad = null;
                try {
                    cad = new cadastroVeiculo();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                cad.setVisible(true);
            }
        });
        bcadastro.setBounds(115, 80, 260, 30);
        this.add(bcadastro);

        JButton bremover = new JButton("Remover veículo cadastrado");
        bremover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        bremover.setBounds(115, 120, 260, 30);
        this.add(bremover);

        JButton bbalterar = new JButton("Alterar informações sobre um veículo");
        bbalterar.setBounds(115, 160, 260, 30);
        this.add(bbalterar);

        JButton brelatorio = new JButton("Relatório sobre os Veículos");
        brelatorio.setBounds(115, 200, 260, 30);
        this.add(brelatorio);

    }

}
