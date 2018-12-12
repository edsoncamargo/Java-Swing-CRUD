/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hunter.models.validators;

import br.com.hunter.models.user.User;

/**
 *
 * @author HUNTER
 */
public class ValidatorUser {

    public static String validate(User user) {

        if (user.getUsername().isEmpty() || "".equals(user.getUsername())) {
            return "The username field is required.";
        }

        if (user.getName().isEmpty() || "".equals(user.getName())) {
            return "The name field is required.";
        }

        if ("  /  /    ".equals(user.getBirth()) || user.getBirth() == "  /  /    ") {
            return "The birth field is required.";
        }

        if (user.getPassword().isEmpty() || "".equals(user.getPassword())) {
            return "The password field is required.";
        }

        if (user.getPassword().length() < 6) {
            return "Your password is too small, please type more than 6 characters.";
        }

        return null;
    }

}
