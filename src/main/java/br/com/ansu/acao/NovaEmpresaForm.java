package br.com.ansu.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresaForm  implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response){
		
		
		
		return "foward:formNovaEmpresa.jsp";
		
	}

}
