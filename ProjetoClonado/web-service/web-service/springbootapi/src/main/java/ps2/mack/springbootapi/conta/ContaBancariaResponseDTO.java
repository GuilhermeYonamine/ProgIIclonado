package ps2.mack.springbootapi.conta;

public record ContaBancariaResponseDTO(Long id, String nomeTitular, double saldo, String numAgencia) {
    public ContaBancariaResponseDTO(ContaBancaria conta) {
        this(conta.getId(), conta.getNomeTitular(), conta.getSaldo(), conta.getNumAgencia());
    }
}
