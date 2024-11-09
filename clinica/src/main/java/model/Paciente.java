package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Paciente.
 */
public class Paciente {

	/** The id. */
	private String id;
	
	/** The cpf. */
	private String cpf;
	
	/** The nome. */
	private String nome;
	
	/** The phone. */
	private String phone;
	
	/** The email. */
	private String email;
	
	/**
	 * Instantiates a new paciente.
	 */
	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new paciente.
	 *
	 * @param id the id
	 * @param cpf the cpf
	 * @param nome the nome
	 * @param phone the phone
	 * @param email the email
	 */
	public Paciente(String id, String cpf, String nome, String phone, String email) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.phone = phone;
		this.email = email;
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
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
