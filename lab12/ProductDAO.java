package lab12;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        // Подгрузка драйвера БД Derby
        Class.forName("org.h2.Driver");
        // Получение соединения с БД
        return DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/~/test;user=sa;password=");
    }

    public List<Product> getProductById(int id) throws Exception {
        List<Product> products = new ArrayList<>();
        // Получение соединения с БД
        try (Connection con = getConnection();

             // Подготовка SQL-запроса
             PreparedStatement st = con.prepareStatement(
                     "Select description, rate, quantity " +
                             "From products " +
                             "Where id = ?");) {
            // Указание значений параметров запроса
            st.setInt(1, id);

            // Выполнение запроса
            ResultSet rs = st.executeQuery();

            // Перечисляем результаты выборки
            while (rs.next()) {
                // Из каждой строки выборки выбираем результаты,
                // формируем новый объект Product
                // и помещаем его в коллекцию
                Product product = new Product(
                        id,
                        rs.getString(1),
                        rs.getFloat(2),
                        rs.getInt(3));
                products.add(product);
            }
        }

        return products;
    }

    public void addProduct(Product product) throws Exception {
        // Получение соединения с БД
        try (Connection con = getConnection();

        // Подготовка SQL-запроса
        PreparedStatement st = con.prepareStatement(
                "Insert into products " +
                        "(id, description, rate, quantity) " +
                        "values (?, ?, ?, ?)");) {
            // Указание значений параметров запроса
            st.setInt(1, product.getId());
            st.setString(2, product.getDescription());
            st.setFloat(3, product.getRate());
            st.setInt(4, product.getQuantity());

            // Выполнение запроса
            st.executeUpdate();
        }
    }

    public void setProduct(Product product) throws Exception {
        // Получение соединения с БД
        try (Connection con = getConnection();

        // Подготовка SQL-запроса
        PreparedStatement st = con.prepareStatement(
                "Update products " +
                        "Set description=?, rate=?, quantity=? " +
                        "Where id=?");) {
            // Указание значений параметров запроса
            st.setString(1, product.getDescription());
            st.setFloat(2, product.getRate());
            st.setInt(3, product.getQuantity());
            st.setInt(4, product.getId());

            // Выполнение запроса
            st.executeUpdate();
        }
    }

    public void removeProduct(int id) throws Exception {
        // Получение соединения с БД
        try (Connection con = getConnection();

        // Подготовка SQL-запроса
        PreparedStatement st = con.prepareStatement(
                "Delete from products " +
                        "Where id = ?");) {
            // Указание значений параметров запроса
            st.setInt(1, id);

            // Выполнение запроса
            st.executeUpdate();
        }
    }

}
