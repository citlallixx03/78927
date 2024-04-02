package mx.uv;
import static spark.Spark.*;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class AppWS 
{
    public static void main( String[] args ){
        
        /*get("/", (request, response) -> {
            String respuesta= "<hola><hola/>";
            response.type("aplication/xml");
            return respuesta;
        });*/

        /*get("xml", (req, res)-> {
            Alumno respuesta= new Alumno();
            respuesta.setNombre("Sebastian");
            respuesta.setId(7);
            res.type("aplication/xml");
            //return "<nombre>"+respuesta.getNombre()+"</nombre>";
        });*/
        
        
        get("/", (req, res)->{
            String respuesta = "<note>\n" + //
                                "  <to>Tove</to>\n" + //
                                "  <from>Jani</from>\n" + //
                                "  <heading>Reminder</heading>\n" + //
                                "  <body>Don't forget me this weekend!</body>\n" + //
                                "</note>";
            res.type("application/xml");
            return respuesta;
        });

        get("/xml", (req, res)->{
            Alumno alumno = new Alumno();
            alumno.setNombre("Sebastian");
            alumno.setId("7");

            XmlMapper xml = new XmlMapper();
            String respuesta = xml.writeValueAsString(alumno);

            res.type("application/xml");
            //return "<nombre>" + alumno.getNombre() +"</nombre>";
            return respuesta;
        });
    }
}

class Alumno {
    String nombre;
    String apellido;
    String id;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}