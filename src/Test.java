
import ApplicationPack.FullInfoGUI.InfoWindow;
import ApplicationPack.JsonISO2;
import ApplicationPack.PropWorker;
import ApplicationPack.Settings.SettingWindow;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception {
//        SwingUtilities.invokeLater(()->new SettingWindow());

        Date date = new Date(1548213108);
        System.out.println(date);

    }
}
