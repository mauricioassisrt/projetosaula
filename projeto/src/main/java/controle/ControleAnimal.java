/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import banco.Banco;
import banco.DAOGenerico;
import entidades.Animal;
import entidades.Origem;
import entidades.Raca;
import entidades.Remedios;
import entidades.Tipo;
import entidades.Vacinacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ControleAnimal {
    
	private Animal objetoAnimal = new Animal();
    private DAOGenerico dao = new DAOGenerico();
    private List<Animal> lista = new ArrayList<>();
    private Vacinacao objetoVacinacao = new Vacinacao();
    private Remedios objetoRemedios= new Remedios();
    private List<Vacinacao> listaCondicaoAnimal = new ArrayList<>();
    
    
    public List<Remedios> completaRemedios(String parametro){
 		List<Remedios> listaRemedios = new ArrayList<Remedios>();
 		listaRemedios = dao.listaCondicao(Remedios.class, "LOWER(nomeVacina)  LIKE LOWER('%"+parametro+"%')");
 		return listaRemedios;
 	}
    public List<Origem> completaOrigem(String parametro){
		List<Origem> listaOrigem = new ArrayList<Origem>();
		listaOrigem = dao.listaCondicao(Origem.class, "LOWER(local)  LIKE LOWER('%"+parametro+"%')");
		return listaOrigem;
	}
    
    public List<Tipo> completaTipo(String parametro){
		List<Tipo> listaTipo = new ArrayList<Tipo>();
		listaTipo = dao.listaCondicao(Tipo.class, "LOWER(animalTipo)  LIKE LOWER('%"+parametro+"%')");
		return listaTipo;
	}
    
    public List<Raca> completaRaca(String parametro){
		List<Raca> listaRaca = new ArrayList<Raca>();
		listaRaca = dao.listaCondicao(Raca.class, "LOWER(nomeDaRaca)  LIKE LOWER('%"+parametro+"%')");
		return listaRaca;
	}
    public ControleAnimal(){
        preencher();
    }

    public void novo() {
        objetoAnimal = new Animal();
    }
    public void excluir(Animal tipo){
        objetoAnimal = tipo;
        if(tipo.getId()!=null){
            try {
                dao.exluir(tipo);
            } catch (Exception ex) {
                Logger.getLogger(ControleAnimal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        novo();
        preencher();
    }
    
    public void inserirMovimento() throws IOException{
    	FacesContext faces = FacesContext.getCurrentInstance();
        if (objetoVacinacao.getId() == null ) {
        	if(objetoAnimal.getIdade()<=objetoRemedios.getLimiteIdade()){
        		System.out.println(objetoAnimal.getIdade() + objetoRemedios.getLimiteIdade());
            	objetoVacinacao.setObjetoAnimal(objetoAnimal);
            	objetoVacinacao.setObjetoRemedio(objetoRemedios);
            	objetoVacinacao.setDataVacinacao(new Date());
                dao.inserir(objetoVacinacao);
                faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Animal Vacinado com Sucesso !!!!"));	
                
        	}else{
        		faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"","A idade do animal não é permitida para a vacina!!"));	
        	}
        } else {
            dao.salvar(objetoVacinacao);
        }
        preencher();
        novo();
        objetoRemedios = new Remedios();
        objetoVacinacao = new Vacinacao();
        
    }
    
    
    public void inserir() {
        if (objetoAnimal.getId() == null) {
            objetoAnimal.setDesmamado(false);
            objetoAnimal.setNaovendido(false);
        	dao.inserir(objetoAnimal);
        	Banco.getInstancia();
            
        } else {
            objetoAnimal.setNaovendido(false);
            dao.salvar(objetoAnimal);
        }
        preencher();
        novo();
    }

    
    private void preencher() {
        lista = dao.lista(Animal.class);
        listaCondicaoAnimal = dao.lista(Vacinacao.class);
    }

    
    
	public List<Vacinacao> getListaCondicaoAnimal() {
		return listaCondicaoAnimal;
	}
	public void setListaCondicaoAnimal(List<Vacinacao> listaCondicaoAnimal) {
		this.listaCondicaoAnimal = listaCondicaoAnimal;
	}
	public Animal getObjetoAnimal() {
        return objetoAnimal;
    }

    public void setObjetoAnimal(Animal objetoAnimal) {
        this.objetoAnimal = objetoAnimal;
    }

    public List<Animal> getLista() {
        return lista;
    }

    public void setLista(List<Animal> lista) {
        this.lista = lista;
    }
	public Vacinacao getObjetoVacinacao() {
		return objetoVacinacao;
	}
	public void setObjetoVacinacao(Vacinacao objetoVacinacao) {
		this.objetoVacinacao = objetoVacinacao;
	}
	public Remedios getObjetoRemedios() {
		return objetoRemedios;
	}
	public void setObjetoRemedios(Remedios objetoRemedios) {
		this.objetoRemedios = objetoRemedios;
	}
    
}
