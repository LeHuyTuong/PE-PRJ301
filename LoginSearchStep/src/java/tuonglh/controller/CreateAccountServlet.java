/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tuonglh.controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import tuonglh.registration.RegistrationCreateErr;
import tuonglh.registration.RegistrationDAO;
import tuonglh.registration.RegistrationDTO;

/**
 *
 * @author USER
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {
    private final String Signin_PAGE = "createAccount.jsp";
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
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        RegistrationCreateErr errors = new RegistrationCreateErr();
        boolean foundErr = false;
        String url = Signin_PAGE;
        try {
            if(username.trim().length() < 6 || username.trim().length() > 20){
                foundErr = true;
                errors.setUsernameLengthErr("6-20 character");
            }
            if(password.trim().length() < 8 || password.trim().length() > 20){
                foundErr = true;
                errors.setPasswordLengthErr("8-20 character");
            }
            else if (!confirm.trim().equals(password.trim())){
                foundErr = true;
                errors.setConfirmNotMatch("Confirm not match");
            }
            if(fullname.trim().length() < 8 || fullname.trim().length() > 40){
                foundErr = true;
                errors.setFullnameLengthErr("8-40 character");
            }
            
            if (foundErr == true) {
                request.setAttribute("CREATE_ERROR", errors);
            } else {
                RegistrationDAO dao = new RegistrationDAO();
                RegistrationDTO accounts = new RegistrationDTO(username, password, fullname, false);
                boolean result = dao.createAccount(accounts);
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("SQL" + msg);
            if(msg.contains("duplicate")){
                errors.setUsernameIsExist(username + "duplicate");
                request.setAttribute("CREATE_ERROR", errors);
            }
        } catch (ClassNotFoundException ex) {
            log("Class not found " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
