import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ControleClientes extends JFrame {
    DefaultTableModel modelo2 = new DefaultTableModel();
    JTable clientes = new JTable(modelo2);
    JScrollPane barraRolagem3 = new JScrollPane(clientes);
    public ControleClientes() throws SQLException, ClassNotFoundException {
        super("Locadora de Veículos v1.0");
        this.setLayout(null);
        this.setSize(1000, 650);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lTitulo = new JLabel("Controle de clientes");
        lTitulo.setBounds(200, 10, 600, 35);
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Dialog",Font.PLAIN,30));
        this.add(lTitulo);

        JLabel lDesc = new JLabel("Clientes disponíveis:");
        lDesc.setBounds(200, 40, 600, 22);
        lDesc.setHorizontalAlignment(SwingConstants.CENTER);
        lDesc.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(lDesc);

        JLabel opc = new JLabel("Relatório");
        opc.setBounds(29, 210, 600, 30);
        opc.setHorizontalAlignment(SwingConstants.LEFT);
        opc.setFont(new Font("Dialog", Font.PLAIN, 20));
        this.add(opc);

        attabela();

        JButton btCadastro = new JButton("Cadastrar Cliente");
        btCadastro.setBounds(35, 80, 300, 50);
        btCadastro.setHorizontalAlignment(SwingConstants.CENTER);
        btCadastro.setBackground(Color.lightGray);
        this.add(btCadastro);
        btCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    CadastroCliente2 cad = new CadastroCliente2();
                    cad.setVisible(true);
                    attabela();
                }catch (Exception e4){}

            }
        });

        JButton btremov= new JButton("Remover Cliente");
        btremov.setBounds(342, 80, 300, 50);
        btremov.setHorizontalAlignment(SwingConstants.CENTER);
        btremov.setBackground(Color.lightGray);
        this.add(btremov);
        btremov.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ClienteDAO cli = new ClienteDAO();
                    AluguelDAO alu = new AluguelDAO();
                    String CPF = JOptionPane.showInputDialog(null,"Digite o CPF do cliente que você deseja remover:","Aviso",JOptionPane.INFORMATION_MESSAGE);
                    if(cli.buscaCliente(CPF)==null){
                        JOptionPane.showMessageDialog(null,"CPF não encontrado","Erro",JOptionPane.ERROR_MESSAGE);
                    }else{
                        //int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza ?","Confirmação",JOptionPane.YES_NO_CANCEL_OPTION);
                        if(alu.buscaAlugado(CPF) == null){
                            cli.rmvCliente(CPF);
                            attabela();
                            JOptionPane.showMessageDialog(null,"O cliente foi removido com sucesso","Aviso",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            int confirm = JOptionPane.showConfirmDialog(null, "Este cliente possui um carro alugado, deseja remove-lo mesmo assim ?","Confirmação",JOptionPane.YES_NO_CANCEL_OPTION);
                            if(confirm==0){
                                alu.removeAluguel(CPF);
                                cli.rmvCliente(CPF);
                                JOptionPane.showMessageDialog(null,"O cliente foi removido com sucesso","Aviso",JOptionPane.INFORMATION_MESSAGE);
                                attabela();
                            }
                        }
                    }
                }catch (Exception e3){ }
            }
        });
        String[] cat = {"Selecione uma opção para alterar","Placa do carro alugado","CPF do Cliente","Nome completo","Idade",
                "Local de retirada", "Data de retirada","Local de devolução","Data de devolução","Opcionais","Valor total pago"};
        JComboBox getaltera = new JComboBox(cat);
        getaltera.setBackground(Color.white);
        getaltera.setBounds(650, 80, 300, 50);
        getaltera.setFont(new Font("Dialog", Font.PLAIN, 15));
        this.add(getaltera);

        JButton btAltera = new JButton("Alterar dados do cliente");
        btAltera.setBounds(650, 130, 300, 50);
        btAltera.setHorizontalAlignment(SwingConstants.CENTER);
        btAltera.setBackground(Color.lightGray);
        this.add(btAltera);
        btAltera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AluguelDAO alug= new AluguelDAO();
                    ClienteDAO cli  = new ClienteDAO();
                    String coluna = (String) getaltera.getSelectedItem();
                    if(coluna == "Selecione uma opção para alterar"){
                        JOptionPane.showMessageDialog(null,"Opção inválida, por favor tente novamente","Erro",JOptionPane.ERROR_MESSAGE);
                    }else{
                        String CPF = JOptionPane.showInputDialog(null,"Digite O CPF do cliente que deseja alterar as informações:",
                                "Aviso",JOptionPane.PLAIN_MESSAGE);
                        if(alug.buscaAlugado(CPF)==null){
                            JOptionPane.showMessageDialog(null,"CPF não encontrado","Erro",JOptionPane.ERROR_MESSAGE);
                        }else {
                            String novoValor = JOptionPane.showInputDialog("Digite o novo valor para " + getaltera.getSelectedItem() + ":");
                            if(coluna=="CPF do Cliente"|| coluna=="Nome completo" || coluna=="Idade"){cli.alteraColuna(CPF,coluna,novoValor);}
                            if(coluna=="CPF do Cliente"|| coluna=="Placa do carro alugado"){
                                JOptionPane.showMessageDialog(null,"Não é possível alterar essas informações pois o cliente tem um carro alugado","Erro",JOptionPane.ERROR_MESSAGE);
                            }else{
                                alug.alteraColuna(CPF,coluna,novoValor);
                                attabela();
                            }
                        }

                    }
                }catch (Exception e3) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar Alterar o valor da coluna, tente novamente","Aviso",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton bDisponiveis = new JButton("Clientes com veiculos alugado");
        bDisponiveis.setBounds(29, 500, 300, 50);
        bDisponiveis.setHorizontalAlignment(SwingConstants.CENTER);
        bDisponiveis.setBackground(Color.lightGray);
        this.add(bDisponiveis);
        bDisponiveis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    attabela();
                }catch (Exception e1){

                }
            }
        });

        JButton bAlugados = new JButton("Todos os clientes cadastrados");
        bAlugados.setBounds(337, 500, 300, 50);
        bAlugados.setHorizontalAlignment(SwingConstants.CENTER);
        bAlugados.setBackground(Color.lightGray);
        this.add(bAlugados);
        bAlugados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    attabela2();
                }catch (Exception e1){ }
            }
        });

        JButton bTodos = new JButton("Clientes cadastrados sem veículo alugado");
        bTodos.setBounds(646, 500, 300, 50);
        bTodos.setHorizontalAlignment(SwingConstants.CENTER);
        bTodos.setBackground(Color.lightGray);
        this.add(bTodos);
        bTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    attabela3();
                }catch (Exception e1){ }

            }
        });
    }
    public void attabela() throws SQLException, ClassNotFoundException {
        DefaultTableModel modelo = new DefaultTableModel();
        JTable clientes = new JTable(modelo);
        AluguelDAO clienteDAO = new AluguelDAO();

        Object [][] table = tabelaClientes();
        clientes.setModel(new DefaultTableModel(table,new String[]{"Placa carro alugado","CPF cadastrado","Nome completo"
                ,"Idade","Local de retirada","Data de retirada","Local de devolução",
                "Data de devolução","Opcionais","Valor total pago"}));
        JScrollPane barraRolagem3 = new JScrollPane(clientes);
        barraRolagem3.setBounds(30, 240, 925, 250);
        barraRolagem3.setFont(new Font("Dialog",Font.PLAIN,10));
        this.add(barraRolagem3);
    }
    public Object [][] tabelaClientes() throws SQLException, ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) clientes.getModel();

        //CarroDAO carro = new CarroDAO();
        AluguelDAO cliente = new AluguelDAO();
        Object[][] dados = new Object[cliente.numLinhaTabelaAluguel()][10];
        int i =0;
        for(Aluguel cli : cliente.tabelaAluguel()) {
            dados[i][0] = cli.getPlaca_Carro_Alugado();
            dados[i][1] = cli.getCPF_cadastrado();
            dados[i][2] = cli.getNome_completo();
            dados[i][3] = Integer.toString(cli.getIdade());
            dados[i][4] = cli.getLocal_de_retirada();
            dados[i][5] = cli.getData_de_retirada();
            dados[i][6] = cli.getLocal_de_devolucao();
            dados[i][7] = cli.getData_de_devolucao();
            dados[i][8] = cli.getOpcionais();
            dados[i][9] = cli.getValorPago();
            i++;
        }
        return dados;
    }
    public void attabela2() throws SQLException, ClassNotFoundException {
        DefaultTableModel modelo = new DefaultTableModel();
        JTable clientes = new JTable(modelo);

        Object [][] table = tabelaClientes2();
        clientes.setModel(new DefaultTableModel(table,new String[]{"CPF","Nome completo","Idade"}));
        JScrollPane barraRolagem3 = new JScrollPane(clientes);
        barraRolagem3.setBounds(30, 240, 925, 250);
        barraRolagem3.setFont(new Font("Dialog",Font.PLAIN,10));
        this.add(barraRolagem3);
    }
    public Object [][] tabelaClientes2() throws SQLException, ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) clientes.getModel();


        ClienteDAO cliente = new ClienteDAO();
        Object[][] dados = new Object[cliente.numLinhaTabela1()][3];
        int i =0;
        for(Cliente cli : cliente.tabelaCliente1()) {
            dados[i][0] = cli.getCPF();
            dados[i][1] = cli.getNomeCompleto();
            dados[i][2] = cli.getIdade();
            i++;
        }
        return dados;
    }
    public void attabela3() throws SQLException, ClassNotFoundException {
        DefaultTableModel modelo = new DefaultTableModel();
        JTable clientes = new JTable(modelo);

        Object [][] table = tabelaClientes3();
        clientes.setModel(new DefaultTableModel(table,new String[]{"CPF","Nome completo","Idade"}));
        JScrollPane barraRolagem3 = new JScrollPane(clientes);
        barraRolagem3.setBounds(30, 240, 925, 250);
        barraRolagem3.setFont(new Font("Dialog",Font.PLAIN,10));
        this.add(barraRolagem3);
    }
    public Object [][] tabelaClientes3() throws SQLException, ClassNotFoundException {
        DefaultTableModel model = (DefaultTableModel) clientes.getModel();

        ClienteDAO cliente = new ClienteDAO();
        Object[][] dados = new Object[cliente.numLinhaTabela2()][3];
        int i =0;
        for(Cliente cli : cliente.tabelaCliente2()) {
            dados[i][0] = cli.getCPF();
            dados[i][1] = cli.getNomeCompleto();
            dados[i][2] = cli.getIdade();
            i++;
        }
        return dados;
    }
   /* public static void main(String args[]) throws SQLException, ClassNotFoundException {
        ControleClientes ctr = new ControleClientes();
        ctr.setVisible(true);
    }*/
}
