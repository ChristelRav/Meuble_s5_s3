/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import confection.Materiel;
import confection.Meuble;
import confection.SousCategorie;
import confection.Style;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

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
                else if(a==4)
                {
                    Meuble m= new Meuble();
                     int id = Integer.parseInt(request.getParameter("categorie"));
                    double min=Double.parseDouble(request.getParameter("min"));
                    double max=Double.parseDouble(request.getParameter("max"));
                    List<Meuble> list=m.list_MeubleAll(null,id);
                    List<Meuble> lmeuble=m.list_Meuble(list,max,min);
                    request.setAttribute("listMeuble", lmeuble);
                    
                    SousCategorie ss = new SousCategorie(); ss.setIdCategorie(id);
                     Object [] sc =  ss.getOne();
                    Object [] style =  Style.selectAll();
                    
                    request.setAttribute("objStyle", style);
                request.setAttribute("categorie", id);
                request.setAttribute("souscategorie", sc);
                    RequestDispatcher dispat = request.getRequestDispatcher("/pages/confection/categorie/categorie.jsp");
                    dispat.forward(request,response);
                } else if(a == 6){
                     Meuble m= new Meuble();
                       double min=Double.parseDouble(request.getParameter("min"));
                    double max=Double.parseDouble(request.getParameter("max"));
                    List<Meuble> list=new Meuble(). listMeuble_Prix(null);
                    List<Meuble> lmeuble=m.list_Meuble(list,max,min);
                    request.setAttribute("listMeuble", lmeuble);
                 
                    RequestDispatcher dispat = request.getRequestDispatcher("/pages/confection/default/meuble.jsp");
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
