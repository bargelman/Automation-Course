package lesson04.ObjectOrientedPrograming02.HomeExercises.ecercise08;

import java.sql.Timestamp;
import java.util.Date;

public class Client {
//        Gives the current time and date
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

}
//       Option 2:
//       Date date = new Date();
//       System.out.println(new Timestamp(date.getTime()));

//       Option 3:
//       Date date = new Date();
//       Timestamp timeStamp = new Timestamp(date.getTime());


//        Output : 2021-12-22 09:10:03.884