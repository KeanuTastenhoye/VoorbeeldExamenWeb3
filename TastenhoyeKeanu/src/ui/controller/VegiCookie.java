package ui.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VegiCookie extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String veggie = request.getParameter("veggie");
        Cookie cookie = new Cookie("vegi", veggie);

        response.addCookie(cookie);

        return "Controller?action=NaarIndex";
    }
}
