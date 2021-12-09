package br.com.ansu.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ansu.model.Banco;
import br.com.ansu.model.Usuario;

public class Login implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramLogin = request.getParameter("login");
		String paramSenha = request.getParameter("senha");
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(paramLogin, paramSenha);
		
			
		
		if(usuario != null) {
		
			return "redirect:entrada?acao=ListaEmpresas";
			
		}
		else{
			return "redirect:entrada?acao=LoginForm";
		}
		
		
		
		
		
		
		
}
	}
