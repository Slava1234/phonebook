package com.phonebook.service;

import com.phonebook.dao.PhoneBookDAO;
import com.phonebook.util.Util;
import com.phonebook.objects.PhoneBook;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class PhoneBookService implements PhoneBookDAO {
    
    @Autowired
    Util util;

    public List<PhoneBook> getAll() {
        Connection connection = util.getConnection();
        
        List<PhoneBook> phoneBookList = new ArrayList<PhoneBook>();

        String query = "SELECT * FROM phone_book";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                PhoneBook phoneBook = new PhoneBook();
                phoneBook.setId(resultSet.getInt("id"));
                phoneBook.setName(resultSet.getString("name"));
                phoneBook.setPhone(resultSet.getLong("phone"));
                phoneBook.setEmail(resultSet.getString("email"));
                
                phoneBookList.add(phoneBook);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return phoneBookList;
    }

}
