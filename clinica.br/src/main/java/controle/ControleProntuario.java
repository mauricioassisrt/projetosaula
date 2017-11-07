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
	List<Prontuario> listaExibeProntuario = new ArrayList<>();
	String informacoes, nomePaciente, informacoes2;
	Long idPaciente;
	
	public ControleProntuario() {
		preencher();
	}
	public void preencher(){
		objetoMedico = UsuarioLogado.retornaUsuarioLogado();
		listaPaciente = dao.lista(Paciente.class);
		listaProntuario = dao.lista(Prontuario.class);

		System.out.println("No metodo preeecher");
	}
	public void novo(){
		objetoMedico = new Medico();
		objetoPaciente = new Paciente();
		objetoProntuario = new Prontuario();

		System.out.println("No metodo Novo");
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
			 informacoes = prontuario.getInformacoes();
			 nomePaciente = prontuario.getObjetoPaciente().getNome();
			 System.out.println("IF 0----- Paciente "+objetoPaciente.getNome()+" medico "+objetoMedico.getNome()+objetoPaciente.getId());
			 idPaciente = objetoPaciente.getId();
			}else{
				
			}
			
		}
		objetoPaciente = new Paciente();
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("novaConsulta.jsf");

		System.out.println("No metodo AdicionarProntuario");
	}
	
	public void limparBean(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.removeAttribute("controleProntuario");
		informacoes2 = "";
		nomePaciente = "";
		listaExibeProntuario = new ArrayList<>();
		objetoPaciente = new Paciente();
		objetoProntuario = new Prontuario();

	}
	
	public void realizarConsulta()throws IOException{
		System.out.println("Entrou");
		objetoProntuario.setDataProntuario(new Date());
		objetoProntuario.setInformacoes(informacoes2);
		System.out.println("Salvou"+objetoProntuario.getDataProntuario()+" Inform"+objetoProntuario.getInformacoes());
		dao.inserir(objetoProntuario);
		System.out.println("Saiu");
		preencher();
		System.out.println("Preencher");
		exibirDadosDaConsulta();
		System.out.println("Exibir");
		objetoProntuario = new Prontuario();
		FacesContext.getCurrentInstance().getExternalContext().redirect("consultas.jsf");

		System.out.println("Saiu");
		
	}
	public void exibirDadosDaConsulta(){
	
		for (Prontuario prontuario : listaProntuario) {
			if(prontuario.getObjetoPaciente().getId().equals(idPaciente)){
				listaExibeProntuario.add(prontuario);
			}
		}

		System.out.println("No metodo ExibirDadosConsulta");
	}
	
	
	
	public List<Prontuario> getListaProntuario() {
		return listaProntuario;
	}
	public void setListaProntuario(List<Prontuario> listaProntuario) {
		this.listaProntuario = listaProntuario;
	}
	public List<Prontuario> getListaExibeProntuario() {
		return listaExibeProntuario;
	}
	public void setListaExibeProntuario(List<Prontuario> listaExibeProntuario) {
		this.listaExibeProntuario = listaExibeProntuario;
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
