package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import static jakarta.servlet.RequestDispatcher.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Javi
 */
public class ErrorHandler extends HttpServlet {

    @Override
    protected void doGet(
      HttpServletRequest req, 
      HttpServletResponse resp) throws IOException {
        Log.log.error("Se ha producido un error "); 
        resp.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<html><head><title>Descripcion del Error</title></head><body>");
            writer.write("<h2>Descripcion del error:</h2>");
            writer.write("<ul>");
            Arrays.asList(
              ERROR_STATUS_CODE, 
              ERROR_EXCEPTION_TYPE, 
              ERROR_MESSAGE)
              .forEach(e ->
                writer.write("<li>" + e + ":" + req.getAttribute(e) + " </li>")
            );
            writer.write("</ul>");
            writer.write("</html></body>");
        }
    }
}