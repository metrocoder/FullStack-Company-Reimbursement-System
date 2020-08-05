package dev.edwin.controllers;

import com.google.gson.Gson;
import dev.edwin.entities.Reimbursement;
import dev.edwin.entities.Reimbursement;
import dev.edwin.services.ReimbursementService;
import dev.edwin.services.ReimbursementServiceImp;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementController {
    private static ReimbursementService rserv = ReimbursementServiceImp.getRserv();
    private static Gson gson = new Gson();

    public static Handler createReimbursement = (ctx) ->
    {
        String body = ctx.body();


        try
        {
            Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
            if(reimbursement != null) {
                Reimbursement returned = rserv.createReimbursement(reimbursement);
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

    public static Handler getReimbursementById = (ctx) -> {
        String rid = ctx.pathParam("rid");

        try
        {
            Reimbursement reimbursement = rserv.getReimbursementById(Integer.parseInt(rid));
            String json = gson.toJson(reimbursement);
            ctx.result(json);
            ctx.status(200);
        } catch (NumberFormatException e)
        {
            ctx.status(404);
            e.printStackTrace();
        }
    };

    public static Handler getAllReimbursements = (ctx) -> {
//		Can have query to search 
        String name = ctx.queryParam("name");
        String email = ctx.queryParam("email");


        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

        reimbursements = rserv.getAllReimbursement();


        String json = gson.toJson(reimbursements);
        ctx.result(json);
        ctx.status(200);
    };


    public static Handler updateReimbursement = (ctx) -> {
        String body = ctx.body();
        Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
        Reimbursement result = rserv.updateReimbursement(reimbursement);

        ctx.result(gson.toJson(result));
        ctx.status(202);

    };

    public static Handler deleteReimbursement = (ctx) -> {
        String body = ctx.body();
        Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
        try
        {
            boolean result = rserv.deleteReimbursement(reimbursement);

            if(result == true)
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
