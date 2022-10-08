package com.kosec.springbootjdbc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.kosec.springbootjdbc.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class jdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @RequestMapping(value = "/insert",method =  RequestMethod.POST)
    public String index(@RequestBody User user) {

        jdbcTemplate.execute("insert into user values("+user.getId()+",'"+user.getUnm()+"','"+user.getEmail()+"')");
        return "Record Added Successfully : "+user.toString();
        
    }

    @GetMapping("/fetch")
    public List<Map<String, Object>> fetch(){
        List<Map<String, Object>> a = jdbcTemplate.queryForList("select * from user");
        return a;
    }
    
    @GetMapping("/delete/{id}")
    public String deleteRecord(@PathVariable(value = "id") int id) {
        jdbcTemplate.execute("delete from user where id="+id);
        return "Record Deleted";
    }

    @PutMapping("/update/{id}")
    public String updateRecord(@PathVariable(value = "id") int id,@RequestBody Map<String,String> user) {
        jdbcTemplate.execute("update user set "+user.get("col")+"='"+user.get("value")+"' where id="+id);
        return "Record updated successfully..!";
    }
}
