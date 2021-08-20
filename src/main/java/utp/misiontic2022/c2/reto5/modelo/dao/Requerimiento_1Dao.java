package utp.misiontic2022.c2.reto5.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.c2.reto5.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.reto5.util.JDBCUtilities;

public class Requerimiento_1Dao 
{
    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException 
    {
        var connection = JDBCUtilities.getConnection();
        var response = new ArrayList<Requerimiento_1>();
        var sql = "SELECT mc.Nombre_Material , mc.Precio_Unidad "+
                        "FROM MaterialConstruccion mc "+
                        "WHERE mc.Importado = 'Si' "+
                        "ORDER BY mc.Precio_Unidad DESC";
        PreparedStatement stmt = null;
        ResultSet rSet = null;

        try
        {
            stmt = connection.prepareStatement(sql);
            rSet = stmt.executeQuery();

            while(rSet.next())
            {
                var requerimiento1VO = new Requerimiento_1();
                requerimiento1VO.setNombreMaterial(rSet.getString("Nombre_Material"));
                requerimiento1VO.setPrecioUnidad(rSet.getInt("Precio_Unidad"));

                response.add(requerimiento1VO);
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