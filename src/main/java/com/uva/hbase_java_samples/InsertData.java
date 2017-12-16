package com.uva.hbase_java_samples;

/**
 * @author Uva Prakash P
 * Dec 16, 2017
 */

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class InsertData {
	public static void main(String[] args) throws IOException {
		System.out.println("Initializing HBase Insert Data");
		
		// Instantiating Configuration class
		Configuration con = HBaseConfiguration.create();
	    Connection connection = null;
    	connection = ConnectionFactory.createConnection(con);

		// Instantiating HTable class
		HTable hTable = (HTable) connection.getTable(TableName.valueOf("employee"));

		// Instantiating Put class
		// Mention row id
		Put p = new Put(Bytes.toBytes("row1")); 

		// Adding values using add() method
		// Accepts column family name, qualifier/row name ,value
		p.addColumn(Bytes.toBytes("personal"),
		Bytes.toBytes("name"),Bytes.toBytes("Uva"));

		p.addColumn(Bytes.toBytes("personal"),
		Bytes.toBytes("city"),Bytes.toBytes("Chennai"));

		p.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("designation"),
		Bytes.toBytes("Senior Developer"));

		p.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("salary"),
		Bytes.toBytes("50000"));
		      
		// Saving the put Instance to the HTable.
		hTable.put(p);
		System.out.println("Data Inserted");
		      
		// Closing HTable
		hTable.close();
	 }	
}
