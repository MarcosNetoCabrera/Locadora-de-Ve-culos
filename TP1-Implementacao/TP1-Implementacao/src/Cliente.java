public class Cliente {
    private String CPF;
    private String NomeCompleto;
    private int idade;

    public Cliente(String CPF, String nomeCompleto, int idade) {
        this.CPF = CPF;
        this.NomeCompleto = nomeCompleto;
        this.idade = idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        NomeCompleto = nomeCompleto;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
