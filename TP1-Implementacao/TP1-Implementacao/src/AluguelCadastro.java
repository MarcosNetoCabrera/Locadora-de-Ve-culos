import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AluguelCadastro extends JFrame {

    DefaultTableModel modelo2 = new DefaultTableModel();
    JTable carros2 = new JTable(modelo2);
    JScrollPane barraRolagem3 = new JScrollPane(carros2);

    public void attabela2() throws SQLException, ClassNotFoundException {

        DefaultTableModel modelo = new DefaultTableModel();
        JTable carros2 = new JTable(modelo);

        Object [][] table = TabelaVeiculo2();
        carros2.setModel(new DefaultTableModel(table,new String[]{"Placa","Categoria"
                ,"Passageiros","Tam. bagageiro","Tipo de câmbio","Possui ar cond.",
                "Consumo(km/l)","Acessórios","Custo por dia"}));
        JScrollPane barraRolagem3 = new JScrollPane(carros2);
        barraRolagem3.setBounds(30, 80, 925, 180);
        barraRolagem3.setFont(new Font("Dialog",Font.PLAIN,10));
        this.add(barraRolagem3);
    }
    public Object [][] TabelaVeiculo2() throws SQLException, ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) carros2.getModel();

        CarroDAO carro = new CarroDAO();
        //ClienteDAO cliente = new ClienteDAO();
        Object[][] dados = new Object[carro.numLinhaTabela2()][9];
        int i = 0;
        for(Carro car : carro.tabelaCarros2()) {

            dados[i][0] = car.getPlaca();
            dados[i][1] = car.getCategoria();
            dados[i][2] = Integer.toString(car.getNumero_maximo_de_passageiros());
            dados[i][3] = car.getTamanho_do_bagageiro();
            dados[i][4] = car.getTipo_de_cambio();
            dados[i][5] = car.getPossui_ar_condicionado();
            dados[i][6] = Integer.toString(car.getMedia_de_consumo());
            dados[i][7] = car.getAcessorios();
            dados[i][8] = Integer.toString(car.getCusto_por_dia());
            i++;
        }
        return dados;
    }

    public AluguelCadastro() throws SQLException, ClassNotFoundException {
        super("Locadora de Veículos v1.0");
        this.setLayout(null);
        this.setSize(1000, 550);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lTitulo = new JLabel("Aluguel de veículos");
        lTitulo.setBounds(200, 10, 600, 35);
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Dialog",Font.PLAIN,30));
        this.add(lTitulo);

        JLabel lDesc = new JLabel("Veículos disponiveis:");
        lDesc.setBounds(200, 45, 600, 22);
        lDesc.setHorizontalAlignment(SwingConstants.CENTER);
        lDesc.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(lDesc);

        attabela2();

        JTextField getPlaca = new JTextField();
        //getPlaca.setBackground(new Color(255, 255, 230));
        getPlaca.setBounds(29, 320, 280, 30);
        getPlaca.setText("Insira a placa do carro desejado");
        getPlaca.setFont(new Font("Dialog", Font.PLAIN, 15));
        getPlaca.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(getPlaca);

        JTextField getCPF = new JTextField();
        //getPlaca.setBackground(new Color(255, 255, 230));
        getCPF.setBounds(29, 280, 280, 30);
        getCPF.setText("Insira um  CPF cadastrado");
        getCPF.setFont(new Font("Dialog", Font.PLAIN, 15));
        getCPF.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(getCPF);

        String[] loc = {"Selecione o Local de retirada","Agencia cidade nova","Agencia Aeroporto Manaus","Agencia Centro","Agencia UFAM","Agencia Ponta Negra"};
        JComboBox getAgencia = new JComboBox(loc);
        getAgencia.setBackground(Color.WHITE);
        getAgencia.setBounds(353, 280, 280, 30);
        getAgencia.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getAgencia);

        JTextField getDataRet = new JTextField();
        //getPlaca.setBackground(new Color(255, 255, 230));
        getDataRet.setBounds(676, 280, 280, 30);
        getDataRet.setText("Insira a data de retirada (dd/mm/yyyy)");
        getDataRet.setFont(new Font("Dialog", Font.PLAIN, 15));
        getDataRet.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(getDataRet);

        String[] loc1 = {"Selecione o Local de devolução","Agencia cidade nova","Agencia Aeroporto Manaus","Agencia Centro","Agencia UFAM","Agencia Ponta Negra"};
        JComboBox getAgenciaDev = new JComboBox(loc1);
        getAgenciaDev.setBackground(Color.WHITE);
        getAgenciaDev.setBounds(353, 320, 280, 30);
        getAgenciaDev.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getAgenciaDev);

        JTextField getDataDev = new JTextField();
        //getPlaca.setBackground(new Color(255, 255, 230));
        getDataDev.setBounds(676, 320, 280, 30);
        getDataDev.setText("Insira a data de devolução (dd/mm/yyyy)");
        getDataDev.setFont(new Font("Dialog", Font.PLAIN, 15));
        getDataDev.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(getDataDev);

        JLabel opc = new JLabel("Opcionais:");
        opc.setBounds(29, 360, 600, 30);
        opc.setHorizontalAlignment(SwingConstants.LEFT);
        opc.setFont(new Font("Dialog", Font.PLAIN, 20));
        this.add(opc);

        JRadioButton op1 = new JRadioButton("GPS - Custo: R$ 200");
        op1.setBounds(28, 390, 165, 30);
        op1.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(op1);

        JRadioButton op2 = new JRadioButton("Assentos para crianças  - Custo: R$ 700");
        op2.setBounds(200, 390, 300, 30);
        op2.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(op2);

        JRadioButton op3 = new JRadioButton("Seguro completo - R$ 3000");
        op3.setBounds(500, 390, 280, 30);
        op3.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(op3);

        JButton bConf = new JButton("Confirmar Dados e alugar o Veiculo");
        bConf.setBounds(29, 450, 928, 35);
        bConf.setBackground(Color.lightGray);
        this.add(bConf);
        bConf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    ClienteDAO cliDAO = new ClienteDAO();
                    Cliente c = cliDAO.buscaCliente(getCPF.getText());
                    int opc = 0;
                    String placa = getPlaca.getText();
                    String nome = c.getNomeCompleto();
                    int idade = c.getIdade();
                    if(idade < 18){
                        JOptionPane.showMessageDialog(null, "So é permitido o Aluguel de carros para maiores de 18 anos","Aviso",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }else{
                        String LocalRetirada = (String) getAgencia.getSelectedItem();
                        String DataRet = getDataRet.getText();
                        String LocalDevolucao = (String) getAgenciaDev.getSelectedItem();
                        String DataDev = getDataDev.getText();
                        String opcionais = "";
                        if(op1.isSelected()) {
                            opc += 200;
                            opcionais+="GPS ";
                        }
                        if(op2.isSelected()) {
                            opc += 700;
                            opcionais+="Assentos para crianças ";
                        }
                        if(op3.isSelected()) {
                            opc += 3000;
                            opcionais+="Seguro completo ";
                        }
                        CarroDAO carroDAO = new CarroDAO();

                        int valor = carroDAO.TotalPagamento(placa,DataRet,DataDev,opc);
                        if(valor == -1){
                            JOptionPane.showMessageDialog(null, "A data de devolução deve ser maior que a de retirada","Aviso",JOptionPane.ERROR_MESSAGE);
                        }else{
                            int esc = JOptionPane.showConfirmDialog(null,"O valor total das diárias mais os opcionais escolhidos será de R$ "+valor+", você deseja confirmar o aluguel ?","Confirmação",JOptionPane.YES_NO_CANCEL_OPTION);
                            if(esc == 0){
                                AluguelDAO clienteDAO = new AluguelDAO();
                                Aluguel cli = new Aluguel(placa,getCPF.getText(),nome,idade,LocalRetirada,DataRet,LocalDevolucao,DataDev,opcionais,valor);
                                clienteDAO.adicionarCliente(cli);
                                JOptionPane.showMessageDialog(null,"Parabéns seu veículo foi alugado com sucesso, obrigado por escolher a relâmpago locadora de veiculos!!!",
                                        "Aviso",JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                            }
                        }
                    }
                }catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar Alugar o veículo, verifique as informações e tente novamente","Aviso",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

   /* public static void main(String args[]) throws SQLException, ClassNotFoundException {
        AluguelCadastro alug = new AluguelCadastro();
        alug.setVisible(true);
    }*/
}
