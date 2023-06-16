package dev.aronba.opengym.History;

import dev.aronba.opengym.Json.Json;
import dev.aronba.opengym.Json.ModelExercise;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;
import java.util.List;

public class HistoryPage extends JLabel {

    private final JTextArea area;
    private static JTree jTree;

    public HistoryPage(){
        setLayout(new BorderLayout());
        jTree = new JTree(generateTreeModel());
        jTree.addTreeSelectionListener((tsl) -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tsl.getPath().getLastPathComponent();
            inspectFiles(node);
        });

        add(jTree,BorderLayout.WEST);
        area = new JTextArea();
        area.setEditable(false);
        add(area,BorderLayout.CENTER);
    }
    private static DefaultTreeModel generateTreeModel() {
        String path = "Workouts";
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(path);

        loadFiles(new File(path),root);

        return new DefaultTreeModel(root);
    }
    private void inspectFiles(DefaultMutableTreeNode node) {
        String filename = node.getUserObject().toString();
        String path = "Workouts/" + filename;

        List<ModelExercise> list = Json.readWorkoutFromJson(new File(path));
        area.setText("");
        for (ModelExercise exercise : list){
            area.append("Name: " + exercise.getName() + "\n");
            area.append("Sets: " + exercise.getSets() + "\n");
            area.append("\n");
        }
    }
    public static void loadFiles(){
        String path = "Workouts";
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(path);
        loadFiles(new File(path),root);
        jTree.setModel(generateTreeModel());
    }
    private static void loadFiles(File dir, DefaultMutableTreeNode parentNode){
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());
                    loadFiles(file, childNode);
                    parentNode.add(childNode);
                } else {
                    DefaultMutableTreeNode leafNode = new DefaultMutableTreeNode(file.getName());
                    parentNode.add(leafNode);
                }
            }
        }
    }
}
