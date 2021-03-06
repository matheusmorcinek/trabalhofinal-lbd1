package master_RN;

public class Cliente {

	private int codCliente;
	private String nome;
	private int telefone;
	private String endereco;
	private double limiteConta;
	private String status;
        
        public Cliente(int codigo,
                       String nome,
                       String status,
                       int telefone,
                       String endereco,
                       Double limite){
            this.codCliente = codigo;
            this.nome = nome;
            this.status = status;
            this.telefone = telefone;
            this.endereco = endereco;
            this.limiteConta = limite;            
        }
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getLimiteConta() {
		return limiteConta;
	}
	public void setLimiteConta(double limiteConta) {
		this.limiteConta = limiteConta;
	}

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", limiteConta=" + limiteConta + ", status=" + status + '}';
    }
	
	
}
