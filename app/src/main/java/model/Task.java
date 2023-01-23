package model;

import java.util.Date;

/**schedules
 *
 * @author Eduardo
 */
public class Task {
    private int id;
    private int idUser;
    private int idSchedule;
    private String name;
    private String description;
    private boolean completed;
    private String notes;
    private Date deadline;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, int idUser, int idSchedule, String name, String description, boolean completed, String notes, Date deadline, Date createdAt, Date updatedAt) {
        setId(id);
        setIdUser(idUser);
        setIdSchedule(idSchedule);
        setName(name);
        setDescription(description);
        setCompleted(completed);
        setNotes(notes);
        setDeadline(deadline);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    
}
