package br.com.ansu.acao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ansu.model.Banco;
import br.com.ansu.model.Empresa;

public class NovaEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String paramNome = request.getParameter("nome");
		String paramData = request.getParameter("data");
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramData);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(paramNome);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco(); 
		banco.adiciona(empresa);
		
		request.setAttribute("empresa",empresa.getNome());
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
