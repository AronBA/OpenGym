package dev.aronba.opengym.History;

import dev.aronba.opengym.Json.Json;
import dev.aronba.opengym.Json.ModelExercise;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

public class HistoryPage extends JLabel {

    private JTextArea area;
    private JTree jTree;

    private DefaultTreeModel treeModel;

    public HistoryPage(){

        String path = "Workouts";
        setLayout(new BorderLayout());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(path);

        loadFiles(new File(path),root);

        treeModel = new DefaultTreeModel(root);
        jTree = new JTree(treeModel);
        jTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1){
                        TreePath path = jTree.getPathForLocation(e.getX(),e.getY());
                        if (path != null){
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                            instpectFiles(node);

                        }
                    }
            }
        });
        add(jTree,BorderLayout.WEST);
        area = new JTextArea();
        area.setEditable(false);
        add(area,BorderLayout.CENTER);


    }

    private void instpectFiles(DefaultMutableTreeNode node){

        String filename = node.getUserObject().toString();
        String path = "Workouts/" + filename;

        List<ModelExercise> list = Json.readWorkoutFromJson(new File(path));

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
