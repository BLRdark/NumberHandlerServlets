package com.web;

import com.web.handler.TextFormatter;
import exception.MyException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomePage extends HttpServlet {
    final static Logger logger = Logger.getLogger(WelcomePage.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/welcome.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string = req.getParameter("number").trim();

        try{
            new TextFormatter().handle(string);
        }catch (MyException ex){
            logger.error("Error: " + ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getServletContext().getRequestDispatcher("/jsp/welcome.jsp").forward(req, resp);
    }
}
