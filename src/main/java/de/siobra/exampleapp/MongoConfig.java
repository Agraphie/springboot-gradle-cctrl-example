package de.siobra.exampleapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {
	private String host = "localhost";
	private int port = 27017;
	private String databaseName = "exampleDB";
	
	@Value("${MONGOSOUP_URL:}")
	private String mongoURL;
	private String ccDBName;

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		if (ccDBName != null) {
			return ccDBName;
		}
		return databaseName;
	}

	@Override
	public Mongo mongo() throws Exception {
		if (mongoURL != null && !mongoURL.isEmpty()) {
			//we need to find out the database name
			//unfortunately MongoSoup stores everything in one big string so we have to search for
			//our database name and extract it
			//adjust if needed! Database name has to be set!
			Matcher m = Pattern.compile("(cc_.*)").matcher(mongoURL);
			if (m.find())
				ccDBName = m.group(1);

			return new MongoClient(new MongoClientURI(mongoURL));
		}
		return new MongoClient(host, port);
	}

}
