package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DAO dao = new DAO();
    JavaBeans produto = new JavaBeans();
    
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			produto(request, response);
		} else if (action.equals("/insert")) {
			novoProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void produto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("cadastro.jsp");
		ArrayList<JavaBeans> lista = dao.listarProdutos();
		
		for (int i = 0; i< lista.size(); i++) {
			System.out.println(lista.get(i).getIdProduto());
			System.out.println(lista.get(i).getDescProduto());
			System.out.println(lista.get(i).getDataValidade());
			System.out.println(lista.get(i).getDataCadastro());
			System.out.println(lista.get(i).getPreco());
			System.out.println(lista.get(i).getAtivo());
			
		}
	}
	
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setDescProduto(request.getParameter("Desc_Produto"));
		produto.setDataValidade(request.getParameter("Data_Validade"));
		produto.setDataCadastro(request.getParameter("Data_Cadastro"));
		produto.setPreco(request.getParameter("Preco"));
		produto.setAtivo(request.getParameter("Ativo"));
	
		dao.inserirProduto(produto);
		response.sendRedirect("main");
	}
}
