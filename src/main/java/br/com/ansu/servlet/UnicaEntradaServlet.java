package br.com.ansu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ansu.acao.Acao;
import br.com.ansu.acao.AlteraEmpresa;
import br.com.ansu.acao.ListaEmpresas;
import br.com.ansu.acao.MostraEmpresa;
import br.com.ansu.acao.NovaEmpresa;
import br.com.ansu.acao.NovaEmpresaForm;
import br.com.ansu.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		//String nome = null;
		
		String nomeClasse = "br.com.ansu.acao." + paramAcao;
		
		String nome = null;
		try {
			Class classe = Class.forName(nomeClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
		
		
		String[] tipoEndereco = nome.split(":");
		if(tipoEndereco[0].equals("foward")){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		}
		else {
			response.sendRedirect(tipoEndereco[1]);
		}
//		
//		if(paramAcao.equals("ListaEmpresas")){
//			ListaEmpresas acao = new ListaEmpresas();
//		    nome = acao.executa(request,response);
//		}
//		
//		else if(paramAcao.equals("RemoveEmpresa")){
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request,response);
//		}
//		
//		else if(paramAcao.equals("NovaEmpresa")){
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request,response);
//		}
//		
//		if(paramAcao.equals("MostraEmpresa")){
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request,response);
//		}
//		
//		else if(paramAcao.equals("AlteraEmpresa")){
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request,response);
//		}
//		
//		else if(paramAcao.equals("NovaEmpresaForm")){
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request,response);
//		}
		
		
		
	}

}
