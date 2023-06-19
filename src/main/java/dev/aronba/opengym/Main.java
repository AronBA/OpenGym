package dev.aronba.opengym;

import com.formdev.flatlaf.FlatDarkLaf;


import javax.swing.*;


class Main{



    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        Window.getInstance();


    }
}