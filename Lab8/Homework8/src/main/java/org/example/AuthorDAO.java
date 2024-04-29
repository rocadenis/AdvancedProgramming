package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private final Connection connection;

    public AuthorDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void addAuthor(String authorName) {
        if (!isAuthorExist(authorName)) {
            String insertQuery = "INSERT INTO authors(name) VALUES(?)";

            try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
                pstmt.setString(1, authorName);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private boolean isAuthorExist(String authorName) {
        String checkQuery = "SELECT * FROM authors WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(checkQuery)) {
            pstmt.setString(1, authorName);
            ResultSet resultSet = pstmt.executeQuery();
            return resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<String> getAllAuthors() {
        List<String> authors = new ArrayList<>();
        String selectQuery = "SELECT name FROM authors";

        try (PreparedStatement pstmt = connection.prepareStatement(selectQuery);
             ResultSet resultSet = pstmt.executeQuery()) {

            while (resultSet.next()) {
                authors.add(resultSet.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return authors;
    }
}
