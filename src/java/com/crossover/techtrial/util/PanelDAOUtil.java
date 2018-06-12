/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.techtrial.util;

import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.model.Panel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thefavourofpraise
 */
@Transactional
@Repository
public class PanelDAOUtil {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Panel findPanel(String panel) {
        String sql = "select * from panels where serial = ?";
        RowMapper<Panel> rowMapper = new BeanPropertyRowMapper<Panel>(Panel.class);
        return jdbcTemplate.query(sql, rowMapper).get(0);
    }

    public Panel findOne(long id) {
        String sql = "select * from panels where id = ?";
        RowMapper<Panel> rowMapper = new BeanPropertyRowMapper<Panel>(Panel.class);
        return jdbcTemplate.query(sql, rowMapper).get(0);
    }

    public boolean exist(long id) {
        String sql = "select * from panels where id = ?";
        RowMapper<Panel> rowMapper = new BeanPropertyRowMapper<Panel>(Panel.class);
        return !jdbcTemplate.query(sql, rowMapper).isEmpty();
    }

    public List<Panel> findAll(Sort sort) {
        String sql = "select * from panels order by ?";
        RowMapper<Panel> rowMapper = new BeanPropertyRowMapper<Panel>(Panel.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<Panel> findAll(Pageable pgbl) {
        String sql = "select * from panels";
        RowMapper<Panel> rowMapper = new BeanPropertyRowMapper<Panel>(Panel.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Iterable<Panel> findAll() {
        String sql = "select * from panels";
        RowMapper<Panel> rowMapper = new BeanPropertyRowMapper<Panel>(Panel.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
    public Iterable<Panel> findAll(Iterable<Long> itrbl) {
        
        String sql = "select * from panels where id in () ";
        RowMapper<Panel> rowMapper = new BeanPropertyRowMapper<Panel>(Panel.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Panel save(Panel p) {
        String sql = "INSERT INTO panels (id, serial,brand, latitude,longitude) values (?, ?, ?,?)";
        jdbcTemplate.update(sql, p.getId(), p.getSerial(),p.getBrand(), p.getLatitude(), p.getLongitude());
        return p;
    }
    public long count() {
        String sql = "select * from panels where id in () ";
        RowMapper<Integer> rowMapper = new BeanPropertyRowMapper<Integer>(Integer.class);
        return jdbcTemplate.query(sql, rowMapper).get(0);
    }
    
public void delete(long id) {
        String sql = "delete from panel where id  = ?";
        jdbcTemplate.update(sql, id);
    }

}
