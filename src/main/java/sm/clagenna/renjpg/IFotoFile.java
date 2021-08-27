package sm.clagenna.renjpg;

import java.io.File;

public interface IFotoFile {
  boolean rinominaFile();

  String getOldShortName();

  String getNewName();

  File getOldName();

  void setOldName(File p_nam);
}
