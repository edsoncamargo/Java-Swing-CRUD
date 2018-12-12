/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hunter.services.user;

import br.com.hunter.db.dao.user.DaoUser;
import br.com.hunter.models.user.User;
import br.com.hunter.models.validators.ValidatorUser;
import java.sql.SQLException;

/**
 *
 * @author HUNTER
 */
public class ServicesUser {
    
    DaoUser du = new DaoUser();
    private static final ServicesUser INSTANCE = new ServicesUser();
    
    public static ServicesUser getInstance() {
        return INSTANCE;
    }
    
    public String createUser(User user) throws SQLException {
        String reply = null;
        reply = ValidatorUser.validate(user);
        
        if (reply == null) {
            try {
                du.createUser(user);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return reply;
    }
    
}
