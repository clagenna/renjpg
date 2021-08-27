package boh.nef;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class ProvaNef {

  private static final String[] arrNef      = { "dati/DSC_8861.NEF", "dati/DSC_8905.NEF" };
  @SuppressWarnings("unused")
  private static final String   CSZ_NITYPE  = "xmp:CreatorTool";
  private static final String   CSZ_CREDATE = "xmp:CreateDate";

  @Test
  public void provalo() {
    File fi = new File(arrNef[0]);
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
        System.out.println("Creation Date:" + szDt);
      } else {
        System.out.println("non trovo " + CSZ_CREDATE);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
