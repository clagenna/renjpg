package sm.clagenna.renjpg;

import java.util.Calendar;
import java.util.Date;

public class DeltaData {

  int sg, gg, hh, mm, ss;

  public DeltaData() {

  }
//
//  @Test
//  public void provaDelta() {
//    String sz = "-0g 23h 4m 5s";
//    parseDelta(sz);
//    Calendar cal = Calendar.getInstance();
//    Date dt = new Date();
//    cal.setTime(dt);
//    SimpleDateFormat fmt = new SimpleDateFormat();
//    System.out.println(fmt.format(dt));
//    dt = spostaData(dt);
//    System.out.println(fmt.format(dt));
//    System.out.println(toString());
//  }

  public void parseDelta(String p_sz) {
    sg = 1;
    String[] arr = p_sz.split(" ");
    for (String sz : arr) {
      parse(sz);
    }
  }

  public Date spostaData(Date p_dt) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(p_dt);
    cal.add(Calendar.DAY_OF_MONTH, gg*sg);
    cal.add(Calendar.HOUR, hh*sg);
    cal.add(Calendar.MINUTE, mm*sg);
    cal.add(Calendar.SECOND, ss*sg);
    return cal.getTime();
  }

  private void parse(String p_sz) {
    String ls = p_sz;
    if (p_sz.startsWith("-")) {
      sg = -1;
      ls = p_sz.substring(1);
    }
    if (p_sz.startsWith("+")) {
      sg = 1;
      ls = p_sz.substring(1);
    }
    char cc = ls.charAt(ls.length() - 1);
    ls = ls.substring(0, ls.length() - 1);
    switch (cc) {
      case 'g':
        gg = Integer.valueOf(ls).intValue();
        break;
      case 'h':
        hh = Integer.valueOf(ls).intValue();
        break;
      case 'm':
        mm = Integer.valueOf(ls).intValue();
        break;
      case 's':
        ss = Integer.valueOf(ls).intValue();
        break;
      default:
        System.out.println("Err: " + p_sz);
        break;
    }
  }

  @Override
  public String toString() {
    String sz = String.format("%d %dg %dh %dm %ds", Integer.valueOf(sg), Integer.valueOf(gg), Integer.valueOf(hh), Integer.valueOf(mm), Integer.valueOf(ss));
    return sz;
  }
}
