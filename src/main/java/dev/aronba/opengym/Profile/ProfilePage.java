package dev.aronba.opengym.Profile;
import dev.aronba.opengym.History.HistoryPage;
import dev.aronba.opengym.Theme;
import org.apache.commons.io.FileUtils;


import javax.swing.*;
import java.io.File;
import java.io.IOException;
import dev.aronba.opengym.Settings;

public class ProfilePage extends JPanel {
    public ProfilePage() {
        JComboBox<String> themesComboBox = new JComboBox(Theme.values());
        themesComboBox.addActionListener(l -> {
            Theme theme = (Theme) themesComboBox.getSelectedItem();
            Settings.setTheme(theme);
            Settings.saveTheme(theme);
            Settings.updateTheme();
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
