/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empire.patch.generator.desk.utils;

import java.awt.TextArea;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;

/**
 *
 * @author Administrator
 */
public class MainFrameConsoleUtil {
    private static java.awt.TextArea console;
    private static javax.swing.JTextPane jTextPane1;
        //private  static javax.swing.JEditorPane jEditorPane1;,JEditorPane jEditorPane1
    public static TextArea getConsole() {
        return console;
    }

    public static void initConsole(TextArea console,JTextPane jTextPane1) {
        MainFrameConsoleUtil.console = console;
        MainFrameConsoleUtil.jTextPane1=jTextPane1;
        //MainFrameConsoleUtil.jEditorPane1=jEditorPane1;
    }
    public static void println(String context){
        console.append(context+"\r\n");
        //jTextPane1.print("", MessageFormat);
         //设置字体大小
        SimpleAttributeSet attrset = new SimpleAttributeSet();
        Document docs = jTextPane1.getDocument();//获得文本对象
        try {
            docs.insertString(docs.getLength(), context,attrset);//对文本进行追加
            jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength()); 
        } catch (BadLocationException ex) {
            Logger.getLogger(MainFrameConsoleUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
