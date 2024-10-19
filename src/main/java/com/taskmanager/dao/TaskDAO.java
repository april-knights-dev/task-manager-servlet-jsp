package com.taskmanager.dao;

import java.util.ArrayList;
import java.util.List;

import com.taskmanager.model.Task;

// TaskDAOクラスは、タスクに関連するデータベース操作を管理します。
// このクラスはタスクの取得、追加、削除などのメソッドを提供します。
public class TaskDAO {
    private static TaskDAO instance;
    private List<Task> tasks = new ArrayList<>();

    private TaskDAO() {}

    public static synchronized TaskDAO getInstance() {
        if (instance == null) {
            instance = new TaskDAO();
        }
        return instance;
    }

    public void addTask(Task task) {
        task.setId(tasks.size() + 1); // 簡単なID生成
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks); // 防御的コピーを返す
    }

    public Task getTaskById(int id) {
        return tasks.stream()
                    .filter(task -> task.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    public void updateTask(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == task.getId()) {
                tasks.set(i, task);
                break;
            }
        }
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}
