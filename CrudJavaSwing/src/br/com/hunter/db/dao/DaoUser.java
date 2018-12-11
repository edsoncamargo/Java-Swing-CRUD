/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hunter.db.dao;

import br.com.hunter.db.utils.ConnectionUtils;
import br.com.hunter.models.user.User;
import br.com.hunter.services.date.ConvertDate;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author edson
 */
public class DaoUser {

    // Instanciando a classe que faz a conexão com o banco de dados
    ConnectionUtils conex = new ConnectionUtils();

    // Metódo de cadastrar cliente (recebendo por parâmetro o cliente que será cadastrado)
    public void createUser(User user) throws SQLException {
        try {

            String sql = "insert into tb_user"
                    + "(UserName, Name, Birth, Password)"
                    + "VALUE (?, ?, ?, ?)";

            PreparedStatement pst = conex.getConnection().prepareStatement(sql);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getName());
            pst.setString(3, user.getBirth());
            pst.setString(4, user.getPassword());

            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
