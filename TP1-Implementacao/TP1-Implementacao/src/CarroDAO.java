import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CarroDAO extends BancoDeDados {
    private JFrame frame;
//imprimi os carros
    public void listarCarros() {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_carro");
            while (rs.next()) {
                System.out.println("Placa: " + rs.getString(1)
                        + ", Categoria: " + rs.getString(2)
                        + ", Número_máximo_de_passageiros: " + rs.getString(3)
                        + ", Tamanho_do_bagageiro: " +rs.getString(4)
                        + ", Tipo_de_câmbio: "+rs.getString(5)
                        + ", Possui_ar_condicionado: "+rs.getString(6)
                        + ", Média_de_consumo(km/l): "+rs.getString(7)
                        + ", Acessorios: "+rs.getString(8)
                        + ", Custo_por_dia: "+rs.getString(9));
            }
        }
        catch (SQLException e) { }
    }
    //adiciona um carro
    public boolean adicionarCarro(Carro c) {
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO tbl_carro VALUES ('"+c.getPlaca()+"','"
                    +c.getCategoria()+"',"
                    +c.getNumero_maximo_de_passageiros()+",'"
                    +c.getTamanho_do_bagageiro()+"','"
                    +c.getTipo_de_cambio()+"','"
                    +c.getPossui_ar_condicionado()+"',"
                    +c.getMedia_de_consumo()+",'"
                    +c.getAcessorios()+"',"
                    +c.getCusto_por_dia()+")");
            return true;

        } catch (SQLException e) {return false;}
    }
    //buscar
    public Carro buscaCarro(String placa) {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tbl_carro WHERE " +
                    "Placa='" + placa + "'");
            if (rs.next()) {
                return new Carro(rs.getString(1),rs.getString(2), rs.getInt(3), rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
            }
            else return null;
        }
        catch (SQLException e) { return null; }
    }
    //remover carro
    public void removeCarro(String placa){
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate("DELETE FROM tbl_carro WHERE Placa = '"+placa+"'");
        }
        catch(SQLException e) { }
    }

    public LinkedList<Carro> tabelaCarros(){
        try {
            Statement st = conexao.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_carro");

            LinkedList<Carro> listar = new LinkedList<>();
            while(rs.next()){
                Carro car = new Carro(rs.getString(1),rs.getString(2), rs.getInt(3), rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
                listar.add(car);
            }
            return listar;
        }catch(SQLException e) { return null; }
    }

    public LinkedList<Carro> tabelaCarros2(){
        try {
            Statement st = conexao.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_carro");
            AluguelDAO clienteDAO = new AluguelDAO();

            LinkedList<Carro> listar = new LinkedList<>();
            while(rs.next()){
                Carro car = new Carro(rs.getString(1),rs.getString(2), rs.getInt(3), rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
                Aluguel cli = clienteDAO.buscaCliente(car.getPlaca());
                if(cli == null){
                    listar.add(car);
                }
            }
            return listar;
        }catch(SQLException e) { return null; }
    }
    public LinkedList<Carro> tabelaCarros3(){
        try {
            Statement st = conexao.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_carro");
            AluguelDAO clienteDAO = new AluguelDAO();

            LinkedList<Carro> listar = new LinkedList<>();
            while(rs.next()){
                Carro car = new Carro(rs.getString(1),rs.getString(2), rs.getInt(3), rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
                Aluguel cli = clienteDAO.buscaCliente(car.getPlaca());
                if(cli != null){
                    listar.add(car);
                }
            }
            return listar;
        }catch(SQLException e) { return null; }
    }

    public int numLinhaTabela(){
        try{
            int numLinhas = 0;
            Statement st = conexao.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_carro");

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
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_carro");
            AluguelDAO clienteDAO = new AluguelDAO();
            while(rs.next()){
                String placa = rs.getString(1);
                if(clienteDAO.buscaCliente(placa) == null){
                    numLinhas++;
                }
            }
            return numLinhas;
        }catch (SQLException e) { return 0; }
    }
    public int numLinhaTabela3(){
        try{
            int numLinhas = 0;
            Statement st = conexao.createStatement();
            ResultSet rs =  st.executeQuery("SELECT * FROM tbl_carro");
            AluguelDAO clienteDAO = new AluguelDAO();
            while(rs.next()){
                String placa = rs.getString(1);
                if(clienteDAO.buscaCliente(placa) != null){
                    numLinhas++;
                }
            }
            return numLinhas;
        }catch (SQLException e) { return 0; }
    }

    public boolean alteraColuna(String placa,String coluna,String novoValor){
        try{
            int nv = 0;
            //CarroDAO card = new CarroDAO();
            // Carro ccar = card.buscaCarro(placa);
            if(coluna == "Passageiros"){
                coluna = "Número_máximo_de_passageiros";
                nv = Integer.parseInt(novoValor);
            }if(coluna == "Tam. bagageiro"){
                coluna = "Tamanho_do_bagageiro";
            }if(coluna == "Tipo de câmbio"){
                coluna = "Tipo_de_câmbio";
            }if(coluna == "Possui ar cond."){
                coluna = "Possui_ar_condicionado";
            }if(coluna == "Consumo(km/l)"){
                coluna = "Média_de_consumo";
                nv = Integer.parseInt(novoValor);
            }if(coluna == "Custo por dia"){
                coluna = "Custo_por_dia";
                nv = Integer.parseInt(novoValor);
            }
            //System.out.println("UPDATE tbl_carro SET '"+coluna+"'= '"+novoValor+"' WHERE Placa = '"+placa+"'");
            Statement st = conexao.createStatement();
            if(coluna == "Número_máximo_de_passageiros" || coluna == "Média_de_consumo" || coluna == "Custo_por_dia"){
                st.executeUpdate("UPDATE tbl_carro SET "+coluna+" = "+nv+" WHERE Placa = '"+placa+"'");
                return true;
            }else{
                st.executeUpdate("UPDATE tbl_carro SET "+coluna+" = '"+novoValor+"' WHERE Placa = '"+placa+"'");
                return true;
            }
        }catch(SQLException e) {
            return false;
        }
    }

    public int TotalPagamento(String placa,String dataRet, String dataDev, int opc){
        int total = 0;

        CarroDAO carroDAO = new CarroDAO();
        Carro car = carroDAO.buscaCarro(placa);
        int dia = car.getCusto_por_dia();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date firstDate = null;
        try {
            firstDate = sdf.parse(dataRet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date secondDate = null;
        try {
            secondDate = sdf.parse(dataDev);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long diff = secondDate.getTime() - firstDate.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        if(diffrence < 0){
            return -1;
        }
        ///System.out.println("The difference in days is : "+diffrence);
        total = (int) (diffrence * dia) + opc;

        return total;
    }

   /* public static void main(String args[]) throws SQLException, ClassNotFoundException {

        CarroDAO carroD = new CarroDAO();

        Carro car = new Carro("JTO-1458","Compacto", 1, "Pequeno",
                "Manual","Não",5,"Airbag",100);
        //carroD.adicionarCarro(car);
        //carroD.removeCarro("JTO-1458");

        //carroD.alteraColuna("EOF-3132","Custo por dia","100");

        //int valor = carroD.TotalPagamento("JTO-1458","05/10/2021","10/10/2021",3000);
        //System.out.println(valor);
    }*/
}
