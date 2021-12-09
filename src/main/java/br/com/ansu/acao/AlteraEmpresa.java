package br.com.ansu.acao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ansu.model.Banco;
import br.com.ansu.model.Empresa;

public class AlteraEmpresa  implements Acao{
	
	public String executa(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		
		String paramId = request.getParameter("id");
		String paramData = request.getParameter("data");
		String paramNome = request.getParameter("nome");
		
		Integer id = Integer.valueOf(paramId);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramData);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	
		Banco banco = new Banco();
		Empresa empresa = banco.buscaPorId(id);
		
		empresa.setNome(paramNome);
		empresa.setDataAbertura(dataAbertura);
	
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
