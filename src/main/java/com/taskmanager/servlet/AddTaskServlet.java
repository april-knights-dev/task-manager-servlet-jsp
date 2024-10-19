package com.taskmanager.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.TaskDAO;
import com.taskmanager.model.Task;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String dueDateStr = request.getParameter("dueDate");

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);

        if (dueDateStr != null && !dueDateStr.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dueDate = dateFormat.parse(dueDateStr);
                task.setDueDate(dueDate);
            } catch (ParseException e) {
                // エラーメッセージをセットしてリダイレクト
                request.getSession().setAttribute("errorMessage", "無効な日付形式です。");
                response.sendRedirect("listTasks");
                return;
            }
        }

        TaskDAO taskDAO = TaskDAO.getInstance();
        taskDAO.addTask(task);

        response.sendRedirect("listTasks");
    }
}
