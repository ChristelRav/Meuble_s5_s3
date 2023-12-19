<%-- 
    Document   : materiel
    Created on : 13 déc. 2023, 15:59:53
    Author     : ravmi
--%>
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
                        <form>
                        <div class="row mb-3">
                          <label class="col-sm-2 col-form-label" for="basic-default-name">Matériel</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" id="basic-default-name" />
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
                                  </tr>
                                </thead>
                                <tbody class="table-border-bottom-0">
                                  <tr>
                                    <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>Bois</strong></td>
                                    <td>55</td>
                                  </tr>
                                   <tr>
                                    <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>Planche</strong></td>
                                    <td>55</td>
                                  </tr>
                                   <tr>
                                    <td><i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>Bois</strong></td>
                                    <td>55</td>
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