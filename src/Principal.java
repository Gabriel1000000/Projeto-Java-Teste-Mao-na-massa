import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 - Inserir todos os funcionários
        funcionarios.add(new Funcionario("Maria", "18/10/2000", "2009.44", "Operador"));
        funcionarios.add(new Funcionario("João", "12/05/1990", "2284.38", "Operador"));
        funcionarios.add(new Funcionario("Caio", "02/05/1961", "9836.14", "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", "14/10/1988", "19119.88", "Diretor"));
        funcionarios.add(new Funcionario("Alice", "05/01/1995", "2234.68", "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", "19/11/1999", "1582.72", "Operador"));
        funcionarios.add(new Funcionario("Arthur", "31/03/1993", "407.84", "Contador"));
        funcionarios.add(new Funcionario("Laura", "08/07/1994", "3017.45", "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", "24/05/2003", "1606.85", "Eletricista"));
        funcionarios.add(new Funcionario("Helena", "02/09/1996", "2799.93", "Gerente"));

        // 3.2 - Remover o funcionário “João”
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 - Imprimir todos os funcionários
        System.out.println("Lista de Funcionários:");
        funcionarios.forEach(Principal::imprimirFuncionario);

        // 3.4 - Aplicar 10% de aumento no salário
        funcionarios.forEach(f -> f.aumentarSalario(new BigDecimal("10")));

        System.out.println("\nLista após aumento de 10%:");
        funcionarios.forEach(Principal::imprimirFuncionario);

        // 3.5 - Agrupar os funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 - Imprimir os funcionários agrupados por função
        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\n" + funcao + ":");
            lista.forEach(Principal::imprimirFuncionario);
        });

        // 3.8 - Funcionários que fazem aniversário nos meses 10 e 12
        System.out.println("\nFuncionários que fazem aniversário em Outubro e Dezembro:");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonth() == Month.OCTOBER ||
                             f.getDataNascimento().getMonth() == Month.DECEMBER)
                .forEach(Principal::imprimirFuncionario);

        // 3.9 - Funcionário com maior idade
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(f -> f.getDataNascimento()));
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("\nFuncionário mais velho: " + maisVelho.getNome() + " - " + idade + " anos");

        // 3.10 - Lista de funcionários em ordem alfabética
        System.out.println("\nFuncionários em ordem alfabética:");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(Principal::imprimirFuncionario);

        // 3.11 - Soma total dos salários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários: " + formatarMoeda(totalSalarios));

        // 3.12 - Salários mínimos de cada funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nSalário mínimo de cada funcionário:");
        funcionarios.forEach(f -> {
            BigDecimal qtdSalariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.DOWN);
            System.out.println(f.getNome() + " - " + qtdSalariosMinimos + " salários mínimos");
        });
    }

    // Método para formatar e imprimir funcionário
    private static void imprimirFuncionario(Funcionario f) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(f.getNome() + " | " + f.getDataNascimento().format(formatter) +
                " | " + formatarMoeda(f.getSalario()) + " | " + f.getFuncao());
    }

    // Método para formatar valores monetários
    private static String formatarMoeda(BigDecimal valor) {
        NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
        nf.setMinimumFractionDigits(2);
        return nf.format(valor);
    }
}
