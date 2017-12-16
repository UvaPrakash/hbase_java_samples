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
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.util.Bytes;

public class DeleteData {

   public static void main(String[] args) throws IOException {
	  System.out.println("Initializing HBase Delete Data");

	  // Instantiating Configuration class
	  Configuration con = HBaseConfiguration.create();
	  Connection connection = null;
	  connection = ConnectionFactory.createConnection(con);

      // Instantiating HTable class
	  HTable hTable = (HTable) connection.getTable(TableName.valueOf("employee"));

      // Instantiating Delete class
      Delete delete = new Delete(Bytes.toBytes("row1"));
      delete.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("name"));
      delete.addFamily(Bytes.toBytes("professional"));

      // deleting the data
      hTable.delete(delete);

      // closing the HTable object
      hTable.close();
      System.out.println("Data Deleted");
   }
}