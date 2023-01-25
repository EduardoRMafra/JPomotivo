package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Eduardo
 */
public class TaskController {
    
    public void save(Task task){
        String sql = "INSERT INTO tasks (idUser, name, description, completed, "
                + "notes, deadline, createdAt, updatedAt) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, task.getIdUser());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao criar a tarefa " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void update(Task task){
        String sql = "UPDATE tasks SET idUser = ?, name = ?, description = ?, completed = ?, "
        + "notes = ?, deadline = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
        
                Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, task.getIdUser());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao atualizar a tarefa " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void removeById(int taskId){
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, taskId);
            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao deletar a tarefa " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public List<Task> getAll(int idUser){
        
        String sql = "SELECT * FROM tasks WHERE idUser = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Task> tasks = new ArrayList<Task>();
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, idUser);
            
            //retorno execução query
            resultSet = statement.executeQuery();
            
            //enquanto existir algum valor a ser percorrido no resultSet
            while(resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdUser(resultSet.getInt("idUser"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("note"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                tasks.add(task);
            }
        }catch(Exception ex){
            throw new RuntimeException("Erro ao carregar as tarefas " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        //retornando lista de tarefas de um usuário criadas no banco de dados
        return tasks;
    }
}
