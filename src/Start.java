import ApplicationPack.TrayAPP;

/**
 * @author Andrii Hurniak
 */
public class Start {
    private  static TrayAPP application;

    /**
     * The main method,
     * start point of the program
     * @param args
     */
    public static void main(String[] args) {
        application = new TrayAPP();
        try {
            application.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
