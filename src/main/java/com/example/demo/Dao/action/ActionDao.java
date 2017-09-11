package com.example.demo.Dao.action;

import com.example.demo.entity.dataModel.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yang on 2017/8/12.
 */
public interface ActionDao extends JpaRepository<Action,Integer>{
    public Action getActionById(int id);
    public Action getActionByAction_name(String action_name);
    public List<Action> getActionsByIdNotNull();
}
