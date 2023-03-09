package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ScheduleTask;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Eduardo
 */
public class ScheduleTaskController {
    public void save(ScheduleTask scheduleTask){
                String sql = "INSERT INTO scheduletasks (idUser, idSchedule, idTask) "
                + "VALUES (?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, scheduleTask.getIdUser());
            statement.setInt(2, scheduleTask.getIdSchedule());
            statement.setInt(3, scheduleTask.getSchTask().getId());

            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao adicionar tarefas ao cronograma " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void update(ScheduleTask scheduleTask){
        String sql = "UPDATE scheduletasks SET idTask = ? WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, scheduleTask.getSchTask().getId());
            statement.setInt(2, scheduleTask.getId());
            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao alterar a tarefas do cronograma" + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
        
    public void removeById(int idScheduleTask){
        String sql = "DELETE FROM scheduletasks WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, idScheduleTask);
            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao deletar a tarefas do cronograma " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
        public List<ScheduleTask> getAll(int idSchedule, int idUser){
        //Seleciona 2 tabelas do banco de dados e busca e junta dados especificos delas baseado no id das tarefas
        //utilizando como filtro o idSchedule e o idUser para selecionar apenas aquelas tarefas que são de um
        //cronograma e usuário invés de todos.
        String sql = "SELECT tasks.id, tasks.name, tasks.description, tasks.completed, "
                + "tasks.notes, tasks.deadline, scheduleTasks.id FROM tasks " 
                + "JOIN scheduleTasks ON tasks.id = scheduleTasks.idTask "
                + "WHERE scheduleTasks.idSchedule = ? AND tasks.idUser = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<ScheduleTask> scheduleTasks = new ArrayList<>();
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, idSchedule);
            statement.setInt(2, idUser);
            //retorno execução query
            resultSet = statement.executeQuery();
            
            //enquanto existir algum valor a ser percorrido no resultSet
            while(resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                
                ScheduleTask scheduleTask = new ScheduleTask();
                scheduleTask.setId(resultSet.getInt("scheduleTasks.id"));
                scheduleTask.setIdSchedule(idSchedule);
                scheduleTask.setIdUser(idUser);
                scheduleTask.setSchTask(task);
                scheduleTasks.add(scheduleTask);
            }
        }catch(Exception ex){
            throw new RuntimeException("Erro ao carregar as tarefas " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        //retornando lista de tarefas de um cronograma criadas no banco de dados
        return scheduleTasks;
    }
}
