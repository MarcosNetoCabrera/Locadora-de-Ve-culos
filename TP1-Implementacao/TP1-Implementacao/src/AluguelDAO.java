import java.sql.*;
import java.util.LinkedList;

public class AluguelDAO extends BancoDeDados {

    public boolean adicionarCliente(Aluguel c) {
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO tbl_aluguel VALUES ('"+c.getPlaca_Carro_Alugado()+"','"
                    +c.getCPF_cadastrado()+"','"
                    +c.getNome_completo()+"',"
                    +c.getIdade()+",'"
                    +c.getLocal_de_retirada()+"','"
                    +c.getData_de_retirada()+"','"
                    +c.getLocal_de_devolucao()+"','"
                    +c.getData_de_devolucao()+"','"
                    +c.getOpcionais()+"',"
                    +c.getValorPago()+")");
            return true;
        } catch (SQLException e) { return false; }
    }
    public boolean removeAluguel(String CPF){
        try {
            Statement st = conexao.createStatement();
            st.execute("set SQL_SAFE_UPDATES = 0;");
            st.executeUpdate("DELETE FROM tbl_aluguel WHERE CPF_cadastrado = '"+CPF+"'");
            return true;
        }
        catch(SQLException e) { return false; }
    }
    public Aluguel buscaCliente(String placa) {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_aluguel WHERE " +
                    "Placa_Carro_Alugado='" + placa + "'");
            if (rs.next()) {
                return new Aluguel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4), rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
            }
            else return null;
        }
        catch (SQLException e) { return null; }
    }
    public Aluguel buscaAlugado(String Cpf) {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_aluguel WHERE " +
                    "CPF_cadastrado='" + Cpf + "'");
            if (rs.next()) {
                return new Aluguel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4), rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
            }
            else return null;
        }
        catch (SQLException e) { return null; }
    }

    public LinkedList<Aluguel> tabelaAluguel(){
        try {
            Statement st = conexao.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_aluguel");

            LinkedList<Aluguel> listar = new LinkedList<>();
            while(rs.next()){
                Aluguel cli = new Aluguel(rs.getString(1),rs.getString(2),rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
                listar.add(cli);
            }
            return listar;
        }catch(SQLException e) { return null; }
    }
    public int numLinhaTabelaAluguel(){
        try{
            int numLinhas = 0;
            Statement st = conexao.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_aluguel");

            while(rs.next()){
                numLinhas++;
            }
            return numLinhas;
        }catch (SQLException e) { return 0; }
    }
    public void alteraColuna(String CPF,String coluna,String novoValor){
        try{
            int nv = 0;
            if(coluna == "Placa do carro alugado"){
                coluna = "Placa_Carro_Alugado";
            }if(coluna == "CPF do Cliente"){
                coluna = "CPF_cadastrado";
            }if(coluna == "Nome completo"){
                coluna = "Nome_Completo";
            }if(coluna == "Idade"){
                coluna = "idade";
                nv = Integer.parseInt(novoValor);
            }if(coluna == "Local de retirada"){
                coluna = "Local_de_Retirada";
            }if(coluna == "Data de retirada"){
                coluna = "Data_de_Retirada";
            }if(coluna == "Local de devolução"){
                coluna = "Local_de_Devolução";
            }if(coluna == "Data de devolução"){
                coluna = "Data_de_Devolução";
            }if(coluna == "Valor total pago"){
                nv = Integer.parseInt(novoValor);
                coluna = "valor_total_pago";
            }

            Statement st = conexao.createStatement();
            if(coluna == "Idade" || coluna == "Valor total pago"){
                st.executeUpdate("UPDATE tbl_aluguel SET "+coluna+" = "+nv+" WHERE CPF_cadastrado = '"+CPF+"'");
            }else{
                st.executeUpdate("UPDATE tbl_aluguel SET "+coluna+" = '"+novoValor+"' WHERE CPF_cadastrado = '"+CPF+"'");
            }
        }catch(SQLException e) {
            System.out.print(e);
        }

    }
    /*public static void main(String args[]) {

        AluguelDAO clienteDAO = new AluguelDAO();

        Aluguel a = new Aluguel("LUL-3124","01640360247","José marcos cabrera neto",20
                ,"Agencia cidade nova","22/05/2001","Agencia cidade nova","25/05/2001"
                , "GPS",2000);
        //clienteDAO.removeCliente("JTO-1458");
        clienteDAO.adicionarCliente(a);
        //Cliente c2 = clienteDAO.buscaCliente("JTO-1458");
        //System.out.println(c2.getNome_completo());

    }*/
}
