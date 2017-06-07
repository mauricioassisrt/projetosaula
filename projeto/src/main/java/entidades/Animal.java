package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


@Entity
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int brinco;
	private String nomeAnimal;
	private double valorCompra;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dataCompra;
	private int idade;
	private char sexo;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dtNascimento;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dtDesmame;
	private boolean desmamado;
	private boolean naovendido;
	private double valorVenda;
	private String lactando;
	@ManyToOne
	private Tipo objetoTipo;
	@ManyToOne
	private Raca objetoRaca;
	@ManyToOne
	private Origem objetoOrigem;
	
	
	
	
	public boolean isNaovendido() {
		return naovendido;
	}
	public void setNaovendido(boolean naovendido) {
		this.naovendido = naovendido;
	}
	public String getLactando() {
		return lactando;
	}
	public void setLactando(String lactando) {
		this.lactando = lactando;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public boolean isDesmamado() {
		return desmamado;
	}
	public void setDesmamado(boolean desmamado) {
		this.desmamado = desmamado;
	}
	public Date getDtDesmame() {
		return dtDesmame;
	}
	public void setDtDesmame(Date dtDesmame) {
		this.dtDesmame = dtDesmame;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getBrinco() {
		return brinco;
	}
	public void setBrinco(int brinco) {
		this.brinco = brinco;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public double getValorCompra() {
		return valorCompra;
	}
	
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Tipo getObjetoTipo() {
		return objetoTipo;
	}
	public void setObjetoTipo(Tipo objetoTipo) {
		this.objetoTipo = objetoTipo;
	}
	public Raca getObjetoRaca() {
		return objetoRaca;
	}
	public void setObjetoRaca(Raca objetoRaca) {
		this.objetoRaca = objetoRaca;
	}
	public Origem getObjetoOrigem() {
		return objetoOrigem;
	}
	public void setObjetoOrigem(Origem objetoOrigem) {
		this.objetoOrigem = objetoOrigem;
	}
	
	
}
