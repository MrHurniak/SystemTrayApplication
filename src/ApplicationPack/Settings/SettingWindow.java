package ApplicationPack.Settings;

import ApplicationPack.PropWorker;
import org.json.JSONException;

import javax.swing.*;

public class SettingWindow extends JFrame {
    public SettingWindow(){
        setSize(300,320);
        setTitle("Settings");
        try {
            add(new SettingPanel());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setIconImage(new ImageIcon(new PropWorker().getSettingsImage()).getImage());
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
