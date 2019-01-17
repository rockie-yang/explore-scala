package jdbc

import java.sql.{Connection, DriverManager, ResultSet}

// Oracle is always tricky to handle for proprietary reason
// We can not just simply using maven dependency!!!
//
// Steps 1: run a docker container to have simulation environment
//
//      docker run -d -p 8080:8080 -p 1521:1521 --name oracle sath89/oracle-12c
//
// Step 2: Copy driver jar files from container
//
//      docker cp oracle:/u01/app/oracle-product/12.1.0/xe/jdbc/lib ~/git/explore-scala/lib/
//
// Step 3: Modify pom file
//
//          <dependency>
//              <groupId>com.oracle</groupId>
//              <artifactId>ojdbc</artifactId>
//              <version>14</version>
//              <scope>system</scope>
//              <systemPath>${basedir}/lib/ojdbc6.jar</systemPath>
//          </dependency>
//
//
object Oracle {
  def main(args: Array[String]): Unit = {
      var connection: Connection = null
      try {
        // make the connection
        //step1 load the driver class
        val driver = Class.forName("oracle.jdbc.driver.OracleDriver")

        //step2 create  the connection object
        connection = DriverManager.getConnection(
          "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
//        jdbc:oracle:thin:@10.0.11.44:1521:xe

        // create the statement, and run the select query
        val statement = connection.createStatement()

        statement.execute("create table test(id number(10) not null, name varchar2(50) not null)")
        statement.execute("insert into test(id, name) values(1, 'rockie')")
        statement.execute("insert into test(id, name) values(2, 'yang')")

        connection.commit()

        val resultSet: ResultSet = statement.executeQuery("SELECT id, name from test")
        while ( resultSet.next() ) {
          val id = resultSet.getString("id")
          val name = resultSet.getString("name")
          println(s"id = $id, name = $name")
        }

        statement.execute("drop table test")
      } catch {
        case e => e.printStackTrace
      } finally {
        connection.close()
      }


  }
}
