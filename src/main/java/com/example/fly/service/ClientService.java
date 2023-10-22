package com.example.fly.service;

import com.example.fly.hiber.HibernateUtil;
import dao.AgentDao;
import entity.Clients;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientService {
    private AgentDao agentDao;
    public ClientService(AgentDao agentDao){
        this.agentDao = agentDao;
    }
    public boolean saveClient(Clients client) {
        boolean result = false;
        result = agentDao.saveClient(client);
        return result;
    }
}
