package com.uva.hbase_java_samples;

/**
 * @author Uva Prakash P
 * Dec 16, 2017
 */

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class AddDeleteColumnFamily {
	public static void main(String[] args) throws MasterNotRunningException, IOException {
	  System.out.println("Initializing HBase Add/Delete Column Family");
		   
      // Instantiating configuration class
	  Configuration con = HBaseConfiguration.create();
	  Connection connection = null;
	  connection = ConnectionFactory.createConnection(con);

	  // Instantiating HbaseAdmin class
	  HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
	  
      // Adding column families
      admin.addColumn("employee", new HColumnDescriptor("employeename"));
      admin.addColumn("employee", new HColumnDescriptor("contactdetails"));
      System.out.println("Column Added");
      
      // Deleting a column family
      admin.deleteColumn("employee","professional");
      System.out.println("Column Deleted"); 
   }	
}