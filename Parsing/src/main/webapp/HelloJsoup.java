package main.webapp;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * ����� ������ ���� www.utair.ru
 *
 */
public class HelloJsoup {
	/**
	 * ����� ������ �������� https://www.utair.ru/about/aircrafts/
	 * 
	 */

	public static void main(String[] args) throws IOException {

		parseUrl();

	}

	public static void parseUrl() throws IOException {
		Document doc = Jsoup.connect("https://www.utair.ru/about/aircrafts/").get();
		String title = doc.title();
		AddJson addJson = new AddJson();

		for (int i = 0; i < 7; i++) {

			Element infoAir = doc.select("div.airship-block-info").get(i);

			Element nameAir = doc.select("div.airship-block-title").get(i);

			System.out.println("�������� �������� : " + nameAir);

			System.out.println("���������� � �������� : " + infoAir);

			addJson.addJsonInfo(infoAir, nameAir);
		}

	}

}
