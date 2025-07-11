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
import pe.model.tblFashionCreateErr;
import pe.model.tblFashionDAO;

/**
 *
 * @author USER
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    private final String ERROR_PAGE = "error.jsp";
    private final String FASHION_PAGE = "fashionList.jsp";

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
        String url = FASHION_PAGE;
        String id = request.getParameter("txtID");
        String txtName = request.getParameter("txtName");
        String txtPrice = request.getParameter("txtPrice");
        String txtSize = request.getParameter("txtSize");
        String txtDescription = request.getParameter("txtDescription");
        String searchValue = request.getParameter("lastSearchValue");
        tblFashionCreateErr errors = new tblFashionCreateErr();
        try {
            Double price = Double.parseDouble(txtPrice);
            
            tblFashionDAO dao = new tblFashionDAO();
            boolean result = dao.updateValue(id, txtName, txtDescription, price, txtSize);
            if (result == true) {
                url = "MainController"
                        + "?txtSearchValue=" + searchValue
                        + "&action=Search";
            }

        } catch (NumberFormatException ex) {
            String msg = ex.getMessage();
            log("Number Format" + msg);
            errors.setNumberFormatWrong("Price must be a integer");
            request.setAttribute("CREATE_ERROR", errors);
            url = "MainController"
                        + "?txtSearchValue=" + searchValue
                        + "&action=Search";
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (SQLException ex) {
            log("SQL" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("Class Not Found" + ex.getMessage());
        } finally {
            response.sendRedirect(url);
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
