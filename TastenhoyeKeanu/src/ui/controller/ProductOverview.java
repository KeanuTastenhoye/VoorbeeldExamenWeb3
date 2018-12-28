package ui.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductOverview extends RequestHandler {
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
            request.setAttribute("products", getProductService().allVegetarianProducts());
        }
        else if (cooky.equals("neen")) {
            request.setAttribute("products", getProductService().allNonVegetarianProducts());
        }
        else {
            request.setAttribute("products", getProductService().getAll());
        }
        return "products.jsp";
    }
}
