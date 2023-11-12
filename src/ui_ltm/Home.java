/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_ltm;

import java.awt.Component;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.DecimalFormat;
import org.json.JSONException;
import java.util.Arrays;

/**
 *
 * @author ACER
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private static String dataNhaSachTiki = "";
    private static String dataNhaCuaDoiSong = "";
    private static String dataMayAnh = "";
    private static String dataLaptopMayViTinhLinkKien = "";
    private static String dataDongHoVaTrangSuc = "";
    private static String dataBaloVaVali = "";
    private static String dataTuiThoiTrangNam = "";
    private static String dataGiayDepNam = "";
    
    public Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listSanPham = new javax.swing.JTabbedPane();
        nhaSachTikiScrollPane = new javax.swing.JScrollPane();
        nhaSachTikiTable = new javax.swing.JTable();
        nhaCuaDoiSongScrollPane = new javax.swing.JScrollPane();
        nhaCuaDoiSongTable = new javax.swing.JTable();
        mayAnhScrollPane = new javax.swing.JScrollPane();
        mayAnhTable = new javax.swing.JTable();
        laptopMayViTinhLinhKienScrollPane = new javax.swing.JScrollPane();
        laptopMayViTinhLinhKienTable = new javax.swing.JTable();
        dongHoVaTrangSucScrollPane = new javax.swing.JScrollPane();
        dongHoVaTrangSucTable = new javax.swing.JTable();
        baloVaValiScrollPane = new javax.swing.JScrollPane();
        baloVaValiTable = new javax.swing.JTable();
        tuiThoiTrangNamScrollPane = new javax.swing.JScrollPane();
        tuiThoiTrangNamTable = new javax.swing.JTable();
        giayDepNamScrollPane = new javax.swing.JScrollPane();
        giayDepNamTable = new javax.swing.JTable();
        theoDoiGiaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRA CỨU LỊCH SỬ GIÁ SẢN PHẨM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(321, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.setText("Tìm Kiếm");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jTextField2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Trang Chủ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        listSanPham.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        nhaSachTikiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nhaSachTikiTable.setName("nha-sach-tiki"); // NOI18N
        nhaSachTikiScrollPane.setViewportView(nhaSachTikiTable);
        if (nhaSachTikiTable.getColumnModel().getColumnCount() > 0) {
            nhaSachTikiTable.getColumnModel().getColumn(0).setMinWidth(40);
            nhaSachTikiTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            nhaSachTikiTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        listSanPham.addTab("Nhà sách Tiki", nhaSachTikiScrollPane);

        nhaCuaDoiSongScrollPane.setName("nha-cua-doi-song"); // NOI18N

        nhaCuaDoiSongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nhaCuaDoiSongTable.setName("nha-cua-doi-song"); // NOI18N
        nhaCuaDoiSongScrollPane.setViewportView(nhaCuaDoiSongTable);
        if (nhaCuaDoiSongTable.getColumnModel().getColumnCount() > 0) {
            nhaCuaDoiSongTable.getColumnModel().getColumn(0).setMinWidth(40);
            nhaCuaDoiSongTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            nhaCuaDoiSongTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        listSanPham.addTab("Nhà cửa đời sống", nhaCuaDoiSongScrollPane);

        mayAnhTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mayAnhTable.setName("may-anh"); // NOI18N
        mayAnhScrollPane.setViewportView(mayAnhTable);
        if (mayAnhTable.getColumnModel().getColumnCount() > 0) {
            mayAnhTable.getColumnModel().getColumn(0).setMinWidth(40);
            mayAnhTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            mayAnhTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        listSanPham.addTab("Máy ảnh", mayAnhScrollPane);

        laptopMayViTinhLinhKienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        laptopMayViTinhLinhKienTable.setName("laptop-may-vi-tinh-linh-kien"); // NOI18N
        laptopMayViTinhLinhKienScrollPane.setViewportView(laptopMayViTinhLinhKienTable);
        if (laptopMayViTinhLinhKienTable.getColumnModel().getColumnCount() > 0) {
            laptopMayViTinhLinhKienTable.getColumnModel().getColumn(0).setMinWidth(40);
            laptopMayViTinhLinhKienTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            laptopMayViTinhLinhKienTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        listSanPham.addTab("Laptop máy vi tính linh kiện", laptopMayViTinhLinhKienScrollPane);

        dongHoVaTrangSucTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dongHoVaTrangSucTable.setName("dong-ho-va-trang-suc"); // NOI18N
        dongHoVaTrangSucScrollPane.setViewportView(dongHoVaTrangSucTable);
        if (dongHoVaTrangSucTable.getColumnModel().getColumnCount() > 0) {
            dongHoVaTrangSucTable.getColumnModel().getColumn(0).setMinWidth(40);
            dongHoVaTrangSucTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            dongHoVaTrangSucTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        listSanPham.addTab("Đồng hồ và trang sức", dongHoVaTrangSucScrollPane);

        baloVaValiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        baloVaValiTable.setName("balo-va-vali"); // NOI18N
        baloVaValiScrollPane.setViewportView(baloVaValiTable);
        if (baloVaValiTable.getColumnModel().getColumnCount() > 0) {
            baloVaValiTable.getColumnModel().getColumn(0).setMinWidth(40);
            baloVaValiTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            baloVaValiTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        listSanPham.addTab("Balo và vali", baloVaValiScrollPane);

        tuiThoiTrangNamScrollPane.setName(""); // NOI18N

        tuiThoiTrangNamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tuiThoiTrangNamTable.setName("tui-thoi-trang-nam"); // NOI18N
        tuiThoiTrangNamScrollPane.setViewportView(tuiThoiTrangNamTable);
        if (tuiThoiTrangNamTable.getColumnModel().getColumnCount() > 0) {
            tuiThoiTrangNamTable.getColumnModel().getColumn(0).setMinWidth(40);
            tuiThoiTrangNamTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            tuiThoiTrangNamTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        listSanPham.addTab("Túi thời trang nam", tuiThoiTrangNamScrollPane);

        giayDepNamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        giayDepNamTable.setName("giay-dep-nam"); // NOI18N
        giayDepNamScrollPane.setViewportView(giayDepNamTable);
        if (giayDepNamTable.getColumnModel().getColumnCount() > 0) {
            giayDepNamTable.getColumnModel().getColumn(0).setMinWidth(40);
            giayDepNamTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            giayDepNamTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        listSanPham.addTab("Giày dép nam ", giayDepNamScrollPane);

        theoDoiGiaButton.setBackground(new java.awt.Color(51, 102, 255));
        theoDoiGiaButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        theoDoiGiaButton.setForeground(new java.awt.Color(255, 255, 255));
        theoDoiGiaButton.setText("Theo dõi giá");
        theoDoiGiaButton.setToolTipText("");
        theoDoiGiaButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        theoDoiGiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theoDoiGiaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listSanPham)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(theoDoiGiaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(theoDoiGiaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void theoDoiGiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theoDoiGiaButtonActionPerformed
        
        int tabIndex = listSanPham.getSelectedIndex();
        Component tabComponent = listSanPham.getComponentAt(tabIndex);
        JScrollPane scrollPane = (JScrollPane) tabComponent;
        JViewport viewport = scrollPane.getViewport();
        JTable table = (JTable) viewport.getView();
        int selectedRow = table.getSelectedRow();
        
        
        if (selectedRow >= 0) {
            int stt = (int) table.getValueAt(selectedRow, 0);
            String name = (String) table.getValueAt(selectedRow, 1);
//            String imageURL = (String) table.getValueAt(selectedRow, 1);
            String tableName = table.getName();
//            System.out.println(stt + "\n" + name + "\n" + table.getName());

            int columnCount = table.getColumnCount();
            System.out.println("Số lượng cột trong bảng là: " + columnCount);
            Object[] rowData = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                rowData[i] = table.getValueAt(selectedRow, i);
            }
            System.out.println(Arrays.toString(rowData));
            
            String productID = getProductID(tableName, stt);
            String lastestPrice = getLastestPrice(productID);
            String imageURL = getImageURL(tableName, stt);
            String listPriceAndDate = getListPrice(productID);

            System.out.println("ID: " + productID + "\n name: " + name +  "\n Gia:" + lastestPrice + "\n Anh: " + imageURL);
            // Chuyển thông tin sản phẩm được chọn đến Chitietsp
            Chitietsp chitietsp = new Chitietsp(listPriceAndDate);
            chitietsp.setSelectedProductName(name);
            chitietsp.setSelectedProductPrice(lastestPrice);
            chitietsp.setSelectedProductImageURL(imageURL);
//            chitietsp.sendDataChart(listPriceAndDate);
            chitietsp.setVisible(true);
        }
    }//GEN-LAST:event_theoDoiGiaButtonActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
   
    
    public static void  handleDataTable(JTable table, String categoryID) {
        
        String dataReceive = TikiTrackPriceClient.handleListProduct("GetListProduct", categoryID);
        switch(categoryID) {
            case "nha-sach-tiki":
                dataNhaSachTiki = dataReceive;
                break; 
            case "nha-cua-doi-song":
                dataNhaCuaDoiSong = dataReceive;
                break;  
            case "may-anh":
                dataMayAnh = dataReceive;
                break;     
            case "laptop-may-vi-tinh-linh-kien":
                dataLaptopMayViTinhLinkKien = dataReceive;
                break; 
            case "dong-ho-va-trang-suc":
                dataDongHoVaTrangSuc = dataReceive;
                break;     
            case "balo-va-vali":
                dataBaloVaVali = dataReceive;
                break;               
            case "tui-thoi-trang-nam":
                dataTuiThoiTrangNam = dataReceive;
                break;                
            case "giay-dep-nam":
                dataGiayDepNam = dataReceive;
                break;    
        }
        JSONObject jsReceive = new JSONObject(dataReceive);
        JSONArray arrReceive = new JSONArray(jsReceive.getJSONArray("list product"));
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        tableModel.setRowCount(0);

        for (int i = 0; i < arrReceive.length(); i++) {
            JSONObject contentReceive = arrReceive.getJSONObject(i);
            int stt = i + 1;
            String name = contentReceive.getString("name");
            String imageURL = contentReceive.getString("imageURL");
            
            tableModel.addRow(new Object[]{stt, name, imageURL});
//            System.out.println("hiihh " + contentReceive.toString());
        }
        
//            System.out.println("API Response for GetListProduct: " + dataReceive);

    }
    
    public void sendDataTable() {
        handleDataTable(nhaSachTikiTable, "nha-sach-tiki");
        handleDataTable(nhaCuaDoiSongTable, "nha-cua-doi-song");
        handleDataTable(mayAnhTable, "may-anh");
        handleDataTable(laptopMayViTinhLinhKienTable, "laptop-may-vi-tinh-linh-kien");
        handleDataTable(dongHoVaTrangSucTable, "dong-ho-va-trang-suc");
        handleDataTable(baloVaValiTable, "balo-va-vali");
        handleDataTable(tuiThoiTrangNamTable, "tui-thoi-trang-nam");
        handleDataTable(giayDepNamTable, "giay-dep-nam");
    }
    
    public String getProductID(String tableName, int stt) {
        String listProduct = "";
        switch(tableName) {
            case "nha-sach-tiki":
                listProduct = dataNhaSachTiki;
                break; 
            case "nha-cua-doi-song":
                listProduct = dataNhaCuaDoiSong;
                break;  
            case "may-anh":
                listProduct = dataMayAnh;
                break;     
            case "laptop-may-vi-tinh-linh-kien":
                listProduct = dataLaptopMayViTinhLinkKien;
                break; 
            case "dong-ho-va-trang-suc":
                listProduct = dataDongHoVaTrangSuc;
                break;     
            case "balo-va-vali":
                listProduct = dataBaloVaVali;
                break;               
            case "tui-thoi-trang-nam":
                listProduct = dataTuiThoiTrangNam;
                break;                
            case "giay-dep-nam":
                listProduct = dataGiayDepNam;
                break;   
        }
        
        JSONObject jsListProduct = new JSONObject(listProduct);
        JSONArray arrListProduct = new JSONArray(jsListProduct.getJSONArray("list product"));
        JSONObject contentListProduct = arrListProduct.getJSONObject(stt - 1);
        
        String productID = contentListProduct.getString("productID");
//        System.out.println("Product ID dang tim la " + productID);
        return productID;
    }
    
        public String getLastestPrice(String productID) {
            String listPriceAndDate = TikiTrackPriceClient.handleListProduct("GetListPriceAndDate", productID);
            
            // Parse JSON response to extract the price
            JSONObject jsonObject = new JSONObject(listPriceAndDate);
            JSONArray priceAndDateArray = jsonObject.getJSONArray("ListPriceAndDate");

            System.out.println("price and date: " + listPriceAndDate);
            // Lấy giá từ lần tìm kiếm gần nhất (ở cuối danh sách)
            if (priceAndDateArray.length() > 0) {
                JSONObject latestPrice = priceAndDateArray.getJSONObject(priceAndDateArray.length() - 1);
                double price = latestPrice.getDouble("price");

                DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
                return decimalFormat.format(price) + " VND";
            } else {
                return "N/A";
            }
        }
    
        public String getImageURL(String tableName, int stt) {
        String listProduct = "";
        switch(tableName) {
            case "nha-sach-tiki":
                listProduct = dataNhaSachTiki;
                break; 
            case "nha-cua-doi-song":
                listProduct = dataNhaCuaDoiSong;
                break;  
            case "may-anh":
                listProduct = dataMayAnh;
                break;     
            case "laptop-may-vi-tinh-linh-kien":
                listProduct = dataLaptopMayViTinhLinkKien;
                break; 
            case "dong-ho-va-trang-suc":
                listProduct = dataDongHoVaTrangSuc;
                break;     
            case "balo-va-vali":
                listProduct = dataBaloVaVali;
                break;               
            case "tui-thoi-trang-nam":
                listProduct = dataTuiThoiTrangNam;
                break;                
            case "giay-dep-nam":
                listProduct = dataGiayDepNam;
                break;   
        }
        
        JSONObject jsListProduct = new JSONObject(listProduct);
        JSONArray arrListProduct = new JSONArray(jsListProduct.getJSONArray("list product"));
        JSONObject contentListProduct = arrListProduct.getJSONObject(stt - 1);
        
        String imageURL = contentListProduct.getString("imageURL");
//        System.out.println("URL dang tim la " + imageURL);
        return imageURL;
    }
        
        public String getListPrice(String productID) {
            String listPriceAndDate = TikiTrackPriceClient.handleListProduct("GetListPriceAndDate", productID);
            
            // Parse JSON response to extract the price
            JSONObject jsonObject = new JSONObject(listPriceAndDate);
            JSONArray priceAndDateArray = jsonObject.getJSONArray("ListPriceAndDate");          
           return priceAndDateArray.toString();
        }
  
        
//        public String getListPriceAndDate(String productID) {
//             String listPriceAndDate = TikiTrackPriceClient.handleListProduct("GetListPriceAndDate", productID);
//             return listPriceAndDate;
//        }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      TikiTrackPriceClient client = new TikiTrackPriceClient("localhost", 4444);
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Home home = new Home();
                home.setVisible(true);
                home.sendDataTable();
 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane baloVaValiScrollPane;
    private javax.swing.JTable baloVaValiTable;
    private javax.swing.JScrollPane dongHoVaTrangSucScrollPane;
    private javax.swing.JTable dongHoVaTrangSucTable;
    private javax.swing.JScrollPane giayDepNamScrollPane;
    private javax.swing.JTable giayDepNamTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JScrollPane laptopMayViTinhLinhKienScrollPane;
    private javax.swing.JTable laptopMayViTinhLinhKienTable;
    private javax.swing.JTabbedPane listSanPham;
    private javax.swing.JScrollPane mayAnhScrollPane;
    private javax.swing.JTable mayAnhTable;
    private javax.swing.JScrollPane nhaCuaDoiSongScrollPane;
    private javax.swing.JTable nhaCuaDoiSongTable;
    private javax.swing.JScrollPane nhaSachTikiScrollPane;
    private javax.swing.JTable nhaSachTikiTable;
    private javax.swing.JButton theoDoiGiaButton;
    private javax.swing.JScrollPane tuiThoiTrangNamScrollPane;
    private javax.swing.JTable tuiThoiTrangNamTable;
    // End of variables declaration//GEN-END:variables
}
