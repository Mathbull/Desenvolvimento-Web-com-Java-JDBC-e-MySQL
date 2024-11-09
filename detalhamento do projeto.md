<h1 align="center"> Detalhamento do funcionamento do app </h1>

<h2 align="center" id="inicio" >Demonstração de detalhada do funionamento da aplicação web. Demostrando do codigo a interface</h2>

Sumário para navegação da página

- <a href="#home">Home</a>
- <a href="#paciente">Paciente</a>
    - <a href="#paciente_views">1. Apresentação da views de pacientes</a>
        - <a href="#uso_jsp">1.1 Uso de JSP para incluir views</a>
        - <a href="#read_pct">1.2 Leitura dos Pacientes no BD</a>
        - <a href="#request_to_view">1.3 Transformando os dados vindos do banco de dados em view HTML</a>
    - <a href="#updade_paciente">2. Editar paciente </a>
        - <a href="#read_paciente_id">2.1 Busca paciente por ID</a>
        - <a href="#setAtribute_edit_paciente">2.2 Setando atributos e view de edição</a>
        - <a href="#criando_view_edit_paciente">2.3 Criando view de edição de paciente</a>
        - <a href="#update_paciente">2.4 Realizando Update do paciente</a>

- <a href="#medico">Médico</a>
- <a href="#consulta">Consulta</a>


<h2  id="home">Home</h2>

Essa pagina, coresponde ao `` index.html  `` que atua como uma capa ou ponto de entrada para a aplicação. Além disso, serve especialmente quando não se encontra uma página específica baseada na URL que foi acessada. Este documento apresenta uma clínica médica, incluindo informações sobre pacientes, médicos e consultas.

<img src="image.png" width="800">   


<a href="#inicio">Voltar ao inicio</a>


<h2 id="paciente">Paciente</h2>

Essa aba já é dedicada ao paciente e apresenta informações sobre pacientes cadastrados, incluindo opções de edição e exclusão. Ele inclui campos essenciais como ID, CPF, nome, telefone e email para a administração dos dados dos pacientes. Além disso, o documento possibilita a adição de novos pacientes através de um link específico, facilitando a gestão das informações.

<img src="image-1.png" width="800" >   

<strong id="paciente_views">1. Apresentação da views de pacientes</strong>

<strong id="uso_jsp">1.1 Uso de JSP para incluir views:</strong> 

Um coisa interresante sobre essa pagina que por ser feita em .JSP ela nos permite fazer ``<%@ page include="caminho de um outro .jsp" > ``, que assim o controller "fala" para a pagina paciente qual vai ser a pedaço mostrando tem 3 opções com base na operação que se está executando (leitura de dados, criação ou edição), tornando a navegação mais eficiente e organizada.:

```jsp
<% if(request.getAttribute("view") == ("views/novoPaciente.jsp")){ %>
    <%@ include file="views/novoPaciente.jsp" %>
    
<%}else if(request.getAttribute("view") == ("views/editPacinete.jsp")){ %>
    <%@ include file="views/editPacinete.jsp" %>
    
<% }else{%>
    <%@ include file="views/tablePaciente.jsp" %>
<% } %> 
``` 
<strong id="read_pct">1.2 Leitura dos Pacientes:</strong> 

O controller recebe a URL ``"/paciente "``  que então realiza uma conexão com o banco de dados e executa uma query SQL para recuperar todos os pacientes ordenados pelo nome.

```java  
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
``` 

<strong id="request_to_view">1.3 Transformando os dados vindos do banco de dados em view HTML:</strong> 

A página JSP recebe os pacientes vindos do Banco de dados via request e exibe os dados dos pacientes em uma tabela, juntamente com opções para editar e excluir:

```jsp
<% 	@SuppressWarnings("unchecked")
	ArrayList<Paciente> pacientes = (ArrayList<Paciente>) request.getAttribute("pacientes"); %>
<h1>Pacientes</h1>
<a href="novoPaciente" class="btn paciente">Novo paciente</a>
<table class="tbPaciente">
    <thead>
        <tr>
            <th>ID</th>
            <th>CPF</th>
            <th>Nome</th>
            <th>Telefone</th>
            <th>Email</th>
            <th>Opções</th>
        </tr>
    </thead>
    <tbody>
        <% for(Paciente paciente: pacientes){ %>
            <tr>
                <td> <%= paciente.getId() %> </td>
                <td> <%= paciente.getCpf() %> </td> 
                <td> <%= paciente.getNome() %> </td> 
                <td> <%= paciente.getPhone() %> </td> 
                <td> <%= paciente.getEmail() %> </td> 
                <td> 
                    <a href="selectPacient?id=<%=paciente.getId() %>" class="btn paciente">Editar</a> 
                    <a href="javascript: confirmar(<%= paciente.getId() %>)" class="btn delet">Excluir</a>
                    </td> 
            </tr>
        <% } %>
    </tbody>	
</table>
<script src="scripts/confirmador.js"></script>

``` 
<strong id="updade_paciente">2. Editar paciente </strong>

