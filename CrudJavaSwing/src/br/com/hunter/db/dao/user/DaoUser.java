/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hunter.db.dao.user;

import br.com.hunter.db.utils.ConnectionUtils;
import br.com.hunter.models.user.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author edson
 */
public class DaoUser {

    // Instanciando a classe que faz a conexão com o banco de dados
    ConnectionUtils conex = new ConnectionUtils();
    PreparedStatement pst;
    ResultSet rs;

    // Metódo de cadastrar cliente (recebendo por parâmetro o cliente que será cadastrado)
    public void createUser(User user) throws SQLException {
        try {
            String query = "insert into tb_user"
                    + "(UserName, Name, Birth, Password)"
                    + "VALUE (?, ?, ?, ?)";

            pst = conex.getConnection().prepareStatement(query);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getName());
            pst.setString(3, user.getBirth());
            pst.setString(4, user.getPassword());

            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<String> showUsers() throws SQLException {
        String query = "select name from tb_user";
        ArrayList names = new ArrayList();

        pst = conex.getConnection().prepareStatement(query);
        rs = pst.executeQuery(query);
        while (rs.next()) {
            names.add(rs.getString("Name"));
        }

        return names;
    }

}
