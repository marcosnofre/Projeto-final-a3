package unpbankdigital;

import br.com.unpbankdigital.domain.conta.ContaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;


public class TesteRealizarDeposito {

    @Test
    public void testRealizarDepositoComSucesso() {
        ContaService serviceMock = Mockito.mock(ContaService.class);
        // Deposito realizado com sucesso!
        Integer numeroDaConta = 2;
        BigDecimal valor = BigDecimal.valueOf(2.00);

        serviceMock.realizarDeposito(numeroDaConta, valor);

        Mockito.verify(serviceMock).realizarDeposito(numeroDaConta, valor);
    }
}