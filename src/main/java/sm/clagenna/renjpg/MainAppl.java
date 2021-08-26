package sm.clagenna.renjpg;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class MainAppl extends javax.swing.JFrame {

  private static final long serialVersionUID = -8597574521316065785L;

  private boolean           m_bSubDirs       = false;

  Vector<TrattaJpgFile>     vecFiles;

  private DeltaData         m_delta;
  private int               m_nRigaSel;

  // private ImagePanel m_img;

  /** Creates new form MainAppl */
  public MainAppl() {
    initUi();
    initComponents();
    intestaTabella();
  }

  /**
   *
   */
  private void initUi() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      UIManager.put("ComboBox.disabledForeground", Color.black);
      Toolkit.getDefaultToolkit().setDynamicLayout(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // GEN-BEGIN:initComponents
  // <editor-fold defaultstate="collapsed" desc="Generated Code">
  private void initComponents() {

    lbMsg = new javax.swing.JLabel();
    jTabbedPane1 = new javax.swing.JTabbedPane();
    panSrcDir = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    txDirSrc = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    btCercaSrc = new javax.swing.JButton();
    btConv = new javax.swing.JButton();
    panDeltaOra = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    txDelta = new javax.swing.JTextField();
    panRidimensiona = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    txJpgino = new javax.swing.JTextField();
    btJpgino = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();
    txPixX = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    txPixY = new javax.swing.JTextField();
    ckProp = new javax.swing.JCheckBox();
    jSplitPane1 = new javax.swing.JSplitPane();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    panJpg = new javax.swing.JPanel();
    lbJpg = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    lbMsg.setMinimumSize(new java.awt.Dimension(0, 10));

    jLabel1.setLabelFor(txDirSrc);
    jLabel1.setText("Scegli il direttorio delle foto");

    jButton1.setText("Dir");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btDirClick(evt);
      }
    });

    btCercaSrc.setText("Aggiorna");
    btCercaSrc.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCercaClick(evt);
      }
    });

    btConv.setText("Rinomina");
    btConv.setActionCommand("Rinomina");
    btConv.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btConvClick(evt);
      }
    });

    org.jdesktop.layout.GroupLayout panSrcDirLayout = new org.jdesktop.layout.GroupLayout(panSrcDir);
    panSrcDir.setLayout(panSrcDirLayout);
    panSrcDirLayout.setHorizontalGroup(panSrcDirLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(panSrcDirLayout.createSequentialGroup().addContainerGap()
            .add(panSrcDirLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(jLabel1)
                .add(panSrcDirLayout.createSequentialGroup()
                    .add(txDirSrc, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE).add(18, 18, 18).add(jButton1,
                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(panSrcDirLayout.createSequentialGroup().add(btCercaSrc)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED).add(btConv)))
            .addContainerGap()));
    panSrcDirLayout.setVerticalGroup(panSrcDirLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(panSrcDirLayout.createSequentialGroup().addContainerGap().add(jLabel1)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
            .add(panSrcDirLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jButton1).add(txDirSrc,
                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(panSrcDirLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(btCercaSrc).add(btConv))
            .addContainerGap(14, Short.MAX_VALUE)));

    jTabbedPane1.addTab("Src dir", panSrcDir);

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel2.setLabelFor(txDelta);
    jLabel2.setText("Delta orario");
    jLabel2.setToolTipText("Quantita di tempo da aggiungere all'ora presente nella informazione EXIF");
    jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

    txDelta.setText("-0h 0m 0s");

    org.jdesktop.layout.GroupLayout panDeltaOraLayout = new org.jdesktop.layout.GroupLayout(panDeltaOra);
    panDeltaOra.setLayout(panDeltaOraLayout);
    panDeltaOraLayout.setHorizontalGroup(panDeltaOraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(panDeltaOraLayout.createSequentialGroup().addContainerGap()
            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 76, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
            .add(txDelta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(387, Short.MAX_VALUE)));
    panDeltaOraLayout.setVerticalGroup(panDeltaOraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(panDeltaOraLayout.createSequentialGroup().addContainerGap()
            .add(panDeltaOraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel2).add(txDelta,
                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(78, Short.MAX_VALUE)));

    jTabbedPane1.addTab("Delta Ora", panDeltaOra);

    jLabel3.setText("Destin");

    btJpgino.setText("jpgino");

    jLabel4.setText("Pix X");

    txPixX.setHorizontalAlignment(SwingConstants.RIGHT);
    txPixX.setText("1240");
    txPixX.setPreferredSize(new java.awt.Dimension(64, 22));

    jLabel5.setText("Pix Y");

    txPixY.setHorizontalAlignment(SwingConstants.RIGHT);
    txPixY.setText("1024");
    txPixY.setPreferredSize(new java.awt.Dimension(64, 22));

    ckProp.setSelected(true);
    ckProp.setText("Proporzionale");
    ckProp.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

    org.jdesktop.layout.GroupLayout panRidimensionaLayout = new org.jdesktop.layout.GroupLayout(panRidimensiona);
    panRidimensiona.setLayout(panRidimensionaLayout);
    panRidimensionaLayout
        .setHorizontalGroup(panRidimensionaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panRidimensionaLayout.createSequentialGroup().addContainerGap()
                .add(panRidimensionaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(panRidimensionaLayout
                    .createSequentialGroup().add(jLabel3).addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                    .add(panRidimensionaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(panRidimensionaLayout.createSequentialGroup()
                            .add(btJpgino, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .add(panRidimensionaLayout.createSequentialGroup()
                            .add(txJpgino, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE).add(83, 83, 83))))
                    .add(panRidimensionaLayout.createSequentialGroup().add(jLabel4).add(18, 18, 18)
                        .add(txPixX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txPixY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED).add(ckProp).add(273, 273, 273)))));
    panRidimensionaLayout
        .setVerticalGroup(
            panRidimensionaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(
                    panRidimensionaLayout.createSequentialGroup().addContainerGap()
                        .add(panRidimensionaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel3).add(
                            txJpgino, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(panRidimensionaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel4)
                            .add(txPixX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel5)
                            .add(txPixY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(ckProp))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 9, Short.MAX_VALUE).add(btJpgino)
                        .addContainerGap()));

    jTabbedPane1.addTab("Ridim", panRidimensiona);

    jSplitPane1.setDividerLocation(200);

    jTable1
        .setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null },
            { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    jScrollPane1.setViewportView(jTable1);

    jSplitPane1.setLeftComponent(jScrollPane1);

    panJpg.setLayout(new java.awt.BorderLayout());
    panJpg.add(lbJpg, java.awt.BorderLayout.CENTER);

    jSplitPane1.setRightComponent(panJpg);

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(org.jdesktop.layout.GroupLayout.TRAILING,
            layout.createSequentialGroup().addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 603,
                        Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTabbedPane1).add(org.jdesktop.layout.GroupLayout.LEADING, lbMsg,
                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
                .addContainerGap()));
    layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup().addContainerGap()
            .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED).add(lbMsg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)));

    jTabbedPane1.getAccessibleContext().setAccessibleName("Src dir");

    pack();
  }// </editor-fold>
   // GEN-END:initComponents

  // GEN-FIRST:event_btDirClick
  private void btDirClick(java.awt.event.ActionEvent evt) {
    String sz = getDir();
    setDirPath(sz);
    txDirSrc.setText(sz);
    m_nRigaSel = -1;
  }// GEN-LAST:event_btDirClick

  // GEN-FIRST:event_btConvClick
  void btConvClick(java.awt.event.ActionEvent evt) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    try {
      for (TrattaJpgFile jp : vecFiles) {
        jp.rinominaFile();
      }
      scanDir(getDirPath(), m_bSubDirs);
      riempiGrid();
    } finally {
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }// GEN-LAST:event_btConvClick

  // GEN-FIRST:event_btCercaClick
  void btCercaClick(java.awt.event.ActionEvent evt) {
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    String sz = txDirSrc.getText();
    if (sz != null) {
      setDelta(new DeltaData());
      String szDelta = txDelta.getText();
      getDelta().parseDelta(szDelta);
      scanDir(sz, m_bSubDirs);
      riempiGrid();
    }
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }// GEN-LAST:event_k

  /**
   * @param args
   *          the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new MainAppl().setVisible(true);
      }
    });
  }

  // GEN-BEGIN:variables
  // Variables declaration - do not modify
  private javax.swing.JButton     btCercaSrc;
  private javax.swing.JButton     btConv;
  private javax.swing.JButton     btJpgino;
  private javax.swing.JCheckBox   ckProp;
  private javax.swing.JButton     jButton1;
  private javax.swing.JLabel      jLabel1;
  private javax.swing.JLabel      jLabel2;
  private javax.swing.JLabel      jLabel3;
  private javax.swing.JLabel      jLabel4;
  private javax.swing.JLabel      jLabel5;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSplitPane  jSplitPane1;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTable      jTable1;
  private javax.swing.JLabel      lbJpg;
  private javax.swing.JLabel      lbMsg;
  private javax.swing.JPanel      panDeltaOra;
  private javax.swing.JPanel      panJpg;
  private javax.swing.JPanel      panRidimensiona;
  private javax.swing.JPanel      panSrcDir;
  private javax.swing.JTextField  txDelta;
  private javax.swing.JTextField  txDirSrc;
  private javax.swing.JTextField  txJpgino;
  private javax.swing.JTextField  txPixX;
  private javax.swing.JTextField  txPixY;
  // End of variables declaration//GEN-END:variables

  private String                  DirPath;

  public String getDirPath() {
    return DirPath;
  }

  public void setDirPath(String dirPath) {
    DirPath = dirPath;
  }

  private String getDir() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    String szDir = getDirPath();
    if (szDir == null || szDir.length() < 2)
      szDir = "c:\\";
    chooser.setCurrentDirectory(new File(szDir));

    int returnVal = chooser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      szDir = chooser.getCurrentDirectory().getAbsolutePath() + System.getProperty("file.separator")
          + chooser.getSelectedFile().getName();
    }
    return szDir;
  }

  private void intestaTabella() {
    DefaultTableModel model = new DefaultTableModel();

    // Create 2 columns
    model.addColumn("Nome attuale");
    model.addColumn("Nome nuovo");

    jTable1.setModel(model);
    jTable1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        RigaSelezionata(e);
      }
    });
    // Force the header to resize and repaint itself
    jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
    jTable1.getTableHeader().resizeAndRepaint();
    // m_img = new ImagePanel(panJpg);
    // panJpg.add(m_img, BorderLayout.CENTER);
  }

  void scanDir(String szDir, boolean bSubDirs) {
    if (szDir == null)
      return;
    vecFiles = new Vector<TrattaJpgFile>();
    File dir = null;
    try {
      dir = new File(szDir);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    if (dir == null)
      return;
    deleteRows();
    if ( !dir.isDirectory())
      return;
    System.out.println(szDir);
    File[] files = dir.listFiles();
    for (int i = 0; i < files.length; i++) {
      File fil = files[i];
      try {
        if (fil.isFile()) {
          TrattaJpgFile jpgf = new TrattaJpgFile(this);
          jpgf.setFilePath(fil);
          if (jpgf.readFileJpeg()) {
            vecFiles.add(jpgf);
          }
        } else {
          if (bSubDirs)
            scanDir(fil.getAbsolutePath(), bSubDirs);
        }
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("rem errore su \"" + fil.getAbsolutePath() + "\" " + e.getMessage());
      }
    }
  }

  void riempiGrid() {
    deleteRows();
    if (vecFiles == null)
      return;
    for (TrattaJpgFile jpgf : vecFiles) {
      addRow(jpgf);
    }
  }

  /**
   * @param p_jpgf
   */
  private void addRow(TrattaJpgFile p_jpgf) {
    String szOld, szNew;
    szOld = p_jpgf.getOldShortName();
    szNew = p_jpgf.getNewName();

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.addRow(new Object[] { szOld, szNew });
  }

  private void deleteRows() {
    intestaTabella();
  }

  public void log(String sz) {
    if (sz == null)
      sz = "";
    lbMsg.setText(sz);
  }

  public void setDelta(DeltaData delta) {
    m_delta = delta;
  }

  public DeltaData getDelta() {
    return m_delta;
  }

  public void RigaSelezionata(ListSelectionEvent e) {
    if ( !e.getValueIsAdjusting()) {
      int i = jTable1.getSelectedRow();
      if (i != m_nRigaSel) {
        m_nRigaSel = i;
        if (m_nRigaSel >= 0 && vecFiles != null && vecFiles.size() > m_nRigaSel) {
          TrattaJpgFile tjp = vecFiles.get(m_nRigaSel);
          setImage(tjp.getOldName());
          // m_img.setImage(tjp.getOldName());
        }
      }
    }
  }

  private void setImage(String p_imgName) {
    // ImageIcon ico = new ImageIcon(oldName); ??
    // lbJpg.setPreferredSize(new
    // Dimension(panJpg.getWidth(),panJpg.getHeight()));
    // lbJpg.setIcon(ico);
    int nw = panJpg.getWidth();
    int nh = panJpg.getHeight();
    //    Toolkit tk = Toolkit.getDefaultToolkit();
    //    Image img = tk.getImage(p_imgName);
    //    Image imgrsz = img.getScaledInstance(nw, nh, Image.SCALE_DEFAULT);
    Image imgrsz = imageScaled(p_imgName, nw, nh);
    ImageIcon icon = new ImageIcon(imgrsz);
    lbJpg.setIcon(icon);
    lbJpg.repaint();
  }

  private Image imageScaled(String p_imgName, int nw, int nh) {
    Image imgrsz = null;
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image img = tk.getImage(p_imgName);
    int nwimg = -1;
    int nhimg = -1;
    MediaTracker mTracker = new MediaTracker(this);
    mTracker.addImage(img, 1);
    try {
      mTracker.waitForID(1);
      nwimg = img.getWidth(null);
      nhimg = img.getHeight(null);
      //      System.out.println(String.format("W=%d,H=%d", toi(nwimg), toi(nhimg)));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    if (nwimg == -1) {
      imgrsz = img.getScaledInstance(nw, nh, Image.SCALE_DEFAULT);
      return imgrsz;
    }
    double sca = (double) nwimg / (double) nhimg;
    int newh = -1;
    int neww = (int) (nh * sca);
    if (neww > nw) {
      newh = (int) (nh / sca);
      neww = -1;
    }
    imgrsz = img.getScaledInstance(neww, newh, Image.SCALE_DEFAULT);
    return imgrsz;
  }

  @SuppressWarnings("unused")
  private Object toi(int vv) {
    return Integer.valueOf(vv);
  }
}

class ImagePanel extends JPanel {
  /** serialVersionUID */
  private static final long serialVersionUID = 4996829474433680772L;
  private String            path;
  private Image             img;
  private double            m_dblProp;
  private JPanel            m_pan;

  public ImagePanel(JPanel pan) {
    m_pan = pan;
  }

  public void setImage(String szPath) {
    path = szPath;
    try {
      img = ImageIO.read(new File(path));
      m_dblProp = (double) img.getWidth(null) / (double) img.getHeight(null);
      System.out.println("ImagePanel.setImage()=" + szPath);
      // m_pan.invalidate();
      // m_pan.repaint();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void paint(Graphics g) {
    if (img != null) {
      System.out.println("ImagePanel.paint()");
      int nW = m_pan.getWidth();
      int nH = (int) (nW / m_dblProp);
      if (nH > m_pan.getHeight()) {
        nH = m_pan.getHeight();
        nW = (int) (nH * m_dblProp);
      }
      g.drawImage(img, 0, 0, nW, nH, null);
    }
  }
}
