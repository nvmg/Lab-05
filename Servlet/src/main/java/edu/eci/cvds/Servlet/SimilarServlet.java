package edu.eci.cvds.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;
import edu.eci.cvds.Servlet.model.Todo;

@WebServlet(
        urlPatterns = "/similarServlet"
)

public class SimilarServlet extends HttpServlet{

    private List<Todo> listTodo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String id = req.getParameter("id");
            Todo todo = Service.getTodo(Integer.parseInt(id));
            Writer responseWriter = resp.getWriter();
            resp.setStatus(HttpServletResponse.SC_OK);
            listTodo = new ArrayList<Todo>();
            listTodo.add(todo);
            responseWriter = resp.getWriter();
            responseWriter.write(Service.todosToHTMLTable(listTodo));
        } catch(NumberFormatException e){
            sendHtmlError(resp, "400 : Bad Request.", HttpServletResponse.SC_BAD_REQUEST);
        } catch (MalformedURLException e){
            sendHtmlError(resp, "500 : Internal Server Error.", HttpServletResponse.SC_BAD_REQUEST);
        } catch(IOException e) {
            sendHtmlError(resp, "404 : Not Found.", HttpServletResponse.SC_NOT_FOUND);
        } catch(Exception e){
            sendHtmlError(resp, "400 : Bad Request", HttpServletResponse.SC_BAD_REQUEST);
        }


    }
    /**
     * Enviar un mensaje de respuesta en HTML
     * @param resp Clase respuesta
     * @param error El mensaje del error a mostrar
     * @param noError El número del error a mostrar
     */
    private void sendHtmlError(HttpServletResponse resp, String error, int noError){
        try {
            resp.setStatus(noError);
            Writer responseWriter = resp.getWriter();
            responseWriter.write(new StringBuilder("<h1>").append(error).append("</h1>").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            Todo todo = Service.getTodo(Integer.parseInt(id));
            Writer responseWriter = resp.getWriter();
            resp.setStatus(HttpServletResponse.SC_OK);
            listTodo = new ArrayList<Todo>();
            listTodo.add(todo);
            responseWriter = resp.getWriter();
            responseWriter.write(Service.todosToHTMLTable(listTodo));
        } catch(NumberFormatException e){
            sendHtmlError(resp, "400 : Bad Request.", HttpServletResponse.SC_BAD_REQUEST);
        } catch (MalformedURLException e){
            sendHtmlError(resp, "500 : Internal Server Error.", HttpServletResponse.SC_BAD_REQUEST);
        } catch(IOException e) {
            sendHtmlError(resp, "404 : Not Found.", HttpServletResponse.SC_NOT_FOUND);
        } catch(Exception e){
            sendHtmlError(resp, "400 : Bad Request", HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}