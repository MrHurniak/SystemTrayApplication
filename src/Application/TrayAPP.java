package Application;

import WeatherAPIWorker.WeatherWorker;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class TrayAPP {
    //todo In my OS some problems with tray icons!!!
    //todo make a normal exception catching

    private PropWorker propWorker;
    private TrayIcon trayIcon;
    private WeatherWorker weatherWorker;

    public TrayAPP() {
        this.propWorker = new PropWorker();
        this.weatherWorker = new WeatherWorker();
    }

    public void start()throws Exception{
        if(SystemTray.isSupported()){
            SystemTray tray = SystemTray.getSystemTray();
            tray.add(createTrayIcon());
            greeting();
        } else{
            JOptionPane.showMessageDialog(null,"Your system does not support System Tray");
        }
    }
    static private PopupMenu createPopupMenu(){
        PopupMenu menu = new PopupMenu();
        MenuItem exit = new MenuItem();
        MenuItem setting = new MenuItem();
        exit.setLabel("Close");
        setting.setLabel("Setting");
        menu.add(setting);
        menu.add(exit);
        exit.addActionListener(e -> System.exit(0));
        setting.addActionListener(e ->
                SwingUtilities.invokeLater(
                        ()-> new SettingWindow()));
        return menu;
    }
    private TrayIcon createTrayIcon(){
        Image image = new ImageIcon(propWorker.getTrayImage()).getImage();
         trayIcon = new TrayIcon(image,"MyTest",createPopupMenu());
        trayIcon.addActionListener(e -> System.out.println(e.getActionCommand()));
        return trayIcon;
    }
    private void greeting(){
        //todo it would be better if app will make greeting according to day time
        trayIcon.displayMessage("Hello!",weatherWorker.getWeather(),TrayIcon.MessageType.NONE);
    }
}
