package dev.salles;

import dev.salles.model.entities.User;
import dev.salles.persistence.dao.UserDAO;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        User user = new User("felicity", "Felicity Smoak", "1992-12-12", "Female");
        User user2 = new User("oliverq", "Oliver Queen", "1992-12-13", "Male");
        User user3 = new User("johndig", "John Diggle", "1985-01-04", "Male");
        new UserDAO().insert(user);
        new UserDAO().insert(user2);
        new UserDAO().insert(user3);
        user2.setBirthdate("1999-09-29");
        new UserDAO().update(user2);
        new UserDAO().delete("johndig");

        Optional<User> optionalUser = new UserDAO().select("oliverq");
        if (optionalUser.isPresent()) {
            User tempUser = optionalUser.get();
            System.out.println("Username: " + tempUser.getUsername() +
                                "\nName: " + tempUser.getFullname() +
                                "\nBirth date: " + tempUser.getBirthdate() +
                                "\nGender: " + tempUser.getGender());
        } else {
            System.out.println("There is no user with that username!");
        }

        List<User> users = new UserDAO().selectAll();
        for(User u : users) {
            System.out.println("\n---------------------------------------------------");
            System.out.println("\nUsername: " + u.getUsername() +
                                "\nName: " + u.getFullname() +
                                "\nBirth date: " + u.getBirthdate() +
                                "\nGender: " + u.getGender());
        }
    }
}
