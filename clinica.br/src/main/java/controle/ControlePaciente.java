package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import banco.DAOGenerico;
import entidades.Paciente;
import entidades.Prontuario;

@ManagedBean
@ViewScoped
public class ControlePaciente {
	

	private Paciente objetoPaciente = new Paciente();
    private DAOGenerico dao = new DAOGenerico();
    private List<Paciente> lista = new ArrayList<>();
    private List<Prontuario> listaProntuario = new ArrayList<>();

    public ControlePaciente(){
    	
        preencher();
    }

    public void novo() {
        objetoPaciente = new Paciente();
    }
    public void excluir(Paciente tipo) throws IOException{
    	FacesContext faces = FacesContext.getCurrentInstance();
        objetoPaciente = tipo;
        if(tipo.getId()!=null){
            try {
                dao.exluir(tipo);
                faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atenção ","Apagado com sucesso!!!!"));		
            } catch (Exception ex) {
                Logger.getLogger(ControlePaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        novo();
        preencher();
    }
    public void inserir() throws IOException{
    	FacesContext faces = FacesContext.getCurrentInstance();
    	
        if (objetoPaciente.getId() == null) {
            dao.inserir(objetoPaciente);
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informação","Cadastrado com sucesso!!!!"));		
            
        } else {
            dao.salvar(objetoPaciente);
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informação","alteração com sucesso!!!!"));		
        }
        preencher();
        novo();
    }

    private void preencher() {
        lista = dao.lista(Paciente.class);
        listaProntuario = dao.lista(Prontuario.class);
    }

    public Paciente getObjetoPaciente() {
        return objetoPaciente;
    }

    public void setObjetoPaciente(Paciente objetoPaciente) {
        this.objetoPaciente = objetoPaciente;
    }

    public List<Paciente> getLista() {
        return lista;
    }

    public void setLista(List<Paciente> lista) {
        this.lista = lista;
    }

	public List<Prontuario> getListaProntuario() {
		return listaProntuario;
	}

	public void setListaProntuario(List<Prontuario> listaProntuario) {
		this.listaProntuario = listaProntuario;
	}
    

	
}
