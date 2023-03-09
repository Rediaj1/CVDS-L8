package edu.eci.cvds.servlet;

import java.io.*;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.model.Todo;

import java.util.*;

@WebServlet(urlPatterns = "/sonHttpServlet")

public class sonHttpServlet extends HttpServlet {

    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        String trouble = "";
        try {
            Optional<String> optID = Optional.ofNullable(req.getParameter("id"));
            int ID = Integer.valueOf(optID.get());
            Todo todo = Service.getTodo(ID);
            List<Todo> thingsToDo = new ArrayList<Todo>();
            resp.setStatus(HttpServletResponse.SC_OK);
            thingsToDo.add(todo);
            responseWriter.write(Service.todosToHTMLTable(thingsToDo));
        } catch (Exception error) {
            if (error instanceof FileNotFoundException) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                trouble = "No encontrado: ERROR 404";
            } else if (error instanceof NumberFormatException) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                trouble = "Requerimiento inválido: ERROR 400";
            } else if (error instanceof MalformedURLException) {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                trouble = "Error interno en el servidor; ERROR 500";
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                trouble = "Requerimiento inválido; ERROR 400";
            }
        } finally {
            responseWriter.write(trouble);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> optID = Optional.ofNullable(req.getParameter("id"));
        int id = optID.isPresent() ? Integer.parseInt(optID.get()) : -1;
        Writer responseWriter = resp.getWriter();
        responseWriter.write(id+"was added");

    }
}

