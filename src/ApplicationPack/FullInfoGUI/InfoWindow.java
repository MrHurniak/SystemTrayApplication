package ApplicationPack.FullInfoGUI;

import ApplicationPack.PropWorker;
import ApplicationPack.Settings.SettingWindow;
import WeatherAPIWorker.WeatherWorker;

import javax.swing.*;

public class InfoWindow extends JFrame {

    MainPanel mainPanel;
    public InfoWindow(){
        setTitle("Forecast");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(new PropWorker().getTrayImage()).getImage());
        setSize(300,325);
        setResizable(false);
        setJMenuBar(getJMenuBar());
        mainPanel = new MainPanel();
        add(mainPanel);
        setVisible(true);
    }

    public JMenuBar getJMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenuItem settings = new JMenuItem("Settings");
        JMenuItem reload = new JMenuItem("re-new");
        reload.addActionListener(e -> {
            System.out.println("InfoWindow.getJMenuBar().reload.");
            mainPanel.reload();
        });
        settings.addActionListener(e -> {
            System.out.println("Setting button");
            SwingUtilities.invokeLater(()->
                    new SettingWindow());
        });
        menuBar.add(settings);
        menuBar.add(reload);
        return menuBar;
    }
}
