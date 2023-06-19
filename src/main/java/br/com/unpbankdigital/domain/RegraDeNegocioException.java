package br.com.unpbankdigital.domain;

public class RegraDeNegocioException extends RuntimeException {
    public RegraDeNegocioException(String mensagem) {
        super(mensagem);
    }
    public static class EmailInvalidoException extends RegraDeNegocioException {
        public EmailInvalidoException() {
            super("O email fornecido é inválido.");
        }
    }

    public static class CPFInvalidoException extends RegraDeNegocioException {
        public CPFInvalidoException() {
            super("O CPF fornecido é inválido.");
        }
    }

    public static class NumeroContaInvalidoException extends RegraDeNegocioException {
        public NumeroContaInvalidoException() {
            super("O número de conta fornecido é inválido.");
        }
    }
}
