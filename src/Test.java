import WeatherAPIWorker.WeatherWorker;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) throws AWTException, InterruptedException {
        WeatherWorker worker = new WeatherWorker();
        worker.getInfo();
        /*if(SystemTray.isSupported()){
            SystemTray tray = SystemTray.getSystemTray();
            Image image = new ImageIcon("world.png").getImage();
            TrayIcon trayIcon = new TrayIcon(image,"MyTest",createPopupMenu());
            tray.add(trayIcon);
            while (true){
                trayIcon.displayMessage("Hi!","Today is a very beautiful day",TrayIcon.MessageType.NONE);

                //I want to display message every 3 hours
                Thread.sleep(10800000 );
            }
        } else{
            JOptionPane.showMessageDialog(null,"Your system does not support System Tray");
        }*/
    }
    static private PopupMenu createPopupMenu(){
        PopupMenu menu = new PopupMenu();
        MenuItem exit = new MenuItem();
        exit.setLabel("Close");
        menu.add(exit);
        menu.addActionListener((e)->System.exit(0));
        return menu;
    }
}
