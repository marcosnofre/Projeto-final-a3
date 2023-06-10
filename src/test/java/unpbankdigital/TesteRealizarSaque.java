package unpbankdigital;

import br.com.unpbankdigital.domain.conta.ContaService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

public class TesteRealizarSaque {
    @Test
    public void testeRealizarSaque() {
        ContaService serviceMock = Mockito.mock(ContaService.class);

        Integer numeroDaConta = 2;
        BigDecimal valor = BigDecimal.valueOf(2.00);

        serviceMock.realizarSaque(numeroDaConta, valor);

        Mockito.verify(serviceMock).realizarSaque(numeroDaConta, valor);

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Valor inválido para saque!");
        } else
            System.out.println("Saque realizado com sucesso!");
    }
    @Test
    public void testeRealizarSaqueSemSucesso(){
        ContaService serviceMock = Mockito.mock(ContaService.class);

        Integer numeroDaConta = 2;
        BigDecimal valor = BigDecimal.valueOf(-50);

        serviceMock.realizarSaque(numeroDaConta, valor);

        Mockito.verify(serviceMock).realizarSaque(numeroDaConta, valor);

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Valor inválido para saque!");
        } else
            System.out.println("Saque realizado com sucesso!");
    }
    @Test
    public void testeRealizarSaqueNumeroContaInvalido() {
        ContaService serviceMock = Mockito.mock(ContaService.class);

        Integer numeroDaConta = -1;
        BigDecimal valor = BigDecimal.valueOf(50);

        if (numeroDaConta <= 0) {
            System.out.println("Número de conta inválido!");
            return;
        }
        serviceMock.realizarSaque(numeroDaConta, valor);

        Mockito.verify(serviceMock).realizarSaque(numeroDaConta, valor);

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Valor inválido para saque!");
        } else {
            System.out.println("Saque realizado com sucesso!");
        }
    }
}