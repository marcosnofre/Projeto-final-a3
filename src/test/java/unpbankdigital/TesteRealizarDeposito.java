package unpbankdigital;

import br.com.unpbankdigital.domain.conta.ContaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;


public class TesteRealizarDeposito {

    @Test
    public void testRealizarDepositoComSucesso() {
        ContaService serviceMock = Mockito.mock(ContaService.class);
        // Deposito realizado COM sucesso!
        Integer numeroDaConta = 2;
        BigDecimal valor = BigDecimal.valueOf(2.00);

        serviceMock.realizarDeposito(numeroDaConta, valor);

        Mockito.verify(serviceMock).realizarDeposito(numeroDaConta, valor);

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Valor inválido para depósito!");
        } else
            System.out.println("Deposito realizado com sucesso!");
    }

    @Test
    public void testRealizarDepositoSemSucesso() {
        ContaService serviceMock = Mockito.mock(ContaService.class);
        // Deposito realizado SEM sucesso!
        Integer numeroDaConta = 22;
        BigDecimal valor = BigDecimal.valueOf(-2.00);

        serviceMock.realizarDeposito(numeroDaConta, valor);

        Mockito.verify(serviceMock).realizarDeposito(numeroDaConta, valor);
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Valor inválido para depósito!");
        } else
        System.out.println("Deposito realizado com sucesso!");

    }
}