package Application;

import Repository.Impl.ProducrepositoryImpl;
import Repository.Impl.ProductrepositoryImpl;
import Repository.Impl.Repository;
import model.ConnectionDatabase;
import Repository.ProductrepositoryImpl;
import model.Product;

import java.sql.Connection;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) {
        try (Connection conn = ConnectionDatabase.getInstance()){
            Repository<Product> repository = (Repository<Product>) new ProductrepositoryImpl();
            System.out.println("~~~~ List Products for Database ~~~~");
            repository.list().stream().forEach(System.out::println);
            System.out.println("~~~~ Get by Id : 1 ~~~~");
            System.out.println(repository.byId(1).toString());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
