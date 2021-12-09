package br.com.ansu.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static Integer chaveSequencial = 1;
	
	static {
			
			Empresa empresa1 = new Empresa();
			empresa1.setId(chaveSequencial++);
			empresa1.setNome("AnsuCom1");
			
			Empresa empresa2 = new Empresa();
			empresa2.setId(chaveSequencial++);
			empresa2.setNome("AnsuCom2");
			
			lista.add(empresa1);
			lista.add(empresa2);
			
			Usuario u1 = new Usuario();
			u1.setLogin("teste");
			u1.setSenha("123");
			
			Usuario u2 = new Usuario();
			u2.setLogin("teste");
			u2.setSenha("123");
			
			listaUsuarios.add(u1);
			listaUsuarios.add(u2);
			
			
			
			
	}
	
	
	public void adiciona(Empresa empresa){
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		
		return Banco.lista;
	}
	
	public void remove(Integer id){
		Iterator<Empresa> it = lista.iterator();
		while(it.hasNext()){
			Empresa emp = it.next();
			if(emp.getId() == id){
				it.remove();
			}
		}
	}
	
	public Empresa buscaPorId(Integer id){
		for(Empresa empresa : lista ){
			if(empresa.getId() == id){
				return empresa;
			}
		}
		
		return null;
		
	}
}
