package sm.clagenna.renjpg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class TrattaNefFiles extends TrattaFotoFile implements IFotoFile {

  private static final String CSZ_CREDATE   = "xmp:CreateDate";
  private static final String CSZ_EXTENTION = "nef";

  public TrattaNefFiles(MainAppl p_main) {
    super(p_main);
  }

 
  @Override
  public String getNewName() {
    String szNew = super.getNewName();
    if (szNew == null) {
      readNEFFile();
      szNew = super.getNewName();
    }
    return szNew;
  }

  private void readNEFFile() {
    File fi = getOldName();
    try (FileInputStream fis = new FileInputStream(fi)) {
      byte[] data = new byte[2048];
      int ret = fis.read(data);
      if (ret == -1)
        throw new IOException("Nulla da leggere ....");
      String buff = new String(data);
      int k1 = buff.indexOf(CSZ_CREDATE + ">");
      int k2 = buff.indexOf("</" + CSZ_CREDATE);
      if (k1 > 0) {
        String szDt = buff.substring(k1 + CSZ_CREDATE.length() + 1, k2);
        Date dt = parseDate(szDt);
        if (dt != null)
          setDtScatto(dt);

      } else {
        System.out.println("non trovo " + CSZ_CREDATE);
      }
    } catch (IOException e) {
      getAppl().log("Err:" + fi.getName() + ":" + e.getMessage());
    }
  }

  @Override
  public String getFileExt() {
    return CSZ_EXTENTION;
  }

}
