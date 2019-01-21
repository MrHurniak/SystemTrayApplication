package ApplicationPack.FullInfoGUI;

import ApplicationPack.PropWorker;
import ApplicationPack.SettingWindow;
import WeatherAPIWorker.WeatherWorker;

import javax.swing.*;

public class InfoWindow extends JFrame {
    public InfoWindow(WeatherWorker worker){
        setTitle("Forecast");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(new PropWorker().getTrayImage()).getImage());
        setSize(300,300);
        setResizable(false);
        setJMenuBar(getJMenuBar());
        add(new MainPanel(worker));
        setVisible(true);
    }

    public JMenuBar getJMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenuItem settings = new JMenuItem("Settings");
        settings.addActionListener(e -> {System.out.println("Setting button");
        new SettingWindow();});
        menuBar.add(settings);
        return menuBar;
    }
}
