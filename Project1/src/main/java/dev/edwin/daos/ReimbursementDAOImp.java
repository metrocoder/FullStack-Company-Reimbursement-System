package dev.edwin.daos;

import dev.edwin.entities.Reimbursement;
import dev.edwin.utils.ConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImp implements ReimbursementDAO {

    private static ReimbursementDAO rdao = null;

    private ReimbursementDAOImp()
    {super();}

    public static ReimbursementDAO getRdao(){
        if (rdao == null)
            rdao = new ReimbursementDAOImp();

        return rdao;
    }


    @Override
    public Reimbursement createReimbursement(Reimbursement reimbursement)
    {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO project1_db.REIMBURSEMENT VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, 0);
            ps.setDouble(2, reimbursement.getAmount());
            ps.setString(3, reimbursement.getSubmit_date().toString());
            ps.setInt(4, reimbursement.getStatus());
            ps.setString(5, reimbursement.getStatus_date().toString());
            ps.setString(6, reimbursement.getEmployee_note());
            ps.setString(7, reimbursement.getManager_note());
            ps.setInt(8, reimbursement.getCid());
            ps.setInt(9, reimbursement.getEid());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("rid");
            reimbursement.setRid(key);

            return reimbursement;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reimbursement getReimbursementById(int rid)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM project1_db.REIMBURSEMENT WHERE rid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rid);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Reimbursement reimbursement = new Reimbursement();
            reimbursement.setAmount(rs.getFloat("amount"));
            reimbursement.setSubmit_date(rs.getString("submit_date"));
            reimbursement.setStatus(rs.getInt("status"));
            reimbursement.setStatus_date(rs.getString("status_date"));
            reimbursement.setEmployee_note(rs.getString("employee_note"));
            reimbursement.setManager_note(rs.getString("manager_note"));
            reimbursement.setCid(rs.getInt("cid"));
            reimbursement.setEid(rs.getInt("eid"));
            reimbursement.setRid(rs.getInt("rid"));


            return reimbursement;

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reimbursement> getAllReimbursement()
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM project1_db.REIMBURSEMENT";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
            Reimbursement reimbursement;
            while (rs.next()){
                reimbursement = new Reimbursement();
                reimbursement.setAmount(rs.getFloat("amount"));
                reimbursement.setSubmit_date(rs.getString("submit_date"));
                reimbursement.setStatus(rs.getInt("status"));
                reimbursement.setStatus_date(rs.getString("status_date"));
                reimbursement.setEmployee_note(rs.getString("employee_note"));
                reimbursement.setManager_note(rs.getString("manager_note"));
                reimbursement.setCid(rs.getInt("cid"));
                reimbursement.setEid(rs.getInt("eid"));
                reimbursement.setRid(rs.getInt("rid"));


                reimbursements.add(reimbursement);
            }

            return reimbursements;

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Reimbursement updateReimbursement(Reimbursement reimbursement)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "UPDATE REIMBURSEMENT SET amount=?,status=?,status_date=?,employee_note=?,manager_note=?,cid=?,eid=? WHERE rid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, reimbursement.getAmount());
//            ps.setString(2, reimbursement.getSubmit_date().toString());
            ps.setInt(2, reimbursement.getStatus());
            ps.setString(3, reimbursement.getStatus_date().toString());
            ps.setString(4, reimbursement.getEmployee_note());
            ps.setString(5, reimbursement.getManager_note());
            ps.setInt(6, reimbursement.getCid());
            ps.setInt(7, reimbursement.getEid());
            ps.setInt(8, reimbursement.getRid());

            if(ps.executeUpdate() > 0)
            {
                return reimbursement;
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteReimbursement(Reimbursement reimbursement)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "DELETE FROM project1_db.REIMBURSEMENT WHERE rid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbursement.getRid());

            if(ps.executeUpdate() > 0)
            {
                return true;
            }

            return false;

        }catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
