package dev.salles.persistence.dao;

import dev.salles.model.entities.User;
import dev.salles.persistence.utils.DAO;
import dev.salles.persistence.utils.SQLConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO implements DAO<User, String> {
    public void insert(User user) {
        String sql = "INSERT INTO USER VALUES(?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = SQLConnection.getConn().prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFullname());
            ps.setString(3, user.getBirthdate());
            ps.setString(4, user.getGender());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(User user) {
        String sql = "UPDATE USER SET fullname = ?, birthdate = ?, gender = ? WHERE username = ?";
        PreparedStatement ps = null;

        try {
            ps = SQLConnection.getConn().prepareStatement(sql);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getBirthdate());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getUsername());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String key) {
        String sql = "DELETE FROM USER WHERE username = ?";
        PreparedStatement ps = null;

        try {
            ps = SQLConnection.getConn().prepareStatement(sql);
            ps.setString(1, key);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> select(String key) {
        String sql = "SELECT * FROM USER WHERE username = ?";
        User user = null;
        PreparedStatement ps = null;

        try {
            ps = SQLConnection.getConn().prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rsUser = ps.executeQuery();
            while (rsUser.next()) {
                user = new User(rsUser.getString(1), rsUser.getString(2), rsUser.getString(3), rsUser.getString(4));
            }

            rsUser.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.ofNullable(user);
    }

    public List<User> selectAll() {
        String sql = "SELECT * FROM USER";
        List<User> users = new ArrayList<>();
        PreparedStatement ps = null;

        try {
            ps = SQLConnection.getConn().prepareStatement(sql);
            ResultSet rsUser = ps.executeQuery();
            while (rsUser.next()) {
                users.add(new User(rsUser.getString(1), rsUser.getString(2), rsUser.getString(3), rsUser.getString(4)));
            }

            rsUser.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

}
