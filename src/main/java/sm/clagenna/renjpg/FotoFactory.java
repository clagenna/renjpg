package sm.clagenna.renjpg;

import java.io.File;

public class FotoFactory {
  private MainAppl m_main;

  public FotoFactory(MainAppl mainAppl) {
    m_main = mainAppl;
  }

  public IFotoFile get(File p_fi) {
    IFotoFile fiRet = null;
    String szExt = p_fi.getName();
    if (szExt == null)
      return fiRet;
    int k = szExt.lastIndexOf(".");
    if (k < 1)
      return fiRet;
    String sz = szExt.substring(k + 1);
    if (sz == null || sz.length() < 3)
      return fiRet;
    sz = sz.trim().toLowerCase();
    switch (sz) {
      case "jpg":
      case "jpeg":
      case "png":
        fiRet = new TrattaJpgFile(m_main);
        break;
      case "nef":
      case "cr2":
        fiRet = new TrattaNefFiles(m_main);
        break;
      default:
        System.out.println("Non tratto file:" + p_fi.getName());
    }
    return fiRet;
  }

}
