`<%-- 
    Document   : materiel
    Created on : 13 déc. 2023, 15:59:53
    Author     : ravmi
--%>
<%@page import="confection.Materiel"%>
<%@page import="confection.Style"%>
<%@ page import="java.util.*" %>
<% List<Materiel> a = (List<Materiel>) request.getAttribute("listMateriel"); %>
<% Object[] b = (Object []) request.getAttribute("objStyle"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@include file="../../../inc/header.jsp"%>
  <%@include file="../../../inc/menu.jsp"%>
  <%@include file="../../../inc/navbar.jsp"%>
   <div class="content-wrapper">
       
        <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Formulaire Insertion/</span> Matériel</h4>
              <div class="row">
                <!-- Basic Layout -->
                <div class="col-xxl">
                  <div class="card mb-4">
                    <div class="card-header d-flex align-items-center justify-content-between">
                      <h5 class="mb-0">Table Matériel</h5>
                      <small class="text-muted float-end">Insert</small>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/InsertServlet"  method="get">
                        <input type="hidden" value="3" class="form-control" id="exampleInputPassword1" name="a">
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Matériel</label>
                          <div class="col-sm-10">
                            <input name="materiel" type="text" class="form-control" id="basic-default-name" />
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Unité</label>
                          <div class="col-sm-10">
                            <input name="unite" type="text" class="form-control" id="basic-default-name" />
                          </div>
                        </div>
                         <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Prix Unitaire</label>
                          <div class="col-sm-10">
                            <input name="pu" type="number" min="0" class="form-control" id="basic-default-name" />
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
                        
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Formulaire Insertion/</span>Style Matériel</h4>            
            <div class="row">
                <div class="col-xxl">
                  <div class="card mb-4">
                    <div class="card-header d-flex align-items-center justify-content-between">
                      <h5 class="mb-0">Table Style Matériel</h5>
                      <small class="text-muted float-end">Insert</small>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/InsertServlet"  method="get">
                        <input type="hidden" value="9" class="form-control" id="exampleInputPassword1" name="a">
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Matériel</label>
                          <div class="col-sm-10">
                            <select type="text" name="materiel" class="form-control" id="basic-default-name" >
                                    <% for (int i = 0; i < a.size(); i++) { %>
                                        <option value="<% out.print(a.get(i).getIdMateriel()); %>"><% out.print(a.get(i).getCategorie()); %></option>
                                    <% } %>
                              </select>
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Style</label>
                          <div class="col-sm-10">
                                <select type="text" class="form-control" id="basic-default-name"  name="style" >
                                     <% for (int i = 0; i < b.length; i++) { %>
                                        <%   Style tabStyle = (Style)b[i]; %>
                                           <option value="<% out.print(tabStyle.getIdStyle()); %>"><% out.print(tabStyle.getStyle()); %></option>
                                     <% } %>
                                </select>
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Quantite En plus</label>
                          <div class="col-sm-10">
                            <input  name = "quantite" type="number" miin="0" class="form-control" id="basic-default-name" />
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
              
            <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Formulaire Séléction/</span> Matériel</h4>
             <div class="row">                 
                   <div class="col-md-12">
                        <div class="card mb-4">
                            <h5 class="card-header">Liste Séléction</h5>
                            <div class="table-responsive text-nowrap">
                              <table class="table">
                                <thead>
                                  <tr>
                                    <th>Matièrel</th>
                                    <th>Unite</th>
                                    <th>Prix(Ariary)</th>
                                  </tr>
                                </thead>
                                <tbody class="table-border-bottom-0">
                                  <% for (int i = 0; i < a.size(); i++) { %>
                                        <tr>
                                            <td><i class="fab fa-angular fa-lg text-danger me-3"></i><a href="${pageContext.request.contextPath}/SelectServlet?a=3&&materiel=<% out.print(a.get(i).getIdMateriel()); %>"><strong><% out.print(a.get(i).getMateriel()); %></strong></a></td>
                                            <td><% out.print(a.get(i).getUnite()); %></td>
                                            <td><% out.print(a.get(i).getQp()); %></td>
                                        </tr>
                                  <% } %>
                                </tbody>
                              </table>
                            </div>
                        </div>
                 </div>
            </div>
     
        </div>  
   </div>
              
  <%@include file="../../../inc/footer.jsp"%>