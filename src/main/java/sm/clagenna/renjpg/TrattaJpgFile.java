package sm.clagenna.renjpg;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * Legge le informazioni EXIF e converte il nome del file con il valore della
 * data di scatto. Nelle informazioni EXIF
 * <table>
 * <tr>
 * <th style="width: 30px;">Section</th>
 * <th>Tag</th>
 * <th>Value</th>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Image Description</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Make</td>
 * <td>NIKON</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Model</td>
 * <td>COOLPIX P5000</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Orientation</td>
 * <td>Top, left side (Horizontal / normal)</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>X Resolution</td>
 * <td>300 dots per inch</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Y Resolution</td>
 * <td>300 dots per inch</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Resolution Unit</td>
 * <td>Inch</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Software</td>
 * <td>COOLPIX P5000V1.0</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Date/Time</td>
 * <td>2010:05:29 10:56:18</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Date/Time</td>
 * <td>2010:05:29 10:56:18 nome=20100529_105618</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>YCbCr Positioning</td>
 * <td>Datum point</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Exposure Time</td>
 * <td>1/700 sec</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>F-Number</td>
 * <td>F2,7</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Exposure Program</td>
 * <td>Program normal</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>ISO Speed Ratings</td>
 * <td>64</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Exif Version</td>
 * <td>2.20</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Date/Time Original</td>
 * <td>2010:05:29 10:56:18</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Date/Time Original</td>
 * <td>2010:05:29 10:56:18 nome=20100529_105618</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Date/Time Digitized</td>
 * <td>2010:05:29 10:56:18</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Components Configuration</td>
 * <td>YCbCr</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Compressed Bits Per Pixel</td>
 * <td>4 bits/pixel</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Exposure Bias Value</td>
 * <td>0 EV</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Max Aperture Value</td>
 * <td>F2,7</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Metering Mode</td>
 * <td>Multi-segment</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Light Source</td>
 * <td>Unknown</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Flash</td>
 * <td>Flash did not fire, auto</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Focal Length</td>
 * <td>7,5 mm</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>User Comment</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>FlashPix Version</td>
 * <td>1.00</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Color Space</td>
 * <td>sRGB</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Exif Image Width</td>
 * <td>3648 pixels</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Exif Image Height</td>
 * <td>2432 pixels</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>File Source</td>
 * <td>Digital Still Camera (DSC)</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Scene Type</td>
 * <td>Directly photographed image</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Custom Rendered</td>
 * <td>Normal process</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Exposure Mode</td>
 * <td>Auto exposure</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>White Balance</td>
 * <td>Auto white balance</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Digital Zoom Ratio</td>
 * <td>Digital zoom not used.</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Focal Length 35</td>
 * <td>36mm</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Scene Capture Type</td>
 * <td>Standard</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Gain Control</td>
 * <td>None</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Contrast</td>
 * <td>None</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Saturation</td>
 * <td>None</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Sharpness</td>
 * <td>None</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Subject Distance Range</td>
 * <td>Unknown</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Compression</td>
 * <td>JPEG (old-style)</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Thumbnail Offset</td>
 * <td>4688 bytes</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Thumbnail Length</td>
 * <td>6257 bytes</td>
 * </tr>
 * <tr>
 * <td>Exif</td>
 * <td>Thumbnail Data</td>
 * <td>[6257 bytes of thumbnail data]</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Firmware Version</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>ISO</td>
 * <td>Unknown (0 0)</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Color Mode</td>
 * <td>COLOR</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Quality & File Format</td>
 * <td>FINE</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>White Balance</td>
 * <td>AUTO</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Sharpening</td>
 * <td>AUTO</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>AF Type</td>
 * <td>AF-S</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Flash Sync Mode</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x000a)</td>
 * <td>2822/500</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>ISO Selection</td>
 * <td>AUTO</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Data Dump</td>
 * <td>5 2 0 0 0 0 0 0 0 0 0 1 .....</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown 03</td>
 * <td>3310</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x001a)</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Image Adjustment</td>
 * <td>AUTO</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Tone Compensation</td>
 * <td>AUTO</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Adapter</td>
 * <td>OFF</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Manual Focus Distance</td>
 * <td>0</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Digital Zoom</td>
 * <td>No digital zoom</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>AF Focus Position</td>
 * <td>Centre</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x008f)</td>
 * <td>ANTI-SHAKE</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown 11</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x0094)</td>
 * <td>0</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Noise Reduction</td>
 * <td>OFF</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x009b)</td>
 * <td>0 0</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x009c)</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x009d)</td>
 * <td>0</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x009e)</td>
 * <td>0 0 0 0 0 0</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown 32</td>
 * <td>48 49 48 48 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown 33</td>
 * <td>NORMAL</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown 29</td>
 * <td>NORMAL</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x00ac)</td>
 * <td>VR-ON</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x00ad)</td>
 * <td>STANDARD</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x00ae)</td>
 * <td>0 0 2 0 0 0 0 0 0 0 0 0</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x00b2)</td>
 * <td>????????</td>
 * </tr>
 * <tr>
 * <td>Nikon Makernote</td>
 * <td>Unknown tag (0x00b3)</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>Interoperability</td>
 * <td>Interoperability Index</td>
 * <td>Recommended Exif Interoperability Rules (ExifR98)</td>
 * </tr>
 * <tr>
 * <td>Interoperability</td>
 * <td>Interoperability Version</td>
 * <td>1.00</td>
 * </tr>
 * <tr>
 * <td>GPS</td>
 * <td>GPS Version ID</td>
 * <td>2 2 0 0</td>
 * </tr>
 * <tr>
 * <td>GPS</td>
 * <td>GPS Latitude Ref</td>
 * <td>N</td>
 * </tr>
 * <tr>
 * <td>GPS</td>
 * <td>GPS Latitude</td>
 * <td>43"20'13.175448</td>
 * </tr>
 * <tr>
 * <td>GPS</td>
 * <td>GPS Longitude Ref</td>
 * <td>E</td>
 * </tr>
 * <tr>
 * <td>GPS</td>
 * <td>GPS Longitude</td>
 * <td>17"48'51.68837</td>
 * </tr>
 * <tr>
 * <td>GPS</td>
 * <td>GPS Time-Stamp</td>
 * <td>10:56:18 UTC</td>
 * </tr>
 * <tr>
 * <td>GPS</td>
 * <td>GPS Map Datum</td>
 * <td>WGS-84</td>
 * </tr>
 * <tr>
 * <td>GPS</td>
 * <td>Unknown tag (0x001d)</td>
 * <td>2010:05:29</td>
 * </tr>
 * <tr>
 * <td>Jpeg</td>
 * <td>Data Precision</td>
 * <td>8 bits</td>
 * </tr>
 * <tr>
 * <td>Jpeg</td>
 * <td>Image Height</td>
 * <td>2432 pixels</td>
 * </tr>
 * <tr>
 * <td>Jpeg</td>
 * <td>Image Width</td>
 * <td>3648 pixels</td>
 * </tr>
 * <tr>
 * <td>Jpeg</td>
 * <td>Number of Components</td>
 * <td>3</td>
 * </tr>
 * <tr>
 * <td>Jpeg</td>
 * <td>Component 1</td>
 * <td>Y component: Quantization table 0, Sampling factors 1 horiz/2 vert</td>
 * </tr>
 * <tr>
 * <td>Jpeg</td>
 * <td>Component 2</td>
 * <td>Cb component: Quantization table 1, Sampling factors 1 horiz/1 vert</td>
 * </tr>
 * <tr>
 * <td>Jpeg</td>
 * <td>Component 3</td>
 * <td>Cr component: Quantization table 1, Sampling factors 1 horiz/1 vert</td>
 * </tr>
 * </table>
 *
 * @author claudio
 *
 */
