package tn.taha.ms_saff_management.services.Interfaces;

import tn.taha.ms_saff_management.entities.Tasks;

import java.util.List;

public interface ITaskService {
    public  Tasks addTasktostaff(int IDstaff, Tasks task);

    public Tasks GetTask (int idTask);

    public Tasks update(int idTask,Tasks newTask);

    public List<Tasks> all_tasks_ofstaff(int IdStaff);
    public boolean DeleteTask(int idtask);
}