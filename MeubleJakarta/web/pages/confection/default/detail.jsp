<%-- 
    Document   : detail
    Created on : 19 déc. 2023, 15:01:49
    Author     : ravmi
--%>
<%@page import="confection.Materiel"%>
<%@ page import="java.util.*" %>
<% List<Materiel> a = (List<Materiel>) request.getAttribute("listMateriel"); %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@include file="../../../inc/header.jsp"%>
  <%@include file="../../../inc/menu.jsp"%>
  <%@include file="../../../inc/navbar.jsp"%>
   <div class="content-wrapper">
       
        <div class="container-xxl flex-grow-1 container-p-y">
              
              
            <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Meuble/</span> Confectionnable</h4>
             <div class="row">                 
                   <div class="col-md-12">
                        <div class="card mb-4">
                            <h5 class="card-header">Liste Séléction</h5>
                            <div class="table-responsive text-nowrap">
                              <table class="table">
                                <thead>
                                  <tr>
                                    <th>Meuble</th>
                                    <th>Quantite utilise</th>
                                    <th>unite</th>
                                  </tr>
                                </thead>
                                <tbody class="table-border-bottom-0">
                                  <% for (int i = 0; i < a.size(); i++) { %>
                                        <tr>
                                          <td><i class="fab fa-angular fa-lg text-danger me-3"></i><strong><% out.print(a.get(i).getMateriel()); %></strong></td>
                                          <td><% out.print(a.get(i).getQp()); %></td>
                                          <td><% out.print(a.get(i).getUnite()); %></td>
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