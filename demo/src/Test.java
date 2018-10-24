import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by staLker on 21-08-2018.
 */
public class Test {
    public static void main(String[] args) {
        NavalMgmtDAO navalMgmtDAO = new NavalMgmtDAO();

//        NavalOfficer navalOfficer1 = new NavalOfficer();
//        navalOfficer1.setOfficerNo(3);
//        navalOfficer1.setOfficerName("Jeba");
//        navalOfficer1.setOfficerRank("Pro");
//        navalOfficer1.setOfficerSal(100000000.0);
//        navalOfficer1.setBaseCampID(103);
//
//        NavalOfficer navalOfficer2 = new NavalOfficer();
//        navalOfficer2.setOfficerNo(2);
//        navalOfficer2.setOfficerName("Rastogi");
//        navalOfficer2.setOfficerRank("Pro");
//        navalOfficer2.setOfficerSal(10000000.0);
//        navalOfficer2.setBaseCampID(102);

//        BaseCamp baseCamp1 = new BaseCamp();
//        baseCamp1.setBaseCampId(101);
//        baseCamp1.setBaseCampName("Toofani");
//        baseCamp1.setBaseCampLoc("Chennai");
//
//        System.out.println(navalMgmtDAO.addBaseCamp(baseCamp1));

//          System.out.println(navalMgmtDAO.addNavalOfficer(navalOfficer1));
//        System.out.println(navalMgmtDAO.addNavalOfficer(navalOfficer2));

        ArrayList<String> officersSorted = new ArrayList<String>();
        officersSorted = navalMgmtDAO.getOfficersNameSortedBySal();
        for(String pointer:officersSorted){
            System.out.println(pointer);
        }
    }
}
