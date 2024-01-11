/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;


import confection.Materiel;
import confection.Style;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import confection.*;
import jakarta.servlet.RequestDispatcher;
import outil.DbConnect;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ravmi
 */
public class DefaultServlet extends HttpServlet {

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
               Object [] style =  Style.selectAll();
               Object [] sc =  SousCategorie.selectAll();
                Object [] c =  Categorie.selectAll();
               List<Materiel> lm = new Materiel().listAll(null);
               List<Materiel> lm1 = new ArrayList<>();
                //dispatch
                   if(a  == 1 ){ 
                       request.setAttribute("categorie", c); 
                       RequestDispatcher dispat = request.getRequestDispatcher("/pages/confection/default/index.jsp");
                       dispat.forward(request, response);
                   }else if( a == 2){
                        request.setAttribute("listMateriel", lm1); 
                        request.setAttribute("objStyle", style);
                        RequestDispatcher dispat = request.getRequestDispatcher("/pages/confection/default/style.jsp");
                        dispat.forward(request,response);
                   }else if(a == 3){
                        request.setAttribute("objStyle", style);
                        request.setAttribute("listSousC", sc);
                        request.setAttribute("listMateriel", lm);
                        RequestDispatcher dispat = request.getRequestDispatcher("/pages/confection/default/materiel.jsp");
                        dispat.forward(request,response);
                   }else if(a  == 4){
                        List<Meuble> lmeuble=new Meuble(). listMeuble_Prix(null);
                        request.setAttribute("listMeuble", lmeuble);
                       RequestDispatcher dispat = request.getRequestDispatcher("/pages/confection/default/meuble.jsp");
                        dispat.forward(request,response);
                   }
                   else if(a==10)
                   {
                        request.setAttribute("listMateriel", lm1); 
                        request.setAttribute("objStyle", style);
                        RequestDispatcher dispat = request.getRequestDispatcher("/pages/confection/categorie/categorie.jsp");
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
