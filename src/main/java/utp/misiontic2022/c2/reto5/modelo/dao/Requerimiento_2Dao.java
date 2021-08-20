package utp.misiontic2022.c2.reto5.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.c2.reto5.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.reto5.util.JDBCUtilities;

public class Requerimiento_2Dao 
{
    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException 
    {
        var connection = JDBCUtilities.getConnection();
        var response = new ArrayList<Requerimiento_2>();
        var sql = "SELECT DISTINCT p.Constructora , p.Ciudad "+
                        "FROM Proyecto p "+
                        "WHERE p.Ciudad LIKE 'B%' "+
                        "ORDER BY p.Ciudad";
        PreparedStatement stmt = null;
        ResultSet rSet = null;

        try
        {
            stmt = connection.prepareStatement(sql);
            rSet = stmt.executeQuery();

            while(rSet.next())
            {
                var requerimiento2VO = new Requerimiento_2();
                requerimiento2VO.setContructora(rSet.getString("Constructora"));
                requerimiento2VO.setCiudad(rSet.getString("Ciudad"));

                response.add(requerimiento2VO);
            }
        }
        finally
        {
            if(rSet != null){
                rSet.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(connection != null){
                connection.close();
            }
        }

        return response;
    }
}