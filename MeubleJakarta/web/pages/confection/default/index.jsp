<%-- 
    Document   : index
    Created on : 13 déc. 2023, 15:18:46
    Author     : ravmi
--%>
<%@page import="confection.Categorie"%>
<%@ page import="java.util.*" %>
<% Object[] b = (Object []) request.getAttribute("categorie"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@include file="../../../inc/header.jsp"%>
  <%@include file="../../../inc/menu.jsp"%>
  <%@include file="../../../inc/navbar.jsp"%>
   <div class="content-wrapper">
       
        <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Formulaire Insertion/</span> Catégorie</h4>
              <div class="row">
                <!-- Basic Layout -->
                <div class="col-xxl">
                  <div class="card mb-4">
                    <div class="card-header d-flex align-items-center justify-content-between">
                      <h5 class="mb-0">Table Catégorie</h5>
                      <small class="text-muted float-end">Insert</small>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/InsertServlet" method="get" >
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Categorie</label>
                          <div class="col-sm-10">
                            <input type="hidden" value="10" class="form-control" id="exampleInputPassword1" name="a">
                            <input name="categorie" type="text" class="form-control" id="basic-default-name" />
                          </div>
                        </div>
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
              
              
               <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Formulaire Insertion/</span> Modèle</h4>
              <div class="row">
                <!-- Basic Layout -->
                <div class="col-xxl">
                  <div class="card mb-4">
                    <div class="card-header d-flex align-items-center justify-content-between">
                      <h5 class="mb-0">Table Modèle</h5>
                      <small class="text-muted float-end">Insert</small>
                    </div>
                    <div class="card-body">
                        <form  action="${pageContext.request.contextPath}/InsertServlet" method="get"  >
                              <input type="hidden" value="12" class="form-control" id="exampleInputPassword1" name="a">
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Categorie</label>
                          <div class="col-sm-10">
                                <select type="text" class="form-control" id="basic-default-name"  name="categorie" >
                                <% for (int i = 0; i < b.length; i++) { %>
                                 <%   Categorie tabStyle = (Categorie)b[i]; %>
                                        <option value="<% out.print(tabStyle.getIdCategorie()); %>"><% out.print(tabStyle.getCategorie()); %></option>
                                <% } %>
                                </select>
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Colonne 1</label>
                          <div class="col-sm-10">
                            <input type="text" name="col1" class="form-control" id="basic-default-name" />
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Colonne 2</label>
                          <div class="col-sm-10">
                            <input type="text" name="col2" class="form-control" id="basic-default-name" />
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Colonne 3</label>
                          <div class="col-sm-10">
                            <input type="text" name="col3" class="form-control" id="basic-default-name" />
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Colonne 4</label>
                          <div class="col-sm-10">
                            <input type="text" name="col4"  class="form-control" id="basic-default-name"  />
                          </div>
                        </div>
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