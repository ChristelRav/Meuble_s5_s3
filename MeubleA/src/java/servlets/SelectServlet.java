/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import confection.Materiel;
import confection.Style;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ravmi
 */
public class SelectServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                 int a ;
               if(request.getParameter("a")==null){
                    a = (int)request.getAttribute("a");
               }else{
                    a = Integer.parseInt(request.getParameter("a"));
               }
                if(a == 0){
                    Object [] style =  Style.selectAll();
                    request.setAttribute("objStyle", style);
                    int id = Integer.parseInt(request.getParameter("style"));
                    Style sty = new Style(); sty.setIdStyle(id);
                    List<Materiel> lm = new Materiel().listBy_Style(null,sty);
                    request.setAttribute("listMateriel", lm);
                    RequestDispatcher dispat = request.getRequestDispatcher("/pages/confection/default/style.jsp");
                    dispat.forward(request,response);
                }else if(a  ==3 ){
                    out.println("HAHA");
                    int id = Integer.parseInt(request.getParameter("materiel"));
                    Materiel mm = new Materiel();
                    mm.setIdMateriel(id);
                    List<Materiel> lm = mm.list_MeubleC(null);
                    request.setAttribute("listMateriel", lm);
                     RequestDispatcher dispat = request.getRequestDispatcher("/pages/confection/default/detail.jsp");
                    dispat.forward(request,response);
                }
            }catch(Exception e){
                 out.println(e.getMessage());
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
