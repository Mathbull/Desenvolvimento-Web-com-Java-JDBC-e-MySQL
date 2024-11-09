package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Consulta;
import model.DAO;
import model.Medico;
import model.Paciente;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet( urlPatterns =  {"/Controller", "/paciente", "/medico", "/consulta", 
		"/novoPaciente", "/insertPaciente", "/dltPacient", "/selectPacient", "/updatePaciente", 
		"/novoMedico", "/insertMedico", "/dltMedico", "/selectMedico", "/updateMedico",
		"/novaConsulta", "/insertConsulta", "/dltConsulta", "/selectConsulta", "/updateConsulta"})

public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The formato. */
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
	
	/** The dao. */
	// ---------------------- DAO ------------------------
	DAO dao = new DAO();
	
	/** The pct. */
	//  -------------------  DTO'S ------------------------------
    Paciente pct = new Paciente();
    
    /** The mdc. */
    Medico mdc = new Medico();
    
    /** The cst. */
    Consulta cst = new Consulta();
    
    
 
    /**
     * Instantiates a new controller.
     */
    public Controller() {
        super();
    }
	
	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		
		
		// --------------------------- PACIENTE ------------------------------------
		if(url.equals("/paciente")) {
			readPacientes(request, response);
			
		}else if(url.equals("/novoPaciente")) {
			novoPaiente(request, response);
	
		}else if(url.equals("/insertPaciente")) {
			insertPaciente(request, response);

		}else if(url.equals("/dltPacient")) {
			dltPacient(request, response);

		}else if(url.equals("/selectPacient")) {
			selectPacient(request, response);
			
		}else if(url.equals("/updatePaciente")) {
			updatePaciente(request, response);
		}
		
		// ----------------------- MEDICO ---------------------------------------
		else if(url.equals("/medico")) {
			readMedicos(request, response);
			
		}else if(url.equals("/novoMedico")) {
			novomedico(request, response);
			
		}else if(url.equals("/insertMedico")) {
			insertMedico(request, response);
			
		}else if(url.equals("/dltMedico")) {
			dltMedico(request, response);
			
		}else if(url.equals("/selectMedico")) {
			selectMedico(request, response);
			
		}else if(url.equals("/updateMedico")) {
			updateMedico(request, response);
		}
		
		// ------------------------------- CONSULTA ------------------------------
		else if(url.equals("/consulta")) {
			readConsultas(request, response);
			
		}else if(url.equals("/novaConsulta")) {
			novaConsulta(request, response);
			
		}else if(url.equals("/insertConsulta")) {
			insertConsulta(request, response);
			
		}else if(url.equals("/dltConsulta")) {
			dltConsulta(request, response);
			
		}else if(url.equals("/selectConsulta")) {
			selectConsulta(request, response);
			
		}else if(url.equals("/updateConsulta")) {
			updateConsulta(request, response);
		}
		
		// ------------------------------ URLS NÃO ESPECIFICADAS -------------------------------
		else {
			response.sendRedirect("index.html");
		}
		
	}
	
	// -------------------------------------------------- PACIENTE -------------------------------------------------------
	/**
	 * Read pacientes.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - READ
	protected void readPacientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Paciente> pacientes = dao.pacientes();
		
		request.setAttribute("pacientes", pacientes);
		RequestDispatcher rd = request.getRequestDispatcher("paciente.jsp");
		
		rd.forward(request, response);
	}
	
	/**
	 * Novo paiente.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRAMAR VIEW PARA NOVA ENTIDADTE
	protected void novoPaiente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setAttribute("view", "views/novoPaciente.jsp" );
			RequestDispatcher rd = request.getRequestDispatcher("paciente.jsp");
			
			rd.forward(request, response);
		}
	
	/**
	 * Insert paciente.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - INSERT
	protected void insertPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf_crm");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		pct.setNome(nome);
		pct.setCpf(cpf);
		pct.setPhone(phone);
		pct.setEmail(email);
		
		boolean resultInsert = dao.insertPaciente(pct);
		HashMap<String, String>  dict = new HashMap<>(); 
		if(resultInsert == true) {
			dict.put("sucesso", "Paciente "+pct.getNome()+" criado com sucesso!!");
			request.setAttribute("result", dict );
		}else {
			dict.put("falha", "Falha ao adicionar o "+pct.getNome());
			request.setAttribute("result", dict );
		}
		
		request.setAttribute("view", "views/novoPaciente.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("paciente.jsp");
		rd.forward(request, response);
		
		
	}
	
	/**
	 * Dlt pacient.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - DELETE
	protected void dltPacient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pct.setId(request.getParameter("id"));
		dao.deletPaciente(pct);
		
		response.sendRedirect("paciente");
		
		
	}
	
	/**
	 * Select pacient.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - READ POR ID
	protected void selectPacient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pct.setId(request.getParameter("id"));
		dao.selectPacient(pct);
		
		request.setAttribute("id", pct.getId());
		request.setAttribute("cpf_crm", pct.getCpf());
		request.setAttribute("nome", pct.getNome());
		request.setAttribute("phone", pct.getPhone());
		request.setAttribute("email", pct.getEmail());
		
		request.setAttribute("view", "views/editPacinete.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("paciente.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * Update paciente.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - UPDATE
	protected void updatePaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pct.setId(request.getParameter("id"));
		pct.setCpf(request.getParameter("cpf_crm"));
		pct.setNome(request.getParameter("nome"));
		pct.setPhone(request.getParameter("phone"));
		pct.setEmail(request.getParameter("email"));
				 	
		dao.updatePaciente(pct);
		
		
		response.sendRedirect("paciente");
	}
	
	
	// ----------------------------------------------- MEDICO ------------------------------------------------------------
	/**
	 * Read medicos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - READ
	protected void readMedicos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			ArrayList<Medico> medicos = dao.medicos();
			
			request.setAttribute("medicos", medicos);
			RequestDispatcher rd = request.getRequestDispatcher("medico.jsp");
			
			rd.forward(request, response);
	}
	
	/**
	 * Novomedico.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRAMAR VIEW PARA NOVA ENTIDADTE
	protected void novomedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("view", "views/novoMedico.jsp" );
		RequestDispatcher rd = request.getRequestDispatcher("medico.jsp");
		
		rd.forward(request, response);
	}
	
	/**
	 * Insert medico.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - INSERT
	protected void insertMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String crm = request.getParameter("cpf_crm");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		mdc.setNome(nome);
		mdc.setCrm(crm);
		mdc.setPhone(phone);
		mdc.setEmail(email);
		
		boolean resultInsert = dao.insertMedico(mdc);
		HashMap<String, String>  dict = new HashMap<>(); 
		if(resultInsert == true) {
			dict.put("sucesso", "Medico "+mdc.getNome()+" adicionado com sucesso!!");
		}else {
			dict.put("falha", "Falha ao adicionar o "+mdc.getNome());
		}
		
		request.setAttribute("result", dict );
		request.setAttribute("view", "views/novoMedico.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("medico.jsp");
		rd.forward(request, response);
		
		
	}
	
	/**
	 * Dlt medico.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - DELETE
	protected void dltMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		mdc.setId(request.getParameter("id"));
		dao.deletMedico(mdc);
		
		response.sendRedirect("medico");
	}
	
	/**
	 * Select medico.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - READ POR ID
	protected void selectMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		mdc.setId(request.getParameter("id"));
		dao.selectMedico(mdc);
		
		request.setAttribute("id", mdc.getId());
		request.setAttribute("cpf_crm", mdc.getCrm());
		request.setAttribute("nome", mdc.getNome());
		request.setAttribute("phone", mdc.getPhone());
		request.setAttribute("email", mdc.getEmail());
		
		request.setAttribute("view", "views/editMedico.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("medico.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * Update medico.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - UPDATE
	protected void updateMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		mdc.setId(request.getParameter("id"));
		mdc.setCrm(request.getParameter("cpf_crm"));
		mdc.setNome(request.getParameter("nome"));
		mdc.setPhone(request.getParameter("phone"));
		mdc.setEmail(request.getParameter("email"));
				 	
		dao.updateMedico(mdc);
		
		
		response.sendRedirect("medico");
	}
	
	// ------------------------------------------------ CONSULTA ------------------------------------------------------------
	/**
	 * Read consultas.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - READ
	protected void readConsultas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Consulta> consultas = dao.consultas();
		
		
		request.setAttribute("consultas", consultas);
		RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
		
		rd.forward(request, response);
}
	
	/**
	 * Nova consulta.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRAMAR VIEW PARA NOVA ENTIDADTE
	protected void novaConsulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Medico> medicos = dao.medicos();
		request.setAttribute("medicos", medicos);
		
		ArrayList<Paciente> pacientes = dao.pacientes();
		request.setAttribute("pacientes", pacientes);
		
		request.setAttribute("view", "views/novaConsulta.jsp" );
		RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
		
		rd.forward(request, response);
	}
	
	/**
	 * Insert consulta.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - INSERT
	protected void insertConsulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_pacente = request.getParameter("selectPaciente");
		String id_medico = request.getParameter("selectMedico");
		try {
			Date date = formato.parse(request.getParameter("date"));
			cst.setDataConsulta(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cst.setIdPaciente(id_pacente);
		cst.setIdMedico(id_medico);
		

		
		
		boolean resultInsert = dao.insertConsulta(cst);
		HashMap<String, String>  dict = new HashMap<>(); 
		if(resultInsert == true) {
			dict.put("sucesso", "consulta adicionado com sucesso!!");
		}else {
			dict.put("falha", "Falha ao adicionar consulta");
		}
		
		ArrayList<Medico> medicos = dao.medicos();
		request.setAttribute("medicos", medicos);
		
		ArrayList<Paciente> pacientes = dao.pacientes();
		request.setAttribute("pacientes", pacientes);
		
		request.setAttribute("result", dict );
		request.setAttribute("view","views/novaConsulta.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
		rd.forward(request, response);
		
		
	}
	
	/**
	 * Dlt consulta.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - DELETE
	protected void dltConsulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		cst.setId(request.getParameter("id"));
		dao.deletConsulta(cst);
		
		response.sendRedirect("consulta");
	}
	
	/**
	 * Select consulta.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - READ POR ID
	protected void selectConsulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		cst.setId(request.getParameter("id"));
		dao.selectConsulta(cst);
		
		request.setAttribute("id", cst.getId());
		request.setAttribute("idPaciente", cst.getIdPaciente());
		request.setAttribute("idMedico", cst.getIdMedico());
		request.setAttribute("Paciente", cst.getPaciente());
		request.setAttribute("medico", cst.getMedico());
		request.setAttribute("date", cst.getDataConsulta());
		
		
		ArrayList<Paciente> pacientes = dao.pacientes();
		ArrayList<Medico> medicos = dao.medicos();  
        
   
        medicos.removeIf(medico -> medico.getId().equals(cst.getIdMedico()));  
        pacientes.removeIf(paciente -> paciente.getId().equals(cst.getIdPaciente()));

		request.setAttribute("medicos", medicos);
		request.setAttribute("pacientes", pacientes);
		
		request.setAttribute("view", "views/editConsulta.jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * Update consulta.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// CRUD - UPDATE
	protected void updateConsulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		cst.setId(request.getParameter("id"));
		cst.setIdPaciente(request.getParameter("selectPaciente"));
		cst.setIdMedico(request.getParameter("selectMedico"));
		try {
			Date date = formato.parse(request.getParameter("date"));
			cst.setDataConsulta(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				 	
		dao.updateConsulta(cst);
		
		
		response.sendRedirect("consulta");
	}
	
}
