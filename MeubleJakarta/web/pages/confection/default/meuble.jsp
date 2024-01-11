<%-- 
    Document   : meuble
    Created on : 11 janv. 2024, 09:01:00
    Author     : ravmi
--%>
<%@page import="confection.Meuble"%>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%  List<Meuble> meuble=(List<Meuble>) request.getAttribute("listMeuble"); %>
  <%@include file="../../../inc/header.jsp"%>
  <%@include file="../../../inc/menu.jsp"%>
  <%@include file="../../../inc/navbar.jsp"%>
   <div class="content-wrapper">
       
        <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Fonctionnalités /</span> Meuble</h4>
              <div class="row">
                <!-- Basic Layout -->
                <div class="col-xxl">
                  <div class="card mb-4">
                    <div class="card-header d-flex align-items-center justify-content-between">
                      <h5 class="mb-0">Fourchette de Prix</h5>
                      <small class="text-muted float-end">Insert</small>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/SelectServlet" method="get" >
                            
                            <input type="hidden" value="6" class="form-control" id="exampleInputPassword1" name="a">
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Prix max</label>
                          <div class="col-sm-10">
                            <input name="max" type="number" min="0" class="form-control" id="basic-default-name" />
                          </div>
                        </div>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Prix min</label>
                          <div class="col-sm-10">
                            <input name="min" type="number"  min="0" class="form-control" id="basic-default-name" />
                          </div>
                        </div>
                        <div class="row justify-content-end">
                          <div class="col-sm-10">
                            <button type="submit" class="btn btn-primary">Sélectioner</button>
                          </div>
                        </div>
                      </form>
                    </div>
                      
                  </div>
                </div>
            </div>
              
              
              <div class="row">

              <!-- Bordered Table -->
              <div class="card">
                <h5 class="card-header">Bordered Table</h5>
                <div class="card-body">
                  <div class="table-responsive text-nowrap">
                    <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th>Meuble</th>
                          <th>Prix</th>
                        </tr>
                      </thead>
                      <tbody>
                           <% for(int i=0;i<meuble.size();i++) {%>
                        <tr>
                          <td>
                            <i class="fab fa-angular fa-lg text-danger me-3"></i> <strong><% out.print(meuble.get(i).getMeuble()); %></strong>
                          </td>
                          <td><% out.print(meuble.get(i).getPrix()); %></td>
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