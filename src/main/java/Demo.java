
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.di.ifin.zeus.admin.bont.pojo.LatnameToX;
import com.di.ifin.zeus.admin.bont.pojo.OntLat;
import com.di.ifin.zeus.admin.bont.pojo.Researcher;
import com.di.ifin.zeus.admin.bont.service.impl.LatServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.mongodb.Mongo;
import com.shu.global.Global;

import net.sf.json.JSONObject;

public class Demo {
	private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();

	public static void main(String[] args) {
		String jsonstr = "{\"ontname\":\"突发事件本体\",\"nodes\":[{\"latname\":\"动变\",\"x\":1000},{\"latname\":\"下降\",\"x\":400}]}";
		JSONObject json = JSONObject.fromObject(jsonstr);
		List<LatnameToX> list = gson.fromJson(json.getString("nodes"), new TypeToken<ArrayList<LatnameToX>>() {}.getType());
		for(LatnameToX ltx:list){
			System.out.println(ltx.getLatname()+ltx.getX());
		}
	}
}
