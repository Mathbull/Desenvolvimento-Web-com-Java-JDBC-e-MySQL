package model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Consulta.
 */
public class Consulta {
	
	/** The id. */
	private String id;
	
	/** The id paciente. */
	private String idPaciente;
	
	/** The id medico. */
	private String idMedico;
	
	/** The data consulta. */
	private Date dataConsulta;
	
	/** The paciente. */
	private String paciente;
	
	/** The medico. */
	private String medico;
	
	/**
	 * Instantiates a new consulta.
	 */
	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new consulta.
	 *
	 * @param id the id
	 * @param idPaciente the id paciente
	 * @param idMedico the id medico
	 * @param dataConsulta the data consulta
	 * @param paciente the paciente
	 * @param medico the medico
	 */
	public Consulta(String id, String idPaciente, String idMedico, Date dataConsulta, String paciente, String medico) {
		super();
		this.id = id;
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
		this.dataConsulta = dataConsulta;
		this.paciente = paciente;
		this.medico = medico;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the id paciente.
	 *
	 * @return the id paciente
	 */
	public String getIdPaciente() {
		return idPaciente;
	}

	/**
	 * Sets the id paciente.
	 *
	 * @param idPaciente the new id paciente
	 */
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	/**
	 * Gets the id medico.
	 *
	 * @return the id medico
	 */
	public String getIdMedico() {
		return idMedico;
	}

	/**
	 * Sets the id medico.
	 *
	 * @param idMedico the new id medico
	 */
	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	/**
	 * Gets the data consulta.
	 *
	 * @return the data consulta
	 */
	public Date getDataConsulta() {
		return dataConsulta;
	}

	/**
	 * Sets the data consulta.
	 *
	 * @param dataConsulta the new data consulta
	 */
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	/**
	 * Gets the paciente.
	 *
	 * @return the paciente
	 */
	public String getPaciente() {
		return paciente;
	}

	/**
	 * Sets the paciente.
	 *
	 * @param paciente the new paciente
	 */
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	/**
	 * Gets the medico.
	 *
	 * @return the medico
	 */
	public String getMedico() {
		return medico;
	}

	/**
	 * Sets the medico.
	 *
	 * @param medico the new medico
	 */
	public void setMedico(String medico) {
		this.medico = medico;
	}
	
	
}
