package entidades;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Prontuario
 *
 */
@Entity

public class Prontuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String informações;
	@ManyToOne
	private Medico objetoMedico;
	@ManyToOne
	private Paciente objetoPaciente;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataProntuario;
	public Prontuario() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getInformações() {
		return informações;
	}
	public void setInformações(String informações) {
		this.informações = informações;
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
	public Date getDataProntuario() {
		return dataProntuario;
	}
	public void setDataProntuario(Date dataProntuario) {
		this.dataProntuario = dataProntuario;
	}
	
   
}
