import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class removerVeiculo extends CarroDAO {
    JFrame frame;
    DefaultTableModel modelo = new DefaultTableModel();
    JTable carros = new JTable(modelo);
    JScrollPane barraRolagem = new JScrollPane(carros);


    public removerVeiculo () throws SQLException, ClassNotFoundException {
        frame = new JFrame("Locadora de Veículos v1.0");
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(1000, 650));

        JLabel lTitulo = new JLabel("Controle de veículos");
        lTitulo.setBounds(200, 10, 600, 30);
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Dialog",Font.PLAIN,30));
        this.frame.add(lTitulo);

        JLabel lDesc = new JLabel("Cadastrar, Remover ou Alterar veículos");
        lDesc.setBounds(200, 40, 600, 22);
        lDesc.setHorizontalAlignment(SwingConstants.CENTER);
        lDesc.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.frame.add(lDesc);

        JLabel opc = new JLabel("Relatório");
        opc.setBounds(29, 210, 600, 30);
        opc.setHorizontalAlignment(SwingConstants.LEFT);
        opc.setFont(new Font("Dialog", Font.PLAIN, 20));
        this.frame.add(opc);

        attabela();

        JButton btCadastro = new JButton("Cadastrar veículo");
        btCadastro.setBounds(35, 80, 300, 50);
        btCadastro.setHorizontalAlignment(SwingConstants.CENTER);
        btCadastro.setBackground(Color.lightGray);
        this.frame.add(btCadastro);
        btCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    cadastroVeiculo cad = new cadastroVeiculo();
                    cad.setVisible(true);
                    attabela();
                }catch (Exception e4){}

            }
        });

        JButton btremov= new JButton("Remover veículo");
        btremov.setBounds(342, 80, 300, 50);
        btremov.setHorizontalAlignment(SwingConstants.CENTER);
        btremov.setBackground(Color.lightGray);
        this.frame.add(btremov);
        btremov.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    CarroDAO carop = new CarroDAO();
                    AluguelDAO alu = new AluguelDAO();
                    String Placa = JOptionPane.showInputDialog(null,"Digite a Placa do carro que deseja ser removido:","Aviso",JOptionPane.INFORMATION_MESSAGE);
                    if(carop.buscaCarro(Placa)==null){
                        JOptionPane.showMessageDialog(null,"Placa não encontrada","Erro",JOptionPane.ERROR_MESSAGE);
                    }else{
                        //int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza ?","Aviso",JOptionPane.YES_NO_CANCEL_OPTION);
                        if(alu.buscaCliente(Placa) == null){
                            carop.removeCarro(Placa);
                            attabela();
                            JOptionPane.showMessageDialog(null,"Veículo removido com sucesso","Aviso",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Este veículo esta alugado, não é possível remove-lo","Aviso",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }catch (Exception e3){ }
            }
        });
        String[] cat = {"Selecione uma opção para alterar","Placa","Categoria","Passageiros","Tam. bagageiro","Tipo de câmbio","Possui ar cond.",
                "Consumo(km/l)","Acessórios","Custo por dia"};
        JComboBox getaltera = new JComboBox(cat);
        getaltera.setBackground(Color.white);
        getaltera.setBounds(650, 80, 300, 50);
        getaltera.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.frame.add(getaltera);

        JButton btAltera = new JButton("Alterar dados de um veículo");
        btAltera.setBounds(650, 130, 300, 50);
        btAltera.setHorizontalAlignment(SwingConstants.CENTER);
        btAltera.setBackground(Color.lightGray);
        this.frame.add(btAltera);
        btAltera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    CarroDAO car22 = new CarroDAO();
                    String coluna = (String) getaltera.getSelectedItem();
                    if(coluna == "Selecione uma opção para alterar"){
                        JOptionPane.showMessageDialog(null,"Opção inválida, por favor tente novamente","Erro",JOptionPane.ERROR_MESSAGE);
                    }else{
                        String Placa = JOptionPane.showInputDialog(null,"Digite a Placa do carro que deseja alterar as informações:","Confirmação",JOptionPane.INFORMATION_MESSAGE);
                        if(buscaCarro(Placa)==null){
                            JOptionPane.showMessageDialog(null,"Placa não encontrada","Erro",JOptionPane.ERROR_MESSAGE);
                        }else{
                            String novoValor = JOptionPane.showInputDialog(null,"Digite o novo valor para "+getaltera.getSelectedItem()+":","Confirmação",JOptionPane.INFORMATION_MESSAGE);
                            if(car22.alteraColuna(Placa,coluna,novoValor)==false){
                                JOptionPane.showMessageDialog(null, "Não é possivel alterar a Placa deste carro pois, ele está alugado","Aviso",JOptionPane.ERROR_MESSAGE);
                            }else {
                                JOptionPane.showMessageDialog(null,getaltera.getSelectedItem()+" alterado com sucesso","Aviso",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        //attabela();
                    }
                }catch (Exception e3) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar Alterar o valor da coluna, tente novamente","Aviso",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton bDisponiveis = new JButton("Veículos disponíveis para aluguel");
        bDisponiveis.setBounds(29, 500, 300, 50);
        bDisponiveis.setHorizontalAlignment(SwingConstants.CENTER);
        bDisponiveis.setBackground(Color.lightGray);
        this.frame.add(bDisponiveis);
        bDisponiveis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    attabela2();
                }catch (Exception e1){

                }
            }
        });

        JButton bAlugados = new JButton("Veículos Alugados");
        bAlugados.setBounds(337, 500, 300, 50);
        bAlugados.setHorizontalAlignment(SwingConstants.CENTER);
        bAlugados.setBackground(Color.lightGray);
        this.frame.add(bAlugados);
        bAlugados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    attabela3();
                }catch (Exception e1){ }
            }
        });

        JButton bTodos = new JButton("Todos os veículos cadastrados");
        bTodos.setBounds(646, 500, 300, 50);
        bTodos.setHorizontalAlignment(SwingConstants.CENTER);
        bTodos.setBackground(Color.lightGray);
        this.frame.add(bTodos);
        bTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    attabela();
                }catch (Exception e1){ }

            }
        });
    }
    public Object [][] TabelaVeiculo() throws SQLException, ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) carros.getModel();

        CarroDAO carro = new CarroDAO();

        Object[][] dados = new Object[carro.numLinhaTabela()][9];
        int i =0;
        for(Carro car : carro.tabelaCarros()) {

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
    public void attabela() throws SQLException, ClassNotFoundException {

        DefaultTableModel modelo = new DefaultTableModel();
        JTable carros = new JTable(modelo);

        Object [][] table = TabelaVeiculo();
        carros.setModel(new DefaultTableModel(table,new String[]{"Placa","Categoria"
                ,"Passageiros","Tam. bagageiro","Tipo de câmbio","Possui ar cond.",
                "Consumo(km/l)","Acessórios","Custo por dia"}));
        JScrollPane barraRolagem2 = new JScrollPane(carros);
        barraRolagem2.setBounds(30, 240, 925, 250);
        barraRolagem2.setFont(new Font("Dialog",Font.PLAIN,10));
        this.frame.add(barraRolagem2);
    }
    public Object [][] TabelaVeiculo2() throws SQLException, ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) carros.getModel();

        CarroDAO carro = new CarroDAO();
        //ClienteDAO cliente = new ClienteDAO();
        Object[][] dados = new Object[carro.numLinhaTabela2()][9];
        int i =0;
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

    public void attabela2() throws SQLException, ClassNotFoundException {

        DefaultTableModel modelo = new DefaultTableModel();
        JTable carros2 = new JTable(modelo);

        Object [][] table = TabelaVeiculo2();
        carros2.setModel(new DefaultTableModel(table,new String[]{"Placa","Categoria"
                ,"Passageiros","Tam. bagageiro","Tipo de câmbio","Possui ar cond.",
                "Consumo(km/l)","Acessórios","Custo por dia"}));
        JScrollPane barraRolagem3 = new JScrollPane(carros2);
        barraRolagem3.setBounds(30, 240, 925, 250);
        barraRolagem3.setFont(new Font("Dialog",Font.PLAIN,10));
        this.frame.add(barraRolagem3);
    }
    public Object [][] TabelaVeiculo3() throws SQLException, ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) carros.getModel();

        CarroDAO carro = new CarroDAO();
        //ClienteDAO cliente = new ClienteDAO();
        Object[][] dados = new Object[carro.numLinhaTabela3()][9];
        int i =0;
        for(Carro car : carro.tabelaCarros3()) {
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

    public void attabela3() throws SQLException, ClassNotFoundException {

        DefaultTableModel modelo = new DefaultTableModel();
        JTable carros2 = new JTable(modelo);

        Object [][] table = TabelaVeiculo3();
        carros2.setModel(new DefaultTableModel(table,new String[]{"Placa","Categoria"
                ,"Passageiros","Tam. bagageiro","Tipo de câmbio","Possui ar cond.",
                "Consumo(km/l)","Acessórios","Custo por dia"}));
        JScrollPane barraRolagem3 = new JScrollPane(carros2);
        barraRolagem3.setBounds(30, 240, 925, 250);
        barraRolagem3.setFont(new Font("Dialog",Font.PLAIN,10));
        this.frame.add(barraRolagem3);
    }


    /*public static void main(String args[]) throws SQLException, ClassNotFoundException {
        removerVeiculo remv = new removerVeiculo();
        remv.frame.setVisible(true);
    }*/

}
