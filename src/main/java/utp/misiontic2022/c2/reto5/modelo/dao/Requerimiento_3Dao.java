package utp.misiontic2022.c2.reto5.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.c2.reto5.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.reto5.util.JDBCUtilities;

public class Requerimiento_3Dao 
{
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException 
    {
        var connection = JDBCUtilities.getConnection();
        var response = new ArrayList<Requerimiento_3>();
        var sql = "SELECT c.Proveedor , mc.Nombre_Material , mc.Importado, mc.Precio_Unidad, SUM(c.Cantidad) as Cantidad "+
                    "FROM MaterialConstruccion mc "+
                    "JOIN Compra c ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion "+
                    "WHERE mc.Importado = 'Si' AND c.Proveedor = 'Homecenter' "+
                    "GROUP BY c.Proveedor , mc.ID_MaterialConstruccion "+
                    "ORDER BY c.Proveedor , mc.Nombre_Material";
        PreparedStatement stmt = null;
        ResultSet rSet = null;

        try
        {
            stmt = connection.prepareStatement(sql);
            rSet = stmt.executeQuery();
            
            while(rSet.next())
            {
                var requerimiento3VO = new Requerimiento_3();
                requerimiento3VO.setProveedor(rSet.getString("Proveedor"));
                requerimiento3VO.setNombreMaterial(rSet.getString("Nombre_Material"));
                requerimiento3VO.setImportado(rSet.getString("Importado"));
                requerimiento3VO.setPrecioUnidad(rSet.getInt("Precio_Unidad"));
                requerimiento3VO.setCantidad(rSet.getInt("Cantidad"));

                response.add(requerimiento3VO);
            }
        }
        finally
        {
            if(rSet != null)
            {
                rSet.close();
            }
            if(stmt != null)
            {
                stmt.close();
            }
            if(connection != null)
            {
                connection.close();
            }
        }

        return response;
    }
}