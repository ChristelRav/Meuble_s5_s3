<%-- 
    Document   : confection
    Created on : 19 déc. 2023, 16:21:40
    Author     : ravmi
--%>
<%@page import="java.util.List"%>
<%@page import="confection.Materiel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% int id = (int)request.getAttribute("id"); %>
<% int style = (int)request.getAttribute("style"); %>
<% List<Materiel> b = (List<Materiel>) request.getAttribute("listMateriel"); %>
  <%@include file="../../../inc/header.jsp"%>
  <%@include file="../../../inc/menu.jsp"%>
  <%@include file="../../../inc/navbar.jsp"%>
   <div class="content-wrapper">
       
        <div class="container-xxl flex-grow-1 container-p-y">
               <div class="row">
                  <div class="col-md-6">
                      <h5><a href="index.html" >Insertion Meuble</a></h5>
                  </div>
              </div>
            
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Formulaire Confection/</span> Matériel</h4>
              <div class="row">
                <!-- Basic Layout -->
                <div class="col-xxl">
                  <div class="card mb-4">
                    <div class="card-header d-flex align-items-center justify-content-between">
                      <h5 class="mb-0">Table Confection</h5>
                      <small class="text-muted float-end">Insert</small>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/InsertServlet"  method="get">
                        <input type="hidden" value="7" class="form-control" id="exampleInputPassword1" name="a">
                         <input type="hidden" value="<% out.print(id); %>" class="form-control" id="exampleInputPassword1" name="id">
                        <input type="hidden" value="<% out.print(style); %>" class="form-control" id="exampleInputPassword1" name="style">
                        <input type="hidden" value="<% out.print(id); %>" class="form-control" id="exampleInputPassword1" name="meuble">
                        <% for (int i = 0; i < b.size(); i++) { %>
                                <div class="row mb-3">
                                  <label class="col-sm-2 col-form-label" for="basic-default-name"><% out.print(b.get(i).getMateriel()); %></label>
                                  <div class="col-sm-10">
                                    <input type="text" value="0" class="form-control" id="basic-default-name" name="<% out.print(b.get(i).getMateriel()); %>"/>
                                  </div>
                                </div>
                         <% } %>
                        <div class="row justify-content-end">
                          <div class="col-sm-10">
                            <button type="submit" class="btn btn-primary">Insérer</button>
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
            </div>   
              
     
        </div>  
   </div>
              
  <%@include file="../../../inc/footer.jsp"%>