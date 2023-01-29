package model;

/**
 *
 * @author Eduardo
 */
public class ScheduleTask {
    private int id;
    private int idUser;
    private int idSchedule;
    private int idTask;

    public ScheduleTask() {
    }

    public ScheduleTask(int id, int idUser, int idSchedule, int idTask) {
        setId(id);
        setIdUser(idUser);
        setIdSchedule(idSchedule);
        setIdTask(idTask);
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

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    @Override
    public String toString() {
        return "ScheduleTask{" + "id=" + id + ", idUser=" + idUser + ", idSchedule=" + idSchedule + ", idTask=" + idTask + '}';
    }
}
