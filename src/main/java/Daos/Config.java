package Daos;

public class Config {
    private static String url = "jdbc:mysql://localhost/mce_db?serverTimezone=UTC";
    private static String username = "mce";
    private static String password = "mce";
  
    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
