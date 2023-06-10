package unpbankdigital;

import br.com.unpbankdigital.domain.conta.ContaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TesteConsultarSaldo {

    @Test
    public void testConsultarSaldoSaldoNegativo() {
        ContaService serviceMock = Mockito.mock(ContaService.class);
        Integer numeroDaConta = 1234;
        Integer saldo = -10;

        Mockito.when(serviceMock.consultarSaldo(numeroDaConta)).thenReturn(BigDecimal.valueOf(saldo));
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String saldoFormatado = decimalFormat.format(saldo);
        if (numeroDaConta > 0) {
            System.out.println("Saldo da conta " + numeroDaConta + " é: R$ " + saldoFormatado);
            if (saldo <= 0) {
                System.out.println("Faça um deposito para normalizar sua conta!");
            }
        } else {
            System.out.println("Conta inválida!");
        }
    }

    @Test
    public void testConsultarSaldoContaInvalida() {
        ContaService serviceMock = Mockito.mock(ContaService.class);
        Integer numeroDaConta = -1234;
        Integer saldo = 10;

        Mockito.when(serviceMock.consultarSaldo(numeroDaConta)).thenReturn(BigDecimal.valueOf(saldo));
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String saldoFormatado = decimalFormat.format(saldo);
        if (numeroDaConta > 0) {
            System.out.println("Saldo da conta " + numeroDaConta + " é: R$ " + saldoFormatado);
            if (saldo <= 0) {
                System.out.println("Faça um deposito para normalizar sua conta!");
            }
        } else {
            System.out.println("Conta inválida!");
        }
    }

    @Test
    public void testConsultarSaldoContaValidaSaldoPositivo() {
        ContaService serviceMock = Mockito.mock(ContaService.class);
        Integer numeroDaConta = 1234;
        Integer saldo = 10;

        Mockito.when(serviceMock.consultarSaldo(numeroDaConta)).thenReturn(BigDecimal.valueOf(saldo));
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String saldoFormatado = decimalFormat.format(saldo);
        if (numeroDaConta > 0) {
            System.out.println("Saldo da conta " + numeroDaConta + " é: R$ " + saldoFormatado);
            if (saldo <= 0) {
                System.out.println("Faça um deposito para normalizar sua conta!");
            }
        } else {
            System.out.println("Conta inválida!");
        }
    }
}
