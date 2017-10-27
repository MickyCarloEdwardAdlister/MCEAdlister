package Daos;

public class Config {
    private static String url = "jdbc:mysql://localhost/mce_db?serverTimezone=UTC";
    private static String username = "mce";
    private static String password = "mce";

    public static void setUrl(String url){
        Config.url = url;
    }
    public static void setUsername(String username){
        Config.username = username;
    }
    public static void setPassword(String password){
        Config.password = password;
    }
    public static String getUrl(){
        return url;
    }
    public static String getUsername(){
        return username;
    }
    public static String getPassword(){
        return password;
    }
}
