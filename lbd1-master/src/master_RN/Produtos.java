package master_RN;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import master_DB.conexao_DB;

public class Produtos {


	private int _totalProdutos;


	public int get_totalProdutos() {
		return _totalProdutos;
	}

	public void set_totalProdutos(int _totalProdutos) {
		this._totalProdutos = _totalProdutos;
	}

	
	public Produto RetornaProduto(int codProduto){

		//chama model e retorna produto

		return null;

	}

	public void Cadastrar(Produto produto){

	}

	public void Editar(Produto produto){

	}

	public void Excluir(int codProduto){

	}



}
