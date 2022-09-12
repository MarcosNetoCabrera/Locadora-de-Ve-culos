public class Aluguel {

    private String Placa_Carro_Alugado;
    private String CPF_cadastrado;
    private String Nome_completo;
    private int idade;
    private String Local_de_retirada;
    private String Data_de_retirada;
    private String Local_de_devolucao;
    private String Data_de_devolucao;
    private String Opcionais;
    private int valorPago;


    public Aluguel(String placa_Carro_Alugado, String CPF_cadastrado, String nome_completo, int idade, String local_de_retirada, String data_de_retirada, String local_de_devolucao, String data_de_devolucao, String opcionais, int valorPago) {
        this.Placa_Carro_Alugado = placa_Carro_Alugado;
        this.CPF_cadastrado = CPF_cadastrado;
        this.Nome_completo = nome_completo;
        this.idade = idade;
        this.Local_de_retirada = local_de_retirada;
        this.Data_de_retirada = data_de_retirada;
        this.Local_de_devolucao = local_de_devolucao;
        this.Data_de_devolucao = data_de_devolucao;
        this.Opcionais = opcionais;
        this.valorPago = valorPago;
    }

    public String getPlaca_Carro_Alugado() {
        return Placa_Carro_Alugado;
    }

    public void setPlaca_Carro_Alugado(String placa_Carro_Alugado) {
        Placa_Carro_Alugado = placa_Carro_Alugado;
    }

    public String getCPF_cadastrado() {
        return CPF_cadastrado;
    }

    public void setCPF_cadastrado(String CPF_cadastrado) {
        this.CPF_cadastrado = CPF_cadastrado;
    }

    public String getNome_completo() {
        return Nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        Nome_completo = nome_completo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getLocal_de_retirada() {
        return Local_de_retirada;
    }

    public void setLocal_de_retirada(String local_de_retirada) {
        Local_de_retirada = local_de_retirada;
    }

    public String getData_de_retirada() {
        return Data_de_retirada;
    }

    public void setData_de_retirada(String data_de_retirada) {
        Data_de_retirada = data_de_retirada;
    }

    public String getLocal_de_devolucao() {
        return Local_de_devolucao;
    }

    public void setLocal_de_devolucao(String local_de_devolucao) {
        Local_de_devolucao = local_de_devolucao;
    }

    public String getData_de_devolucao() {
        return Data_de_devolucao;
    }

    public void setData_de_devolucao(String data_de_devolucao) {
        Data_de_devolucao = data_de_devolucao;
    }

    public String getOpcionais() {
        return Opcionais;
    }

    public void setOpcionais(String opcionais) {
        Opcionais = opcionais;
    }

    public int getValorPago() {
        return valorPago;
    }

    public void setValorPago(int valorPago) {
        this.valorPago = valorPago;
    }
}