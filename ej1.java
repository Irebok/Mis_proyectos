import java.io.*;
import java.sql.*;
//ejercicio 1
public class Main {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/practica2?useSSL=false";

    static final String USER = "marcos";
    static final String PASS = "1234";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sqldata = "use misPeliculas";
            int ok = stmt.executeUpdate(sqldata);

            System.out.println("Query OK, "+ok+" row afected ");

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String cadena = "", table, id, foto;

            while (!cadena.equalsIgnoreCase("3")) {
                System.out.println("\n¿Quiere almacenar o recuperar una imagen?\n 1.- Almacenar 2.- Recuperar 3.- Salir\n");
                cadena = br.readLine();
                switch (Integer.parseInt(cadena)) {
                    case 1:
                        System.out.println("\nAlmacenar en... (Actores/Directores)\n");
                        table = cadena = br.readLine();
                        System.out.println("\n...con id_actor/id_director = ...\n");
                        id = cadena = br.readLine();
                        System.out.println("\n¿Nombre del archivo? (nombre.jpg)\n");
                        foto = cadena = br.readLine();
                        AlmacenarFoto(conn, table, id, foto);
                        break;
                    case 2:
                        System.out.println("\nrecuperar de... (Actores/Directores)\n");
                        table = cadena = br.readLine();
                        System.out.println("\n...con id_actor/id_director = ...\n");
                        id = cadena = br.readLine();
                        System.out.println("\n¿Nombre que desea ponerle al archivo? (nombre.jpg)\n");
                        foto = cadena = br.readLine();
                        RecuperarImagen(stmt, table, id, foto);
                        break;
                    case 3: break;
                }
            }

            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Bye!");
    }

    private static void RecuperarImagen(Statement stmt, String table, String id, String foto) throws IOException, SQLException {

        ResultSet rs = stmt.executeQuery("select foto from "+table+" where id_actor = "+id);

        int i = 1;
        while (rs.next()) {
            InputStream in = rs.getBinaryStream(1);
            OutputStream f = new FileOutputStream(new File(foto));
            i++;
            int c = 0;
            while ((c = in.read()) > -1) {
                f.write(c);
            }
            System.out.println("Foto recuperada!");
            f.close();
            in.close();
        }
    }

    private static void AlmacenarFoto(Connection conn, String table, String id, String foto) throws IOException, SQLException {
        String SQL = "UPDATE "+table+" set foto = (?) where id_actor = "+id;
        File file = new File(foto);
        FileInputStream is = new FileInputStream(file);
        PreparedStatement pst = conn.prepareStatement(SQL);
        pst.setBinaryStream(1, is, (int) file.length());
        int ok = pst.executeUpdate();
        System.out.println("Query OK, "+ok+" row afected ");
        is.close();
        pst.close();
    }
}


