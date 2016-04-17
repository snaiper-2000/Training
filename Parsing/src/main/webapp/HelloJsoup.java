package main.webapp;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * класс парсит сайт www.utair.ru
 *
 */
public class HelloJsoup {
	/**
	 * Метод парсит страницу https://www.utair.ru/about/aircrafts/
	 * 
	 */

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://www.utair.ru/about/aircrafts/").get();
		String title = doc.title();
		// Elements el = doc.select("div[name=div.airship-block-info]");

		for (int i = 0; i < 7; i++) {

			Element infoAir = doc.select("div.airship-block-info").get(i);

			Element nameAir = doc.select("div.airship-block-title").get(i);

			System.out.println("Название самолета : " + nameAir);

			System.out.println("Информация о самолете : " + infoAir);

		}
	}

}
