function formatarData(event){
	return (event.charCode >= 48 && event.charCode <= 57)
}

function precoReais(v) {
    v = v.replace(/\D/g, "") //Remove tudo o que não é dígito
    v = v.replace(/(\d{1})$/, ",$1") //Coloca a virgula

   if(v.length >= 5){
      var maximo = v.replace(/\./g,'').replace(',','.') > 9999999999999.99;
      var minimo = v.replace(/\./g,'').replace(',','.') < 0.01;

      if(maximo){
         return '0000';
      }else if(minimo){
         return '0000';
      }else{
         return v;
      }
   }else{
      return v;
   }
 }

function formatarPreco(event){
	frmProduto.Preco.value = 'R$ ' + precoReais(frmProduto.Preco.value)
	
	return (event.charCode >= 48 && event.charCode <= 57 || event.charCode >= 44)
}

function limpar(){
	frmProduto.Desc_Produto.value = ''
	frmProduto.Data_Validade.value = ''
	frmProduto.Data_Cadastro.value = ''
	frmProduto.Preco.value = 'R$ 0000'
	frmProduto.Ativo.checked = false
}

function gravar(){
	let dataValidade = frmProduto.Data_Validade.value
	let dataCadastro = frmProduto.Data_Cadastro.value
	let descricao    = frmProduto.Desc_Produto.value
	let preco 		 = frmProduto.Preco.value
	
	if (descricao === "") {
		alert("Preencha o campo Descrição!")
		frmProduto.Desc_Produto.focus()
		return false
	} else if (preco === "") {
		alert("Preencha o campo Preco!")
		frmProduto.Preco.focus()
		return false
	} else if (dataValidade < '01-01-2024' || dataValidade > '31-01-2050') {
		alert("Preencha corretamente o campo Data de Validade!")
		frmProduto.Data_Validade.focus()
		return false
	} else if (dataCadastro < '01-01-2024'  || dataCadastro > '31-01-2050') {
		alert("Preencha corretamente o campo Data de Cadastro!")
		frmProduto.Data_Cadastro.focus()
		return false	
	} else {
		document.forms["frmProduto"].submit()
		confirm("Produto salvo com sucesso!")
	}
}
