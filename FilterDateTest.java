import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FilterDateTest {

	public static void main(String[] args) throws ParseException {
		
		final Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		String formattedToday = DateConverter.convertDateToString(today);

		Date convertedTodayDate = DateConverter.convertStringToDate(formattedToday);
		cal.add(Calendar.DATE, -1);
		Date yesterday = cal.getTime();
		
		String formattedYesterday = DateConverter.convertDateToString(yesterday);

		Date convertedYesterdayDate = DateConverter.convertStringToDate(formattedYesterday);
		
		List<Record> mainList = getRecords();
		
		List<Record> newList = new ArrayList<>();
		
		for (Record each : mainList) {
			if (!(new SimpleDateFormat("yyyy-MM-dd").parse(each.getStartDtae()).before(convertedYesterdayDate))
					&& !(new SimpleDateFormat("yyyy-MM-dd").parse(each.getStartDtae()).after(convertedTodayDate))) {
				newList.add(each);
			}
		}
		System.out.println("mainList Size " + mainList.size());
		System.out.println("newList Size " + newList.size());

	}

	private static ArrayList<Record> getRecords() {
		ArrayList<Record> records = new ArrayList<>();
		records.add(new Record(1, "record1", "record1@email.com", "2019-06-19", new Date()));
		records.add(new Record(1, "record1", "record1@email.com", "2019-06-19", new Date()));

		records.add(new Record(1, "record1", "record11@email.com", "2019-06-19", new Date()));

		records.add(new Record(1, "record1", "record15@email.com", "2019-06-19", new Date()));

		records.add(new Record(2, "record2", "record2@email.com", "2019-06-18", new Date()));
		records.add(new Record(2, "record2", "record2@email.com", "2019-06-18", new Date()));
		records.add(new Record(2, "record2", "record2@email.com", "2019-06-18", new Date()));

		records.add(new Record(2, "record2", "record6@email.com", "2019-06-17", new Date()));

		records.add(new Record(2, "record2", "record7@email.com", "2019-06-16", new Date()));

		records.add(new Record(2, "record3", "record6@email.com", "2019-06-20", new Date()));
		records.add(new Record(2, "record3", "record6@email.com", "2019-06-20", new Date()));

		records.add(new Record(3, "record3", "record3@email.com", "2019-06-21", new Date()));
		records.add(new Record(3, "record3", "record3@email.com", "2019-06-21", new Date()));
		records.add(new Record(3, "record3", "record3@email.com", "2019-06-17", new Date()));
		records.add(new Record(3, "record3", "record3@email.com", "2019-06-19", new Date()));
		records.add(new Record(3, "record3", "record3@email.com", "2019-06-19", new Date()));

		records.add(new Record(4, "record4", "record15@email.com", "2019-06-18", new Date()));

		return records;
	}

}
