package dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import entity.Country;
import entity.User;
import dao.inter.AbstractDao;
import dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String phone = rs.getString("phone");
        String profileDescription = rs.getString("profile_description");
        String address = rs.getString("address");
        Date birthdate = rs.getDate("birthdate");
        int nationality_id = rs.getInt("nationality_id");
        int birthplace_id = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");
        Country nationality = new Country(nationality_id, null, nationalityStr);
        Country birthplace = new Country(birthplace_id, birthplaceStr, null);
        return new User(id, name, surname, phone, email, password, profileDescription, address, birthdate, nationality, birthplace);
    }

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            String query = "SELECT u.*, " +
                    "n.nationality," +
                    "c.name as birthplace " +
                    "from user as u " +
                    "left join country as n on u.nationality_id = n.id " +
                    "left join country as c on u.birthplace_id = c.id " +
                    "where 1=1";

            if (name != null && !name.trim().isEmpty()) query += " and u.name = ?";
            if (surname != null && !surname.trim().isEmpty()) query += " and u.surname = ?";
            if (nationalityId != null) query += " and u.nationality_id = ?";

            PreparedStatement preparedStatement = c.prepareStatement(query);
            int i = 1;

            if (name != null && !name.trim().isEmpty()) preparedStatement.setString(i++, name);
            if (surname != null && !surname.trim().isEmpty()) preparedStatement.setString(i++, surname);
            if (nationalityId != null) preparedStatement.setInt(i++, nationalityId);

            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                result.add(getUser(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private static final BCrypt.Hasher crypt = BCrypt.withDefaults();

    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("insert into user(name, surname, phone, email, password, profile_description, address, birthdate, birthplace_id, nationality_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurname());
            pstmt.setString(3, u.getPhone());
            pstmt.setString(4, u.getEmail());
            pstmt.setString(5, crypt.hashToString(4, u.getPassword().toCharArray()));
            pstmt.setString(6, u.getProfileDescription());
            pstmt.setString(7, u.getAddress());
            pstmt.setDate(8, u.getBirthDate());
            pstmt.setInt(9, u.getBirthplace().getId());
            pstmt.setInt(10, u.getNationality().getId());
            return pstmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("update user set name = ?, surname = ?, phone = ?, email = ?, profile_description = ?, address = ?, birthdate = ?, birthplace_id = ?, nationality_id = ? where id = ?");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurname());
            pstmt.setString(3, u.getPhone());
            pstmt.setString(4, u.getEmail());
            pstmt.setString(5, u.getProfileDescription());
            pstmt.setString(6, u.getAddress());
            pstmt.setDate(7, u.getBirthDate());
            pstmt.setInt(8, u.getBirthplace().getId());
            pstmt.setInt(9, u.getNationality().getId());
            pstmt.setInt(10, u.getId());
            return pstmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT u.*, n.nationality, c.name as birthplace " +
                    "from user as u " +
                    "left join country as n on u.nationality_id = n.id " +
                    "left join country as c on u.birthplace_id = c.id " +
                    "where u.id =" + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public User getByEmail(String email) {
        User result = null;
        try (Connection c = connect()) {
            String query = "SELECT u.*, n.nationality, c.name as birthplace " +
                    "from user as u " +
                    "left join country as n on u.nationality_id = n.id " +
                    "left join country as c on u.birthplace_id = c.id " +
                    "where u.email = ?";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                result = getUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id =" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
