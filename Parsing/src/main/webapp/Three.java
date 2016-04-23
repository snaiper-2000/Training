package main.webapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

/**
 * Класс для парсинга сайта www.utair.ru
 *
 */
public class Three {
	/**
	 * метод main (запуск программы)
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		gsoupConnect();
	}
    /**
     * метод получается страницу для парсинга 
     * -печатает названия самолетов
     * -передает информацию а самолетах в метод parseInfo
     * @throws IOException
     */
	private static void gsoupConnect() throws IOException {
		//получаем страницу для парсинга
		Document conno = Jsoup.connect("https://www.utair.ru/about/aircrafts/").get();
        
		//поиск элемента, который имеет этот класс
		Elements airships = conno.getElementsByClass("airship-block");
		
		//перебмраем элементы airship-block и присвайваем element
		for (Element element : airships) {
            
			//печатаем название и модель самолета
			System.out.println(element.getElementsByClass("airship-block-title").get(0).text());
			
			//передаем основную информацию о самолете в метод parseInfo
			parseInfo(element.getElementsByClass("airship-block-info").get(0));
		}

	}
    /**
     * метод выводит основную информацию о самолете
     * @param element
     */
	private static void parseInfo(Element element) {
		
		//Находит элементы, в том числе и рекурсивно под этот элемент с указанным именем тега
		//выводит информацию хранящуюся в теге <p>
		Elements arrayP = element.getElementsByTag("p");
		
		//перебираем элементы тега <p> и выводит их содержимое
		for (Element element1 : arrayP) {
			System.out.println(element1.text());
		}
		System.out.println();
		System.out.println();
	}
}
