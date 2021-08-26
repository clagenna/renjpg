package boh;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.junit.Test;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import sm.clagenna.renjpg.ResizeImage;



public class ProvaRidimensiona {

  private Metadata m_mtdt;

  @Test
  public void testa() {
    String[] arr = { "D:/my foto/2010/2010-05-28 Tour Croazia/f20100529_105618.jpg",
        "D:/My Foto/2010/2010-12-27 Trofeo Anderlini/f20101228_075947.jpg", //
        "D:/My Foto/2010/2010-12-27 Trofeo Anderlini/f20101228_113403.jpg" //
    };
    for (String sz : arr) {
      ResizeImage res = new ResizeImage();
      res.setNewSizeX(1280);
      res.setOrigFile(sz);
      res.ridimensiona();
      leggiMetadata(sz);
    }
  }

  private void leggiMetadata(String sz) {
    try {
      File fi = new File(sz);
      m_mtdt = JpegMetadataReader.readMetadata(fi);
      String szNome = null;
      Iterator<Directory> directories = m_mtdt.getDirectories().iterator();
      while (directories.hasNext()) {
        Directory directory = directories.next();
        // iterate through tags and print to System.out
        Iterator<Tag> tags = directory.getTags().iterator();
        try {
          while (tags.hasNext()) {
            Tag tag = tags.next();
            System.out.println("Tag:" + tag.toString());
            switch (tag.getTagType()) {
              case 0x9003:
              case 0x132:
                // Date/Time Original:0x9003][2006:06:22 13:59:45][Exif]
                String ar[] = tag.getDescription().trim().split(":");
                if (ar.length != 5 || ar[0].equals("0000"))
                  szNome = "";
                else
                  szNome = ar[0] + ar[1] + ar[2].replace(" ", "_") + ar[3] + ar[4];
                System.out.println("Tag:" + tag.toString() + " nome=" + szNome);
                break;
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

    } catch (JpegProcessingException e) {
      e.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }

  }
}
