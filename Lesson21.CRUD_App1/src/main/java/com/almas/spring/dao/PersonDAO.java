package com.almas.spring.dao;

import com.almas.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private static int PEOPLE_COUNT;
//    public static final String URL="jdbc:postgresql://localhost:5432/first_db";
//    public static final String USERNAME="postgres";
//    public static  final String PASSWORD="changeme";
//
//    private static Connection connection;
//
//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    private List<Person> people;

//    {
//        people=new ArrayList<>();
//
//        people.add(new Person(++PEOPLE_COUNT,"Tom", 24 , "tom@mail.kz"));
//        people.add(new Person(++PEOPLE_COUNT,"Bob", 23 , "bob@mail.kz"));
//        people.add(new Person(++PEOPLE_COUNT,"Mike", 20 , "mike@mail.kz"));
//        people.add(new Person(++PEOPLE_COUNT,"Katy", 19 , "katy@mail.kz"));
//    }

    public List<Person> index(){

//        return people;
//    List<Person> people = new ArrayList<>();
//
//        Statement statement= null;
//        try {
//            statement = connection.createStatement();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        String SQL="SELECT * FROM Person";
//        try {
//            ResultSet resultSet=statement.executeQuery(SQL);
//
//            while(resultSet.next()){
//              Person person=new Person();
//                person.setId(resultSet.getInt("id"));
//                person.setAge(resultSet.getInt("age"));
//                person.setName(resultSet.getString("name"));
//                person.setEmail(resultSet.getString("email"));
//
//                people.add(person);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//       return people;
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));  //new PersonMapper()
    }

    public Person show(int id){
//        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
//        Person person=null;
//        try {
//        PreparedStatement preparedStatement=
//                null;
//
//            preparedStatement = connection.prepareStatement("SELECT * FROM Person WHERE id=?");
//
//        preparedStatement.setInt(1,id );
//
//        ResultSet resultSet=preparedStatement.executeQuery();
//
//        resultSet.next();
//        person=new Person();
//        person.setId(resultSet.getInt("id"));
//        person.setName(resultSet.getString("name"));
//        person.setEmail(resultSet.getString("email"));
//        person.setAge(resultSet.getInt("age"));
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return  person;

        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person){
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);

//        try {
////            Statement statement=connection.createStatement();
////            String SQL="INSERT INTO Person VALUES("+1+",'"+person.getName()+"',"+person.getAge()+",'"+person.getEmail()+"')";
//
//            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO Person VALUES (1,?,?,?)");
//            preparedStatement.setString(1, person.getName());
//            preparedStatement.setInt(2,person.getAge());
//            preparedStatement.setString(3, person.getEmail());
////            statement.executeUpdate(SQL);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        jdbcTemplate.update("INSERT INTO Person VALUES(1,?,?,?)",person.getName(),person.getAge(),person.getEmail());
    }

    public void update(int id, Person updatePerson){
//        Person personToBeUpdated=show(id);
//        personToBeUpdated.setName(updatePerson.getName());
//        personToBeUpdated.setAge(updatePerson.getAge());
//        personToBeUpdated.setEmail(updatePerson.getEmail());

//        try {
//            PreparedStatement preparedStatement=
//                    connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? where id=?");
//             preparedStatement.setString(1,updatePerson.getName());
//             preparedStatement.setInt(2,updatePerson.getAge());
//             preparedStatement.setString(3, updatePerson.getEmail());
//             preparedStatement.setInt(4, id);
//
//             preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? where id=?",updatePerson.getName(),updatePerson.getAge()
        ,updatePerson.getEmail(),id);
    }

    public void delete(int id) {
//        people.removeIf(p->p.getId()==id);

//        try {
//            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM Person WHERE id=?");
//            preparedStatement.setInt(1,id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        jdbcTemplate.update("DELETE FROM Person WHERE id=?",id);
    }
}
