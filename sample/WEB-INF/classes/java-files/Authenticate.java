import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

public class Authenticate extends HttpServlet{
    static Map<String,String> details = new HashMap<>();
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{

        try {
            
            if(DaLoginModule.data.get(req.getParameter("j_username"))){


            System.out.println("[+] inside authenticate servlet " + req.getParameter("tname") );
            if(req.getParameter("tname").equals("/sample/Admin/admin.html")){
                details.put(req.getParameter("j_username"), "admin");
                DaLoginModule.data.remove(req.getParameter("j_username"));
            }
            else if(req.getParameter("tname").equals("/sample/Doctors")){
                details.put(req.getParameter("j_username"), "doctors");
                DaLoginModule.data.remove(req.getParameter("j_username"));
            }
            else if(req.getParameter("tname").equals("/sample/appointment.jsp")){
                details.put(req.getParameter("j_username"), "patient");
                DaLoginModule.data.remove(req.getParameter("j_username"));
            }
            System.out.println("[+] inside authenticate servlet tname " + req.getParameter("j_username"));

            
        }        
        else{
            // tname = req.getParameter("tname");
            res.sendRedirect("/sample/loginerr.jsp");
            
        }
        req.getRequestDispatcher("/Admin/OTP.jsp").include(req, res);
        
    } catch (Exception e) {
        res.sendRedirect("/sample/loginerr.jsp");
    }
}
}