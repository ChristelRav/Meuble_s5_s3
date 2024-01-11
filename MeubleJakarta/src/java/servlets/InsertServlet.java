/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import confection.Categorie;
import confection.Modele;
import confection.ConfectionMeuble;
import confection.Materiel;
import confection.Meuble;
import confection.Style;
import confection.StyleMateriel;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author ravmi
 */
public class InsertServlet extends HttpServlet {

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
                    LocalTime localTime = LocalTime.parse(request.getParameter("temps"));
                    Time time = Time.valueOf(localTime);
                    Style st  = new Style(request.getParameter("style"),time);
                    st.insert(null);
                    response.sendRedirect("DefaultServlet?a=2");
                }else if(a == 3){
                    Materiel mat = new Materiel(request.getParameter("materiel"),request.getParameter("unite"));
                    mat.insert(null);
                    response.sendRedirect("DefaultServlet?a=3");
                }
                else if(a == 5){
                    Meuble m = new Meuble(Integer.parseInt(request.getParameter("sousc")),Integer.parseInt(request.getParameter("style")),request.getParameter("meuble"));
                    m = m.insert(null);
                    int id = m.getIdMeuble();
                    Style s = new Style(); 
                    s.setIdStyle(Integer.parseInt(request.getParameter("style")));
                    List<Materiel> lm = new Materiel().listBy_Style(null,s);
                    
                    request.setAttribute("listMateriel", lm);
                    request.setAttribute("id", id);
                    request.setAttribute("style", Integer.parseInt(request.getParameter("style")));
                    
                    RequestDispatcher dispat = request.getRequestDispatcher("/pages/confection/default/confection.jsp");
                    dispat.forward(request,response);
                }else if( a == 7){
                    Style s = new Style(); 
                    s.setIdStyle(Integer.parseInt(request.getParameter("style")));
                    out.println("HUHU "+s.getIdStyle());
                    int id =Integer.parseInt(request.getParameter("id"));
                     List<Materiel> lm = new Materiel().listBy_Style(null,s);
                      for (int i = 0; i < lm.size(); i++) {
                            double qtt = Double.parseDouble(request.getParameter(lm.get(i).getMateriel()));
                            ConfectionMeuble cm = new ConfectionMeuble(id,lm.get(i).getIdMateriel(),qtt);
                            cm.insert(null);
                        }
                      response.sendRedirect("DefaultServlet?a=3");
                    
                } else if(a == 9){
                    double d = Double.parseDouble(request.getParameter("quantite"));
                    StyleMateriel stm = new StyleMateriel(Integer.parseInt(request.getParameter("style")),Integer.parseInt(request.getParameter("materiel")),d);
                    stm.insert(null);
                    response.sendRedirect("DefaultServlet?a=3");
                }
                else if(a==10)
                {
                    String c=request.getParameter("categorie");
                    Categorie cat=new Categorie(c);
                    cat.insert(null);
                    response.sendRedirect("DefaultServlet?a=1");
                }else if( a == 12){
                    int c= Integer.parseInt(request.getParameter("categorie"));
                    Modele m = new Modele(c,request.getParameter("col1"),request.getParameter("col2"),request.getParameter("col3"),request.getParameter("col4"));
                    m.insert(null);
                    response.sendRedirect("DefaultServlet?a=1");
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
