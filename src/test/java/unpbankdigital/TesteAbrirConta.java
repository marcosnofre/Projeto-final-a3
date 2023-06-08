package unpbankdigital;

import br.com.unpbankdigital.domain.cliente.DadosCadastroCliente;
import br.com.unpbankdigital.domain.conta.ContaService;
import br.com.unpbankdigital.domain.conta.DadosAberturaConta;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.validation.constraints.NotNull;

public class TesteAbrirConta {
    @Test
    public void testAbrirContaComSucesso() {

        ContaService serviceMock = Mockito.mock(ContaService.class);
        //todos os dados válidos
        int numeroDaConta = 1234;
        String nome = "João";
        String cpf = "12345678900";
        String email = "joao@example.com";

        abrirConta(serviceMock, numeroDaConta, nome, cpf, email);

        Mockito.verify(serviceMock).abrir(new DadosAberturaConta(numeroDaConta, new DadosCadastroCliente(nome, cpf, email)));

    }

    @Test
    public void testAbrirContaComNumeroInvalido() {
        ContaService serviceMock = Mockito.mock(ContaService.class);
        int numeroDaConta = -1; // número inválido
        String nome = "Maria";
        String cpf = "98765432100";
        String email = "maria@example.com";

        abrirConta(serviceMock, numeroDaConta, nome, cpf, email);

        Mockito.verify(serviceMock).abrir(new DadosAberturaConta(numeroDaConta, new DadosCadastroCliente(nome, cpf, email)));

    }

    @Test
    public void testAbrirContaComCpfInvalido() {
        ContaService serviceMock = Mockito.mock(ContaService.class);
        int numeroDaConta = 1234;
        String nome = "Maria";
        String cpf = "965874321"; // cpf com 9 dígitos
        String email = "joao@hotmail.com";

        abrirConta(serviceMock, numeroDaConta, nome, cpf, email);
    }

    @Test
    public void testAbrirContaComEmailInvalido() {
        ContaService serviceMock = Mockito.mock(ContaService.class);
        int numeroDaConta = 1234;
        String nome = "Maria";
        String cpf = "96587432100";
        String email = "joaogmail.com"; // sem @

        abrirConta(serviceMock, numeroDaConta, nome, cpf, email);
    }
    
    @NotNull
    private void abrirConta(ContaService service, int numeroDaConta, String nome, String cpf, String email) {

        service.abrir(new DadosAberturaConta(numeroDaConta, new DadosCadastroCliente(nome, cpf, email)));
        if (numeroDaConta <= 0) {
            System.out.println("Numero da conta inválido");
        }if (cpf.length() != 11) {
            System.out.println("CPF inválido");
        }if (!email.contains("@")) {
            System.out.println("Email inválido");
        }if (numeroDaConta > 0 && cpf.length() == 11 && email.contains("@")) {
            System.out.println("Conta aberta com sucesso!");
        }else {
            System.out.println("Conta não aberta");
        }
    }
}
