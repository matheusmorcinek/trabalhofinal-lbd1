package master_RN;

public class Produto {
	
	private int codProduto;
	private double preco;
	private String nome;
	private int codCategoria;
	//private Categoria categoria;
	
	public Produto(int codigo,double preco, String nome, int codCategoria){
		this.codProduto = codigo;
                this.preco = preco;
		this.nome = nome;
		this.codCategoria = codCategoria;
	}
	
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	@Override
	public String toString(){
		return "Código do produto: "+codProduto+" - [ Nome: "+nome+" - Categoria: "+codCategoria+" -> Preço: "+preco+"]";
	}

	
}
