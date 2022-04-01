package Config;

public class Config {
    private static int port = 8080;
    private static String host = "localhost";
    private static String nameFileSave = "resultCommands";
    private static String nameFileSQLLite = "resultCommands";
    private static String nameTableSQL = "results";
    private static boolean saveFile = false;
    private static boolean saveDB = false;

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Config.port = port;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        Config.host = host;
    }

    public static String getNameFileSave() {
        return nameFileSave;
    }

    public static void setNameFileSave(String nameFileSave) {
        Config.nameFileSave = nameFileSave;
    }

    public static String getNameFileSQLLite() {
        return nameFileSQLLite;
    }

    public static void setNameFileSQLLite(String nameFileSQLLite) {
        Config.nameFileSQLLite = nameFileSQLLite;
    }

    public static String getNameTableSQL() {
        return nameTableSQL;
    }

    public static void setNameTableSQL(String nameTableSQL) {
        Config.nameTableSQL = nameTableSQL;
    }

    public static boolean isSaveFile() {
        return saveFile;
    }

    public static void setSaveFile(boolean saveFile) {
        Config.saveFile = saveFile;
    }

    public static boolean isSaveDB() {
        return saveDB;
    }

    public static void setSaveDB(boolean saveDB) {
        Config.saveDB = saveDB;
    }
}
