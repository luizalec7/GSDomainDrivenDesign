package com.oceanguardians.dao;

import com.oceanguardians.exceptions.AppException;
import com.oceanguardians.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public void insertUser(User user) throws AppException {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("Error inserting user", e);
        }
    }

    public void deleteUser(int id) throws AppException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("Error deleting user", e);
        }
    }

    public void updateUser(User user) throws AppException {
        String sql = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("Error updating user", e);
        }
    }

    public User selectUser(int id) throws AppException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            throw new AppException("Error selecting user", e);
        }
        return null;
    }

    public List<User> selectAllUsers() throws AppException {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password")));
            }
        } catch (SQLException e) {
            throw new AppException("Error selecting all users", e);
        }
        return users;
    }
}
