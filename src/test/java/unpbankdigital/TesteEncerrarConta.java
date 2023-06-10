package unpbankdigital;

import br.com.unpbankdigital.domain.conta.ContaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class TesteEncerrarConta {

    @Test
    public void testEncerrarConta() {
        ContaService serviceMock = Mockito.mock(ContaService.class);
        Integer numeroDaConta = 1234;

        serviceMock.encerrar(numeroDaConta);

        Mockito.verify(serviceMock).encerrar(numeroDaConta);

        if (numeroDaConta > 0) {
            System.out.println("Número inválido para encerramento!");
        } else
            System.out.println("Conta encerrada com sucesso!");

    }
    @Test
    public void testEncerrarContaInvalido() {
        ContaService serviceMock = Mockito.mock(ContaService.class);
        Integer numeroDaConta = -1234;

        serviceMock.encerrar(numeroDaConta);

        Mockito.verify(serviceMock).encerrar(numeroDaConta);

        if (numeroDaConta > 0) {
            System.out.println("Número inválido para encerramento!");
        } else
            System.out.println("Conta encerrada com sucesso!");
    }
}




