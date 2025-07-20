/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package pe.controllers;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import pe.model.TblUsers;
import pe.model.TblUsersBLI;
import pe.model.TblUsersBLO;
import pe.model.TblUsersCreateErr;
import pe.model.UserDao;
import pe.model.UserDto;

/**
 *
 * @author USER
 */
@WebServlet(name="LoginServlet", urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final String LOGIN_PAGE = "login.jsp";
    private static final String WELCOME_PAGE = "welcome.jsp";
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String userID = request.getParameter("txtUserID");
        String password = request.getParameter("txtPassword");
        String url = LOGIN_PAGE;
        TblUsersCreateErr errors = new TblUsersCreateErr();
        try  {
//            TblUsersBLI blo = new TblUsersBLO();
//            TblUsers result = blo.checkLogin(userID, password);
            UserDao dao = new UserDao();
            UserDto result = dao.checkLogin(userID, password);
            if(result != null){
                url = WELCOME_PAGE;
                HttpSession session = request.getSession();
                session.setAttribute("USER_INFO", result);
            }else{
                errors.setInvalidUserOrPassword("Invalid user or password");
                request.setAttribute("CREATE_ERROR", errors);
            }
        }
        catch(SQLException ex){
            log("SQL" + ex.getMessage());
        }
        catch(ClassNotFoundException ex){
            log("Class not Found"+ ex.getMessage());
        }
        finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
