package model;

/**
 *
 * @author Eduardo
 */
public class ScheduleTask {
    private int id;
    private int idUser;
    private int idSchedule;
    private Task schTask;

    public ScheduleTask() {
    }

    public ScheduleTask(int id, int idUser, int idSchedule, Task scTask) {
        setId(id);
        setIdUser(idUser);
        setIdSchedule(idSchedule);
        setSchTask(scTask);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Task getSchTask() {
        return schTask;
    }

    public void setSchTask(Task schTask) {
        this.schTask = schTask;
    }
    @Override
    public String toString() {
        return "ScheduleTask{" + "id=" + id + ", idUser=" + idUser + ", idSchedule=" + idSchedule + ", idTask=" + schTask.getId() + "}";
    }
}
