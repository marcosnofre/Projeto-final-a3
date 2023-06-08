package unpbankdigital;

import br.com.unpbankdigital.domain.cliente.DadosCadastroCliente;
import br.com.unpbankdigital.domain.conta.ContaService;
import br.com.unpbankdigital.domain.conta.DadosAberturaConta;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;

public class TesteAbrirConta {
    @Test
    public void testAbrirContaComSucesso() {

        ContaService serviceMock = Mockito.mock(ContaService.class);

        // Simulação da entrada de dados
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
        int numeroDaConta = -1;
        String nome = "Maria";
        String cpf = "98765432100";
        String email = "maria@example.com";

        abrirConta(serviceMock, numeroDaConta, nome, cpf, email);

        Scanner teclado = new Scanner(System.in);
        teclado.next();

        Mockito.verify(serviceMock, never()).abrir(any());
    }

    private void abrirConta(ContaService service, int numeroDaConta, String nome, String cpf, String email) {

        service.abrir(new DadosAberturaConta(numeroDaConta, new DadosCadastroCliente(nome, cpf, email)));
        if (numeroDaConta <= 0) {
            System.out.println("Número da conta inválido");
        }else {
            System.out.println("Conta aberta com sucesso!");
        }

    }

}