public class TrattaJpgFile extends TrattaFotoFile implements IFotoFile {

  private static final String CSZ_EXTENTION = "jpg";
  Metadata                    m_mtdt;

  public TrattaJpgFile(MainAppl app) {
    super(app);
  }

  public void setNewName(String p_newName) {
    newName = p_newName;
  }

  @Override
  public String getNewName() {
    String szRet = super.getNewName();
    try {
      if (szRet == null) {
        if (readFileJpeg())
          szRet = super.getNewName();
      }
    } catch (JpegProcessingException | IOException e) {
      getAppl().log(e.getMessage());
    }
    return szRet;
  }

  public boolean readFileJpeg() throws JpegProcessingException, IOException {
    boolean bRet = false;
    String oldName = getOldShortName();
    String szFilNam = oldName.toLowerCase();
    if ( !bRet)
      bRet = szFilNam.endsWith(".jpg");
    if ( !bRet)
      bRet = szFilNam.endsWith(".jpeg");
    if ( !bRet)
      bRet = szFilNam.endsWith(".png");

    if ( !bRet)
      return bRet;

    // trovo il nome in base alla data di scatto foto
    try {
      m_mtdt = JpegMetadataReader.readMetadata(getOldName());
      newName = formattaNomeInData();
      if (newName != null && newName.length() > 9) {
        Date dt = fmt.parse(newName);
        dt = getAppl().getDelta().spostaData(dt);
        newName = fmt.format(dt);
      } else {
        Date dt = testPatternsFileName(getOldName());
        if (dt != null)
          newName = fmt.format(dt);
      }
    } catch (ParseException ex) {
      log(ex);
      // ex.printStackTrace();
    } catch (IOException ex) {
      log(ex);
      // ex.printStackTrace();
    }
    bRet = newName.length() > 6;
    return bRet;
  }

  protected String formattaNomeInData() {
    String szNome = "";
    for (Directory directory : m_mtdt.getDirectories()) {
      try {
        for (Tag tag : directory.getTags()) {
          switch (tag.getTagTypeHex()) {
            case "0x9003": {
              // Date/Time Original:0x9003][2006:06:22 13:59:45][Exif]
              String ar[] = tag.getDescription().trim().split(":");
              if (ar.length != 5 || ar[0].equals("0000"))
                szNome = "";
              else {
                szNome = ar[0] + ar[1] + ar[2].replace(" ", "_") + ar[3] + ar[4];
                break;
              }
            }
            case "0x0003": {
              Date dt = directory.getDate(tag.getTagType());
              if (dt != null) {
                szNome = fmt.format(dt);
                break;
              }
            }
          }
        }
      } catch (Exception e) {
        log(e);
      }
    }
    return szNome;
  }

  public boolean ridimensiona(float fDim) {
    boolean bRet = false;

    return bRet;
  }

  @Override
  public String getFileExt() {
    return CSZ_EXTENTION;
  }
}
