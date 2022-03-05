package edu.eci.cvds.Servlet.model;

public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    /**
     * Constructor para la clase Todo.
     */
    public Todo() {

    }
    /**
     * Retorma el id del usuario.
     * @return userId - Entero con el id del usuario.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Retorma el id.
     * @return id - Entero con el id.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorma el título.
     * @return userId - String con el título.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retorna el valor de completado.
     * @return completed - Booleano con el valor de completado.
     */
    public boolean getCompleted() {
        return completed;
    }

    /**
     * Actualiza el valor del titulo.
     * @param title - Nuevo titulo.
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Actualiza el valor de completado.
     * @param completed -  Nuevo valor para completado.
     */

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Actualzia el valor del id.
     * @param id - Nuevo valor para id.
     */
    public void setId(int id) {
        this.id = id;
    }

}