Em cada botão de edição da tabela de pacientes contem o ID do respectivo paceinte, que atreavés desse ID, é realizado uma busca no banco de dados para trazer todas as informações desse paciente que será carregada para uma class que posteriormente será repassada para a view de editção de paciente com todas as informações sobre ele encontradas no banco d de dados.

<strong id="read_paciente_id">2.1 Busca paciente por ID:</strong>

A class `` Controller `` recebe a url ``/selectPacient `` passando como paramentro o ID do paciente. Posteriormente é chamado a função `` selectPacient `` que realiza uma uma consulta SQL com busca nesse ID chamando a seguinte função da class `` DAO ``:

``` java
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

```
<strong id="setAtribute_edit_paciente">2.2 Setando atributos e view de edição:</strong>

Assim, posteriormente a isso setamos os atributos do request com os valores desse paciente e "falamos" para a pagina `` Paciente `` que a view que deverá ser mostrada é a de edição de paciente: 

``` java
request.setAttribute("id", pct.getId());
request.setAttribute("cpf_crm", pct.getCpf());
request.setAttribute("nome", pct.getNome());
request.setAttribute("phone", pct.getPhone());
request.setAttribute("email", pct.getEmail());

request.setAttribute("view", "views/editPacinete.jsp");

RequestDispatcher rd = request.getRequestDispatcher("paciente.jsp");
rd.forward(request, response);
```
<strong id="criando_view_edit_paciente">2.3 Criando view de edição de paciente</strong>

Com as informações vinda do request modemos criar um novo forms com esses valores correspondente ao paciente selecionado para edição:

``` java
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>

<% 	@ SuppressWarnings("unchecked")
	HashMap<String, String>  dict = (HashMap<String, String>) request.getAttribute("result"); %>

<h1>Editar o paciente de ID <%= request.getAttribute("id") %></h1>

<a href="paciente" class="btn paciente">Voltar</a>

<form class="form newPaciente" id="frmNewPaciente" name="frmnovoMedicoOrPaciente"  action="updatePaciente">
	<input type="hidden" name="id" readonly value="<% out.print(request.getAttribute("id")); %>">
	<input type="text" name="nome" placeholder="Nome" value="<% out.print(request.getAttribute("nome")); %>">
	<input type="text" name="cpf_crm" placeholder="CPF" value="<% out.print(request.getAttribute("cpf_crm")); %>">
	<input type="text" name="phone" placeholder="Telefone" value="<% out.print(request.getAttribute("phone")); %>">
	<input type="text" name="email" placeholder="Email" value="<% out.print(request.getAttribute("email")); %>">

    <input type="button" value="Editar" class="btn paciente"  onclick="validarCampo()">
	<span  id="errorCampo"> </span>
</form>
```

<strong id="update_paciente">2.4 Realizando Update do paciente</strong>

Após todos os campos estarem validados, <a href="#validar_campo">segue o link explicando como funciona essa parte</a>, ao clicar no botão de enviar o `` Controller `` recebe a url `` "/updatePaciente" ``, que por sua vez chama a função `` updadePaciente `` que pega os parametros passados pelo forms e os set no objeto `` paciente ``:

```java
pct.setId(request.getParameter("id"));
pct.setCpf(request.getParameter("cpf_crm"));
pct.setNome(request.getParameter("nome"));
pct.setPhone(request.getParameter("phone"));
pct.setEmail(request.getParameter("email"));

dao.updatePaciente(pct);
```
Após ter setado as informações dentro da classe então é chamado o método `` updatePaciente`` dentro da classe `` DAO `` que irá execultar um SQL com os dados que serão modificados e qual é o ID do paciente que será modificado:
```java
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
```

</details>


<details>
    <summary>Medico</summary>


</details>


<details>
    <summary>Consulta</summary>


</details>