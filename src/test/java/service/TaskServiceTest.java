package service;

import com.insart.tasker.entities.Task;
import com.insart.tasker.services.TaskService;
import util.TaskUtil;
import config.TestDataBaseConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class TaskServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private TaskService taskService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

   public  Task task=new Task();
    public void setTaskInfo(Task task_info)
    {
        task=task_info;
    }


    @Test
    public void testSaveTask() throws Exception {
         taskService.addTask(TaskUtil.createTask(task));
    }
}
