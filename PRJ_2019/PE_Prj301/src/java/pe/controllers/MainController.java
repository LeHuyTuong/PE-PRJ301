/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Computing Fundamental - HCM Campus
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String WELCOME = "login.jsp";
    private static final String LOGIN_ACCOUNT_CONTROLLER = "LoginAccountServlet";
    private static final String SEARCH_ACCOUNT_CONTROLLER = "SearchAccountServlet";
    private static final String LOGOUT_ACCOUNT_CONTROLLER = "LogoutAccountServlet";
    private static final String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountServlet";
    private static final String CHECK_ACCOUNT_CONTROLLER = "CheckAccountServlet";

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
        String url = WELCOME;
        try {
            String action = request.getParameter("action");
            //-----            your code here   --------------------------------
            if (action == null) {
            } else {
                switch (action) {
                    case "Login":
                        url = LOGIN_ACCOUNT_CONTROLLER;
                        break;
                    case "Search":
                        url = SEARCH_ACCOUNT_CONTROLLER;
                        break;
                    case "Logout":
                        url = LOGOUT_ACCOUNT_CONTROLLER;
                        break;
                    case "Update":
                        url = UPDATE_ACCOUNT_CONTROLLER;
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            //-----            your code here   --------------------------------
        } catch (Exception e) {
            log("error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
