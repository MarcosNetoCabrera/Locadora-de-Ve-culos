import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ClienteDAO extends BancoDeDados{
    public void listarClientes() {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_cliente");
            while (rs.next()) {
                System.out.println("CPF: " + rs.getString(1)
                        + ", Nome Completo: " + rs.getString(2)
                        + ", idade: " + rs.getString(3));
            }
        }
        catch (SQLException e) { }
    }
    public boolean addCliente(Cliente c) {
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO tbl_cliente VALUES ('"+c.getCPF()+"','"
                    +c.getNomeCompleto()+"',"
                    +c.getIdade()+")");
            return true;
        } catch (SQLException e) { return false; }
    }
    public void rmvCliente(String cpf){
        try {
            Statement st = conexao.createStatement();
            st.execute("set SQL_SAFE_UPDATES = 0;");
            st.executeUpdate("DELETE FROM tbl_cliente WHERE CPF = '"+cpf+"'");
        }
        catch(SQLException e) { }
    }
    public Cliente buscaCliente(String cpf) {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_cliente WHERE " +
                    "CPF=" + cpf + "");
            if (rs.next()) {
                return new Cliente(rs.getString(1),rs.getString(2), rs.getInt(3));
            }
            else return null;
        }
        catch (SQLException e) { return null; }
    }

    public void alteraColuna(String CPF,String coluna,String novoValor) {
        try {
            int nv = 0;
            if (coluna == "CPF do Cliente") {
                coluna = "CPF";
            }
            if (coluna == "Nome completo") {
                coluna = "Nome_completo";
            }
            if (coluna == "Idade") {
                coluna = "idade";
                nv = Integer.parseInt(novoValor);
            }
            Statement st = conexao.createStatement();
            if (coluna == "Idade") {
                st.executeUpdate("UPDATE tbl_cliente SET " + coluna + " = " + nv + " WHERE CPF = '" + CPF + "'");
            } else {
                st.executeUpdate("UPDATE tbl_cliente SET " + coluna + " = '" + novoValor + "' WHERE CPF = '" + CPF + "'");
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
    public LinkedList<Cliente> tabelaCliente1(){
        try {
            Statement st = conexao.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_cliente");

            LinkedList<Cliente> listar = new LinkedList<>();
            while(rs.next()){
                Cliente car = new Cliente(rs.getString(1),rs.getString(2), rs.getInt(3));
                listar.add(car);
            }
            return listar;
        }catch(SQLException e) { return null; }
    }
    public int numLinhaTabela1(){
        try{
            int numLinhas = 0;
            Statement st = conexao.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_cliente");

            while(rs.next()){
                numLinhas++;
            }
            return numLinhas;
        }catch (SQLException e) { return 0; }
    }
    public int numLinhaTabela2(){
        try{
            int numLinhas = 0;
            Statement st = conexao.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_cliente");
            AluguelDAO clienteDAO = new AluguelDAO();
            while(rs.next()){
                String CPF = rs.getString(1);
                if(clienteDAO.buscaAlugado(CPF) == null){
                    numLinhas++;
                }
            }
            return numLinhas;
        }catch (SQLException e) { return 0; }
    }

    public LinkedList<Cliente> tabelaCliente2(){
        try {
            Statement st = conexao.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_cliente");
            AluguelDAO alug = new AluguelDAO();

            LinkedList<Cliente> listar = new LinkedList<>();
            while(rs.next()){
                Cliente cli = new Cliente(rs.getString(1),rs.getString(2), rs.getInt(3));
                Aluguel Al = alug.buscaAlugado(cli.getCPF());
                if(Al == null){
                    listar.add(cli);
                }
            }
            return listar;
        }catch(SQLException e) { return null; }
    }

    /*public static void main(String args[]) {
        //Cliente c = new Cliente("01640360245","adalberto das dores",55);
        ClienteDAO cli = new ClienteDAO();
        //cli.rmvCliente("Insira seu cpf");
        //cli.addCliente();
        //cli.alteraColuna("6541654561","Idade","20");
        cli.listarClientes();
    }*/
}
