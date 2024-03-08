package mx.uv;
import static spark.Spark.*;



/**
 * Hello world!
 *
 */
public class AppWS 
{
    public static void main( String[] args ){
        
        get("/", (request, response) -> {
            return "hello word";
        });
        
    }


}
