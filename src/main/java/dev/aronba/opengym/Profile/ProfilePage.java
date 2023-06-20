package dev.aronba.opengym.Profile;
import dev.aronba.opengym.History.HistoryPage;
import dev.aronba.opengym.Theme;
import org.apache.commons.io.FileUtils;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import dev.aronba.opengym.Window;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import dev.aronba.opengym.Settings;

public class ProfilePage extends JPanel {
    public ProfilePage() {
        JComboBox<String> themesComboBox = new JComboBox(Theme.values());
        themesComboBox.addActionListener(l -> {
            Theme theme = (Theme) themesComboBox.getSelectedItem();
            Settings.setTheme(theme);
            Settings.saveTheme(theme);
        });
        add(themesComboBox);

        JButton deleteDataButton = new JButton("Delete all Data");
        deleteDataButton.addActionListener(l -> deleteData(Settings.workoutFolder));

        add(deleteDataButton);
    }

    private void deleteData(File dir) {
        try {
            FileUtils.cleanDirectory(dir);
            HistoryPage.loadFiles();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
