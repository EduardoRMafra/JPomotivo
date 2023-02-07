package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;
import util.ConnectionFactory;

/**
 *
 * @author Eduardo
 */
public class UserController {
    
        public void create(User user){
        String sql = "INSERT INTO users (name, password) "
                + "VALUES (?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());

            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao cadastrar usuário " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void update(User user){
        String sql = "UPDATE users SET name = ?, password = ? WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());
            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao atualizar informações de usuário " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void removeById(int userId){
        String sql = "DELETE FROM users WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setInt(1, userId);
            
            //executando a query
            statement.execute();
        }catch(Exception ex){
            throw new RuntimeException("Erro ao deletar o usuário " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public User hasUser(String name, String password){
        
        String sql = "SELECT id, name, password FROM users WHERE name = ? AND password = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        
        //usuário é null caso não exista registro
        User user = null;
        
        try{
            //estabelecendo conexão com banco de dados
            conn = ConnectionFactory.getConnection();
            //preparando query
            statement = conn.prepareStatement(sql);
            
            //setando valores do statement
            statement.setString(1, name);
            statement.setString(2, password);
            
            //retorno execução query
            resultSet = statement.executeQuery();
            
            //verifica se existe algum registro no resultSet
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
            }
        }catch(Exception ex){
            throw new RuntimeException("Erro ao carregar o usuário " + ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        //retornando usuário cadastrado no banco de dados
        return user;
    }
}
