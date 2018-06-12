/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.techtrial.util;

import com.crossover.techtrial.model.HourlyElectricity;
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
public class ElectricityDAOUtil1 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HourlyElectricity findPanel(String panel) {
        String sql = "select * from panels where serial = ?";
        RowMapper<HourlyElectricity> rowMapper = new BeanPropertyRowMapper<HourlyElectricity>(HourlyElectricity.class);
        return jdbcTemplate.query(sql, rowMapper).get(0);
    }

    public HourlyElectricity findOne(long id) {
        String sql = "select * from panels where id = ?";
        RowMapper<HourlyElectricity> rowMapper = new BeanPropertyRowMapper<HourlyElectricity>(HourlyElectricity.class);
        return jdbcTemplate.query(sql, rowMapper).get(0);
    }

    public boolean exist(long id) {
        String sql = "select * from panels where id = ?";
        RowMapper<HourlyElectricity> rowMapper = new BeanPropertyRowMapper<HourlyElectricity>(HourlyElectricity.class);
        return !jdbcTemplate.query(sql, rowMapper).isEmpty();
    }

    public List<HourlyElectricity> findAll(Sort sort) {
        String sql = "select * from panels order by ?";
        RowMapper<HourlyElectricity> rowMapper = new BeanPropertyRowMapper<HourlyElectricity>(HourlyElectricity.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<HourlyElectricity> findAll(Pageable pgbl) {
        String sql = "select * from panels";
        RowMapper<HourlyElectricity> rowMapper = new BeanPropertyRowMapper<HourlyElectricity>(HourlyElectricity.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Iterable<HourlyElectricity> findAll() {
        String sql = "select * from panels";
        RowMapper<HourlyElectricity> rowMapper = new BeanPropertyRowMapper<HourlyElectricity>(HourlyElectricity.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
    public Iterable<HourlyElectricity> findAll(Iterable<Long> itrbl) {
        
        String sql = "select * from panels where id in () ";
        RowMapper<HourlyElectricity> rowMapper = new BeanPropertyRowMapper<HourlyElectricity>(HourlyElectricity.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public HourlyElectricity save(HourlyElectricity p) {
        String sql = "INSERT INTO eletricty (id, panel) values (?, ?)";
        jdbcTemplate.update(sql, p.getId());
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
public Page<HourlyElectricity> findAllByPanelIdOrderByReadingAtDesc(Long panelId, Pageable pageable) 
{
        String sql = "select * from eletricty where panel_id  = ? ";
        RowMapper<HourlyElectricity> rowMapper = new BeanPropertyRowMapper<HourlyElectricity>(HourlyElectricity.class);
        return null;
}
}
