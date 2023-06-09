package unpbankdigital;

import br.com.unpbankdigital.domain.cliente.Cliente;
import br.com.unpbankdigital.domain.cliente.DadosCadastroCliente;
import br.com.unpbankdigital.domain.conta.Conta;
import br.com.unpbankdigital.domain.conta.ContaService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class TesteContasAbertas {
    @Test
    public void testeContasAbertasSemLetras(){

        ContaService serviceMock = Mockito.mock(ContaService.class);

        DadosCadastroCliente dadosCliente1 = new DadosCadastroCliente("Igor", "07456789000", "igor@gmail.com");
        DadosCadastroCliente dadosCliente2 = new DadosCadastroCliente("João", "88565435030", "joao@hotmail.com");
        Cliente cliente1 = new Cliente(dadosCliente1);
        Cliente cliente2 = new Cliente(dadosCliente2);
        Conta conta1 = new Conta(1, cliente1);
        Conta conta2 = new Conta(2, cliente2);

        Set<Conta> contas = new HashSet<>();
        contas.add(conta1);
        contas.add(conta2);
        Mockito.when(serviceMock.listarContasAbertas()).thenReturn(contas);

        Set<Conta> resultado = serviceMock.listarContasAbertas();

        Mockito.verify(serviceMock).listarContasAbertas();

        Assert.assertEquals(contas, resultado);

        if (contas.equals(resultado)) {
            System.out.println("A lista de contas foi exibida sem erros!");
        } else {
            System.out.println("A lista contém erros!");
        }

    }
}
