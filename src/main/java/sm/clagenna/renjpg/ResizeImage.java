package sm.clagenna.renjpg;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResizeImage {

  private static final String SUB_DIR    = "jpg";

  private double              m_fPerc;
  private String              m_szOrigFile;
  private BufferedImage       m_imgOrig;
  private int                 m_nXOrig, m_nYOrig;
  private int                 m_nTypeOrig;

  private int                 m_nNewSizeX;
  private String              m_szNewFile;
  private BufferedImage       m_imgNew;
  private int                 m_nXNew, m_nYNew;
  private boolean             WithHints  = true;

  private String              m_szSubDir = SUB_DIR;

  public ResizeImage() {

  }

  public ResizeImage(double scale) {
    setPerc(scale);
  }

  public ResizeImage(String szFile) {
    setOrigFile(szFile);
  }

  public ResizeImage(String szFile, double scale) {
    setPerc(scale);
    setOrigFile(szFile);
  }

  public boolean ridimensiona() {
    boolean bRet = false;
    bRet = openOrigImage();
    if (bRet)
      bRet = redim();
    if (bRet)
      bRet = salvaNuova();
    return bRet;
  }

  private boolean openOrigImage() {
    boolean bRet = false;
    m_imgOrig = null;
    try {
      File fi = new File(getOrigFile());
      bRet = fi.exists();
      if (bRet) {
        m_imgOrig = ImageIO.read(fi);
        m_nTypeOrig = m_imgOrig.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : m_imgOrig.getType();
        m_nXOrig = m_imgOrig.getWidth();
        m_nYOrig = m_imgOrig.getHeight();
      }
    } catch (IOException e) {
      bRet = false;
      e.printStackTrace();
    }
    return bRet;
  }

  private boolean redim() {
    boolean bRet = false;
    if (m_fPerc > 0) {
      m_nXNew = (int) ((double) m_nXOrig * m_fPerc);
      m_nYNew = (int) ((double) m_nYOrig * m_fPerc);
    } else {
      double ff = (double) m_nNewSizeX / (double) m_nXOrig;
      m_nXNew = m_nNewSizeX;
      m_nYNew = (int) ((double) m_nYOrig * ff);
    }
    m_imgNew = new BufferedImage(m_nXNew, m_nYNew, m_nTypeOrig);
    Graphics2D grafic = m_imgNew.createGraphics();
    grafic.drawImage(m_imgOrig, 0, 0, m_nXNew, m_nYNew, null);
    grafic.dispose();
    bRet = true;
    if (isWithHints()) {
      grafic.setComposite(AlphaComposite.Src);
      grafic.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      grafic.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      grafic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
    return bRet;
  }

  private boolean salvaNuova() {
    boolean bRet = true;
    File fi = new File(getNewFile());
    File dir = new File(fi.getParent());
    if ( !dir.exists())
      bRet = dir.mkdirs();
    try {
      if (bRet)
        ImageIO.write(m_imgNew, "jpg", fi);
    } catch (IOException e) {
      e.printStackTrace();
      bRet = false;
    }
    return bRet;
  }

  public int getNewSizeX() {
    return m_nNewSizeX;
  }

  public void setNewSizeX(int p_n) {
    m_nNewSizeX = p_n;
  }

  public double getPerc() {
    return m_fPerc;
  }

  public void setPerc(double fPerc) {
    if (fPerc < 1)
      m_fPerc = fPerc;
    else
      m_fPerc = fPerc / 100;
  }

  public String getOrigFile() {
    return m_szOrigFile;
  }

  public void setOrigFile(String p_szFile) {
    m_szOrigFile = p_szFile;
    if (m_szNewFile == null) {
      File fi = new File(m_szOrigFile);
      String szSep = System.getProperty("file.separator");
      if (fi.exists()) {
        String sz = fi.getParent() + szSep + getSubDir() + szSep + fi.getName();
        setNewFile(sz);
      }
    }
  }

  public String getNewFile() {
    return m_szNewFile;
  }

  public void setNewFile(String p_szFile) {
    m_szNewFile = p_szFile;
  }

  public void setWithHints(boolean withHints) {
    WithHints = withHints;
  }

  public boolean isWithHints() {
    return WithHints;
  }

  public void setSubDir(String m_szSubDir) {
    this.m_szSubDir = m_szSubDir;
  }

  public String getSubDir() {
    return m_szSubDir;
  }
}
