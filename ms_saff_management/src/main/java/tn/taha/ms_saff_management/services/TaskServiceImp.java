package tn.taha.ms_saff_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.taha.ms_saff_management.entities.Staff;
import tn.taha.ms_saff_management.entities.Tasks;
import tn.taha.ms_saff_management.repository.StaffRepository;
import tn.taha.ms_saff_management.repository.TaskRepository;
import tn.taha.ms_saff_management.services.Interfaces.ITaskService;

import java.util.List;
@Service
public class TaskServiceImp implements ITaskService {
    @Autowired
    private TaskRepository tasksRepository;
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Tasks addTasktostaff(int IDstaff, Tasks task) {
        if (staffRepository.findById(IDstaff).isPresent()) {
            Staff staff = staffRepository.findById(IDstaff).get();
            task.setStaff(staff);
            return tasksRepository.save(task);

        }else {
            return null;
        }
    }

    @Override
    public Tasks GetTask( int idTask) {

        if (tasksRepository.findById(idTask).isPresent()) {
            Tasks task = tasksRepository.findById(idTask).get();
            return task;
        } else {
            return null; // Handle the case when the task doesn't exist or doesn't belong to the staff
        }
    }

    @Override
    public Tasks update(int idTask,Tasks newTask) {
        if (tasksRepository.findById(idTask).isPresent()) {
            Tasks oldtask = tasksRepository.findById(idTask).get();
            oldtask.setLabel(newTask.getLabel());
            oldtask.setToDo(newTask.getToDo());
            oldtask.setDate(newTask.getDate());
            oldtask.setStartTime(newTask.getStartTime());
            oldtask.setEndTime(newTask.getEndTime());
            return tasksRepository.save(oldtask);
        } else {
            return null; // Handle the case when the task doesn't exist or doesn't belong to the staff
        }
    }

    @Override
    public List<Tasks> all_tasks_ofstaff(int IdStaff) {
        return tasksRepository.findByStaff_IdStaff(IdStaff);
    }

    @Override
    public boolean DeleteTask( int idtask) {
        if (tasksRepository.findById(idtask).isPresent()) {
            //Tasks task = tasksRepository.findById(idtask).get();
            tasksRepository.deleteById(idtask);
            return true;
        }else {
            return false;
        }
    }
}