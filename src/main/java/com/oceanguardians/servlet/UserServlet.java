package com.oceanguardians.servlet;

import com.oceanguardians.api.ViaCepService;
import com.oceanguardians.api.OpenWeatherService;
import com.oceanguardians.bo.UserBO;
import com.oceanguardians.exceptions.AppException;
import com.oceanguardians.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserBO userBO;
    private ViaCepService viaCepService;
    private OpenWeatherService openWeatherService;

    @Override
    public void init() throws ServletException {
        super.init();
        userBO = new UserBO();
        viaCepService = new ViaCepService();
        openWeatherService = new OpenWeatherService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            if ("cep".equals(action)) {
                String cep = request.getParameter("cep");
                JsonObject address = viaCepService.getAddressByCep(cep);
                request.setAttribute("address", address);
                request.getRequestDispatcher("/address.jsp").forward(request, response);
            } else if ("weather".equals(action)) {
                String city = request.getParameter("city");
                JsonObject weather = openWeatherService.getWeatherByCity(city);
                request.setAttribute("weather", weather);
                request.getRequestDispatcher("/weather.jsp").forward(request, response);
            } else {
                List<User> users = userBO.getAllUsers();
                request.setAttribute("users", users);
                request.getRequestDispatcher("/users.jsp").forward(request, response);
            }
        } catch (AppException e) {
            throw new ServletException("Error processing application logic", e);
        } catch (Exception e) {
            throw new ServletException("Error processing request", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = new User(username, email, password);
            try {
                userBO.createUser(user);
                response.sendRedirect("users");
            } catch (AppException e) {
                throw new ServletException("Error creating user", e);
            }
        }
    }
}
