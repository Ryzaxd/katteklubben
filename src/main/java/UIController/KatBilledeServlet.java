package UIController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entiteter.Kæledyr;
import entiteter.Medlem;

import java.io.*;
import java.util.ArrayList;

@WebServlet("/catImage")
public class KatBilledeServlet extends HttpServlet {

    private KatController katController = new KatController(catRepository);
    private Medlem medlem = new Medlem();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int kid = Integer.parseInt(request.getParameter("kid"));
        int logged_medlem_id = medlem.getMid();

        ArrayList<Kæledyr> katte_liste = katController.getAllCatsForUser(logged_medlem_id);


        String filePath = null;
        for(Kæledyr kat : katte_liste) {
            if(kat.getKid() == kid) {
                filePath = kat.getBilledePath();
                break;
            }
        }

        if(filePath != null) {
            response.setContentType("image/jpeg");

            OutputStream out = response.getOutputStream();

            InputStream in = new FileInputStream(new File(filePath));

            byte[] buffer = new byte[4096];
            int length;
            while((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.flush();
            out.close();

        }
    }

}
