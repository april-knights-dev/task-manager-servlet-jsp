package com.taskmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.TaskDAO;
import com.taskmanager.model.Task;

@WebServlet("/listTasks")
public class ListTasksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TaskDAO taskDAO = TaskDAO.getInstance();
        List<Task> tasks = taskDAO.getTasks();
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/listTasks.jsp").forward(request, response);
    }
}