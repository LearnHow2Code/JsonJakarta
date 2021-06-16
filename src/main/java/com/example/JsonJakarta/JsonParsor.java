package com.example.JsonJakarta;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.io.IOException;

@WebServlet(name = "JsonParsor", value = "/JsonParsor")
public class JsonParsor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.print("Hellooo Hellooo Hellooo Hellooo Hellooo Hellooo Hellooo Hellooo Hellooo Hellooo ");
        PrintWriter out = response.getWriter();
        try {
            // here we use JSON Lib to convert string to object
            String data = request.getParameter("d");
            System.out.print("Hellooo");
            System.out.print(data);
            System.out.print("----------------------------------------------");

            JSONObject jSONObject = JSONObject.fromObject(data);
            System.out.println(jSONObject.getString("Name"));
            System.out.println(jSONObject.getString("Address"));
            JSONArray phone = jSONObject.getJSONArray("Phone");
            System.out.println(phone.getJSONObject(0).getString("phone1"));
            System.out.println(phone.getJSONObject(1).getString("phone2"));

            JSONArray onlyarray = jSONObject.getJSONArray("onlyarray");
            System.out.println(onlyarray.get(0));
            System.out.println(onlyarray.get(1));
            System.out.println(onlyarray.get(2));
            System.out.println(onlyarray.get(3));
            System.out.println(onlyarray.get(4));


        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
