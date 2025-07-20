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
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import pe.account.AccountCreateErr;
import pe.appointment.AppointmentCreaErr;
import pe.appointment.AppointmentDAO;
import pe.appointment.AppointmentDTO;

/**
 *
 * @author USER
 */
@WebServlet(name = "CreateServlet", urlPatterns = {"/CreateServlet"})
public class CreateServlet extends HttpServlet {

    private final String APP_PAGE = "login.jsp";
    private final String ERROR_PAGE = "create.jsp";

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

        String account = request.getParameter("btAccount");
        String phone = request.getParameter("btPhone");
        String name = request.getParameter("btName");
        String time = request.getParameter("btTime");
        String place = request.getParameter("btPlace");
        String btExpense = request.getParameter("btExpense");
        String note = request.getParameter("btNote");
        AppointmentCreaErr errors = new AppointmentCreaErr();
        boolean foundErr = false;

        String url = ERROR_PAGE;
        try {
            double expense = Double.parseDouble(btExpense);
            if (phone.isEmpty()) {
                foundErr = true;
                errors.setPhoneFormat("Phone must 10 number");
            }
            if (name.isEmpty()) {
                foundErr = true;
                errors.setNameFormat("Not Empty name ");
            }
            if (time.isEmpty()) {
                foundErr = true;
                errors.setEmptyInfo("Not Empty info");
            }
            if (place.isEmpty()) {
                foundErr = true;
                errors.setEmptyInfo("Not Empty info");
            }
            if (foundErr) {
                request.setAttribute("CREATE_ERROR_APP", errors);
                url = ERROR_PAGE;
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else {

                AppointmentDAO dao = new AppointmentDAO();
                AppointmentDTO dto = new AppointmentDTO();
                boolean result = dao.addAppointment(dto);
                if (result == true) {
                    url = APP_PAGE;
                    response.sendRedirect(url);
                }
            }
        } catch (NumberFormatException ex) {
            String msg = ex.getMessage();
            log("Number Format " + msg);
            errors.setWrongExpenseFormat("expense is float number");
            request.setAttribute("CREATE_ERROR_APP", errors);
            url = ERROR_PAGE;
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            return;
        } catch (IllegalArgumentException ex) {
            String msg = ex.getMessage();
            log("Time stamp format" + msg);
            errors.setWrongTimeFormat("Time must be yyyy-mm-dd ");
            url = ERROR_PAGE;
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            return;
        } catch (SQLException ex) {
            log("SQL" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("Class Not Found " + ex.getMessage());
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
