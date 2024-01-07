<%-- 
    Document   : categorie
    Created on : 13 déc. 2023, 16:39:06
    Author     : ravmi
--%>

<%@page import="confection.Style"%>
<%@page import="confection.SousCategorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Object[] a = (Object []) request.getAttribute("objStyle"); %>
<% Object[] b = (Object []) request.getAttribute("souscategorie"); %>
<% int id = (Integer) request.getAttribute("categorie"); %>
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
            
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Formulaire Insertion/</span> Matériel</h4>
              <div class="row">
                <!-- Basic Layout -->
                <div class="col-xxl">
                  <div class="card mb-4">
                    <div class="card-header d-flex align-items-center justify-content-between">
                      <h5 class="mb-0">Table Meuble</h5>
                      <small class="text-muted float-end">Insert</small>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/InsertServlet" method="get" >
                             <input type="hidden" value="5" class="form-control" id="exampleInputPassword1" name="a">
                              <input type="hidden" value="<% out.print(id); %>" class="form-control" id="exampleInputPassword1" name="categorie">
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Nom</label>
                          <div class="col-sm-10">
                            <input type="text" name="meuble" class="form-control" id="basic-default-name" />
                          </div>
                        </div>
                         <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Sous Categorie</label>
                          <div class="col-sm-10">
                              <select type="text" name="sousc" class="form-control" id="basic-default-name" >
                                    <% for (int i = 0; i < b.length; i++) { %>
                                    <%   SousCategorie tabStyle = (SousCategorie) b[i]; %>
                                        <option value="<% out.print(tabStyle.getIdSousCategorie()); %>"><% out.print(tabStyle.getSousCategorie()); %></option>
                                    <% } %>
                              </select>
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Style</label>
                          <div class="col-sm-10">
                               <div class="col-sm-10">
                              <select type="text" class="form-control" id="basic-default-name"  name="style" >
                                     <% for (int i = 0; i < a.length; i++) { %>
                                        <%   Style tabStyle = (Style)a[i]; %>
                                           <option value="<% out.print(tabStyle.getIdStyle()); %>"><% out.print(tabStyle.getStyle()); %></option>
                                     <% } %>
                              </select>
                          </div>
                        </div>
                              <p></p>
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
              
            <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Formulaire Séléction/</span> Matériel</h4>
             <div class="row">                 
                   <div class="col-md-12">
                        <div class="card mb-4">
                            <h5 class="card-header">Liste Canapé</h5>
                            <div class="table-responsive text-nowrap">
                              <table class="table">
                                <thead>
                                  <tr>
                                    <th>Meuble</th>
                                    <th>Style</th>
                                  </tr>
                                </thead>
                                <tbody class="table-border-bottom-0">
                                  <tr>
                                    <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>Chaise de Gaming Moderne</strong></td>
                                    <td>Royal</td>
                                  </tr>
                                </tbody>
                              </table>
                            </div>
                        </div>
                 </div>
            </div>
     
        </div>  
   </div>
              
  <%@include file="../../../inc/footer.jsp"%>
