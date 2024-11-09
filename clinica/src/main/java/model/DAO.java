package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date; 

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://localhost:3306/dbclinica?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "";
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// CONECTOR DO BD	
	private Connection conectar() {
		Connection con = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// -------------------------------------- PACIENTE --------------------------------------------------
	/**
	 * Pacientes.
	 *
	 * @return the array list
	 */
	// CRUD - READ
	public ArrayList<Paciente> pacientes(){
		
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		
		String read = "SELECT * FROM pacientes order by nome;";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				pacientes.add(new Paciente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			
			pst.close();
			return pacientes;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Insert paciente.
	 *
	 * @param paciente the paciente
	 * @return the boolean
	 */
	// CRUD - INSERT
	public Boolean insertPaciente(Paciente paciente) {
		String insert = "INSERT INTO pacientes(cpf, nome, phone, email) values(?, ?, ?, ?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setString(1, paciente.getCpf());
			pst.setString(2, paciente.getNome());
			pst.setString(3, paciente.getPhone());
			pst.setString(4, paciente.getEmail());
			pst.executeUpdate();
			pst.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Delet paciente.
	 *
	 * @param paciente the paciente
	 */
	// CRUD - DELETE
	public void deletPaciente(Paciente paciente) {
		String delete = "DELETE FROM pacientes where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, paciente.getId());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	/**
	 * Select pacient.
	 *
	 * @param pct the pct
	 */
	// CRUD - READ POR ID
	public void selectPacient(Paciente pct) {
		String select = "SELECT * FROM pacientes where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(select);
			pst.setString(1, pct.getId());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {	
				pct.setId(Integer.toString(rs.getInt(1)));
				pct.setCpf(rs.getString(2));
				pct.setNome(rs.getString(3));
				pct.setPhone(rs.getNString(4));
				pct.setEmail(rs.getString(5));	
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Update paciente.
	 *
	 * @param pct the pct
	 */
	// CRUD - UPDATE
	public void updatePaciente(Paciente pct) {
		String update = "update pacientes SET cpf=?, nome=?, phone=?, email=? WHERE id=? ;";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			
			pst.setString(1, pct.getCpf());
			pst.setString(2, pct.getNome());
			pst.setString(3, pct.getPhone());
			pst.setString(4, pct.getEmail());
			pst.setString(5, pct.getId());
			
			pst.executeUpdate();
			pst.close();
			System.out.println("ID a ser atualizado: " + pct.getId());  

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// -------------------------- MEDICO ------------------------------------
	/**
	 * Medicos.
	 *
	 * @return the array list
	 */
	// CRUD - READ
	public ArrayList<Medico> medicos(){
		ArrayList<Medico> mdc = new ArrayList<Medico>();
		
		String read = "SELECT * FROM medicos order by nome;";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				mdc.add(new Medico(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			
			pst.close();
			return mdc;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Insert medico.
	 *
	 * @param mdc the mdc
	 * @return the boolean
	 */
	// CRUD - INSERT
	public Boolean insertMedico(Medico mdc) {
		String insert = "INSERT INTO medicos(crm, nome, phone, email) values(?, ?, ?, ?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setString(1, mdc.getCrm());
			pst.setString(2, mdc.getNome());
			pst.setString(3, mdc.getPhone());
			pst.setString(4, mdc.getEmail());
			pst.executeUpdate();
			pst.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Delet medico.
	 *
	 * @param mdc the mdc
	 */
	// CRUD - DELETE
	public void deletMedico(Medico mdc) {
		String delete = "DELETE FROM medicos where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, mdc.getId());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Select medico.
	 *
	 * @param mdc the mdc
	 */
	// CRUD - READ POR ID
	public void selectMedico(Medico mdc) {
		String select = "SELECT * FROM medicos where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(select);
			pst.setString(1, mdc.getId());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {	
				mdc.setId(Integer.toString(rs.getInt(1)));
				mdc.setCrm(rs.getString(2));
				mdc.setNome(rs.getString(3));
				mdc.setPhone(rs.getNString(4));
				mdc.setEmail(rs.getString(5));	
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Update medico.
	 *
	 * @param mdc the mdc
	 */
	// CRUD - UPDATE
	public void updateMedico(Medico mdc) {
		String update = "update medicos SET crm=?, nome=?, phone=?, email=? WHERE id=? ;";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			
			pst.setString(1, mdc.getCrm());
			pst.setString(2, mdc.getNome());
			pst.setString(3, mdc.getPhone());
			pst.setString(4, mdc.getEmail());
			pst.setString(5, mdc.getId());
			
			pst.executeUpdate();
			pst.close();
			System.out.println("ID a ser atualizado: " + mdc.getId());  

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------- CONSULTA ------------------------------------------	
	/**
	 * Consultas.
	 *
	 * @return the array list
	 */
	// CRUD - READ
	public ArrayList<Consulta> consultas(){
		ArrayList<Consulta> cst = new ArrayList<Consulta>();
		
		String read = "SELECT cst.*, pct.nome, mdc.nome FROM consultas as cst"
				+ " LEFT JOIN pacientes pct ON cst.id_paciente = pct.id"
				+ " LEFT JOIN medicos mdc ON cst.id_medico = mdc.id;";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				cst.add(new Consulta(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6)));
			}
			
			pst.close();
			return cst;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Insert consulta.
	 *
	 * @param cst the cst
	 * @return the boolean
	 */
	// CRUD - INSERT
	public Boolean insertConsulta(Consulta cst) {
		String insert = "INSERT INTO consultas (id_paciente, id_medico, data_consulta) values(?, ?, ?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setString(1, cst.getIdPaciente());
			pst.setString(2, cst.getIdMedico());
			pst.setDate(3, new Date(cst.getDataConsulta().getTime()));
			
			pst.executeUpdate();
			pst.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Delet consulta.
	 *
	 * @param cst the cst
	 */
	// CRUD - DELETE
	public void deletConsulta(Consulta cst) {
		String delete = "DELETE FROM consultas where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, cst.getId());
			pst.executeUpdate();
			pst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	/**
	 * Select consulta.
	 *
	 * @param cst the cst
	 */
	// CRUD - READ POR ID
	public void selectConsulta(Consulta cst) {
		String select = "SELECT cst.*, pct.nome, mdc.nome FROM consultas as cst"
				+ " LEFT JOIN pacientes pct ON cst.id_paciente = pct.id"
				+ " LEFT JOIN medicos mdc ON cst.id_medico = mdc.id"
				+ " WHERE cst.id =? ;";
		
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(select);
			pst.setString(1, cst.getId());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {	
				cst.setId(Integer.toString(rs.getInt(1)));
				cst.setIdPaciente(rs.getString(2));
				cst.setIdMedico(rs.getString(3));
				cst.setDataConsulta(rs.getDate(4));
				cst.setPaciente(rs.getString(5));
				cst.setMedico(rs.getString(6));
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Update consulta.
	 *
	 * @param cst the cst
	 */
	// CRUD - UPDATE
	public void updateConsulta(Consulta cst) {
		String update = "update consultas SET id_paciente=?, id_medico=? WHERE id=? ;";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			
			pst.setString(1, cst.getIdPaciente());
			pst.setString(2, cst.getIdMedico());
			pst.setString(3, cst.getId());
	
			
			pst.executeUpdate();
			pst.close();
			System.out.println("ID a ser atualizado da consulta: " + cst.getId());  

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
