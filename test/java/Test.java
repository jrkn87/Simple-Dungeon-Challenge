import pl.duhc.simpledungeonchellange.database.QueryExecute;

public class Test {
    public static void main(String[] args) {
        QueryExecute queryExecute = new QueryExecute("select * from hero");
        queryExecute.execute();
    }
}
