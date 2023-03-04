package yandex.cloud.serverless.todo;

import yandex.cloud.serverless.todo.db.Dao;
import yandex.cloud.serverless.todo.db.TaskDao;
import yandex.cloud.serverless.todo.model.Task;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class DeleteTaskServlet extends HttpServlet {

    private final Dao<Task> taskDao = new TaskDao();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        var taskId = req.getParameter("taskId");
        Objects.requireNonNull(taskId, "Parameter 'taskId' missing");

        taskDao.deleteById(taskId);
    }

}
