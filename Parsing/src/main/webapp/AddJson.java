package main.webapp;

import org.json.simple.JSONObject;
import org.jsoup.nodes.Element;

public class AddJson {
	
	public void addJsonInfo(Element infoAir, Element nameAir) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "nameAir");
		jsonObject.put("info", "infoAir");

		System.out.println("Json : " + jsonObject.toString());
	}

}
