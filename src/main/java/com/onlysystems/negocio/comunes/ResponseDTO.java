package com.onlysystems.negocio.comunes;

public class ResponseDTO {



    private int codigo;

    private String mensaje;

    private Object data;

    public ResponseDTO() {

    }

    public ResponseDTO(int codigo, String mensaje, Object data) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
