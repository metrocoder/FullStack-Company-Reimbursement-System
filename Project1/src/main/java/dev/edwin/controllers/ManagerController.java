package dev.edwin.controllers;

import com.google.gson.Gson;
import dev.edwin.entities.Manager;
import dev.edwin.entities.Manager;
import dev.edwin.services.ManagerService;
import dev.edwin.services.ManagerServiceImp;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class ManagerController 
{
    private static ManagerService mserv = ManagerServiceImp.getMserv();
    private static Gson gson = new Gson();

    public static Handler createManager = (ctx) ->
    {
        String body = ctx.body();


        try
        {
            Manager manager = gson.fromJson(body, Manager.class);
            if(manager != null) {
                Manager returned = mserv.createManager(manager);
                ctx.result(gson.toJson(returned));
                ctx.status(200);
            }
            else
                ctx.status(404);


        }catch (Exception e)
        {
            ctx.status(404);
            e.printStackTrace();
        }

    };

    public static Handler getManagerById = (ctx) -> {
        String mid = ctx.pathParam("mid");

        try
        {
            Manager manager = mserv.getManagerById(Integer.parseInt(mid));
            String json = gson.toJson(manager);
            ctx.result(json);
            ctx.status(200);
        } catch (NumberFormatException e)
        {
            ctx.status(404);
            e.printStackTrace();
        }
    };

    public static Handler getAllManagers = (ctx) -> {
//		Can have query to search
        String name = ctx.queryParam("name");
        String email = ctx.queryParam("email");


        List<Manager> managers = new ArrayList<Manager>();

        if(name != null)
        {
            managers.add(mserv.getManagerByName(name));
        }
        else if (email != null)
        {
            managers.add(mserv.getManagerByEmail(email));
        }
        else
        {
            managers = mserv.getAllManagers();
        }

        String json = gson.toJson(managers);
        ctx.result(json);
        ctx.status(200);
    };


    public static Handler updateManager = (ctx) -> {
        String body = ctx.body();
        Manager manager = gson.fromJson(body, Manager.class);
        Manager result = mserv.updateManager(manager);

        ctx.result(gson.toJson(result));
        ctx.status(202);

    };

    public static Handler deleteManager = (ctx) -> {
        String body = ctx.body();
        Manager manager = gson.fromJson(body, Manager.class);
        try
        {
            boolean result = mserv.deleteManager(manager);

            if(result)
                ctx.status(200);
            else
                ctx.status(404);
        }catch(NumberFormatException e)
        {
            ctx.status(404);
            e.printStackTrace();
        }
    };
}
