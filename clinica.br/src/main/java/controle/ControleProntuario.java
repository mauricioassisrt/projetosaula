package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ArrayUtils;

import banco.DAOGenerico;
import entidades.Medico;
import entidades.Paciente;
import entidades.Prontuario;

@ManagedBean
@SessionScoped
public class ControleProntuario {

	DAOGenerico dao = new DAOGenerico();
	Medico objetoMedico = new Medico();
	Paciente objetoPaciente = new Paciente();
	Prontuario objetoProntuario = new Prontuario();
	List<Paciente> listaPaciente = new ArrayList<>();
	List<Prontuario> listaProntuario = new ArrayList<>();
	String informacoes, nomePaciente, informacoes2;
	
	public ControleProntuario() {
		preencher();
	}
	public void preencher(){
		objetoMedico = UsuarioLogado.retornaUsuarioLogado();
		listaPaciente = dao.lista(Paciente.class);
		listaProntuario = dao.lista(Prontuario.class);
	}
	public void novo(){
		objetoMedico = new Medico();
		objetoPaciente = new Paciente();
		objetoProntuario = new Prontuario();
	}
	public void adicionarPessoaAoProntuario(Paciente objeto) throws IOException{
		 objetoPaciente = objeto;
		//Adiciona paciente ao prontuario e medico
		objetoProntuario.setObjetoPaciente(objetoPaciente);
		objetoProntuario.setObjetoMedico(objetoMedico);
		nomePaciente = objetoPaciente.getNome();
		informacoes = "";
		
		for (Prontuario prontuario : listaProntuario) {
			
			if(objetoPaciente.getId() ==prontuario.getObjetoPaciente().getId()){
			 informacoes = prontuario.getInformações();
			 nomePaciente = prontuario.getObjetoPaciente().getNome();
			 System.out.println("IF 0----- Paciente "+objetoPaciente.getNome()+" medico "+objetoMedico.getNome()+objetoPaciente.getId());
			 
			}else{
				
			}
			
		}
		objetoPaciente = new Paciente();
		FacesContext.getCurrentInstance().getExternalContext().redirect("novaConsulta.jsf");
		
	}
	
	public void limparBean(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.removeAttribute("controleProntuario");

	}
	
	public void realizarConsulta()throws IOException{
		
		objetoProntuario.setDataProntuario(new Date());
		objetoProntuario.setInformações(informacoes2);
		dao.inserir(objetoProntuario);
		
		objetoProntuario = new Prontuario();
		limparBean();
		FacesContext.getCurrentInstance().getExternalContext().redirect("listaPacientes.jsf");
		
		
	}
	
	public Medico getObjetoMedico() {
		return objetoMedico;
	}
	public void setObjetoMedico(Medico objetoMedico) {
		this.objetoMedico = objetoMedico;
	}
	public Paciente getObjetoPaciente() {
		return objetoPaciente;
	}
	public void setObjetoPaciente(Paciente objetoPaciente) {
		this.objetoPaciente = objetoPaciente;
	}
	public Prontuario getObjetoProntuario() {
		return objetoProntuario;
	}
	public void setObjetoProntuario(Prontuario objetoProntuario) {
		this.objetoProntuario = objetoProntuario;
	}
	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}
	public void setListaPaciente(List<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getInformacoes2() {
		return informacoes2;
	}
	public void setInformacoes2(String informacoes2) {
		this.informacoes2 = informacoes2;
	}
	
	
}
