package sm.clagenna.renjpg;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TrattaFotoFile implements IFotoFile {

  private MainAppl              appl;
  private File                  fileOld;
  protected String              newName;
  Date                          dtScatto;
  protected static final String FIL_PREFIX = "f";
  protected SimpleDateFormat    fmt        = new SimpleDateFormat("yyyyMMdd_HHmmss");
  protected SimpleDateFormat    fmtZulu    = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
  protected SimpleDateFormat    fmtZulu2   = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS", Locale.US);
  Map<String, String>           m_mapPatt;

  public TrattaFotoFile(MainAppl p_app) {
    setAppl(p_app);
  }

  protected Date testPatternsFileName(File p_fileJpg) {
    if (m_mapPatt == null)
      creaMapPatt();
    Date dtRet = null;
    String szFilNam = p_fileJpg.getName();
    try {
      for (String szPat : m_mapPatt.keySet()) {
        Pattern pat = Pattern.compile(szPat);
        Matcher match = pat.matcher(szFilNam);

        if (match.find()) {
          int n1 = match.start();
          int n2 = match.end();
          String sz = szFilNam.substring(n1, n2);
          String szFmt = m_mapPatt.get(szPat);
          SimpleDateFormat dtFtm = new SimpleDateFormat(szFmt);
          dtRet = dtFtm.parse(sz);
          break;
        }
      }
    } catch (ParseException ex) {
      ex.printStackTrace();
    }
    return dtRet;
  }

  private void creaMapPatt() {
    m_mapPatt = new HashMap<>();
    m_mapPatt.put("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9] at [0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9]", "yyyy-MM-dd' at 'HH.mm.ss");
    m_mapPatt.put("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9] at [0-9][0-9]\\:[0-9][0-9]\\:[0-9][0-9]", "yyyy-MM-dd' at 'HH:mm:ss");
    m_mapPatt.put("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]_[0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9]", "yyyy-MM-dd'_'HH.mm.ss");
  }

  protected void log(Exception e) {
    log(e.getMessage());
    e.printStackTrace();
  }

  void log(String sz) {
    if (getAppl() != null)
      getAppl().log(sz);
    System.out.println(sz);
  }

  @Override
  public boolean rinominaFile() {
    boolean bRet = false;
    // ripristino la modified-date alla data di scatto
    Date dtCrea;
    try {
      dtCrea = fmt.parse(newName);
      getOldName().setLastModified(dtCrea.getTime());
    } catch (ParseException e) {
      log(e);
    }
    // se ha gia lo stesso nome ? allora esco
    if (getOldName().getAbsolutePath().toLowerCase().endsWith(newName.toLowerCase() + "." + getFileExt()))
      return bRet;

    String szNewName = FIL_PREFIX + newName + "." + getFileExt();
    int k = 1;
    while ( !bRet) {
      String szDirBase = getOldName().getAbsolutePath();
      szDirBase = szDirBase.substring(0, szDirBase.lastIndexOf("\\"));
      bRet = getOldName().renameTo(new File(szDirBase + "\\" + szNewName));
      if ( !bRet)
        szNewName = FIL_PREFIX + newName + "_" + String.valueOf(k++) + ".jpg";
    }
    System.out.println("ren \"" + getOldName() + "\" " + szNewName);
    return bRet;
  }

  @Override
  public String getNewName() {
    return newName;
  }

  @Override
  public File getOldName() {
    return fileOld;
  }

  @Override
  public String getOldShortName() {
    return fileOld.getName();
  }

  @Override
  public void setOldName(File p_oldName) {
    fileOld = p_oldName;
  }

  public File getFilePath() {
    return fileOld;
  }

  public void setFilePath(File path) {
    fileOld = path;
  }

  public MainAppl getAppl() {
    return appl;
  }

  public void setAppl(MainAppl appl) {
    this.appl = appl;
  }

  public Date parseDate(String p_sz) {
    Date dtRet = null;
    try {
      dtRet = fmt.parse(p_sz);
    } catch (ParseException e) {
      // e.printStackTrace();
    }
    try {
      if (dtRet == null)
        dtRet = fmtZulu.parse(p_sz);
    } catch (ParseException e) {
      // e.printStackTrace();
    }
    try {
      if (dtRet == null)
        dtRet = fmtZulu2.parse(p_sz);
    } catch (ParseException e) {
      // e.printStackTrace();
    }
    return dtRet;
  }

  public void setDtScatto(Date dt) {
    dtScatto = dt;
    if (dt != null)
      creaNewFileName(dt);
  }

  private void creaNewFileName(Date dt) {
    newName = fmt.format(dt);
  }

  public abstract String getFileExt();

}
