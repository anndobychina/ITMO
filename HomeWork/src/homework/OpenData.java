package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.*;
import com.opencsv.CSVReader;

public class OpenData extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		URL url = new URL("http://localhost:8888/reestr.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		CSVReader csv = new CSVReader(reader);
		List<String[]> rows = csv.readAll();
		rows.remove(0);
		ArrayList<Entry> entries = new ArrayList<Entry>();
		for (String[] row : rows) {
			Entry entry = new Entry();
			entry.index = Integer.parseInt(row[0]);
			entry.name = row[3];
			entry.adress = row[7];
			entry.totalplaces = Integer.parseInt(row[17]);

			entries.add(entry);
		}
		csv.close();
		reader.close();
		int i;
		int[] listOfNumbers = new int[entries.size()];
		for (i = 0; i < entries.size(); i++) {
			listOfNumbers[i] = entries.get(i).totalplaces;
		}
		Arrays.sort(listOfNumbers);
		ArrayList<Entry> sortedEntries = new ArrayList<Entry>();
		for (int n : listOfNumbers) {
			for (i = 0; i < entries.size(); i++) {
				if (entries.get(i).totalplaces == n) {
					sortedEntries.add(entries.get(i));
					entries.remove(i);
					break;
				}
			}
		}
		resp.getWriter().println(
				"<table border=\"1\"><tr><td>№</td><td>Сокращенное наименование юридического лица, в том числе фирменное наименование</td><td>Место расположения объекта</td><td>Общее количество торговых мест</td></tr>");
		for (Entry entry : sortedEntries) {
			resp.getWriter().println("<tr><td>" + entry.index + "</td><td>" + entry.name + "</td><td>" + entry.adress
					+ "</td><td>" + entry.totalplaces + "</td></tr>");
		}
		resp.getWriter().println("</table>");

	}
}
