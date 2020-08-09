package dev.edwin.controllers;

import com.google.gson.Gson;
import dev.edwin.entities.ExpenseCategory;
import dev.edwin.services.ExpenseCategoryService;
import dev.edwin.services.ExpenseCategoryServiceImp;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class ExpenseCategoryController {
    private static ExpenseCategoryService ecserv = ExpenseCategoryServiceImp.getEserv();
    private static Gson gson = new Gson();

    public static Handler createExpenseCategory = (ctx) ->
    {
        String body = ctx.body();


        try
        {
            ExpenseCategory expenseCategory = gson.fromJson(body, ExpenseCategory.class);
            if(expenseCategory != null) {
                ExpenseCategory returned = ecserv.createExpenseCategory(expenseCategory);
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

    public static Handler getExpenseCategoryById = (ctx) -> {
        String cid = ctx.pathParam("cid");

        try
        {
            ExpenseCategory expenseCategory = ecserv.getExpenseCategoryById(Integer.parseInt(cid));
            String json = gson.toJson(expenseCategory);
            ctx.result(json);
            ctx.status(200);
        } catch (NumberFormatException e)
        {
            ctx.status(404);
            e.printStackTrace();
        }
    };

    public static Handler getAllExpenseCategories = (ctx) -> {
        String title = ctx.queryParam("title");

        List<ExpenseCategory> expenseCategories = new ArrayList<ExpenseCategory>();

        if(title != null)
        {
            expenseCategories.add( ecserv.getExpenseCategoryByTitle(title));
        }
        else
            expenseCategories = ecserv.getAllExpenseCategories();

        String json = gson.toJson(expenseCategories);
        ctx.result(json);
        ctx.status(200);
    };


    public static Handler updateExpenseCategory = (ctx) -> {
        String body = ctx.body();
        ExpenseCategory expenseCategory = gson.fromJson(body, ExpenseCategory.class);
        ExpenseCategory result = ecserv.updateExpenseCategory(expenseCategory);

        ctx.result(gson.toJson(result));
        ctx.status(202);

    };

    public static Handler deleteExpenseCategory = (ctx) -> {
        String body = ctx.body();
        ExpenseCategory expenseCategory = gson.fromJson(body, ExpenseCategory.class);
        try
        {
            boolean result = ecserv.deleteExpenseCategory(expenseCategory);

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
