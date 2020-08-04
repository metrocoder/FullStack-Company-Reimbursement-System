package dev.edwin.services;

import dev.edwin.daos.ManagerDAO;
import dev.edwin.entities.Manager;

import javax.inject.Inject;
import java.util.List;

public class ManagerServiceImp implements ManagerService {

    @Inject
    private ManagerDAO mdao;


    private static ManagerService mserv = null;

    private ManagerServiceImp() {
        super();
    }

    public static ManagerService getMserv() {
        if (mserv == null)
            mserv = new ManagerServiceImp();

        return mserv;
    }

    @Override
    public Manager createManager(Manager manager) {
        return mdao.createManager(manager);
    }

    @Override
    public Manager getManagerById(int mgid) {
        return mdao.getManagerById(mgid);
    }

    @Override
    public Manager getManagerByEmail(String email) {
        return mdao.getManagerByEmail(email);
    }

    @Override
    public Manager getManagerByName(String name) {
        return mdao.getManagerByName(name);
    }

    @Override
    public List<Manager> getAllManagers() {
        return mdao.getAllManagers();
    }


    @Override
    public Manager updateManager(Manager manager) {
        return mdao.updateManager(manager);
    }

    @Override
    public boolean deleteManager(Manager manager) {
        return mdao.deleteManager(manager);
    }
}
