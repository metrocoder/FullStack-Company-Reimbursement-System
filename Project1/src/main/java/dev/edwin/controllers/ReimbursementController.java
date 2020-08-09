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
        String employee = ctx.queryParam("employeeId");
        String category = ctx.queryParam("categoryId");
        String manager = ctx.queryParam("managerId");
        String approvalStatus = ctx.queryParam("approval");
        String sortAmount = ctx.queryParam("sort_amount");
        String sortStatusDate = ctx.queryParam("sort_status_date");
        String sortSubmitDate = ctx.queryParam("sort_submit_date");

        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        if (employee != null)
        {
            reimbursements = rserv.getReimbursementByEmployee(Integer.parseInt(employee));
        }
        else if (category != null)
        {
            reimbursements = rserv.getReimbursementByCategory(Integer.parseInt(category));
        }
        else if (manager != null)
        {
            reimbursements = rserv.getReimbursementByManager(Integer.parseInt(manager));
        }
        else if(approvalStatus != null)
        {
            if (approvalStatus.compareToIgnoreCase("APPROVED") == 0)
                reimbursements = rserv.getReimbursementsApproved();

            if (approvalStatus.compareToIgnoreCase("PENDING") == 0)
                reimbursements = rserv.getReimbursementsDenied();
        }
        else if (sortAmount != null)
        {
            if(sortAmount.compareToIgnoreCase("ASC") == 0)
                reimbursements = rserv.getReimbursementsAmountAscending();

            if (sortAmount.compareToIgnoreCase("DESC") == 0)
                reimbursements = rserv.getReimbursementsAmountDescending();
        }
        else if (sortStatusDate != null)
        {
            if (sortStatusDate.compareToIgnoreCase("DESC") == 0)
                reimbursements = rserv.getReimbursementsStatusDateAscending();

            if (sortStatusDate.compareToIgnoreCase("ASC") == 0)
                reimbursements = rserv.getReimbursementsStatusDateDescending();
        }
        else if (sortSubmitDate != null)
        {
            if (sortSubmitDate.compareToIgnoreCase("DESC") == 0)
                reimbursements = rserv.getReimbursementsSubmitDateAscending();

            if (sortSubmitDate.compareToIgnoreCase("ASC") == 0)
                reimbursements = rserv.getReimbursementsSubmitDateDescending();
        }
        else
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
