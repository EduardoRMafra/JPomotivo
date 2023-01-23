package model;

import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class Schedule {
    private int id;
    private int idUser;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private int working;
    private int shortBreak;
    private int bigBreak;

    public Schedule(int id, int idUser, String name, String description, Date createdAt, Date updatedAt, int working, int shortBreak, int bigBreak) {
        setId(id);
        setIdUser(idUser);
        setName(name);
        setDescription(description);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        setWorking(working);
        setShortBreak(shortBreak);
        setBigBreak(bigBreak);
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

    public int getWorking() {
        return working;
    }

    public void setWorking(int working) {
        this.working = working;
    }

    public int getShortBreak() {
        return shortBreak;
    }

    public void setShortBreak(int shortBreak) {
        this.shortBreak = shortBreak;
    }

    public int getBigBreak() {
        return bigBreak;
    }

    public void setBigBreak(int bigBreak) {
        this.bigBreak = bigBreak;
    }

    @Override
    public String toString() {
        return "Schedule{" + "id=" + id + ", idUser=" + idUser + ", name=" + name + ", description=" + description + ", createAt=" + createdAt + ", updatedAt=" + updatedAt + ", working=" + working + ", shortBreak=" + shortBreak + ", bigBreak=" + bigBreak + '}';
    }
    
    
    
}


