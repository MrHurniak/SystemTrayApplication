package ApplicationPack;

import ApplicationPack.FullInfoGUI.InfoWindow;
import WeatherAPIWorker.WeatherWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class TrayAPP {
    //todo make a normal exception catching
    private int DELAY = 3;
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
            startMessaging();
        } else{
            JOptionPane.showMessageDialog(null,"Your system does not support System Tray");
        }
    }

    @Deprecated
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
        JPopupMenu jPopup = createJPopup();
        Image image = new ImageIcon(propWorker.getTrayImage()).getImage();
         trayIcon = new TrayIcon(image,"MyTest"/*,createPopupMenu()*/);
        trayIcon.addActionListener(e -> {
            new InfoWindow(weatherWorker);
            System.out.println("Action. Open full info window.");

        });

        //Do like this, because I want to have JPopupMenu instead PopupMenu
        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger()){
                    jPopup.setLocation(e.getX(),e.getY());
                    jPopup.setInvoker(jPopup);
                    jPopup.setVisible(true);
                }
            }
        });
        return trayIcon;
    }


    //todo тут є якийсь баг, вроді пофіксив
    private void startMessaging(){
        weatherWorker.renew();
        trayIcon.displayMessage(weatherWorker.getCity(),weatherWorker.getWeather(),TrayIcon.MessageType.NONE);

        try {
            Thread.sleep(milisToAction(DELAY));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){
            weatherWorker.renew();
            trayIcon.displayMessage(weatherWorker.getCity(),weatherWorker.getWeather(),TrayIcon.MessageType.NONE);
            try {
                Thread.sleep(TimeUnit.MILLISECONDS.convert(DELAY,TimeUnit.HOURS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long milisToAction(int hours){

        if(hours>24 || hours <0){ throw new IllegalArgumentException("Hours between 0 and 24");}

        LocalTime localTime = LocalTime.now();
        int seconds = localTime.getSecond() + localTime.getMinute()*60 + localTime.getHour()*60*60;
        int left = (hours*60*60)-seconds%(hours*60*60);
        return TimeUnit.MILLISECONDS.convert(left,TimeUnit.SECONDS);
    }
    /**
     * Create popup menu which will be shown when user
     * pressed on right button
     * @return JPopupMenu
     */
    private JPopupMenu createJPopup(){
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem settings = new JMenuItem("Settings");
        JMenuItem exit = new JMenuItem("Exit");

        exit.addActionListener(e -> System.exit(0));
        settings.addActionListener( e -> SwingUtilities.invokeLater(()-> new SettingWindow()));

        settings.setIcon( new ImageIcon(propWorker.getSettingsImage()));
        exit.setIcon(new ImageIcon(propWorker.getExitImage()));

        popupMenu.add(settings);
        popupMenu.addSeparator();
        popupMenu.add(exit);

        /*Crutch  that help to hide JPopupMenu, because
        it hides only when user press on menu
        otherwise it will stay on it`s place till user don`t choose one of the menu*/

        popupMenu.addMouseListener(new MouseAdapter() {
            boolean mouseStillOnMenu = false;
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseStillOnMenu = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseStillOnMenu = false;

                new Thread(() -> {

                    try {
                        Thread.sleep(2_500);  //waits one second before checking if mouse is still on the menu
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    if (!mouseStillOnMenu) {
                        popupMenu.setVisible(false);
                    }

                }).start();
            }
        });
        return popupMenu;

    }

}
