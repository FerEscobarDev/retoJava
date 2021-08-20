package utp.misiontic2022.c2.reto5.modelo.vo;

public class Requerimiento_3 {
    String proveedor;
    String nombreMaterial;
    String importado;
    int precioUnidad;
    int cantidad;

    public String getProveedor()
    {
        return proveedor;
    }

    public void setProveedor(String proveedor)
    {
        this.proveedor = proveedor;
    }

    public String getNombreMaterial()
    {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial)
    {
        this.nombreMaterial = nombreMaterial;
    }

    public String getImportado()
    {
        return importado;
    }

    public void setImportado(String importado)
    {
        this.importado = importado;
    }

    public int getPrecioUnidad()
    {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad)
    {
        this.precioUnidad = precioUnidad;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }
}
