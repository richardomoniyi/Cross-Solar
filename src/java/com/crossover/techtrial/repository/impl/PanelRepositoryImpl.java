/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.techtrial.repository.impl;

import com.crossover.techtrial.model.Panel;
import com.crossover.techtrial.repository.PanelRepository;
import com.crossover.techtrial.util.PanelDAOUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author thefavourofpraise
 */
public class PanelRepositoryImpl implements PanelRepository{

    @Override
    public Panel findBySerial(String serial) {
        return new PanelDAOUtil().findPanel(serial);
        
    }

    @Override
    public Iterable<Panel> findAll(Sort sort) {
        return new PanelDAOUtil().findAll(sort);
    }

    @Override
    public Page<Panel> findAll(Pageable pgbl) {
        return null;
    }

    @Override
    public <S extends Panel> S save(S s) {
        return null;
    }

    @Override
    public <S extends Panel> Iterable<S> save(Iterable<S> itrbl) {
        return null;
    }

    @Override
    public Panel findOne(Long id) {
        return new PanelDAOUtil().findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return new PanelDAOUtil().exist(id);
    }

    @Override
    public Iterable<Panel> findAll() {
        return new PanelDAOUtil().findAll();
    }

    @Override
    public Iterable<Panel> findAll(Iterable<Long> itrbl) {
        return new PanelDAOUtil().findAll(itrbl);
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Panel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Iterable<? extends Panel> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
