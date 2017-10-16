package controle;
import banco.DAOGenerico;
import entidades.Medico;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControleMedico {

		private Medico objetoMedico = new Medico();
	    private DAOGenerico dao = new DAOGenerico();
	    private List<Medico> lista = new ArrayList<>();

	    public ControleMedico(){
	    	objetoMedico = UsuarioLogado.retornaUsuarioLogado();
	        preencher();
	    }

	    public void novo() {
	        objetoMedico = new Medico();
	    }
	    public void excluir(Medico tipo){
	        objetoMedico = tipo;
	        if(tipo.getId()!=null){
	            try {
	                dao.exluir(tipo);
	            } catch (Exception ex) {
	                Logger.getLogger(ControleMedico.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	        novo();
	        preencher();
	    }
	    public void inserir() {
	    	
	    	if(objetoMedico.getId() !=null){
	    		
	    	}
	        if (objetoMedico.getId() != null) {
	            dao.inserir(objetoMedico);
	        } else {
	            dao.salvar(objetoMedico);
	        }
	        preencher();
	        novo();
	    }

	    private void preencher() {
	        lista = dao.lista(Medico.class);
	    }

	    public Medico getObjetoMedico() {
	        return objetoMedico;
	    }

	    public void setObjetoMedico(Medico objetoMedico) {
	        this.objetoMedico = objetoMedico;
	    }

	    public List<Medico> getLista() {
	        return lista;
	    }

	    public void setLista(List<Medico> lista) {
	        this.lista = lista;
	    }
	    
	
	
}
