package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

   
        if (!password.equals(confirmPassword)) {
            out.println("Hata: Şifreler eşleşmiyor!");
            return; 
        }
        
        out.println("Ad: " + firstName);
        out.println("Soyad: " + lastName);
        out.println("Yaşadığım Şehir: " + city);
        out.println("Eposta Adresi: " + email);
        out.println("Şifre: " + password);
        out.println("Şifre Tekrar: " + confirmPassword);

        out.close();
    }
}