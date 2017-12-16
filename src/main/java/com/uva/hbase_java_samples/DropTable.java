package com.uva.hbase_java_samples;

/**
 * @author Uva Prakash P
 * Dec 16, 2017
 */

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class DropTable {
   public static void main(String[] args) throws IOException {
	   System.out.println("Initializing HBase Drop Table");

	   // Instantiating configuration class
	   Configuration con = HBaseConfiguration.create();
	   Connection connection = null;
   	   connection = ConnectionFactory.createConnection(con);

       // Instantiating HBaseAdmin class
   	   HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
   	   
   	   // Check if table exists
       Boolean bool = admin.tableExists("employee");
       System.out.println("Checking whether the table employee exists: "+ bool);
       
       if(bool){
           // Disabling table named employee
           admin.disableTable("employee");
           
           // Deleting employee table
           admin.deleteTable("employee");
           System.out.println("Table employee deleted");
       }
   }
}