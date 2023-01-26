package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Schedule;
import util.ConnectionFactory;

/**
 *
 * @author Eduardo
 */
public class ScheduleController {
    
    public void save(Schedule schedule){
        String sql = "INSERT INTO schedules (idUser, name, description, "
                + "createdAt, updatedAt, active, shortBreak, bigBreak) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, schedule.getIdUser());
            statement.setString(2, schedule.getName());
            statement.setString(3, schedule.getDescription());
            statement.setDate(4, new Date(schedule.getCreatedAt().getTime()));
            statement.setDate(5, new Date(schedule.getUpdatedAt().getTime()));
            statement.setBoolean(6, schedule.isActive());
            statement.setInt(7, schedule.getShortBreak());
            statement.setInt(8, schedule.getBigBreak());

            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao criar o cronograma " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void update(Schedule schedule){
        String sql = "UPDATE schedules SET idUser = ?, name = ?, description = ?, createdAt = ?, "
        + "updatedAt = ?, active = ?, shortBreak = ?, bigBreak = ? WHERE id = ?";
        
            Connection conn = null;
            PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, schedule.getIdUser());
            statement.setString(2, schedule.getName());
            statement.setString(3, schedule.getDescription());
            statement.setDate(4, new Date(schedule.getCreatedAt().getTime()));
            statement.setDate(5, new Date(schedule.getUpdatedAt().getTime()));
            statement.setBoolean(6, schedule.isActive());
            statement.setInt(7, schedule.getShortBreak());
            statement.setInt(8, schedule.getBigBreak());
            statement.setInt(9, schedule.getId());
            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao atualizar o cronograma " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void removeById(int scheduleId){
        String sql = "DELETE FROM schedules WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, scheduleId);
            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao deletar o cronograma " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public List<Schedule> getAll(int idUser){
        
        String sql = "SELECT * FROM schedules WHERE idUser = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Schedule> schedules = new ArrayList<Schedule>();
        
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
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt("id"));
                schedule.setIdUser(resultSet.getInt("idUser"));
                schedule.setName(resultSet.getString("name"));
                schedule.setDescription(resultSet.getString("description"));
                schedule.setCreatedAt(resultSet.getDate("createdAt"));
                schedule.setUpdatedAt(resultSet.getDate("updatedAt"));
                schedule.setActive(resultSet.getBoolean("active"));
                schedule.setShortBreak(resultSet.getInt("shortBreak"));
                schedule.setBigBreak(resultSet.getInt("bigBreak"));
                
                schedules.add(schedule);
            }
        }catch(Exception ex){
            throw new RuntimeException("Erro ao carregar os cronogramas " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        //retornando lista de cronogramas de um usuário criadas no banco de dados
        return schedules;
    }
}
