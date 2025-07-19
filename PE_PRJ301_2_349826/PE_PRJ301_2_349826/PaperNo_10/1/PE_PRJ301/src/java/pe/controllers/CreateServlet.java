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
import pe.model.HouseBLI;
import pe.model.HouseBLO;
import pe.model.TblHouse;
import pe.model.TblHouseCreateErr;

/**
 *
 * @author USER
 */
@WebServlet(name = "CreateServlet", urlPatterns = {"/CreateServlet"})
public class CreateServlet extends HttpServlet {

    private final String CREATE_PAGE = "createHouse.jsp";
    private final String ERROR_PAGE = "login.jsp";

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
        String name = request.getParameter("txtName");
        String description = request.getParameter("txtDescription");
        String priceStr = request.getParameter("txtPrice");
        String sizeStr = request.getParameter("txtSize");
        TblHouseCreateErr errors = new TblHouseCreateErr();
        String url = CREATE_PAGE;
        boolean foundErr = false;
        try {
            if (id.length() != 5) {
                errors.setNotFormat("Please try with format H-XXX X is a number");
                foundErr = true;
            }

            double price = Double.parseDouble(priceStr);
            if ((price < 0 || price > 500)) {
                errors.setDataType("Lmao");
                foundErr = true;
            }
            double size = Double.parseDouble(sizeStr);
            if ((size < 0 || size > 500)) {
                errors.setDataType("Lmao");
                foundErr = true;
            }
            if (foundErr) {
                request.setAttribute("ERROR", errors);
            } else {
                HouseBLI blo = new HouseBLO();
                TblHouse house = new TblHouse(id, name, description, price, size, false);
                boolean result = blo.createHouse(house);
                if (result) {
                    url = ERROR_PAGE;
                    request.setAttribute("SUCCESS", "SuccessFull");
                }
            }
        } catch (NumberFormatException ex) {
            String msg = ex.getMessage();
            log("Number Format Exception" + msg);
            errors.setDataType("data format not true, please enter ex 2.5 or 2.0");
            request.setAttribute("ERROR", errors);
        } catch (IllegalArgumentException ex) {
            String msg = ex.getMessage();
            log("Illegal " + msg);
            if (msg.contains("duplicate")) {
                errors.setDuplicateID(id + "duplicate");
                request.setAttribute("ERROR", errors);
            }
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
