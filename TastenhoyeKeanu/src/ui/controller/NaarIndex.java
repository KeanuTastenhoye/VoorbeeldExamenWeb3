package ui.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NaarIndex extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String cooky = "";
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("vegi")) {
                    cooky = cookie.getValue();
                }
            }
        }

        if (cooky.equals("ja")) {
            request.setAttribute("vegi", "Je bent momenteel vegetarisch!");
        }
        else if (cooky.equals("neen")) {
            request.setAttribute("vegi", "Je bent momenteel niet vegetarisch!");
        }
        else {
            request.setAttribute("vegi", "");
        }

        return "index.jsp";
    }
}
