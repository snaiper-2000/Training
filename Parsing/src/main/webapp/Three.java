package main.webapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

/**
 * ����� ��� �������� ����� www.utair.ru
 *
 */
public class Three {
	/**
	 * ����� main (������ ���������)
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		gsoupConnect();
	}
    /**
     * ����� ���������� �������� ��� �������� 
     * -�������� �������� ���������
     * -�������� ���������� � ��������� � ����� parseInfo
     * @throws IOException
     */
	private static void gsoupConnect() throws IOException {
		//�������� �������� ��� ��������
		Document conno = Jsoup.connect("https://www.utair.ru/about/aircrafts/").get();
        
		//����� ��������, ������� ����� ���� �����
		Elements airships = conno.getElementsByClass("airship-block");
		
		//���������� �������� airship-block � ����������� element
		for (Element element : airships) {
            
			//�������� �������� � ������ ��������
			System.out.println(element.getElementsByClass("airship-block-title").get(0).text());
			
			//�������� �������� ���������� � �������� � ����� parseInfo
			parseInfo(element.getElementsByClass("airship-block-info").get(0));
		}

	}
    /**
     * ����� ������� �������� ���������� � ��������
     * @param element
     */
	private static void parseInfo(Element element) {
		
		//������� ��������, � ��� ����� � ���������� ��� ���� ������� � ��������� ������ ����
		//������� ���������� ���������� � ���� <p>
		Elements arrayP = element.getElementsByTag("p");
		
		//���������� �������� ���� <p> � ������� �� ����������
		for (Element element1 : arrayP) {
			System.out.println(element1.text());
		}
		System.out.println();
		System.out.println();
	}
}
