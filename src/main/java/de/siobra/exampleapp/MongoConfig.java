package de.siobra.exampleapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration{
	 @Value("localhost") private String host;
	 @Value("27017") private int port;
	 @Value("exampleDB") private String databaseName;
	 @Value("${MONGOSOUP_URL:}") private String mongoURL;

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "cc_tuOTCqVNyVgS";
	}

	@Override
	public Mongo mongo() throws Exception {
		if(mongoURL != null && !mongoURL.isEmpty()){
			MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoURL));
			return mongoClient;
		}
	        return new MongoClient(host, port);
	}

}
