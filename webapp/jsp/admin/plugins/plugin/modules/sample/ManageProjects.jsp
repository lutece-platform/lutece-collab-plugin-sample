<jsp:useBean id="managesampleProject" scope="session" class="fr.paris.lutece.plugins.plugin.modules.sample.web.ProjectJspBean" />
<% String strContent = managesampleProject.processController ( request , response ); %>

<%@ page errorPage="../../../../ErrorPage.jsp" %>
<jsp:include page="../../../../AdminHeader.jsp" />

<%= strContent %>

<%@ include file="../../../../AdminFooter.jsp" %>
