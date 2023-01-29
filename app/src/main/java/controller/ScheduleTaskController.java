package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ScheduleTask;
import util.ConnectionFactory;

/**
 *
 * @author Eduardo
 */
public class ScheduleTaskController {
    public void add(ScheduleTask scheduleTask){
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
            statement.setInt(3, scheduleTask.getIdTask());

            
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
            statement.setInt(1, scheduleTask.getIdTask());
            statement.setInt(3, scheduleTask.getId());
            
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
        public List<ScheduleTask> getAll(int idUser, int idSchedule){
        
        String sql = "SELECT * FROM scheduleTasks WHERE idUser = ? AND idSchedule = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<ScheduleTask> scheduleTasks = new ArrayList<ScheduleTask>();
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, idUser);
            statement.setInt(2, idSchedule);
            
            //retorno execução query
            resultSet = statement.executeQuery();
            
            //enquanto existir algum valor a ser percorrido no resultSet
            while(resultSet.next()){
                ScheduleTask scheduleTask = new ScheduleTask();
                scheduleTask.setId(resultSet.getInt("id"));
                scheduleTask.setId(resultSet.getInt("idUser"));
                scheduleTask.setId(resultSet.getInt("idSchedule"));
                scheduleTask.setId(resultSet.getInt("idTask"));
                
                
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
