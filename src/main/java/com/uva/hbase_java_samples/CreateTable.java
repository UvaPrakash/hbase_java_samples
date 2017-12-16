package com.uva.hbase_java_samples;

/**
 * @author Uva Prakash P
 * Dec 11, 2017
 */

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class CreateTable 
{
	   public static void main(String[] args) throws IOException {
		   System.out.println("Initializing HBase Create Table");
		   
	      // Instantiating configuration class
		  Configuration con = HBaseConfiguration.create();
		  Connection connection = null;
		  connection = ConnectionFactory.createConnection(con);

	      // Instantiating HbaseAdmin class
	      HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();

	      // Instantiating table descriptor class
	      HTableDescriptor tableDescriptor = new
	      HTableDescriptor(TableName.valueOf("employee"));

	      // Adding column families to table descriptor
	      tableDescriptor.addFamily(new HColumnDescriptor("personal"));
	      tableDescriptor.addFamily(new HColumnDescriptor("professional"));

	      // Execute the table through admin
	      admin.createTable(tableDescriptor);
	      System.out.println("Table: employee created");
	   }
}
