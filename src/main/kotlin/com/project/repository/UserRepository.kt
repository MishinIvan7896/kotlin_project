package com.project.repository

import com.project.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.sql.SQLException

@Repository
class UserRepository(@Autowired var jdbcTemplate: JdbcTemplate) {

    fun findByUsername(name: String): User? {
        val sql = "SELECT * FROM users WHERE username = ?"
        return jdbcTemplate.queryForObject(sql, arrayOf<Any>(name), this::mapRowToUser)
    }

    fun findAll(): List<User?>? {
        val sqlQuery = "select * from users"
        return jdbcTemplate.query(sqlQuery, this::mapRowToUser)
    }

    fun findOne(id: Long): User? {
        val sqlQuery = "select * from users where id = ?"
        return jdbcTemplate.queryForObject(sqlQuery, arrayOf<Any>(id), this::mapRowToUser)
    }

    @Throws(SQLException::class)
    private fun mapRowToUser(resultSet: ResultSet, rowNum: Int): User? {
        val user = User()
        user.setId(resultSet.getLong("id"))
        user.setUsername(resultSet.getString("username"))
        user.setPassword(resultSet.getString("password"))
        user.setRole(resultSet.getString("role"))
        return user
    }

}