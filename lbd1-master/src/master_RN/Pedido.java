package master_RN;

public class Pedido {

	private String data;
	private int codProduto;
	private int quantidade;
	private int valorTotal;
	private int codCliente;
	private int codPedido;
	
	
	public int getCodPedido() {
		return codPedido;
	}
	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

    public Pedido(int codProduto, int quantidade, int valorTotal, int codCliente, int codPedido) {
        this.codProduto = codProduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.codCliente = codCliente;
        this.codPedido = codPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "data=" + data + ", codProduto=" + codProduto + ", quantidade=" + quantidade + ", valorTotal=" + valorTotal + ", codCliente=" + codCliente + ", codPedido=" + codPedido + '}';
    }
	
	
	
}
