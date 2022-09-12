import java.util.ArrayList;

public class Carro {
    private String Placa;
    private String Categoria;
    private int Numero_maximo_de_passageiros;
    private String Tamanho_do_bagageiro;
    private String Tipo_de_cambio;
    private String Possui_ar_condicionado;
    private int Media_de_consumo;
    private String Acessorios;
    private int Custo_por_dia;

    ArrayList<Carro> carros = new ArrayList<Carro>();


    public void addLista(Carro c) {
        this.carros.add(c);
    }

    public Carro(String placa, String categoria, int numero_maximo_de_passageiros, String tamanho_do_bagageiro, String tipo_de_cambio, String possui_ar_condicionado, int media_de_consumo, String acessorios, int custo_por_dia) {
        this.Placa = placa;
        this.Categoria = categoria;
        this.Numero_maximo_de_passageiros = numero_maximo_de_passageiros;
        this.Tamanho_do_bagageiro = tamanho_do_bagageiro;
        this.Tipo_de_cambio = tipo_de_cambio;
        this.Possui_ar_condicionado = possui_ar_condicionado;
        this.Media_de_consumo = media_de_consumo;
        this.Acessorios = acessorios;
        this.Custo_por_dia = custo_por_dia;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getNumero_maximo_de_passageiros() {
        return Numero_maximo_de_passageiros;
    }

    public void setNumero_maximo_de_passageiros(int numero_maximo_de_passageiros) {
        Numero_maximo_de_passageiros = numero_maximo_de_passageiros;
    }

    public String getTamanho_do_bagageiro() {
        return Tamanho_do_bagageiro;
    }

    public void setTamanho_do_bagageiro(String tamanho_do_bagageiro) {
        Tamanho_do_bagageiro = tamanho_do_bagageiro;
    }

    public String getTipo_de_cambio() {
        return Tipo_de_cambio;
    }

    public void setTipo_de_cambio(String tipo_de_cambio) {
        Tipo_de_cambio = tipo_de_cambio;
    }

    public String getPossui_ar_condicionado() {
        return Possui_ar_condicionado;
    }

    public void setPossui_ar_condicionado(String possui_ar_condicionado) {
        Possui_ar_condicionado = possui_ar_condicionado;
    }

    public int getMedia_de_consumo() {
        return Media_de_consumo;
    }

    public void setMedia_de_consumo(int media_de_consumo) {
        Media_de_consumo = media_de_consumo;
    }

    public String getAcessorios() {
        return Acessorios;
    }

    public void setAcessorios(String acessorios) {
        Acessorios = acessorios;
    }

    public int getCusto_por_dia() {
        return Custo_por_dia;
    }

    public void setCusto_por_dia(int custo_por_dia) {
        Custo_por_dia = custo_por_dia;
    }
}