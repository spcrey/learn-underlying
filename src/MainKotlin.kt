import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

object MainKotlin {
    @JvmStatic
    fun main(args:Array<String>) {
        val dbFile = "D:\\Main Files\\Projects\\learn-underlying\\resource\\database.db"
        Class.forName("org.sqlite.JDBC")
        val connection: Connection = DriverManager.getConnection("jdbc:sqlite:$dbFile")
        val statement: Statement = connection.createStatement()
        val resultSet: ResultSet = statement.executeQuery(
            "SELECT * FROM Student"
        )
        while (resultSet.next()) {
            val name = resultSet.getString("name")
            println("name: $name")
        }
        resultSet.close()
        statement.close()
        connection.close()
    }
}

