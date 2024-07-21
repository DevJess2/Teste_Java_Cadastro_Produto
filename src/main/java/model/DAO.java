package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "org.sqlite.JDBC";
	private String url = 
				"jdbc:sqlite:C:\\Users\\Jéssica\\Documents"
				+ "\\Jéssica\\Teste Java"
				+ "\\SQLite";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url);
			System.out.println("Connection to SQLite has been established.");
			return con;			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void inserirProduto(JavaBeans produto) {
		String create = "insert into cadastro_produto (Desc_Produto, Data_Validade, Data_Cadastro, Preco, Ativo) values (?, ?, ?, ?, ?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, produto.getDescProduto());
			pst.setString(2, produto.getDataValidade());
			pst.setString(3, produto.getDataCadastro());
			pst.setString(4, produto.getPreco());
			pst.setString(5, produto.getAtivo());

			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<JavaBeans> listarProdutos() {
		ArrayList<JavaBeans> produtos = new ArrayList<>();

		String read = "select * from CADASTRO_PRODUTO order by DESC_PRODUTO";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String descProduto = rs.getString(2);
				String dataValidade = rs.getString(3);
				String dataCadastro = rs.getString(4);
				String preco = rs.getString(5);
				String ativo = rs.getString(6);

				produtos.add(new JavaBeans(id, descProduto, dataValidade, dataCadastro, preco, ativo));
			}

			con.close();

			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}