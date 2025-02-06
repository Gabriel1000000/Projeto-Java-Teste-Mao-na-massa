import java.math.BigDecimal;

class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, String dataNascimento, String salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = new BigDecimal(salario);
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void aumentarSalario(BigDecimal percentual) {
        BigDecimal aumento = salario.multiply(percentual).divide(new BigDecimal(100));
        this.salario = this.salario.add(aumento);
    }
}
