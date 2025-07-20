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
import pe.model.FashionCreateErr;
import pe.model.FashionDao;

/**
 *
 * @author USER
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    private static final String SEARCH_PAGE = "search.jsp";
    private final String UPDATE_PAGE = "Update.jsp";
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
        String id = request.getParameter("txtID");
        String name = request.getParameter("txtNamereal");
        String description = request.getParameter("txtDescription");
        String priceStr = request.getParameter("txtPrice");
        String size = request.getParameter("txtSize");
        String searchValue = request.getParameter("lastSearchValue");
        String url = UPDATE_PAGE;
        FashionCreateErr errors = new FashionCreateErr();
        boolean canRedirect = false;
        try {
            double price = Double.parseDouble(priceStr);
            FashionDao dao = new FashionDao();
            boolean result = dao.updateItem(id, name, description, price, size);
            if (result == true) {
                canRedirect =  true;
                url = "MainController"
                        + "?txtName=" + searchValue
                        + "&action=Search";
            }
        } catch (NumberFormatException ex) {
            canRedirect = false;
            log("Number format exception" + ex.getMessage());
            errors.setNumberFormat("Price is double format");
            request.setAttribute("CREATE_ERRORS", errors);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (SQLException ex) {
            log("SQL" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("Class not Found" + ex.getMessage());
        } finally {
            if (canRedirect) {
                response.sendRedirect(url);
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
