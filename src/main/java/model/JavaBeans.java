package model;

public class JavaBeans {
	private String idProduto;
	private String descProduto;
	private String dataValidade;
	private String dataCadastro;
	private String preco;
	private String ativo;
	
	public JavaBeans() {
		super();		
	}

	public JavaBeans(String idProduto, String descProduto, String dataValidade, String dataCadastro, String preco,
			String ativo) {
		super();
		this.idProduto = idProduto;
		this.descProduto = descProduto;
		this.dataValidade = dataValidade;
		this.dataCadastro = dataCadastro;
		this.preco = preco;
		this.ativo = ativo;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}	
}
