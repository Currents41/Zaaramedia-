//package com.dao;
//
//import com.config.Koneks;   
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.swing.JRViewer;
//import com.service.ServiceReport;
//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.sql.*;
//import java.util.HashMap;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import net.sf.jasperreports.engine.JasperPrintManager;
//
//public class ReportDAO implements ServiceReport{
//
//    private final Connection conn;
//    
//    public ReportDAO(){
//        conn = Koneks.getConnection();
//    }
//
//    @Override
//    public void cetakBarcode(JPanel pn, String barcode) {
//        try {
//            String reportPath = "src/com/report/ZaaramediaBar.jasper";
//
//            HashMap<String, Object> parameters = new HashMap<>();
//            if (barcode != null && !barcode.trim().isEmpty()) {
//                parameters.put("barcode", barcode);
//            }
//
//            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
//
//            JRViewer viewer = new JRViewer(print);
//
//            viewer.setZoomRatio(2.0f); 
//
//            pn.removeAll();
//            pn.setLayout(new BorderLayout());
//            pn.setPreferredSize(new Dimension(650,495)); 
//            pn.add(viewer, BorderLayout.CENTER);
//            pn.revalidate();
//            pn.repaint();
//            pn.updateUI();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public void printBarcode(String barcode) {
//        try {
//            String reportPath = "src/com/report/ZaaramediaBar.jasper";
//
//            HashMap<String, Object> parameters = new HashMap<>();
//            if (barcode != null && !barcode.trim().isEmpty()) {
//                parameters.put("barcode", barcode);
//            }
//
//            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
//            JasperPrintManager.printReport(print, true);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            e.printStackTrace();
//        }
//    }
//}
