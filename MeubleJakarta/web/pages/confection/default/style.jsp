<%-- 
    Document   : style
    Created on : 13 déc. 2023, 15:27:36
    Author     : ravmi
--%>
<%@page import="confection.Materiel"%>
<%@page import="confection.Style"%>
<%@ page import="java.util.*" %>
<% Object[] a = (Object []) request.getAttribute("objStyle"); %>
<% List<Materiel> b = (List<Materiel>) request.getAttribute("listMateriel"); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@include file="../../../inc/header.jsp"%>
  <%@include file="../../../inc/menu.jsp"%>
  <%@include file="../../../inc/navbar.jsp"%>
   <div class="content-wrapper">
       
        <div class="container-xxl flex-grow-1 container-p-y">
               <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Formulaire Séléction/</span> Matériel</h4>
            <div class="row">
                    <div class="col-md-5">
                      <div class="card mb-4">
                        <h5 class="card-header">Style</h5>
                        <div class="card-body">
                          <form action="${pageContext.request.contextPath}/SelectServlet"  method="get">
                          <input type="hidden" value="0" class="form-control" id="exampleInputPassword1" name="a">
                          <div>
                              <select type="text" class="form-control" id="basic-default-name"  name="style" >
                                     <% for (int i = 0; i < a.length; i++) { %>
                                        <%   Style tabStyle = (Style)a[i]; %>
                                           <option value="<% out.print(tabStyle.getIdStyle()); %>"><% out.print(tabStyle.getStyle()); %></option>
                                     <% } %>
                                </select>
                          </div>
                          <div class="demo-inline-spacing">
                                <button type="submit" class="btn btn-info">Sélectionné</button>
                          </div>
                          </form>
                        </div>
                      </div>
                    </div>

                   <div class="col-md-7">
                        <div class="card mb-4">
                            <h5 class="card-header">Liste Séléction</h5>
                            <div class="table-responsive text-nowrap">
                              <div style="max-height: 200px; overflow-y: auto;">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Matièrel</th>
                                                <th>quantite En Plus</th>
                                            </tr>
                                        </thead>
                                        <tbody class="table-border-bottom-0">
                                            <% if (!b.isEmpty()) { %>
                                                <% for (int i = 0; i < b.size(); i++) { %>
                                                    <tr>
                                                        <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong><% out.print(b.get(i).getMateriel()); %></strong></td>
                                                        <td><% out.print(b.get(i).getUnite()); %></td>
                                                    </tr>
                                                <% } %>
                                            <% } else { %>
                                                <tr>
                                                    <td>Aucune Sélection</td>
                                                <tr>
                                            <% } %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                  </div>
                  </div>
                
            
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Formulaire Insertion/</span> Style</h4>
              <div class="row">
                <!-- Basic Layout -->
                <div class="col-xxl">
                  <div class="card mb-4">
                    <div class="card-header d-flex align-items-center justify-content-between">
                      <h5 class="mb-0">Table Style</h5>
                      <small class="text-muted float-end">Insert</small>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/InsertServlet"  method="get">
                        <input type="hidden" value="0" class="form-control" id="exampleInputPassword1" name="a">
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Style</label>
                          <div class="col-sm-10">
                            <input name="style" type="text" class="form-control" id="basic-default-name" />
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Temp Fabrication</label>
                          <div class="col-sm-10">
                            <input name="temps" type="time" class="form-control" id="basic-default-name" />
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
