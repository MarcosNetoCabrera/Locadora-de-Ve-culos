import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class cadastroVeiculo extends JFrame {


    public cadastroVeiculo() throws SQLException, ClassNotFoundException {
        super("Locadora de Veículos v1.0");
        this.setLayout(null);
        this.setSize(500, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lTitulo = new JLabel("Controle de veículos");
        lTitulo.setBounds(15, 10, 450, 30);
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Dialog",Font.PLAIN,20));
        this.add(lTitulo);

        JLabel lDesc = new JLabel("Cadastro de veículo");
        lDesc.setBounds(15, 40, 450, 20);
        lDesc.setHorizontalAlignment(SwingConstants.CENTER);
        lDesc.setFont(new Font("Dialog", Font.PLAIN, 13));
        this.add(lDesc);

        JLabel lPlaca = new JLabel("Placa:");
        lPlaca.setBounds(5, 80, 50, 30);
        lPlaca.setHorizontalAlignment(SwingConstants.LEFT);
        lPlaca.setForeground(Color.BLACK);
        this.add(lPlaca);

        JTextField getPlaca = new JTextField();
        getPlaca.setBackground(Color.white);
        getPlaca.setBounds(160, 80, 280, 30);
        getPlaca.setText("Insira a Placa (ex: XXX-1234)");
        getPlaca.setFont(new Font("Dialog", Font.PLAIN, 15));
        getPlaca.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(getPlaca);

        JLabel lCategoria = new JLabel("Categoria:");
        lCategoria.setBounds(5, 120, 60, 30);
        lCategoria.setHorizontalAlignment(SwingConstants.LEFT);
        lCategoria.setForeground(Color.BLACK);
        lCategoria.setBackground(new Color(255, 255, 230));
        this.add(lCategoria);

        String[] cat = {"Compacto","Standard","Grande","Econômico","Premium","Minivan"};
        JComboBox getCategooria = new JComboBox(cat);
        getCategooria.setBackground(Color.white);
        getCategooria.setBounds(160, 120, 280, 30);
        getCategooria.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getCategooria);

        JLabel lnumMax = new JLabel("Passageiros:");
        lnumMax.setBounds(5, 160, 80, 30);
        lnumMax.setHorizontalAlignment(SwingConstants.LEFT);
        lnumMax.setForeground(Color.BLACK);
        lnumMax.setBackground(new Color(255, 255, 230));
        this.add(lnumMax);

        JTextField getnumMax = new JTextField();
        getnumMax.setBackground(Color.white);
        getnumMax.setBounds(160, 160, 280, 30);
        getnumMax.setText("Número máxímo de passageiros");
        getnumMax.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getnumMax);

        JLabel ltamBag = new JLabel("Tamanho do Bagageiro:");
        ltamBag.setBounds(5, 200, 180, 30);
        ltamBag.setHorizontalAlignment(SwingConstants.LEFT);
        ltamBag.setForeground(Color.BLACK);
        ltamBag.setBackground(new Color(255, 255, 230));
        this.add(ltamBag);

        String[] t = {"Grande","Médio","Pequeno"};
        JComboBox getTamBag = new JComboBox(t);
        getTamBag.setBackground(Color.white);
        getTamBag.setBounds(160, 200, 280, 30);
        getTamBag.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getTamBag);

        JLabel ltipoCambio = new JLabel("Câmbio:");
        ltipoCambio.setBounds(5, 240, 80, 30);
        ltipoCambio.setHorizontalAlignment(SwingConstants.LEFT);
        ltipoCambio.setForeground(Color.BLACK);
        ltipoCambio.setBackground(new Color(255, 255, 230));
        this.add(ltipoCambio);

        String[] c = {"Manual","Automático"};
        JComboBox getTipocambio = new JComboBox(c);
        getTipocambio.setBackground(Color.white);
        getTipocambio.setBounds(160, 240, 280, 30);
        getTipocambio.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getTipocambio);

        JLabel lPssAr= new JLabel("Possui ar condicionado:");
        lPssAr.setBounds(5, 280, 150, 30);
        lPssAr.setHorizontalAlignment(SwingConstants.LEFT);
        lPssAr.setForeground(Color.BLACK);
        lPssAr.setBackground(new Color(255, 255, 230));
        this.add(lPssAr);

        String[] s = {"Sim","Não"};
        JComboBox getAR = new JComboBox(s);
        getAR.setBackground(Color.white);
        getAR.setBounds(160, 280, 280, 30);
        getAR.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getAR);

        JLabel lMedcons= new JLabel("Média de consumo(km/l):");
        lMedcons.setBounds(5, 320, 150, 30);
        lMedcons.setHorizontalAlignment(SwingConstants.LEFT);
        lMedcons.setForeground(Color.BLACK);
        lMedcons.setBackground(new Color(255, 255, 230));
        this.add(lMedcons);

        JTextField getMedcons = new JTextField();
        getMedcons.setBackground(Color.white);
        getMedcons.setBounds(160, 320, 280, 30);
        getMedcons.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getMedcons);

        JLabel lAcess= new JLabel("Acessórios:");
        lAcess.setBounds(5, 360, 150, 30);
        lAcess.setHorizontalAlignment(SwingConstants.LEFT);
        lAcess.setForeground(Color.BLACK);
        lAcess.setBackground(new Color(255, 255, 230));
        this.add(lAcess);

        JTextField getAcess = new JTextField();
        getAcess.setBackground(Color.white);
        getAcess.setBounds(160, 360, 280, 30);
        getAcess.setText("Airbag,Freio ABS ou DVD");
        getAcess.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getAcess);

        JLabel lCusto= new JLabel("Custo por dia (R$):");
        lCusto.setBounds(5, 400, 150, 30);
        lCusto.setHorizontalAlignment(SwingConstants.LEFT);
        lCusto.setForeground(Color.BLACK);
        lCusto.setBackground(new Color(255, 255, 230));
        this.add(lCusto);

        JTextField getCusto = new JTextField();
        getCusto.setBackground(Color.white);
        getCusto.setBounds(160, 400, 280, 30);
        getCusto.setText("Valor");
        getCusto.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getCusto);

        JButton bConf = new JButton("Confirmar Cadastro");
        bConf.setBounds(160, 460, 280, 30);
        bConf.setBackground(Color.LIGHT_GRAY);
        this.add(bConf);
        bConf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String placa = getPlaca.getText();
                    String categoria = (String) getCategooria.getSelectedItem();
                    String num = getnumMax.getText();
                    int num_passageiros = Integer.parseInt(num);
                    String tam_bag = (String) getTamBag.getSelectedItem();
                    String tipo_cambio = (String) getTipocambio.getSelectedItem();
                    String possui_ar = (String) getAR.getSelectedItem();
                    String md = getMedcons.getText();
                    int media_consumo = Integer.parseInt(md);
                    String acessorios = getAcess.getText();
                    String c = getCusto.getText();
                    int custo_por_dia = Integer.parseInt(c);
                    CarroDAO carroDAO = new CarroDAO();
                    Carro carro = new Carro(placa, categoria, num_passageiros, tam_bag, tipo_cambio, possui_ar, media_consumo, acessorios, custo_por_dia);
                    carroDAO.adicionarCarro(carro);
                    JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!","Aviso",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cadastrar o veículo, tente novamente","Aviso",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /*public static void main(String args[])throws ClassNotFoundException, SQLException {
        cadastroVeiculo cad = new cadastroVeiculo();
        cad.setVisible(true);


    }*/
}
