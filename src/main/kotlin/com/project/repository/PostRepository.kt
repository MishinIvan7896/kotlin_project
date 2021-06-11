package com.project.repository

import com.project.models.Post
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.sql.SQLException

@Repository
class PostRepository(@Autowired var jdbcTemplate: JdbcTemplate) {

    fun findAll(): List<Post?>? {
        val sqlQuery = "select id, authorId, text from posts"
        return jdbcTemplate.query(sqlQuery, this::mapRowToPost)
    }

    fun findOne(id: Long): Post? {
        val sqlQuery = "select id, authorId, text from posts where id = ?"
        return jdbcTemplate.queryForObject(sqlQuery, arrayOf<Any>(id), this::mapRowToPost)
    }

    fun save(post: Post) {
        val sqlQuery = "insert into posts (authorId, text) values (?, ?)"
        jdbcTemplate.update(
            sqlQuery,
            post.getAuthorId(),
            post.getText(),
        )
    }

    fun update(post: Post) {
        val sqlQuery = "update posts set text = ? where id = ?"
        jdbcTemplate.update(sqlQuery, post.getText(), post.getId())
    }

    fun delete(id: Long): Boolean {
        val sqlQuery = "delete from posts where id = ?"
        return jdbcTemplate.update(sqlQuery, id) > 0
    }

    @Throws(SQLException::class)
    private fun mapRowToPost(resultSet: ResultSet, rowNum: Int): Post? {
        val post = Post()
        post.setId(resultSet.getLong("id"))
        post.setAuthorId(resultSet.getLong("authorId"))
        post.setText(resultSet.getString("text"))
        return post
    }
}