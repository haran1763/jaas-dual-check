import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

public class Authenticate extends HttpServlet{
    static Map<String,String> details = new HashMap<>();
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{

        System.out.println(DaLoginModule.auth.get(req.getParameter("j_username")).get(0).getName());


        if(DaLoginModule.auth.get(req.getParameter("j_username")).get(0)==null){
            res.sendRedirect("/sample/loginerr.jsp");
        }
        else{
            // tname = req.getParameter("tname");
            System.out.println("[+] inside authenticate servlet " + req.getParameter("tname") );
            if(req.getParameter("tname").equals("/sample/Admin/admin.html")){
                details.put(req.getParameter("j_username"), "admin");
            }
            else if(req.getParameter("tname").equals("/sample/Doctors")){
                details.put(req.getParameter("j_username"), "doctors");
            }
            else if(req.getParameter("tname").equals("/sample/appointment.jsp")){
                details.put(req.getParameter("j_username"), "patient");
            }
            System.out.println("[+] inside authenticate servlet tname " + req.getParameter("j_username"));
            
            req.getRequestDispatcher("/Admin/OTP.jsp").include(req, res);
        }
}
}