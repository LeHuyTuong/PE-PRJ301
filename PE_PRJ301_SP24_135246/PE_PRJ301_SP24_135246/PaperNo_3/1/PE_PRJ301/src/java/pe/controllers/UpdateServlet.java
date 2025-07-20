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
import java.sql.SQLException;
import pe.model.tblCurrencyCreateErr;
import pe.model.tblCurrencyDAO;

/**
 *
 * @author USER
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    private final String EDIT_PAGE = "editCurrencyRate.jsp";

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
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String rateStr = request.getParameter("rate");
        System.out.println(rateStr);
        System.out.println(description);
        System.out.println(code);
        System.out.println(name);
        boolean canRedirect = false;
        tblCurrencyCreateErr errors = new tblCurrencyCreateErr();

        String searchValue = request.getParameter("lastSearchValue");
        String url = EDIT_PAGE;
        try {
            double rate = Double.parseDouble(rateStr);
            if(rate == 0){
                errors.setEmptyRate("Rate is empty. Please enter rate");
                request.setAttribute("CREATE_ERR", errors);
            }
            tblCurrencyDAO dao = new tblCurrencyDAO();
            boolean result = dao.updateItem(name, code, description, rate);
             System.out.println(result);
            if (result == true) {
                canRedirect = true;
                url = "MainController"
                        + "?action=Search"
                        + "&code=" + code
                        + "&name=" + name;
                request.setAttribute("URL", url);
            }
        }catch (SQLException ex) {
            log("SQL: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("Class Not Found " + ex.getMessage());
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
