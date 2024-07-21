<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="java.util.Date" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Cadastro de Produtos</title>
		<style type="text/css">
	           @import url('https://fonts.googleapis.com/css2?family=Niramit:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;1,200;1,300;1,400;1,500;1,600;1,700&display=swap');
	
			body{
				margin: 0px;
				border: 0px;
				padding: 0px;
			}
			
			h1{
				margin: 5px;
	               padding: 5px;
	               font-family: "Niramit", sans-serif;
	               font-weight: 300;
	               font-style: normal;
			}
	
	           form{            
	               margin: 5px;
	               padding: 5px;
	               font-family: "Niramit", sans-serif;
	               font-weight: 200;
	               font-style: normal;
	               text-decoration: none;
	           }
	
	           form table tr td input{
	               border-width: 1px;
	               border-style: solid;
	               border-color:  black;          
	           }
	           
	           form table tr td .Botao{
	               cursor: pointer;          
	           }
		</style>
	</head>
	<body>
		<h1>Cadastro de Produto</h1>
		<form name="frmProduto" action="insert">
			<table>
				<tr>
					<td><label>Descrição:</label></td>
					<td><input type="text" name="Desc_Produto" class="Descricao" maxlength="50"></td>
				</tr>
										
				<tr>
					<td><label>Data de Validade:</label></td>
					<td><input type="date" name="Data_Validade" id="Data_Validade" class="Data" min="2024-01-01" max="2050-12-31" placeholder="dd/mm/aaaa" onkeypress="return formatarData(event)"></td>
				</tr>
				
				<tr>
					<td><label>Data de Cadastro:</label></td>
					<td><input type="date" name="Data_Cadastro" id="Data_Cadastro" class="Data" min="2024-01-01" max="2050-12-31"  placeholder="dd/mm/aaaa" onkeypress="return formatarData(event)"></td>
				</tr>
				
				<tr>
					<td><label>Preço:</label></td>
					<td><input type="text" min= '0.01' max = '9999999999999.99' step = 0.01 name="Preco" class="Preco" placeholder = 'R$ 0000' onkeypress="return formatarPreco(event)"></td>
				</tr>
				
				<tr>
					<td><label>Ativo:</label></td>
					<td><input type="checkbox" name="Ativo" class="Ativo"></td>
				</tr>
				
				<tr>
					<td><input type="button" value="Limpar" class="Botao" onclick="limpar()"></td>
					<td><input type="button" value="Gravar" class="Botao" onclick="gravar()"></td>
				</tr>				
			</table>
		</form>
		
		<script src="scripts/validador.js"></script>
	</body>
</html>