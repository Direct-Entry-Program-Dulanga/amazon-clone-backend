package lk.ijse.amazonclonebackend.api;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jakarta.annotation.Resource;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lk.ijse.amazonclonebackend.dto.ItemDTO;
import lk.ijse.amazonclonebackend.service.ItemService;

import javax.sql.DataSource;

@WebServlet(name = "itemServlet", value = "/items", loadOnStartup = 0)
public class ItemServlet extends HttpServlet {


    @Resource(name = "java:comp/env/jdbc/amazon")
    private DataSource dataSource;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Connection connection = dataSource.getConnection();
            ItemService itemService = new ItemService(connection);

            List<ItemDTO> items = itemService.getAllItems();

            Jsonb jsonb = JsonbBuilder.create();
            response.setContentType("application/json");

            response.getWriter().println(jsonb.toJson(items));

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to obtain a new connection", e);
        }
    }

    public void destroy() {
    }
}