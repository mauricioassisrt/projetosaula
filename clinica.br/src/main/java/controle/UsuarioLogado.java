package controle;


import org.springframework.security.core.context.SecurityContextHolder;

import banco.DAOGenerico;
import entidades.Medico;

public class UsuarioLogado {

	public static Medico retornaUsuarioLogado(){
		try {
			Medico p = new Medico();
			p = (Medico) new DAOGenerico().listaCondicao(Medico.class, "email = '"+SecurityContextHolder.getContext().getAuthentication().getName()+"'").get(0);
			return p;			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
